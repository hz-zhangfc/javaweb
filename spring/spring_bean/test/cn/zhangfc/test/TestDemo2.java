package cn.zhangfc.test;

import org.junit.Test;

import cn.zhangfc.getbean.Pen;

public class TestDemo2 extends Test0 {
	public TestDemo2()
	{
		super("/cn/zhangfc/getbean/getBean.xml");
	}
	
	@Test
	public void test1()
	{
		Pen p1 = (Pen) super.context.getBean("pen1");
		Pen p2 = (Pen) super.context.getBean("pen2");
		Pen p3 = (Pen) super.context.getBean("pen3");
		sop(p1);
		sop(p2);
		sop(p3);
	}
}
