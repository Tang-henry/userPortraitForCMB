package com.fid.service.impl.business.userLaber;

import com.fid.dto.helper.OneDayHaveStockDto;
import com.fid.dto.helper.SetBatchUserHaveStockHelperDto;
import com.fid.mapper.business.userLaber.EveryDayHaveStockMapper;
import com.fid.mapper.common.DbConfigMapper;
import com.fid.model.business.userLaber.EveryDayHaveStock;
import com.fid.model.common.DbConfig;
import com.fid.service.business.userLaber.EveryDayHaveStockService;
import com.fid.service.common.DbConfigService;
import com.fid.service.impl.BaseService;
import com.fid.util.common.MyDateUtil;
import com.fid.vo.common.MsgMap;
import com.github.pagehelper.PageHelper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
@Service("everyDayHaveStockService")
public class EveryDayHaveStockServiceImpl extends BaseService<EveryDayHaveStock> implements EveryDayHaveStockService {

	@Autowired
	private EveryDayHaveStockMapper everyDayHaveStockMapper;
	
	@Autowired
	private MyDateUtil myDateUtil;

	@Override
	public MsgMap setBatchUserHaveStock(SetBatchUserHaveStockHelperDto dto) {
		MsgMap msgMap = new MsgMap();
		List<EveryDayHaveStock> insertList = new ArrayList<EveryDayHaveStock>();
		
		if(CollectionUtils.isNotEmpty(dto.getOneDayList())){
			Long nowTime = new Date().getTime();
			for(OneDayHaveStockDto oneDay : dto.getOneDayList()){
				Long haveTime = myDateUtil.parseDate(oneDay.getHaveTime());
				
				if(CollectionUtils.isNotEmpty(oneDay.getDataList())){
					for(EveryDayHaveStock eds : oneDay.getDataList()){
						eds.setCreateTime(nowTime);
						eds.setUpdateTime(nowTime);
						eds.setHaveTime(haveTime);
						eds.setUserId(dto.getUserId());
						
						insertList.add(eds);
					}
					
				}
			}
		}
		
		everyDayHaveStockMapper.insertList(insertList);
		msgMap.doSuccess();
		return msgMap;
	}
	
	
}
