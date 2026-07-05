package com.fernando6489.proyecto_final.repository;

import com.fernando6489.proyecto_final.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
