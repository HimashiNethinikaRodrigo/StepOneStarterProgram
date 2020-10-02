import model.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstMovies {
    public static void evaluateMovieList(List<Movie> movieList, String movieType) {
        int comedyCount = 0;
        int movieLengthGreaterThanOneFiftyCount = 0;
        Map<String, Integer> directors = new HashMap<>();
        for (Movie movie : movieList) {
            if (movie.getGenres().contains("Comedy"))
                comedyCount++;
            if (movie.getMinutes() > 150)
                movieLengthGreaterThanOneFiftyCount++;

            final String[] directorNames = movie.getDirector().trim().split(String.valueOf(','));
            for (String directorName : directorNames) {
                directorName = directorName.trim();
                if (directors.containsKey(directorName)) {
                    Integer filmCount = directors.get(directorName);
                    directors.put(directorName, ++filmCount);
                } else {
                    directors.put(directorName, 1);
                }
            }

        }
        int movieCount = Utils.calculateMaxCount(directors);

        directors.forEach((key, value) -> {
            if (value == movieCount)
                System.out.println("values rating -------- :" + key + " :  " + value);
        });

        System.out.println("Comedy " + movieType + "Count : " + comedyCount);
        System.out.println(movieType + " movie Length Grater than 150 : " + movieLengthGreaterThanOneFiftyCount);
        System.out.println(movieType + " max number of movies directed by single director : " + movieCount);
    }
}
