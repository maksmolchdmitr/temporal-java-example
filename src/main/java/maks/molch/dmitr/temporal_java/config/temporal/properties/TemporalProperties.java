package maks.molch.dmitr.temporal_java.config.temporal.properties;

import maks.molch.dmitr.temporal_java.temporal.Schedule;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "temporal")
public record TemporalProperties(
        Map<Schedule, ScheduleProperties> schedules
) {
}
