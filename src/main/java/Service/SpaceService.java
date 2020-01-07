package Service;

import Entity.Movie;
import Entity.Space;

import java.util.List;

public interface SpaceService {
    Boolean newSpace(Space space);
    Boolean addMembers(String spaceid,String memberid);
    Boolean addMovies(String spaceid,String movieid);
    Boolean deleteMovies(String spaceid,String owner,String movieid);
    Boolean deleteMembers(String spaceid,String ower,String menmberid);
    List<Movie> findMoviesById(String spaceid);
    Space findByid(String spaceid);

    List<Space> findMySpace(String userid);

    List<Space> findJoinSpace(String userid);

    List<Space> findSpaceByName(String name);
}
