package lk.ijse.repository.impl;

import lk.ijse.entity.Order;
import lk.ijse.repository.OrderRepository;
import org.hibernate.Session;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepository orderRepository;

    private Session session;

    private OrderRepositoryImpl(){}

    public static OrderRepository getInstance(){
        return orderRepository == null ? orderRepository = new OrderRepositoryImpl() : orderRepository;

    }
    @Override
    public int save(Order object) {
        return (Integer) session.save(object);
    }

    @Override
    public void update(Order object) {
        session.update(object);
    }

    @Override
    public Order get(int id) {
        return null;
    }

    @Override
    public void delete(Order object) {

    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
