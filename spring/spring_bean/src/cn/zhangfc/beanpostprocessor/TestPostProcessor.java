package cn.zhangfc.beanpostprocessor;

import org.junit.Test;

import cn.zhangfc.test.Test0;

public class TestPostProcessor extends Test0 {

	public TestPostProcessor()
	{
		super("/cn/zhangfc/beanpostprocessor/beanpostprocessor.xml");
	}
	
	@Test
	public void test()
	{
		Person p = (Person) get("zs");
		sop(p);
	}
}
