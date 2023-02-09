package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.TaskModel;

public class AddTaskToManagerResult {
    private final TaskModel task;

    private AddTaskToManagerResult(TaskModel task) { this.task = task; }

    public TaskModel getTask() { return task; }

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
