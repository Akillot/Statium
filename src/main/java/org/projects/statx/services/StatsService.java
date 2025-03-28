package org.projects.statx.services;

import org.projects.statx.entities.Stats;
import org.projects.statx.repositories.StatsRepository;
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
