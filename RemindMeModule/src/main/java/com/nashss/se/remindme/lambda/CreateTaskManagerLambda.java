package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.CreateTaskManagerRequest;
import com.nashss.se.remindme.activity.results.CreateTaskManagerResult;

public class CreateTaskManagerLambda extends LambdaActivityRunner<CreateTaskManagerRequest, CreateTaskManagerResult>
implements RequestHandler<LambdaRequest<CreateTaskManagerRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateTaskManagerRequest> input, Context context) {
        return super.runActivity(() -> input.fromPath(path -> CreateTaskManagerRequest.builder()
                .withManagerId(path.get("taskManagerId"))
                .build()),
                (request, serviceComponent) -> serviceComponent.provideCreateTaskManagerActivity().handleRequest(request));
    }
}
