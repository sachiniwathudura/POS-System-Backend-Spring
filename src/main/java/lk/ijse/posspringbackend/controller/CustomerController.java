package lk.ijse.posspringbackend.controller;

import lk.ijse.posspringbackend.dto.CustomerDTO;
import lk.ijse.posspringbackend.entity.Customer;
import lk.ijse.posspringbackend.exception.CustomerNotFoundException;
import lk.ijse.posspringbackend.exception.DataPersistsFailedException;
import lk.ijse.posspringbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    private static final Logger logger= LoggerFactory.getLogger(Customer.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDTO customerDTO){
        if (customerDTO == null){
            logger.warn("Received null CustomerDTO");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                customerService.saveCustomer(customerDTO);
                logger.info("Customer saved successfully: {}", customerDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistsFailedException e) {
                logger.error("Failed to persist customer data: {}", customerDTO, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                logger.error("Unexpected error occurred while saving customer: {}", customerDTO, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable("id") String id, @RequestBody CustomerDTO customerDTO){
        if (customerDTO == null || id == null || id.isEmpty()) {
            logger.warn("Received null id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                customerDTO.setId(id);
                customerService.updateCustomer(customerDTO);
                logger.info("Customer saved successfully: {}", customerDTO);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (DataPersistsFailedException e) {
                logger.error("Failed to persist customer data: {}", customerDTO, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                logger.error("Unexpected error occurred while saving customer: {}", customerDTO, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping(value ="/{id}" )
    public ResponseEntity<Void> deleteCustomer(@PathVariable ("id") String id) {
        try {
            if (id == null || id.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
