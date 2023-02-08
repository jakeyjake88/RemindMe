package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.CreateTaskManagerRequest;
import com.nashss.se.remindme.activity.results.CreateTaskManagerResult;

public class CreateTaskManagerLambda extends LambdaActivityRunner<CreateTaskManagerRequest, CreateTaskManagerResult>
implements RequestHandler<AuthenticatedLambdaRequest<CreateTaskManagerRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateTaskManagerRequest> input, Context context) {
        CreateTaskManagerRequest req = input.fromPath(path -> CreateTaskManagerRequest.builder()
                .withTaskManagerName(path.get("taskManagerName")).build());
        return super.runActivity(() -> input.fromUserClaims(claims -> CreateTaskManagerRequest.builder()
                        .withCreatorId(claims.get("email"))
                        .withTaskManagerName(req.getTaskManagerName())
                .build()),
                (request, serviceComponent) -> serviceComponent.provideCreateTaskManagerActivity().handleRequest(request));
    }
}
