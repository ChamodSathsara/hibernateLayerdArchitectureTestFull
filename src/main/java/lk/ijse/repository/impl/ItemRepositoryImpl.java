package lk.ijse.repository.impl;

import lk.ijse.entity.Item;
import lk.ijse.repository.ItemRepository;
import lk.ijse.service.impl.ItemServiceImpl;
import org.hibernate.Session;

import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {

    private static ItemRepository itemRepository;
    private Session session;

    private ItemRepositoryImpl(){}

    public static ItemRepository getInstance(){
        return itemRepository == null ? itemRepository = new ItemRepositoryImpl():itemRepository;
    }
    @Override
    public int save(Item object) {
        return (Integer) session.save(object);
    }

    @Override
    public void update(Item object) {
        session.update(object);
    }

    @Override
    public Item get(int id) {
        return null;
    }

    @Override
    public void delete(Item object) {

    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
