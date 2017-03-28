package com.fid.common.myEnum.common;

import java.util.ArrayList;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;



public class ConfigStringEnum {
	
	public static enum DbConfigMap{
		sendOpenIdArray("自动生成随机数的栏目", "Ftu_sendOpenIdArray");
		
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
