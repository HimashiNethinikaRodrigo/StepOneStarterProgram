import model.Movie;
import model.Rater;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
//            final List<model.Movie> movieListShort = loadMovies("./data/ratedmovies_short.csv");
//            System.out.println("Number of short movies : " + movieListShort.size());
//            evaluateMovieList(movieListShort, "Short");

            final List<Movie> movieListFull = Utils.loadMovies("./data/ratedmoviesfull.csv");
            System.out.println("Number of Full movies : " + movieListFull.size());
            FirstMovies.evaluateMovieList(movieListFull, "Full");

            System.out.println("------------------------------------------------------------------------------------------------------");

//            final List<model.Rater> raterListShort = loadRaters("./data/ratings_short.csv");
//            System.out.println("Number of Short ratings : " + raterListShort.size());
//            evaluateRatingList(raterListShort, "Short");

            final List<Rater> raterListFull = Utils.loadRaters("./data/ratings.csv");
            System.out.println("Number of Full ratings : " + raterListFull.size());
            FirstRatings.evaluateRatingList(raterListFull, "Full");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
