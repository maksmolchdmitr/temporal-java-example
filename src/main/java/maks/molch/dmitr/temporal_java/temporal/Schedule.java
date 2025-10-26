package maks.molch.dmitr.temporal_java.temporal;

import lombok.RequiredArgsConstructor;
import maks.molch.dmitr.temporal_java.temporal.workflow.HelloWorkflow;

@RequiredArgsConstructor
public enum Schedule {
    SAY_HELLO(
            HelloWorkflow.class,
            QueueName.SAY_HELLO
    );

    private final Class<? extends AbstractWorkflow> workflowType;
    private final QueueName queueName;

    public String getWorkflowId() {
        return this.name().toLowerCase() + "_workflow";
    }

    public String getScheduleId() {
        return this.name().toLowerCase() + "_schedule";
    }
}
