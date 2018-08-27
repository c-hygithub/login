<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
${ requestScope["register.message"]} <br/>
	<form action="${ pageContext.request.contextPath}/Register"  method="post"  onsubmit="return check()">
		*姓名<input type="text" id="name" name="name" /><br />
		 *年龄<input type="text" id="age" name="age" /><br />
		  *电话<input type="text"id="phone" name="phone" /> <br />
		   *id<input type="text" id="id"name="id" /><br /> 
		   <input type="submit" value="注册" />

	</form>
</body>
<script>
function check(){
//获取getElementById()
//判断是否为空
var name=document.getElementById("name").value;
var age=document.getElementById("age").value;
var phone=document.getElementById("phone").value;
var id=document.getElementById("id").value;
if(name==null || name==''){
alert("名字不能为空");
return false;
}
if(age==null || age==''){
alert("年龄不能为空");
return false;
}
if(phone==null || phone==''){
alert("电话不能为空");
return false;
}
if(id==null || id==''){
alert("id不能为空");
return false;
}


}

</script>
</html>
