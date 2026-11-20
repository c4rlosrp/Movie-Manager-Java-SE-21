package es.movie_manager.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author manana
 **/
public class MovieManager {
    public static List<Movie> catalogo;

    static {
        try {
            catalogo = MovieAPI.obtenerPeliculas();
        } catch (IOException | InterruptedException e) {
            System.err.println("Fallo en la API: " + e);
        }
    }


}
