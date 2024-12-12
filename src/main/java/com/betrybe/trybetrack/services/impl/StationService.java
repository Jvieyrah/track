package com.betrybe.trybetrack.services.impl;

import com.betrybe.trybetrack.models.entities.Station;
import com.betrybe.trybetrack.models.repositories.StationRepository;
import com.betrybe.trybetrack.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService implements BaseService<Station> {

    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station createEntity(Station entity) {
        return stationRepository.save(entity);
    }

    @Override
    public Optional<Station> updateEntity(Long id, Station entity) {
        Optional<Station> optionalStation = stationRepository.findById(id);

        if (optionalStation.isPresent()) {
            Station station = optionalStation.get();
            station.setName(entity.getName());
            station.setBusLines(entity.getBusLines());

            Station updatedStation = stationRepository.save(station);
            return Optional.of(updatedStation);
        }

        return optionalStation;
    }

    @Override
    public Optional<Station> deleteEntity(Long id) {
        Optional<Station> optionalStation = stationRepository.findById(id);

        if (optionalStation.isPresent()) {
            stationRepository.deleteById(id);
        }

        return optionalStation;
    }

    @Override
    public Optional<Station> getEntityById(Long id) {
        return stationRepository.findById(id);
    }

    @Override
    public List<Station> getAllEntities() {
        return stationRepository.findAll();
    }
}
