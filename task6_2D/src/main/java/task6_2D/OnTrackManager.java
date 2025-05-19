package task6_2D;

import java.util.*;

public class OnTrackManager {

    public static class Task {
        int id;
        int studentId;
        String status;
        List<String> feedback;
        List<String> chat;

        public Task(int id, int studentId) {
            this.id = id;
            this.studentId = studentId;
            this.status = "submitted";
            this.feedback = new ArrayList<>();
            this.chat = new ArrayList<>();
        }
    }

    private Map<Integer, Task> taskMap = new HashMap<>();
    private int taskIdCounter = 1;

    public int createTask(int studentId) {
        int id = taskIdCounter++;
        taskMap.put(id, new Task(id, studentId));
        return id;
    }

    public List<Integer> getTaskInbox(int studentId) {
        List<Integer> taskIds = new ArrayList<>();
        for (Task t : taskMap.values()) {
            if (t.studentId == studentId) {
                taskIds.add(t.id);
            }
        }
        return taskIds;
    }

    public Task getTaskDetails(int taskId) {
        return taskMap.get(taskId);
    }

    public void postChatMessage(int taskId, String sender, String message) {
        Task t = taskMap.get(taskId);
        if (t != null) {
            t.chat.add(sender + ": " + message);
        }
    }

    public void updateTaskStatus(int taskId, String status) {
        Task t = taskMap.get(taskId);
        if (t != null) {
            t.status = status;
        }
    }

    public List<Integer> filterTasksByStatus(String status) {
        List<Integer> filtered = new ArrayList<>();
        for (Task t : taskMap.values()) {
            if (t.status.equals(status)) {
                filtered.add(t.id);
            }
        }
        return filtered;
    }
}
