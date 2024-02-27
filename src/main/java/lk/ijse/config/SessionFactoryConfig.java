package lk.ijse.config;

import lk.ijse.embadded.OrderDetailsPK;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.Order;
import lk.ijse.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    public static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;
    private SessionFactoryConfig(){

        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(OrderDetailsPK.class)
                .buildSessionFactory();
    }
    public static SessionFactoryConfig getInstance(){
        return sessionFactoryConfig == null ? sessionFactoryConfig = new SessionFactoryConfig() : sessionFactoryConfig;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
