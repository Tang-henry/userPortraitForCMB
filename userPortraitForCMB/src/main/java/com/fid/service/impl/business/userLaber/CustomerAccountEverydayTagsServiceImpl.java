package com.fid.service.impl.business.userLaber;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fid.mapper.business.userLaber.CustomerAccountEverydayTagsMapper;
import com.fid.mapper.business.userLaber.CustomerAccountInfoHMapper;
import com.fid.mapper.business.userLaber.CustomerAccountInfoMapper;
import com.fid.mapper.business.userLaber.CustomerBusinessTransLogMapper;
import com.fid.model.business.userLaber.CustomerAccountEverydayTags;
import com.fid.model.business.userLaber.CustomerAccountInfo;
import com.fid.model.business.userLaber.CustomerBusinessTransLog;
import com.fid.service.business.userLaber.CustomerAccountEverydayTagsService;
import com.fid.service.impl.BaseService;
import com.fid.util.common.MyDateUtil;
import com.fid.vo.common.MsgMap;

@Service("customerAccountEverydayTagsService")
public class CustomerAccountEverydayTagsServiceImpl extends BaseService<CustomerAccountEverydayTags> implements CustomerAccountEverydayTagsService {

	
	@Autowired
	private MyDateUtil myDateUtil;
	
	@Autowired
	private CustomerAccountInfoMapper customerAccountInfoMapper;
	
	@Autowired
	private CustomerAccountInfoHMapper customerAccountInfoHMapper;
	
	@Autowired
	private CustomerBusinessTransLogMapper customerBusinessTransLogMapper;
	
	@Autowired
	private CustomerAccountEverydayTagsMapper customerAccountEverydayTagsMapper;
	
	
	@Override
	public boolean handleDailyTagsToDbForCustomer() {
		try {
			// 获取请求的当前时间的最大值跟最小值
			SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date start = formater2.parse(formater.format(new Date()) + " 00:00:00");
			Date end = formater2.parse(formater.format(new Date()) + " 23:59:59");
			// 得到所有的用户列表
			List<CustomerAccountInfo> customerAccountInfoList = customerAccountInfoMapper.getAll();
			for (CustomerAccountInfo customerAccountInfo : customerAccountInfoList) {
				// 得到客户当天的业务交易、盈亏信息
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("custNo", customerAccountInfo.getCustNo());
				map.put("beginTransTime", start.getTime());
				map.put("endTransTime", end.getTime());
				List<CustomerBusinessTransLog> byCondition = customerBusinessTransLogMapper.getByCondition(map);
				String transBusiCodeTags = "";               //业务权限标签
				BigDecimal  dailyProfitAndLossTags = null;   //每日盈亏标签
				if (byCondition.size() > 0) {
					//当日有业务交易
					for (CustomerBusinessTransLog customerBusinessTransLog : byCondition) {
						//查看客户基础信息中是否存在该业务
						String busiCodeTags = customerAccountInfo.getBusiCodeTags();
						if (busiCodeTags != null && busiCodeTags.length() != 0) {
							if (busiCodeTags.contains(customerBusinessTransLog.getBusinessName())) {
								transBusiCodeTags = busiCodeTags;
							}else {
								transBusiCodeTags = transBusiCodeTags + "," + customerBusinessTransLog.getBusinessName();
							}
						}else {
							transBusiCodeTags = customerBusinessTransLog.getBusinessName();
						}
					}
				}else {
					//当日没有交易，业务权限标签取历史值
					transBusiCodeTags = customerAccountInfo.getBusiCodeTags();
				}
				
				dailyProfitAndLossTags = customerAccountInfo.getDailyProfitAndLoss();
				
				//插入
				CustomerAccountEverydayTags customerAccountEverydayTags = new CustomerAccountEverydayTags();
				customerAccountEverydayTags.setBusinessAuthorityTags(transBusiCodeTags);
				customerAccountEverydayTags.setCreateTime(new Date());
				customerAccountEverydayTags.setCustNo(customerAccountInfo.getCustNo());
				customerAccountEverydayTags.setProfitAndLossTags(dailyProfitAndLossTags.toString());
				customerAccountEverydayTags.setTransDate(new Date());
				customerAccountEverydayTags.setTransTime(new Date());
				
				customerAccountEverydayTagsMapper.insert(customerAccountEverydayTags);
			}
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public MsgMap getCustomerAccountTags(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean handleAllDailyTagsToDbForCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("1.22");
		System.out.println("construct with a String value: " + a);
		BigDecimal b = new BigDecimal("2.22");
//		a.add(b);
		a = a.add(b);
		
		BigDecimal  dailyProfitAndLossTags = null;
		dailyProfitAndLossTags = new BigDecimal("1.22");
		System.out.println(dailyProfitAndLossTags);
		System.out.println("a plus b is : " + a);
	}

}
