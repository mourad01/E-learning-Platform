package com.jobintech.elearningjobintech.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    @ManyToOne
    @JoinColumn(
            referencedColumnName = "id",
            name = "steps-Doing-FK")
    @JsonIgnoreProperties("doing")
    private Steps steps;

    public Doing(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Doing(String title, String description, String status, Steps steps) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.steps = steps;
    }
}
