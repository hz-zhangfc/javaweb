package cn.zhangfc.getbean;

import java.util.HashMap;

public class InstanceFactoryBean {
	private HashMap<String,Pen> map = new HashMap<>();
	public InstanceFactoryBean(String name)
	{
		//�������û��ֻΪ�ˡ��������ð�Ϊ�˺���
		map.put("pen1", new Pen("pen1", "��ɫ"));
		map.put("pen2", new Pen("pen2", "��ɫ"));
	}
	public Pen getPen(String name)
	{
		return map.get(name);
	}
}
