package lk.ijse.dto;

import lk.ijse.embadded.OrderDetailsPK;
import lk.ijse.entity.Item;
import lk.ijse.entity.Order;
import lk.ijse.entity.OrderDetail;

import java.sql.Timestamp;

public class OrderDetailDto {
    private OrderDetailsPK orderDetailsPK;
    private String description;

    public OrderDetailDto() {
    }

    //All Args Constructor
    public OrderDetailDto(OrderDetailsPK orderDetailsPK,String description) {
        this.orderDetailsPK = orderDetailsPK;
        this.description = description;
    }

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
        return "OrderDetailDto{" +
                "orderDetailsPK=" + orderDetailsPK +
                ", description='" + description + '\'' +
                '}';
    }

    public OrderDetail toEntity(){
        OrderDetail orderDetailDto = new OrderDetail();
        orderDetailDto.setDescription(this.description);
        orderDetailDto.setOrderDetailsPK(this.orderDetailsPK);

        return orderDetailDto;
    }
}
