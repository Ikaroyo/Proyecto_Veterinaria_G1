/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria_MODELO;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Barbara
 */
public class Visita {
    
    private int idvisita;
    private LocalDate fecha_visita;
    private double peso;
    private boolean activo;
    private String sintomas;

    
    Mascota mascota;
    Tratamiento tratamiento;

    public Visita(int idvisita, LocalDate fecha_visita, double peso, boolean activo, Mascota mascota, Tratamiento tratamiento, String sintomas) {
        this.idvisita = -1;
        this.fecha_visita = fecha_visita;
        this.peso = peso;
        this.activo = activo;
        this.mascota = mascota;
        this.tratamiento = tratamiento;
        this.sintomas=sintomas;
    }

    public Visita(LocalDate fecha_visita, double peso, boolean activo, Mascota mascota, Tratamiento tratamiento, String sintomas) {
        this.fecha_visita = fecha_visita;
        this.peso = peso;
        this.activo = activo;
        this.mascota = mascota;
        this.tratamiento = tratamiento;
        this.sintomas=sintomas;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Visita() {
          this.idvisita = -1;
    }

    public int getIdvisita() {
        return idvisita;
    }

    public void setIdvisita(int idvisita) {
        this.idvisita = idvisita;
    }

    public LocalDate getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(LocalDate fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Visita{" + "idvisita=" + idvisita + ", fecha_visita=" + fecha_visita + ", peso=" + peso + ", activo=" + activo + ", mascota=" + mascota + ", tratamiento=" + tratamiento + '}';
    }
    
    
    
    
    
}
