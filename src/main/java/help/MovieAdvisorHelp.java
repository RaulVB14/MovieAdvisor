package help;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
public class MovieAdvisorHelp {

    private String help;

    @PostConstruct
    public void init() {
        try {
            help = Files.lines(Paths.get(ResourceUtils.getFile("classpath:ayuda.txt").toURI()))
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            System.err.println("Error cargando la ayuda");
            System.exit(-1);
        }
    }

    public String getHelp() {
        return help;
    }
}
