package Entity;

public class Space {
    private String spaceid;

    private String name;

    private String owner;

    private String users;

    private String movies;

    public String getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(String spaceid) {
        this.spaceid = spaceid == null ? null : spaceid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users == null ? null : users.trim();
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies == null ? null : movies.trim();
    }
}