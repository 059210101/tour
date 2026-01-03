<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>管理员个人信息管理</title>
  <!-- 引入 layui.css -->
  <link href="//unpkg.com/layui@2.9.0/dist/css/layui.css" rel="stylesheet">
  <!-- 引入 layui.js -->
  <script src="//unpkg.com/layui@2.9.0/dist/layui.js"></script>
  <script>
    if ("${judge}"!==""){
      alert("${judge}");
    }

  </script>
  <script src="../js/jquery-1.8.0.min.js"></script>

</head>
<body>
<div class="layui-form" style="margin: 10px auto auto 10px">
  <form action="${pageContext.request.contextPath}/admin/updateAdmin">
    <input type="number" name="admin_id" value="${admin.admin_id}" hidden>
    <span style="font-family: 微软雅黑;font-size: 40px;color: #16baaa">身份：管理员</span><br><br><br>
    <span style="font-family: 微软雅黑;font-size: 20px;color: red">下列操作可执行修改当前管理员信息功能，请谨慎操作！</span><br><br>
    <input type="text" name="admin_name" value="${admin.admin_name}" placeholder="请输入用户名" class="layui-input" required style="width: 60%;height: 50px"><br>
    <input type="text" name="phone" value="${admin.phone}" placeholder="请输入联系方式" class="layui-input" required style="width: 60%;height: 50px"><br>
    <input type="password" name="password_now" placeholder="请输入当前登录密码" class="layui-input" required style="width: 60%;height: 50px"><br>
    <input type="password" name="password_new" placeholder="请输入新的密码" class="layui-input" required style="width: 60%;height: 50px"><br>
    <input type="password" name="password_new2" placeholder="再次输入新的密码" class="layui-input" required style="width: 60%;height: 50px"><br>
    <input type="submit" class="layui-btn layui-btn-lg" value="提交">
  </form>

</div>

</body>
</html>

