package com.huizhi.oa.util;

public class ResultMap<T> {
	private  int code;
    private String msg;
    private  int count;
    private  T data;
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public T getData() {
        return data;
    }
 
    public void setData(T data) {
        this.data = data;
    }
 
    public int getCode() {
        return code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
 
    public int getCount() {
        return count;
    }
 
    public void setCount(int count) {
        this.count = count;
    }
 
    public ResultMap(String msg, T data, int code, int count) {
    	this.code = code;
        this.msg = msg;
        
        this.count = count;
        this.data = data;
    }
 
    public ResultMap() {
    }
}