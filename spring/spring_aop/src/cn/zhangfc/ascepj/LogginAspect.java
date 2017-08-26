package cn.zhangfc.ascepj;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * 声明该类为切面:
 *    1.让IOC容器创建这个类的bean(@Component)
 *    2.声明为切面(@Aspect)
 */
@Aspect
@Component
public class LogginAspect {
	//声明这是一个前置通知
	//@Before("execution(* com.zj.asceptj.*.*(..))")
	//*号是一个占位符，表示任意字符，大家可以跟原来的写法对比一下
	@Before("execution(* cn.zhangfc.ascepj.Calcultor.add(int,int))")
	//Calcultor是接口，接口以及他的实现类被切吗？
	public void before(JoinPoint jp)
	{
		//注意，JoinPoint来自org.aspectj.lang.JoinPoint，小心导错包
        //方法名
		String methodName = jp.getSignature().getName();
		//方法参数
		List<Object> args =  Arrays.asList(jp.getArgs());
		System.out.println("方法名:"+methodName+",and args"+args);
	}
	 @After("execution(* cn.zhangfc.ascepj.*.*(..))")
	    public void afterMethod(JoinPoint joinpoint){
	        //注意，JoinPoint来自org.aspectj.lang.JoinPoint，小心导错包
	        //方法名
	        String methodName = joinpoint.getSignature().getName();
	        //方法参数
	        List<Object> args = Arrays.asList(joinpoint.getArgs());
	        System.out.println("method :"+methodName+" ,and:"+args);
	    }
}
