package com.nssol.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionMQUtil {

	 private  static  String hostName;
	 private static String port;
	 private static String userName;
	 private static String password;
	 private static String virtualHost;
	 private static String exchangeName;


	@Value("${rabbitMQ.hostName}")
	public void setHostName(String hostName) {
		ConnectionMQUtil.hostName = hostName;
	}

	@Value("${rabbitMQ.port}")
	public  void setPort(String port) {
		ConnectionMQUtil.port = port;
	}
	
	@Value("${rabbitMQ.userName}")
	public  void setUserName(String userName) {
		ConnectionMQUtil.userName = userName;
	}
	
	@Value("${rabbitMQ.password}")
	public  void setPassword(String password) {
		ConnectionMQUtil.password = password;
	}

	@Value("${rabbitMQ.virtualHost}")
	public  void setVirtualHost(String virtualHost) {
		ConnectionMQUtil.virtualHost = virtualHost;
	}

	@Value("${rabbitMQ.exchangeName}")
	public  void setExchangeName(String exchangeName) {
		ConnectionMQUtil.exchangeName = exchangeName;
	}

	
	public static String getHostName() {
		return hostName;
	}
	
	public static String getPort() {
		return port;
	}

	public static String getUserName() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}

	
	public static String getVirtualHost() {
		return virtualHost;
	}

	public static String getExchangeName() {
		return exchangeName;
	}

}
