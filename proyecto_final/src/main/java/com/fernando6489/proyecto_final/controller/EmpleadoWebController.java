package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.model.Empleado;
import com.fernando6489.proyecto_final.repository.EmpleadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/empleados")
public class EmpleadoWebController {

    private final EmpleadoRepository repo;

    public EmpleadoWebController(EmpleadoRepository repo) {
        this.repo = repo;
    }

    // Listar todos los empleados
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleados", repo.findAll());
        return "empleados_list"; // plantilla Thymeleaf
    }

    // Mostrar formulario de nuevo empleado
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleado_form"; // plantilla Thymeleaf
    }

    // Guardar empleado (nuevo o editado)
    @PostMapping
    public String guardar(@ModelAttribute Empleado empleado) {
        repo.save(empleado);
        return "redirect:/admin/empleados";
    }

    // Editar empleado existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Empleado empleado = repo.findById(id).orElseThrow();
        model.addAttribute("empleado", empleado);
        return "empleado_form"; // reutiliza el mismo formulario
    }

    // Eliminar empleado
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/admin/empleados";
    }
}
