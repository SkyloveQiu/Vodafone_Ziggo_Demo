package nl.vodafoneziggo.vodafoneziggo_demo.service;

import nl.vodafoneziggo.vodafoneziggo_demo.models.Order;

import java.util.List;

public interface OrderServiceInterface {
    Integer createOrder(Order order) throws Exception;
    List<Order> getAllOrders();

}
