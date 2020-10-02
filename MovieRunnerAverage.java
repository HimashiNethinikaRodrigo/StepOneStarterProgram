import model.AverageMovieRating;
import model.Movie;
import model.MovieRating;
import model.Rater;

import java.io.IOException;
import java.util.*;

public class MovieRunnerAverage {
    static SecondRatings secondRatingsShort = null;
    static SecondRatings secondRatings = null;
    static Map<String, List<MovieRating>> movieRatings = new LinkedHashMap<>();
    static Map<String, String> movies = new LinkedHashMap<>();

    public static void printAverageRatings()  {

        System.out.println("Movie Size Short : " + secondRatingsShort.getMovieSize());
        System.out.println("Rater Size Short : " + secondRatingsShort.getRaterSize());
        System.out.println("Movie Size : " + secondRatings.getMovieSize());
        System.out.println("Rater Size : " + secondRatings.getRaterSize());
    }

    public static double getAverageByID(String movieId, int minimalRaters) {
        final List<MovieRating> movieRatingList = movieRatings.get(movieId);
        double average = movieRatingList.get(0).getTotalRating() / movieRatingList.get(0).getUserCount();
        if (movieRatingList.get(0).getUserCount() > minimalRaters) {
            return average;
        } else {
            return 0.0;
        }
    }

    public static double getAverageRatingOneMovie(String movieId) {
        final List<MovieRating> movieRatingList = movieRatings.get(movieId);
        return movieRatingList.get(0).getTotalRating() / movieRatingList.get(0).getUserCount();

    }

    public static List<AverageMovieRating> getAverageRatings(int minimalRaters) {
        List<AverageMovieRating> averageMovieRatings = new ArrayList<>();
        movieRatings.forEach((key, value) -> {
            if (value.get(0).getUserCount() >= minimalRaters) {
                AverageMovieRating averageMovieRating = new AverageMovieRating(key
                        , value.get(0).getTotalRating() / value.get(0).getUserCount());
                averageMovieRatings.add(averageMovieRating);
            }
        });
        averageMovieRatings.sort(Comparator.comparingDouble(AverageMovieRating::getAverage));
        return averageMovieRatings;
    }

    public static void main(String[] args) {
        try {
            secondRatingsShort = new SecondRatings("./data/ratedmovies_short.csv", "./data/ratings_short.csv");
            secondRatings = new SecondRatings("./data/ratedmoviesfull.csv", "./data/ratings.csv");
            printAverageRatings();
            createMovieRatingMap(secondRatingsShort.getMyRaters(), movieRatings); // change for secondRatings
            createMoviesMap(secondRatingsShort.getMyMovies(), movies); // change for secondRatings
            System.out.println("average : " + getAverageByID("1798709", 0));

            final List<AverageMovieRating> averageRatings = getAverageRatings(3);
            System.out.println("All average rating count : " + averageRatings.size());
            averageRatings.forEach(movieRating -> System.out.println(movieRating.getAverage() + " " + getTitleById(movieRating.getMovieId())));
            System.out.println("Title of given movie ID : " + getTitleById("1798709"));
            System.out.println("ID of given movie Title : " + getIdByTitle("Hers"));
            System.out.println("Average rating of movie by title " + getAverageRatingOneMovie(getIdByTitle("The Godfather")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createMoviesMap(ArrayList<Movie> myMovies, Map<String, String> movies) {
        myMovies.forEach(myMovie -> movies.put(myMovie.getID(), myMovie.getTitle()));
    }

    private static void createMovieRatingMap(List<Rater> raterList, Map<String, List<MovieRating>> movieRatings) {
        for (Rater rater : raterList) {
            rater.getRatings().forEach(myMovie -> {
                List<MovieRating> movieRatingList;
                if (movieRatings.containsKey(myMovie.getItem())) {
                    movieRatingList = movieRatings.get(myMovie.getItem());
                    movieRatingList.set(0, new MovieRating(movieRatingList.get(0).getTotalRating() + myMovie.getValue(), movieRatingList.get(0).getUserCount() + 1));
                } else {
                    movieRatingList = new ArrayList<>();
                    movieRatingList.add(new MovieRating(myMovie.getValue(), 1));
                }
                movieRatings.put(myMovie.getItem(), movieRatingList);
            });
        }
    }

    private static String getTitleById(String id) {
        return movies.get(id) != null ? movies.get(id) : "ID was not found";
    }

    private static String getIdByTitle(String title) {
        final Optional<String> first = movies
                .entrySet()
                .stream()
                .filter(entry -> title.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        return first.orElse("NO SUCH TITLE");
    }
}
