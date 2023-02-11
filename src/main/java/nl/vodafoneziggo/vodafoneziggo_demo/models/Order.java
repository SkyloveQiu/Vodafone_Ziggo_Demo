package nl.vodafoneziggo.vodafoneziggo_demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;


/**
 * Entity to order.
 */
@Entity
@Table(name = "Threads")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "productID")
    private String productId;

    /**
     * Basic constructor for an Order
     *
     * @param email     The email of the user
     * @param firstName The time at which this thread was created
     * @param lastName  The ID of the board to which this thread belongs
     * @param productId The NetID of the user who posted this thread
     */
    public Order(String email, String firstName, String lastName, String productId) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.productId = productId;
    }

    public Order() {
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProductId() {
        return productId;
    }


    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(productId, order.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}

