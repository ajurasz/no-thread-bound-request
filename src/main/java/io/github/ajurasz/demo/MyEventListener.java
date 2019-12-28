package io.github.ajurasz.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
class MyEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(MyEventListener.class);
    private final GetUserId getUserId;

    MyEventListener(GetUserId getUserId) {
        this.getUserId = getUserId;
    }

    @Async
    @EventListener
    public void handle(MyEvent event) {
        LOG.info("MyEventListener#handle - start");
        handleEvent();
        LOG.info("MyEventListener#handle - stop");
    }

    private void handleEvent() {
        LOG.info("MyEventListener#handleEvent - {}", getUserId.userId());
    }
}
