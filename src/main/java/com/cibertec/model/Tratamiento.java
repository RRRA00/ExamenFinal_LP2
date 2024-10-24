package com.cibertec.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Tratamiento")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "historial_medico_id")
    private Historial_Medico historialMedico;

    private String nombre_tratamiento;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha_tratamiento;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Historial_Medico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(Historial_Medico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public String getNombre_tratamiento() {
        return nombre_tratamiento;
    }

    public void setNombre_tratamiento(String nombre_tratamiento) {
        this.nombre_tratamiento = nombre_tratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_tratamiento() {
        return fecha_tratamiento;
    }

    public void setFecha_tratamiento(Date fecha_tratamiento) {
        this.fecha_tratamiento = fecha_tratamiento;
    }
}
