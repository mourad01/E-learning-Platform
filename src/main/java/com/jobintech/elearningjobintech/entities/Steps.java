package com.jobintech.elearningjobintech.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Steps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    @ManyToOne
    @JsonIgnoreProperties("Parcour")
    @JoinColumn(referencedColumnName = "id",
    name = "parcour-user-FK",
    nullable = false)
    private Parcour parcour;

}
