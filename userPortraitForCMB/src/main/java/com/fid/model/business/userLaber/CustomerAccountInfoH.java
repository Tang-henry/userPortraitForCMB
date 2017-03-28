package com.fid.model.business.userLaber;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerAccountInfoH implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8682098378905419892L;

	private Long id;

    private String custNo;

    private String securitiesFund;

    private String totalFund;
    
    private String busiCodeTags;

    private BigDecimal dailyProfitAndLoss;

    private Date transTime;

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

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

	@Override
	public String toString() {
		return "CustomerAccountInfoH [id=" + id + ", custNo=" + custNo + ", securitiesFund=" + securitiesFund
				+ ", totalFund=" + totalFund + ", busiCodeTags=" + busiCodeTags + ", dailyProfitAndLoss="
				+ dailyProfitAndLoss + ", transTime=" + transTime + "]";
	}
    
}