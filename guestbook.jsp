<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>留言</title>
  <!-- 引入 layui.css -->
  <link href="//unpkg.com/layui@2.9.0/dist/css/layui.css" rel="stylesheet">
  <!-- 引入 layui.js -->
  <script src="//unpkg.com/layui@2.9.0/dist/layui.js"></script>
  <script src="../js/jquery-1.8.0.min.js"></script>

  <script>
    if ("${judge}"!==""){
      alert("${judge}");
    }

    function del(guestbook_id) {
      if (confirm("确认删除?")){
        $.ajax({
          url:"${pageContext.request.contextPath}/guestbook/deleteGuestbook",
          data:{"guestbook_id":guestbook_id},
          dataType:"text",
          success:function () {
            alert("删除成功！")
            $("#ID-table-demo-init").load("${pageContext.request.contextPath}/jsp/guestbook.jsp");
            window.location.reload();
          }
        });
      }
    }
  </script>


</head>
<body>

<div class="layui-form-item" style="float: left">
  <div class="layui-input-group" style="margin: 30px auto 20px auto">
    <div class="layui-input-split layui-input-prefix">
      搜索栏
    </div>
    <form action="${pageContext.request.contextPath}/guestbook/selectGuestbookByName">
      <input type="text" name="user_name" placeholder="请输入留言人用户名" class="layui-input" style="width: 400px;height: 50px">
      <div class="layui-input-suffix" style="height: 83px;width: 258px;left: 372px">
        <input type="submit" class="layui-btn" value="搜索" style="height: 50px"/>
        <a class="layui-btn" style="height: 50px;line-height: 50px" href="${pageContext.request.contextPath}/guestbook/selectGuestbookAll">显示所有用户留言</a>
      </div>
    </form>
  </div>
</div>

<table class="layui-table" id="ID-table-demo-init">
  <thead>
  <tr>
    <th>留言人</th>
    <th>留言标题</th>
    <th>留言时间</th>
    <th>具体操作</th>
    <th>留言状态</th>
  </tr>
  </thead>

  <tbody>
  <c:forEach var="guestbook" items="${guestbookList}">
    <tr>
      <span hidden>${guestbook.guestbook_id}</span>
      <td>${guestbook.user_name}</td>
      <td>${guestbook.guestbook_title}</td>
      <span hidden>${guestbook.guestbook_contents}</span>
      <td>${guestbook.guestbook_addtime}</td>
      <td>
        <a href="${pageContext.request.contextPath}/guestbook/toGuestbookLook?guestbook_id=${guestbook.guestbook_id}" class="layui-btn layui-btn-primary layui-border-green" lay-on="test-page-custom">查看</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a class="layui-btn layui-btn-primary layui-border-green" onclick="del(${guestbook.guestbook_id})">删除</a>
      </td>
      <td>
        <c:if test="${guestbook.guestbook_state==0}">
          <a class="layui-btn layui-btn-primary layui-border-red">未读</a>
        </c:if>
        <c:if test="${guestbook.guestbook_state==1}">
          <a class="layui-btn layui-btn-primary layui-border-green">已读</a>
        </c:if>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
