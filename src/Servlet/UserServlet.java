package Servlet;

import Entity.Admin;
import Entity.User;
import Service.UserService;
import com.oracle.jdbc.util.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/admin/user.do")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserService service= ServiceFactory.getObject(UserService.class);
        Admin loginAdmin=(Admin) request.getSession().getAttribute("admin");
        //重定向
        if(loginAdmin==null){
            String contextPath=request.getServletContext().getContextPath();
            System.out.println(contextPath);
            response.sendRedirect(contextPath+"/admin/login.html");
        }
        String flag=request.getParameter("flag");
        if(flag.equals("add")){
            String name=request.getParameter("userName");
            String realName=request.getParameter("realName");
            String password=request.getParameter("password");
            String phone=request.getParameter("phone");
            String remain=request.getParameter("remain");

            HttpSession session=request.getSession();
            Admin admin= (Admin) session.getAttribute("admin");
            User user=new User();
            user.setOperator(admin.getAdminName());
            user.setUserName(name);
            user.setRealName(realName);
            user.setPassword(password);
            user.setPhone(phone);
            user.setRemain(Integer.valueOf(remain));

            service.insert(user);

            response.sendRedirect("user.do?flag=select");
        }else if(flag.equals("delete")){

            String userId=request.getParameter("userId");
            service.delete(Integer.valueOf(userId));
            response.sendRedirect("user.do?flag=select");
        }else if(flag.equals("select")){

            List<User> list=service.getUser();
            PrintWriter out=response.getWriter();
            out.println("<html>\n" +
                    "  <head>\n" +
                    "    <title>用户列表</title>\n" +
                    "  </head>\n" +
                    "  <body>\n");

            out.println("<table width=\'90%\' border='1'>\n" +
                    "    <tr>\n" +
                    "      <th>用户名</th>\n" +
                    "      <th>真实姓名</th>\n" +
                    "      <th>密码</th>\n" +
                    "      <th>电话</th>\n" +
                    "      <th>remain</th>\n" +
                    "      <th>operator</th>\n" +
                    "      <th>创建时间</th>\n" +
                    "    </tr>");
            for (User b:
                    list) {
                out.println("<tr>");
                out.println("<td>"+b.getUserName()+"</td>");
                out.println("<td>"+b.getRealName()+"</td>");
                out.println("<td>"+b.getPassword()+"</td>");
                out.println("<td>"+b.getPhone()+"</td>");
                out.println("<td>"+b.getRemain()+"</td>");
                out.println("<td>"+b.getOperator()+"</td>");
                out.println("<td>"+b.getCreateTime()+"</td>");
                out.println("<td>"+"<a href='user.do?userId="+b.getUserId()+"&flag=delete'>删除"+"</th>");
                out.println("</tr>");
            }
            out.println("</table><br>");

            out.println("<a href='addUser.html'>添加用户</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}
