package cn.zhangfc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.xml.ws.spi.Invoker;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

public class CalcultorProxy {
	private Calcultor target ;
	public CalcultorProxy(Calcultor target)
	{
		this.target = target;
	}
	public Object getProxy()
	{
		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("开始计算。。。");
				Object obj = method.invoke(target, args);
				System.out.println("结束计算。。。");
				return obj;
			}
		};
		return Proxy.newProxyInstance(loader, interfaces, h);
	}
}
