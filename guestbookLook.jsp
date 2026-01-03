<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言查看</title>
    <!-- 引入 layui.css -->
    <link href="//unpkg.com/layui@2.9.0/dist/css/layui.css" rel="stylesheet">
    <!-- 引入 layui.js -->
    <script src="//unpkg.com/layui@2.9.0/dist/layui.js"></script>
</head>
<body style="background-color: whitesmoke">
<div style="width: 1110px;margin: 15px auto auto 15px">
    <div style="font-size: 22px;font-family: 宋体,serif"><b>留言标题：${guestbookList[0].guestbook_title}</b></div><br>
    <div style="font-size: 22px;font-family: 宋体,serif">留言人：${guestbookList[0].user_name}</div><br>
    <div style="font-size: 15px;font-family: 宋体,serif">留言时间：${guestbookList[0].guestbook_addtime}</div><br>
    <div style="font-size: 17px;font-family: 宋体,serif">${guestbookList[0].guestbook_contents}</div><br>
<%--    <a href="${pageContext.request.contextPath}/guestbook/selectGuestbookAll"--%>
<%--       class="layui-btn layui-btn-lg" style="text-decoration: none">返回</a>--%>
</div>
</body>
</html>
