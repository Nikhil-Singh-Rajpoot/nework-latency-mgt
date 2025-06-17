package com.LatencyMGT.controller;

import com.LatencyMGT.entitys.Latency;
import com.LatencyMGT.repo.LatencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/latency")
public class LatencyController {

    @Autowired
    private LatencyRepo repo;

    @GetMapping
    public List<Latency> getAllLogs() {
        return repo.findAll();
    }

    @GetMapping("/url")
    public List<Latency> getByUrl(@RequestParam String url) {
        return repo.findByUrl(url);
    }
}
