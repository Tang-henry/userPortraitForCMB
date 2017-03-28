package com.fid.util.common;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fid.common.myEnum.common.ConfigStringEnum;
import com.fid.service.common.DbConfigService;


@Component
public class DbConfigUtil {
	
	public static ConcurrentHashMap<String, String> dbConfigMap= new ConcurrentHashMap<String, String>();
	
	@Autowired
	private DbConfigService dbConfigService;
	
	public ConcurrentHashMap<String, String> getDbConfigMapFromDb(){
		return dbConfigService.queryConfigMap(ConfigStringEnum.DbConfigMap.getAllKeys());
	}
	
	public <T> T getObjByClass(String key, Class<T> clazz){
		return JSON.parseObject(getValueByKey(key), clazz);
	}
	
	public JSONArray getJSONArrayValueByKey(String key){
		return JSON.parseArray(getValueByKey(key));
	}
	
	public JSONObject getJSONObjectValueByKey(String key){
		return JSON.parseObject(getValueByKey(key));
	}
	
	public Integer getIntegerValueByKey(String key){
		return new Integer(getValueByKey(key));
	}
	
	public Double getDoubleValueByKey(String key){
		return new Double(getValueByKey(key));
	}
	
	public String getValueByKey(String key) {
		String retStr = null;
		try {
			
			if(dbConfigMap == null){
				dbConfigMap = getDbConfigMapFromDb();
			}
			retStr = dbConfigMap.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return retStr;
		}
		
	}
}
