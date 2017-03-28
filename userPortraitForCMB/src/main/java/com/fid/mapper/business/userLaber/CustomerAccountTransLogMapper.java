package com.fid.mapper.business.userLaber;

import java.util.List;
import java.util.Map;

import com.fid.model.business.userLaber.CustomerAccountTransLog;
import com.fid.util.MyMapper;

public interface CustomerAccountTransLogMapper extends MyMapper<CustomerAccountTransLog>{
    /**
     * 根据交易时间范围等条件得到List
     */
    public List<CustomerAccountTransLog> getByCondition(Map<String,Object> map);
    
}