package com.fid.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fid.model.common.DbConfig;
import com.fid.service.common.DbConfigService;

@Controller
public class TestController {
	
	@Autowired
	private DbConfigService dbConfigService;
	
	@RequestMapping("/testQueryAllTranToMap")
	@ResponseBody
	public Map<String, String> testQueryAllTranToMap(){
		return dbConfigService.queryAllTranToMap();
	}
}
