package com.betrybe.trybetrack.controllers;

import com.betrybe.trybetrack.controllers.dto.ResponseDTO;
import com.betrybe.trybetrack.controllers.dto.ScheduleDTO;
import com.betrybe.trybetrack.models.entities.Schedule;
import com.betrybe.trybetrack.services.impl.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<Schedule>> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule Schedule = scheduleService.createEntity(scheduleDTO.toEntity());
        ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                "Agendamento criado com sucesso", Schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<Schedule>> updateSchedule(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO) {
        Optional<Schedule> optionalSchedule = scheduleService.updateEntity(id, scheduleDTO.toEntity());

        if(optionalSchedule.isEmpty()) {
            ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                    "Agendamento não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                "Agendamento atualizado com sucesso", optionalSchedule.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Schedule>> deleteSchedule(@PathVariable Long id) {
        Optional<Schedule> optionalSchedule = scheduleService.deleteEntity(id);

        if(optionalSchedule.isEmpty()) {
            ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                    "Agendamento não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                "Agendamento excluído com sucesso", optionalSchedule.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<Schedule>> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> optionalSchedule = scheduleService.getEntityById(id);

        if(optionalSchedule.isEmpty()) {
            ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                    "Agendamento não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                "Agendamento recuperado com sucesso", optionalSchedule.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<Schedule>>> getAllSchedules() {
        List<Schedule> entities = scheduleService.getAllEntities();
        ResponseDTO<List<Schedule>> responseDTO = new ResponseDTO<>(
                "Agendamentos recuperados com sucesso", entities);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}
