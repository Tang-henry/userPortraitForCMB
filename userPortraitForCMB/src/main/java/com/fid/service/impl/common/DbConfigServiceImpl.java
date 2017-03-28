package com.fid.service.impl.common;

import com.fid.mapper.common.DbConfigMapper;
import com.fid.model.common.DbConfig;
import com.fid.service.common.DbConfigService;
import com.fid.service.impl.BaseService;
import com.github.pagehelper.PageHelper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
@Service("dbConfigService")
public class DbConfigServiceImpl extends BaseService<DbConfig> implements DbConfigService {

	@Autowired
	private DbConfigMapper dbConfigMapper;
	
	@Override
	public List<DbConfig> queryAll() {
		// TODO Auto-generated method stub
		return dbConfigMapper.queryAll();
	}

	@Override
	public Map<String, String> queryAllTranToMap() {
		List<DbConfig> list = queryAll();
		Map<String, String> retMap = new HashMap<String, String>();
		
		if(CollectionUtils.isNotEmpty(list)){
			for(DbConfig dbConfig : list){
				if(dbConfig != null 
					&& StringUtils.isNotEmpty(dbConfig.getDbKey())
					&& StringUtils.isNotEmpty(dbConfig.getDbValue())){
					retMap.put(dbConfig.getDbKey(), dbConfig.getDbValue());
				}
			}
		}
		
		return retMap;
	}

	@Override
	public ConcurrentHashMap<String, String> queryConfigMap(ArrayList<String> queryParamList) {
		ConcurrentHashMap<String, String> retMap = new ConcurrentHashMap<String, String>();
		
		Map hm = new HashMap();
		hm.put("queryParamList", queryParamList);
		List<DbConfig> list = (List<DbConfig>)dbConfigMapper.queryConfigMap(hm);
		if(!CollectionUtils.isEmpty(list)){
			for(DbConfig dbConfig : list){
				retMap.put(dbConfig.getDbKey(), dbConfig.getDbValue());
			}
		}
		
		return retMap;
	}
	
	//分页查询
    //PageHelper.startPage(page, rows);
	
}
