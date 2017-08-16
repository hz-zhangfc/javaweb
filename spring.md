<h1 style="background-color:#E6E6FA">第一阶段：会用</h1>
<h2>一.环境准备</h2>
eclipse+spring-tool-suite
<strong> 注意：可以在这个插件官网上看看eclipse版本和该插件版本是否符合</strong><br/>
<a href="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/spring-tool-suite.PNG">插件的安装</a><br/>
<strong>碰到的问题：当安装失败时，试试勾选最下面那个选项</strong>
<image src="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/1.PNG"/>
<hr>
<h2>二.spring in eclipse</h2>
1.spring 配置文件<br/>
new-->other-->输入spring关键字-->选择spring bean configure file<storng>不清楚可以全部试过去</strong><br/>
<image src="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/2.PNG" width="500" height="200"/>
<strong>一个个点过去看看</strong>
<hr/>
<h2>三.IOC</h2>
<strong>一个反射贯穿其中</strong>
<h3>HelloSpring</h3>
<p>
内容：<a href="https://github.com/hz-zhangfc/javaweb/blob/master/spring/spring_bean/test/cn/zhangfc/test/TestDemo1.java">ApplicationContext,配置文件路径加载</a>，
<a  href="https://github.com/hz-zhangfc/javaweb/blob/master/spring/spring_bean/src/cn/zhangfc/hello/hello.xml">配置文件编写</a>
</p>
<h3>属性注入</h3>
<pre>
  &lt;bean name="hellospring" class="cn.zhangfc.hello.HelloSpring">
	  &lt;property name="name" value="张三">&lt;/property>
  &lt;/bean>
</pre>
<h3>构造方法注入</h3>
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
</pre>

<h3>配置bean的一些知识点</h3>
<h4>字面值</h4>
<ul>
	<li>字面值：可用字符串表示的值，可以通过 <value> 元素标签或 value 属性进行注入。</li>
	<li>基本数据类型及其封装类、String 等类型都可以采取字面值注入的方式</li>
	<li>若字面值中包含特殊字符，可以把字面值包裹起来。使用 &lt;![CDATA[]]>(在xml或html中"&lt;"是特殊字符)</li>
	&lt;property name="name" value="&lt;![CDATA[&lt;哈哈>]]>">&lt;/property>
</ul>
<h4>引用其他bean</h4>
<pre>
	&lt;bean id="car1" class="cn.zhangfc.hello.Car"/>
	&lt;bean id="person" class="cn.zhangfc.hello.Person">
		&lt;property name="car" ref="car1"/>
	&lt;/bean>
</pre>
<h4>内部bean</h4>
<pre>
	&lt;bean id="person2" class="cn.zhangfc.hello.Person">
		&lt;property name="car">
			&lt;!-- 内部 bean, 类似于匿名内部类对象. 不能被外部的 bean 来引用, 也没有必要设置 id 属性 -->
			&lt;bean class="cn.zhangfc.hello.Car">
				&lt;property name="price" value="10000">&lt;/property>
			&lt;/bean>
		&lt;/property>
	&lt;/bean>
</pre>
<h4>null值和级联属性</h4>
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
</pre>
<h4>集合属性</h4>
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
</pre>

<h3>使用 p 命名空间</h3>
<pre>
	<b>先引入该命名空间</b>
	&lt;bean id="user3" class="com.atguigu.spring.helloworld.User"
		p:cars-ref="cars" p:userName="Titannic">
	&lt;/bean>
</pre>
<h3>自动装配</h3>
<pre>
	自动装配: 只声明 bean, 而把 bean 之间的关系交给 IOC 容器来完成 
	byType: 根据类型进行自动装配. 但要求 IOC 容器中只有一个类型对应的 bean, 若有多个则无法完成自动装配.
	byName: 若属性名和某一个 bean 的 id 名一致, 即可完成自动装配. 若没有 id 一致的, 则无法完成自动装配
	在使用 XML 配置时, 自动转配用的不多. 但在基于 注解 的配置时, 自动装配使用的较多.
</pre>
<h3>继承 Bean 配置</h3>
<pre>
	<b>可以忽略父 Bean 的 class 属性, 让子 Bean 指定自己的类, 而共享相同的属性配置. 但此时 abstract 必须设为 true</b>
	<b>父 Bean 可以作为配置模板, 也可以作为 Bean 实例. 若只想把父 Bean 作为模板, 可以设置 &lt;bean> 的abstract 属性为 true, 这样 Spring 将不会实例化这个 Bean</b>
	&lt;bean id="father" abstract="true"> 
	    &lt;property name="name" value="parent"/>  
	    &lt;property name="age" value="1"/>  
	&lt;/bean>  
	&lt;bean id="son" class="org.springframework.beans.DerivedTestBean" parent="father" init-method="initialize">  
	    &lt;property name="name" value="override"/>  
	    &lt;!-- age will inherit the value of 1 from the parent bean definition-->  
	&lt;/bean>  
	
	&lt;bean id="inheritedTestBean" abstract="true" class="org.springframework.beans.TestBean">  
	    &lt;property name="name" value="parent"/>  
	    &lt;property name="age" value="1"/>  
	&lt;/bean>  
	&lt;bean id="inheritsWithDifferentClass" class="org.springframework.beans.DerivedTestBean" parent="inheritedTestBean" init-method="initialize">  
	    &lt;property name="name" value="override"/>  
	    &lt;!-- the age property value of 1 will be inherited from parent -->  
	&lt;/bean>  
	&lt;bean id="inheritsWithSameClass" parent="inheritedTestBean" init-method="initialize">  
	    &lt;property name="name" value="override"/>  
	    &lt;!-- the age property value of 1 will be inherited from parent -->  
	&lt;/bean>  
</pre>
