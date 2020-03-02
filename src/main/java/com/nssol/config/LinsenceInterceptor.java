package com.nssol.config;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.nssol.common.SecretUtil;

public class LinsenceInterceptor implements HandlerInterceptor {

	private String linsenceKey;
	
	public LinsenceInterceptor(String linsenceKey){
		this.linsenceKey = linsenceKey;
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		if(!StringUtils.isEmpty(linsenceKey)) {
			String decryptLinsenceStr = SecretUtil.decrypt(linsenceKey, SecretUtil.KEY);
			if(!StringUtils.isEmpty(decryptLinsenceStr)) {
				String[] linsenceArr = decryptLinsenceStr.split("_");
				if(linsenceArr.length==3) {
					if("NEVER".equals(linsenceArr[1])) {
						return true;
					} else {
						if(linsenceArr[1].length()==8) {
							String nowDateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
							if(Integer.parseInt(nowDateStr)<Integer.parseInt(linsenceArr[1])){
								return true;
							} else {
								setLinsenceErrorInfo(response);
								return false;
							}
						} else {
							setLinsenceErrorInfo(response);
							return false;
						}
					}
				} else {
					setLinsenceErrorInfo(response);
					return false;
				}
			} else {
				setLinsenceErrorInfo(response);
				return false;
			}
		} else {
			setLinsenceErrorInfo(response);
			return false;
		}
	}
	
	private void setLinsenceErrorInfo(HttpServletResponse response) throws IOException{
		OutputStream outputStream = response.getOutputStream();
		response.setHeader("content-type", "text/html;charset=UTF-8");
		byte[] dataByteArr = "LinsenceError".getBytes("UTF-8");
		outputStream.write(dataByteArr);
	}
}
