package DemoRest;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private static BookService instance;
    private static final List<BookModel> data = new ArrayList<BookModel>();

    static {
        data.add(new BookModel(1, "Harry Potter", 999.99f));
        data.add(new BookModel(2, "Goosebumps", 329.50f));
    }

    private BookService() {}

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }

        return instance;
    }

    public List<BookModel> listAll() {
        return new ArrayList<BookModel>(data);
    }

    public int add(BookModel book) {
        int newId = data.size() + 1;
        book.setId(newId);
        data.add(book);

        return newId;
    }

    public BookModel get(int id) {
        BookModel bookToFind = new BookModel(id);
        int index = data.indexOf(bookToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }

    public boolean delete(int id) {
        BookModel bookToFind = new BookModel(id);
        int index = data.indexOf(bookToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }

        return false;
    }

    public boolean update(BookModel book) {
        int index = data.indexOf(book);
        if (index >= 0) {
            data.set(index, book);
            return true;
        }
        return false;
    }

}
