<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员管理</title>
    <!-- 引入 layui.css -->
    <link href="//unpkg.com/layui@2.9.0/dist/css/layui.css" rel="stylesheet">
    <!-- 引入 layui.js -->
    <script src="//unpkg.com/layui@2.9.0/dist/layui.js"></script>
    <style>
        #news_iframe{
            width: 80%;
            height: 700px;
            margin: 20px auto auto 220px;
            border: none;
        }
    </style>
    <script>
        function judge(index) {
            if (index===1){
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/jsp/scenicAdd.jsp";
            } else if (index===2) {
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/scenic/selectScenicAll";
            } else if (index===3){
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/jsp/userAdd.jsp";
            } else if (index===4){
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/user/selectAllUser";
            } else if (index===5){
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/notice/selectNoticeAll";
            } else if (index===6){
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/essay/selectEssayAll";
            } else if (index===7){
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/guestbook/selectGuestbookAll";
            } else if (index===8){
                document.getElementById("news_iframe").src="${pageContext.request.contextPath}/jsp/adminPersonalManagement.jsp";
            }
        }
    </script>
</head>
<body>
<ul class="layui-nav">
    <li class="layui-nav-item" style="left: 85%">
        <a href="">管理员</a>
    </li>
    <li class="layui-nav-item" lay-unselect style="left: 85%">
        <a href="javascript:;">
            <img src="https://unpkg.com/outeres@0.0.10/demo/avatar/1.jpg" class="layui-nav-img">
        </a>
        <dl class="layui-nav-child">
            <dd style="text-align: center;"><a href="${pageContext.request.contextPath}/judge/adminOut">退出</a></dd>
        </dl>
    </li>
</ul>

<ul class="layui-nav layui-nav-tree layui-nav-side">
    <li class="layui-nav-item">
        <a href="javascript:" style="height: 50px;line-height: 50px">景点管理</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:" onclick="judge(1)">添加景点</a></dd>
            <dd><a href="javascript:" onclick="judge(2)">修改景点</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:">用户管理</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:" onclick="judge(3)">添加用户</a></dd>
            <dd><a href="javascript:" onclick="judge(4)">修改用户</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:" onclick="judge(5)">公告管理</a>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:" onclick="judge(6)">文章管理</a>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:" onclick="judge(7)">留言</a>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:" onclick="judge(8)">个人信息管理</a>
    </li>
</ul>

<iframe id="news_iframe" src="${pageContext.request.contextPath}/scenic/selectScenicAll"></iframe>

</body>
</html>
