package com.fid.model.business.userLaber;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fid.mybatis.typehander.TimeStampTypeHandler;

import tk.mybatis.mapper.annotation.ColumnType;

public class UserLabel {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String labelName;
	
	private String labelId;
	
	//com.fid.common.myEnum.business.userLaber.UserLabelEnum.LabelType
	private Integer labelType;
	
	@ColumnType(typeHandler = TimeStampTypeHandler.class)
	private Long labelTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public Integer getLabelType() {
		return labelType;
	}

	public void setLabelType(Integer labelType) {
		this.labelType = labelType;
	}

	public Long getLabelTime() {
		return labelTime;
	}

	public void setLabelTime(Long labelTime) {
		this.labelTime = labelTime;
	}
	
}
