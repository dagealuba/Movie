package Controller;


import Entity.Love;
import Entity.User;
import Service.FriendService;
import ServiceImpl.MyHandler;
import Service.UserService;
import Service.LoveService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoveService loveService;
    @Autowired
    private MyHandler myHandler;
    @Autowired
    private FriendService friendService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    //注册新用户
    public Map register(User user) {
        String email = user.getEmail();
        //System.out.println(user.getName());
        Map<String, String> map = new HashMap();
        if (judgeEmail(email) == true) {
            //添加用户
            user.setUserid(UUID.randomUUID().toString());
            userService.register(user);
            map.put("message", "true");

            User u = userService.findById(user.getUserid()).get(0);
            u.setPassword(null);
            map.put("user",JSON.toJSONString(u));

            //注册成功后默认生成一个收藏夹
            Love love = new Love();
            love.setLoveid(UUID.randomUUID().toString());
            love.setName("我喜欢的");
            love.setUser(user.getUserid());
            loveService.insertLove(love);
            System.out.println("收藏夹添加成功！");

            //默认好友列表
            try {
                friendService.addFriend(user.getUserid(),user.getUserid());
            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            map.put("message", "false");
        }
        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    //登录验证
    public Map login(String email, String password, HttpSession session) {
        List<User> user = userService.login(email, password);
        Map<String, String> map = new HashMap();
        if (user.size() != 0) {
            map.put("message", "true");
            String id = user.get(0).getUserid();
            map.put("user", JSON.toJSONString(userBack(id), SerializerFeature.WriteMapNullValue));
            session.setAttribute("username", id);
        } else {
            map.put("message", "false");
        }
        return map;
    }

    @RequestMapping(value = "/autoLogin", method = RequestMethod.GET)
    @ResponseBody
    //登录验证
    public List<User> autoLogin(String userid, HttpSession session) {
        List<User> userInfoBack = userService.findById(userid);
        session.setAttribute("username", userid);
        userInfoBack.get(0).setPassword(null);
        return userInfoBack;
    }

    @RequestMapping("/message")
    public @ResponseBody
    String sendMessage() {
        boolean flag = myHandler.sendMessageToAllUsers(new TextMessage("你好"));
//        System.out.println(flag);
        return "发送";
    }

    @RequestMapping(value = "/userBack", method = RequestMethod.GET)
    @ResponseBody
    //返回用户信息，不包括密码
    public List<User> userBack(String id) {
        List<User> userInfoBack = userService.findById(id);
        userInfoBack.get(0).setPassword(null);
        return userInfoBack;
    }


    @RequestMapping(value = "/judgeEmail", method = RequestMethod.GET)
    @ResponseBody
    //判断邮箱是否注册过
    public Boolean judgeEmail(String email) {
        Boolean flag = null;
        List<User> users = userService.findByEmail(email);
        if (users.size() != 0) {
            flag = false;//数据库中已经存在该email
        } else {
            flag = true;//数据库中不存在该email
        }
        return flag;
    }


    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    //上传文件
    public String uploadFile(@RequestParam(value = "file") MultipartFile file, @CookieValue("userId") String userId, HttpServletRequest request) throws IOException {
        String host = "http://47.107.238.107/Movie/upload/";
        String picturePath = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String fileFinishName = userId + fileName.substring(fileName.lastIndexOf("."));
        File targetFile = new File(picturePath, fileFinishName);
//        System.out.println(targetFile.getPath());
        if (!targetFile.exists()) {
            targetFile.mkdir();
        }
        file.transferTo(targetFile);
        String fileUrl = host + fileFinishName;
        List<User> user = userService.findById(userId);
        user.get(0).setAvatar(fileUrl);
        userService.updateUser(user.get(0));
        return fileUrl;
    }

    //更新地址
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateAddress(String id, String address) {
        List<User> user = userService.findById(id);
//        System.out.println(address);
//        System.out.println(user.get(0).getAddress());
        user.get(0).setAddress(address);
        userService.updateUser(user.get(0));
        List<User> user1 = userService.findById(id);
        if (user1.get(0).getAddress().trim().equalsIgnoreCase(address)) {
            return true;
        } else {
//            System.out.println(user1.get(0).getAddress());
            return false;
        }

    }

    //修改个人信息
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateInfo(String id, User user) {
        user.setUserid(id);
        userService.updateUser(user);
        return true;
    }

    //通过名字查找用户
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    @ResponseBody
    public Map findByName(String name) {
        List<User> user = userService.findByName(name);
        Map<String, String> map = new HashMap();
        if (user.size() != 0) {
            map.put("message", "true");
            map.put("user", JSON.toJSONString(user, SerializerFeature.WriteMapNullValue));
        } else {
            map.put("message", "false");
        }
        return map;
    }

    //通过id查找用户
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findById(String userid) {
        List<User> users = userService.findById(userid);
        if (users.size() != 0) {
//            System.out.println("true");
        } else {
//            System.out.println("false");
        }
        return users;
    }

    public MyHandler getMyHandler() {
        return myHandler;
    }

    public void setMyHandler(MyHandler myHandler) {
        this.myHandler = myHandler;
    }


    //生成字符串数组
    public static class AllCharacter {
        public static char[] charArray() {
            int i = 1234567890;
            String s = "qwertyuiopasdfghjklzxcvbnm";
            String S = s.toUpperCase();
            String word = s + S + i;
            char[] c = word.toCharArray();
            return c;
        }
    }

    @RequestMapping(value = "/verifyCode")
    @ResponseBody
    //生成六位随机字符验证码
    public String verifyCode() {

        char[] c = AllCharacter.charArray();//获取包含26个字母大小写和数字的字符数组
        Random rd = new Random();
        String code = "";
        for (int k = 0; k < 6; k++) {
            int index = rd.nextInt(c.length);//随机获取数组长度作为索引
            code += c[index];//循环添加到字符串后面
        }
        return code;
    }


    //找回密码
    @RequestMapping(value = "/retrievePassword", method = RequestMethod.GET)
    @ResponseBody
    public Map retrievePassword(String email, HttpSession session) {
        Map<String, String> map = new HashMap<String, String>();
        String emailSubject = "一起看电影吧";
        String emailContent = verifyCode();
        session.setAttribute("verifyCode", emailContent);
        String emailType = "text/html;charset=UTF-8";
        if (userService.sendEmail(email, emailSubject, emailContent, emailType)) {
            System.out.println("发送成功");
            map.put("message", "true");
        } else {
            map.put("message", "false");
        }
        map.put("sessionId", session.getId());
        return map;
    }

    @RequestMapping(value = "/findByEmail", method = RequestMethod.GET)
    @ResponseBody
    public User findByEmail(String email) {
//       User user = null;
       return userService.findByEmail(email).get(0);
    }

    //check验证码
    @RequestMapping(value = "/checkCode", method = RequestMethod.GET)
    @ResponseBody
    public Boolean checkCode(String verifyCode, HttpSession session) {
        if (verifyCode.equals(String.valueOf(session.getAttribute("verifyCode")))) {

            System.out.println("验证成功");
            return true;
        } else {
            System.out.println("验证失败");
            return false;
        }

    }

    //重设密码
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Boolean resetPassword(String id, String password) {
        List<User> user = userService.findById(id);
        user.get(0).setPassword(password);
        userService.updateUser(user.get(0));
        List<User> user1 = userService.findById(id);
        if (user1.get(0).getPassword().trim().equalsIgnoreCase(password)) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findUsers(String val){
        List<User> users = new ArrayList<>();

        users = userService.findByName(val);
        users.addAll(userService.findLikeId(val));
        users.addAll(userService.findLikeEmail(val));

        return users;
    }


    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteUser(String userid){
        return userService.deleteUser(userid);
    }

    @RequestMapping(value = "/checkPassword", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkPassword(String userid,String pwd){
        if (userService.findById(userid).size() > 0){
            User user = userService.findById(userid).get(0);
            if (user.getPassword().equals(pwd)){
                return true;
            }
        }

        return false;
    }

    //可能认识的人
    @RequestMapping(value ="/getPotentialAcquaintances",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Integer> getPotentialAcquaintances(String userid){
        //一度好友
        List<User> firstFriends=friendService.getAllFriends(userid);

        List<User> myself = userService.findById(userid);
//        System.out.println("myself:"+JSON.toJSONString(myself));
        //二度好友
        List<User> allSecondFriends =new ArrayList<>();
        for (User user:firstFriends){
            allSecondFriends.addAll(friendService.getAllFriends(user.getUserid()));
        }

        //去重后的二度好友
        List<User> secondFriends=new ArrayList<>();

        for (int i = 0; i < allSecondFriends.size(); i++){
            boolean flag = true;
            for (int j = 0; j < secondFriends.size(); j++){
                if (secondFriends.get(j).getUserid().equals(allSecondFriends.get(i).getUserid())){
                    flag = false;
                    break;
                }
            }

            if (flag){
                secondFriends.add(allSecondFriends.get(i));
            }
        }
//        System.out.println("secondFriends:"+JSON.toJSONString(secondFriends));
        //去掉二度好友中的一度好友
        Iterator<User> second = secondFriends.iterator();

        while (second.hasNext()) {
            Iterator<User> first = firstFriends.iterator();
            User secondUser = second.next();
            while (first.hasNext()){
                User firstUser = first.next();
                if (firstUser.getUserid().equals(secondUser.getUserid())){
                    second.remove();
                }
            }
        }
//        System.out.println("secondFriends 2.0:"+JSON.toJSONString(secondFriends));

        second = secondFriends.iterator();
        while (second.hasNext()) {
            Iterator<User> userSelf = myself.iterator();
            User secondUser = second.next();
            while (userSelf.hasNext()){
                User self = userSelf.next();
                System.out.println("secondFriends 3.0-self:"+JSON.toJSONString(self.getUserid().equals(secondUser.getUserid())));
                if (self.getUserid().equals(secondUser.getUserid())){
                    second.remove();
                }
            }
        }
        System.out.println("secondFriends 3.0:"+JSON.toJSONString(secondFriends));

        //三度好友
        Map<String,List<User>> thirdFriends =new HashMap<>();
        for (User user:secondFriends){
            thirdFriends.put(user.getUserid(),friendService.getAllFriends(user.getUserid()));
        }
        System.out.println("thirdFriends:"+JSON.toJSONString(thirdFriends));
        //空间换时间，HashMap的get方法比较高效
        Map<String,Integer> map=new HashMap();
        List<User> commonFriends=new ArrayList<>();
        //记录二度好友和共同好友个数
        Map<String,Integer> allCommonFriends = new HashMap<>();
        for (User user1:firstFriends){
            map.put(user1.getUserid(),1);
        }
        for (Map.Entry<String,List<User>> m1:thirdFriends.entrySet()){
            for (User user:m1.getValue()){
                System.out.println("map.get(user):"+JSON.toJSONString(map.get(user.getUserid())));
                map.put(user.getUserid(),map.get(user.getUserid())==null?1:2);
            }
            for(Map.Entry<String,Integer> m:map.entrySet()){
                if (m.getValue()==2){
                    commonFriends.add(userService.findById(m.getKey()).get(0));
                }
            }
            allCommonFriends.put(m1.getKey(),commonFriends.size());
            System.out.println("size:"+commonFriends.size());

        }
        //对二度好友按共同好友数降序排列
//        List<Map.Entry<User,Integer>> list = new ArrayList<>();
//        list.addAll(allCommonFriends.entrySet());
//        ValueComparator valueComparator = new ValueComparator();
//        Collections.sort(list,valueComparator);
        return allCommonFriends;
    }
    //自定义排序方式
    private static class ValueComparator implements Comparator<Map.Entry<User,Integer>>
    {
        public int compare(Map.Entry<User,Integer> m,Map.Entry<User,Integer> n)
        {
            return n.getValue()-m.getValue();
        }
    }
}
