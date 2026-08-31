<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <title>Add To-Do Item</title>
</head>

<body>

<h1>Add a To-Do Item</h1>

<form action="<%= request.getContextPath() %>/todo"
      method="post">

    <label for="description">
        To-Do Item:
    </label>

    <input type="text"
           id="description"
           name="description"
           required>

    <button type="submit">
        Add Item
    </button>

</form>

<p>
    <a href="<%= request.getContextPath() %>/todo">
        Return to To-Do List
    </a>
</p>

</body>
</html>