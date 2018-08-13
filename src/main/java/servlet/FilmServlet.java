package servlet;

import dao.FilmDao;
import dao.FilmDaoImpl;
import dao.UserDao;
import dao.UserDaoIMmpl;
import entity.Film;
import entity.Language;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Emma on 2018/8/13.
 */
public class FilmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAll(req,resp);
    }

    public void getAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        HttpSession session=httpServletRequest.getSession();
        FilmDao filmDao=new FilmDaoImpl();
        List<Film> films=filmDao.getAll();
        List<Language> lans=filmDao.getLans();
        session.setAttribute("lans",lans);
        session.setAttribute("filmlist",films);
        try {
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest,httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
