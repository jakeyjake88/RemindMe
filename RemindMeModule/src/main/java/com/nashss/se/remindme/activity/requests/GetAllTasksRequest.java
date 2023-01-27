package com.nashss.se.remindme.activity.requests;

public class GetAllTasksRequest {
    private final String taskManagerId;

    private GetAllTasksRequest(String taskManagerId) {
        this.taskManagerId = taskManagerId;
    }

    public String getTaskManagerId() {
        return taskManagerId;
    }

    @Override
    public String toString() {
        return "GetAllTasksRequest{ " + "taskManagerId'" + taskManagerId + '\''
                + '}';
    }

    //CHECKSTYLE:Off:Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String taskManagerId;

        public Builder withTaskManagerId(String taskManagerId) {
            this.taskManagerId = taskManagerId;
            return this;
        }

        public GetAllTasksRequest build() { return new GetAllTasksRequest(taskManagerId);}
    }
}