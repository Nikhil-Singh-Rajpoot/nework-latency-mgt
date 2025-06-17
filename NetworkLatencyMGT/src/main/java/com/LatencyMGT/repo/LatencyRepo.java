package com.LatencyMGT.repo;

import com.LatencyMGT.entitys.Latency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LatencyRepo extends JpaRepository<Latency,String> {
    List<Latency> findByUrl(String url);
}
