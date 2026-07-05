package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.model.Empleado;
import com.fernando6489.proyecto_final.repository.EmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoRepository repo;

    public EmpleadoController(EmpleadoRepository repo) {
        this.repo = repo;
    }

    // Listar todos los empleados
    @GetMapping
    public List<Empleado> listar() {
        return repo.findAll();
    }

    // Obtener un empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo empleado
    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return repo.save(empleado);
    }

    // Actualizar un empleado existente
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        return repo.findById(id)
                .map(e -> {
                    e.setNombre(empleado.getNombre());
                    e.setEmail(empleado.getEmail());
                    return ResponseEntity.ok(repo.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
