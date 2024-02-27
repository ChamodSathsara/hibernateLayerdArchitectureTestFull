package lk.ijse.repository;

import lk.ijse.dto.CustomerDto;
import lk.ijse.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

    List<Customer> getAllCustomer();
}

