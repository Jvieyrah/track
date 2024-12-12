package com.betrybe.trybetrack.controllers;

import com.betrybe.trybetrack.controllers.dto.ResponseDTO;
import com.betrybe.trybetrack.controllers.dto.StationDTO;
import com.betrybe.trybetrack.models.entities.Station;
import com.betrybe.trybetrack.services.impl.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<Station>> createStation(@RequestBody StationDTO stationDTO) {
        Station Station = stationService.createEntity(stationDTO.toEntity());
        ResponseDTO<Station> responseDTO = new ResponseDTO<>(
                "Rodoviária criado com sucesso", Station);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<Station>> updateStation(@PathVariable Long id, @RequestBody StationDTO stationDTO) {
        Optional<Station> optionalStation = stationService.updateEntity(id, stationDTO.toEntity());

        if(optionalStation.isEmpty()) {
            ResponseDTO<Station> responseDTO = new ResponseDTO<>(
                    "Rodoviária não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Station> responseDTO = new ResponseDTO<>(
                "Rodoviária atualizado com sucesso", optionalStation.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Station>> deleteStation(@PathVariable Long id) {
        Optional<Station> optionalStation = stationService.deleteEntity(id);

        if(optionalStation.isEmpty()) {
            ResponseDTO<Station> responseDTO = new ResponseDTO<>(
                    "Rodoviária não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Station> responseDTO = new ResponseDTO<>(
                "Rodoviária excluído com sucesso", optionalStation.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<Station>> getStationById(@PathVariable Long id) {
        Optional<Station> optionalStation = stationService.getEntityById(id);

        if(optionalStation.isEmpty()) {
            ResponseDTO<Station> responseDTO = new ResponseDTO<>(
                    "Rodoviária não encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
        }

        ResponseDTO<Station> responseDTO = new ResponseDTO<>(
                "Rodoviária recuperado com sucesso", optionalStation.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<Station>>> getAllStations() {
        List<Station> entities = stationService.getAllEntities();
        ResponseDTO<List<Station>> responseDTO = new ResponseDTO<>(
                "Rodoviárias recuperadas com sucesso", entities);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}
