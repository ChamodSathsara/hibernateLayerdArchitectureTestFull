package lk.ijse.repository;

import lk.ijse.entity.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer>{
    List<Order> getAllOrder();
}
