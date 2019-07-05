package Controller;

import Entity.Comment;
import Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    @ResponseBody
    public Comment insertComment(Comment comment){
        String con=comment.getContent();
        String mov=comment.getMovie();
        String to=comment.getTocomment();
        System.out.println(con);
        System.out.println(mov);
        comment.setCommentid(UUID.randomUUID().toString());
        Date day=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));
        comment.setTime(day);

        if(commentService.insertComment(comment)==1){
            System.out.println("评论成功");
        }
        else{
            System.out.println("评论失败");
        }
        return comment;
    }

    @RequestMapping(value = "/deleteCommentById",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteCommentById(String commentId){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        if(commentService.deleteComment(commentId)==1){
            map.put("message",true);
            System.out.println("删除成功");
        }
        else{
            map.put("message",false);
            System.out.println("删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/deleteCommentByMovieId",method = RequestMethod.POST)
    @ResponseBody
    public  Map deleteCommentByMovieId(String movie){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        if(commentService.deleteCommentByMovieId(movie)==1){
            map.put("message",true);
            System.out.println("删除成功");
        }
        else{
            map.put("message",false);
            System.out.println("删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/selectCommentBymovieId",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> selectCommentBymovieId(String movie){
        List<Comment> comments=commentService.selectCommentByMovieId(movie);
        return comments;
    }

    @RequestMapping(value = "/selectCommentByToCommentId",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> selectCommentByToCommentId(String tocomment){
        List<Comment> comments=commentService.selectCommentByToCommentId(tocomment);
        return comments;
    }

    @RequestMapping(value = "/selectCommentById",method = RequestMethod.GET)
    @ResponseBody
    public Comment selectCommentById(String commentid){
        return commentService.selectCommentById(commentid);
    }

    @RequestMapping(value = "/countComment",method = RequestMethod.GET)
    @ResponseBody
    public int countComment(String movie){
        return commentService.countComment(movie);
    }
}
