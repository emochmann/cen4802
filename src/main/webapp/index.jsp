<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Task" %>

<!DOCTYPE html>
<html>

<head>
    <title>To-Do List</title>
</head>

<body>

<h1>My To-Do List</h1>

<p>
    <a href="<%= request.getContextPath() %>/todo?action=addPage">
        Add To-Do Item
    </a>
</p>

<p>
    <a href="<%= request.getContextPath() %>/todo?action=deletePage">
        Delete To-Do Item
    </a>
</p>

<%
    List<Task> tasks =
            (List<Task>) request.getAttribute("tasks");

    if (tasks == null || tasks.isEmpty()) {
%>

<p>No tasks found.</p>

<%
} else {
%>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Description</th>
    </tr>

    <%
        for (Task task : tasks) {
    %>

    <tr>
        <td><%= task.getId() %></td>
        <td><%= task.getDescription() %></td>
    </tr>

    <%
        }
    %>

</table>

<%
    }
%>

</body>
</html>