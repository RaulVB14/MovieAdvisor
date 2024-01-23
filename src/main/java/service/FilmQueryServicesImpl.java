package service;


import daos.FilmDAO;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Film;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import utils.JHibernateUtil;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

@Service
public class FilmQueryServicesImpl implements FilmQueryService {

   // private FilmDAO dao;

    @PostConstruct
    public void init() {
        Predicate<Film> predicate = null;
    }

    @Override
    public Collection<Film> exec() {
        return null;
    }

    @Override
    public FilmQueryService anyGenre(List<String> genres) {
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> query = cb.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            query.select(root.get("genres")).where(cb.equal(root.get("genres"), genres));
            return (FilmQueryService) session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public FilmQueryService allGenre(List<String> genres) {
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> query = cb.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            query.select(root.get("genres"));
            return (FilmQueryService) session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public FilmQueryService year(String year) {
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> query = cb.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            query.select(root.get("year")).where(cb.equal(root.get("year"), year));
            return (FilmQueryService) session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public FilmQueryService betwennYears(String from, String to) {
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> query = cb.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            //no se como hacer el between


            List<Film> films = session.createQuery(query).getResultList();
            return (FilmQueryService) films;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public FilmQueryService titleContains(String title) {
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> query = cb.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            query.select(root.get("nombre")).where(cb.equal(root.get("title"), title));
            return (FilmQueryService) session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
