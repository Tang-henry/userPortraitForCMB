package com.fid.common.myEnum.business.userLaber;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

public class UserLabelEnum {
	public static enum LabelType{
		zhuti("主题标签", 1),
		gainian("概念标签", 2),
		jibenmian("基本面标签", 3);
		
		private String description;

		private Integer key;

		private LabelType(String description, Integer key) {
			this.description = description;
			this.key = key;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

	}
}
