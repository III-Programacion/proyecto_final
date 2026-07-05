package com.fernando6489.proyecto_final.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolesController {

    @GetMapping("/")
    public String home() {
        return "Bienvenido, has iniciado sesión correctamente.";
    }

    @GetMapping("/admin/test")
    public String adminTest() {
        return "Bienvenido ADMIN, acceso concedido.";
    }

    @GetMapping("/usuario/test")
    public String usuarioTest() {
        return "Bienvenido USUARIO, acceso concedido.";
    }

    @GetMapping("/cliente/test")
    public String clienteTest() {
        return "Bienvenido CLIENTE, acceso concedido.";
    }
}
