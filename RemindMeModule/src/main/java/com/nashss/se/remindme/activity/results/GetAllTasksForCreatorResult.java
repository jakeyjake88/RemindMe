package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.TaskModel;

import java.util.List;

/**
 * Class for the GetAllTasksForCreatorResult for the RemindMeClient.
 */
public class GetAllTasksForCreatorResult {
    private final List<TaskModel> tasks;

    /**
     * Constructor for the GetAllTasksForCreatorResult class.
     * @param tasks the list of tasks
     */
    private GetAllTasksForCreatorResult(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "Result{" + "tasks=" + tasks + '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private List<TaskModel> tasks;

        public Builder withTasks(List<TaskModel> tasks) {
            this.tasks = tasks;
            return this;
        }

        public GetAllTasksForCreatorResult build() { return new GetAllTasksForCreatorResult(tasks); }
    }
}
