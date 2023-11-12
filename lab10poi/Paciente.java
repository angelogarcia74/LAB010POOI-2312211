/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10poi;

/**
 *
 * @author Angelo Garcia
 */
   public class Paciente {
    private double dni;
    private String nombre;
    private String direccion;
    private double peso;
    private double temperatura;
    private Medico medicoAtendiente;

    public Paciente() {
    }

    public Paciente(double dni, String nombre, String direccion, double peso, double temperatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Medico getMedicoAtendiente() {
        return medicoAtendiente;
    }

    public void setMedicoAtendiente(Medico medicoAsignado) {
        this.medicoAtendiente = medicoAsignado;
    }

   }

    

