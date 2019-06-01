package lesson14;

import java.util.*;

public class SortExample {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add (new Movie("C", 5.2));
        movies.add (new Movie("AB", 6.3));
        movies.add (new Movie("AC", 5.4));
        movies.add (new Movie("AG", 5.0));
        movies.add (new Movie("Hi", 5));
        movies.add (new Movie("M", 7));
        for (Movie movie : movies){
            System.out.println(movie.score+ "  "+movie.title);
        }
        System.out.println();
        System.out.println();
        Collections.sort(movies, new MovieTitlesComparator());
        for (Movie movie : movies){
            System.out.println(movie.score+ "  "+movie.title);
        }
    }

}
