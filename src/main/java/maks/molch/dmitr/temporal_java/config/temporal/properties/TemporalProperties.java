package maks.molch.dmitr.temporal_java.config.temporal.properties;

import maks.molch.dmitr.temporal_java.temporal.ScheduleType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "temporal", ignoreUnknownFields = false)
public record TemporalProperties(
        Map<ScheduleType, ScheduleProperties> schedules
) {
}
