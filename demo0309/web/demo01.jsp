<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/9
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<%--%>
    <%--ArrayList<Student> arrayList = new ArrayList<>();--%>
    <%--arrayList.add(new Student(123,"123",123));--%>
    <%--arrayList.add(new Student(1233,"2123",122133));--%>
    <%--arrayList.add(new Student(121233,"1223",121233));--%>

<%--%>--%>

<%--<%--%>

<%--for (int i = 0; i <arrayList.size() ; i++) {--%>

<%--%>--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td><%=arrayList.get(i).getId()  %></td>--%>
<%--<td><%=arrayList.get(i).getName() %></td>--%>
<%--<td><%=arrayList.get(i).getAge()  %></td>--%>
<%--</tr>--%>
<%--</table>--%>

<%--<%--%>
<%--}--%>
<%--%>--%>


<h1>demo01</h1>
<%
    ArrayList<Student> arrayList= (ArrayList<Student>) request.getAttribute("stu");

    for (int i = 0; i <arrayList.size() ; i++) {

%>
<table>
    <tr>
        <td><%=arrayList.get(i).getId()  %></td>
        <td><%=arrayList.get(i).getName() %></td>
        <td><%=arrayList.get(i).getAge()  %></td>
    </tr>
</table>
<%
    }
%>

</body>
</html>
