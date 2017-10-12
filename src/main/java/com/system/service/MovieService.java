package com.system.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.system.bean.Movie;
import com.system.dao.MovieDao;
import com.system.dao.UserDao;
import com.system.utils.RedisUtil;

import redis.clients.jedis.Jedis;

@Service
public class MovieService {
    
    @Autowired
    MovieDao Mapper;
    @Autowired
    RedisUtil redisutil;
    
    public List<Movie> getAllmovies(String type) {
        List<Movie> allmovie=new ArrayList<Movie>();
        allmovie=Mapper.selectByType(type);
        return allmovie;
    }
    
    public Movie getmoviebyId(String id) {
        Movie movie = Mapper.selectById(id);
        return movie;
    }
    
    public Map<String, String> getCommentByid(String id) {
        
        Map<String, String> Comments = new HashMap<String, String>();
        Jedis x = redisutil.getJedis();
        String key = id + "_comment";
        
        Comments = (HashMap<String, String>) x.hgetAll(key);               
        redisutil.returnResource(x);
        return Comments;
    }
    
    public synchronized boolean putCommentByid(String id, JSONObject jsonobj) {
        List<String> alltheComment = new ArrayList<String>();
        Jedis x = redisutil.getJedis();
        String key = id + "_comment";
        x.incr("count_id");
        String count_id = x.get("count_id");
        jsonobj.put("count_id", count_id);
        x.hset(key, count_id, jsonobj.toString());
        System.out.println(key + " " + count_id + " " + jsonobj.toString());
        redisutil.returnResource(x);
        return true;
    }
    
    public boolean throwup(String id, String count_id) {
        Jedis x = redisutil.getJedis();
        String key = id + "_comment";
        String value = x.hget(key, count_id);
        JSONObject json1 = JSONObject.parseObject(value);
        int ups =  Integer.valueOf(json1.getString("up")) + 1;
        json1.put("up", ups + "");
        x.hset(key, count_id, value);
        redisutil.returnResource(x);
        return true;
    }
    
    public boolean putUserpoint(String userId, String picId, String Point) {
        Jedis x = redisutil.getJedis();
        String key = userId + "_Point";
        if(x.hget(key, picId) != null) {
            return false;
        }
        x.hset(key, picId, Point);
        
        String filename = "D:\\j2eeworkspace\\MovieTry\\datafile\\rua.csv";
        File file = new File(filename);
        FileWriter filewrite;
        try {
            filewrite = new FileWriter(file, true);
            String data = "\n" + userId + "," + picId + "," + Point;
            filewrite.write(data);
            filewrite.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        redisutil.returnResource(x);
        return true;
    }
}
