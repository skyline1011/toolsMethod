package com.lsrobot.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

/**
 * FastJson工具类
 */
public class FastJsonUtils {
    private static final SerializeConfig config;
    static {
        config = new SerializeConfig();
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

    private static final SerializerFeature[] features = {
            SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
    };

    public static String toJSONString(Object obj){
        return JSON.toJSONString(obj,config,features);
    }

    public static String toJSONNoFeatures(Object obj){
        return JSON.toJSONString(obj,config);
    }

    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    // 转换为数组
    public static <T> Object[] toArray(String text){
        return toArray(text,null);
    }

    // 转换为数组
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    //将javabean转化为序列化的json字符串
    public static <T> Object beanToJson(T t) {
        String textJson = JSON.toJSONString(t);
        Object objectJson  = JSON.parse(textJson);
        return objectJson;
    }

    //将string转化为序列化的json字符串
    public static Object textToJson(String text) {
        Object objectJson  = JSON.parse(text);
        return objectJson;
    }

    //json字符串转化为map
    public static Map stringToCollect(String s) {
        Map m = JSONObject.parseObject(s);
        return m;
    }

    //将map转化为string
    public static String collectToString(Map m) {
        String s = JSONObject.toJSONString(m);
        return s;
    }

    public static void main(String[] args) {
        Person p = new Person("zhangsan",20);
        String str = "{\"name\":\"zhangsan\",\"aged\":20}";
        JSONObject jsonObject = (JSONObject) beanToJson(p);//对象转json
        System.out.println(jsonObject.toString());
        JSONObject jsonStr = (JSONObject) textToJson(str);//字符串转Json
        System.out.println(jsonStr.toString());
        System.out.println("-----------------------------------");
        Map map = stringToCollect(jsonObject.toString());//Json转Map
        System.out.println(map.toString());
        JSONObject newJson = (JSONObject) textToJson(collectToString(map));//Map转Json
        System.out.println("new:----" + newJson);
    }
}
