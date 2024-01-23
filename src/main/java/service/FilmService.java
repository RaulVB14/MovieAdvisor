package service;


import daos.FilmDAO;
import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    FilmDAO filmDao;

    @Autowired
    FilmQueryService queryService;

//    public Collection<String> findAllGenres(){
//        List<String> result = null;
//        result = filmDao.findAll()
//                .stream()
//                .map( film -> film.getGenres())
//                .flatMap(lista -> lista.stream())
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//
//        return result;
//
//    }

    public Collection<Film> findAll() {

        return filmDao.findAll();
    }

    public Collection<Film> findByAnyGenre(List<String> genres) {
        return queryService.anyGenre(genres).exec();
    }

    public Collection<Film> findByAllGenres(List<String> genres) {
        return queryService.allGenre(genres).exec();
    }

    public Collection<Film> findByYear(String year) {
        return queryService.year(year).exec();
    }

    public Collection<Film> findBetweenYears(String from, String to) {
        return  queryService.betwennYears(from, to).exec();
    }

    public Collection<Film> findByTitle(String title) {
        return queryService.titleContains(title).exec();
    }

}
