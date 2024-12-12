package com.betrybe.trybetrack.services.impl;

import com.betrybe.trybetrack.models.entities.BusLine;
import com.betrybe.trybetrack.models.entities.Schedule;
import com.betrybe.trybetrack.models.entities.Station;
import com.betrybe.trybetrack.models.repositories.BusLineRepository;
import com.betrybe.trybetrack.services.BaseService;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusLineService implements BaseService<BusLine> {

    private final BusLineRepository busLineRepository;

    private final StationService stationService;

    private final ScheduleService scheduleService;

    @Autowired
    public BusLineService(BusLineRepository busLineRepository,
                          StationService stationService, ScheduleService scheduleService) {
        this.busLineRepository = busLineRepository;
        this.stationService = stationService;
        this.scheduleService = scheduleService;
    }


    public BusLine createEntity(BusLine entity) {
        return busLineRepository.save(entity);
    }

    public Optional<BusLine> updateEntity(Long id, BusLine entity) {
        Optional<BusLine> optionalLine = busLineRepository.findById(id);

        if (optionalLine.isPresent()) {
            BusLine busLine = optionalLine.get();
            busLine.setCode(entity.getCode());
            busLine.setName(entity.getName());

            BusLine updatedBusLine = busLineRepository.save(busLine);
            return Optional.of(updatedBusLine);
        }

        return optionalLine;
    }

    public Optional<BusLine> deleteEntity(Long id) {
        Optional<BusLine> optionalLine = busLineRepository.findById(id);

        if (optionalLine.isPresent()) {
            busLineRepository.deleteById(id);
        }

        return optionalLine;
    }

    public Optional<BusLine> getEntityById(Long id) {
        return busLineRepository.findById(id);
    }

    public List<BusLine> getAllEntities() {
        return busLineRepository.findAll();
    }

    public Optional<Schedule> createScheduleEntity(Long busLineId, Schedule schedule) {
        Optional<BusLine> optionalBusLine = busLineRepository.findById(busLineId);
        if(optionalBusLine.isEmpty()) {
            return Optional.empty();
        }

        BusLine busLine = optionalBusLine.get();

        schedule.setBusLine(busLine);
        Schedule newEntity = scheduleService.createEntity(schedule);

        busLine.getSchedules().add(newEntity);
        busLineRepository.save(busLine);

        return Optional.of(newEntity);
    }

    public Optional<Schedule> updateScheduleEntity(Long scheduleId, Schedule schedule) {
        Optional<Schedule> optionalSchedule = scheduleService.getEntityById(scheduleId);

        if(optionalSchedule.isPresent()) {
            Schedule scheduleFromDB = optionalSchedule.get();
            scheduleFromDB.setDepartureDate(schedule.getDepartureDate());
            scheduleFromDB.setDepartureTime(schedule.getDepartureTime());
            scheduleFromDB.setAvailable(schedule.isAvailable());

            return scheduleService.updateEntity(scheduleId, scheduleFromDB);
        }

        return optionalSchedule;
    }


    public Optional<Schedule> deleteScheduleEntity(Long scheduleId) {
        Optional<Schedule> optionalSchedule = scheduleService.getEntityById(scheduleId);

        if(optionalSchedule.isPresent()) {
            return scheduleService.deleteEntity(scheduleId);
        }

        return optionalSchedule;
    }

    @Transactional
    public Optional<BusLine> setStationToBusLine(Long busLineId, Long stationId) {
        Optional<BusLine> optionalBusLine = busLineRepository.findById(busLineId);
        if (optionalBusLine.isEmpty()) {
            return Optional.empty();
        }

        Optional<Station> optionalStation = stationService.getEntityById(stationId);
        if (optionalStation.isEmpty()) {
            return Optional.empty();
        }

        BusLine busLine = optionalBusLine.get();
        Station station = optionalStation.get();

        busLine.getStations().add(station);
        BusLine updatedBusLine = busLineRepository.save(busLine);

        return Optional.of(updatedBusLine);
    }

    public Optional<BusLine> unsetStationToBusLine(Long busLineId, Long stationId) {
        Optional<BusLine> optionalBusLine = busLineRepository.findById(busLineId);
        if (optionalBusLine.isEmpty()) {
            return Optional.empty();
        }

        Optional<Station> optionalStation = stationService.getEntityById(stationId);
        if (optionalStation.isEmpty()) {
            return Optional.empty();
        }

        BusLine busLine = optionalBusLine.get();
        Station station = optionalStation.get();

        busLine.getStations().remove(station);
        BusLine updatedBusLine = busLineRepository.save(busLine);

        return Optional.of(updatedBusLine);
    }

    public List<BusLine> getFutureEntities(LocalDate date) {
        List<BusLine> busesLines = busLineRepository.findAll();
        return busesLines.stream().map(busLine -> {
            List<Schedule> schedules = busLine.getSchedules()
                .stream()
                .filter(schedule -> date.isBefore(schedule.getDepartureDate())).toList();
            busLine.setSchedules(schedules);
            return busLine;
        }).toList();
    }

    public List<BusLine> getFutureEntitiesById(Long id, LocalDate date) {
        Optional<BusLine> optionalBusLine = busLineRepository.findById(id);
        if (optionalBusLine.isEmpty()) {
            return List.of();
        }

        BusLine busLine = optionalBusLine.get();
        List<Schedule> schedules = busLine.getSchedules()
            .stream()
            .filter(schedule -> date.isBefore(schedule.getDepartureDate())).toList();
        busLine.setSchedules(schedules);

        return List.of(busLine);
    }

    public Optional<BusLine> getEntityByCode(String code){
        return busLineRepository.findByCode(code);
    }

    public List<BusLine> getEntitiesFromStationId(Long stationId) {
        return busLineRepository.findBusLinesFromStationId(stationId);
    }

    public List<BusLine> getEntitiesWithAvailableSchedules() {
        return busLineRepository.findBusLinesWithAvailableSchedules();
    }
}
