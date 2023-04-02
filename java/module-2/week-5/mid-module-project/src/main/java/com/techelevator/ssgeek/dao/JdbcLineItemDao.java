package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDao implements  LineItemDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcLineItemDao(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public List<LineItem> getLineItemsBySale(int saleId) {
        List<LineItem> listOfLineItems = new ArrayList<>();
        String sql = "SELECT * FROM line_item WHERE sale_id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,saleId);
        while(result.next()){
            LineItem lineItem = mapRowToLineItem(result);
            listOfLineItems.add(lineItem);
        }
        return listOfLineItems;
    }
    private LineItem mapRowToLineItem(SqlRowSet result){
        LineItem lineItem= new LineItem();
        lineItem.setLineItemId(result.getInt("line_item_id"));
        lineItem.setProductId(result.getInt("product_id"));
        lineItem.setSaleId(result.getInt("sale_id"));
        lineItem.setPrice(result.getBigDecimal("price"));
        lineItem.setQuantity(result.getInt("quantity"));
        return lineItem;
    }
}
