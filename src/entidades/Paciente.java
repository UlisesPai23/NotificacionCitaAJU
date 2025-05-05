/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import mensajes.NotificacionesCorreo;

/**
 *
 * @author darkheaven
 */
public class Paciente {
    
    
    public Paciente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }
    private String nombre;
    private String email;
    private String telefono;  
    
    public void enviarConfirmacionCita(Cita cita) {
        NotificacionesCorreo notificacionesCorreo = new NotificacionesCorreo();
        notificacionesCorreo.enviarConfirmacionPaciente(cita);
    }
}
