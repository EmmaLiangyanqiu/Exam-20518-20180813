package servlet;

import dao.FilmDao;
import dao.FilmDaoImpl;
import entity.Film;

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
public class DeleteFilm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String film_id=req.getParameter("film_id");
        FilmDao filmDao=new FilmDaoImpl();
        filmDao.deleteFilm(film_id);

        List<Film> films=filmDao.getAll();
        session.setAttribute("filmlist",films);
        try {
            req.getRequestDispatcher("film_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
