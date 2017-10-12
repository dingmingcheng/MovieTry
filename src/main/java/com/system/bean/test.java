package com.system.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;



public class test {
    public static void main(String[] args) throws Exception {
        String filename = "D:\\j2eeworkspace\\MovieTry\\datafile\\item.csv";
        File file = new File(filename);
        FileWriter filewrite= new FileWriter(file, true);
        String data = "\n123,123,123";
        filewrite.write(data);
        filewrite.close();
//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("apples", "3kg");
//        jsonObj.put("sugar", "1kg");
//        jsonObj.put("pastry", "2.4kg");
//        jsonObj.put("bestEaten", "outdoors");
//        System.out.println(jsonObj.toString());
//        String x = jsonObj.toString();
//        JSONObject jsonObj1 = JSON.parseObject(x);
//        System.out.println(jsonObj1.getString("apples"));
//        jsonObj1.put("apples", "6kg");
//        System.out.println(jsonObj1.toString());
        
    }
}
