package com.betrybe.trybetrack.models.repositories;

import com.betrybe.trybetrack.models.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long>,
    RevisionRepository<Station, Long, Long> {
}
