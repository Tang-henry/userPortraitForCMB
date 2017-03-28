package userLaber;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.fid.dto.helper.OneDayHaveStockDto;
import com.fid.dto.helper.SetBatchUserHaveStockHelperDto;
import com.fid.model.business.userLaber.EveryDayHaveStock;
import com.fid.service.business.userLaber.EveryDayHaveStockService;
import com.isea533.mybatis.test.BasicTest;

public class EveryDayHaveStockServiceTest extends BasicTest{
	 
	@Autowired
	private EveryDayHaveStockService everyDayHaveStockService;
	
	@Test
	//{"oneDayList":[{"dataList":[{"stockCode":"000063"}],"haveTime":"2017-03-20"}],"userId":1}
	public void testSetBatchUserHaveStockHelperDto(){
		SetBatchUserHaveStockHelperDto dto = new SetBatchUserHaveStockHelperDto();
		dto.setUserId(1L);
		
		List<OneDayHaveStockDto> oneDayList = new  ArrayList<OneDayHaveStockDto>();
		
		OneDayHaveStockDto oneDay = new OneDayHaveStockDto();
		oneDay.setHaveTime("2017-03-20");
		
		EveryDayHaveStock eds = new EveryDayHaveStock();
		eds.setStockCode("000063");
		List<EveryDayHaveStock> list = new ArrayList<EveryDayHaveStock>();
		list.add(eds);
		
		oneDay.setDataList(list);
		oneDayList.add(oneDay);
		
		dto.setOneDayList(oneDayList);
		String dtoJSONString = JSON.toJSONString(dto);
		System.out.println(dtoJSONString);
		
		SetBatchUserHaveStockHelperDto myDto = JSON.parseObject(dtoJSONString, SetBatchUserHaveStockHelperDto.class);
		System.out.println();
	}
	 
}
