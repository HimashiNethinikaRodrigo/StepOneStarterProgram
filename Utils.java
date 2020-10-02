import model.Movie;
import model.Rater;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Utils {
    public static BufferedReader loadFiles(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
        br.readLine();
        return br;
    }

    public static List<Movie> loadMovies(String fileName) throws IOException {
        List<Movie> movieList = new ArrayList<>();
        final BufferedReader br = loadFiles(fileName);
        String line = br.readLine();
        while (line != null) {
            String[] attributes = line.split(",\"|\",");
            Movie movie = createMovie(attributes);
            movieList.add(movie);
            line = br.readLine();

        }

        return movieList;
    }

    public static List<Rater> loadRaters(String fileName) throws IOException {
        List<Rater> raterList = new ArrayList<>();
        final BufferedReader br = loadFiles(fileName);
        String line = br.readLine();
        while (line != null) {
            String[] attributes = line.split(",");
            Rater rater = createRater(attributes);
            raterList.add(rater);
            line = br.readLine();

        }

        return raterList;

    }

    private static Rater createRater(String[] attributes) {
        Rater rater = new Rater(
                attributes[0]);
        rater.addRating(attributes[1], Double.parseDouble(attributes[2]));
        return rater;
    }

    private static Movie createMovie(String[] attributes) {
        return new Movie(
                attributes[0],
                attributes[1],
                attributes[2],
                attributes[4],
                attributes[5],
                attributes[3],
                attributes[7],
                Integer.parseInt(attributes[6]));

    }

    public static int calculateMaxCount(Map<String, Integer> list){
        return list.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getValue();
    }

}


