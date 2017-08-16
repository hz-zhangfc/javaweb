<h1 style="background-color:#E6E6FA">第一阶段：会用</h1>
<h2>一.环境准备</h2>
eclipse+spring-tool-suite
<strong> 注意：可以在这个插件官网上看看eclipse版本和该插件版本是否符合</strong><br/>
<a href="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/spring-tool-suite.PNG">插件的安装</a><br/>
<strong>碰到的问题：当安装失败时，试试勾选最下面那个选项</strong>
<image src="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/1.PNG"/>
<hr/><hr/><hr/>
<h2>二.spring in eclipse</h2>
1.spring 配置文件<br/>
new-->other-->输入spring关键字-->选择spring bean configure file<storng>不清楚可以全部试过去</strong><br/>
<image src="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/2.PNG" width="500" height="200"/>
<strong>一个个点过去看看</strong>
<hr/><hr/><hr/>
<h2>三.IOC</h2>
<strong>一个反射贯穿其中</strong>
<h3>1.HelloSpring</h3>
<p>
内容：<a href="https://github.com/hz-zhangfc/javaweb/blob/master/spring/spring_bean/test/cn/zhangfc/test/TestDemo1.java">ApplicationContext,配置文件路径加载</a>，
<a  href="https://github.com/hz-zhangfc/javaweb/blob/master/spring/spring_bean/src/cn/zhangfc/hello/hello.xml">配置文件编写</a>
</p><hr/><hr/>
<h3>2.属性注入</h3>
<pre>
  &lt;bean name="hellospring" class="cn.zhangfc.hello.HelloSpring">
	  &lt;property name="name" value="张三">&lt;/property>
  &lt;/bean>
</pre><hr/><hr/>
<h3>3.构造方法注入</h3>
<pre>
   <strong>写法一</strong>
   &lt;bean name="person2" class="cn.zhangfc.hello.Person">
		 &lt;constructor-arg value="李四" index="0" > &lt;/constructor-arg>
		 &lt;constructor-arg value="22" index="1" > &lt;/constructor-arg>
		 &lt;constructor-arg value="男" index="2" > &lt;/constructor-arg>
   &lt;/bean>
   <strong>注意：类中要有相对应的构造函数，对了最好写一个无参构造函数保险，不然属性注入或其他地方时会报错</strong>
   <strong>index不加也可以，加了写时顺序可以乱，index不乱就行</strong>
   <strong>写法二</strong>
   &lt;bean name="person2" class="cn.zhangfc.hello.Person">
		 &lt;constructor-arg value="李四" type="java.lang.String" > &lt;/constructor-arg>
		 &lt;constructor-arg value="22" type="int" > &lt;/constructor-arg>
		 &lt;constructor-arg value="男" type="java.lang.String" > &lt;/constructor-arg>
   &lt;/bean>
   <strong>这种写法用在参数个数一致时加以区分</strong>
</pre><hr/><hr/>
<h3>4.配置bean的一些知识点</h3>
<h4>a.字面值</h4>
<ul>
	<li>字面值：可用字符串表示的值，可以通过 <value> 元素标签或 value 属性进行注入。</li>
	<li>基本数据类型及其封装类、String 等类型都可以采取字面值注入的方式</li>
	<li>若字面值中包含特殊字符，可以把字面值包裹起来。使用 &lt;![CDATA[]]>(在xml或html中"&lt;"是特殊字符)</li>
	&lt;property name="name" value="&lt;![CDATA[&lt;哈哈>]]>">&lt;/property>
</ul><hr/>
<h4>b.引用其他bean</h4>
<pre>
	&lt;bean id="car1" class="cn.zhangfc.hello.Car"/>
	&lt;bean id="person" class="cn.zhangfc.hello.Person">
		&lt;property name="car" ref="car1"/>
	&lt;/bean>
</pre><hr/>
<h4>c.内部bean</h4>
<pre>
	&lt;bean id="person2" class="cn.zhangfc.hello.Person">
		&lt;property name="car">
			&lt;!-- 内部 bean, 类似于匿名内部类对象. 不能被外部的 bean 来引用, 也没有必要设置 id 属性 -->
			&lt;bean class="cn.zhangfc.hello.Car">
				&lt;property name="price" value="10000">&lt;/property>
			&lt;/bean>
		&lt;/property>
	&lt;/bean>
