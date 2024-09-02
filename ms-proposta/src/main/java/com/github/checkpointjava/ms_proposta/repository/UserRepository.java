package com.github.checkpointjava.ms_proposta.repository;

import com.github.checkpointjava.ms_proposta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}