package com.jobintech.elearningjobintech.repositories;

import com.jobintech.elearningjobintech.entities.Learning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILearningRep extends JpaRepository<Learning, Long> {

}
