package lk.ijse.dto;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Order;
import lk.ijse.entity.OrderDetail;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

public class OrderDto {
    private int oId;
    private String description;
    private Timestamp date;

    private Customer customer;

    //No args constructor
    public OrderDto() {
    }
    //All args Constructor

    public OrderDto(int oId, String description , Customer customer) {
        this.oId = oId;
        this.description = description;
        this.customer = customer;
    }

    //Getters & Setters


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    //Override ToString method
    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    public Order toEntity(){
        Order orderDto = new Order();
        orderDto.setoId(this.oId);
        orderDto.setDescription(this.description);
        orderDto.setCustomer(this.customer);

        return orderDto;
    }
}
