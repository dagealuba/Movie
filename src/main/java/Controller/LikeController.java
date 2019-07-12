package Controller;


import Entity.LikeCommentKey;
import Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class LikeController {
    @Autowired
    private LikeService likeService;

    //点赞
    @RequestMapping(value = "/insertLike",method = RequestMethod.GET)
    @ResponseBody
    public Map insertLike(LikeCommentKey like){
        String comment=like.getComment();
        String user=like.getUser();
        System.out.println("评论id:"+comment);
        System.out.println("用户id:"+user);

        Map<String,Boolean> map=new HashMap<String,Boolean>();
        int tag=likeService.insertLike(like);
        if(tag==1){
            System.out.println("点赞成功");
            map.put("message",true);
        }
        else{
            System.out.println("点赞失败");
            map.put("message",false);
        }
        return map;
    }

    //通过评论id统计点赞数
    @RequestMapping(value = "/countLike",method = RequestMethod.GET)
    @ResponseBody
    public int countLike(String comment){
        int count=likeService.countLike(comment);
        return count;
    }

    //通过评论id查看点赞
    @RequestMapping(value="/selectLikeByCommentId",method = RequestMethod.GET)
    @ResponseBody
    public List<LikeCommentKey> selectLikeByCommentId(String comment){
        List<LikeCommentKey> likes=likeService.selectLikeByCommentId(comment);
        if(likes.size()!=0){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        return likes;
    }

    @RequestMapping(value="/isLiked",method = RequestMethod.GET)
    @ResponseBody
    public boolean isLiked(String user, String comment){
        return likeService.isLiked(user,comment);
    }

    //通过用户id取消点赞
    @RequestMapping(value = "/deleteLikeByUserId",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteLikeByUserId(String user){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        int tag=likeService.deleteLikeByUserId(user);
        if(tag==1){
            System.out.println("删除点赞成功");
            map.put("message",true);
        }
        else{
            System.out.println("删除点赞失败");
            map.put("message",false);
        }
        return map;
    }

    //通过评论id删除点赞
    @RequestMapping(value = "/deleteLikeByCommentId",method = RequestMethod.GET)
    @ResponseBody
    public Map deleteLikeByCommentId(String comment){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        int tag=likeService.deleteLikeByCommentId(comment);
        if(tag==1){
            System.out.println("点赞删除成功");
            map.put("message",true);
        }
        else{
            System.out.println("点赞删除失败");
            map.put("message",true);
        }
        return map;
    }

}
