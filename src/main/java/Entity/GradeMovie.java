package Entity;

public class GradeMovie extends GradeMovieKey {
    private Integer grade;
    private  String  userid;
    private String  movieid;

    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String  getUserid(){return  userid;};
    public void  setUserid(String  userid){this.userid=userid;};

    public String  getMovieid(){return  movieid;};
    public void  setMovieid(String  movieid){this.movieid=movieid;};
}