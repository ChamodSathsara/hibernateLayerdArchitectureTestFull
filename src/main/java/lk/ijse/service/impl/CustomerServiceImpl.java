package lk.ijse.service.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.CustomerDto;
import lk.ijse.entity.Customer;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.repository.impl.CustomerRepositoryImpl;
import lk.ijse.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerService customerService;

    private Session session;

    private final CustomerRepository customerRepository;

    private CustomerServiceImpl(){
        customerRepository = CustomerRepositoryImpl.getInstance();
    }

    public static CustomerService getInstance(){
        return customerService == null ? customerService = new CustomerServiceImpl() :customerService;
    }
    @Override
    public int saveCustomer(CustomerDto customer) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction  = session.beginTransaction();
        int isSave =-1;
        try {
            customerRepository.setSession(session);
            isSave= customerRepository.save(customer.toEntity());
            transaction.commit();
            return isSave;
        }
        catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
            return isSave;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean updateCustomer(CustomerDto customer) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            customerRepository.setSession(session);
            customerRepository.update(customer.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public CustomerDto getCustomer(int id) {

        session = SessionFactoryConfig.getInstance().getSession();
        try{
            customerRepository.setSession(session);
            Customer customer = customerRepository.get(id);
            CustomerDto customerDto = customer.ToClass();
            return customerDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteCustomer(CustomerDto customer) {
        return false;
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        session = SessionFactoryConfig.getInstance().getSession();
        try {
            customerRepository.setSession(session);
            List<Customer> customerList = customerRepository.getAllCustomer();
            List<CustomerDto> customerDtos = new ArrayList<>();
            for (Customer customer : customerList){
                customerDtos.add(customer.ToClass());
            }
            return customerDtos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
