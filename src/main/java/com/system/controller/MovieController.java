package com.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.system.bean.Comment;
import com.system.bean.Movie;
import com.system.service.MovieService;
import com.system.service.RecommondService;


@Controller
public class MovieController {
    @Autowired
    MovieService movieservice;
    @Autowired
    RecommondService recommondservice;
    
    @RequestMapping("getMovie.do")
    public Object getMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieType = request.getParameter("movieType");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject Json=new JSONObject();
        List<Movie> okk=new ArrayList<Movie>();
        okk=movieservice.getAllmovies(movieType);
        Json.put("list", okk);     
//        for(Movie o : okk) {
//            System.out.println(o.getID());
//        }
        out.write(Json.toString());        
        return null;
    }
    /*
     * 获取推荐电影
     */
    @RequestMapping("getRec.do")
    public Object getRec(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String Id = request.getParameter("userNow");
        response.setContentType("text/html;charset=utf-8");
        List<String> movieIds1 = new ArrayList<String>();
        List<String> movieIds2 = new ArrayList<String>();
        List<String> movieIds3 = new ArrayList<String>();
        List<String> randommovie = new ArrayList<String>();
        List<Movie> okk=new ArrayList<Movie>();
        PrintWriter out = response.getWriter();
        JSONObject Json=new JSONObject();
        movieIds1 = recommondservice.getMoviesById(Id);
        movieIds2 = recommondservice.getMoviesByItem(Id);
        movieIds3 = recommondservice.getMoviesByUser(Id);
        for(String i : movieIds1) {
            randommovie.add(i);
        }
        for(String i : movieIds2) {
            randommovie.add(i);
        }
        for(String i : movieIds3) {
            randommovie.add(i);
        }
        int len = randommovie.size();
        
        for(int i = 0; i < 15; i ++) {
            int y = (int) (Math.random() * len);
            okk.add( movieservice.getmoviebyId(y+"") );
        }

        Json.put("list", okk);
        out.write(Json.toString());        
        return null;
    }
    
    @RequestMapping("getComment.do")
    public Object getComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Id = request.getParameter("Pictureid");
        List<Comment> okk = new ArrayList<Comment>();
        Map<String, String> allcomments = new HashMap<String, String>();
        response.setContentType("text/html;charset=utf-8");
        allcomments = movieservice.getCommentByid(Id);
        JSONObject Json1 = new JSONObject();
        Comment comment = new Comment();
        for(String key : allcomments.keySet()) {
            String comm = allcomments.get(key);
            Json1 = JSONObject.parseObject(comm);
            comment = new Comment();
            comment.setComment(Json1.getString("comment"));
            comment.setCount_id(Json1.getString("count_id"));
            comment.setTime(Json1.getString("time"));
            comment.setUp(Json1.getString("up"));
            comment.setUsername(Json1.getString("username"));
            okk.add(comment);
        }
        
        PrintWriter out = response.getWriter();
        JSONObject Json=new JSONObject();
        Json.put("list", okk);
        System.out.println(Json.toString());
        out.write(Json.toString());
        return null;
    }
    
    @RequestMapping("throwup.do")
    public Object throwup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Id = request.getParameter("Pictureid");
        String count_id = request.getParameter("countId");
        response.setContentType("text/html;charset=utf-8");
        movieservice.throwup(Id, count_id);
        return null;
    }
    
    @RequestMapping("putComment.do")
    public Object putComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String Id = request.getParameter("Pictureid");
        String time = request.getParameter("time");
        String username = (String) session.getAttribute("userNow");
        String comment = request.getParameter("comment");
        
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("username", username);
        jsonobj.put("time", time);
        jsonobj.put("comment", comment);
        jsonobj.put("up", 0+"");
        movieservice.putCommentByid(Id, jsonobj);
        return null;
    }
    
    @RequestMapping("putpoint.do")
    public Object putpoint(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String Id = request.getParameter("Pictureid");
        String userId = request.getParameter("userId");
        String Point = request.getParameter("Point");
        String username = (String) session.getAttribute("userNow");

        movieservice.putUserpoint(userId, Id, Point);
        return null;
    }
}
