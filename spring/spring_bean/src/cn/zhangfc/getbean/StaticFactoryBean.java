package cn.zhangfc.getbean;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public class StaticFactoryBean {
	private static HashMap<String, Pen> map = new HashMap<>();
	static{
		map.put("pen1", new Pen("pen1", "��ɫ"));
		map.put("pen2", new Pen("pen2", "��ɫ"));
	}
	public static Pen getPen(int i,String carName)
	{
		return map.get(carName);
	}
}
