<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/9
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int score = 100;
    if (score>=90){
%>
<h1>A</h1>
<%
    }
    if (score>=80&&score<=90){
%>
<h1>B</h1>
<%
    }
    if (score>=60&&score<=80){

%>
<h1>C</h1>
<%
    }
    if (score<=60){
%>
<h1>D</h1>
<%
    }
%>

<%
    for (int i = 1; i <= 9 ; i++) {
        for (int j = 1; j <= i ; j++) {
%>
<%=j%> * <%=i%>= <%=i * j%> &nbsp;
<%
        }
%>
</br>
<%
    }
%>

</body>
</html>
