package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements  SaleDao{

        private final JdbcTemplate jdbcTemplate;

        public JdbcSaleDao(DataSource dataSource){
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

    @Override
    public Sale getSale(int saleId) {
            Sale sale = null;
            String sql = "SELECT * FROM sale WHERE sale_id=?";
            SqlRowSet results= jdbcTemplate.queryForRowSet(sql,saleId);
            if(results.next()){
                sale=mapRowToSale(results);
            }

        return sale;
    }


    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
            List<Sale> listOfSales = new ArrayList<>();

        String sql = "SELECT s.sale_id, c.customer_id, s.sale_date, s.ship_date, c.name AS customer_name FROM sale s " +
                "JOIN customer c on s.customer_id = c.customer_id WHERE s.customer_id = ? ORDER BY sale_id;";
            SqlRowSet results= jdbcTemplate.queryForRowSet(sql,customerId);
            while (results.next()){
               Sale sale=mapRowToSale(results);
                listOfSales.add(sale);
            }
        return listOfSales;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        List<Sale> listOfSalesByProduct = new ArrayList<>();
        Sale sale = null;
        String sql = "SELECT sale.sale_id, customer_id, sale_date, ship_date FROM sale JOIN line_item on line_item.sale_id= sale.sale_id WHERE product_id =?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,productId);
        while (results.next()){
            sale=mapRowToSale(results);
            listOfSalesByProduct.add(sale);
        }
        return listOfSalesByProduct;
    }

    @Override
    public Sale createSale(Sale newSale){
            String sql = "INSERT sale (sale_id, customer_id, sale_date, ship_date) VALUES (?,?,?,?) RETURNING sale_id";
            Integer newId = jdbcTemplate.queryForObject(sql, int.class, newSale.getSaleId(),newSale.getCustomerId(),
                    newSale.getSaleDate(),newSale.getShipDate());
   return getSale(newId);
        }

    @Override
    public void deleteSale(int saleId) {
        String sql = "DELETE FROM line_item WHERE sale_id=? DELETE FROM sale WHERE sale_id=?";
        jdbcTemplate.update(sql,saleId);
    }

    @Override
    public List<Sale> getSalesUnshipped() {
        return null;
    }

    @Override
    public void updateSale(Sale updatedSale) {

    }


    private Sale mapRowToSale(SqlRowSet result){
            Sale sale = new Sale();
            sale.setCustomerId(result.getInt("customer_id"));
            sale.setSaleId(result.getInt("sale_id"));
            sale.setSaleDate(result.getDate("sale_date").toLocalDate());
            if(result.getDate("ship_date") != null){
                sale.setShipDate(result.getDate("ship_date").toLocalDate());
            }

            return sale;
    }
}
