package maks.molch.dmitr.temporal_java.temporal.workflow.impl;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import maks.molch.dmitr.temporal_java.temporal.activity.SayHelloActivity;
import maks.molch.dmitr.temporal_java.temporal.workflow.HelloWorkflow;

import java.time.Duration;

public class HelloWorkflowImpl implements HelloWorkflow {

    private final SayHelloActivity activity = Workflow.newActivityStub(
            SayHelloActivity.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(10))
                    .build()
    );

    @Override
    public String hello(String name) {
        return activity.sayHello(name);
    }
}
