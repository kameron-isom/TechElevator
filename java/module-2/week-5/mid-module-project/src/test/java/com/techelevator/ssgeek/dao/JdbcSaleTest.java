package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcSaleTest extends BaseDaoTests {
    private JdbcSaleDao jdbcSaleDao;

    @Before
    public void setup(){

        jdbcSaleDao= new JdbcSaleDao(dataSource);
    }

    @Test
    public void getSaleBySaleId(){
        Sale sale = jdbcSaleDao.getSale(1);
        Assert.assertEquals(1,sale.getSaleId());

    }

    @Test
    public void getSalesByCustomerIdGetsCustomerId(){
        List<Sale> sales = jdbcSaleDao.getSalesByCustomerId(1);


        List<Sale> sale = jdbcSaleDao.getSalesByCustomerId(99);
        //Assert.assertEquals("getSalesByCustomerId returned sales for  id not in customer database",
          //      0, sale.size());



        Assert.assertEquals(2,sales.size());
    }

    @Test
    public void getSalesByProductIdGetsProductId(){
        List<Sale> sales = jdbcSaleDao.getSalesByProductId(1);


        List<Sale> sale = jdbcSaleDao.getSalesByProductId(99);
        Assert.assertEquals("getSalesByCustomerId returned sales for  id not in customer database",
                0, sale.size());

        Assert.assertEquals(3,sales.size());
    }

    @Test
    public void createNewSale(){

    }

    @Test
    public void deleteSales(){

    }
}
