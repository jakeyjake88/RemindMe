package com.nashss.se.remindme.activity.results;

public class CreateTaskManagerResult {
    private final String managerId;

    private CreateTaskManagerResult(String managerId) {
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

        public Builder withManagerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public CreateTaskManagerResult build() { return new CreateTaskManagerResult(managerId); }
    }
}
