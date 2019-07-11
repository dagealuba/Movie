package Service;

import Entity.Space;

import java.util.Map;

public interface SpaceService {

    public Map exitspace(String userid, String spaceid);
    public Space findSpace(String  spaceid);
    public Map addMovies(String spaceid,String owner,String movies );
    public Map deleteMovies(String spaceid,String owner,String movies );
}
