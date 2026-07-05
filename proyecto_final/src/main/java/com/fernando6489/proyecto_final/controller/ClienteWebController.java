package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.model.Cliente;
import com.fernando6489.proyecto_final.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/clientes")
public class ClienteWebController {

    private final ClienteRepository repo;

    public ClienteWebController(ClienteRepository repo) {
        this.repo = repo;
    }

    // Listar todos los clientes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", repo.findAll());
        return "clientes_list";
    }

    // Mostrar formulario de nuevo cliente
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente_form";
    }

    // Guardar cliente (nuevo o editado)
    @PostMapping
    public String guardar(@ModelAttribute Cliente cliente) {
        repo.save(cliente);
        return "redirect:/admin/clientes";
    }

    // Editar cliente existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Cliente cliente = repo.findById(id).orElseThrow();
        model.addAttribute("cliente", cliente);
        return "cliente_form";
    }

    // Eliminar cliente
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/admin/clientes";
    }
}
