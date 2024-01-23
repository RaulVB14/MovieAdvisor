package service;


import model.Film;

import java.util.Collection;
import java.util.List;

public interface FilmQueryService {
    public Collection<Film> exec();
    public FilmQueryService anyGenre(List<String> genres);
    public FilmQueryService allGenre(List<String> genres);
    public FilmQueryService year(String year);
    public FilmQueryService betwennYears(String from, String to);
    public FilmQueryService titleContains(String title);

}
