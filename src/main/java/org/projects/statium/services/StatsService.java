package org.projects.statium.services;

import org.projects.statium.entities.Stats;
import org.projects.statium.repositories.StatsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {
    private final StatsRepository statsRepository;

    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public Optional<Stats> getStatsById(Long id) {
        return statsRepository.findById(id);
    }

    public Stats createStats(Stats stats) {
        return statsRepository.save(stats);
    }
}
