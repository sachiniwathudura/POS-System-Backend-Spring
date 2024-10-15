package lk.ijse.posspringbackend.controller;

import lk.ijse.posspringbackend.dto.OrderDetailsDTO;
import lk.ijse.posspringbackend.dto.OrdersDTO;
import lk.ijse.posspringbackend.exception.DataPersistsFailedException;
import lk.ijse.posspringbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody OrdersDTO ordersDTO) {
        if (ordersDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                orderService.saveOrder(ordersDTO);
                logger.info("Order placed successfully: {}", ordersDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistsFailedException e){
                logger.error("Failed to persist order data: {}", ordersDTO, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                logger.error("Unexpected error occurred while saving order: {}", ordersDTO, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDTO> getOrderDetails() {
        return orderService.getOrderDetails();
    }
}
