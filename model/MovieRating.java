package model;

public class MovieRating {
    private double totalRating;
    private int userCount;

    public MovieRating(double totalRating, int userCount) {
        this.totalRating = totalRating;
        this.userCount = userCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = totalRating;
    }
}
