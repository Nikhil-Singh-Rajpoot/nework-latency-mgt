package com.LatencyMGT.services;

import com.LatencyMGT.entitys.Latency;
import com.LatencyMGT.repo.LatencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

@Service
public class LatencyService {

    @Autowired
    private LatencyRepo latencyRepo;

    public void checkLatency(String url) {
        try {
            long start = System.nanoTime();
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();
            long end = System.nanoTime();

            long duration = (end - start) / 1_000_000; // to ms

            Latency log = new Latency();
            log.setUrl(url);
            log.setResponseTime(duration);
            log.setTimestamp(LocalDateTime.now());
            latencyRepo.save(log);

            // Optional alert
            if(duration > 500) {
                System.out.println("⚠️ High Latency Detected for " + url + ": " + duration + "ms");
            }

        } catch (Exception e) {
            System.out.println("❌ Failed to connect to " + url);
        }
    }
}
