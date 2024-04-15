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
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author santi
 */
public class Acercade extends JDialog{
    PI pi;
     JButton jbCerrar;
      JEditorPane editor;
    public Acercade(PI obj){
        super(obj ,"Acerca de", true);
        pi = obj;
        setSize(405, 600);
        setLocationRelativeTo(obj);
        setLayout(null);
        crearGUI();
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    private void crearGUI() {
        
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL mh = getClass().getResource("imagenes/Nikoll.jpg");
         URL sh = getClass().getResource("imagenes/Santiago.jpg");
          URL st = getClass().getResource("imagenes/Victor.jpg");
           
        editor.setText(
                
                "<div align='center'><img src=" + mh + " width=200 height=200></div>"
                +  "<div align='center'><font face='Times New Roman' size='4' color='black'><b>Nikoll Ximena Duarte Rivera</b></font></div>"+
                  "<div align='center'><font face='Times New Roman' size='4' color='black'><b>Coidigo estudiantil: 230221043</b></font></div><br>" +
       
                        "<div align='center'><img src=" + sh + " width=200 height=200></div>"
                +  "<div align='center'><font face='Times New Roman' size='4' color='black'><b>Santiago Hernández Rosales</b></font></div>"+
                  "<div align='center'><font face='Times New Roman' size='4' color='black'><b>Coidigo estudiantil: 230221049</b></font></div><br>" +
                        
                        "<div align='center'><img src=" + st + " width=200 height=200></div>"
                +  "<div align='center'><font face='Times New Roman' size='4' color='black'><b>Victor Hugo Soto Restrepo</b></font></div>"+
                  "<div align='center'><font face='Times New Roman' size='4' color='black'><b>Coidigo estudiantil: 230221040</b></font></div><br>" 
                        
                  
                        );
        

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
        js.setBounds(5, 10, 383, 480);
        add(js);
        
        
    

        
       
        jbCerrar = new JButton("Cerrar");
        jbCerrar.setBounds(96, 515, 200, 30);
        jbCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCerrar();
            }

        });
        add(jbCerrar);
    }
    
    
    private void evento_jbCerrar() {
        
        setVisible(false);
        dispose();
    }
}