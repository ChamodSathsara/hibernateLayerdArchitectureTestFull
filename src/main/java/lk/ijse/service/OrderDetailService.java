package lk.ijse.service;

import lk.ijse.dto.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    int saveOrderDetail(OrderDetailDto orderDetail);
    OrderDetailDto getOrderDetail(int id);

    boolean updateOrderDetail(OrderDetailDto orderDetail);

    boolean deleteOrderDetail(OrderDetailDto orderDetail);

    List<OrderDetailDto> getAllOrderDetail();
}
