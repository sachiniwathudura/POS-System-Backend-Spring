package lk.ijse.posspringbackend.service;

import lk.ijse.posspringbackend.customObj.ItemResponse;
import lk.ijse.posspringbackend.dao.ItemDao;
import lk.ijse.posspringbackend.dto.ItemDTO;
import lk.ijse.posspringbackend.entity.Item;
import lk.ijse.posspringbackend.exception.DataPersistsFailedException;
import lk.ijse.posspringbackend.exception.ItemNotFoundException;
import lk.ijse.posspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        Item save = itemDao.save(mapping.convertToItem(itemDTO));
        if (save == null){
            throw new DataPersistsFailedException("cannot save item");
        }
    }

    @Override
    public void updateItem(String code ,ItemDTO itemDTO) {
        Optional<Item> tmp = itemDao.findById(code);
        if (!tmp.isPresent()) {
            throw new ItemNotFoundException("item not found");
        }else {
            tmp.get().setName(itemDTO.getName());
            tmp.get().setPrice(itemDTO.getPrice());
            tmp.get().setQty(itemDTO.getQty());
        }
    }

    @Override
    public void deleteItem(String code) {
        Optional<Item>tmp=itemDao.findById(code);
        if(!tmp.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else{
            itemDao.deleteById(code);
        }
    }

    @Override
    public ItemResponse getSelectedItem(String code) {
        if(itemDao.existsById(code)){
            return mapping.convertToItemDTO(itemDao.getReferenceById(code));
        }else{
            throw new ItemNotFoundException("Item not found ");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.convertItemToList(itemDao.findAll());
    }
}
