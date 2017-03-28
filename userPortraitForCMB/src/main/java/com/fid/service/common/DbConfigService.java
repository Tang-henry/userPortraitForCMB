package com.fid.service.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fid.model.common.DbConfig;
import com.fid.service.IService;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface DbConfigService extends IService<DbConfig> {

    List<DbConfig> queryAll();
    Map<String, String> queryAllTranToMap();
	ConcurrentHashMap<String, String> queryConfigMap(ArrayList<String> allKeys);
}
