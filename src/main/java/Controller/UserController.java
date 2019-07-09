package Controller;


import Entity.Love;
import Entity.User;
import Service.UserService;
import Service.LoveService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    //注册新用户
    public Map register(User user ){
        String email=user.getEmail();
        //System.out.println(user.getName());
        Map<String,Boolean> map=new HashMap();
        if (judgeEmail(email)==true){
            //添加用户
            user.setUserid(UUID.randomUUID().toString());
            userService.register(user);
            map.put("message",true);

            //注册成功后默认生成一个收藏夹
            Love love=new Love();
            love.setLoveid(UUID.randomUUID().toString());
            love.setName("我喜欢的");
            love.setUser(user.getUserid());
            loveService.insertLove(love);
            System.out.println("收藏夹添加成功！");

        }else{
            map.put("message",false);
        }
        return map;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody

    //登录验证
    public Map login(String email, String password) {
        List<User> user = userService.login(email, password);
        Map<String,String> map=new HashMap();
        if (user.size() != 0){
            map.put("message","true");
            String id=user.get(0).getUserid();
            map.put("user", JSON.toJSONString(userBack(id),SerializerFeature.WriteMapNullValue));
        }else {
            map.put("message","false");
        }
        return map;
    }
    @RequestMapping(value = "/userBack",method=RequestMethod.GET)
    @ResponseBody
    //返回用户信息，不包括密码
    public List<User> userBack(String id){
        List<User> userInfoBack= userService.findById(id);
        userInfoBack.get(0).setPassword(null);
        return userInfoBack;
    }


    @RequestMapping(value = "/judgeEmail",method = RequestMethod.GET)
    @ResponseBody
    //判断邮箱是否注册过
    public Boolean judgeEmail(String email) {
        Boolean flag = null;
        List<User> users =userService.findByEmail(email);
        if (users.size()!=0){
            flag=false;//数据库中已经存在该email
        }else{
            flag=true;//数据库中不存在该email
        }
        return flag;
    }


    @RequestMapping(value = "/uploadFile" )
    @ResponseBody
    //上传文件
    public String uploadFile(@RequestParam(value = "file")  MultipartFile file,@CookieValue("userId") String userId ,HttpServletRequest request) throws IOException {
        String host="http://47.107.238.107/movie/upload/";
        String picturePath=request.getSession().getServletContext().getRealPath("upload");
        String fileName=file.getOriginalFilename();
        String fileFinishName=userId+fileName.substring(fileName.lastIndexOf("."));
        File targetFile=new File(picturePath,fileFinishName);
        System.out.println(targetFile.getPath());
        if (!targetFile.exists()){
            targetFile.mkdir();
        }
        file.transferTo(targetFile);
        String fileUrl=host+fileFinishName;
        List<User> user= userService.findById(userId);
        user.get(0).setAvatar(fileUrl);
        userService.updateUser(user.get(0));
        return fileUrl;
    }
    //更新地址
    @RequestMapping(value = "/updateAddress",method =RequestMethod.POST)
    @ResponseBody
    public Boolean updateAddress(String id,String address){
        List<User> user =userService.findById(id);
        System.out.println(address);
        System.out.println(user.get(0).getAddress());
        user.get(0).setAddress(address);
        userService.updateUser(user.get(0));
        List<User> user1 =userService.findById(id);
        if (user1.get(0).getAddress().trim().equalsIgnoreCase(address)){
            return true;
        }else {
            System.out.println(user1.get(0).getAddress());
            return false;
        }

    }
    //修改个人信息
    @RequestMapping(value = "/updateInfo",method =RequestMethod.POST)
    @ResponseBody
    public Boolean updateInfo( String id,User user){
        user.setUserid(id);
        userService.updateUser(user);
        return true;
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    @ResponseBody
    public Map findByName(String name){
        List<User> user =userService.findByName(name);
        Map<String,String> map=new HashMap();
        if (user.size()!=0){
            map.put("message","true");
            map.put("user",JSON.toJSONString(user,SerializerFeature.WriteMapNullValue));
        }else{
            map.put("message","false");
        }
        return map;
    }
    //生成字符串数组
    public static class AllCharacter {
        public static char[] charArray(){
            int i = 1234567890;
            String s ="qwertyuiopasdfghjklzxcvbnm";
            String S=s.toUpperCase();
            String word=s+S+i;
            char[] c=word.toCharArray();
            return c;
        }
    }
    @RequestMapping(value = "/verifyCode")
    @ResponseBody
    //生成六位随机字符验证码
    public  String verifyCode(){

        char[] c= AllCharacter.charArray();//获取包含26个字母大小写和数字的字符数组
        Random rd = new Random();
        String code="";
        for (int k = 0; k < 6; k++) {
            int index = rd.nextInt(c.length);//随机获取数组长度作为索引
            code+=c[index];//循环添加到字符串后面
        }
        return code;
    }


    //找回密码
    @RequestMapping(value = "/retrievePassword",method = RequestMethod.GET)
    @ResponseBody
    public Map retrievePassword (String email,HttpSession session) {
        Map<String,String> map=new HashMap<>();
        String emailSubject="一起看电影吧";
        String emailContent=verifyCode();
        session.setAttribute("verifyCode",emailContent);
        String emailType="text/html;charset=UTF-8";
        if (userService.sendEmail(email,emailSubject,emailContent,emailType)){
            System.out.println("发送成功");
            map.put("message","true");
        }else {
            map.put("message","false");
        }
        map.put("sessionId",session.getId());
        return map;
    }
    //check验证码
    @RequestMapping(value ="/checkCode",method = RequestMethod.GET)
    @ResponseBody
    public Boolean checkCode(String verifyCode, HttpSession session){
        if (verifyCode.equals(String.valueOf(session.getAttribute("verifyCode")))){

            System.out.println("验证成功");
            return true;
        }else {
            System.out.println("验证失败");
            return false;
        }

    }
    //重设密码
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    @ResponseBody
    public Boolean resetPassword(String id,String password){
        List<User> user =userService.findById(id);
        user.get(0).setPassword(password);
        userService.updateUser(user.get(0));
        List<User> user1 =userService.findById(id);
        if (user1.get(0).getPassword().trim().equalsIgnoreCase(password)){
            return true;
        }else {
            return false;
        }
    }


}
