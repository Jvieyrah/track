package com.betrybe.trybetrack.controllers;

import com.betrybe.trybetrack.controllers.dto.BusLineDTO;
import com.betrybe.trybetrack.controllers.dto.ResponseDTO;
import com.betrybe.trybetrack.controllers.dto.ScheduleDTO;
import com.betrybe.trybetrack.models.entities.BusLine;
import com.betrybe.trybetrack.models.entities.Schedule;
import com.betrybe.trybetrack.services.impl.BusLineService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buslines")
public class BusLineController {

    private final BusLineService busLineService;

    @Autowired
    public BusLineController(BusLineService busLineService) {
        this.busLineService = busLineService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<BusLine>> createLine(@RequestBody BusLineDTO busLineDTO) {
        BusLine busLine = busLineService.createEntity(busLineDTO.toEntity());
        ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                "Itinerário criado com sucesso", busLine);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<BusLine>> updateLine(@PathVariable Long id, @RequestBody BusLineDTO busLineDTO) {
        Optional<BusLine> optionalBusLine = busLineService.updateEntity(id, busLineDTO.toEntity());

        if(optionalBusLine.isEmpty()) {
            ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                    "Itinerário não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                "Itinerário atualizado com sucesso", optionalBusLine.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<BusLine>> deleteLine(@PathVariable Long id) {
        Optional<BusLine> optionalBusLine = busLineService.deleteEntity(id);

        if(optionalBusLine.isEmpty()) {
            ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                    "Itinerário não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                "Itinerário excluído com sucesso", optionalBusLine.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<BusLine>> getLineById(@PathVariable Long id) {
        Optional<BusLine> optionalBusLine = busLineService.getEntityById(id);

        if(optionalBusLine.isEmpty()) {
            ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                    "Itinerário não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                "Itinerário recuperado com sucesso", optionalBusLine.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<BusLine>>> getAllLines() {
        List<BusLine> entities = busLineService.getAllEntities();
        ResponseDTO<List<BusLine>> responseDTO = new ResponseDTO<>(
                "Itinerários recuperados com sucesso", entities);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PostMapping("/{busLineId}/schedule")
    public ResponseEntity<ResponseDTO<Schedule>> createSchedule(@PathVariable Long busLineId, @RequestBody ScheduleDTO scheduleDTO) {
        Optional<Schedule> optionalSchedule = busLineService.createScheduleEntity(busLineId, scheduleDTO.toEntity());

        if(optionalSchedule.isEmpty()) {
            ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                    "Itinerário não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                "Agendamento criado com sucesso", optionalSchedule.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/schedule/{scheduleId}")
    public ResponseEntity<ResponseDTO<Schedule>> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleDTO scheduleDTO) {
        Optional<Schedule> optionalSchedule = busLineService.updateScheduleEntity(scheduleId, scheduleDTO.toEntity());

        if(optionalSchedule.isEmpty()) {
            ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                    "Agendamento não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                "Agendamento atualizado com sucesso", optionalSchedule.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/schedule/{scheduleId}")
    public ResponseEntity<ResponseDTO<Schedule>> deleteSchedule(@PathVariable Long scheduleId) {
        Optional<Schedule> optionalSchedule = busLineService.deleteScheduleEntity(scheduleId);

        if(optionalSchedule.isEmpty()) {
            ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                    "Agendamento não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Schedule> responseDTO = new ResponseDTO<>(
                "Agendamento excluído com sucesso", optionalSchedule.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
    
    @PutMapping("/{busLineId}/station/{stationId}")
    public ResponseEntity<ResponseDTO<BusLine>> setScheduleToBusLine(
            @PathVariable Long busLineId, @PathVariable Long stationId) {
        Optional<BusLine> optionalBusLine = busLineService.setStationToBusLine(busLineId, stationId);

        if(optionalBusLine.isEmpty()) {
            ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                    "Rodoviária ou itinerário não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                "Atribuído a rodoviária ao itinerário com sucesso", optionalBusLine.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{busLineId}/station/{stationId}")
    public ResponseEntity<ResponseDTO<BusLine>> unsetScheduleToBusLine(
            @PathVariable Long busLineId, @PathVariable Long stationId) {
        Optional<BusLine> optionalBusLine = busLineService.unsetStationToBusLine(busLineId, stationId);

        if(optionalBusLine.isEmpty()) {
            ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                    "Rodoviária ou itinerário não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                "Retirado a atribuição a rodoviária ao itinerário com sucesso", optionalBusLine.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/future")
    public ResponseEntity<ResponseDTO<List<BusLine>>> getFutureLines(@RequestParam LocalDate date) {
        List<BusLine> entities = busLineService.getFutureEntities(date);
        ResponseDTO<List<BusLine>> responseDTO = new ResponseDTO<>(
            "Itinerários recuperados com sucesso", entities);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/{id}//future/{date}")
    public ResponseEntity<ResponseDTO<List<BusLine>>> getFutureLinesById(@PathVariable Long id, @RequestParam LocalDate date) {
        List<BusLine> entities = busLineService.getFutureEntities(date);
        ResponseDTO<List<BusLine>> responseDTO = new ResponseDTO<>(
            "Itinerários recuperados com sucesso", entities);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ResponseDTO<BusLine>> getBusLineByCode(@PathVariable String code){
        Optional<BusLine> optionalBusLine = busLineService.getEntityByCode(code);

        if(optionalBusLine.isEmpty()) {
            ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
                "Itinerário não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<BusLine> responseDTO = new ResponseDTO<>(
            "Itinerário recuperado com sucesso", optionalBusLine.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/station/{stationId}")
    public ResponseEntity<ResponseDTO<List<BusLine>>> getAllLinesFromStationId(@PathVariable Long stationId) {
        List<BusLine> entities = busLineService.getEntitiesFromStationId(stationId);
        ResponseDTO<List<BusLine>> responseDTO = new ResponseDTO<>(
            "Itinerários recuperados com sucesso", entities);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/available")
    public ResponseEntity<ResponseDTO<List<BusLine>>> getAllWithAvailableSchedules() {
        List<BusLine> entities = busLineService.getEntitiesWithAvailableSchedules();
        ResponseDTO<List<BusLine>> responseDTO = new ResponseDTO<>(
            "Itinerários recuperados com sucesso", entities);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
