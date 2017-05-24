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

*　**servlet访问URL映射配置**

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
  





