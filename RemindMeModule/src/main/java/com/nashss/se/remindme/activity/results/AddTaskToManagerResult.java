package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.TaskModel;

/**
 * Class for the AddTaskToManagerResult for the RemindMeClient.
 */
public class AddTaskToManagerResult {
    private final TaskModel task;

    /**
     * Constructor for the AddTaskToManagerResult endpoint.
     * @param task the task object
     */
    private AddTaskToManagerResult(TaskModel task) {
        this.task = task;
    }

    public TaskModel getTask() {
        return task;
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

        public AddTaskToManagerResult build() { return new AddTaskToManagerResult(task); }
    }
}
