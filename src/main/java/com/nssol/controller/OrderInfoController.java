package com.nssol.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nssol.model.T_Tagging;

@Controller
@RequestMapping("/")
public class OrderInfoController {
	
	@RequestMapping("/orderList")
	@ResponseBody
    public ModelAndView orderList(ModelAndView modelAndView){
		modelAndView.setViewName("orderList");
		return modelAndView;
	}
}
