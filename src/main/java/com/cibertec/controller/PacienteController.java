package com.cibertec.controller;

import com.cibertec.model.Paciente;
import com.cibertec.service.PacienteService;

import jakarta.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Mostrar formulario para registrar un nuevo paciente
    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "registrarPaciente";  // nombre de la vista HTML
    }

    
    @PostMapping("/registrar")
    public String registrarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        // Registra el paciente usando el servicio
        Paciente nuevoPaciente = pacienteService.registrarPaciente(paciente);
        // Redirigir a la página de lista de pacientes
        return "redirect:/pacientes/listar";
    }



    // Mostrar la lista de pacientes
    @GetMapping("/listar")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        model.addAttribute("pacientes", pacientes);
        return "listarPacientes"; // Asegúrate de que este sea el nombre correcto de tu vista
    }
  

    private void generarConstanciaPDF(Paciente paciente, HttpServletResponse response) throws Exception {

        InputStream reporteStream = this.getClass().getResourceAsStream("/reportes/constanciaApellido.jasper");

  
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", paciente.getNombre());
        parametros.put("apellido", paciente.getApellido());
        parametros.put("direccion", paciente.getDireccion());
       

        // Cargar el archivo .jasper
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporteStream);

        // Rellenar el reporte con los datos del paciente
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

        // Configurar la respuesta para generar el PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=constancia_" + paciente.getApellido() + ".pdf");

        // Exportar el reporte como un archivo PDF
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
    
   
}

