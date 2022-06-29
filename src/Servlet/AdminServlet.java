package Servlet;

import Entity.Admin;
import Entity.Book;
import Service.AdminService;
import com.oracle.jdbc.util.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin/admin.do")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        AdminService service= ServiceFactory.getObject(AdminService.class);
        String flag=request.getParameter("flag");

        Admin loginAdmin=(Admin) request.getSession().getAttribute("admin");
        //重定向
        HttpSession session=request.getSession();
        if(loginAdmin==null){
            String contextPath=request.getServletContext().getContextPath();
            System.out.println(contextPath);
            response.sendRedirect(contextPath+"/admin/login.html");
        }
        if("add".equals(flag)){
            String name=request.getParameter("adminName");
            String password=request.getParameter("password");
            String realName=request.getParameter("realName");
            Admin admin=new Admin();

            admin.setAdminName(name);
            admin.setRealName(realName);
            admin.setPassword(password);
            admin.setOperator(loginAdmin.getAdminName());

            service.save(admin);
            response.sendRedirect("admin.do?flag=list");
        }else if("remove".equals(flag)){
            Integer adminId=Integer.valueOf(request.getParameter("adminId"));
            service.delete(adminId);
            response.sendRedirect("admin.do?flag=list");
        }else if("list".equals(flag)){

            List<Admin> list=service.getAll();
            PrintWriter out=response.getWriter();
            out.println("<html>\n" +
                    "  <head>\n" +
                    "    <title>管理员列表</title>\n" +
                    "  </head>\n" +
                    "  <body>\n");

            out.println("<table width=\'90%\' border='1'>\n" +
                    "    <tr>\n" +
                    "      <th>管理员名称</th>\n" +
                    "      <th>真实姓名</th>\n" +
                    "      <th>登录次数</th>\n" +
                    "      <th>操作者</th>\n" +
                    "      <th>创建时间</th>\n" +
                    "      <th>最后登录时间</th>\n" +
                    "    </tr>");
            for (Admin b:
                    list) {
                out.println("<tr>");
                out.println("<td >"+b.getAdminName()+"</td>");
                out.println("<td>"+b.getRealName()+"</td>");
                out.println("<td>"+b.getAccessCount()+"</td>");
                out.println("<td>"+b.getOperator()+"</td>");
                out.println("<td>"+b.getCreate_time()+"</td>");
                out.println("<td>"+b.getLast_access_time()+"</td>");
                out.println("<td>"+"<a href='admin.do?adminId="+b.getAdminID()+"&flag=remove'>删除"+"</th>");
                out.println("</tr>");
            }
            out.println("</table><br>");

            out.println("<a href='addAdmin.html'>添加管理员</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}