</pre><hr/>
<h4>d.null值和级联属性</h4>
<pre>
	<b>级联属性</b>
	&lt;bean id="dao5" class="com.atguigu.spring.ref.Dao">&lt;/bean>
	&lt;bean id="service" class="com.atguigu.spring.ref.Service">
		&lt;!-- 通过 ref 属性值指定当前属性指向哪一个 bean! -->
		&lt;property name="dao" ref="dao5"></property>
	&lt;/bean>
	&lt;bean id="action" class="com.atguigu.spring.ref.Action">
		&lt;property name="service" ref="service2">&lt;/property>
		&lt;!-- 设置级联属性(了解) -->
		&lt;property name="service.dao.dataSource" value="DBCP2">&lt;/property>
	&lt;/bean>
	<b>null值</b>
	&lt;bean id="dao2" class="com.atguigu.spring.ref.Dao">
		&lt;!-- 为 Dao 的 dataSource 属性赋值为 null, 若某一个 bean 的属性值不是 null, 使用时需要为其设置为 null(了解) -->
		&lt;property name="dataSource">&lt;null/>&lt;/property>
	&lt;/bean>
</pre><hr/>
<h4>e.集合属性</h4>
<h5>it is so important</h5>
<h5>List集合</h5>
<pre>
	&lt;bean id="user" class="com.atguigu.spring.helloworld.User">
		&lt;property name="userName" value="Jack">&lt;/property>
		&lt;property name="cars">
			&lt;!-- 使用 list 元素来装配集合属性 -->
			&lt;list>
				&lt;ref bean="car"/>
				&lt;ref bean="car2"/>
			&lt;/list>
		&lt;/property>
	&lt;/bean>
</pre>
<pre>
	<b>需要使用 utility scheme（一个命名空间） 定义集合</b>
	&lt;!-- 声明集合类型的 bean -->
	&lt;util:list id="cars">
		&lt;ref bean="car"/>
		&lt;ref bean="car2"/>
	&lt;/util:list>	
	&lt;bean id="user2">
		&lt;property name="cars" ref="cars">&lt;/property>
	&lt;/bean>
</pre><hr/><hr/>

<h3>5.使用 p 命名空间</h3>
<pre>
	<b>先引入该命名空间</b>
	&lt;bean id="user3" class="com.atguigu.spring.helloworld.User"
		p:cars-ref="cars" p:userName="Titannic">
	&lt;/bean>
</pre><hr/><hr/>
<h3>6.自动装配</h3>
<pre>
	自动装配: 只声明 bean, 而把 bean 之间的关系交给 IOC 容器来完成 
	byType: 根据类型进行自动装配. 但要求 IOC 容器中只有一个类型对应的 bean, 若有多个则无法完成自动装配.
	byName: 若属性名和某一个 bean 的 id 名一致, 即可完成自动装配. 若没有 id 一致的, 则无法完成自动装配
	在使用 XML 配置时, 自动转配用的不多. 但在基于 注解 的配置时, 自动装配使用的较多.
</pre><hr/><hr/>
<h3>7.继承 Bean 配置</h3>
	<b>可以忽略父 Bean 的 class 属性, 让子 Bean 指定自己的类, 而共享相同的属性配置. 但此时 abstract 必须设为 true</b>
	<b>父 Bean 可以作为配置模板, 也可以作为 Bean 实例. 若只想把父 Bean 作为模板, 可以设置 &lt;bean> 的abstract 属性为 true, 
	这样 Spring 将不会实例化这个 Bean</b>
<pre>
	&lt;bean id="father" abstract="true"> 
	    &lt;property name="name" value="parent"/>  
	    &lt;property name="age" value="1"/>  
	&lt;/bean>  
	&lt;bean id="son" class="org.springframework.beans.DerivedTestBean" parent="father" init-method="initialize">  
	    &lt;property name="name" value="override"/>  
	    &lt;!-- age will inherit the value of 1 from the parent bean definition-->  
	&lt;/bean> 	
