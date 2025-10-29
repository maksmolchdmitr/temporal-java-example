package maks.molch.dmitr.temporal_java.temporal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import maks.molch.dmitr.temporal_java.temporal.workflow.HelloWorkflow;

@RequiredArgsConstructor
@Getter
public enum ScheduleType {
    SAY_HELLO(
            HelloWorkflow.class,
            Queue.SAY_HELLO
    );

    private final Class<? extends AbstractWorkflow> workflowType;
    private final Queue queue;

    public String getWorkflowId() {
        return this.name().toLowerCase() + "_workflow";
    }

    public String getScheduleId() {
        return this.name().toLowerCase() + "_schedule";
    }
}
