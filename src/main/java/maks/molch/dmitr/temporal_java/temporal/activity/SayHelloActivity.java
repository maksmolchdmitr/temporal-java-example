package maks.molch.dmitr.temporal_java.temporal.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import maks.molch.dmitr.temporal_java.temporal.AbstractActivity;

@ActivityInterface
public interface SayHelloActivity extends AbstractActivity {
    @ActivityMethod
    String sayHello(String name);
}
