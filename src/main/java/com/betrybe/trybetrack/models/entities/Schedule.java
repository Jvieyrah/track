package com.betrybe.trybetrack.models.entities;

import com.betrybe.trybetrack.listeners.ScheduleListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "schedules")
@EntityListeners(ScheduleListener.class)
@Audited
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    private boolean available;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_line_id")
    @JsonIgnore
    private BusLine busLine;

    public Schedule() {
    }

    public Schedule(Long id, LocalDate departureDate, LocalTime departureTime, boolean available, BusLine busLine) {
        this.id = id;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.available = available;
        this.busLine = busLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }
}
