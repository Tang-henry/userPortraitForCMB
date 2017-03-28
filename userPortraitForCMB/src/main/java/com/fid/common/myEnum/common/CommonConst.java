package com.fid.common.myEnum.common;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CommonConst {
	
	public static enum MsgMapKeys{
		
		num("返回数量","num"),
		data("返回数据", "data"),
		code("返回代码", "code"),
		operateSuccess("操作是否成功", "operateSuccess"),
		msg("返回说明", "msg"),
		youInput("接口入参", "youInput");

		private String description;

		private String key;

		private MsgMapKeys(String description, String key) {
			this.description = description;
			this.key = key;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}
	
	public static enum SystemValidator {
		doSuccess("请求成功","0"),
		systemExcption("系统异常", "-1000"),
		userValidateFail("用户验证失败", "-1"),
		requestParamNotComplete("请求参数不完整", "-2");

		private String status;

		private String code;

		private SystemValidator(String status, String code) {
			this.status = status;
			this.code = code;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}
	/*com.common.common.ConsumerOperateType.OPERATE_VIEW*/
	public static enum CommonStructureTableAllFieldEnum {
		views("观看","1"),
		likes("点赞", "2");

		private String description;

		private String key;

		private CommonStructureTableAllFieldEnum(String description, String key) {
			this.description = description;
			this.key = key;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}
}
