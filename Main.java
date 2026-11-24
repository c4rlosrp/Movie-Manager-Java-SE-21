package es.movie_manager;

import es.movie_manager.data.MovieCsv;
import es.movie_manager.data.MovieManager;

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
    public static void main(String[] args){
        MovieManager mm = new MovieManager();

        String bold = "\u001B[1m";
        String reset = "\u001B[0m";
        System.out.println(bold
                + " Ejercio 1: Las 5 películas mejor valoradas."
                + reset );

        mm.getTopMovies(5);

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
                + reset );
        System.out.println(mm.getSkipAndLongestTitle(3));
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
        MiReader2 r2 = new MiReader2();

        try(Scanner sc = new Scanner(System.in);
            r2;
            MiReader r = new MiReader()
            ){

            System.out.println(divide(sc));
            System.out.println(divide(sc));
        } catch (Exception e) {
            System.err.println(e);
        }
        //r2 = new MiReader2();
        System.out.println("Ultima línea");

    }
    static class MiReader implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("Me cierro");
        }

    }

    static class MiReader2 implements Closeable {

        @Override
        public void close() {
            System.out.println("Yo tambien");
        }

    }
    public static int divide(Scanner sc){
        int dividendo, divisor, result = 0;

        try {

            System.out.println("Calculadora que divide, dame el dividendo: ");
            dividendo = sc.nextInt();

            System.out.println("Ahora dame el divisor: ");
            divisor = Integer.parseInt(sc.next());

            result = dividendo/divisor;
            System.out.println(result);
            System.out.println("Mensaje post division");

            return result;
        } catch (InputMismatchException | NumberFormatException | ClassCastException e ){
            System.err.println("Debes introducir un numero entero correcto");
//            System.exit(0);
            //Runtime.getRuntime().halt(int status);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage() + " No se puede dividir entre 0");

        }
//        finally {
//            sc.close();
//            result = 10;
//            System.out.println("Estoy en finally");
//        }

        return result;
    }

}

