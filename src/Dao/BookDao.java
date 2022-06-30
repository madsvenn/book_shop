package Dao;

import com.oracle.jdbc.util.Dao;
import Entity.Book;

import java.util.List;
import java.util.Map;

public class BookDao {

    public List<Book> selectAll(){

        String sql="SELECT * FROM TB_BOOK";
        return Dao.query(sql,Book.class);
    }

    public void insert(Book book){
        String sql="INSERT INTO TB_BOOK VALUES(null,?,?,?,?,?,?,?)";

        Dao.executeSql(sql,book.getCategoryId(),book.getBookName(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getSalePrice(),0);

    }
    public void Delete(Integer BookId){

        String sql="DELETE FROM TB_BOOK WHERE BOOK_ID=?";
        Dao.executeSql(sql,BookId);
    }
    public void update(Book book){
        String sql="UPDATE TB_BOOK SET CATEGORY_ID =?, BOOK_NAME= ?, AUTHOR= ?, PUBLISHER = ?, PRICE= ? ,SALE_PRICE = ? WHERE BOOK_ID = ?";
        Dao.executeSql(sql, book.getCategoryId(),book.getBookName(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getSalePrice(),book.getBookId());
    }
    public Book get_one_book(Integer bookId){
        String sql="SELECT * FROM TB_BOOK WHERE BOOK_ID = ?";
        return Dao.queryOne(sql,Book.class,new Object[]{bookId});
    }

    public List<Map<String,Object>>selectRepositories(){
        String sql = "SELECT book_name,\n" +
                "CASE \n" +
                "\tWHEN kind='in' THEN '入库'\n" +
                "\tELSE \n" +
                "\t\t'出库'\n" +
                "END kind,count,balance,execute_time,operator from tb_repository r INNER JOIN tb_book b ON r.book_id=b.book_id;\n";
        return Dao.queryToMap(sql,new Object[]{});
    }
}
