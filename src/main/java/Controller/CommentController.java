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

    //统计评论数
    @RequestMapping(value = "/countComment",method = RequestMethod.GET)
    @ResponseBody
    public int countComment(String movie){
        return commentService.countComment(movie);
    }

    //统计回复数
    @RequestMapping(value = "/countCommentByToComment",method = RequestMethod.GET)
    @ResponseBody
    public int countCommentByToComment(String tocomment){
        return commentService.countCommentByToComment(tocomment);
    }

    //添加评论
    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    @ResponseBody
    public Comment insertComment(Comment comment){
        String con=comment.getContent();
        String mov=comment.getMovie();
        String to=comment.getTocomment();
        String user=comment.getUser();

        Comment comment1=new Comment();
        comment1.setCommentid(UUID.randomUUID().toString());
        comment1.setMovie(mov);
        comment1.setContent(con);
        Date day=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));
        comment1.setTime(day);
        comment1.setTocomment(to);
        comment1.setUser(user);

        if(commentService.insertComment(comment1)==1){
            System.out.println("评论成功");
        }
        else{
            System.out.println("评论失败");
        }
        return comment;
    }

    //通过评论id删除评论
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

    //通过电影id删除评论
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

    //通过电影id查看评论
    @RequestMapping(value = "/selectCommentByMovieId",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> selectCommentByMovieId(String movie){
        List<Comment> comments=new ArrayList<Comment>();
        comments=commentService.selectCommentByMovieId(movie);
        if(comments.size()!=0){
            System.out.println("搜索成功");
        }
        else{
            System.out.println("搜索失败");
        }
        return comments;
    }

    //通过被回复的评论id查看评论
    @RequestMapping(value = "/selectCommentByToCommentId",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> selectCommentByToCommentId(String tocomment){
        List<Comment> comments=new ArrayList<Comment>();
        comments=commentService.selectCommentByToCommentId(tocomment);
        if(comments.size()!=0){
            System.out.println("搜索成功");
        }
        else{
            System.out.println("搜索失败");
        }
        return comments;
    }

    //通过评论id查看评论
    @RequestMapping(value = "/selectCommentById",method = RequestMethod.GET)
    @ResponseBody
    public Comment selectCommentById(String commentid){
        Comment comment=new Comment();
        comment=commentService.selectCommentById(commentid);
        return comment;
    }


}
