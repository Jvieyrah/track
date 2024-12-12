package com.betrybe.trybetrack.controllers.dto;

public interface RequestEntity<T> {
    public T toEntity();
}
