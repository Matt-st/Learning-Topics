import java.util.*;

public class MovieSortingExampleOne {

    static void sortList( List<Movie> movieList) {
        Comparator<Movie> sortingByTitle =
                (Movie m1, Movie m2)->m1.title.compareTo(m2.title);

        Collections.sort(movieList, sortingByTitle);

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

class Movie {
    public String title;
    public int rating;
    Movie (String title, int rating){
        this.title = title;
        this.rating = rating;
    }
}

