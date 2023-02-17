package com.nashss.se.remindme.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.remindme.activity.requests.AddTaskToManagerRequest;
import com.nashss.se.remindme.activity.results.AddTaskToManagerResult;

/**
 * Makes the Lambda Call.
 */
public class AddTaskToManagerLambda extends LambdaActivityRunner<AddTaskToManagerRequest, AddTaskToManagerResult>
    implements RequestHandler<AuthenticatedLambdaRequest<AddTaskToManagerRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<AddTaskToManagerRequest> input, Context context) {
        AddTaskToManagerRequest request = input.fromBody(AddTaskToManagerRequest.class);
        return super.runActivity(() -> input.fromUserClaims(claims -> AddTaskToManagerRequest.builder()
                .withCreatorId(claims.get("email"))
                .withDescription(request.getDescription())
                .withDueDate(request.getDueDate())
                .withName(request.getName()).withTaskManagerId(request.getTaskManagerId())
                .build()),
            (req, serviceComponent) -> serviceComponent.provideAddTaskToManagerActivity().handleRequest(req));
    }
}
