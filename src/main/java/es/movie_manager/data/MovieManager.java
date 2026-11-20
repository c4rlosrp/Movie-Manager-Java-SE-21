package es.movie_manager.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Movie> getTopMovies(int limit){
        return catalogo.stream()
                .sorted(Comparator.comparing((Movie m) -> m.getStars()).reversed())
                .limit(limit)
                .toList() // Lista Inmutable
                //.collect(Collectors.toList()) // si lo usamos  la lista sería Mutable
                ;
    }

    public void  showTop5Movies(){
        getTopMovies(5).forEach(m -> System.out.println(m.getTitle() + " - " + m.getStars()));
    }

    public List<Movie> getYearsMovies(int year){
        return catalogo.stream()
                .
    }


}
