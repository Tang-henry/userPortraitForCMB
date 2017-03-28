package com.fid.model.business.userLaber;

import java.io.Serializable;
import java.util.Date;

public class CustomerBusinessTransLog implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4524476750352769492L;

	private Long id;

    private String custNo;

    private String businessCode;

    private String businessName;

    private Date transDate;

    private Date transTime;

    private Date createTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "CustomerBusinessTransLog [id=" + id + ", custNo=" + custNo + ", businessCode=" + businessCode
				+ ", businessName=" + businessName + ", transDate=" + transDate + ", transTime=" + transTime
				+ ", createTime=" + createTime + ", remark=" + remark + "]";
	}
    
}