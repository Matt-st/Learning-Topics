import java.util.*;

public class MovieSortingExampleThree {

    static void sortList( List<Movie> movieList) {



        Collections.sort(movieList, new MovieChainedComparator(
                new MovieRatingComparator().reversed(),
                new MovieTitleComparator()

        ));

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


class MovieChainedComparator implements Comparator<Movie> {
    private List<Comparator<Movie>> listComparators;
    @SafeVarargs
    public MovieChainedComparator(Comparator<Movie>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
    @Override
    public int compare(Movie m1, Movie m2) {
        for (Comparator<Movie> comparator : listComparators) {
            int result = comparator.compare(m1, m2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}

 class MovieTitleComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.title.compareTo(m2.title);
    }
}

class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return Integer.compare(m1.rating, m2.rating);
    }
}