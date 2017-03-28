package com.fid.model.business.userLaber;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerAccountTransLog implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3693145990014908472L;

	private Long id;

    private String custNo;

    private String custName;

    private String fundAccNo;

    private BigDecimal transAmt;

    private String secType;

    private String secCode;

    private String secShortName;

    private String businessCode;

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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getFundAccNo() {
        return fundAccNo;
    }

    public void setFundAccNo(String fundAccNo) {
        this.fundAccNo = fundAccNo == null ? null : fundAccNo.trim();
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType == null ? null : secType.trim();
    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode == null ? null : secCode.trim();
    }

    public String getSecShortName() {
        return secShortName;
    }

    public void setSecShortName(String secShortName) {
        this.secShortName = secShortName == null ? null : secShortName.trim();
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
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
		return "CustomerAccountTransLog [id=" + id + ", custNo=" + custNo + ", custName=" + custName + ", fundAccNo="
				+ fundAccNo + ", transAmt=" + transAmt + ", secType=" + secType + ", secCode=" + secCode
				+ ", secShortName=" + secShortName + ", businessCode=" + businessCode + ", transDate=" + transDate
				+ ", transTime=" + transTime + ", createTime=" + createTime + "]";
	}
    
}