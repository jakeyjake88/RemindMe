package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.GetUserRequest;
import com.nashss.se.remindme.activity.results.GetUserResult;

public class GetUserLambda extends LambdaActivityRunner<GetUserRequest, GetUserResult>
implements RequestHandler<LambdaRequest<GetUserRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetUserRequest> input, Context context) {
        return super.runActivity(() -> input.fromPath(path -> GetUserRequest.builder()
                .withId(path.get("userId"))
                .build()),
                (request, serviceComponent) -> serviceComponent.provideGetUserActivity().handleRequest(request));
    }
}
