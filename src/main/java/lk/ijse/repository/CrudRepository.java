package lk.ijse.repository;

public interface CrudRepository<T ,ID> extends SuperRepository {
    int save(T object);
    void update(T object);
    T get(int id);
    void delete(T object);
}
