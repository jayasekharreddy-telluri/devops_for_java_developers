package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

public class S3EventHandler implements RequestHandler<S3Event, String> {

    @Override
    public String handleRequest(S3Event event, Context context) {
        context.getLogger().log("Received S3 event: " + event);

        event.getRecords().forEach(record -> {
            String bucket = record.getS3().getBucket().getName();
            String key = record.getS3().getObject().getKey();
            context.getLogger().log("Bucket: " + bucket + ", Key: " + key);
        });

        return "S3 Event processed successfully!";
    }
}
