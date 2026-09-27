package com.bookstore.controller;

import com.bookstore.model.CartItem;
import com.bookstore.service.CartService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {
    private final CartService service;
    public CartController(CartService service) { this.service = service; }

    @GetMapping
    public Map<String,Object> getCart() {
        List<CartItem> items = service.getCart();
        return Map.of("items", items, "total", service.total());
    }

    @PostMapping
    public Map<String,String> add(@RequestBody Map<String,Long> body) {
        service.add(body.get("bookId"));
        return Map.of("message", "Book added to cart");
    }

    @DeleteMapping("/{id}")
    public Map<String,String> remove(@PathVariable long id) {
        service.remove(id);
        return Map.of("message", "Item removed");
    }
}
