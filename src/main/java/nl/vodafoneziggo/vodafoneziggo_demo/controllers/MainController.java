package nl.vodafoneziggo.vodafoneziggo_demo.controllers;

import nl.vodafoneziggo.vodafoneziggo_demo.models.Order;
import nl.vodafoneziggo.vodafoneziggo_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private OrderService orderService;

    @PostMapping("orderCreation")
    public ResponseEntity<Integer> createOrder(final Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("orders")
    public ResponseEntity<List<Order>> fetchOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
