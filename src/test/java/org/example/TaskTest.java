package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskDescription() {
        Task task = new Task("Finish homework");

        assertEquals("Finish homework", task.getDescription());
    }

    @Test
    void testTaskStartsIncomplete() {
        Task task = new Task("Finish homework");

        assertFalse(task.isCompleted());
    }

    @Test
    void testTaskCanBeCompleted() {
        Task task = new Task("Finish homework");

        task.setCompleted(true);

        assertTrue(task.isCompleted());
    }

    @Test
    void testTaskCanBeMarkedIncompleteAgain() {
        Task task = new Task("Finish homework");

        task.setCompleted(true);
        task.setCompleted(false);

        assertFalse(task.isCompleted());
    }
}