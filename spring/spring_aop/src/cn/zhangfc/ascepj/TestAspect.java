package cn.zhangfc.ascepj;

import org.junit.Test;

import test.Test0;

public class TestAspect extends Test0{
	public TestAspect()
	{
		super("cn/zhangfc/ascepj/ascepj.xml");
	}
	@Test
	public void test()
	{
		Calcultor c = (Calcultor) getBean("calcultorImpl");
		c.add(1, 2);
		c.sub(1, 7);
	}
}
