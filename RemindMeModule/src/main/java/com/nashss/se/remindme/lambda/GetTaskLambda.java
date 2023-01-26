package com.nashss.se.remindme.lambda;

import com.nashss.se.remindme.activity.requests.GetTaskRequest;
import com.nashss.se.remindme.activity.results.GetTaskResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetTaskLambda extends LambdaActivityRunner<GetTaskRequest, GetTaskResult>
    implements RequestHandler<LambdaRequest<GetTaskRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetTaskRequest> input, Context context) {
        return super.runActivity(() -> input.fromPath(path -> GetTaskRequest.builder()
                .withTaskManagerId(path.get("taskManagerId"))
                .withId(path.get("id"))
                .build()),
                (request, serviceComponent) -> serviceComponent.provideGetTaskActivity().handleRequest(request));
    }
}
