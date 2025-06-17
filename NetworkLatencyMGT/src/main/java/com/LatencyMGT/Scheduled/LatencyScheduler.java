package com.LatencyMGT.Scheduled;

import com.LatencyMGT.services.LatencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LatencyScheduler {

    @Autowired
    private LatencyService latencyService;

    @Scheduled(fixedRate = 60000) // every 60 seconds we also called like Demon Thread
    public void monitorUrls() {
        latencyService.checkLatency("http://flipkart.com");
        latencyService.checkLatency("https://google.com");
    }

}
