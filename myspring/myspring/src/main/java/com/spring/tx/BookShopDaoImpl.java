package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("BookShopDao") //它用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jbJdbcTemplate){
//    	this.jdbcTemplate = jbJdbcTemplate;
//    }
    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM book WHERE isbn = ?";
       
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    public void updateBookStock(String isbn) {
        //检查书的库存是否足够，若不够，则抛出异常
        String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock == 0) {
            throw new BookStockException("库存不足！");
        }
        String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }
    public void updateUserAccount(String username, int price) {
        //检查余额是否不足，若不足，则抛出异常
        String sql2 = "SELECT balance FROM account WHERE username = ?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
        if (balance < price) {
            throw new UserAccountException("余额不足！");
        }       
        String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql, price, username);
    }

}
