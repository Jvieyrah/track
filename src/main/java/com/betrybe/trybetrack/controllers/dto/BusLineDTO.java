package com.betrybe.trybetrack.controllers.dto;

import com.betrybe.trybetrack.models.entities.BusLine;

public record BusLineDTO(
        Long id,
        String code,
        String name) implements RequestEntity<BusLine> {
    @Override
    public BusLine toEntity() {
        return new BusLine(id, code, name, null, null);
    }
}
