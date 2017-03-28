package com.fid.model.business.userLaber;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerHabitEverydayTags implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7104391354506399618L;

	private Long id;

    private String custNo;

    private String transTimeTags;

    private String transFrequencyTags;

    private String positionFeatureTags;
    
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

    public String getTransTimeTags() {
        return transTimeTags;
    }

    public void setTransTimeTags(String transTimeTags) {
        this.transTimeTags = transTimeTags == null ? null : transTimeTags.trim();
    }

    public String getTransFrequencyTags() {
        return transFrequencyTags;
    }

    public void setTransFrequencyTags(String transFrequencyTags) {
        this.transFrequencyTags = transFrequencyTags == null ? null : transFrequencyTags.trim();
    }

    public String getPositionFeatureTags() {
        return positionFeatureTags;
    }

    public void setPositionFeatureTags(String positionFeatureTags) {
        this.positionFeatureTags = positionFeatureTags == null ? null : positionFeatureTags.trim();
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
		return "CustomerHabitEverydayTags [id=" + id + ", custNo=" + custNo + ", transTimeTags=" + transTimeTags
				+ ", transFrequencyTags=" + transFrequencyTags + ", positionFeatureTags=" + positionFeatureTags
				+ ", transDate=" + transDate + ", transTime=" + transTime + ", createTime=" + createTime + "]";
	}
}