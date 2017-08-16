package cn.zhangfc.getbean;

import java.util.HashMap;

public class InstanceFactoryBean {
	private HashMap<String,Pen> map = new HashMap<>();
	public InstanceFactoryBean(String name)
	{
		//这个参数没用只为了。。。。好吧为了好玩
		map.put("pen1", new Pen("pen1", "蓝色"));
		map.put("pen2", new Pen("pen2", "红色"));
	}
	public Pen getPen(String name)
	{
		return map.get(name);
	}
}
