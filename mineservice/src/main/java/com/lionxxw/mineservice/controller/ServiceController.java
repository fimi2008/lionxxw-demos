package com.lionxxw.mineservice.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class ServiceController {
	protected static final Log logger = LogFactory.getLog(ServiceController.class);
	
	// 增加此注解,就可以有效的解决返回的json数据中文乱码问题
	@RequestMapping(value="update", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String json(){
		logger.info("json 接口接受请求~~~~~~~");
		
		JSONObject json = new JSONObject();
		json.put("versionName", "v2.0");
		json.put("versionCode", 2);
		json.put("description", "新增xxx功能,赶紧来体验吧~~");
		json.put("downloadUrl", "http://10.10.11.126:8080/download/app.apk");
		
		logger.info("json 返回数据~~~~~~~"+json);
		long[] src = new long[5];
		System.arraycopy(src, 1, src, 0, src.length - 1);
		src[src.length - 1] = System.currentTimeMillis();
		if (src[0] >= (System.currentTimeMillis() - 5000)){
			System.out.println("已经频繁访问"+src.length +"次了");
		}
		return json.toJSONString();
	}
}