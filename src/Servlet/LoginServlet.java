package Servlet;

import Dao.AdminDao;
import Entity.Admin;
import Service.AdminService;
import com.oracle.jdbc.util.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/admin/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adminName=request.getParameter("adminName");
        String password=request.getParameter("password");
        System.out.println("adminName: "+adminName);
        System.out.println("password: "+password);

        AdminService service= ServiceFactory.getObject(AdminService.class);
        Admin admin=service.login(adminName,password);

        if(admin!=null){
            //如果登录成功 将管理员信息存在session中

            HttpSession session=request.getSession();
            System.out.println("sessionId: "+session.getId());
            System.out.println("isNew: "+session.isNew());
            System.out.println("lasAccessTime: "+new Date(session.getLastAccessedTime()));
            System.out.println("createTime: "+new Date(session.getCreationTime()));
            System.out.println("maxAge: "+session.getMaxInactiveInterval());

            //
            session.setAttribute("admin",admin);
            request.getRequestDispatcher("index.html").forward(request, response);

        }else {
            response.sendRedirect("login.jsp");
        }
    }
}
