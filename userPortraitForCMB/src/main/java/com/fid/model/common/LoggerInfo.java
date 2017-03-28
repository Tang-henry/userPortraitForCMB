package com.fid.model.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fid.mybatis.typehander.TimeStampTypeHandler;

import tk.mybatis.mapper.annotation.ColumnType;

public class LoggerInfo {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long coastTime;
	
	@ColumnType(typeHandler = TimeStampTypeHandler.class)
    private Long requestTime;
    
    @ColumnType(typeHandler = TimeStampTypeHandler.class)
    private Long responseTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCoastTime() {
		return coastTime;
	}

	public void setCoastTime(Long coastTime) {
		this.coastTime = coastTime;
	}

	public Long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
	}

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

}
