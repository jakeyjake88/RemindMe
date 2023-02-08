package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.dynamodb.models.TaskManager;
import com.nashss.se.remindme.models.TaskManagerModel;
import com.nashss.se.remindme.models.TaskModel;

import java.util.List;

public class GetTaskManagerResult {
    private final List<TaskManagerModel> tasks;

    private GetTaskManagerResult(List<TaskManagerModel> tasks) {
        this.tasks = tasks;
    }

    public List<TaskManagerModel> getAllTask() {
        return tasks;
    }

    @Override
    public String toString() {
        return "GetTaskResult{" + "task=" + tasks +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static GetTaskManagerResult.Builder builder() {
        return new GetTaskManagerResult.Builder();
    }
    public static class Builder {
        private List<TaskManagerModel> tasks;

        public GetTaskManagerResult.Builder withTask(List<TaskManagerModel> tasks) {
            this.tasks = tasks;
            return this;
        }

        public GetTaskManagerResult build() {
            return new GetTaskManagerResult(tasks);
        }
    }
}
