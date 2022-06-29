package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet", value = "/zip.action")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String > map = new HashMap<String,String>();
        String code=request.getParameter("code");
        System.out.println(code);
        map.put("10001","北京,天安门");
        String data="";
        if(map.containsKey(code)){
            data = map.get(code);
            System.out.println(data);
        }else {
            data="null,null";
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(data);
    }
}
