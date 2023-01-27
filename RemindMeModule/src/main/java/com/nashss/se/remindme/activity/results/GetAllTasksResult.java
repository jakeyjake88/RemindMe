package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.TaskModel;

import java.util.List;

public class GetAllTasksResult {
    private final List<TaskModel> tasks;

    private GetAllTasksResult(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public List<TaskModel> getTasks() { return tasks; }

    @Override
    public String toString() {
        return "GetAllTasksResult{" + "tasks=" + tasks + '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private List<TaskModel> tasks;

        public Builder withTasks(List<TaskModel> tasks) {
            this.tasks = tasks;
            return this;
        }

        public GetAllTasksResult build() { return new GetAllTasksResult(tasks); }
    }
}