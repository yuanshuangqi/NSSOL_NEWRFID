package com.nssol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

@Configuration
public class RabbitMQSendConfig {

	 public static Connection getConnection() throws Exception {
		 
	        //定义连接工厂
	        ConnectionFactory factory = new ConnectionFactory();
	        //设置服务地址
	        factory.setHost(ConnectionMQUtil.getHostName());
	        //端口
	        factory.setPort(Integer.parseInt(ConnectionMQUtil.getPort()));
	        //设置账号信息，用户名、密码、vhost
	        factory.setVirtualHost(ConnectionMQUtil.getVirtualHost());
	        factory.setUsername(ConnectionMQUtil.getUserName());
	        factory.setPassword(ConnectionMQUtil.getPassword());
	        // 通过工程获取连接
	        Connection connection = factory.newConnection();
	        return connection;
	    }
	 
	public static void sendMQ() throws Exception {

		 // 获取到连接以及mq通道
		  Connection connection = null;
	      Channel channel = null;
	      
	   try {
				connection =getConnection();
				
		        // 从连接中创建通道
		         channel = connection.createChannel();
		
		         // 声明exchange
		         channel.exchangeDeclare(ConnectionMQUtil.getExchangeName(),"fanout",true);
	
		        // 消息内容
		        String message = "true";
	
		        channel.basicPublish(ConnectionMQUtil.getExchangeName(),"",MessageProperties.MINIMAL_PERSISTENT_BASIC, message.getBytes()); 
	   
	   } catch (Exception e) {
	        e.printStackTrace();
	    }catch(ExceptionInInitializerError e) {
	    	 e.printStackTrace();
	    }catch(NoClassDefFoundError e) {
	    	e.printStackTrace();
	    }
	   finally {
		    	//关闭通道和连接
		    	if (channel != null) {
		            channel.close();
		        }
		        if (connection != null) {
		            connection.close();
		        }
	    }
	}
}
