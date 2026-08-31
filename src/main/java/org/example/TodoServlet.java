package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {

    private final TodoManager manager = new TodoManager();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "addPage":
                request.getRequestDispatcher("add.jsp")
                        .forward(request, response);
                break;

            case "deletePage":
                request.setAttribute("tasks", manager.getTasks());

                request.getRequestDispatcher("delete.jsp")
                        .forward(request, response);
                break;

            case "delete":

                int id = Integer.parseInt(
                        request.getParameter("id")
                );

                manager.deleteTask(id);

                response.sendRedirect("todo");

                break;

            default:

                request.setAttribute(
                        "tasks",
                        manager.getTasks()
                );

                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String description =
                request.getParameter("description");

        manager.addTask(description);

        response.sendRedirect("todo");
    }
}
