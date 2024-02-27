package lk.ijse.repository.impl;

import lk.ijse.entity.Customer;
import lk.ijse.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class CustomerRepositoryImpl implements CustomerRepository{

    private static CustomerRepository customerRepository;

    private Session session;

    private CustomerRepositoryImpl(){

    }
    public static CustomerRepository getInstance(){
        return customerRepository == null ? customerRepository = new CustomerRepositoryImpl():customerRepository;
    }

    @Override
    public int save(Customer customer) {
        return (Integer)session.save(customer);

    }

    @Override
    public void update(Customer customer) {
        session.update(customer);
    }

    @Override
    public Customer get(int id) {
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public List<Customer> getAllCustomer() {

        String sql = "SELECT c FROM Customer AS c";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();

        return list;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}