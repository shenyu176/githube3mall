package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**
	 * 需求:后台页面跳转
	 * 请求:localhost:8082/{页面名称}
	 * 
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
}	
