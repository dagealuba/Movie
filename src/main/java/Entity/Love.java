package Entity;

public class Love {
    private String loveid;

    private String name;

    private String movies;

    private String user;

    public String getLoveid() {
        return loveid;
    }

    public void setLoveid(String loveid) {
        this.loveid = loveid == null ? null : loveid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies == null ? null : movies.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }
}