package es.movie_manager;

import es.movie_manager.data.MovieCsv;
import es.movie_manager.data.MovieManager;
import es.movie_manager.data.error.TresholdException;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author manana
 **/
public class Main {
    public static void main(String[] args) {
        MovieManager mm = new MovieManager();

        String bold = "\u001B[1m";
        String reset = "\u001B[0m";
        System.out.println(bold
                + " Ejercio 1: Las 5 películas mejor valoradas."
                + reset);

        try {
//            mm.getTopMovies(-1);
            System.out.println(mm.getSkipAndLongestTitle(-3));
        } catch (TresholdException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        mm.showTop5Movies();
//        System.out.println("=======================================================");
//
//        System.out.println(bold
//                + "Ejercicio 1.1: Obtener películas por año."
//                + reset );
//        System.out.println(Arrays.toString(mm.getImages(2026)));
//        System.out.println("=======================================================");
//
//        System.out.println(bold
//                + "Ejercicio 1.2: Buscar película por ID."
//                + reset );
//        mm.printMovies(mm.getMovieWithId(2));
//        System.out.println("=======================================================");
//
        System.out.println(bold
                + "Ejercicio 1.3: Saltar y obtener el título más largo."
                + reset);
        try {
            System.out.println(mm.getSkipAndLongestTitle(3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("=======================================================");
//
//        System.out.println(bold
//                + "Ejercicio 1.4: Limitamos y comprobamos nota."
//                + reset );
//        System.out.println(mm.areLimitedMoviesAboveStars(3, 2));
//        System.out.println("=======================================================");
//
//        System.out.println(bold
//                + "Ejercicio 2: Número de películas por género."
//                + reset );
//        System.out.println(mm.getMoviesByGenre());
//        System.out.println("=======================================================");
//
//        System.out.println(bold
//                + "Ejercicio 3. Nota media por género."
//                + reset );
//        System.out.println(mm.getAverageStarsByGenre());
//        System.out.println("=======================================================");
//
//        System.out.println(bold
//                + "Ejercicio 4. Año con mayor número de películas."
//                + reset );
//        mm.getYearMostMovie();
//        System.out.println("=======================================================");
//
//        System.out.println(bold
//                + "Ejercicio 5. Dividir las películas en base a su nota."
//                + reset );
//        System.out.println(mm.reviewMovies(2.5));
//        System.out.println("=======================================================");

    }

}

