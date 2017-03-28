package com.fid.mapper.business.userLaber;

import java.util.List;

import com.fid.model.business.userLaber.CustomerAccountInfo;
import com.fid.util.MyMapper;

public interface CustomerAccountInfoMapper extends MyMapper<CustomerAccountInfo>{
    
    
    /**
     * 得到所有的用户信息
     */
    public List<CustomerAccountInfo> getAll();
    
    /**
     * 根据cust_no得到用户信息
     */
    public CustomerAccountInfo getOneByCustNo(String custNo);
}