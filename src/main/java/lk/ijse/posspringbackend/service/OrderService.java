package lk.ijse.posspringbackend.service;

import lk.ijse.posspringbackend.dto.OrderDetailsDTO;
import lk.ijse.posspringbackend.dto.OrdersDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrdersDTO ordersDTO);
    List<OrderDetailsDTO> getOrderDetails();
}
