package io.schultz.dustin.todoapp.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class MaxMemoryHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        boolean invalid = Runtime.getRuntime().maxMemory()>(100*1024*1024);
        Status status  = invalid ? Status.DOWN : Status.UP;
        return Health.status(status)
                .withDetail("image",
                        invalid
                         ? "https://preview.redd.it/3iu2aznxfrz21.jpg?auto=webp&s=eeff5f35558ecc37de13945f33549e60c6cafbec"
                         : "https://lumiere-a.akamaihd.net/v1/images/p_up_19753_e6f911e3.jpeg")
                .build();
    }
}
