package pi;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
             


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HOME-WIN10
 */
public class cap1 extends JFrame{

   
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
   
    
    public cap1(Humanidades obj){
        super("Capitulo 1 - Introduccion");
        hm = obj;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        crearGUI();
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        setVisible(true);
    }
    
    private void crearGUI() {
        
        jbSig = new JButton("Capitulo siguiente");
        jbSig.setBounds(530, 525, 120, 30);
        jbSig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                evento_jbSig();
               
            }
        });
        add(jbSig);
        
        
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(350, 525, 100, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
        
        
        jbAnt = new JButton("Capitulo anterior");
        jbAnt.setBounds(145, 525, 120, 30);
        jbAnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbAnt();
            }
        });
        add(jbAnt);
       
        
        
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL url = getClass().getResource("imagenes/h1.2.jpg");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>Objetivo 7: Garantizar el acceso a una energía asequible, segura, sostenible y moderna</b></font></div><br>" +
                        "<div align='left'><font face='Times New Roman' size='4' color='black'><b>¿Cual es el objetivo de desarrollo sostenible 7: energía asequible y no contaminante?</b></font></div><br>" +  
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>El ODS 7 busca garantizar el acceso a una energía asequible, segura, sostenible y moderna para todos. Para ello, se hace necesario duplicar la tasa mundial de mejora de la eficiencia energética, así como aumentar sustancialmente el porcentaje de renovables en el mix energético.<br><br>" +
                    
                  "<div align='left'><font face='Times New Roman' size='4' color='black'><b>¿En qué consiste el Objetivo de Desarrollo Sostenible 7?</b></font></div><br>" +      
                "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>El acceso a la energía segura y continua condiciona enormemente las posibilidades de desarrollo humano, social y económico. La población mundial está creciendo y también crece con ella la demanda de energía, por lo que es fundamental hacerla llegar a toda la población para mejorar a escala global el acceso a sistemas de cocción, calefacción, iluminación de escuelas y hospitales, comunicación y acceso a internet, máquinas y herramientas de trabajo, cuestiones que repercuten directamente sobre el desarrollo. A su vez, es necesario que la energía sea sostenible para que permita un desarrollo sin comprometer la capacidad de las generaciones futuras. La energía sostenible es una oportunidad que transforma vidas, economías y el planeta.<br><br>" +
                              
                "<div align='center'><img src=" + url + " width=400 height=200></div><br><br><br><br>" + 
            
                "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>" 
                       
        + "<a href = 'https://www.pactomundial.org/ods/7-energia-asequible-y-no-contaminante/'>Fuente numero 1</a><br>"
        + "<a href = 'https://www.iberdrola.com/sostenibilidad/comprometidos-objetivos-desarrollo-sostenible/ods-7-energia-asequible-y-no-contaminante'>Fuente numero 2</a><br>"
        + "<a href = 'https://agenda2030lac.org/es/ods/7-energia-asequible-y-no-contaminante'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=imwsw6odo3A'>Video</a><br>");

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
        js.setBounds(5, 10, 780, 500);
        add(js);
        
        
    }

    
    
    public void evento_jbSig(){
      cap2 cp2 = new cap2(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap10 cp10 = new cap10(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
    
}
    
    