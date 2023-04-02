package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcLineItemTest extends  BaseDaoTests{

    private JdbcLineItemDao jdbcLineItemDao;

    @Before

    public void setUp(){
        jdbcLineItemDao=new JdbcLineItemDao(dataSource);
    }

    @Test

    public void getLineItemBySaleId(){
        List<LineItem> lineItems= jdbcLineItemDao.getLineItemsBySale(1);

        Assert.assertEquals(3, lineItems.size());
    }
}
