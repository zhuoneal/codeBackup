package com.spring.impl;
import org.apache.log4j.Logger;

import com.spring.server.myspring;  
public class loggerTest implements myspring{ 
	private static final Logger LOG = Logger.getLogger(loggerTest.class);  
	public void function() {
		// TODO Auto-generated method stub
		LOG.info("this is log");  
	}
	public String read(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	public int updata(String key) {
		// TODO Auto-generated method stub
		return 0;
	}  	
}
