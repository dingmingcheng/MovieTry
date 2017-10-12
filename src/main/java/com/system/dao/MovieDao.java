package com.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.bean.Movie;

public interface MovieDao {
    public List<Movie> selectByType(@Param("movietype") String type);
    public Movie selectById(@Param("id")String id);
}
