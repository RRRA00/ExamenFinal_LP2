package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.Tratamiento;
import com.cibertec.service.TratamientoService;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;

    @PostMapping("/registrar")
    public ResponseEntity<Tratamiento> registrarTratamiento(@RequestBody Tratamiento tratamiento) {
        Tratamiento nuevoTratamiento = tratamientoService.registrarTratamiento(tratamiento);
        return ResponseEntity.ok(nuevoTratamiento);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Tratamiento>> listarTratamientos() {
        List<Tratamiento> tratamientos = tratamientoService.listarTratamientos();
        return ResponseEntity.ok(tratamientos);
    }
}