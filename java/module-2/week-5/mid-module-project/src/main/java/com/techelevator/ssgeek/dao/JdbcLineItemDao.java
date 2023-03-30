package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcLineItemDao implements  LineItemDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcLineItemDao(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public List<LineItem> getLineItemsBySale(int saleId) {
        return null;
    }
}
