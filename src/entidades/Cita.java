/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author darkheaven
 */
public class Cita {
    
    
    public Cita(String fecha, String hora, Paciente paciente, Medico medico, String motivo) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
        this.motivo = motivo;
    }
    
    

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }
    private String fecha;
    private String hora;
    private Paciente paciente;
    private Medico medico;
    private String motivo;
}
