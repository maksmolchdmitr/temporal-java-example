package maks.molch.dmitr.temporal_java.temporal.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import maks.molch.dmitr.temporal_java.temporal.AbstractWorkflow;

@WorkflowInterface
public interface HelloWorkflow extends AbstractWorkflow {
    @WorkflowMethod
    String hello(String name);
}
