package com.betrybe.trybetrack.services.impl;

import com.betrybe.trybetrack.models.entities.Schedule;
import com.betrybe.trybetrack.models.repositories.ScheduleRepository;
import com.betrybe.trybetrack.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements BaseService<Schedule> {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public Schedule createEntity(Schedule entity) {
        return scheduleRepository.save(entity);
    }

    @Override
    public Optional<Schedule> updateEntity(Long id, Schedule entity) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if(optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            schedule.setDepartureDate(entity.getDepartureDate());
            schedule.setDepartureTime(entity.getDepartureTime());
            schedule.setBusLine(entity.getBusLine());

            Schedule updatedSchedule = scheduleRepository.save(schedule);
            return Optional.of(updatedSchedule);
        }

        return optionalSchedule;
    }

    @Override
    public Optional<Schedule> deleteEntity(Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if(optionalSchedule.isPresent()) {
            scheduleRepository.deleteById(id);
        }

        return optionalSchedule;
    }

    @Override
    public Optional<Schedule> getEntityById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> getAllEntities() {
        return scheduleRepository.findAll();
    }
}
