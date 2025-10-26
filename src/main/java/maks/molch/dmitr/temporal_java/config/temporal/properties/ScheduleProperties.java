package maks.molch.dmitr.temporal_java.config.temporal.properties;

import io.temporal.api.enums.v1.ScheduleOverlapPolicy;

import java.time.Duration;

public record ScheduleProperties(
        Duration interval,
        Duration intervalOffset,
        ScheduleOverlapPolicy overlapPolicy
) {
}
