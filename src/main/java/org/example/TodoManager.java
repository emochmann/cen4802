package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TodoManager {

    public void addTask(String description) {
        Transaction transaction = null;

        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Task task = new Task(description);
            session.persist(task);

            transaction.commit();
            System.out.println("Task added.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error adding task.");
            e.printStackTrace();
        }
    }

    public void displayTasks() {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            List<Task> tasks = session.createQuery("from Task", Task.class).list();

            if (tasks.isEmpty()) {
                System.out.println("No tasks found.");
            } else {
                System.out.println("\nTo-Do List:");
                for (Task task : tasks) {
                    System.out.println(task);
                }
            }
        }
    }

    public List<Task> getTasks() {
        try (Session session =
                     HibernateManager.getSessionFactory().openSession()) {

            return session.createQuery(
                    "from Task",
                    Task.class
            ).list();
        }
    }

    public void deleteTask(int id) {
        Transaction transaction = null;

        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Task task = session.get(Task.class, id);

            if (task != null) {
                session.remove(task);
                System.out.println("Task deleted.");
            } else {
                System.out.println("Task not found.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error deleting task.");
            e.printStackTrace();
        }
    }

    public void completeTask(int id) {
        Transaction transaction = null;

        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Task task = session.get(Task.class, id);

            if (task != null) {
                task.setCompleted(true);
                transaction.commit();
                System.out.println("Task completed.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error completing task.");
            e.printStackTrace();
        }
    }
}