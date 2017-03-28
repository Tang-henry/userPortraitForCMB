package com.fid.util.common;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component 
public class JsonUtil {
	
	public String objToString(Object obj){
		return JSON.toJSONString(obj);
	}
	
	public <T> T stringToObj(String string ,Class<T> className){
		return JSON.parseObject(string, className);
	}
	
}