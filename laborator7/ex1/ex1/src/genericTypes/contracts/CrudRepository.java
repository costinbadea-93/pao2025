package genericTypes.contracts;

//tip generic pe clasa
public interface CrudRepository<T> {
//    void save(Object object);
//    void delete(Object object);
//    Object getById(Object id);

    void save(T t);
    void delete(T t);
    T getById(int id);
}
