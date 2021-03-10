<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/9
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>scope02.jsp</div>

<%=pageContext.getAttribute("key")%>
<%=request.getAttribute("key")%>
<%=session.getAttribute("key")%>
<%=application.getAttribute("key")%>

</body>
</html>