</pre>
	<b>子 Bean 从父 Bean 中继承配置, 包括 Bean 的属性配置子 Bean 也可以覆盖从父 Bean 继承过来的配置</b>
	<b>并不是&lt;bean> 元素里的所有属性都会被继承. 比如: autowire, abstract 等.</b>
<pre>
	&lt;bean id="inheritedTestBean" abstract="true" class="org.springframework.beans.TestBean">  
	    &lt;property name="name" value="parent"/>  
	    &lt;property name="age" value="1"/>  
	&lt;/bean>  
	&lt;bean id="inheritsWithDifferentClass" class="org.springframework.beans.DerivedTestBean" 
	parent="inheritedTestBean" init-method="initialize">  
	    &lt;property name="name" value="override"/>  
	    &lt;!-- the age property value of 1 will be inherited from parent -->  
	&lt;/bean>  
	&lt;bean id="inheritsWithSameClass" parent="inheritedTestBean" init-method="initialize">  
	    &lt;property name="name" value="override"/>  
	    &lt;!-- the age property value of 1 will be inherited from parent -->  
	&lt;/bean>  
</pre><hr/><hr/>
<h3>8.依赖 Bean 配置</h3>
<ul>
	<li><strong>Spring 允许用户通过 depends-on 属性设定 Bean 前置依赖的Bean，前置依赖的 Bean 会在本 Bean 实例化之前创建好</strong></li>
	<li><strong>如果前置依赖于多个 Bean，则可以通过逗号，空格或的方式配置 Bean 的名称</strong></li>
</strong>
<ul>
<pre>
	&lt;bean id="user6" parent="user" p:userName="维多利亚">&lt;/bean>
	&lt;!-- 测试 depents-on -->	
	&lt;bean id="user5" parent="user" p:userName="Backham" depends-on="user6">&lt;/bean>
</pre><hr/><hr/>
<h3>9.Bean 的作用域</h3>
<ul>
	<li>prototype: 原型的. 每次调用 getBean 方法都会返回一个新的 bean. 且在第一次调用 getBean 方法时才创建实例</li>
	<li>singleton: 单例的. 每次调用 getBean 方法都会返回同一个 bean. 且在 IOC 容器初始化时即创建 bean 的实例. 默认值</li>
</ul>
<pre>
	&lt;bean id="dao2" class="com.atguigu.spring.ref.Dao" scope="prototype">&lt;/bean>
</pre><hr/><hr/>
<h3>10.使用外部属性文件</h3>
<pre>
	配置文件中的数据
	jdbc.user=root
	jdbc.password=1230
	jdbc.driverClass=com.mysql.jdbc.Driver
	jdbc.jdbcUrl=jdbc:mysql:///test
	jdbc.initPoolSize=5
	jdbc.maxPoolSize=10
 	&lt;!--导入外部的资源文件，classpath相当于eclipsed src目录下 -->
	&lt;context:property-placeholder location="classpath:db.properties"/>
	&lt;!-- 配置数据源 -->
	&lt;bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		&lt;property name="user" value="${jdbc.user}">&lt;/property>
		&lt;property name="password" value="${jdbc.password}">&lt;/property>
		&lt;property name="driverClass" value="${jdbc.driverClass}">&lt;/property>
		&lt;property name="jdbcUrl" value="${jdbc.jdbcUrl}">&lt;/property>
		&lt;property name="initialPoolSize" value="${jdbc.initPoolSize}">&lt;/property>
		&lt;property name="maxPoolSize" value="${jdbc.maxPoolSize}">&lt;/property>
	&lt;/bean>
</pre><hr/><hr/>
<h3>11.Spring表达式语言：SpEL</h3>
<ul>
	<li>Spring 表达式语言（简称SpEL）：是一个支持运行时查询和操作对象图的强大的表达式语言。</li>
	<li>语法类似于 EL：SpEL 使用 #{…} 作为定界符，所有在大框号中的字符都将被认为是 SpEL</li>
	<li>SpEL 为 bean 的属性进行动态赋值提供了便利</li>
	<li>通过 SpEL 可以实现：
				通过 bean 的 id 对 bean 进行引用;  
				调用方法以及引用对象中的属性;
				计算表达式的值;
				正则表达式的匹配;</li>

