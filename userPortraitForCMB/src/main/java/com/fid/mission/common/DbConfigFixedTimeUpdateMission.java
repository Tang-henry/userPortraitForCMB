package com.fid.mission.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fid.util.common.DbConfigUtil;

@Component
public class DbConfigFixedTimeUpdateMission {
	
	@Autowired
	private DbConfigUtil dbConfigUtil;
	
	@Scheduled(cron = "0 0/1 * * * ?")
	@PostConstruct
	public void fixedTimeUpdateDbConfig(){
		dbConfigUtil.dbConfigMap = dbConfigUtil.getDbConfigMapFromDb();
		
		System.out.println(dbConfigUtil.dbConfigMap.toString());
	}
}
