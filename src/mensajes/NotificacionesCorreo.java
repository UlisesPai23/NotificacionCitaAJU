/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajes;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import entidades.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author darkheaven
 */
public class NotificacionesCorreo {
    private static String emailFrom = "noti4uemail@gmail.com"; 
    private static String passwordFrom = "ucuk jrxg duwy tsla"; 
    private Properties mProperties;
    private Session mSession;

    
    
    
    public NotificacionesCorreo() {
        mProperties = new Properties();
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.starttls.enable", "true");
        mProperties.put("mail.smtp.port", "587");
        mProperties.put("mail.smtp.user", emailFrom);
        mProperties.put("mail.smtp.auth", "true");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    }

    public void enviarConfirmacionPaciente(Cita cita) {
        Paciente paciente = cita.getPaciente();
        String subject = "Confirmación de Cita";
        String content = String.format(
            "Hola %s,\n\nSu cita con %s está confirmada.\nFecha: %s a las %s\nMotivo: %s\n",
            paciente.getNombre(), cita.getMedico().getNombre(), cita.getFecha(), cita.getHora(), cita.getMotivo()
        );
        enviarEmail(paciente.getEmail(), subject, content);
    }

    public void enviarNotificacionMedico(Cita cita) {
        Medico medico = cita.getMedico();
        String subject = "Nueva Cita";
        String content = String.format(
            "Hola Dr. %s,\n\nTiene una nueva cita con %s.\nFecha: %s a las %s\nMotivo: %s\nTeléfono paciente: %s\n",
            medico.getNombre(), cita.getPaciente().getNombre(), cita.getFecha(), cita.getHora(), cita.getMotivo(), cita.getPaciente().getTelefono()
        );
        enviarEmail(medico.getEmail(), subject, content);
    }

    private void enviarEmail(String emailTo, String subject, String content) {
    try {
        mSession = Session.getInstance(mProperties);
        MimeMessage mCorreo = new MimeMessage(mSession);
        mCorreo.setFrom(new InternetAddress(emailFrom));
        mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
        mCorreo.setSubject(subject);


        MimeMultipart multipart = new MimeMultipart("alternative");
        
        
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText(content, "utf-8", "plain");
        

        MimeBodyPart htmlPart = new MimeBodyPart();
        String htmlContent = "<html><body><p>" + content.replace("\n", "<br>") + "</p></body></html>";
        htmlPart.setContent(htmlContent, "text/html; charset=utf-8");
        
        multipart.addBodyPart(textPart);
        multipart.addBodyPart(htmlPart);
        mCorreo.setContent(multipart);
        
        mCorreo.saveChanges();
        
        Transport mTransport = mSession.getTransport("smtp");
        mTransport.connect(emailFrom, passwordFrom);
        mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
        mTransport.close();
        
        System.out.println("Correo enviado a: " + emailTo);
    } catch (MessagingException ex) {
        Logger.getLogger(NotificacionesCorreo.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
