package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class HelloLambda implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        context.getLogger().log("Event: " + event);

        String name = "World";

        // 1️⃣ GET query param
        if (event.getQueryStringParameters() != null &&
                event.getQueryStringParameters().get("name") != null) {
            name = event.getQueryStringParameters().get("name");
        }

        // 2️⃣ POST body
        String httpMethod = event.getHttpMethod();
        if ("POST".equalsIgnoreCase(httpMethod) && event.getBody() != null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> bodyMap = mapper.readValue(event.getBody(), Map.class);

                if (bodyMap.get("name") != null) {
                    name = bodyMap.get("name");
                }
            } catch (Exception e) {
                context.getLogger().log("Error parsing body: " + e.getMessage());
            }
        }

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(200);
        response.setBody("Hello from Java Lambda, name = " + name);

        return response;
    }
}
