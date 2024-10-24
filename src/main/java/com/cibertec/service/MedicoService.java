package com.cibertec.service;

import com.cibertec.model.Medico;
import com.cibertec.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Registrar nuevo médico
    public Medico registrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Listar todos los médicos
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    // Obtener médico por id
    public Optional<Medico> obtenerMedicoPorId(int id) {
        return medicoRepository.findById(id);
    }

    // Actualizar un médico
    public Medico actualizarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Eliminar un médico
    public void eliminarMedico(int id) {
        medicoRepository.deleteById(id);
    }
}
