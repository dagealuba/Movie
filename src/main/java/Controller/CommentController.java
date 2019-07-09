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

    //统计tocomment的回复数
    @RequestMapping(value = "/countCommentByToComment",method = RequestMethod.GET)
    @ResponseBody
    public int countCommentByToComment(String tocomment){
        return commentService.countCommentByToComment(tocomment);
    }

    //添加评论
    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    @ResponseBody
    public Map insertComment(Comment comment){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        comment.setCommentid(UUID.randomUUID().toString());
        Date day=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));
        comment.setTime(day);

        int tag=commentService.insertComment(comment);
        if(tag==1){
            System.out.println("评论成功");
            map.put("message",true);
        }
        else{
            System.out.println("评论失败");
            map.put("message",false);
        }
        return map;
    }

    //通过评论id删除评论
    @RequestMapping(value = "/deleteCommentById",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteCommentById(String commentid){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        int tag=commentService.deleteComment(commentid);
        if(tag==1){
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
        int tag=commentService.deleteCommentByMovieId(movie);
        if(tag==1){
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

    //通过被回复的评论id查看回复
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
