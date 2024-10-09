package lk.ijse.posspringbackend.service;

import lk.ijse.posspringbackend.customObj.CustomerResponse;
import lk.ijse.posspringbackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String id);
    CustomerResponse getSelectedCustomer(String id);
    List<CustomerDTO> getAllCustomers();

}
