<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>文章管理界面</title>
  <!-- 引入 layui.css -->
  <link href="//unpkg.com/layui@2.9.0/dist/css/layui.css" rel="stylesheet">
  <!-- 引入 layui.js -->
  <script src="//unpkg.com/layui@2.9.0/dist/layui.js"></script>
  <script src="../js/jquery-1.8.0.min.js"></script>

  <script>
    if ("${judge}"!=""){
      alert("${judge}");
    }

    function del(essay_id) {
      if (confirm("确认删除?")){
        $.ajax({
          url:"${pageContext.request.contextPath}/essay/deleteEssayById",
          data:{"essay_id":essay_id},
          dataType:"text",
          success:function () {
            alert("删除成功！")
            $("#ID-table-demo-init").load("${pageContext.request.contextPath}/jsp/essayPersonalManagement.jsp");
            window.location.reload();
          }
        });
      }
    }
  </script>
  <script>
    layui.use(function(){
      var form = layui.form;
      var layer = layui.layer;
      // select 事件
      form.on('select(demo-select-filter)', function(data){
        var elem = data.elem; // 获得 select 原始 DOM 对象
        var value = data.value; // 获得被选中的值
        var othis = data.othis; // 获得 select 元素被替换后的 jQuery 对象
        document.getElementById("search_text").placeholder=value;
        // layer.msg(this.innerHTML + ' 的 value: '+ value); // this 为当前选中 <option> 元素对象
        if (value==="按用户名称查询"){
          document.getElementById("search_text").name="user_name";
          document.getElementById("Type").action="${pageContext.request.contextPath}/essay/selectEssayByUserName";
        }
        else if (value==="按文章标题查询"){
          document.getElementById("search_text").name="essay_title";
          document.getElementById("Type").action="${pageContext.request.contextPath}/essay/selectEssayByTitle";
        }else {
          document.getElementById("Type").action="";
        }
      });
    });
  </script>
  <script>
    $.ajax({

    });
  </script>

</head>
<body>

<div class="layui-form-item" style="float: left">
  <div class="layui-input-group" style="margin: 30px auto 20px auto">
    <div class="layui-input-split layui-input-prefix">
      搜索栏
    </div>
    <form id="Type">
      <input type="text" name="essay_title" id="search_text" class="layui-input" style="width: 400px;height: 50px">
      <div class="layui-input-suffix" style="height: 83px;width: 255px;left: 372px">
        <input type="submit" class="layui-btn" value="搜索" style="height: 50px"/>
        <a class="layui-btn" style="height: 50px;line-height: 50px" href="${pageContext.request.contextPath}/essay/selectEssayAll">显示所有文章</a>
      </div>
    </form>
  </div>
  <div class="layui-form" >
    <div class="layui-col-md3">
      <select lay-filter="demo-select-filter">
        <option value="" data-placeholder="" ></option>
        <option value="按用户名称查询" data-placeholder="按用户名称查询">按用户名称查询</option>
        <option value="按文章标题查询" data-placeholder="按文章标题查询">按文章标题查询</option>
      </select>
    </div>
  </div>
</div>

<table class="layui-table" id="ID-table-demo-init">
  <thead>
  <tr>
    <th>用户名</th>
    <th>文章标题</th>
    <th>公告发布时间</th>
    <th>具体操作</th>
  </tr>
  </thead>

  <tbody>
  <c:forEach var="essay" items="${essayList}">
    <tr>
      <span hidden>${essay.essay_id}</span>
      <td>${essay.user_name}</td>
      <td>${essay.essay_title}</td>
      <td>${essay.essay_addtime}</td>
      <td>
        <a href="${pageContext.request.contextPath}/essay/toEssayLook?essay_id=${essay.essay_id}"
           class="layui-btn layui-btn-primary layui-border-green" lay-on="test-page-custom">查看</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a class="layui-btn layui-btn-primary layui-border-green" onclick="del(${essay.essay_id})">删除</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
