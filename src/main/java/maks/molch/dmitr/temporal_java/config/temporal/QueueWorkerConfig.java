package maks.molch.dmitr.temporal_java.config.temporal;

import maks.molch.dmitr.temporal_java.temporal.AbstractActivity;
import maks.molch.dmitr.temporal_java.temporal.AbstractWorkflow;
import maks.molch.dmitr.temporal_java.temporal.QueueName;

import java.util.List;

public interface QueueWorkerConfig {

    QueueName getQueueName();

    List<Class<? extends AbstractWorkflow>> getWorkflowTypes();

    List<AbstractActivity> getActivities();

}
