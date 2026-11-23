package es.movie_manager.data;

import java.io.IOException;
import java.util.*;
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
                .filter((Movie m) -> m.getYear() == year)
                .toList();
    }
    public List<Movie> getMovieWithId(){
        return catalogo.stream()
                .filter((Movie m) -> m.getId() == 1)
                .toList();
    }

    public int getSkipAndLongestTitle(int skip){
        return catalogo.stream()
                .skip(skip)
                .mapToInt(m -> m.getTitle().length())
                .max()
                .orElse(0);
    }

    public boolean areLimitedMoviesAboveStars(int limit, double minStars){
        return catalogo.stream()
                .limit(limit)
                .allMatch((Movie m) -> m.getStars() >= minStars);
    }

    public Map<String, Long> getMoviesByGenre(){
        return catalogo.stream()
                .flatMap(m -> Arrays.stream(m.getGenre()))
                .collect(Collectors.groupingBy(g -> g, TreeMap::new, Collectors.counting()));
    }

    public Map<String, Double> getAverageStarsByGenre(){
        return catalogo.stream()
                .flatMap(m -> Arrays.stream(m.getGenre()).map(g -> Map.entry(g, m.getStars())))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
    }
}
