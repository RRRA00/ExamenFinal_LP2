package com.cibertec.controller;

import com.cibertec.model.Historial_Medico;
import com.cibertec.model.Paciente;
import com.cibertec.model.Medico;
import com.cibertec.service.HistorialMedicoService;
import com.cibertec.service.PacienteService;
import com.cibertec.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/historialMedico")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialMedicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    // Mostrar formulario para registrar un nuevo historial médico
    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("historialMedico", new Historial_Medico());

        // Agregar lista de pacientes y médicos para seleccionar
        List<Paciente> listaPacientes = pacienteService.listarPacientes();
        List<Medico> listaMedicos = medicoService.listarMedicos();
        model.addAttribute("pacientes", listaPacientes);
        model.addAttribute("medicos", listaMedicos);

        return "registrarHistorialMedico";  // nombre de la vista HTML
    }

    // Procesar el registro de un nuevo historial médico
    @PostMapping("/registrar")
    public String registrarHistorialMedico(@ModelAttribute("historialMedico") Historial_Medico historialMedico) {
        historialMedicoService.registrarHistorialMedico(historialMedico);
        return "redirect:/historialMedico/listar"; // Redirecciona a la lista de historiales médicos después del registro
    }

    // Mostrar la lista de historiales médicos
    @GetMapping("/listar")
    public String listarHistorialesMedicos(Model model) {
        List<Historial_Medico> listaHistorialMedico = historialMedicoService.listarHistorialesMedicos();
        model.addAttribute("historialesMedicos", listaHistorialMedico);
        return "listarHistorialesMedicos";  // nombre de la vista HTML
    }
}
