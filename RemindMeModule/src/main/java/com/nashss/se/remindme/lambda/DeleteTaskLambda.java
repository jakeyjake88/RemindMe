package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.DeleteTaskRequest;
import com.nashss.se.remindme.activity.results.DeleteTaskResult;
/**
 * Makes the Lambda Call.
 */
public class DeleteTaskLambda extends LambdaActivityRunner<DeleteTaskRequest, DeleteTaskResult>
    implements RequestHandler<LambdaRequest<DeleteTaskRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<DeleteTaskRequest> input, Context context) {
        return super.runActivity(() -> input.fromPathAndQuery((path, query) -> DeleteTaskRequest.builder()
                .withTaskManagerId(path.get("taskManagerId"))
                .withTaskId(query.get("taskId"))
                .build()), (request, serviceComponent) ->
                serviceComponent.provideDeleteTaskActivity().handleRequest(request)
        );
    }
}
