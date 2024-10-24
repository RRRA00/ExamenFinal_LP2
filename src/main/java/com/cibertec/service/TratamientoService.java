package com.cibertec.service;

import com.cibertec.model.Tratamiento;
import com.cibertec.repository.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    // Registrar nuevo tratamiento
    public Tratamiento registrarTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    // Listar todos los tratamientos
    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepository.findAll();
    }

    // Obtener tratamiento por id
    public Optional<Tratamiento> obtenerTratamientoPorId(int id) {
        return tratamientoRepository.findById(id);
    }

    // Actualizar un tratamiento
    public Tratamiento actualizarTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    // Eliminar un tratamiento
    public void eliminarTratamiento(int id) {
        tratamientoRepository.deleteById(id);
    }
}
