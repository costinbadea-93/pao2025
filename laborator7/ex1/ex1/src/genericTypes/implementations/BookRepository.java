package genericTypes.implementations;

import genericTypes.contracts.CrudRepository;
import genericTypes.model.Book;

public class BookRepository implements CrudRepository<Book> {
    @Override
    public void save(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public Book getById(int id) {
        return null;
    }
}
