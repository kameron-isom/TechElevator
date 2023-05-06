package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book getBook(int bookId) {
        Book book =new Book();
        String sql= "SELECT * FROM book WHERE book_id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,bookId);
        while (result.next()){
            book = mapRowToBook(result);
        }
        return book ;
    }

    @Override
    public Book updateRating(int bookId, BigDecimal newRating) {
        Book book =new Book();
        String sql = "UPDATE book SET star_rating=? WHERE book_id=?";
        int updatedRows= jdbcTemplate.update(sql, newRating, bookId);
        if(updatedRows!=1){
            System.out.println("Not avaliable ");;
        }
        return getBook(updatedRows); }

    @Override
    public void deleteBook(int bookId) {
        String sqlBookAuthor = "DELETE FROM book_author WHERE book_id=?";
        int resultBooAuthor = jdbcTemplate.update(sqlBookAuthor,bookId);

        String sql = "DELETE FROM book WHERE book_id=?";
       int result = jdbcTemplate.update(sql,bookId);
    }

    private Book mapRowToBook(SqlRowSet results) {
        Book book = new Book();
        book.setBookId(results.getInt("book_id"));
        book.setBookTitle(results.getString("book_title"));
        book.setStarRating(results.getBigDecimal("star_rating"));
        book.setOutOfPrint(results.getBoolean("out_of_print"));
        book.setForewordBy((Integer) results.getObject("foreword_by"));
        book.setPublisherId(results.getInt("publisher_id"));
        book.setPublishedDate(results.getDate("published_date").toLocalDate());
        return book;
    }
}
