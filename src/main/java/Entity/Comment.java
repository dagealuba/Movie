package Entity;

import java.util.Date;

public class Comment {
    private String commentid;

    private String movie;

    private String content;

    private Date time;

    private String tocomment;

    private String user;

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie == null ? null : movie.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTocomment() {
        return tocomment;
    }

    public void setTocomment(String tocomment) {
        this.tocomment = tocomment == null ? null : tocomment.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }
}