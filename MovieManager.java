package es.movie_manager.data;

import es.movie_manager.data.error.TresholdException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author manana
 **/
public class MovieManager {
    public static List<Movie> catalogo;

    static {
        try {
//            catalogo =  MovieAPI.obtenerPeliculas();
//            Set<Movie> catalogoSinDuplicados = new HashSet<>(catalogo);
//            catalogoSinDuplicados.addAll(MovieCsv.cargar(Path.of("movies_300.csv")));
//            catalogo = new ArrayList<>(catalogoSinDuplicados);

            catalogo = new ArrayList<>(MovieCsv.cargar(Path.of("movies_300.csv")));
            MovieAPI.obtenerPeliculas().stream()
                    .filter(m -> !catalogo.contains(m))
                    .forEach(m -> catalogo.add(m));


        } catch (IOException | InterruptedException e) {
            System.err.println("Fallo en la API" + e);
        }
    }

    public List<Movie> getTopMovies(int limit){
        if(limit > TresholdException.MAXIMUMSIZE || limit < TresholdException.MINIMUMSIZE){
            throw new TresholdException("El valor debe estar entre 0 y 100");
        }
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

    public List<Movie> getMoviesForYear(int year){
        return catalogo.stream()
                .filter((Movie m) -> m.getYear() == year)
                .toList();
    }

    public String[] getImagesForYear(List<Movie> movies){
        return  movies.stream()
                .map(Movie::getImage_url)
//                .toArray() nos devuelve un Array de Object
                .toArray(String[]::new);
    }

    public String[] getImages(int year){
        return  getImagesForYear(getMoviesForYear(year));
    }

    public List<Movie> getMovieWithId(int id){
        return catalogo.stream()
                .filter((Movie m) -> m.getId() == id)
                .toList();
    }

    public  void printMovies(List<Movie> m){
        m.stream()
                .forEach(System.out::println);
    }

    public int getSkipAndLongestTitle(int skip) throws InputMismatchException{
        if(skip > TresholdException.MAXIMUMSIZE || skip < TresholdException.MINIMUMSIZE){
            throw new TresholdException("El valor debe estar entre 0 y 100");
        }
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
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));
    }

    public Map<String, Double> getAverageStarsByGenre(){
        return catalogo.stream()
                .flatMap(m -> Arrays.stream(m.getGenre())
                        .map(g -> Map
                                .entry(g, m.getStars()))
                )
                .collect(Collectors
                        .groupingBy(
                            Map.Entry::getKey,
                            Collectors.averagingDouble(entry -> entry.getValue())
                        ));
    }
//
//   public void showYearMostMovie(){
//       Map.Entry<Integer, Long> obj = getYearMostMovie();
//       System.out.println(obj.getKey() + ":" + obj.getValue());
//   }

   public void getYearMostMovie(){
        catalogo.stream()
                .collect(Collectors.groupingBy(Movie::getYear,
                        Collectors.counting()))
                .entrySet()
                .stream()
//                .max((x,y) -> (int) (x.getValue() - y.getValue()))
                .max(Map.Entry.comparingByValue())
//                .get();
                .ifPresent(System.out::println);
   }

    public Map<Boolean, List<Movie>>  reviewMovies(double nota){
        return catalogo.stream()
                .sorted(Comparator.comparing((Movie m) -> m.getStars()).reversed())
                .collect(Collectors
                        .partitioningBy(m -> m.getStars() >= nota));
    }


}
