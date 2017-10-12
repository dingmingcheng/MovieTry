package com.system.dao;

import java.util.List;

import com.system.bean.User;
import com.system.bean.Userinf;

public interface UserinfDao {
    public Userinf selectbyname(String username);
    public boolean insertintoUserinf(Userinf x);    
}
