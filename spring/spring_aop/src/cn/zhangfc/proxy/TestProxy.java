package cn.zhangfc.proxy;

import org.junit.Test;

public class TestProxy {
	@Test
	public void test()
	{
		CalcultorProxy cp = new CalcultorProxy(new CalculotImpl());
		Calcultor proxy = (Calcultor) cp.getProxy();
		proxy.add(1, 2);
	}
}
