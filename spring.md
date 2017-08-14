<h1>第一阶段：会用</h1>
<h2>一.环境准备</h2>
eclipse+spring-tool-suite
<strong> 注意：可以在这个插件官网上看看eclipse版本和该插件版本是否符合</strong>
<a href="https://github.com/hz-zhangfc/javaweb/blob/master/spring/images/spring-tool-suite.PNG">插件的安装</a>
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
<pre>
