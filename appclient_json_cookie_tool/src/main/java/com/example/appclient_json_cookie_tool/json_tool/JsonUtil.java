package com.example.ba.myjacksondemo.json_tool;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Azusa on 2016/1/24.
 */
public class JsonUtil {

    //将一个类转换陈json字符串
    public static <T> String getJsonStringformat(T oject)  {
        ObjectMapper mapper = new ObjectMapper();
        String JsonString = null;
        try {
            JsonString = mapper.writeValueAsString(oject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return JsonString;
    }

    //将一个json字符串转成list
    public static ArrayList<String> getlistfromString(String string) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> list = new ArrayList<>();
        if (string==null||string.trim().length()==0) {
            return list;
        }

        try {
            list = mapper.readValue(string, new TypeReference<ArrayList<String>>() {
            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //将一个Json字符串转换成对应的类
    public static <T> T getObjectfromString(String jsonString, Class<T> clazz)  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param json json数据
     * @param key  要获取的数据的key
     * @return 该key对应的值
     */
    public static String getStringbyKey(String json, String key)  {
        try {
            JSONObject jsonObject = null;
            jsonObject = new JSONObject(json);
            return jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

