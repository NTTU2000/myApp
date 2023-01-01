package com.myapp.dev.model.mapping;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "EVENT")
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "EVENT_ID")
    private Long eventId;

    @Column(name = "EVENT_DATE")
    private LocalDate eventDate;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

}
