package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.GetUserRequest;
import com.nashss.se.remindme.activity.results.GetUserResult;

/**
 * Makes the Lambda Call.
 */
public class GetUserLambda extends LambdaActivityRunner<GetUserRequest, GetUserResult>
    implements RequestHandler<AuthenticatedLambdaRequest<GetUserRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<GetUserRequest> input, Context context) {
        return super.runActivity(() -> input.fromUserClaims(claims ->
                GetUserRequest.builder()
                        .withId(claims.get("email"))
                        .build()),
            (request, serviceComponent) -> serviceComponent.provideGetUserActivity().handleRequest(request)
        );
    }
}
