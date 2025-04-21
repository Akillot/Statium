package org.projects.statium.repositories;

import org.projects.statium.entities.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
    List<Stats> findBySocialLink_LinkId(Long linkId);
}
