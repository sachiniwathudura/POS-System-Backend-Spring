package lk.ijse.posspringbackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.posspringbackend.dao.CustomerDao;
import lk.ijse.posspringbackend.dao.ItemDao;
import lk.ijse.posspringbackend.dao.OrderDao;
import lk.ijse.posspringbackend.dao.OrderDetailsDao;
import lk.ijse.posspringbackend.dto.OrderDetailsDTO;
import lk.ijse.posspringbackend.dto.OrdersDTO;
import lk.ijse.posspringbackend.entity.Customer;
import lk.ijse.posspringbackend.entity.Item;
import lk.ijse.posspringbackend.entity.OrderDetails;
import lk.ijse.posspringbackend.entity.Orders;
import lk.ijse.posspringbackend.exception.DataPersistsFailedException;
import lk.ijse.posspringbackend.util.AppUtil;
import lk.ijse.posspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveOrder(OrdersDTO ordersDTO) {

            // Create and populate the OrderEntity
            Orders orderEntity = new Orders();
            orderEntity.setOrderId(AppUtil.createOrderId());
            orderEntity.setOrderDate(ordersDTO.getOrderDate());
            orderEntity.setTotal(ordersDTO.getTotal());
            orderEntity.setDiscount(ordersDTO.getDiscount());
            orderEntity.setSubTotal(ordersDTO.getSubTotal());
            orderEntity.setCash(ordersDTO.getCash());
            orderEntity.setBalance(ordersDTO.getBalance());

            // Retrieve the CustomerEntity from the database
            Customer customerEntity = customerDao.findById(ordersDTO.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " + ordersDTO.getId()));
            orderEntity.setCustomer(customerEntity);

            // Save the OrderEntity
            Orders savedOrder = orderDao.save(orderEntity);

            // Process the order details and save them
            for (OrderDetailsDTO orderDetailDTO : ordersDTO.getOrderDetails()) {
                OrderDetails orderDetailsEntity = new OrderDetails();
                orderDetailsEntity.setOd_id(AppUtil.createOrderDetailId());
                orderDetailsEntity.setQty(orderDetailDTO.getQty());
                orderDetailsEntity.setUnitPrice(orderDetailDTO.getUnitPrice());

                // Retrieve the ItemEntity from the database
                Item itemEntity = itemDao.findById(orderDetailDTO.getCode())
                        .orElseThrow(() -> new IllegalArgumentException("Invalid item code: " + orderDetailDTO.getCode()));
                orderDetailsEntity.setItem(itemEntity);
                orderDetailsEntity.setOrder(savedOrder);  // Link the saved order

                // Save each OrderDetailsEntity
                orderDetailsDao.save(orderDetailsEntity);
            }

            if (savedOrder == null) {
                throw new DataPersistsFailedException("Order save failed!");
            }
    }



    @Override
    public List<OrderDetailsDTO> getOrderDetails() {
        return mapping.convertOrderDetailListToOrderDetailDTOList(orderDetailsDao.findAll());
    }
}
