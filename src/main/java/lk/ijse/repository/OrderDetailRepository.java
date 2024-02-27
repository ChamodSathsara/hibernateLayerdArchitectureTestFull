package lk.ijse.repository;

import lk.ijse.entity.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends CrudRepository<OrderDetail,Integer>{
    List<OrderDetail> getAllOrderDetails();
}
