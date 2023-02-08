package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.GetTaskManagerRequest;
import com.nashss.se.remindme.activity.results.GetTaskManagerResult;

public class GetTaskManagerLambda extends LambdaActivityRunner<GetTaskManagerRequest, GetTaskManagerResult>
implements RequestHandler<AuthenticatedLambdaRequest<GetTaskManagerRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<GetTaskManagerRequest> input, Context context) {
        return super.runActivity(() -> input.fromUserClaims(claims ->
                GetTaskManagerRequest.builder()
                        .withCreatorId(claims.get("email"))
                        .build()),
                (request, serviceComponent) -> serviceComponent.provideGetTaskManagerActivity().handleRequest(request)
        );
    }
}
