package dao;

import entity.Film;
import entity.Language;

import java.util.List;

/**
 * Created by Emma on 2018/8/13.
 */
public interface FilmDao {
    public List<Film> getAll();
    public List<Language> getLans();
    public void addFilm(Film film);
    void deleteFilm(String id);
    void updateFilm(Film film);
}
