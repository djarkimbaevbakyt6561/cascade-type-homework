package bakyt.services;

public interface GeneralService<T> {
    void save(T t);
    void update(Long id, T t);
    void delete(Long id);
}
