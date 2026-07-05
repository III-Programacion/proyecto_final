package com.fernando6489.proyecto_final.service;

import com.fernando6489.proyecto_final.model.Empleado;
import com.fernando6489.proyecto_final.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepository repo;

    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public List<Empleado> listarTodos() { return repo.findAll(); }
    public Optional<Empleado> buscarPorId(Long id) { return repo.findById(id); }
    public Empleado guardar(Empleado empleado) { return repo.save(empleado); }
    public void eliminar(Long id) { repo.deleteById(id); }
}
