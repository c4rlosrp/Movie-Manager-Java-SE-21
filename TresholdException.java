package es.movie_manager.data.error;

/**
 * @author manana
 **/
public class TresholdException extends RuntimeException {
    public TresholdException(String message) {
        super(message);
    }

    public static final int MAXIMUMSIZE = 100;
    public static final int MINIMUMSIZE = 0;


}
