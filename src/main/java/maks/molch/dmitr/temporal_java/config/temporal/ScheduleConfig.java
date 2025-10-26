package maks.molch.dmitr.temporal_java.config.temporal;

import io.temporal.client.schedules.ScheduleClient;
import io.temporal.client.schedules.ScheduleClientOptions;
import io.temporal.client.schedules.ScheduleOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import maks.molch.dmitr.temporal_java.config.temporal.properties.TemporalProperties;
import maks.molch.dmitr.temporal_java.temporal.Schedule;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties(TemporalProperties.class)
public class ScheduleConfig {

    @Bean
    public ScheduleClient scheduleClient(WorkflowServiceStubs workflowServiceStubs) {
        return ScheduleClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public ScheduleUpdater scheduleUpdater(
            ScheduleClient scheduleClient,
            List<Schedule> scheduleList
    ) {
        return new ScheduleUpdater(scheduleClient, scheduleList);
    }
}
