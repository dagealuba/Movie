package ServiceImpl;

import Dao.SpaceMapper;
import Entity.Movie;
import Entity.Space;
import Service.SpaceService;
import Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpaceServiceImpl implements SpaceService {
    @Autowired
    private SpaceMapper spaceMapper;
    @Autowired
    private MovieService movieService;
    public Boolean newSpace(Space space){
        spaceMapper.insertSelective(space);
        return true;
    }

    @Override
    public Boolean addMembers(String spaceid, String memberid) {
        Space space = new Space();
        if (space.getUsers()!=null){
            space.setUsers(space.getUsers()+","+memberid);
        }else {
            space.setUsers(memberid);
        }
        spaceMapper.updateByPrimaryKey(space);
        return true;
    }

    @Override
    public Boolean addMovies(String spaceid, String movieid) {
        Space space = new Space();
        if(space.getMovies()!=null){
            space.setMovies(space.getMovies()+","+movieid);
        }else{
            space.setMovies(movieid);
        }
        spaceMapper.updateByPrimaryKey(space);
        return true;
    }

    @Override
    public Boolean deleteMovies(String spaceid, String owner, String movieid) {
        Space space =findByid(spaceid);
        if (space.getOwner().equalsIgnoreCase(owner)){
            space.setMovies(space.getMovies().replace(space.getMovies(),""));
            spaceMapper.updateByPrimaryKey(space);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean deleteMembers(String spaceid, String owner, String menmberid) {
        Space space=findByid(spaceid);
        if (space.getOwner().equalsIgnoreCase(owner)){
            space.setUsers(space.getUsers().replace(space.getUsers(),""));
            spaceMapper.updateByPrimaryKey(space);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Movie> findMoviesById(String spaceid) {
        List<Movie> movieList=new  ArrayList<Movie>();
        Space space = findByid(spaceid);
        String movies = space.getMovies();
        List<String> movieidList = Arrays.asList(movies.split(","));
        for(String id:movieidList){
            movieList.add(movieService.findById(id));
        }
        return movieList;
    }

    @Override
    public Space findByid(String spaceid) {
        Space space=spaceMapper.selectByPrimaryKey(spaceid);
        return space;
    }


}
