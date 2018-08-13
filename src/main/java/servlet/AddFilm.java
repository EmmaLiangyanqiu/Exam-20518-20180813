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
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Emma on 2018/8/13.
 */
public class AddFilm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addFile(req,resp);
    }
    public void addFile(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        try {
            httpServletRequest.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpServletResponse.setCharacterEncoding("utf-8");
        HttpSession session=httpServletRequest.getSession();
        String title=httpServletRequest.getParameter("title");
        String description=httpServletRequest.getParameter("description");
        String lan=httpServletRequest.getParameter("language");
        System.out.println(title+description+lan);
        Film film=new Film();
        film.setLanguage(lan);
        film.setTitle(title);
        film.setDescription(description);
        FilmDao filmDao=new FilmDaoImpl();
        filmDao.addFilm(film);


        List<Film> films=filmDao.getAll();
        session.setAttribute("filmlist",films);
        try {
            httpServletRequest.getRequestDispatcher("film_list.jsp").forward(httpServletRequest,httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
