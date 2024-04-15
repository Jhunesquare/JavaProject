/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author santi
 */
public class comoderivar extends JFrame{
    JEditorPane editor;
    JButton jbVolver;
    Matematicas mate;
 
    comoderivar(Matematicas obj) {
        super("Concepto derivada");
        mate = obj;
        setSize(600, 450); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);         
        setResizable(false); 
        crearGUI();
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public void crearGUI() {  
        jbVolver = new JButton("Volver a la calculadora");
        jbVolver.setBounds(390, 380, 170, 20);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
      
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL url = getClass().getResource("imagenes/Tabladerivadas.jpg");

        editor.setText(
                "<div align='center'><font face='Arial' size='5' color='black'><b>¿Que son las derivadas?</b></font></div><br>" +

                "<font face='Arial' size='5' color='black'>La derivada es uno de los conceptos más importantes en matemáticas. La derivada es el resultado de un límite y representa la pendiente de la recta tangente a la gráfica de la función en un punto.<br><br>" +
                        "<strong>Reglas de las derivas</strong><br><br>" +       
                "<div align='center'><img src=" + url + " width=500 height=700></div><br>");

        editor.setEditable(false);//mostrar solo codigo HTML

        editor.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(e.getURL().toURI());
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
        );
        
        JScrollPane js = new JScrollPane(editor);
        js.setBounds(20, 20, 550, 350);
        add(js);
           
    }
     public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        mate.setVisible(true);//mostrar la ventana del menu principal
    }
}
