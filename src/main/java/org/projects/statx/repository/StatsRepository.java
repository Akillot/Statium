package org.projects.statx.repository;

import org.projects.statx.entity.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
    List<Stats> findBySocialLinkId(Long linkId);
}
