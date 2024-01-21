package MovieAdvisor;

import model.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pojos.FilmPOJO;

import java.util.List;

@SpringBootApplication
public class MovieAdvisorApplication {

    public static void main(String[] args) {

        SpringApplication.run(MovieAdvisorApplication.class, args);
        List<Film> pelis;
        FilmPOJO fp = new FilmPOJO();
//        pelis = fp.init();
//        for (Film m : pelis) {
//			fp.insert(m);
//        }

    }

}
