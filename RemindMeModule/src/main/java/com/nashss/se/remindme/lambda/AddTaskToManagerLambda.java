package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.AddTaskToManagerRequest;
import com.nashss.se.remindme.activity.results.AddTaskToManagerResult;

/**
 * Makes the Lambda Call.
 */
public class AddTaskToManagerLambda extends LambdaActivityRunner<AddTaskToManagerRequest, AddTaskToManagerResult>
    implements RequestHandler<LambdaRequest<AddTaskToManagerRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<AddTaskToManagerRequest> input, Context context) {
        return super.runActivity(() -> input.fromBody(AddTaskToManagerRequest.class),
            (request, serviceComponent) ->
             serviceComponent.provideAddTaskToManagerActivity().handleRequest(request));
    }
}
