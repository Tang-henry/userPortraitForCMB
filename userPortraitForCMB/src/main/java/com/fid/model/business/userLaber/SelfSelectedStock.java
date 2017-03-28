package com.fid.model.business.userLaber;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fid.mybatis.typehander.TimeStampTypeHandler;

import tk.mybatis.mapper.annotation.ColumnType;

public class SelfSelectedStock {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long userId;
	
	private String stockCode;
	
	@ColumnType(typeHandler = TimeStampTypeHandler.class)
    private Long createTime;
    
    @ColumnType(typeHandler = TimeStampTypeHandler.class)
    private Long updateTime;
    
    @ColumnType(typeHandler = TimeStampTypeHandler.class)
    private Long haveTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Long getHaveTime() {
		return haveTime;
	}

	public void setHaveTime(Long haveTime) {
		this.haveTime = haveTime;
	}
    
}
