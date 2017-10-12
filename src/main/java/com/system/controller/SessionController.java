package com.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.system.bean.Movie;
import com.system.service.UserService;

@Controller
public class SessionController {
    @Autowired
    UserService userService;
    
    @RequestMapping("getUserNow.do")
    public Object getMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String mes = (String) session.getAttribute("userNow");
        int Id = userService.getuserId(mes);
        out.write(Id+"");        
        return null;
    } 
}
