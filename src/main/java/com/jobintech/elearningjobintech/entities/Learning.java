package com.jobintech.elearningjobintech.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Learning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;



    @ManyToOne
    @JoinColumn(
            referencedColumnName = "id",
            name = "steps-user-FK")
    @JsonIgnoreProperties("learnings")
    private Steps steps;

    public Learning(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Learning(String title, String description, String status, Steps steps) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.steps = steps;
    }



}
