package cn.zhangfc.scan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.zhangfc.scan.respository.MyRespository;

@Service("myService")
public class MyServiceImpl implements MyService {

	@Autowired(required=true)
	@Qualifier(value="myRespository")
	private  MyRespository respository;
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("Œ“ «MyServiceImpl");
	}

	@Override
	public String toString() {
		return "MyServiceImpl [respository=" + respository + "]";
	}
	

}
