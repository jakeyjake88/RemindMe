package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.GetAllTasksForCreatorRequest;
import com.nashss.se.remindme.activity.results.GetAllTasksForCreatorResult;

/**
 * Makes the Lambda Call.
 */
public class GetAllTasksForCreatorLambda extends LambdaActivityRunner<GetAllTasksForCreatorRequest,
        GetAllTasksForCreatorResult> implements RequestHandler<AuthenticatedLambdaRequest<GetAllTasksForCreatorRequest>,
        LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<GetAllTasksForCreatorRequest> input,
                                        Context context) {
        return super.runActivity(
            () -> input.fromUserClaims(claims ->
                        GetAllTasksForCreatorRequest.builder()
                                .withCreatorId(claims.get("email"))
                    .build()),
            (request, serviceComponent)
                -> serviceComponent.provideGetAllTasksForCreatorActivity().handleRequest(request)
        );
    }
}
