import model.Rater;

import java.util.*;

public class FirstRatings {

    public static void evaluateRatingList(List<Rater> raterList, String raterType) {
        Map<String, Integer> raters = new LinkedHashMap<>();
        Map<String, Integer> movieRatings = new LinkedHashMap<>();
        createRatersMap(raterList, raters);
        createMovieRatingMap(raterList, movieRatings);
        int ratingCount = Utils.calculateMaxCount(raters);
        int movieRatingCount = Utils.calculateMaxCount(movieRatings);

        raters.forEach((key, value) -> {
            if (value == ratingCount)
                System.out.println("values rating -------- :" + key + " :  " + value);
        });

        movieRatings.forEach((key, value) -> {
            if (value == movieRatingCount)
                System.out.println("values movie rating -------- :" + key + " :  " + value);
        });

        System.out.println(raterType+ " rating count of specific rater (193): "+ raters.get("193"));
        System.out.println(raterType+ " rating count of specific movie have (1798709): "+ movieRatings.get("1798709"));
        System.out.println(raterType+ " max rating count: "+ ratingCount);
        System.out.println(raterType+ " max movie rating count: "+ movieRatingCount);
        System.out.println(raterType+ " different movie count: "+ (long) movieRatings.entrySet().size());
    }

    private static void createMovieRatingMap(List<Rater> raterList, Map<String, Integer> movieRatings) {
        for (Rater rater : raterList) {
            rater.getItemsRated().forEach(myMovie -> {
                if (movieRatings.containsKey(myMovie)){
                    Integer count = movieRatings.get(myMovie);
                    movieRatings.put(myMovie, ++count);
                } else {
                    movieRatings.put(myMovie, 1);
                }
            });
        }
    }

    private static void createRatersMap(List<Rater> raterList, Map<String, Integer> raters) {
        for (Rater rater : raterList) {
            final String id = rater.getID();
            if (raters.containsKey(id)) {
                Integer raterCount = raters.get(id);
                raters.put(id, ++raterCount);
            } else {
                raters.put(id, 1);
            }

        }
    }

}

