/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import javax.swing.JOptionPane;

/**
 *
 * @author darkheaven
 */
public class Main {
    public static void main(String[] args) { 
    System.setProperty("https.protocols", "TLSv1.2");
        
        Paciente paciente = new Paciente("Ulises", "guillermo.hernandez261429@potros.itson.edu.mx", "6221389801");
        Medico medico = new Medico("cholo", "joaquin.carpio261724@potros.itson.edu.mx");

        Cita cita = new Cita("2025-10-05", "10:00", paciente, medico, "COVID-20");


        paciente.enviarConfirmacionCita(cita);
        
        
        medico.enviarNotificacionCita(cita);
        
        
        
    }
}      


