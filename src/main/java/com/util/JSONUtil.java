package com.util;

import com.example.practice.City;
import com.example.practice.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class JSONUtil {
    public  static String provincetoJson(Province province){
        ObjectMapper om=new ObjectMapper();
        try {
            String json=om.writeValueAsString(province);
            return  json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public  static  String provincestoJson(ArrayList<Province> plist){
        ObjectMapper om=new ObjectMapper();
        try {
            String json=om.writeValueAsString(plist);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public  static  String citystoJson(ArrayList<City> clist){
        ObjectMapper om=new ObjectMapper();
        try {
            String json=om.writeValueAsString(clist);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
    public  static  String citytoJson(City city){
        ObjectMapper om=new ObjectMapper();
        try {
            String json=om.writeValueAsString(city);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
    public static String toJson(Object object){  //其实这个就够了 转成Object 属性名和值不影响
        ObjectMapper om=new ObjectMapper();
        try {
            String json=om.writeValueAsString(object);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
