package Entity;

public class GradeMovieKey {
    private String user;

    private String movie;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie == null ? null : movie.trim();
    }
}