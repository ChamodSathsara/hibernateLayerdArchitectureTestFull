package lk.ijse.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "item_id")
    private int iId;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_price")
    private int price;
    @Column(name = "qty")
    private int qty;

    //Order detail(assosiate entity) relationship
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "item")
    private List<OrderDetail> orderDetails;

    //No Args Constructor

    public Item() {
    }

    //All Args Constructor
    public Item(int iId, String name, int price, int qty) {
        this.iId = iId;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    //Getters & Setters

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    //To string method

    @Override
    public String toString() {
        return "Item{" +
                "iId=" + iId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
