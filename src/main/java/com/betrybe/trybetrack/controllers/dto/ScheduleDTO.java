package com.betrybe.trybetrack.controllers.dto;

import com.betrybe.trybetrack.models.entities.Schedule;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleDTO(
        Long id,
        @JsonProperty("departure_date")
        LocalDate departureDate,
        @JsonProperty("departure_time")
        LocalTime departureTime,
        boolean available
) implements RequestEntity<Schedule> {
    @Override
    public Schedule toEntity() {
        return new Schedule(id, departureDate, departureTime, available, null);
    }
}
