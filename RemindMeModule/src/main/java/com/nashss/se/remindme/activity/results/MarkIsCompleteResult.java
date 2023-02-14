package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.TaskModel;

/**
 * Class for the MarkIsCompleteResult class for the RemindMeClient.
 */
public class MarkIsCompleteResult {
    private final TaskModel task;

    /**
     * Constructor for the MarkIsCompleteRequest class.
     *
     * @param task the task being updated
     */
    private MarkIsCompleteResult(TaskModel task) {
        this.task = task;
    }

    public TaskModel getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "MarkIsCompleteResult{" +
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

        public MarkIsCompleteResult build() {
            return new MarkIsCompleteResult(task);
        }
    }
}
