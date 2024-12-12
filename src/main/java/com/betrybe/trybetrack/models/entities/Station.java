package com.betrybe.trybetrack.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "stations")
@EntityListeners(AuditingEntityListener.class)
@Audited
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "stations", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<BusLine> busLines;

    public Station() {
    }

    public Station(Long id, String name, List<BusLine> busLines) {
        this.id = id;
        this.name = name;
        this.busLines = busLines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusLine> getBusLines() {
        return busLines;
    }

    public void setBusLines(List<BusLine> busLines) {
        this.busLines = busLines;
    }
}
