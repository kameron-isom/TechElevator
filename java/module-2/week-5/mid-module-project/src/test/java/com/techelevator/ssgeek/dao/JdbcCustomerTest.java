package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcCustomerTest extends  BaseDaoTests{
   private JdbcCustomerDao jdbcCustomerDao;

    @Before
public void setup(){
        jdbcCustomerDao =new JdbcCustomerDao(dataSource);
    }

    @Test
    public void getCustomer(){
        Customer customer = jdbcCustomerDao.getCustomer(1);
        Assert.assertEquals("Customer 1",customer.getName());
    }
    @Test
    public void getListOfCustomers(){
        List<Customer> customers =jdbcCustomerDao.getCustomers();
        Assert.assertEquals(4, customers.size());
    }
    @Test
    public void createCustomer(){

    Customer customer = new Customer(1,"Jeff","2102 Jeff","apt 304","New York", "NY","9009");
    Integer newId = customer.getCustomerId();

    Assert.assertEquals(customer,newId);
    }

    @Test
    public void updatedCustomer(){

            Customer customer = jdbcCustomerDao.getCustomer(1);
            Assert.assertNotNull("can't test updateCustomer until getCustomer is working", customer);
            customer.setName("Test");

            jdbcCustomerDao.updateCustomer(customer);

            Customer updatedCustomer = jdbcCustomerDao.getCustomer(1);
            Assert.assertEquals("updateCustomer failed to change customer name in database", "Test", updatedCustomer.getName());
        }

    }

