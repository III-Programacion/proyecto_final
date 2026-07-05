package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.model.Perfil;
import com.fernando6489.proyecto_final.repository.PerfilRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    private final PerfilRepository repo;

    public PerfilController(PerfilRepository repo) {
        this.repo = repo;
    }

    // Listar todos los perfiles
    @GetMapping
    public List<Perfil> listar() {
        return repo.findAll();
    }

    // Obtener un perfil por ID
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo perfil
    @PostMapping
    public Perfil crear(@RequestBody Perfil perfil) {
        return repo.save(perfil);
    }

    // Actualizar un perfil existente
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> actualizar(@PathVariable Long id, @RequestBody Perfil perfil) {
        return repo.findById(id)
                .map(p -> {
                    p.setCargo(perfil.getCargo());
                    p.setTelefono(perfil.getTelefono());
                    return ResponseEntity.ok(repo.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un perfil
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
