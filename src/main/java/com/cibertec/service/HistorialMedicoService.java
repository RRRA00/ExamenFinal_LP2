package com.cibertec.service;

import com.cibertec.model.Historial_Medico;
import com.cibertec.repository.Historial_MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService {

    @Autowired
    private Historial_MedicoRepository historialMedicoRepository;

    // Registrar nuevo historial médico
    public Historial_Medico registrarHistorialMedico(Historial_Medico historialMedico) {
        return historialMedicoRepository.save(historialMedico);
    }

    // Listar todos los historiales médicos
    public List<Historial_Medico> listarHistorialesMedicos() {
        return historialMedicoRepository.findAll();
    }

    // Obtener historial médico por id
    public Optional<Historial_Medico> obtenerHistorialMedicoPorId(int id) {
        return historialMedicoRepository.findById(id);
    }

    // Actualizar un historial médico
    public Historial_Medico actualizarHistorialMedico(Historial_Medico historialMedico) {
        return historialMedicoRepository.save(historialMedico);
    }

    // Eliminar un historial médico
    public void eliminarHistorialMedico(int id) {
        historialMedicoRepository.deleteById(id);
    }
}
