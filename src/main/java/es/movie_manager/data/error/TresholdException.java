package es.movie_manager.data.error;

import java.io.IOException;

/**
 * @author manana
 **/
public class TresholdException extends IOException {
    public TresholdException(String message) {
        super(message);
    }

    public TresholdException() {
        super("El valor debe estar entre " +  MINIMUMSIZE + " y " + MAXIMUMSIZE);
    }

    public static final int MAXIMUMSIZE = 100;
    public static final int MINIMUMSIZE = 0;


}
