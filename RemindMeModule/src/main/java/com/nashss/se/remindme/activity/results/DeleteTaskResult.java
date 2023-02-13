package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.TaskModel;

/**
 * Class for the DeleteTaskResult for the RemindMeClient.
 */
public class DeleteTaskResult {
    private final TaskModel task;

    /**
     * Constructor for the DeleteTaskResult class.
     *
     * @param task The task being deleted
     */
    public DeleteTaskResult(TaskModel task) {
        this.task = task;
    }

    public TaskModel getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "DeleteTaskResult{" +
                "task'" + task;
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

        public DeleteTaskResult build() {
            return new DeleteTaskResult(task);
        }
    }
}
