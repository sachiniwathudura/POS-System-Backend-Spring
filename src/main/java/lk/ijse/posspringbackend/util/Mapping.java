package lk.ijse.posspringbackend.util;

import lk.ijse.posspringbackend.dto.CustomerDTO;
import lk.ijse.posspringbackend.dto.ItemDTO;
import lk.ijse.posspringbackend.dto.OrderDetailsDTO;
import lk.ijse.posspringbackend.entity.Customer;
import lk.ijse.posspringbackend.entity.Item;
import lk.ijse.posspringbackend.entity.OrderDetails;
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
    public List<CustomerDTO> convertCustomerToList(List<Customer> customerEntities){return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //item matters mapping
    public Item convertToItem(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, Item.class);
    }
    public ItemDTO convertToItemDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }
    public List<ItemDTO> convertItemToList(List<Item> itemEntities){
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDTO>>() {}.getType());
    }

    public List<OrderDetailsDTO> convertOrderDetailListToOrderDetailDTOList(List<OrderDetails> orderDetailsList) {
        return modelMapper.map(orderDetailsList, new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }

}
