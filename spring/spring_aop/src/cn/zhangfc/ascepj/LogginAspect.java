package cn.zhangfc.ascepj;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
		System.out.println("before,方法名:"+methodName+",and args"+args);
	}
	
	
	 @After("execution(* cn.zhangfc.ascepj.*.*(..))")
	    public void afterMethod(JoinPoint joinpoint){
	        //注意，JoinPoint来自org.aspectj.lang.JoinPoint，小心导错包
	        //方法名
	        String methodName = joinpoint.getSignature().getName();
	        //方法参数
	        List<Object> args = Arrays.asList(joinpoint.getArgs());
	        System.out.println("after,method :"+methodName+" ,and:"+args);
	    }
	 
	 
	  /**
	     * 返回通知: 方法正常执行完后调用，如果有异常，则不调用
	     *             可以访问到方法的返回值
	     * @param joinPoint
	     * @param result   方法的返回值
	     */
	 //返回通知
	 @AfterReturning(value="execution(* cn.zhangfc.ascepj.*.*(..))",returning="result")
	 public void afterReturning(JoinPoint jp,Object result)
	 {
		 String methodName = jp.getSignature().getDeclaringTypeName();
		 System.out.println("方法名："+methodName+"，返回值："+result);
	 }
	 
	 @AfterThrowing(value="execution(* cn.zhangfc.ascepj.*.*(..))",throwing="ex")
	 public void afterException(JoinPoint jp,Exception ex)
	 {
		 System.out.println(jp.getSignature().getDeclaringTypeName()+"方法发生了"+ex+"异常");
	 }
}
