package com.betrybe.trybetrack;

import com.betrybe.trybetrack.models.entities.BusLine;
import com.betrybe.trybetrack.models.entities.Schedule;
import com.betrybe.trybetrack.models.repositories.BusLineRepository;
import com.betrybe.trybetrack.models.repositories.ScheduleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class TrybetrackApplicationTest {

    @MockBean
    BusLineRepository busLineRepository;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ScheduleRepository scheduleRepository;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void creteBusLine() throws Exception {
        BusLine fakeBusLine = new BusLine();

        Mockito.when(busLineRepository.save(any())).thenReturn(fakeBusLine);
        mockMvc.perform(
                        post("/buslines").content(asJsonString(new BusLine())).contentType("application/json"))
                .andExpect(status().isCreated());
        Mockito.verify(busLineRepository).save(any(BusLine.class));
    }

    @Test
    void updateBusLineSuccess() throws Exception {
        BusLine fakeBusLine = new BusLine();
        Mockito.when(busLineRepository.findById(anyLong())).thenReturn(Optional.of(fakeBusLine));
        Mockito.when(busLineRepository.save(any(BusLine.class))).thenReturn(fakeBusLine);

        mockMvc.perform(
                        put("/buslines/1").content(asJsonString(new BusLine())).contentType("application/json"))
                .andExpect(status().isOk());
        Mockito.verify(busLineRepository).save(any(BusLine.class));
    }

    @Test
    void updateBusLineFail() throws Exception {
        Mockito.when(busLineRepository.findById(any())).thenReturn(Optional.empty());
        mockMvc.perform(
                        put("/buslines/1").content(asJsonString(new BusLine())).contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Itinerário não encontrado"));
        Mockito.verify(busLineRepository, never()).save(any(BusLine.class));
    }

    @Test
    void deleteBusLineSuccess() throws Exception {
        BusLine fakeBusLine = new BusLine();
        Mockito.when(busLineRepository.findById(any())).thenReturn(Optional.of(fakeBusLine));
        mockMvc.perform(
                        delete("/buslines/1"))
                .andExpect(status().isOk());
        Mockito.verify(busLineRepository).deleteById(anyLong());
    }

    @Test
    void deleteBusLineFail() throws Exception {
        Mockito.when(busLineRepository.findById(any())).thenReturn(Optional.empty());
        mockMvc.perform(
                        delete("/buslines/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Itinerário não encontrado"));
        Mockito.verify(busLineRepository, never()).deleteById(anyLong());
    }

    @Test
    void getByIdBusLineSuccess() throws Exception {
        BusLine busLine = new BusLine();
        Mockito.when(busLineRepository.findById(any())).thenReturn(Optional.of(busLine));
        mockMvc.perform(
                        get("/buslines/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getByIdBusLineFail() throws Exception {
        Mockito.when(busLineRepository.findById(any())).thenReturn(Optional.empty());
        mockMvc.perform(
                        get("/buslines/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Itinerário não encontrado"));
        ;
    }

    @Test
    void getBusLineSuccess() throws Exception {
        BusLine fakeBusLine = new BusLine();
        Mockito.when(busLineRepository.findAll()).thenReturn(List.of(fakeBusLine));
        mockMvc.perform(
                        get("/buslines"))
                .andExpect(status().isOk());
    }
    @Test
    void createScheduleSuccess() throws Exception {
        BusLine fakeBusLine = new BusLine(1L, "TBR-001", "Belo Horizonte - São Paulo", new ArrayList<>(), new ArrayList<>());
        Schedule fakeSchedule = new Schedule();
        Mockito.when(busLineRepository.findById(any())).thenReturn(Optional.of(fakeBusLine));
        Mockito.when(scheduleRepository.save(any(Schedule.class))).thenReturn(fakeSchedule);
        mockMvc.perform(
                        post("/buslines/1/schedule").content(asJsonString(fakeSchedule)).contentType("application/json"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.id").value(fakeSchedule.getId()));
        Mockito.verify(busLineRepository).findById(fakeBusLine.getId());
        Mockito.verify(busLineRepository).save(fakeBusLine);
    }

}
