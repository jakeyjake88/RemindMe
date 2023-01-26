package activity.requests;

public class GetTaskRequest {
    private final String taskId;
    private final String taskManagerId;

    private GetTaskRequest(String taskId, String taskManagerId) {
        this.taskId = taskId;
        this.taskManagerId = taskManagerId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskManagerId() {
        return taskManagerId;
    }

    @Override
    public String toString() {
        return "GetTaskRequest{" +
                "taskid='" + taskId + '\'' +
                "taskManagerId'" + taskManagerId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String taskId;
        private String taskManagerId;

        public Builder withId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder withTaskManagerId(String taskManagerId) {
            this.taskManagerId = taskManagerId;
            return this;
        }

        public GetTaskRequest build() {
            return new GetTaskRequest(taskId, taskManagerId);
        }
    }
}
