package lk.ijse.repository;

import lk.ijse.entity.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item,Integer>{
    List<Item> getAllItems();
}
