package lk.ijse.service;

import jdk.dynalink.linker.LinkerServices;
import lk.ijse.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    int saveCustomer(CustomerDto customer);
    boolean updateCustomer(CustomerDto customer);
    CustomerDto getCustomer(int id);
    boolean deleteCustomer(CustomerDto customer);
    List<CustomerDto> getAllCustomer();
}
