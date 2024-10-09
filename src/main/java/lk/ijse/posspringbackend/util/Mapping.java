package lk.ijse.posspringbackend.util;

import lk.ijse.posspringbackend.dto.CustomerDTO;
import lk.ijse.posspringbackend.entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //customer matters mapping
    public Customer convertToCustomer(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, Customer.class);
    }
    public CustomerDTO convertToCustomerDTO(Customer customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public List<CustomerDTO> convertCustomerToList(List<Customer> customerEntities){
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }
}
