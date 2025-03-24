package org.projects.statx.controllers;

import org.projects.statx.entity.Stats;
import org.projects.statx.repository.StatsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    private final StatsRepository statsRepository;

    public StatsController(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    @GetMapping
    public List<Stats> getStats() {
        return statsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stats> getStatsById(@PathVariable Long id) {
        Optional<Stats> stats = statsRepository.findById(id);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stats createStats(@RequestBody Stats stats) {
        return statsRepository.save(stats);
    }

    @GetMapping("/social-link/{linkId}")
    public List<Stats> getStatsBySocialLink(@PathVariable Long linkId) {
        return statsRepository.findBySocialLinkId(linkId);
    }


    //GET /api/stats - get all stats
    //GET /api/stats/{id} - get statistics by ID
    //POST /api/stats - create stats
    //GET /api/stats/social-link/{linkId} - get stats by the link
}
