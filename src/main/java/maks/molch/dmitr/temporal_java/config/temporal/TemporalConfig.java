package maks.molch.dmitr.temporal_java.config.temporal;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.WorkerFactory;
import maks.molch.dmitr.temporal_java.temporal.AbstractActivity;
import maks.molch.dmitr.temporal_java.temporal.AbstractWorkflow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TemporalConfig {

    @Bean
    public WorkerLifecycleConfig temporalLifecycleConfig(WorkerFactory workerFactory) {
        return new WorkerLifecycleConfig(workerFactory);
    }

    @Bean
    public WorkerFactory workerFactory(
            WorkflowClient workflowClient,
            List<QueueWorkerConfig> queueWorkerConfigList
    ) {
        var factory = WorkerFactory.newInstance(workflowClient);

        for (var queueWorkerConfig : queueWorkerConfigList) {
            var worker = factory.newWorker(queueWorkerConfig.getQueueName().name());
            for (Class<? extends AbstractWorkflow> workflowType : queueWorkerConfig.getWorkflowTypes()) {
                worker.registerWorkflowImplementationTypes(workflowType);
            }
            for (AbstractActivity activity : queueWorkerConfig.getActivities()) {
                worker.registerActivitiesImplementations(activity);
            }
        }

        factory.start();

        return factory;
    }

    @Bean
    public WorkflowClient workflowClient() {
        var service = WorkflowServiceStubs.newLocalServiceStubs();
        return WorkflowClient.newInstance(service);
    }
}
