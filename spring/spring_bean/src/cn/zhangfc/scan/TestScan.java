package cn.zhangfc.scan;

import org.junit.Test;

import cn.zhangfc.scan.controller.MyController;
import cn.zhangfc.scan.respository.MyRespository;
import cn.zhangfc.scan.service.MyService;
import cn.zhangfc.test.Test0;

public class TestScan extends Test0 {
	public TestScan()
	{
		super("/cn/zhangfc/scan/scan.xml");
	}
	@Test
	public void test()
	{
		MyComponent component = (MyComponent) get("myComponent");
		MyService service = (MyService) get("myServiceImpl");
		//MyRespository respository = (MyRespository) get("myRespository");
		MyController controller = (MyController) get("myController");
		sop(component);
		sop(service);
		//sop(respository);
		sop(controller);
	}
}
