package lk.ijse.service.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.ItemDto;
import lk.ijse.repository.ItemRepository;
import lk.ijse.repository.impl.ItemRepositoryImpl;
import lk.ijse.service.ItemService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    private static ItemService itemService;

    private Session session;

    private final ItemRepository itemRepository;

    private ItemServiceImpl(){
        itemRepository = ItemRepositoryImpl.getInstance();
    }

    public static ItemService getInstance(){
        return itemService == null ? itemService = new ItemServiceImpl() : itemService;
    }

    @Override
    public int saveItem(ItemDto item) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction  = session.beginTransaction();

        try{
            itemRepository.setSession(session);
            int save = itemRepository.save(item.toEntity());
            transaction.commit();
            return save;
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            session.close();
        }
    }

    @Override
    public ItemDto getItem(int id) {
        return null;
    }

    @Override
    public boolean updateItem(ItemDto item) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            itemRepository.setSession(session);
            itemRepository.update(item.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }
    @Override
    public boolean deleteItem(ItemDto item) {
        return false;
    }

    @Override
    public List<ItemDto> getAllItems() {
        return null;
    }
}
