import model.Movie;
import model.Rater;

import java.io.IOException;
import java.util.ArrayList;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;

    SecondRatings(String movieFile, String ratingFiles) throws IOException {
        myMovies = (ArrayList<Movie>) Utils.loadMovies(movieFile);
        myRaters = (ArrayList<Rater>) Utils.loadRaters(ratingFiles);
    }

    public ArrayList<Movie> getMyMovies() {
        return myMovies;
    }

    public void setMyMovies(ArrayList<Movie> myMovies) {
        this.myMovies = myMovies;
    }

    public ArrayList<Rater> getMyRaters() {
        return myRaters;
    }

    public void setMyRaters(ArrayList<Rater> myRaters) {
        this.myRaters = myRaters;
    }

    public int getMovieSize() {
        return myMovies.size();
    }

    public int getRaterSize() {
        return myRaters.size();
    }

}
