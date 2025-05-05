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
public class Medico {

    
    public Medico(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
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
    private String nombre;
    private String email;
    
    
    public void enviarNotificacionCita(Cita cita) {
        NotificacionesCorreo notificacionesCorreo = new NotificacionesCorreo();
        notificacionesCorreo.enviarNotificacionMedico(cita);
    }
}
