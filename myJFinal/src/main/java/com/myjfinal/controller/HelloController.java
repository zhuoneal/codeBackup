package com.myjfinal.controller;

import com.jfinal.core.Controller;  

/** 
 * @author jack.song 
 * @time 2014年12月26日 
 */  
public class HelloController extends Controller {  
  
    public void index(){  
    	renderText("Hello JFinal World.111");
        //render("/index.ftl");  
    }  
}