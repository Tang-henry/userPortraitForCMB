package com.fid.dto.helper;

import java.util.List;

import com.fid.model.business.userLaber.EveryDayHaveStock;

public class SetBatchUserHaveStockHelperDto {
	private Long userId;
	
	private List<OneDayHaveStockDto> oneDayList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<OneDayHaveStockDto> getOneDayList() {
		return oneDayList;
	}

	public void setOneDayList(List<OneDayHaveStockDto> oneDayList) {
		this.oneDayList = oneDayList;
	}
	
}
