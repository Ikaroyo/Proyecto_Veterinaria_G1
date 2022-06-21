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
public class Mascota {
    
    private int id_mascota;
    private String alias;
    private String sexo;
    private String especie;
    private String raza;
    private String color_pelaje;
    private LocalDate fecha_nac;
    private double peso_actual;
    // es el mismo peso de la tabla visita//
    private double peso_promedio;
    private int edad;
    private boolean activo;
    
    Cliente cliente;

    public Mascota(int id_mascota, String alias, String sexo, String especie, String raza, String color_pelaje, LocalDate fecha_nac, double peso_actual, double peso_promedio, boolean activo, Cliente cliente) {
        this.id_mascota = -1;
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.color_pelaje = color_pelaje;
        this.fecha_nac = fecha_nac;
        this.peso_actual = peso_actual;
        this.peso_promedio = peso_promedio;
        this.activo = activo;
        this.cliente = cliente;
    }

    public Mascota(String alias, String sexo, String especie, String raza, String color_pelaje, LocalDate fecha_nac, double peso_actual, double peso_promedio, boolean activo, Cliente cliente) {
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.color_pelaje = color_pelaje;
        this.fecha_nac = fecha_nac;
        this.peso_actual = peso_actual;
        this.peso_promedio = peso_promedio;
        this.activo = activo;
        this.cliente = cliente;
    }

    public Mascota(String alias, String sexo, String especie, String raza, String color_pelaje, LocalDate fecha_nac, double peso_actual, double peso_promedio, boolean activo) {
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.color_pelaje = color_pelaje;
        this.fecha_nac = fecha_nac;
        this.peso_actual = peso_actual;
        this.peso_promedio = peso_promedio;
        this.activo = activo;
    }

    
    
    
    public Mascota() {
        this.id_mascota = -1;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor_pelaje() {
        return color_pelaje;
    }

    public void setColor_pelaje(String color_pelaje) {
        this.color_pelaje = color_pelaje;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public double getPeso_actual() {
        return peso_actual;
    }

    public void setPeso_actual(double peso_actual) {
        this.peso_actual = peso_actual;
    }

    public double getPeso_promedio() {
        return peso_promedio;
    }

    public void setPeso_promedio(double peso_promedio) {
        this.peso_promedio = peso_promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Paciente " + id_mascota + " - " + alias ;
    }
    
   
    
}
