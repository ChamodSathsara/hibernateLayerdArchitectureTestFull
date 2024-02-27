package lk.ijse.embadded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class OrderDetailsPK implements Serializable {

    //attributes
    @Column(name = "order_id")
    private int oId;

    @Column(name = "item_id")
    private int iId;

    //No args  constructor
    public OrderDetailsPK() {
    }

    //All args Constructor
    public OrderDetailsPK(int oId, int iId) {
        this.oId = oId;
        this.iId = iId;
    }
    //Getters & Setters

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    //to string method
    @Override
    public String toString() {
        return "OrderDetailsPK{" +
                "oId=" + oId +
                ", iId=" + iId +
                '}';
    }
}
