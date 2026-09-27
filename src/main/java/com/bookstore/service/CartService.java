package com.bookstore.service;

import com.bookstore.dao.CartDAO;
import com.bookstore.model.CartItem;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    private final CartDAO dao;
    public CartService(CartDAO dao) { this.dao = dao; }
    public List<CartItem> getCart() { return dao.findAll(); }
    public void add(long bookId) { dao.add(bookId); }
    public void remove(long id) { dao.remove(id); }
    public void clear() { dao.clear(); }
    public double total() { return getCart().stream().mapToDouble(CartItem::getSubtotal).sum(); }
}