</ul><hr/>
<h4>SpEL：字面量</h4>
<pre>
	整数：&lt;property name="count" value="#{5}"/>
	小数：&lt;property name="frequency" value="#{89.7}"/>
	科学计数法：&lt;property name="capacity" value="#{1e4}"/>
	String可以使用单引号或者双引号作为字符串的定界符号：&lt;property name=“name” value="#{'Chuck'}"/> 或 
		&lt;property name='name' value='#{"Chuck"}'/>
	Boolean：&lt;property name="enabled" value="#{false}"/>
</pre><hr/>
<h4>SpEL：引用 Bean、属性和方法1</h4>
<pre>
	&lt;bean name="car1" class="cn.zhangfc.hello.Car">
	&lt;property name="name" value="car1">&lt;/property>
	&lt;property name="price" value="10000">&lt;/property>
	&lt;/bean>
	<b>引用car bean</b>
	&lt;bean name="person3" class="cn.zhangfc.hello.Person" 
	p:car="#{car1}" p:name="张三" p:age="14" p:sex="男">&lt;/bean>
	<b>引用其他对象属性以及调用方法，链式方法</b>
	&lt;bean name="person4" class="cn.zhangfc.hello.Person" 
	p:name="#{person3.name}" p:age="#{person3.getAge()}"
	p:sex="#{person3.getSex().toString()}"/>
	<b>调用静态方法或静态属性</b>
	<b>通过 T() 调用一个类的静态方法，它将返回一个 Class Object，然后再调用相应的方法或属性</b>
	p:age="#{T(java.lang.Math).PI}" 
</pre><hr/>
<h4>SpEL支持的运算符号</h4>
<image src="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/3.PNG"/>
<image src="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/4.PNG"/>
<hr/><hr/>
<h3>其他创建bean的方式</h3>
<h4>通过调用静态工厂方法创建 Bean</h4>
<pre>
 	 &lt;!-- 通过工厂方法的方式来配置 bean -->
	&lt;!-- 1. 通过静态工厂方法: 一个类中有一个静态方法, 可以返回一个类的实例(了解) -->
	&lt;!-- 在 class 中指定静态工厂方法的全类名, 在 factory-method 中指定静态工厂方法的方法名 -->
	&lt;bean id="dateFormat" class="java.text.DateFormat" factory-method="getDateInstance">
	&lt;!-- 可以通过 constructor-arg 子节点为静态工厂方法指定参数 -->
		&lt;constructor-arg value="2">&lt;/constructor-arg>
	&lt;/bean>
</pre><hr/>
<h4>通过调用实例工厂方法创建 Bean</h4>
<pre>
   &lt;!-- 2. 实例工厂方法: 先需要创建工厂对象, 再调用工厂的非静态方法返回实例(了解) -->
	&lt;!-- ①. 创建工厂对应的 bean -->
	&lt;bean id="simpleDateFormat" class="java.text.SimpleDateFormat">
		&lt;constructor-arg value="yyyy-MM-dd hh:mm:ss">&lt;/constructor-arg>
	&lt;/bean>
	&lt;!-- ②. 有实例工厂方法来创建 bean 实例 -->
	&lt;!-- factory-bean 指向工厂 bean, factory-method 指定工厂方法(了解) -->
	&lt;bean id="datetime" factory-bean="simpleDateFormat" factory-method="parse">
		&lt;!-- 通过 constructor-arg 执行调用工厂方法需要传入的参数 -->
		&lt;constructor-arg value="1990-12-12 12:12:12">&lt;/constructor-arg>
	&lt;/bean>
</pre><hr/>
<h4>实现 FactoryBean 接口在 Spring IOC 容器中配置 Bean</h4>
<a href="https://github.com/hz-zhangfc/javaweb/tree/master/spring/spring_bean/src/cn/zhangfc/getbean">代码详见</a>
<ul>
	<li>Spring 中有两种类型的 Bean, 一种是普通Bean, 另一种是工厂Bean, 即FactoryBean. </li>
	<li>工厂 Bean 跟普通Bean不同, 其返回的对象不是指定类的一个实例, 其返回的是该工厂 Bean 的 getObject 方法所返回的对象 </li>
</ul>
