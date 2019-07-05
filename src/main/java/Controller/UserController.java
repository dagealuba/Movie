package Controller;


import Entity.User;
import Service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;


@Controller
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    //注册新用户
    public Map register(User user ){
        String email=user.getEmail();
        //System.out.println(user.getName());
        Map<String,String> map=new HashMap();
        if (judgeEmail(email)==true){
            //添加用户
            user.setUserid(UUID.randomUUID().toString());
            user.setAvatar("xxx");
            userService.register(user);
            map.put("message","true");
            map.put("user",JSON.toJSONString(user,SerializerFeature.WriteMapNullValue));
        }else{
            map.put("message","false");
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
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        String picturePath = "C:\\Users\\ASUS\\IdeaProjects\\Movie\\images_upload\\";
        String fileName=file.getOriginalFilename();
        String fileFinishName=UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
        File targetFile=new File(picturePath,fileFinishName);
        if (!targetFile.exists()){
            targetFile.mkdir();
        }
        file.transferTo(targetFile);
        String fileUrl=fileFinishName;
        User user =new User();
        user.setAvatar(fileUrl);
        userService.updateUser(user);
    return fileUrl;
    }
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

    @RequestMapping(value = "sendEmail",method = RequestMethod.POST)
    @ResponseBody
    public String sendEmail (String email,String emailSubject, String emailContent, String emailContentType) throws GeneralSecurityException {
        String receiverInternetAddress=email;
        String flag=null;
        //邮件服务器主机名
        String mailServer ="smtp.qq.com";
        //登录邮箱的账号
        final String loginAccount="2608379678@qq.com";
        //登录邮箱的授权码
        final String loginAuthCode="shkdstwytcgueahh";
        //发件人邮箱
        String sender ="2608379678@qq.com";

        try {
            //和邮件服务器建立连接
            Properties properties=new Properties();
            //设置邮件服务器主机名
            properties.setProperty("mail.host",mailServer);
            //发送邮件身份验证
            properties.setProperty("mail.smtp.auth","true");
            //发送邮件协议名称
            properties.setProperty("mail.transport.protocol","smtp");

            //开启SSL加密
            MailSSLSocketFactory sslSocketFactory =new MailSSLSocketFactory();
            sslSocketFactory.setTrustAllHosts(true);
            properties.put("mail.stmp.ssl.enable",true);
            properties.put("mail.smtp.socaketFactory",sslSocketFactory);

            //创建session
            Session session =Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    PasswordAuthentication passwordAuthentication=new PasswordAuthentication(loginAccount,loginAuthCode);
                    return super.getPasswordAuthentication();
                }
            });
            //设置打开调试状态
            session.setDebug(true);
            //声明一个邮件对象，代表一封邮件
            MimeMessage mimeMessage=new MimeMessage(session);
            //邮件信息封装
            //1.发件人
            InternetAddress sendInternetAddress =new InternetAddress(sender);
            mimeMessage.setFrom(sendInternetAddress);
            //2.收件人
            InternetAddress receiveInternetAddress = new InternetAddress(receiverInternetAddress);
            mimeMessage.setRecipient(Message.RecipientType.TO,receiveInternetAddress);
            //3.邮件内容
            //邮件标题
            mimeMessage.setSubject("一起看电影吧","utf-8");
            //邮件正文
            mimeMessage.setContent("11","text/html;charset=UTF-8");
            //发送动作
            Transport.send(mimeMessage);
            System.out.println("发送成功");
            flag="true";

        }catch(Exception e) {
            flag = "false";

        }

        return flag;
    }

}
