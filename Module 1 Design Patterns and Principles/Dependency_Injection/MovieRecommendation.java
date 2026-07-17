class Movie {
    void recommend() {
        System.out.println("Watch Interstellar");
    }
}

public class Main {
    public static void main(String[] args) {

        Movie movie = new Movie(); // dependency

        movie.recommend();
    }
}