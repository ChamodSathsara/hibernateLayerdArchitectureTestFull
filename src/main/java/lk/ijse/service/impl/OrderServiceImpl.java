package lk.ijse.service.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.OrderDto;
import lk.ijse.repository.OrderRepository;
import lk.ijse.repository.impl.OrderRepositoryImpl;
import lk.ijse.service.OrderService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static OrderService orderService;

    private Session session;

    private final OrderRepository orderRepository;

    private OrderServiceImpl(){
        orderRepository = OrderRepositoryImpl.getInstance();

    }
    public static OrderService getInstance(){
        return orderService == null ? orderService = new OrderServiceImpl() : orderService;
    }
    @Override
    public int saveOrder(OrderDto order) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            orderRepository.setSession(session);
            int isSave = orderRepository.save(order.toEntity());
            transaction.commit();
            return isSave;

        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
            return -1;
        }finally {
            session.close();
        }
    }

    @Override
    public OrderDto getOrder(int id) {
       return null;

    }

    @Override
    public boolean updateOrder(OrderDto order) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            orderRepository.setSession(session);
            session.update(order.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }

    }

    @Override
    public boolean deleteOrder(OrderDto order) {
        return false;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }
}
