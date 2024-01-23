package pojos;



import daos.FilmDAO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Film;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import utils.JHibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static utils.LeerCSV.lecturaCSV;

@Repository
public class FilmPOJO implements FilmDAO {
    public static ArrayList<Film> peliculas = new ArrayList<>();


    //Cargar Peliculas
    public List<Film> init() {
        peliculas= (ArrayList<Film>) lecturaCSV();

        return peliculas;
    }


    @Override
    public Film findById(int id) {
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> query = cb.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);

            query.select(root);
            query.where(cb.equal(root.get("id"), id));

            return session.createQuery(query).uniqueResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }


    @Override
    public Collection<Film> findAll() {
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            //el cb nos permite realizar modificaciones sobre el select que vamos a hacer
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> query = cb.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            //root = FROM Estudiantes
            query.select(root.get("id,titulo,year,generos"));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public void insert(Film film) {
        Transaction tx = null;
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            //Asi creamos el objeto Estudiante el CHATGPT da .safe y asi no funciona
            tx = session.beginTransaction(); //Inicalizamos transaccion
            session.persist(film); //Hacemos el insert
            tx.commit(); //Finalizamos transaccion
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback(); //Esto lo deshace por si ocurre algun fallo
            }
            System.err.println(ex);
        }
    }

    @Override
    public void update(Film film) {
        Transaction tx = null;
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            if (film.getId() != 0) {
                session.merge(film);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public void delete(int id) {
        Transaction tx = null;
        try (Session session = JHibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Film peli = session.get(Film.class, id); //select de estudiantes por ID
            if (peli != null) {
                session.remove(peli);
            }
            tx.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private int getIndexof(int id) {
        boolean encontrado = false;
        int index = 0;

        while (!encontrado && index < peliculas.size()) {
            if (peliculas.get(index).getId() == id) {
                encontrado = true;
            } else {
                index++;
            }
        }
        //Devolvemos encontrado y en caso contrario devolvemos -1
        return (encontrado) ? index : -1;
    }
}
