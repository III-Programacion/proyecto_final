package com.fernando6489.proyecto_final.repository;

import com.fernando6489.proyecto_final.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {}
