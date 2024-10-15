package lk.ijse.posspringbackend.dao;

import lk.ijse.posspringbackend.entity.Customer;
import lk.ijse.posspringbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, String> {

}
