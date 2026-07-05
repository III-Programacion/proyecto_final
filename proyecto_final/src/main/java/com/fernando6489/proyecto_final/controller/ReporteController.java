package com.fernando6489.proyecto_final.controller;

import com.fernando6489.proyecto_final.repository.ClienteRepository;
import com.fernando6489.proyecto_final.repository.EmpleadoRepository;
import com.fernando6489.proyecto_final.repository.ProyectoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/reportes")
public class ReporteController {

    private final ClienteRepository clienteRepo;
    private final EmpleadoRepository empleadoRepo;
    private final ProyectoRepository proyectoRepo;

    // Constructor para inyectar repositorios
    public ReporteController(ClienteRepository clienteRepo,
                             EmpleadoRepository empleadoRepo,
                             ProyectoRepository proyectoRepo) {
        this.clienteRepo = clienteRepo;
        this.empleadoRepo = empleadoRepo;
        this.proyectoRepo = proyectoRepo;
    }

    // Menú principal de reportes
    @GetMapping
    public String generarReporte() {
        return "reportes_menu"; // busca reportes_menu.html en templates
    }

    // Reporte de Clientes
    @GetMapping("/clientes")
    public String reporteClientes(Model model) {
        model.addAttribute("clientes", clienteRepo.findAll());
        return "reporte_clientes"; // busca reporte_clientes.html en templates
    }

    // Reporte de Empleados
    @GetMapping("/empleados")
    public String reporteEmpleados(Model model) {
        model.addAttribute("empleados", empleadoRepo.findAll());
        return "reporte_empleados"; // busca reporte_empleados.html en templates
    }
    // Reporte de Proyectos
    @GetMapping("/proyectos")
    public String reporteProyectos(Model model) {
        model.addAttribute("proyectos", proyectoRepo.findAll());
        return "reporte_proyectos"; // busca reporte_proyectos.html en templates
    }
}
