package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.model.Proyecto;
import com.fernando6489.proyecto_final.model.Cliente;
import com.fernando6489.proyecto_final.model.Empleado;
import com.fernando6489.proyecto_final.repository.ProyectoRepository;
import com.fernando6489.proyecto_final.repository.ClienteRepository;
import com.fernando6489.proyecto_final.repository.EmpleadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/proyectos")
public class ProyectoWebController {

    private final ProyectoRepository proyectoRepo;
    private final ClienteRepository clienteRepo;
    private final EmpleadoRepository empleadoRepo;

    public ProyectoWebController(ProyectoRepository proyectoRepo,
                                 ClienteRepository clienteRepo,
                                 EmpleadoRepository empleadoRepo) {
        this.proyectoRepo = proyectoRepo;
        this.clienteRepo = clienteRepo;
        this.empleadoRepo = empleadoRepo;
    }

    // Listar proyectos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proyectos", proyectoRepo.findAll());
        return "proyectos_list";
    }

    // Formulario nuevo proyecto
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        model.addAttribute("clientes", clienteRepo.findAll());
        model.addAttribute("empleados", empleadoRepo.findAll());
        return "proyecto_form";
    }

    // Guardar proyecto (corrigiendo cliente y empleados)
    @PostMapping
    public String guardar(@ModelAttribute Proyecto proyecto) {
        // Resolver cliente por ID
        Cliente cliente = clienteRepo.findById(proyecto.getCliente().getId()).orElseThrow();
        proyecto.setCliente(cliente);

        // Resolver empleados por ID
        List<Empleado> empleados = new ArrayList<>();
        for (Empleado e : proyecto.getEmpleados()) {
            Empleado empleado = empleadoRepo.findById(e.getId()).orElseThrow();
            empleados.add(empleado);
        }
        proyecto.setEmpleados(empleados);

        proyectoRepo.save(proyecto);
        return "redirect:/admin/proyectos";
    }

    // Editar proyecto
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Proyecto proyecto = proyectoRepo.findById(id).orElseThrow();
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("clientes", clienteRepo.findAll());
        model.addAttribute("empleados", empleadoRepo.findAll());
        return "proyecto_form";
    }

    // Eliminar proyecto
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        proyectoRepo.deleteById(id);
        return "redirect:/admin/proyectos";
    }
}
