package maks.molch.dmitr.temporal_java.config.temporal;

import io.temporal.client.schedules.ScheduleClient;
import lombok.RequiredArgsConstructor;
import maks.molch.dmitr.temporal_java.temporal.Schedule;

import java.util.List;

@RequiredArgsConstructor
public class ScheduleUpdater {

    private final ScheduleClient client;
    private final List<Schedule> scheduleList;
    private final
}
