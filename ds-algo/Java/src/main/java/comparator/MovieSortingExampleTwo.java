import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieSortingExampleTwo {

    static void sortList( List<Movie> movieList) {
        Comparator<Movie> sortingByRating =
                (Movie m1, Movie m2)->Integer.compare(m1.rating, m2.rating);

        Collections.sort(movieList, sortingByRating);

        for(int i = 0; i < movieList.size(); i++){
            System.out.println(" " + movieList.get(i).title + " " + movieList.get(i).rating);
        }
    }

    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Apples", 4));
        movieList.add(new Movie("Rainman", 4));
        movieList.add(new Movie("Godzilla", 2));
        movieList.add(new Movie("Queen of the South", 4));
        movieList.add(new Movie("Hitman", 3));
        movieList.add(new Movie("Hitman", 2));
        movieList.add(new Movie("Godzilla", 3));
        movieList.add(new Movie("Moana", 4));
        sortList(movieList);
    }
}
