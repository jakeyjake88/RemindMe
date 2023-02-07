package com.nashss.se.remindme.activity.results;

public class CreateTaskManagerResult {
    private final String managerId;
    private final String creatorId;
    private final String taskManagerName;

    private CreateTaskManagerResult(String managerId, String creatorId, String taskManagerName) {
        this.creatorId = creatorId;
        this.taskManagerName = taskManagerName;
        this.managerId = managerId;
    }

    public String getManagerId() { return managerId; }

    @Override
    public String toString() {
        return "CreateTaskManagerResult{" + "id=" + managerId +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String managerId;
        private String creatorId;
        private String taskManagerName;

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

        public CreateTaskManagerResult build() { return new CreateTaskManagerResult(managerId, creatorId, taskManagerName); }
    }
}
