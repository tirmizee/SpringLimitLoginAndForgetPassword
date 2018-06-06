<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
@font-face {
   font-family: bebas-neue;
   src: url(${pageContext.request.contextPath}/resources/fonts/bebas-neue/BebasNeue.otf);
}
@font-face {
   font-family: condition;
   src: url(${pageContext.request.contextPath}/resources/fonts/condition/Condition.ttf);
}
@font-face {
   font-family: CloudLightBold;
   src: url(${pageContext.request.contextPath}/resources/fonts/Cloud-LightBold/Cloud-Bold.otf);
}
.bg{
	background-color: #f5f5f5;
}
.content{
	font-family : CloudLightBold;
	width : 80%;
	margin: auto;
	background-color: #ffffff;
	padding: 50px;
}
.size14 {
    font-size: 14px;
}
.size16 {
    font-size: 16px;
}
.size18 {
    font-size: 18px;
}
.size20 {
    font-size: 20px;
}
.size40 {
    font-size: 40px;
}
.red{
	color: red
}
</style>
<body class="bg"> 
	<div class="content ">
		<span class="size40 red">Opps! Error 404 </span><br>
		<span class="size20">Page Not Found : ${RequestURL}</span>
	</div>
</body>
</html>   