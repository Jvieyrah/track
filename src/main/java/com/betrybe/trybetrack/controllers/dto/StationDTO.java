package com.betrybe.trybetrack.controllers.dto;

import com.betrybe.trybetrack.models.entities.Station;

public record StationDTO(
        Long id,
        String name
) implements RequestEntity<Station> {
    @Override
    public Station toEntity() {
        return new Station(id, name, null);
    }
}
