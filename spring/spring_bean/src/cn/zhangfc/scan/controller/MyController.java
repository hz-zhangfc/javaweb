package cn.zhangfc.scan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import cn.zhangfc.scan.service.MyService;

@Controller
public class MyController {
	private  MyService myService;
	
	public MyService getMyService() {
		return myService;
	}

	@Autowired
	public void setMyService(@Qualifier("myService") MyService myService) {
		this.myService = myService;
	}

	public void say()
	{
		System.out.println("Œ“ «controller..");
	}

	@Override
	public String toString() {
		return "MyController [myService=" + myService + "]";
	}
	
}
