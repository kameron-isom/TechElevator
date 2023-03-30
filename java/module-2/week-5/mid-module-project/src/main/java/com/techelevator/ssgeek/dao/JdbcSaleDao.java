package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcSaleDao implements  SaleDao{

        private final JdbcTemplate jdbcTemplate;

        public JdbcSaleDao(DataSource dataSource){
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

   //list all sales orders for a customer
    //list all sales orders for a product
    //ship a sales order
    //cancel (remove) a sales order

    @Override
    public Sale getSale(int saleId) {
            Sale sale = null;
            String sql = "SELECT * FROM sale";
            SqlRowSet results= jdbcTemplate.queryForRowSet(sql,saleId);
            if(results.next()){
                sale=mapRowToSale(results);
            }

        return sale;
    }


    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
            List<Sale> listOfSales = new ArrayList<>();
            Sale sale = null;
            String sql = "SELECT * FROM sale WHERE customer_id=?";
            SqlRowSet results= jdbcTemplate.queryForRowSet(sql,customerId);
            while (results.next()){
                sale=mapRowToSale(results);
                listOfSales.add(sale);
            }
        return listOfSales;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        List<Sale> listOfSalesByProduct = new ArrayList<>();
        Sale sale = null;
        String sql = "SELECT * FROM sale WHERE product_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,productId);
        while (results.next()){
            sale=mapRowToSale(results);
            listOfSalesByProduct.add(sale);
        }
        return listOfSalesByProduct;
    }

    @Override
    public Sale createSale(Sale newSale){
            String sql = "INSERT sale (sale_id, customer_id, sale_date, shipping_date) VALUES (?,?,?,?) RETURNING sale_id";
            Integer newId = jdbcTemplate.queryForObject(sql, int.class, newSale.getSaleId(),newSale.getCustomerId(), newSale.getSaleDate(),newSale.getShipDate());
   return getSale(newId);
        }

    @Override
    public void deleteSale(int saleId) {
        String sql = "DELETE FROM sale WHERE sale_id=?";
        jdbcTemplate.update(sql,saleId);
    }

    private Sale mapRowToSale(SqlRowSet result){
            Sale sale = new Sale();
            sale.setCustomerId(result.getInt("customer_id"));
            sale.setCustomerName(result.getString("name"));
            sale.setSaleId(result.getInt("sale_id"));
            sale.setSaleDate(result.getDate("sale_date").toLocalDate());
            sale.setShipDate(result.getDate("shipping_date").toLocalDate());
            return sale;
    }
}
