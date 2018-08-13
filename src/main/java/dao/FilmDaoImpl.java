package dao;

import entity.Film;
import entity.Language;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emma on 2018/8/13.
 */
public class FilmDaoImpl implements FilmDao {
    Connection conn= DBUtils.getCon();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Film> getAll() {
        List<Film> list=new ArrayList<Film>();
        String sql="select * from film";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();

            while (rs.next()){
                Film film=new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setLanguage(rs.getString("language"));
                list.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Language> getLans() {
        List<Language> languageList=new ArrayList<Language>();
        String sql="select * from language";
        try {
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Language language=new Language();
                language.setLanguage_id(rs.getInt("language_id"));
                language.setLanguage_name(rs.getString("language_name"));
                languageList.add(language);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return languageList;
    }

    @Override
    public void addFilm(Film film) {
        String sql="insert into  film (title,description,language) values(?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getDescription());
            ps.setString(3, film.getLanguage());
            int count=ps.executeUpdate();
            System.out.println("添加了"+count+"记录");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFilm(String id) {
        String sql="delete from film where film_id='"+id+"'";
        try {
            ps=conn.prepareStatement(sql);
           int count= ps.executeUpdate();
            System.out.println("更新了"+count+"记录");
        } catch (SQLException e) {
        }
    }

    @Override
    public void updateFilm(Film film) {
        System.out.println(film.getTitle());
        System.out.println(film.getFilm_id());
        String sql="update film set title='"+film.getTitle()+"',description='"+film.getDescription()+"',language='"+film.getLanguage()+"'" +
                " where film_id='"+film.getFilm_id()+"'";
        try {
            ps=conn.prepareStatement(sql);
           int count= ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
