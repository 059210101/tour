# 旅游管理系统

## 介绍
基于 **SSM** 的旅游系统，前端使用 **JSP** 技术，UI组件库使用**Layui**

大三上课设系统，因个人能力和时间有限，系统中存在诸多不合理，但基本练手或用来交作业还是可以的， **若使用者有不明之处，我自当鼎力相助** 。

本系统因为**target**有相关的缓存（图片等），所以文件夹比较大，但其实系统本身很小，不建议删除现有的target文件夹。

## 使用环境：

- IDEA
- MySQL 8
- Tomcat 9
- Maven 3.9.3
- 需要懂得Spring以及MyBatis相关知识


## 安装教程

1.  文件中已存在相关数据库文件`tourists.sql`，可能需要手动创建数据库，默认属性就好

2.  导入数据库文件，并执行（或者复制`tourists.sql`里面的代码，在选定的数据库中执行全部代码的查询）

     <img src="readmeImg/image-20240720095741339.png" alt="image-20240720095741339" style="zoom:50%;" />

3.  项目用**IDEA**打开，进入`database.properties`文件，修改为个人的数据库配置（数据库名，用户名和密码）<img src="readmeImg/image-20240720100032355.png" alt="image-20240720100032355" style="zoom: 25%;" />

4.  `pom.xml`文件加载所有的依赖

     <img src="readmeImg/image-20240720103343837.png" alt="image-20240720100602689" style="zoom:33%;" />

5.  项目采用**JDK11**

     <img src="readmeImg/image-20240720100602689.png" alt="image-20240720100602689" style="zoom:33%;" />

6.  部署**Tomcat**服务器，点击应用，并确定。

     <img src="readmeImg/image-20240720100425206.png" alt="image-20240720100425206" style="zoom: 33%;" />

7.  运行

## 使用说明

​		注意：本项目中使用Layui组件库，会因为网络原因，导致部分组件无渲染无样式，请在网络较好的情况下运行，或者将Layui组件库下载到本地变为全局库（默认会占用C盘空间，不建议这么做）

### 普通用户

1. 登录样式

   管理员登录可以用（用户名：admin，密码：123456）

   用户登录可以用（用户名：Ryann，密码：123456）

    <img src="readmeImg/image-20240720101330204.png" alt="image-20240720101330204" style="zoom:25%;" />

2. 前台主页

    <img src="readmeImg/image-20240720101712665.png" alt="image-20240720101712665" style="zoom:25%;" />

3. 查看某一景点

    <img src="readmeImg/image-20240720101836295.png" alt="image-20240720101836295" style="zoom:25%;" />

4. 点击最新公告

    <img src="readmeImg/image-20240720101916658.png" alt="image-20240720101916658" style="zoom:25%;" />

5. 驴友文章中点击某一文章

    <img src="readmeImg/image-20240720102109837.png" alt="image-20240720102109837" style="zoom:25%;" />

6. 对管理员的留言

    <img src="readmeImg/image-20240720102145100.png" alt="image-20240720102145100" style="zoom:25%;" />

7. 个人中心相关操作

    <img src="readmeImg/image-20240720102231878.png" alt="image-20240720102231878" style="zoom:25%;" />



### 管理员

1. 景点相关操作

    <img src="readmeImg/image-20240720103031496.png" alt="image-20240720103031496" style="zoom:25%;" /> 

2. 景点以及其他部分功能的修改支持MarkDown语法

    <img src="readmeImg/image-20240720103202683.png" alt="image-20240720103202683" style="zoom: 25%;" />

    <img src="readmeImg/image-20240720103343836.png" alt="image-20240720103343836" style="zoom:25%;" />



介绍到此为止，其他功能可以自行探索。
