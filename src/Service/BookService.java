package Service;

import Dao.BookDao;
import com.oracle.jdbc.util.Transactional;
import Entity.Book;

import javax.servlet.jsp.PageContext;
import java.util.List;

public class BookService {

    BookDao dao=new BookDao();

    public List<Book> getBooks(){
        return dao.selectAll();
    }

    @Transactional
    public void  save(Book book){
        dao.insert(book);
    }

    @Transactional
    public void delete(Integer BookId){
        dao.Delete(BookId);
    }

    @Transactional
    public void update(Book book){
        dao.update(book);
    }

    @Transactional
    public Book select_one_book(Integer bookId){
        return dao.get_one_book(bookId);
    }
}
