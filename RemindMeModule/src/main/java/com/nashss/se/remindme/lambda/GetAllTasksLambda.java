package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.GetAllTasksRequest;
import com.nashss.se.remindme.activity.results.GetAllTasksResult;

/**
 * Makes the Lambda Call.
 */
public class GetAllTasksLambda extends LambdaActivityRunner<GetAllTasksRequest, GetAllTasksResult>
    implements RequestHandler<LambdaRequest<GetAllTasksRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllTasksRequest> input, Context context) {
        return super.runActivity(() -> input.fromPath(path -> GetAllTasksRequest.builder()
                .withTaskManagerId(path.get("taskManagerId"))
                .build()),
            (request, serviceComponent) -> serviceComponent.provideGetAllTasksActivity().handleRequest(request));
    }
}
