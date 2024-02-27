package lk.ijse.service;

import lk.ijse.dto.OrderDto;

import java.util.List;

public interface OrderService {
    int saveOrder(OrderDto order);
    OrderDto getOrder(int id);
    boolean updateOrder(OrderDto order);
    boolean deleteOrder(OrderDto order);
    List<OrderDto> getAllOrders();
}
