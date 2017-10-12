package com.system.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.bean.User;
import com.system.service.UserService;
import org.apache.log4j.*;
@Controller
public class UserController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/logininterface")
    public Object water() {
        return "login";
    }
    
    @RequestMapping("loginer.do")
    public Object loginer(User user,HttpServletRequest request, HttpServletResponse response) throws IOException{
        String s1,s2;
        s1=request.getParameter("username");
        s2=request.getParameter("password");
        user.setUsername(s1);
        user.setPassword(s2);
        HttpSession session=request.getSession();
        String mes=null;
        boolean loginType = userService.login(user.getUsername(),user.getPassword());
        mes="yes";
        String username=s1;
        if(loginType){
            
//           request.setAttribute("user",user);
//           return "blank";
             
             session.setAttribute("userNow",username);           
//           String x="";
//           Object obj=session.getAttribute("userNow");
//           x=(String)obj;
//           System.out.println(x);
             
             response.setContentType("text/plain;charset=UTF-8");  
             response.getWriter().write(mes);             
         }else{
             mes="dfgdh";  
             response.setContentType("text/plain;charset=UTF-8");  
             response.getWriter().write(mes);
         }
         return null;
    }
        
    
    @RequestMapping("registeration.do")
    public Object registeration(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String username, password, stuemail;
        String interests;
        username=request.getParameter("username");
        password=request.getParameter("password");
        stuemail=request.getParameter("stuemail");       
        interests = request.getParameter("interests");
        //System.out.println(username + " " + password + " " + stuemail + " " + interests);
        
        boolean regtype=userService.register(username, password, stuemail, interests);        
        HttpSession session=request.getSession();
        
        String mes;
        if(regtype)
        {
            response.setContentType("text/plain;charset=UTF-8");  
            mes="注册成功";
            session.setAttribute("userNow",username);
            response.getWriter().write(mes);
        }
        else {
            response.setContentType("text/plain;charset=UTF-8");
            mes="该用户名已被注册";
            response.getWriter().write(mes);
        }
        return null;
    }
}
