package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.model.Perfil;
import com.fernando6489.proyecto_final.repository.PerfilRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/perfiles")
public class PerfilWebController {

    private final PerfilRepository repo;

    public PerfilWebController(PerfilRepository repo) {
        this.repo = repo;
    }

    // Listar todos los perfiles
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("perfiles", repo.findAll());
        return "perfiles_list";
    }

    // Mostrar formulario de nuevo perfil
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("perfil", new Perfil());
        return "perfil_form";
    }

    // Guardar perfil (nuevo o editado)
    @PostMapping
    public String guardar(@ModelAttribute Perfil perfil) {
        repo.save(perfil);
        return "redirect:/admin/perfiles";
    }

    // Editar perfil existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Perfil perfil = repo.findById(id).orElseThrow();
        model.addAttribute("perfil", perfil);
        return "perfil_form";
    }

    // Eliminar perfil
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/admin/perfiles";
    }
}
