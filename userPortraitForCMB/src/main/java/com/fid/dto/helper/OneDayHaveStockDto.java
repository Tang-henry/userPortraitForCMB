package com.fid.dto.helper;

import java.util.List;

import com.fid.model.business.userLaber.EveryDayHaveStock;

public class OneDayHaveStockDto {
	private String haveTime;
	
	private List<EveryDayHaveStock> dataList;

	public String getHaveTime() {
		return haveTime;
	}

	public void setHaveTime(String haveTime) {
		this.haveTime = haveTime;
	}

	public List<EveryDayHaveStock> getDataList() {
		return dataList;
	}

	public void setDataList(List<EveryDayHaveStock> dataList) {
		this.dataList = dataList;
	}
	
}
