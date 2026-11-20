package es.movie_manager;

import es.movie_manager.data.MovieManager;

/**
 * @author manana
 **/
public class Main {
    public static void main(String[] args){
        MovieManager mm = new MovieManager();
        String bold = "\u001B[1m";
        String reset = "\u001B[0m";
        System.out.println(" Ejercio 1: " + bold
                + "Las 5 películas mejor valoradas."
                + reset );

        mm.showTop5Movies();
    }
}
