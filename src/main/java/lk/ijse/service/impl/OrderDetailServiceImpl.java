package lk.ijse.service.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.OrderDetailDto;
import lk.ijse.repository.OrderDetailRepository;
import lk.ijse.repository.impl.OrderDetailRepositoryImpl;
import lk.ijse.service.OrderDetailService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private static OrderDetailService orderDetailService;

    private Session session;

    private final OrderDetailRepository orderDetailRepository;

    private OrderDetailServiceImpl(){
        orderDetailRepository = OrderDetailRepositoryImpl.getInstance();
    }
    public static OrderDetailService getInstance(){
        return orderDetailService == null ? orderDetailService = new OrderDetailServiceImpl() : orderDetailService;
    }

    @Override
    public int saveOrderDetail(OrderDetailDto orderDetail) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            orderDetailRepository.setSession(session);
            int isSave = orderDetailRepository.save(orderDetail.toEntity());
            transaction.commit();
            return isSave;
        }
        catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            session.close();
        }


    }

    @Override
    public OrderDetailDto getOrderDetail(int id) {
        return null;
    }

    @Override
    public boolean updateOrderDetail(OrderDetailDto orderDetail) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            orderDetailRepository.setSession(session);
            orderDetailRepository.update(orderDetail.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteOrderDetail(OrderDetailDto orderDetail) {
        return false;
    }

    @Override
    public List<OrderDetailDto> getAllOrderDetail() {
        return null;
    }
}
