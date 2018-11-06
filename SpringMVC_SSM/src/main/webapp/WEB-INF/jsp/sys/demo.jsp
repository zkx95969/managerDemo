<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="application/javascript" src="/js/jquery/jquery-1.8.2.min.js"></script>
<body>
<h1>Hello world!!!</h1>
<div id="menuList"></div>
<div>
    <form id="addForm">
        <input type="text" name="name"/><br/>
        <input type="text" name="pid"/><br/>
        <input type="text" name="isLast"/><br/>
        <input type="text" name="action"/><br/>
        <input type="button" value="提交" id="addMenu"/>
    </form>


</div>

<div>
    <form id="updateForm">
        <input type="text" name="id"/><br/>
        <input type="text" name="name"/><br/>
        <input type="text" name="pid"/><br/>
        <input type="text" name="isLast"/><br/>
        <input type="text" name="action"/><br/>
        <input type="button" value="提交" id="updateMenu"/>
    </form>
</div>

<div>
    <input type="button" value="删除" id="deleteById">
</div>
<div>
    <input type="button" value="查看" id="findById">
</div>
<div>
    <input type="button" value="查看名字" id="findByName">
</div>

<script>

    $.ajax({
        url:"/findAllMenu",
        type:"post",
        dataType:"json",
        success:function(data){
            var str = "";
            $.each(data,function(index,value){
                str += value.name+"--";
            });
            $("#menuList").html(str);
        }
    });

    $("#addMenu").click(function(){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/addMenu" ,//url
            data: $('#addForm').serialize(),
            success: function (result) {
                alert(result);
            },
            error : function() {
                alert("异常！");
            }
        });
    });
</script>
</body>
</html>
