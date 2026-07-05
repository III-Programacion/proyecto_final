package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.model.Proyecto;
import com.fernando6489.proyecto_final.repository.ProyectoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    private final ProyectoRepository repo;

    public ProyectoController(ProyectoRepository repo) {
        this.repo = repo;
    }

    // Listar todos los proyectos
    @GetMapping
    public List<Proyecto> listar() {
        return repo.findAll();
    }

    // Obtener un proyecto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo proyecto
    @PostMapping
    public Proyecto crear(@RequestBody Proyecto proyecto) {
        return repo.save(proyecto);
    }

    // Actualizar un proyecto existente
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizar(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        return repo.findById(id)
                .map(p -> {
                    p.setNombre(proyecto.getNombre());
                    p.setDescripcion(proyecto.getDescripcion());
                    return ResponseEntity.ok(repo.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un proyecto
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
