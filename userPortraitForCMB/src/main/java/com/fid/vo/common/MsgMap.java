package com.fid.vo.common;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.fid.common.myEnum.common.CommonConst;

public class MsgMap extends HashMap{

	public void putOperateSuccess(Object obj){
		this.put(CommonConst.MsgMapKeys.operateSuccess.getKey(), obj);
	}
	
	public void putNum(Object obj){
		this.put(CommonConst.MsgMapKeys.num.getKey(), obj);
	}
	
	public void putMsg(Object obj){
		this.put(CommonConst.MsgMapKeys.msg.getKey(), obj);
	}
	
	public void putCode(Object obj){
		this.put(CommonConst.MsgMapKeys.code.getKey(), obj);
	}
	
	public void putData(Object obj){
		this.put(CommonConst.MsgMapKeys.data.getKey(), obj);
	}
	
	public void putYouInput(Object obj){
		this.put(CommonConst.MsgMapKeys.youInput.getKey(), obj);
	}
	
	public void setProperty(Boolean operateSuccess, String code, String msg){
		if(operateSuccess != null){
			this.put(CommonConst.MsgMapKeys.operateSuccess.getKey(), operateSuccess);
		}
		
		if(StringUtils.isNotEmpty(code)){
			this.put(CommonConst.MsgMapKeys.code.getKey(), code);
		}
		
		if(StringUtils.isNotEmpty(msg)){
			this.put(CommonConst.MsgMapKeys.msg.getKey(), msg);
		}
	}
	
	public void setFail(CommonConst.SystemValidator csEnum){
		setProperty(false,
				csEnum.getCode(),
				csEnum.getStatus());
	}
	
	public void doFail(String msg){
		putMsg(msg);
		setProperty(false,
				CommonConst.SystemValidator.systemExcption.getCode(),
				CommonConst.SystemValidator.systemExcption.getStatus());
	}
	
	public void doFail(){
		setProperty(false,
				CommonConst.SystemValidator.systemExcption.getCode(),
				CommonConst.SystemValidator.systemExcption.getStatus());
	}
	
	public void doSuccess(){
		setProperty(true,
				CommonConst.SystemValidator.doSuccess.getCode(),
				CommonConst.SystemValidator.doSuccess.getStatus());
	}
	
	public void doSuccess(Object retData){
		putData(retData);
		setProperty(true,
				CommonConst.SystemValidator.doSuccess.getCode(),
				CommonConst.SystemValidator.doSuccess.getStatus());
	}
}
