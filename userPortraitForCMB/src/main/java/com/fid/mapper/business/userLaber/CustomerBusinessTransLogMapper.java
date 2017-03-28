package com.fid.mapper.business.userLaber;

import java.util.List;
import java.util.Map;

import com.fid.model.business.userLaber.CustomerBusinessTransLog;
import com.fid.util.MyMapper;

public interface CustomerBusinessTransLogMapper extends MyMapper<CustomerBusinessTransLog>{
    /**
     * 根据交易时间范围等条件得到用户业务交易List
     */
    public List<CustomerBusinessTransLog> getByCondition(Map<String,Object> map);
}