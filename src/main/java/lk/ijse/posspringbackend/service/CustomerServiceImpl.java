package lk.ijse.posspringbackend.service;

import lk.ijse.posspringbackend.customObj.CustomerResponse;
import lk.ijse.posspringbackend.dao.CustomerDao;
import lk.ijse.posspringbackend.dto.CustomerDTO;
import lk.ijse.posspringbackend.entity.Customer;
import lk.ijse.posspringbackend.exception.DataPersistsFailedException;
import lk.ijse.posspringbackend.util.AppUtil;
import lk.ijse.posspringbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
//@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
   @Autowired
    private  CustomerDao customerDao;
   @Autowired
   private  Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

        Customer savedCustomer = customerDao.save(mapping.convertToCustomer(customerDTO));
        if (savedCustomer == null){
            throw new DataPersistsFailedException("can not save customer");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
//        Optional<Customer> tmpCustomer = customerDao.findById(customerDTO.getId());
//        if(!tmpCustomer.isPresent()){
//            throw new DataPersistsFailedException("User not found");
//        }else {
//            Customer customer = tmpCustomer.get();
//            customer.setName(customerDTO.getName());
//            customer.setAddress(customerDTO.getAddress());
//            customer.setSalary(customerDTO.getSalary());
//            customerDao.save(customer);
//        }
        if (customerDTO.getId() == null || customerDTO.getId().isEmpty()) {
            throw new IllegalArgumentException("The given id must not be null or empty");
        }

        Optional<Customer> tmpCustomer = customerDao.findById(customerDTO.getId());
        if (!tmpCustomer.isPresent()) {
            throw new DataPersistsFailedException("User not found");
        } else {
            Customer customer = tmpCustomer.get();
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            customer.setSalary(customerDTO.getSalary());
            customerDao.save(customer);  // Save updated customer
        }
    }

    @Override
    public void deleteCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public CustomerResponse getSelectedCustomer(String id) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }
}
