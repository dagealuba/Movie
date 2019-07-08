package Controller;


import Entity.LikeCommentKey;
import Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    //点赞
    @RequestMapping(value = "/insertLike",method = RequestMethod.POST)
    @ResponseBody
    public LikeCommentKey insertLike(LikeCommentKey like){
        String comment=like.getComment();
        String user=like.getUser();

        System.out.println("评论id:"+comment);
        System.out.println("用户id:"+user);

        if(likeService.insertLike(like)==1){
            System.out.println("点赞成功");
        }
        else{
            System.out.println("点赞失败");
        }
        return like;
    }

    //统计点赞数
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
        return likes;
    }

    //通过用户id取消点赞
    @RequestMapping(value = "/deleteLikeByUserId",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteLikeByUserId(String user){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        if(likeService.deleteLikeByUserId(user)==1){
            System.out.println("删除点赞成功");
            map.put("message",true);
        }
        else{
            System.out.println("删除点赞失败");
            map.put("message",false);
        }
        return map;
    }

    //通过评论id取消点赞
    @RequestMapping(value = "/deleteLikeByCommentId",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteLikeByCommentId(String comment){
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        if(likeService.deleteLikeByCommentId(comment)==1){
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
