package com.fid.common.myEnum.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;



public class ConfigTransTimeEnum {
	
	public static enum DbConfigMap{
		transTimeTag1("【9:00-10:00】", "9:00:00-10:00:00"),
		transTimeTag2("【10:00-10:30】", "10:00:00-10:30:00"),
		transTimeTag3("【10:30-11:00】", "10:30:00-11:00:00"),
		transTimeTag4("【11:00-11:30】", "11:00:00-11:30:00"),
		transTimeTag5("【13:00-13:30】", "13:00:00-13:30:00"),
		transTimeTag6("【13:30-14:00】", "13:30:00-14:00:00"),
		transTimeTag7("【14:00-14:30】", "14:00:00-14:30:00"),
		transTimeTag8("【14:30-15:00】", "14:30:00-15:00:00");
		
		
		private String description;

		private String key;

		private DbConfigMap(String description, String key) {
			this.description = description;
			this.key = key;
		}
		
		public static ArrayList<String> getAllKeys(){
			ArrayList<String> retAl = new ArrayList<String>();
			DbConfigMap[] dbconfigArray = DbConfigMap.values();
			if(!ArrayUtils.isEmpty(dbconfigArray)){
				for(DbConfigMap dbConfigMap:dbconfigArray){
					retAl.add(dbConfigMap.getKey());
				}
			}
			return retAl;
		}
		
		public static ArrayList<Map<String,Object>> getAllKeysAndDescription(){
			ArrayList<Map<String,Object>> retAl = new ArrayList<Map<String,Object>>();
			DbConfigMap[] dbconfigArray = DbConfigMap.values();
			if(!ArrayUtils.isEmpty(dbconfigArray)){
				for(DbConfigMap dbConfigMap:dbconfigArray){
					Map<String,Object> maps = new HashMap<String, Object>();
					maps.put(dbConfigMap.getDescription(), dbConfigMap.getKey());
					retAl.add(maps);
				}
			}
			return retAl;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

	}
	
}
