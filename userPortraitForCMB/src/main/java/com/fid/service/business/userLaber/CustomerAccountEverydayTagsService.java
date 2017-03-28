package com.fid.service.business.userLaber;

import java.util.Map;

import com.fid.model.business.userLaber.CustomerAccountEverydayTags;
import com.fid.service.IService;
import com.fid.vo.common.MsgMap;

public interface CustomerAccountEverydayTagsService extends IService<CustomerAccountEverydayTags>{
	
	/**
	 * 生成客户每天的账户标签插入数据库
	 * @return
	 */
	public boolean handleDailyTagsToDbForCustomer();
	
	
	/**
	 * 单个客户在一定时间范围内的标签特征(日、周、月、年)
	 */
    public MsgMap getCustomerAccountTags(Map<String,Object> map);
    
    /**
     * 一次性生成客户所有的历史数据账户标签
     */
    public boolean handleAllDailyTagsToDbForCustomer();

}
