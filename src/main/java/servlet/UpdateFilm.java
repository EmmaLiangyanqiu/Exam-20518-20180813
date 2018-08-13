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
public class UpdateFilm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String film_id = (String) session.getAttribute("film_id");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String lan=req.getParameter("language");
        System.out.println(film_id + title+description+lan);
        Film film=new Film();
        film.setDescription(description);
        film.setTitle(title);
        film.setLanguage(lan);
        film.setFilm_id(Integer.parseInt(film_id));
        FilmDao filmDao=new FilmDaoImpl();
        filmDao.updateFilm(film);

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
