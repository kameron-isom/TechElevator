package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcCustomerDao(DataSource dataSource){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Customer getCustomer(int customerId) {
        Customer customer = new Customer();
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql, customerId);
        if(results.next()){
            customer= mapRowToCustomer(results);
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> listOfCustomers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Customer customer= new Customer();
            customer=mapRowToCustomer(results);
            listOfCustomers.add(customer);
        }
        return listOfCustomers;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        String sql = "INSERT INTO customer (customer_id, name, city, state, zip_code,street_address1,street_address2) VALUES(?,?,?,?,?,?,?) RETURNING customer_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newCustomer.getCustomerId(), newCustomer.getName(), newCustomer.getCity(), newCustomer.getState(), newCustomer.getZipCode(),newCustomer.getStreetAddress1(), newCustomer.getStreetAddress2());
        return getCustomer(newId);
    }

    @Override
    public void updateCustomer(Customer updatedCustomer) {
        String sql = "UPDATE customer SET name= ? WHERE customer_id =?";
        int updatedRows = jdbcTemplate.update(sql,  updatedCustomer.getName(),updatedCustomer.getCustomerId());

    }

    private Customer mapRowToCustomer(SqlRowSet result){
       Customer customer = new Customer();
       customer.setCustomerId(result.getInt("customer_id"));
       customer.setCity(result.getString("city"));
       customer.setName(result.getString("name"));
       customer.setState(result.getString("state"));
       customer.setStreetAddress1(result.getString("street_address1"));
       customer.setStreetAddress2(result.getString("street_address2"));
       customer.setZipCode(String.valueOf(result.getInt("zip_code")));
       return customer;
    }
}
