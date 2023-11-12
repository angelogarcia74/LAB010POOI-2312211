/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10poi;

/**
 *
 * @author Angelo Garcia
 */
public class Medico {
    private int Colegiatura;
    private String nombre;
    private String especialidad;

    public Medico() {

    }

    public Medico(int Colegiatura, String nombre, String especialidad) {
        this.Colegiatura = Colegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getColegiatura() {
        return Colegiatura;
    }

    public void setnCogeliatura(int Colegiatura) {
        this.Colegiatura = Colegiatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
