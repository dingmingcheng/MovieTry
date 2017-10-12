package com.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.bean.User;
import com.system.bean.Userinf;
import com.system.dao.UserDao;
import com.system.dao.UserinfDao;


@Service
public class UserService {
    @Autowired
    UserDao Mapper;
    @Autowired
    UserinfDao infMapper;
    
    public boolean login(String username, String password)
    {
        
        User user=Mapper.selectbyname(username);
        if(user!=null)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    public int getuserId(String username) {
        User user = Mapper.selectbyname(username);
        if(user != null) {
            return user.getId();
        }
        return 0;
    }
    
    public boolean register(String username,String password,String stuemail,String interests) {
        User user = new User();
        Userinf userinf = new Userinf();
        
        user.setId(0);
        user.setPassword(password);
        user.setUsername(username);
        userinf.setEmail(stuemail);
        userinf.setUsername(username);
        userinf.setInterests(interests);
        boolean x1 = Mapper.insertintoUser(user);
        boolean x2 = infMapper.insertintoUserinf(userinf);
        return (x1 & x2);
    }
    
}
