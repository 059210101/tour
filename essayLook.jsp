<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>文章查看页面</title>
    <!-- 引入 layui.css -->
    <link href="//unpkg.com/layui@2.9.0/dist/css/layui.css" rel="stylesheet">
    <!-- 引入 layui.js -->
    <script src="//unpkg.com/layui@2.9.0/dist/layui.js"></script>
</head>
<body style="background-color: whitesmoke">
<div style="width: 1110px;margin: 15px auto auto 15px">
    <div style="font-size: 22px;font-family: 宋体,serif"><b>标题：${essayList[0].essay_title}</b></div><br>
    <div style="font-size: 22px;font-family: 宋体,serif">作者：${essayList[0].user_name}</div><br>
    <div style="font-size: 15px;font-family: 宋体,serif">发布时间：${essayList[0].essay_addtime}</div><br>
    <div style="font-size: 17px;font-family: 宋体,serif">${essayList[0].essay_contents}</div><br>
    <div>
        <c:set var="imageExists" value="${fn:length(essayList[0].essay_photo) > 0}" />
        <div class="layui-inline layui-word-aux" id="imgDiv" >
            <c:if test="${imageExists}">
                <img src="${pageContext.request.contextPath}/img/${essayList[0].essay_photo}"
                     style="width: 700px;height: auto;margin: auto auto auto auto;display: flow;">
            </c:if>
        </div>
    </div><br>
    <a href="${pageContext.request.contextPath}/essay/selectEssayAll"
       class="layui-btn layui-btn-lg" style="text-decoration: none">返回</a>
</div>
</body>
</html>
