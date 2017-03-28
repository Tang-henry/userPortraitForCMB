package com.fid.model.business.userLaber;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerAccountEverydayTags implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2910838783739811669L;

	private Long id;

    private String custNo;

    private String businessAuthorityTags;

    private String profitAndLossTags;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transDate;

    private Date transTime;

    private Date createTime;

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

    public String getBusinessAuthorityTags() {
        return businessAuthorityTags;
    }

    public void setBusinessAuthorityTags(String businessAuthorityTags) {
        this.businessAuthorityTags = businessAuthorityTags == null ? null : businessAuthorityTags.trim();
    }

    public String getProfitAndLossTags() {
        return profitAndLossTags;
    }

    public void setProfitAndLossTags(String profitAndLossTags) {
        this.profitAndLossTags = profitAndLossTags == null ? null : profitAndLossTags.trim();
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

	@Override
	public String toString() {
		return "CustomerAccountEverydayTags [id=" + id + ", custNo=" + custNo + ", businessAuthorityTags="
				+ businessAuthorityTags + ", profitAndLossTags=" + profitAndLossTags + ", transDate=" + transDate
				+ ", transTime=" + transTime + ", createTime=" + createTime + "]";
	}
    
}