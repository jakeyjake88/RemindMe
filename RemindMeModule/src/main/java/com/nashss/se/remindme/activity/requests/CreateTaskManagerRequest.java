package com.nashss.se.remindme.activity.requests;

public class CreateTaskManagerRequest {
    private final String creatorId;
    private final String taskManagerName;
    private final String managerId;

    private CreateTaskManagerRequest(String managerId, String creatorId, String taskManagerName) {
        this.managerId = managerId;
        this.creatorId = creatorId;
        this.taskManagerName = taskManagerName;
    }

    public String getCreatorId() { return creatorId; }
    public String getTaskManagerName() { return taskManagerName; }


    @Override
    public String toString() {
        return "GetTaskManagerRequest{" +
                "taskManagerName'" + taskManagerName + '\'' + '}';
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String creatorId;
        private String taskManagerName;
        private String managerId;

        public Builder withManagerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder withCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public Builder withTaskManagerName(String taskManagerName) {
            this.taskManagerName = taskManagerName;
            return this;
        }


        public CreateTaskManagerRequest build() { return new CreateTaskManagerRequest(managerId, creatorId, taskManagerName); }
    }
}
