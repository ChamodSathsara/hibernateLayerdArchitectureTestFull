package lk.ijse.entity;

import jdk.jfr.Timespan;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private int oId;
    @Column(name = "description")
    private String description;

    @CreationTimestamp
    private Timestamp date;

    //Customer RelationShip Generate
    @ManyToOne
    @JoinColumn(name = "customer_id" )
    private Customer customer;

    //OrderDetail Relationship
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "order")
    private List<OrderDetail> orderDetailList;

    //No args constructor
    public Order() {
    }
    //All args Constructor

    public Order(int oId, String description,Timestamp date) {
        this.oId = oId;
        this.description = description;
        this.date = date;
    }

    //Getters & Setters

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //Override ToString method
    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
