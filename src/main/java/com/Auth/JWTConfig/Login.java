package com.Auth.JWTConfig;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: springmvc
 * @Package: com.Auth.JWTConfig
 * @ClassName: Login
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/12 15:10
 * @Version: 1.0
 */
@RestController
public class Login {
   private Integer id;
   private String userName;
   private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @RequestMapping(value="index")
    public String Index(){
        System.out.println("+++++++++++++");
        return "index";
    }
    //处理登录
    @RequestMapping(value="login")
    public ResponseData login(HttpServletRequest request, HttpServletResponse response, @RequestParam( "userName") String userName,
                              @RequestParam("password") String password) {
        Login login = new Login();
        login.setUserName(userName);
        login.setPassword(password);
        ResponseData responseData = ResponseData.ok();
        //先到数据库验证
        Integer loginId = this.checkLogin(login);
        if(null != loginId) {
            User user = this.getUserByLoginId(loginId);
            login.setId(loginId);
            //给用户jwt加密生成token
            String token = JWT.sign(login, 1000L* 10L);
            Cookie sessionId = new Cookie("token_sessionId",token);
//            sessionId.setMaxAge(10);
            //封装成对象返回给客户端
            response.addCookie(sessionId);
            responseData.putDataValue("loginId", login.getId());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", user);
        }
        else{
            responseData =  ResponseData.customerError();
        }
        return responseData;
    }

    private User getUserByLoginId(Integer loginId) {
        return new User();
    }

    private Integer checkLogin(Login login) {
        return 1;
    }
}
