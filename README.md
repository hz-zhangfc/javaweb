
# servlet
javaweb入门

[博客系列](http://www.cnblogs.com/xdp-gacl/tag/JavaWeb%E5%AD%A6%E4%B9%A0%E6%80%BB%E7%BB%93/)<br>


目标：62篇博客，20天内过完，再次掌握3大框架，准备跳水了。

## 一、[javaweb入门](http://www.cnblogs.com/xdp-gacl/p/3729033.html)
描述：web的介绍，Tomcat的安装及结构


## 二、[Tomcat服务器的学习使用一](http://www.cnblogs.com/xdp-gacl/p/3734395.html)
* **Tomcat服务器端口的配置**<br>
  conf/servel.xml Conector节点
  
* **Tomcat虚拟目录的映射方式**<br>
  1.在servel.xml的Host元素中配置，加一个Context节点， 如：\<Context path="/hello" docBase="F:\java\helloProject"/\>
  2.把工程直接扔到webapps文件夹下，映射名就是工程目录的名称
  3.在\conf\Catalina\localhost目录下键一个xml，如：aa.xml，则path就是/aa。在xml文件中加元素<Context docBase="F:\JavaWebDemoProject" />
* **Tomcat配置虚拟主机**
  　配置虚似主机就是配置一个网站。<br>
    如："http://localhost:端口号/JavaWebAppName"的方式访问，其实访问的就是name是"localhost"的那台虚拟主机(Host)，这台虚拟主机管理webapps文件夹<br>下的所有web应用，详情见博客
    
* **windows系统注册域名**

* **浏览器与服务器的交互过程**

* **javaweb工程的目录结构**


## 三、[Tomcat服务器的学习使用二 ](http://www.cnblogs.com/xdp-gacl/p/3744053.html)

* **打包Javaweb应用**
  
* **Tomcat结构体系**

* **互联网上的加密原理**

* **Https连接**

## 四、[HTTP协议](http://www.cnblogs.com/xdp-gacl/p/3751277.html)

## 五、[servet开发一](http://www.cnblogs.com/xdp-gacl/p/3760336.html)

* **servlet简介**

* **servlet运行过程**

* **servlet调用图**

* **使用eclipse开发servlet**

* **servlet访问URL映射配置**

* **Servlet访问URL使用*通配符映射**

* **缺省servlet** 

* **servlet线程安全问题**

## 六、[servlet开发二](http://www.cnblogs.com/xdp-gacl/p/3763559.html)

* **servletconfig详解**

* **servletContext对象**

* **servletContext的应用**<br>
  1.多个servlet应用通过该对象实现数据共享<br>
  setAttribute和 getAttribute<br>
  2.获取web初始化数据<br>
  注意使用getInitParameter方法的<br>
  3.用servletContext实现请求转发<br>
  注意：`复写HttpServlet中的doGet或doPost方法时，不去掉super.doXX时，会出现405错误`---[405错误]   (http://blog.csdn.net/qfs_v/article/details/2545168)<br>
  **`4.利用ServletContext读取资源文件`---在这个`web项目中`**
  
  
## 七、[HttpServletResponse对象一](http://www.cnblogs.com/xdp-gacl/p/3789624.html)
* **简绍，总览**<br>
  1.向浏览器发送数据    注意：`一个流程只能使用一种流，要么xx要么xx`<br>
  2.向浏览器发送响应头<br>
  。。
* **OutputStream流发送数据:`编码要一致`**

* **PrintWriter:`需要仔细看一下，它的细节更多`**

* **使用OutputStream或者PrintWriter向客户端浏览器输出数字**

* **文件下载**<br>
  `下载中文文件时，需要注意的地方就是中文文件名要使用URLEncoder.encode方法进行编码(URLEncoder.encode(fileName, "字符编码"))，否则会出现文件名乱码`
  
## 八、[HttpServletResponse对象二](http://www.cnblogs.com/xdp-gacl/p/3791993.html)

* **HttpServletResponse常见应用——生成验证码：一个小应用**

* **设置响应头，控制浏览器行为**<br>
  * 控制浏览器禁止缓存当前文档<br>
    response.setDateHeader("expries",-1);<br>
    response.setHeader("Cache-control","no-cache");<br>
    response.setHeader("Pragma","no-cache");<br>
  * 控制浏览器定时刷新网页<br>
    response.setHeader("refresh","3");//3秒刷新一次<br>
  * 实现请求重定向  `重点：控制浏览器重新请求`<br>
    response.sendRedirect(/servlet/demo1);<br>
    实质是：response.setHeader("Location","/servlet/demo1"); +  response.setStatus("302);
    
* **<font color=#00ffff>WEB工程中的URL写法</font>**<br>
   如果"/"是给服务器用的，则代表当前的web工程，如果"/"是给浏览器用的，则代表webapps目录(tomcat下的webapps文件夹)。
   
* **response中流使用细节**

## 九、[通过servlet生成验证图片](http://www.cnblogs.com/xdp-gacl/p/3798190.html)  《项目 --待》

## 十、[HttpRequest对象一](http://www.cnblogs.com/xdp-gacl/p/3798347.html)

* **HttpRequest介绍**

* 常用的方法
  * 获取客户机信息
  * 获取客户机请求头
  * 获取客户机请求参数（客户端提交的数据--这是比较常用的）注意一下他的getParameterMap方法，看看代码里是怎么取出数据的
  * `request接受表单提交参数中文乱码问题`  ---这是重点
  * 实现请求转发

## [十一、使用cookie进行会话管理](http://www.cnblogs.com/xdp-gacl/p/3803033.html)
* 1.使用时注意点：设置有效时间，设置路径；删除：name,path要一致,有效时间设为0；
* 2.cookie存储中文时乱码问题；`URLEncoder,URLDecoder`

## [十二、session](http://www.cnblogs.com/xdp-gacl/p/3855702.html)
* 1.session的实现原理
* 2.禁用cookie后的session处理--url重写
* 3.session创建和销毁的时机

## [十三、使用session防止表单重复提交](http://www.cnblogs.com/xdp-gacl/p/3859416.html)
* \<form>表单有个onsubmit属性onsubmit="return dosubmit()"当dosubmit返回false时，不会提交表单
* BASE64Encoder挂了，用Base64代替，放回的byte数组用new String(bytes)会得到和原来一样的结果
