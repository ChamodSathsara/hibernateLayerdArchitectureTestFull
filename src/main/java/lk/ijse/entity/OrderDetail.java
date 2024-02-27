package lk.ijse.entity;

import lk.ijse.embadded.OrderDetailsPK;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailsPK orderDetailsPK;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    private Timestamp date;

    //Item Relationship
    @ManyToOne
    @JoinColumn(
            name = "item_id",
            referencedColumnName = "item_id",
            insertable = false,
            updatable = false
    )
    private Item item;


    //order Relationship
    @ManyToOne
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "order_id",
            insertable = false,
            updatable = false
    )
    private Order order;

    //No args Constructor
    public OrderDetail() {
    }

    //All Args Constructor
    public OrderDetail(OrderDetailsPK orderDetailsPK, String description) {
        this.orderDetailsPK = orderDetailsPK;
        this.description = description;
    }

    //Getters & Setters
    public OrderDetailsPK getOrderDetailsPK() {
        return orderDetailsPK;
    }

    public void setOrderDetailsPK(OrderDetailsPK orderDetailsPK) {
        this.orderDetailsPK = orderDetailsPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    //To string method
    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailsPK=" + orderDetailsPK +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }


}
