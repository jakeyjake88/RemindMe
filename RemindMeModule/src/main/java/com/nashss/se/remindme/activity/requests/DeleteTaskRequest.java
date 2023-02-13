package com.nashss.se.remindme.activity.requests;

/**
 * Class for the DeleteTaskRequest for the RemindMeClient.
 */
public class DeleteTaskRequest {
    private final String taskId;

    /**
     * Constructor for the CreateUserRequest class.
     *
     * @param taskId The unique identifier for the task
     */
    public DeleteTaskRequest(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String taskId;

        public Builder withTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public DeleteTaskRequest build() {
            return new DeleteTaskRequest(taskId);
        }
    }
}
