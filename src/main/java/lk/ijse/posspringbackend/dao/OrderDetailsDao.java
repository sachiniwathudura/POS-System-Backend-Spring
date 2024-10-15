package lk.ijse.posspringbackend.dao;

import lk.ijse.posspringbackend.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, String> {

}
