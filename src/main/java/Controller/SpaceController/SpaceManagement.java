package Controller.SpaceController;

import Entity.Movie;
import Entity.Space;
import Service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin

public class SpaceManagement {
    @Autowired
    private SpaceService spaceService;
    @RequestMapping(value = "/newSpace",method = RequestMethod.POST)
    @ResponseBody
    public Boolean newSpace(String name,String userid){
        Space space = new Space();
        space.setSpaceid(UUID.randomUUID().toString());
        space.setName(name);
        space.setOwner(userid);
        spaceService.newSpace(space);
        return true;
    }
    @RequestMapping(value = "/addMembers",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addMembers(String spaceid,String memberid){
        return spaceService.addMembers(spaceid,memberid);

    }
    @RequestMapping(value = "/addMovies",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addMovies(String spaceid,String movies){
        return spaceService.addMovies(spaceid,movies);
    }
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ResponseBody
    public Space findById(String spaceid){
        return spaceService.findByid(spaceid);
    }

    @RequestMapping(value = "/deleteMembers",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteMembers(String spaceid, String owner, String menmberid){
        return spaceService.deleteMembers(spaceid,owner,menmberid);
    }

    @RequestMapping(value = "/deleteMovies",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteMovies(String spaceid,String owner,String movieid){
        return spaceService.deleteMovies(spaceid,owner,movieid);
    }
    @RequestMapping(value = "/findMovieById",method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> findMovieById(String spaceid){
        return spaceService.findMoviesById(spaceid);
    }


}






















