package com.bookstore.controller;

import com.bookstore.service.CartService;
import com.bookstore.dao.OrderDAO;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/checkout")
@CrossOrigin(origins = "*")
public class CheckoutController {
    private final CartService cart;
    private final OrderDAO orders;

    public CheckoutController(CartService cart, OrderDAO orders) {
        this.cart = cart; this.orders = orders;
    }

    @PostMapping
    public Map<String,Object> checkout() {
        double total = cart.total();
        if (total <= 0) return Map.of("success", false, "message", "Your cart is empty.");
        long orderId = orders.create(total);
        cart.clear();
        return Map.of("success", true, "orderId", orderId, "total", total,
                      "message", "Order placed successfully!");
    }
}
