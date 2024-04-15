/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HOME-USER
 */
public class EnviarCorreoElectronico{
    Humanidades hm;
    GraficoH gh;
    public void enviar(String parametros[]){
        try{
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress( parametros[1],      // correoRemitente
                                            parametros[0]));    // remitente
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(parametros[3])); // correoDestinatario
            
            mm.setSubject(parametros[4]); // asunto
            
            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[5],  // texto del mensage
                                    "text/html");   // tipo de codificacion del mensage
            
            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();            
            mp.addBodyPart(mime_mensage);//adicionar el texto  
                        
            mm.setContent(mp);// adicionar la informacion del objeto Multipart al mensaje
                                    
            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(  parametros[1],     // correoRemitente
                        parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();
            
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }     
    }
    
     public void enviar(String parametros[], String correosDestinatarios[]){
        try{
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress( parametros[1],      // correoRemitente
                                            parametros[0]));    // remitente
            
            InternetAddress toList[] = new InternetAddress[correosDestinatarios.length];
            for (int i = 0; i < correosDestinatarios.length; i++) { // recorrer el arreglo correosDestinatarios
                toList[i] = new InternetAddress(correosDestinatarios[i]);
            }
            mm.addRecipients(Message.RecipientType.TO, toList); // adicionar la lista de correosDestinatarios
            
            mm.setSubject(parametros[3]); // asunto
            
            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[4],  // texto del mensage
                                    "text/html");   // tipo de codificacion del mensage
            
            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();            
            mp.addBodyPart(mime_mensage);//adicionar el texto  
            
            mm.setContent(mp);// adicionar la informacion del objeto Multipart al mensaje
            
                        
            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(  parametros[1],     // correoRemitente
                        parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();
            
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }     
    }
     
     public void enviar(String parametros[], String correosDestinatarios[], String archivos[]){
        try{
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress( parametros[1],      // correoRemitente
                                            parametros[0]));    // remitente
            
            InternetAddress toList[] = new InternetAddress[correosDestinatarios.length];
            for (int i = 0; i < correosDestinatarios.length; i++) { // recorrer el arreglo correosDestinatarios
                toList[i] = new InternetAddress(correosDestinatarios[i]);
            }
            mm.addRecipients(Message.RecipientType.TO, toList); // adicionar la lista de correosDestinatarios
            
            mm.setSubject(parametros[3]); // asunto
            
            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[4],  // texto del mensage
                                    "text/html");   // tipo de codificacion del mensage
            
            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();            
            mp.addBodyPart(mime_mensage);//adicionar el texto  
                        
            for (String nf : archivos) {
                MimeBodyPart attach = new MimeBodyPart();
                attach.attachFile(nf);
                mp.addBodyPart(attach);//adicionar el archivo 
            }
            
            mm.setContent(mp);// adicionar la informacion del objeto Multipart al mensaje
                        
            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(  parametros[1],     // correoRemitente
                        parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();
            
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }     
    }
 
     public void test1(){ // enviar correo a varios destinatarios con archivos adjuntos
         String parametros[] =  { "Santiago Hernández Rosales",    // remitente
                                "shdez726@gmail.com", // correoRemitente
                                "lzjpemzkrmiqpndm",               // contrasena de aplicaciones de Gmail
                                "Puntajes humanidades",  // asunto
                                "Buen dia, anexo los puntajes obtenidos despues de realizar el cuestionario." // mensaje
                                }; 
         
         String correosDestinatarios[] = { "santiago.hernandez05@uceva.edu.co"};
         
         String archivos[] = {  "Ranking.png"};
         
         enviar(parametros, correosDestinatarios, archivos);
     }
     
       
     
       
}
