package com.nssol.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.FilesRequest;
import com.nssol.controller.response.FilesResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about Files" })
public class FilesController {
	
	@Value("${versionUpdatePath}")
	 private String versionUpdatePath;

	@ApiOperation(value = "获取文件夹中最大文件名", notes = "获取最大文件名", produces = "application/json")
    @RequestMapping(value = "/getMaxFileName", method = RequestMethod.POST)
	public FilesResponse getMaxFileName(@RequestBody FilesRequest filesRequest){
		String fileNameMax="";
		Integer versionNum=0;
		Boolean blnUpdate=false;
		String versionNo =filesRequest.getFileName();
		// 获取路径中所有文件
		 File file = new File(versionUpdatePath);

	        String [] fileName = file.list();
          if(fileName !=null && fileName.length>0) {
       	   Arrays.sort(fileName);
       	   fileNameMax=fileName[fileName.length-1];
       	   fileNameMax=fileNameMax.replace(".zip", "");
       	   versionNum =compareAppVersion(versionNo,fileNameMax);
          }
          
          if(versionNum < 0){
        	  blnUpdate=true;
          }
     
          FilesResponse retResponse = new FilesResponse();
          retResponse.setFileName(fileNameMax);
          retResponse.setIsUpdate(blnUpdate);
  		return retResponse;
	}
	
	@ApiOperation(value = "下载最新更新包", notes = "获取最新更新包", produces = "application/json")
    @RequestMapping(value = "/getDownLoadFiles", method = RequestMethod.POST)
	public FilesResponse getDownLoadFiles(@RequestBody FilesRequest filesRequest) {
		
		FilesResponse filesR=new FilesResponse();
		filesR.setIsUpdate(false);
		filesR.setFileName(filesRequest.getFileName());
	    String path = versionUpdatePath+"/"+filesRequest.getFileName();
	 
	    File imageFile = new File(path);
	    if (!imageFile.exists()) {
	        return filesR;
	    }

	    InputStream fis;
		try {
			fis = new FileInputStream(imageFile);
			 byte[] bytes;
				try {
					bytes = FileCopyUtils.copyToByteArray(fis);
					filesR.setFileContect(bytes);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return filesR;
	}
	
	/**
     * 比较APP版本号的大小
     * <p>
     * 1、前者大则返回一个正数
     * 2、后者大返回一个负数
     * 3、相等则返回0
     *
     * @param version1 app版本号
     * @param version2 app版本号
     * @return Integer
     */
	 public Integer compareAppVersion(String version1, String version2) {
	        
	        // 注意此处为正则匹配，不能用.
	        String[] versionArray1 = version1.split("\\.");
	        String[] versionArray2 = version2.split("\\.");
	        int idx = 0;
	        // 取数组最小长度值
	        Integer minLength = Math.min(versionArray1.length, versionArray2.length);
	        Integer diff = 0;
	        // 先比较长度，再比较字符
	        while (idx < minLength
	                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0
	                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {
	            ++idx;
	        }
	        // 如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大
	        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
	        return diff;
	    }
}

