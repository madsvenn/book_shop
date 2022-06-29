package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String methodName = request.getParameter("method");
        if(!methodName.equals(null)){
            Class clazz = this.getClass();

            try {
                Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
                try {
                    method.invoke(this,request,response);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                response.sendRedirect(request.getServletContext().getContextPath()+"/admin/500.html");
            }
        }else{
            response.sendRedirect(request.getServletContext().getContextPath()+"/admin/500.html");
        }
    }

}
