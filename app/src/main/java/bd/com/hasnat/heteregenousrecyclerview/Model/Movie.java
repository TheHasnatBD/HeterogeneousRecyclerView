package bd.com.hasnat.heteregenousrecyclerview.Model;

public class Movie {
    private int image;
    private String movieName, movieCategory;

    public Movie(int image, String movieName, String movieCategory) {
        this.image = image;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
    }

    public int getImage() {
        return image;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieCategory() {
        return movieCategory;
    }
}
