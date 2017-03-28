package com.fid.service.impl.business.userLaber;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fid.common.myEnum.common.ConfigTransTimeEnum;
import com.fid.mapper.business.userLaber.CustomerAccountInfoHMapper;
import com.fid.mapper.business.userLaber.CustomerAccountInfoMapper;
import com.fid.mapper.business.userLaber.CustomerAccountTransLogMapper;
import com.fid.mapper.business.userLaber.CustomerHabitEverydayTagsMapper;
import com.fid.model.business.userLaber.CustomerAccountInfo;
import com.fid.model.business.userLaber.CustomerAccountTransLog;
import com.fid.model.business.userLaber.CustomerHabitEverydayTags;
import com.fid.service.business.userLaber.CustomerHabitEverydayTagsService;
import com.fid.service.impl.BaseService;
import com.fid.util.common.MyDateUtil;
import com.fid.vo.common.MsgMap;


@Service("customerHabitEverydayTagsService")
public class CustomerHabitEverydayTagsServiceImpl extends BaseService<CustomerHabitEverydayTags> implements CustomerHabitEverydayTagsService {

	@Autowired
	private MyDateUtil myDateUtil;
	
	@Autowired
	private CustomerAccountInfoMapper customerAccountInfoMapper;
	
	@Autowired
	private CustomerAccountInfoHMapper customerAccountInfoHMapper;
	
	@Autowired
	private CustomerAccountTransLogMapper customerAccountTransLogMapper;
	
	@Autowired
	private CustomerHabitEverydayTagsMapper customerHabitEverydayTagsMapper;
	
	
	
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
				// 得到客户当天的交易、基础信息
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("custNo", customerAccountInfo.getCustNo());
				map.put("beginTransTime", start.getTime());
				map.put("endTransTime", end.getTime());
				List<CustomerAccountTransLog> byCondition = customerAccountTransLogMapper.getByCondition(map);
				String transTimeTags = "";          //交易时间标签
				String trans_frequency_tags = "";   //交易频率标签
				String position_feature_tags = "";  //仓位特征标签
				CustomerHabitEverydayTags customerHabitEverydayTags = new CustomerHabitEverydayTags();
				if (byCondition.size() > 0){
					List<Map<String,Object>> timeTags = ConfigTransTimeEnum.DbConfigMap.getAllKeysAndDescription();
					//匹配当天的交易时间跟计算交易次数标签
					for (CustomerAccountTransLog customerAccountTransLog : byCondition) {
						Date transTime = customerAccountTransLog.getTransTime();
						Long transTime2 = getLongTimeByDate(transTime);
						System.out.println("用户交易时间:"+transTime2);
						//交易时间特殊标签("【集合竞价】", "9:15:00-9:25:00")
						Long startTime = myDateUtil.parseDate("9:15:00");
						Long engTime = myDateUtil.parseDate("9:25:00");
						if (transTime2 >= startTime && transTime2 <=engTime) {
							if (!"".equals(transTimeTags)) {
								transTimeTags = transTimeTags +","+ "【集合竞价】";
							}else {
								transTimeTags = transTimeTags + "【集合竞价】";
							}
						}else {
							for (Map<String, Object> map2 : timeTags) {
								for (Entry<String, Object> entry: map2.entrySet()) {
									String times[] = entry.getValue().toString().split("-");
									Long startTime2 = myDateUtil.parseDate(times[0]);
									Long engTime2 = myDateUtil.parseDate(times[1]);
									if (transTime2 >= startTime2 && transTime2 < engTime2) {
										if (!"".equals(transTimeTags)) {
											transTimeTags = transTimeTags +","+ entry.getKey();
										}else {
											transTimeTags = transTimeTags +  entry.getKey();
										}
									}
								}
							}
						}
					}
				}
				//得到客户每日交易频率跟仓位特征
				trans_frequency_tags = String.valueOf(byCondition.size());
				position_feature_tags = getPercentByDouble(Double.parseDouble(customerAccountInfo.getSecuritiesFund()),Double.parseDouble(customerAccountInfo.getTotalFund()));
                //插入
				customerHabitEverydayTags.setCustNo(customerAccountInfo.getCustNo());
				customerHabitEverydayTags.setCreateTime(new Date());
				customerHabitEverydayTags.setTransTimeTags(position_feature_tags);
				customerHabitEverydayTags.setTransFrequencyTags(trans_frequency_tags);
				customerHabitEverydayTags.setPositionFeatureTags(position_feature_tags);
				customerHabitEverydayTags.setTransDate(new Date());
				customerHabitEverydayTags.setTransTime(new Date());
				customerHabitEverydayTagsMapper.insert(customerHabitEverydayTags);
			}
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public MsgMap getCustomerHabitTags(Map<String, Object> map) {
		return null;
	}

	@Override
	public boolean handleAllDailyTagsToDbForCustomer() {
		return false;
	}
	
	/**
	 * 工具方法
	 * @param date
	 * @return
	 */
	public Long getLongTimeByDate(Date date){
		SimpleDateFormat format =  new SimpleDateFormat("HH:mm:ss");
		String timeStr=format.format(date);
		Long transTime2 = null;
		try {
			transTime2 = format.parse(timeStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return transTime2;
	}
	
	/**
	 * 工具方法(两个数相除得到百分数返回,保留两位小数)
	 * @param date
	 * @return
	 */
	public String getPercentByDouble(Double a, Double b) {
		double percent = a / b;
		// 输出一下，确认你的小数无误
		System.out.println("小数：" + percent);
		// 获取格式化对象
		NumberFormat nt = NumberFormat.getPercentInstance();
		// 设置百分数精确度2即保留两位小数
		nt.setMinimumFractionDigits(2);
		// 最后格式化并输出
		System.out.println("百分数：" + nt.format(percent));
		return nt.format(percent);
	}
	
	public static void main(String[] args) {
		List<String> timeTags = new ArrayList<String>();
		timeTags = ConfigTransTimeEnum.DbConfigMap.getAllKeys();
		for (String string : timeTags) {
			System.out.println(string);
		}
		
		DateTime dateTime = new DateTime();
		String nowStr = dateTime.toString("yyyy-MM-dd");
		DateTime date = new DateTime(nowStr);
		Date now = date.toDate();
		System.out.println(now.toString());
	}

}
