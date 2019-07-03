package Entity;

import java.util.Date;

public class Movie {
    private String movieid;

    private String name;

    private String leadingCreator;

    private String cover;

    private String stills;

    private Date releaseDate;

    private String time;

    private Integer grade;

    private Integer gradenum;

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid == null ? null : movieid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLeadingCreator() {
        return leadingCreator;
    }

    public void setLeadingCreator(String leadingCreator) {
        this.leadingCreator = leadingCreator == null ? null : leadingCreator.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getStills() {
        return stills;
    }

    public void setStills(String stills) {
        this.stills = stills == null ? null : stills.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGradenum() {
        return gradenum;
    }

    public void setGradenum(Integer gradenum) {
        this.gradenum = gradenum;
    }
}