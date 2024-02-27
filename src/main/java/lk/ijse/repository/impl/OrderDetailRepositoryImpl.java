package lk.ijse.repository.impl;

import lk.ijse.entity.OrderDetail;
import lk.ijse.repository.OrderDetailRepository;
import org.hibernate.Session;

import java.util.List;

public class OrderDetailRepositoryImpl implements OrderDetailRepository {
    private static OrderDetailRepository orderDetailRepository;

    private Session session;

    private OrderDetailRepositoryImpl(){}

    public static OrderDetailRepository getInstance(){
        return orderDetailRepository == null ? orderDetailRepository = new OrderDetailRepositoryImpl():orderDetailRepository;

    }

    @Override
    public int save(OrderDetail object) {
        session.save(object);
        return 1;
    }

    @Override
    public void update(OrderDetail object) {
        session.update(object);
    }

    @Override
    public OrderDetail get(int id) {
        return null;
    }

    @Override
    public void delete(OrderDetail object) {

    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
