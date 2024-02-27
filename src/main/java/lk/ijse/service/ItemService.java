package lk.ijse.service;

import lk.ijse.dto.ItemDto;
import lk.ijse.entity.Item;

import java.util.List;

public interface ItemService {
    int saveItem(ItemDto item);
    ItemDto getItem(int id);
    boolean updateItem(ItemDto item);

    boolean deleteItem(ItemDto item);

    List<ItemDto> getAllItems();
}
