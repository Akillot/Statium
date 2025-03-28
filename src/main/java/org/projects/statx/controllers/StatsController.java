package org.projects.statx.controllers;

import org.projects.statx.entities.Stats;
import org.projects.statx.services.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stats> getStatsById(@PathVariable Long id) {
        Optional<Stats> stats = statsService.getStatsById(id);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stats createStats(@RequestBody Stats stats) {
        return statsService.createStats(stats);
    }
}
