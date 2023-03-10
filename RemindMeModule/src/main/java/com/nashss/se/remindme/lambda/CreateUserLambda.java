package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.CreateUserRequest;
import com.nashss.se.remindme.activity.results.CreateUserResult;

/**
 * Makes the Lambda Call.
 */
public class CreateUserLambda extends LambdaActivityRunner<CreateUserRequest, CreateUserResult>
    implements RequestHandler<AuthenticatedLambdaRequest<CreateUserRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateUserRequest> input, Context context) {
        return super.runActivity(
            () -> input.fromUserClaims(claims ->
                        CreateUserRequest.builder()
                         .withUserId(claims.get("email"))
                          .withUserName(claims.get("name"))
                            .withPhoneNumber(claims.get("phone"))
                            .build()),
            (request, serviceComponent) -> serviceComponent.provideCreateUserActivity().handleRequest(request)
        );
    }
}
