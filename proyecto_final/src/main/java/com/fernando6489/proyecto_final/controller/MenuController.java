package com.fernando6489.proyecto_final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/admin/menu")
    public String adminMenu() {
        return "menu_admin"; // busca menu_admin.html en templates
    }

    @GetMapping("/usuario/menu")
    public String usuarioMenu() {
        return "menu_usuario"; // busca menu_usuario.html en templates
    }

    @GetMapping("/cliente/menu")
    public String clienteMenu() {
        return "menu_cliente"; // busca menu_cliente.html en templates
    }
}
