package lk.ijse.posspringbackend.dao;

import lk.ijse.posspringbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, String> {
    Customer getCustomerById(String id);
}
