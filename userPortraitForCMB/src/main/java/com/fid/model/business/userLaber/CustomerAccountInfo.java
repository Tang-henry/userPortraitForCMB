package com.fid.model.business.userLaber;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerAccountInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8125640081004822567L;

	private Long id;

    private String custNo;

    private String custName;

    private String securitiesFund;

    private String totalFund;
    
    private String busiCodeTags;

    private BigDecimal dailyProfitAndLoss;

    private Date transDate;

    private Date transTime;

    private Date createTime;

    private Date updateTime;

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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getSecuritiesFund() {
        return securitiesFund;
    }

    public void setSecuritiesFund(String securitiesFund) {
        this.securitiesFund = securitiesFund == null ? null : securitiesFund.trim();
    }

    public String getTotalFund() {
        return totalFund;
    }

    public void setTotalFund(String totalFund) {
        this.totalFund = totalFund == null ? null : totalFund.trim();
    }

    public String getBusiCodeTags() {
		return busiCodeTags;
	}

	public void setBusiCodeTags(String busiCodeTags) {
		this.busiCodeTags = busiCodeTags;
	}

	public BigDecimal getDailyProfitAndLoss() {
        return dailyProfitAndLoss;
    }

    public void setDailyProfitAndLoss(BigDecimal dailyProfitAndLoss) {
        this.dailyProfitAndLoss = dailyProfitAndLoss;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "CustomerAccountInfo [id=" + id + ", custNo=" + custNo + ", custName=" + custName + ", securitiesFund="
				+ securitiesFund + ", totalFund=" + totalFund + ", busiCodeTags=" + busiCodeTags
				+ ", dailyProfitAndLoss=" + dailyProfitAndLoss + ", transDate=" + transDate + ", transTime=" + transTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}