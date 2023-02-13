package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.MarkIsCompleteRequest;
import com.nashss.se.remindme.activity.results.MarkIsCompleteResult;

/**
 * Makes the Lambda Call.
 */
public class MarkIsCompleteLambda extends LambdaActivityRunner<MarkIsCompleteRequest, MarkIsCompleteResult>
    implements RequestHandler<LambdaRequest<MarkIsCompleteRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<MarkIsCompleteRequest> input, Context context) {
        return super.runActivity(() -> input.fromBody(MarkIsCompleteRequest.class), (request, serviceComponent) ->
                serviceComponent.provideMarkIsCompleteActivity().handleRequest(request)
        );
    }
}
