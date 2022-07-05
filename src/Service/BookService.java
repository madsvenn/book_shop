package Service;

import Dao.BookDao;
import Entity.Repository;
import com.oracle.jdbc.util.Transactional;
import Entity.Book;
import util.PageInfo;

import java.util.List;
import java.util.Map;

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

    @Transactional
    public List<Map<String,Object>>selectRepositories(){
        return dao.selectRepositories();
    }

    /**
     * 出入库
     * @param repository
     */
    @Transactional
    public void repository(Repository repository){
        //1.update repository

        if("out".equals(repository.getKind())){
            repository.setCount(-repository.getCount());
        }

        //2
        dao.updateBookAmount(repository.getBookId(),repository.getCount());

        //获得库存数
        Book book = dao.get_one_book(repository.getBookId());
        repository.setBalance(book.getAmount());
        //3判断库存是否小于0
        if("out".equals(repository.getKind())){
            if(book.getAmount()<0){
                throw new RuntimeException("库存不足");
            }
        }

        //记录流水
        dao.insertRepository(repository);

    }

    public void queryForPage(PageInfo pageInfo){
        dao.selectCountForPage(pageInfo);
        dao.selectForPage(pageInfo);
    }
}
