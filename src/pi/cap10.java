package pi;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


/**
 *
 * @author santi
 */
public class cap10 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap10(Humanidades obj){
       super("Capitulo 10");
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
        
        
        jbAnt = new JButton("Capitulo anterior");
        jbAnt.setBounds(145, 525, 120, 30);
        jbAnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbAnt();
            }
        });
        add(jbAnt);
        
        
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(350, 525, 100, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
       
        
        
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL url = getClass().getResource("imagenes/h10.jpg");
        

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>Colombia y su potencial en fuentes de energía renovables</b></font></div><br>" +
                      
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Colombia se ha destacado por liderar la implementación de agendas como la de los ODS, las alianzas por el cambio climático y la adopción de estándares mundiales como los desarrollados por la Organización para la Cooperación y el Desarrollo Económico (OCDE). A través de los ODS, el país tiene el reto de avanzar sobre metas concretas y consolidar avances en materia de pobreza, educación y protección del medio ambiente, entre las principales.<br><br>" +
                       
                        
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>La ubicación geográfica y las condiciones climáticas convierten a Colombia en un país con potencial para el desarrollo de fuentes no convencionales de energías renovables. Según los representantes de empresas nacionales y multinacionales con presencia en Colombia, el país tiene las condiciones ideales para la producción de energía eólica y solar.<br><br>" +
                        
                        "<div align='left'><font face='Times New Roman' size='5' color='black'><b>Fuentes de energias renovables en Colombia</b></font></div><br>" +
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>La Asociación Colombiana de Energías Renovables SER Colombia, que agrupa a 54 empresas relacionadas con la generación de energía eléctrica a partir de fuentes renovables no convencionales, ha trabajado desde el 2016 para reunir conocimiento único que favorezca la complementariedad y estabilidad del sistema de generación energética colombiano.<br><br>" +
                      "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>A diferencia de las fuentes energéticas tradicionales, las fuentes no convencionales son una alternativa de inversión para las empresas interesadas en la diversificación de la matriz energética. Colombia, por sus características, ofrece la posibilidad de desarrollar proyectos en torno a energía solar, eólica, biomasa, geotérmica, mareomotriz y pequeñas centrales hidroeléctricas.<br><br>" +
                       
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Capacidad instalada energía eléctrica: Para garantizar el acceso universal a servicios energéticos, el Gobierno nacional propende aumentar la capacidad instalada de generación de energía eléctrica de 16.420 MW a 19.159 MW en 2022.<br><br>" +
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Energía eléctrica: Para 2022, se espera aumentar la cobertura del servicio de energía eléctrica beneficiando a 100 mil nuevos usuarios.<br><br>" +
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Fuentes no convencionales de energía: Aumentar capacidad de generación con energías limpias en 1.500 MW, frente a los 22,4 MW en 2018.<br><br>" +
                        
                        
                        "<div align='center'><img src=" + url + " width=650 height=300></div><br><br>" + 
                
                              "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://www.minambiente.gov.co/planeacion-y-seguimiento/objetivos-de-desarrollo-sostenible-ods/'>Fuente numero 1</a><br>"
        + "<a href = 'https://investincolombia.com.co/es/articulos-y-herramientas/articulos/colombia-y-su-potencial-en-fuentes-de-energia-renovables'>Fuente numero 2</a><br>"
        + "<a href = 'https://ods.dnp.gov.co/es/objetivos/energia-asequible-y-no-contaminante'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=D9V8wt1QZ2A'>Video</a><br>");
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
      cap1 cp1 = new cap1(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap9 cp9 = new cap9(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
    
}