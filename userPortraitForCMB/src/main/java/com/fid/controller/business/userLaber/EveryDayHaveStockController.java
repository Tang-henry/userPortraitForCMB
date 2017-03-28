package com.fid.controller.business.userLaber;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fid.dto.helper.SetBatchUserHaveStockHelperDto;
import com.fid.model.common.DbConfig;
import com.fid.service.business.userLaber.EveryDayHaveStockService;
import com.fid.service.common.DbConfigService;
import com.fid.vo.common.MsgMap;

@Controller
public class EveryDayHaveStockController {
	
	@Autowired
	private EveryDayHaveStockService everyDayHaveStockService;
	
	@RequestMapping("/setBatchUserHaveStock")
	@ResponseBody
	public MsgMap setBatchUserHaveStock(String dtoJSONString){
		SetBatchUserHaveStockHelperDto dto = JSON.parseObject(dtoJSONString, SetBatchUserHaveStockHelperDto.class);
		MsgMap msgMap = new MsgMap();
		try {
			msgMap = everyDayHaveStockService.setBatchUserHaveStock(dto);
		} catch (Exception e) {
			e.printStackTrace();
			msgMap.doFail(e.toString());
		}
		
		return msgMap;
	}
}
