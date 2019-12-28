package io.github.ajurasz.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
class MyService {

    private static final Logger LOG = LoggerFactory.getLogger(MyService.class);
    private final ApplicationEventPublisher eventPublisher;

    MyService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    void process() {
        LOG.info("MyService#process - start");
        eventPublisher.publishEvent(new MyEvent());
        LOG.info("MyService#process - stop");
    }
}
