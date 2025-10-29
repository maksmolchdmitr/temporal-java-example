package maks.molch.dmitr.temporal_java.config.temporal;

import io.temporal.client.WorkflowOptions;
import io.temporal.client.schedules.Schedule;
import io.temporal.client.schedules.ScheduleActionStartWorkflow;
import io.temporal.client.schedules.ScheduleClient;
import io.temporal.client.schedules.ScheduleIntervalSpec;
import io.temporal.client.schedules.ScheduleOptions;
import io.temporal.client.schedules.SchedulePolicy;
import io.temporal.client.schedules.ScheduleSpec;
import lombok.RequiredArgsConstructor;
import maks.molch.dmitr.temporal_java.config.temporal.properties.ScheduleProperties;
import maks.molch.dmitr.temporal_java.temporal.ScheduleType;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class ScheduleInitiator implements InitializingBean {

    private final ScheduleClient client;
    private final Map<ScheduleType, ScheduleProperties> schedulePropertiesMap;

    @Override
    public void afterPropertiesSet() {
        for (ScheduleType scheduleType : ScheduleType.values()) {
            ScheduleProperties properties = Optional.ofNullable(schedulePropertiesMap.get(scheduleType))
                    .orElseThrow(() ->
                            new IllegalArgumentException("Property is absent for schedule: %s".formatted(scheduleType))
                    );
            Schedule schedule = Schedule.newBuilder()
                    .setAction(
                            ScheduleActionStartWorkflow.newBuilder()
                                    .setWorkflowType(scheduleType.getWorkflowType())
                                    .setArguments("Name")
                                    .setOptions(
                                            WorkflowOptions.newBuilder()
                                                    .setWorkflowId(scheduleType.getWorkflowId())
                                                    .setTaskQueue(scheduleType.getQueue().name())
                                                    .build()
                                    )
                                    .build()
                    )
                    .setSpec(
                            ScheduleSpec.newBuilder()
                                    .setIntervals(List.of(
                                            new ScheduleIntervalSpec(
                                                    properties.interval(),
                                                    properties.intervalOffset()
                                            )
                                    ))
                                    .build()
                    )
                    .setPolicy(
                            SchedulePolicy.newBuilder()
                                    .setOverlap(properties.overlapPolicy())
                                    .build()
                    )
                    .build();
            client.createSchedule(
                    scheduleType.getScheduleId(),
                    schedule,
                    ScheduleOptions.newBuilder().build()
            );
        }
    }
}
