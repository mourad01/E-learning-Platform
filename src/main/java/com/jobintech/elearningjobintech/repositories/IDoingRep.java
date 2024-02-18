package com.jobintech.elearningjobintech.repositories;

import com.jobintech.elearningjobintech.entities.Doing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoingRep extends JpaRepository<Doing, Long> {
}
