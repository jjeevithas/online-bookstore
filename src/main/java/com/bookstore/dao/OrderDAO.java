package com.bookstore.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
    private final JdbcTemplate jdbc;
    public OrderDAO(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    public long create(double total) {
        jdbc.update("INSERT INTO orders(total) VALUES(?)", total);
        Long id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        return id == null ? 0 : id;
    }
}
