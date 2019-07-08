package ServiceImpl;

import Dao.UserMapper;
import Entity.User;
import Entity.UserExample;
import Service.UserService;
import com.alibaba.fastjson.JSON;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user ) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria =userExample.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        return userMapper.updateByExampleSelective(user,userExample);
    }

    @Override
    public List<User> login(String email,String password) {
        //System.out.println("name: "+username+"\npassword: "+password);
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        criteria.andPasswordEqualTo(password);
        //List<User> users = userMapper.selectByExample(userExample);
        //System.out.println(users.size()+JSON.toJSONString(users));
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> findByName(@RequestParam String name) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> findByEmail(String email) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }


    @Override
    public List<User> findById(String id) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUseridEqualTo(id);
        List<User> user=userMapper.selectByExample(userExample);
        return user;
    }

    @Override
    public Boolean sendEmail(String email, String emailSubject, String emailContent, String emailType) {
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
            properties.setProperty("mail.smtp.host",mailServer);
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
                    return new PasswordAuthentication(loginAccount,loginAuthCode);
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
            InternetAddress receiveInternetAddress = new InternetAddress(email);
            mimeMessage.setRecipient(Message.RecipientType.TO,receiveInternetAddress);
            //3.邮件内容
            //邮件标题
            mimeMessage.setSubject(emailSubject,"utf-8");
            //邮件正文
            mimeMessage.setContent(emailContent,emailType);
            //发送动作
            Transport.send(mimeMessage);
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
