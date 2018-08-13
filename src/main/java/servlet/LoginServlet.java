package servlet;

import dao.UserDao;
import dao.UserDaoIMmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Emma on 2018/8/13.
 */


public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req,resp);
    }

    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        HttpSession session=httpServletRequest.getSession();
        String name=httpServletRequest.getParameter("name");
        UserDao userDao=new UserDaoIMmpl();
       if(userDao.login(name)==true){
           session.setAttribute("name",name);
           RequestDispatcher dispatcher =  httpServletRequest.getRequestDispatcher("/film");
           try {
               dispatcher.forward(httpServletRequest, httpServletResponse);
           } catch (ServletException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }else{
           try {
               httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest,httpServletResponse);
           } catch (ServletException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

    }

}
