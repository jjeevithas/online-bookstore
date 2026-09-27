package com.bookstore.model;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private double total;
    private LocalDateTime createdAt;

    public Order() {}
    public Order(Long id, double total, LocalDateTime createdAt) {
        this.id = id; this.total = total; this.createdAt = createdAt;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
