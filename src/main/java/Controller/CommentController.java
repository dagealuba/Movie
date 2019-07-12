package Controller;

import Entity.Comment;
import Service.CommentService;
import Service.MovieService;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;

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

        String user=comment.getUser();
        String movie=comment.getMovie();
        if(userService.findById(user)!=null&&movieService.findById(movie)!=null){
            int tag=commentService.insertComment(comment);
            if(tag==1){
                System.out.println("评论成功");
                map.put("message",true);
            }
            else{
                System.out.println("评论失败");
                map.put("message",false);
            }
        }
        else {
            System.out.println("该电影或该人不存在");
            map.put("message",false);
        }

        return map;
    }

    //通过评论id删除评论
    @RequestMapping(value = "/deleteCommentById",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteCommentById(String commentid){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        List<Comment> comments=commentService.selectCommentByToCommentId(commentid);
        for(int i=0;i<comments.size();i++){
            System.out.println(comments.get(i).getCommentid());
        }

        Comment comment=commentService.selectCommentById(commentid);
        comments.add(comment);//需要删除的评论列表
        int tag=0;
        for(int j=0;j<comments.size();j++){
            tag=commentService.deleteComment(comments.get(j).getCommentid());
            if(tag==0){
                map.put("message",false);
                System.out.println("删除失败");
                break;
            }
            else{
                map.put("message",true);
            }
        }
        return map;
    }

    //通过电影id删除评论
    @RequestMapping(value = "/deleteCommentByMovieId",method = RequestMethod.POST)
    @ResponseBody
    public  Map deleteCommentByMovieId(String movie){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        int tag=commentService.deleteCommentByMovieId(movie);
        if(tag!=0){
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
