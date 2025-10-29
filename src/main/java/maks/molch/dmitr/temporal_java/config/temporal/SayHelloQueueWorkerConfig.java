package maks.molch.dmitr.temporal_java.config.temporal;

import maks.molch.dmitr.temporal_java.temporal.AbstractActivity;
import maks.molch.dmitr.temporal_java.temporal.AbstractWorkflow;
import maks.molch.dmitr.temporal_java.temporal.Queue;
import maks.molch.dmitr.temporal_java.temporal.activity.impl.SayHelloActivityImpl;
import maks.molch.dmitr.temporal_java.temporal.workflow.impl.HelloWorkflowImpl;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SayHelloQueueWorkerConfig implements QueueWorkerConfig {
    @Override
    public Queue getQueueName() {
        return Queue.SAY_HELLO;
    }

    @Override
    public List<Class<? extends AbstractWorkflow>> getWorkflowTypes() {
        return List.of(
                HelloWorkflowImpl.class
        );
    }

    @Override
    public List<AbstractActivity> getActivities() {
        return List.of(
                new SayHelloActivityImpl()
        );
    }
}
