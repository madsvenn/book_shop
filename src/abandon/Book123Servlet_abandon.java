package abandon;

import Entity.Book;
import Service.BookService;
import com.oracle.jdbc.util.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BookServlet_abandon", value = "/admin/book123456.do")
public class Book123Servlet_abandon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String flag=request.getParameter("flag");
        if(flag.equals("List")){
            BookService service= ServiceFactory.getObject(BookService.class);
            List<Book> bookList=service.getBooks();

            response.setContentType("text/html;charset=utf-8");

            PrintWriter out=response.getWriter();
            out.println("<html>\n" +
                    "  <head>\n" +
                    "    <title>Book</title>\n" +
                    "  </head>\n" +
                    "  <body>\n");

            out.println("<table width=\'90%\' border='1'>\n" +
                    "    <tr>\n" +
                    "      <th>图书编号</th>\n" +
                    "      <th>图书名称</th>\n" +
                    "      <th>作者</th>\n" +
                    "      <th>出版社</th>\n" +
                    "      <th>价格</th>\n" +
                    "      <th>数量</th>\n" +
                    "      <th>操作</th>\n" +
                    "    </tr>");
            for (Book b:
                    bookList) {
                out.println("<tr>");
                out.println("<td >"+b.getBookId()+"</td>");
                out.println("<td>"+b.getBookName()+"</td>");
                out.println("<td>"+b.getAuthor()+"</td>");
                out.println("<td>"+b.getPublisher()+"</td>");
                out.println("<td>"+b.getPrice()+"</td>");
                out.println("<td>"+b.getAmount()+"</td>");
                out.println("<td>"+"<a href='book.do?flag=view&bookId="+b.getBookId()+"'>修改</td>");
                out.println("<td>"+"<a href='book.do?flag=delete&bookId="+b.getBookId()+"'>删除</td>");
                out.println("</tr>");
            }
            out.println("</table><br>");

            out.println("<a href='addBook.html'>添加</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }else if(flag.equals("delete")){
            request.setCharacterEncoding("UTF-8");
            Integer bookId=Integer.valueOf(request.getParameter("bookId"));
            BookService service= ServiceFactory.getObject(BookService.class);
            service.delete(bookId);
            response.setContentType("text/html;charset=UTF-8");
            System.out.println("删除成功");
            response.sendRedirect("book.do?flag=List");

        }else if(flag.equals("add")){
            request.setCharacterEncoding("UTF-8");
            String bookName=request.getParameter("bookName");
            String author=request.getParameter("author");
            Integer categoryId=Integer.valueOf(request.getParameter("categoryId"));
            String publisher=request.getParameter("publisher");
            Integer price=Integer.valueOf(request.getParameter("price"));
            Integer salPrice=Integer.valueOf(request.getParameter("salPrice"));

            Book book=new Book(categoryId,bookName,author,publisher,price,salPrice);
            BookService service= ServiceFactory.getObject(BookService.class);
            service.save(book);

            response.sendRedirect("book.do?flag=List");

        }else if(flag.equals("view")){
            String bookId=request.getParameter("bookId");
            response.setContentType("text/html;charset=utf-8");
            BookService service=ServiceFactory.getObject(BookService.class);
            Book b=service.select_one_book(Integer.valueOf(bookId));
            PrintWriter out=response.getWriter();
            out.println("<html>\n" +
                    "  <head>\n" +
                    "    <title>Book</title>\n" +
                    "  </head>\n" +
                    "  <body>\n");

            out.println("<table width=\'90%\' border='1'>\n" +
                    "    <tr>\n" +
                    "      <th>图书编号</th>\n" +
                    "      <th>图书名称</th>\n" +
                    "      <th>作者</th>\n" +
                    "      <th>出版社</th>\n" +
                    "      <th>价格</th>\n" +
                    "      <th>数量</th>\n" +
                    "      <th>操作</th>\n" +
                    "    </tr>");

            out.println("<tr>");
            out.println("<td >"+b.getBookId()+"</td>");
            out.println("<td>"+b.getBookName()+"</td>");
            out.println("<td>"+b.getAuthor()+"</td>");
            out.println("<td>"+b.getPublisher()+"</td>");
            out.println("<td>"+b.getPrice()+"</td>");
            out.println("<td>"+b.getAmount()+"</td>");
            out.println("</tr>");
            request.setAttribute("bookId",b.getBookId());
            request.setAttribute("bookName",b.getBookName());
            request.setAttribute("author",b.getAuthor());
            request.setAttribute("categoryId",b.getCategoryId());
            request.setAttribute("publisher",b.getPublisher());
            request.setAttribute("price",b.getPrice());
            request.setAttribute("salePrice",b.getSalePrice());

            request.getRequestDispatcher("saveBook.jsp").forward(request,response);
        }else if(flag.equals("save")){

            String bookId=request.getParameter("bookId");
            System.out.println(bookId);
            request.setCharacterEncoding("UTF-8");
            BookService service= ServiceFactory.getObject(BookService.class);
            Book book = service.select_one_book(Integer.valueOf(bookId));

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
            if(request.getParameter("salPrice").length()>0){
                Integer salPrice=Integer.valueOf(request.getParameter("salPrice"));
                if(salPrice!=book.getSalePrice()){
                    book.setSalePrice(salPrice);
                }
            }
            service.update(book);
            response.sendRedirect("book.do?flag=List");
        }
    }
}
