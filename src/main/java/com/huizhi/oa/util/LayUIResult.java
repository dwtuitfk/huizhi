package com.huizhi.oa.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.List;


/**
 * created by dwtuitfk on 2019/2/3.
 * 自定义响应结构
 */

public class LayUIResult {


    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();


    // 响应业务状态,0   
    private Integer code;


    // 响应消息
    private String msg;
    // 数据总数
    private Integer count;


    // 响应中的数据
    private Object data;


    public static LayUIResult build(Integer code, String msg, Object data) {
        return new LayUIResult(code, msg, data);
    }


    public static LayUIResult ok(Object data) {
        return new LayUIResult(data);
    }


    public static LayUIResult ok() {
        return new LayUIResult(null);
    }


    public LayUIResult() {


    }


    public static LayUIResult build(Integer code, String msg) {
        return new LayUIResult(code, msg, null);
    }

    public static LayUIResult build(Integer code, String msg, int count) {
        LayUIResult result = new LayUIResult(code, msg, null);

        return new LayUIResult(code, msg, null);
    }


    public LayUIResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        if (data != null && data.getClass().isArray()) {
            this.count = Array.getLength(data);
            ;
        }
    }


    public LayUIResult(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
        if (data != null && data.getClass().isArray()) {
            this.count = Array.getLength(data);
            ;
        }
    }


//    public Boolean isOK() {
//        return this.code == 200;
//    }


    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Object getData() {
        return data;
    }


    public void setData(Object data) {
        this.data = data;
    }


    public Integer getCount() {
        return count;
    }


    public void setCount(Integer count) {
        this.count = count;
    }


    /**
     *      * 将json结果集转化为MeiritingResult对象
     *      * 
     *      * @param jsonData json数据
     *      * @param clazz MeiritingResult中的object类型
     *      * @return
     *      
     */
    public static LayUIResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, LayUIResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     *      * 没有object对象的转化
     *      * 
     *      * @param json
     *      * @return
     *      
     */
    public static LayUIResult format(String json) {
        try {
            return MAPPER.readValue(json, LayUIResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *      * Object是集合转化
     *      * 
     *      * @param jsonData json数据
     *      * @param clazz 集合中的类型
     *      * @return
     *      
     */
    public static LayUIResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }


}
