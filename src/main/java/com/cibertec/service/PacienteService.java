package com.cibertec.service;

import com.cibertec.model.Paciente;
import com.cibertec.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Registrar nuevo paciente
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Listar todos los pacientes
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // Obtener paciente por id
    public Optional<Paciente> obtenerPacientePorId(int id) {
        return pacienteRepository.findById(id);
    }

    // Actualizar un paciente
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Eliminar un paciente
    public void eliminarPaciente(int id) {
        pacienteRepository.deleteById(id);
    }
}
