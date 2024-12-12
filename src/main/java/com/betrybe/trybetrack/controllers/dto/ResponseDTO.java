package com.betrybe.trybetrack.controllers.dto;

public record ResponseDTO<T>(String message, T data) {
}
