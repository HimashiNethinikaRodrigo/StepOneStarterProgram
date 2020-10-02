package model;

public class AverageMovieRating {
    private String movieId;
    private double average;

    public AverageMovieRating(String movieId, double average) {
        this.movieId = movieId;
        this.average = average;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "AverageMovieRating{" +
                "movieId='" + movieId + '\'' +
                ", average=" + average +
                '}';
    }
}
