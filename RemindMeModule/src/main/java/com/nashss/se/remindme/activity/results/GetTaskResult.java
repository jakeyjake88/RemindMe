package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.TaskModel;

public class GetTaskResult {
    private final TaskModel task;

    private GetTaskResult(TaskModel task) {
        this.task = task;
    }

    public TaskModel getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "GetTaskResult{" + "task=" + task +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private TaskModel task;

        public Builder withTask(TaskModel task) {
            this.task = task;
            return this;
        }

        public GetTaskResult build() {
            return new GetTaskResult(task);
        }
    }
}
