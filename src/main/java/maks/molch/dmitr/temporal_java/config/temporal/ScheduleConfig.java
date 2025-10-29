package maks.molch.dmitr.temporal_java.config.temporal;

import io.temporal.client.WorkflowOptions;
import io.temporal.client.schedules.Schedule;
import io.temporal.client.schedules.ScheduleActionStartWorkflow;
import io.temporal.client.schedules.ScheduleClient;
import io.temporal.client.schedules.ScheduleIntervalSpec;
import io.temporal.client.schedules.ScheduleOptions;
import io.temporal.client.schedules.SchedulePolicy;
import io.temporal.client.schedules.ScheduleSpec;
import io.temporal.serviceclient.WorkflowServiceStubs;
import jakarta.annotation.PostConstruct;
import maks.molch.dmitr.temporal_java.config.temporal.properties.ScheduleProperties;
import maks.molch.dmitr.temporal_java.config.temporal.properties.TemporalProperties;
import maks.molch.dmitr.temporal_java.temporal.ScheduleType;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableConfigurationProperties(TemporalProperties.class)
public class ScheduleConfig {

    @Bean
    public ScheduleClient scheduleClient(WorkflowServiceStubs workflowServiceStubs) {
        return ScheduleClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public ScheduleInitiator scheduleInitiator(
            ScheduleClient client,
            TemporalProperties temporalProperties
    ) {
        return new ScheduleInitiator(client, temporalProperties.schedules());
    }
}
