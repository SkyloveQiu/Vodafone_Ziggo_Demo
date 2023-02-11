package nl.vodafoneziggo.vodafoneziggo_demo.repositories;

import java.util.List;
import  nl.vodafoneziggo.vodafoneziggo_demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to facilitate CRUD operations on Order entities.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    //get all orders
    List<Order> findAll();
    //get order by email and product id

    Order findByEmailAndProductId(String email,String productID);
}
