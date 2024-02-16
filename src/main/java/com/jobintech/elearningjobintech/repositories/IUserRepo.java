package com.jobintech.elearningjobintech.repositories;

import com.jobintech.elearningjobintech.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<Users, Long> {
}
