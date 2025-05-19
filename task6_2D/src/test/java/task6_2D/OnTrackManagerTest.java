package task6_2D;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OnTrackManagerTest {

    private OnTrackManager manager;

    @Before
    public void setUp() {
        manager = new OnTrackManager();
    }

    @Test // Right
    public void testCreateAndGetInbox() {
        int taskId = manager.createTask(100);
        List<Integer> inbox = manager.getTaskInbox(100);
        assertTrue(inbox.contains(taskId));
    }

    @Test // Boundary
    public void testEmptyInboxForNewStudent() {
        List<Integer> inbox = manager.getTaskInbox(999);
        assertTrue(inbox.isEmpty());
    }

    @Test // Inverse
    public void testUpdateThenRevertStatus() {
        int id = manager.createTask(101);
        manager.updateTaskStatus(id, "in review");
        manager.updateTaskStatus(id, "submitted");
        assertEquals("submitted", manager.getTaskDetails(id).status);
    }

    @Test // Cross-check
    public void testInboxCrossCheckWithDirectTaskScan() {
        int id1 = manager.createTask(111);
        int id2 = manager.createTask(111);
        List<Integer> inbox = manager.getTaskInbox(111);
        assertEquals(2, inbox.size());
        assertTrue(inbox.contains(id1) && inbox.contains(id2));
    }

    @Test // Error
    public void testInvalidTaskIdReturnsNull() {
        assertNull(manager.getTaskDetails(9999));
    }

    @Test // Performance (basic simulation)
    public void testFilterLargeNumberOfTasks() {
        for (int i = 0; i < 1000; i++) {
            int id = manager.createTask(i % 10);
            if (i % 2 == 0) {
                manager.updateTaskStatus(id, "graded");
            }
        }
        List<Integer> gradedTasks = manager.filterTasksByStatus("graded");
        assertTrue(gradedTasks.size() > 0);
    }

    @Test // Chat and Feedback test
    public void testPostChatMessage() {
        int id = manager.createTask(200);
        manager.postChatMessage(id, "student", "Hello");
        assertTrue(manager.getTaskDetails(id).chat.get(0).contains("student: Hello"));
    }
}
