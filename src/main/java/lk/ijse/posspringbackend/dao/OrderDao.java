package lk.ijse.posspringbackend.dao;

import lk.ijse.posspringbackend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Orders,String> {
}
