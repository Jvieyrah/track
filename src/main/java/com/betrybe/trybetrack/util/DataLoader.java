package com.betrybe.trybetrack.util;

import com.betrybe.trybetrack.models.entities.BusLine;
import com.betrybe.trybetrack.models.entities.Schedule;
import com.betrybe.trybetrack.models.entities.Station;
import com.betrybe.trybetrack.services.impl.BusLineService;
import com.betrybe.trybetrack.services.impl.ScheduleService;
import com.betrybe.trybetrack.services.impl.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Profile("!test")

@Component
public class DataLoader implements ApplicationRunner {

    private final BusLineService busLineService;

    private final ScheduleService scheduleService;

    private final StationService stationService;

    @Autowired
    public DataLoader(BusLineService busLineService, ScheduleService scheduleService, StationService stationService) {
        this.busLineService = busLineService;
        this.scheduleService = scheduleService;
        this.stationService = stationService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Random r = new Random();

        BusLine line001 = new BusLine(null, "TBR-001", "Belo Horizonte - São Paulo", null, null);
        BusLine line101 = new BusLine(null, "TBR-101", "São Paulo - Belo Horizonte", null, null);
        BusLine line002 = new BusLine(null, "TBR-002", "São Paulo - Rio de Janeiro", null, null);
        BusLine line102 = new BusLine(null, "TBR-102", "Rio de Janeiro - São Paulo", null, null);
        BusLine line003 = new BusLine(null, "TBR-003", "Belo Horizonte - Salvador", null, null);
        BusLine line103 = new BusLine(null, "TBR-103", "Salvador - Belo Horizonte", null, null);
        BusLine line004 = new BusLine(null, "TBR-004", "Salvador - Fortaleza", null, null);
        BusLine line104 = new BusLine(null, "TBR-104", "Fortaleza - Salvador", null, null);
        BusLine line005 = new BusLine(null, "TBR-005", "Recife - Natal", null, null);
        BusLine line105 = new BusLine(null, "TBR-105", "Natal - Recife", null, null);
        BusLine line006 = new BusLine(null, "TBR-006", "João Pessoa - Teresina", null, null);
        BusLine line106 = new BusLine(null, "TBR-106", "Teresina - João Pessoa", null, null);
        BusLine line007 = new BusLine(null, "TBR-007", "Curitiba - São Paulo", null, null);
        BusLine line107 = new BusLine(null, "TBR-107", "São Paulo - Curitiba", null, null);
        BusLine line008 = new BusLine(null, "TBR-008", "Porto Alegre - São Paulo", null, null);
        BusLine line108 = new BusLine(null, "TBR-108", "São Paulo - Porto Alegre", null, null);
        BusLine line009 = new BusLine(null, "TBR-009", "Campo Grande - Brasilia", null, null);
        BusLine line109 = new BusLine(null, "TBR-109", "Brasilia - Campo Grande", null, null);
        BusLine line010 = new BusLine(null, "TBR-010", "Brasilia - Belém", null, null);
        BusLine line110 = new BusLine(null, "TBR-110", "Belém - Brasilia", null, null);

        line001 = busLineService.createEntity(line001);
        line101 = busLineService.createEntity(line101);
        line002 = busLineService.createEntity(line002);
        line102 = busLineService.createEntity(line102);
        line003 = busLineService.createEntity(line003);
        line103 = busLineService.createEntity(line103);
        line004 = busLineService.createEntity(line004);
        line104 = busLineService.createEntity(line104);
        line005 = busLineService.createEntity(line005);
        line105 = busLineService.createEntity(line105);
        line006 = busLineService.createEntity(line006);
        line106 = busLineService.createEntity(line106);
        line007 = busLineService.createEntity(line007);
        line107 = busLineService.createEntity(line107);
        line008 = busLineService.createEntity(line008);
        line108 = busLineService.createEntity(line108);
        line009 = busLineService.createEntity(line009);
        line109 = busLineService.createEntity(line109);
        line010 = busLineService.createEntity(line010);
        line110 = busLineService.createEntity(line110);

        Station station001 = new Station(null, "Rodoviária de Belo Horizonte", null);
        Station station002 = new Station(null, "Rodoviária de São Paulo", null);
        Station station003 = new Station(null, "Rodoviária de Rio de Janeiro", null);
        Station station004 = new Station(null, "Rodoviária de Salvador", null);
        Station station005 = new Station(null, "Rodoviária de Fortaleza", null);
        Station station006 = new Station(null, "Rodoviária de Recife", null);
        Station station007 = new Station(null, "Rodoviária de Natal", null);
        Station station008 = new Station(null, "Rodoviária de João pessoa", null);
        Station station009 = new Station(null, "Rodoviária de Teresina", null);
        Station station010 = new Station(null, "Rodoviária de Curitiba", null);
        Station station011 = new Station(null, "Rodoviária de Porto Alegre", null);
        Station station012 = new Station(null, "Rodoviária de Campo Grande", null);
        Station station013 = new Station(null, "Rodoviária de Brasília", null);
        Station station014 = new Station(null, "Rodoviária de Belém", null);

        station001 = stationService.createEntity(station001);
        station002 = stationService.createEntity(station002);
        station003 = stationService.createEntity(station003);
        station004 = stationService.createEntity(station004);
        station005 = stationService.createEntity(station005);
        station006 = stationService.createEntity(station006);
        station007 = stationService.createEntity(station007);
        station008 = stationService.createEntity(station008);
        station009 = stationService.createEntity(station009);
        station010 = stationService.createEntity(station010);
        station011 = stationService.createEntity(station011);
        station012 = stationService.createEntity(station012);
        station013 = stationService.createEntity(station013);
        station014 = stationService.createEntity(station014);

        busLineService.setStationToBusLine(line001.getId(),station001.getId());
        busLineService.setStationToBusLine(line001.getId(),station003.getId());
        busLineService.setStationToBusLine(line001.getId(),station002.getId());

        busLineService.setStationToBusLine(line101.getId(),station002.getId());
        busLineService.setStationToBusLine(line101.getId(),station003.getId());
        busLineService.setStationToBusLine(line101.getId(),station001.getId());

        busLineService.setStationToBusLine(line002.getId(),station001.getId());
        busLineService.setStationToBusLine(line002.getId(),station003.getId());

        busLineService.setStationToBusLine(line102.getId(),station002.getId());
        busLineService.setStationToBusLine(line102.getId(),station003.getId());

        busLineService.setStationToBusLine(line003.getId(),station001.getId());
        busLineService.setStationToBusLine(line003.getId(),station003.getId());
        busLineService.setStationToBusLine(line003.getId(),station004.getId());

        busLineService.setStationToBusLine(line103.getId(),station004.getId());
        busLineService.setStationToBusLine(line103.getId(),station003.getId());
        busLineService.setStationToBusLine(line103.getId(),station001.getId());

        busLineService.setStationToBusLine(line004.getId(),station004.getId());
        busLineService.setStationToBusLine(line004.getId(),station006.getId());
        busLineService.setStationToBusLine(line004.getId(),station007.getId());
        busLineService.setStationToBusLine(line004.getId(),station008.getId());
        busLineService.setStationToBusLine(line004.getId(),station005.getId());

        busLineService.setStationToBusLine(line104.getId(),station005.getId());
        busLineService.setStationToBusLine(line104.getId(),station008.getId());
        busLineService.setStationToBusLine(line104.getId(),station007.getId());
        busLineService.setStationToBusLine(line104.getId(),station006.getId());
        busLineService.setStationToBusLine(line104.getId(),station004.getId());

        busLineService.setStationToBusLine(line005.getId(),station006.getId());
        busLineService.setStationToBusLine(line005.getId(),station008.getId());
        busLineService.setStationToBusLine(line005.getId(),station007.getId());

        busLineService.setStationToBusLine(line105.getId(),station007.getId());
        busLineService.setStationToBusLine(line105.getId(),station008.getId());
        busLineService.setStationToBusLine(line105.getId(),station006.getId());

        busLineService.setStationToBusLine(line006.getId(),station008.getId());
        busLineService.setStationToBusLine(line006.getId(),station007.getId());
        busLineService.setStationToBusLine(line006.getId(),station005.getId());
        busLineService.setStationToBusLine(line006.getId(),station009.getId());

        busLineService.setStationToBusLine(line106.getId(),station009.getId());
        busLineService.setStationToBusLine(line106.getId(),station005.getId());
        busLineService.setStationToBusLine(line106.getId(),station007.getId());
        busLineService.setStationToBusLine(line106.getId(),station008.getId());

        busLineService.setStationToBusLine(line007.getId(),station010.getId());
        busLineService.setStationToBusLine(line007.getId(),station002.getId());

        busLineService.setStationToBusLine(line107.getId(),station002.getId());
        busLineService.setStationToBusLine(line107.getId(),station010.getId());

        busLineService.setStationToBusLine(line008.getId(),station011.getId());
        busLineService.setStationToBusLine(line008.getId(),station010.getId());
        busLineService.setStationToBusLine(line008.getId(),station002.getId());

        busLineService.setStationToBusLine(line108.getId(),station002.getId());
        busLineService.setStationToBusLine(line108.getId(),station010.getId());
        busLineService.setStationToBusLine(line108.getId(),station011.getId());

        busLineService.setStationToBusLine(line009.getId(),station012.getId());
        busLineService.setStationToBusLine(line009.getId(),station013.getId());

        busLineService.setStationToBusLine(line109.getId(),station013.getId());
        busLineService.setStationToBusLine(line109.getId(),station012.getId());

        busLineService.setStationToBusLine(line010.getId(),station005.getId());
        busLineService.setStationToBusLine(line010.getId(),station014.getId());

        busLineService.setStationToBusLine(line110.getId(),station014.getId());
        busLineService.setStationToBusLine(line110.getId(),station005.getId());


        Schedule schedule011 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line001);
        Schedule schedule012 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line001);
        Schedule schedule013 = new Schedule(null, LocalDate.of(2023, r.nextInt(3, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line001);
        Schedule schedule014 = new Schedule(null, LocalDate.of(2023, r.nextInt(3, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line001);

        Schedule schedule021 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line002);
        Schedule schedule022 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line002);
        Schedule schedule023 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line002);
        Schedule schedule024 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line002);

        Schedule schedule031 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line003);
        Schedule schedule032 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line003);
        Schedule schedule033 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line003);
        Schedule schedule034 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line003);

        Schedule schedule041 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line004);
        Schedule schedule042 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line004);
        Schedule schedule043 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line004);
        Schedule schedule044 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line004);

        Schedule schedule051 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line005);
        Schedule schedule052 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line005);
        Schedule schedule053 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line005);
        Schedule schedule054 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line005);

        Schedule schedule061 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line006);
        Schedule schedule062 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line006);
        Schedule schedule063 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line006);
        Schedule schedule064 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line006);

        Schedule schedule071 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line007);
        Schedule schedule072 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line007);
        Schedule schedule073 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line007);
        Schedule schedule074 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line007);

        Schedule schedule081 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line008);
        Schedule schedule082 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line008);
        Schedule schedule083 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line008);
        Schedule schedule084 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line008);

        Schedule schedule091 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line009);
        Schedule schedule092 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line009);
        Schedule schedule093 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line009);
        Schedule schedule094 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line009);

        Schedule schedule101 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line010);
        Schedule schedule102 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line010);
        Schedule schedule103 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line010);
        Schedule schedule104 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line010);

        Schedule schedule111 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line101);
        Schedule schedule112 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line101);
        Schedule schedule113 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line101);
        Schedule schedule114 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line101);

        Schedule schedule121 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line102);
        Schedule schedule122 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line102);
        Schedule schedule123 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line102);
        Schedule schedule124 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line102);

        Schedule schedule131 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line103);
        Schedule schedule132 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line103);
        Schedule schedule133 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line103);
        Schedule schedule134 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line103);

        Schedule schedule141 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line104);
        Schedule schedule142 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line104);
        Schedule schedule143 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line104);
        Schedule schedule144 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line104);

        Schedule schedule151 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line105);
        Schedule schedule152 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line105);
        Schedule schedule153 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line105);
        Schedule schedule154 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line105);

        Schedule schedule161 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line106);
        Schedule schedule162 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line106);
        Schedule schedule163 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line106);
        Schedule schedule164 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line106);

        Schedule schedule171 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line107);
        Schedule schedule172 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line107);
        Schedule schedule173 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line107);
        Schedule schedule174 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line107);

        Schedule schedule181 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line108);
        Schedule schedule182 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line108);
        Schedule schedule183 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line108);
        Schedule schedule184 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line108);

        Schedule schedule191 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line109);
        Schedule schedule192 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line109);
        Schedule schedule193 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line109);
        Schedule schedule194 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line109);

        Schedule schedule201 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line110);
        Schedule schedule202 = new Schedule(null, LocalDate.of(2023, r.nextInt(8, 12), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), true, line110);
        Schedule schedule203 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line110);
        Schedule schedule204 = new Schedule(null, LocalDate.of(2023, r.nextInt(1, 7), r.nextInt(1, 25)), LocalTime.of(r.nextInt(0, 23), r.nextInt(0, 59)), false, line110);

        scheduleService.createEntity(schedule011);
        scheduleService.createEntity(schedule012);
        scheduleService.createEntity(schedule013);
        scheduleService.createEntity(schedule014);

        scheduleService.createEntity(schedule021);
        scheduleService.createEntity(schedule022);
        scheduleService.createEntity(schedule023);
        scheduleService.createEntity(schedule024);

        scheduleService.createEntity(schedule031);
        scheduleService.createEntity(schedule032);
        scheduleService.createEntity(schedule033);
        scheduleService.createEntity(schedule034);

        scheduleService.createEntity(schedule041);
        scheduleService.createEntity(schedule042);
        scheduleService.createEntity(schedule043);
        scheduleService.createEntity(schedule044);

        scheduleService.createEntity(schedule051);
        scheduleService.createEntity(schedule052);
        scheduleService.createEntity(schedule053);
        scheduleService.createEntity(schedule054);

        scheduleService.createEntity(schedule061);
        scheduleService.createEntity(schedule062);
        scheduleService.createEntity(schedule063);
        scheduleService.createEntity(schedule064);

        scheduleService.createEntity(schedule071);
        scheduleService.createEntity(schedule072);
        scheduleService.createEntity(schedule073);
        scheduleService.createEntity(schedule074);

        scheduleService.createEntity(schedule081);
        scheduleService.createEntity(schedule082);
        scheduleService.createEntity(schedule083);
        scheduleService.createEntity(schedule084);

        scheduleService.createEntity(schedule091);
        scheduleService.createEntity(schedule092);
        scheduleService.createEntity(schedule093);
        scheduleService.createEntity(schedule094);


        scheduleService.createEntity(schedule101);
        scheduleService.createEntity(schedule102);
        scheduleService.createEntity(schedule103);
        scheduleService.createEntity(schedule104);

        scheduleService.createEntity(schedule111);
        scheduleService.createEntity(schedule112);
        scheduleService.createEntity(schedule113);
        scheduleService.createEntity(schedule114);

        scheduleService.createEntity(schedule121);
        scheduleService.createEntity(schedule122);
        scheduleService.createEntity(schedule123);
        scheduleService.createEntity(schedule124);

        scheduleService.createEntity(schedule131);
        scheduleService.createEntity(schedule132);
        scheduleService.createEntity(schedule133);
        scheduleService.createEntity(schedule134);

        scheduleService.createEntity(schedule141);
        scheduleService.createEntity(schedule142);
        scheduleService.createEntity(schedule143);
        scheduleService.createEntity(schedule144);

        scheduleService.createEntity(schedule151);
        scheduleService.createEntity(schedule152);
        scheduleService.createEntity(schedule153);
        scheduleService.createEntity(schedule154);

        scheduleService.createEntity(schedule161);
        scheduleService.createEntity(schedule162);
        scheduleService.createEntity(schedule163);
        scheduleService.createEntity(schedule164);

        scheduleService.createEntity(schedule171);
        scheduleService.createEntity(schedule172);
        scheduleService.createEntity(schedule173);
        scheduleService.createEntity(schedule174);

        scheduleService.createEntity(schedule181);
        scheduleService.createEntity(schedule182);
        scheduleService.createEntity(schedule183);
        scheduleService.createEntity(schedule184);

        scheduleService.createEntity(schedule191);
        scheduleService.createEntity(schedule192);
        scheduleService.createEntity(schedule193);
        scheduleService.createEntity(schedule194);

        scheduleService.createEntity(schedule201);
        scheduleService.createEntity(schedule202);
        scheduleService.createEntity(schedule203);
        scheduleService.createEntity(schedule204);


    }
}
