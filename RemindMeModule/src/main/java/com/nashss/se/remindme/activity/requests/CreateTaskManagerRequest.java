package com.nashss.se.remindme.activity.requests;

public class CreateTaskManagerRequest {
    private final String managerId;

    private CreateTaskManagerRequest(String managerId) {
        this.managerId = managerId;
    }

    private String getManagerId() { return managerId; }

    @Override
    public String toString() {
        return "GetTaskManagerRequest{" +
                "taskManagerId'" + managerId + '\'' + '}';
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String managerId;

        public Builder withManagerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public CreateTaskManagerRequest build() { return new CreateTaskManagerRequest(managerId); }
    }
}
