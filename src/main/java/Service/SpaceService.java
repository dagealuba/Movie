package Service;

import Entity.Space;

public interface SpaceService {

    public Space findSpace(String  spaceid);
    public int addMovie(String spaceid,String owner,String movies );
    public int deleteMovie(String spaceid,String owner,String movies );
}
