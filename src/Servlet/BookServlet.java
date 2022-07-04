package Servlet;

import Entity.Admin;
import Entity.Book;
import Entity.Repository;
import Service.BookService;
import Service.CategoryService;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.jdbc.util.Transactional;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.List;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "BookServlet", urlPatterns = "/admin/book.do")
public class BookServlet extends BaseServlet {

    BookService bookService = ServiceFactory.getObject(BookService.class);
    CategoryService categoryService = ServiceFactory.getObject(CategoryService.class);

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> list = bookService.getBooks();

        request.setAttribute("list", list);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
    }


    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
        String publisher = request.getParameter("publisher");
        Integer price = Integer.valueOf(request.getParameter("price"));
        Integer salPrice = Integer.valueOf(request.getParameter("salePrice"));
        Book book = new Book(categoryId, bookName, author, publisher, price, salPrice);

        bookService.save(book);

        //3
        response.sendRedirect("book.do?method=list");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        bookService.delete(bookId);
        response.sendRedirect("book.do?method=list");
    }

    public void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        Book book = bookService.select_one_book(bookId);
        request.setAttribute("book", book);
        request.setAttribute("categoryList", categoryService.getAll());
        request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId=request.getParameter("bookId");
        System.out.println(bookId);
        Book book = bookService.select_one_book(Integer.valueOf(bookId));

        String bookName=request.getParameter("bookName");
        if(bookName.length()>0&&bookName!=book.getBookName()){
            book.setBookName(bookName);
        }
        String author=request.getParameter("author");
        System.out.println(author.length());
        if(author.length()>0&&author!=book.getAuthor()){
            book.setAuthor(author);
        }
        if(request.getParameter("categoryId").length()>0){
            Integer categoryId=Integer.valueOf(request.getParameter("categoryId"));
            if(categoryId!=book.getCategoryId()){
                book.setCategoryId(categoryId);
            }
        }

        String publisher=request.getParameter("publisher");
        if(publisher.length()>0&&publisher!=book.getPublisher()){
            book.setPublisher(publisher);
        }
        if(request.getParameter("price").length()>0) {
            Integer price = Integer.valueOf(request.getParameter("price"));
            if(price!=book.getPrice()){
                book.setPrice(price);
            }
        }
        if(request.getParameter("salePrice").length()>0){
            Integer salPrice=Integer.valueOf(request.getParameter("salePrice"));
            if(salPrice!=book.getSalePrice()){
                book.setSalePrice(salPrice);
            }
        }
        bookService.update(book);
        response.sendRedirect("book.do?method=list");
    }

    public void listRepositories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Map<String,Object>> list = bookService.selectRepositories();

        request.setAttribute("list", list);
        request.getRequestDispatcher("bookRepositoryList.jsp").forward(request, response);
    }

    public void viewRepositories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> list = bookService.getBooks();
        request.setAttribute("list",list);
        request.getRequestDispatcher("bookRepository.jsp").forward(request,response);
    }

    public void repositories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Repository repository = new Repository();

        repository.setBookId(Integer.valueOf(request.getParameter("bookId")));
        repository.setCount(Integer.valueOf(request.getParameter("count")));
        repository.setKind(request.getParameter("kind"));

        Admin admin =(Admin) request.getSession().getAttribute("admin");
        repository.setOperator(admin.getAdminName());

        bookService.repository(repository);

        response.sendRedirect("book.do?method=listRepositories");

    }
}
