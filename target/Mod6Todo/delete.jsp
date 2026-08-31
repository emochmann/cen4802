<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Task" %>

<!DOCTYPE html>
<html>

<head>
    <title>Delete To-Do Item</title>
</head>

<body>

<h1>Delete a To-Do Item</h1>

<%
    List<Task> tasks =
            (List<Task>) request.getAttribute("tasks");

    if (tasks == null || tasks.isEmpty()) {
%>

<p>No tasks are available to delete.</p>

<%
} else {
    for (Task task : tasks) {
%>

<p>
    ID <%= task.getId() %>:
    <%= task.getDescription() %>

    <a href="<%= request.getContextPath() %>/todo?action=delete&id=<%= task.getId() %>">
        Delete
    </a>
</p>

<%
        }
    }
%>

<p>
    <a href="<%= request.getContextPath() %>/todo">
        Return to To-Do List
    </a>
</p>

</body>
</html>