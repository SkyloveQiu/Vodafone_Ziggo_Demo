package nl.vodafoneziggo.vodafoneziggo_demo.service;

import jakarta.transaction.Transactional;
import nl.vodafoneziggo.vodafoneziggo_demo.models.Order;
import nl.vodafoneziggo.vodafoneziggo_demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;


@Service
public class OrderService implements OrderServiceInterface {
    @Autowired
    private OrderRepository orderRepository;
    private userValidationService userService;
    @Transactional
    @Override
    public Integer createOrder(Order order) {
        Order finalOrder = null;
        try {
            finalOrder = userService.validateUser(order.getEmail(),order.getProductId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user email is not valid.");
        }
        if (findOrderByEmailAndProduct(order.getEmail(),order.getProductId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Order existed, please don't reorder same product.");
        }
        if (isInvalidEmailAddress(order.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email is not valid, please double check your email address");
        }
        if (finalOrder == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is not registered, please register first.");
        }

        orderRepository.save(finalOrder);
        return finalOrder.getOrderId();
    }

    @ReadOnlyProperty
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @ReadOnlyProperty
    private boolean findOrderByEmailAndProduct(String email, String productId) {
        Order order = orderRepository.findByEmailAndProductId(email,productId);
        if (order == null){
            return false;
        } else {
            return true;
        }
    }

    public static boolean isInvalidEmailAddress(String email) {
        boolean result = false;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = true;
        }
        return result;
    }

}
