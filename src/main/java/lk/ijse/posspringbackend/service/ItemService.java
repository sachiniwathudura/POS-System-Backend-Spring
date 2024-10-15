package lk.ijse.posspringbackend.service;



import lk.ijse.posspringbackend.customObj.ItemResponse;
import lk.ijse.posspringbackend.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem( String code ,ItemDTO itemDTO);
    void deleteItem(String code );
    ItemResponse getSelectedItem(String code);
    List<ItemDTO> getAllItems();
}
