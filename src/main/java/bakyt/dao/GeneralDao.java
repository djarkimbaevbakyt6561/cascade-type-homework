package bakyt.dao;

public interface GeneralDao<T> {
    void save(T t);
    void update(Long id, T t);
    void delete(Long id);
}
