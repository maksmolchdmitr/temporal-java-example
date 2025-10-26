package maks.molch.dmitr.temporal_java.config.temporal;

import io.temporal.worker.WorkerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.Lifecycle;

@RequiredArgsConstructor
public class WorkerLifecycle implements Lifecycle {

    private final WorkerFactory workerFactory;

    private volatile boolean running = false;

    @Override
    public void start() {
        workerFactory.start();
        running = true;
    }

    @Override
    public void stop() {
        running = false;
        workerFactory.shutdown();
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
