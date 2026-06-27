package com.seguroapi.repository;

import com.seguroapi.model.Sinistro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinistroRepository extends JpaRepository<Sinistro, Long> {
}
