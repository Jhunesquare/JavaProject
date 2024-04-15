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
public class cap8 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap8(Humanidades obj){
       super("Capitulo 8");
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

        URL url = getClass().getResource("imagenes/h8.png");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>Datos destacables</b></font></div><br>" +
                  "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Durante décadas, los combustibles fósiles como el carbón, el petróleo o el gas han sido las principales fuentes de producción de electricidad, pero su utilización produce grandes cantidades de gases de efecto invernadero que provocan el cambio climático y tienen efectos nocivos en la salud de las personas y el medio ambiente. Esto afecta a todas las personas, en todos los países.<br><br>" +    
               
                        "<font face='Times New Roman' size='5' color='black'><li>El 13% de la población mundial aún no tiene acceso a servicios modernos de electricidad.</li><li>3000 millones de personas dependen de la madera, el carbón, el carbón vegetal o los desechos de origen animal para cocinar y calentar la comida.</li><li>La energía es el factor que contribuye principalmente al cambio climático y representa alrededor del 60% de todas las emisiones mundiales de gases de efecto invernadero.</li><li>La contaminación del aire en locales cerrados debido al uso de combustibles para la energía doméstica causó 4,3 millones de muertes en 2012, 6 de cada 10 de estas fueron mujeres y niñas.</li><li>En 2015, el 17,5% del consumo final de energía fue de energías renovables.</li>" +
                     
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Sin embargo, el avance en todos los ámbitos de la energía sostenible no está a la altura de lo que se necesita para lograr su acceso universal y alcanzar las metas de este Objetivo. Se debe aumentar el uso de energía renovable en sectores como el de la calefacción y el transporte. Asimismo, son necesarias las inversiones públicas y privadas en energía; así como mayores niveles de financiación y políticas con compromisos más audaces, además de la buena disposición de los países para adoptar nuevas tecnologías en una escala mucho más amplia.<br><br>" +
                        "<div align='center'><img src=" + url + " width=250 height=200></div><br><br>" + 
                
                                 "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://onuhabitat.org.mx/index.php/ods-7-el-objetivo-del-mes'>Fuente numero 1</a><br>"
        + "<a href = 'https://www.mre.gov.py/ods/?us_portfolio=energia-asequible-y-no-contaminante#:~:text=3000%20millones%20de%20personas%20dependen,de%20gases%20de%20efecto%20invernadero.'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.un.org/sustainabledevelopment/es/energy/'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=Nbdbm63U0d0'>Video</a><br>");
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
      cap9 cp9 = new cap9(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap7 cp7 = new cap7(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
   
}
