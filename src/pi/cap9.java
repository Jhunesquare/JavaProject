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
public class cap9 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap9(Humanidades obj){
       super("Capitulo 9");
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

        URL url = getClass().getResource("imagenes/h9.jpg");
        

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>Metas del objetivo 7</b></font></div><br>" +
                      
              "<div align='justified'><font face='Times New Roman' size='4' color='black'>Para garantizar acceso universal a electricidad asequible en 2030, es necesario invertir en fuentes de energía limpia, como la solar, eólica y termal. La adopción de estándares eficaces en función del costo en una variedad de tecnologías también podría reducir en 14% el consumo mundial de electricidad en los edificios. Esto equivale a la energía generada por unas 1.300 centrales medianas cuya construcción se podría evitar.<b><br><br>" +
                        "<font face='Times New Roman' size='5' color='black'><li>De aquí a 2030, garantizar el acceso universal a servicios energéticos asequibles, fiables y modernos</li><li>De aquí a 2030, aumentar considerablemente la proporción de energía renovable en el conjunto de fuentes energéticas</li><li>De aquí a 2030, duplicar la tasa mundial de mejora de la eficiencia energética</li><li>De aquí a 2030, aumentar la cooperación internacional para facilitar el acceso a la investigación y la tecnología relativas a la energía limpia, incluidas las fuentes renovables, la eficiencia energética y las tecnologías avanzadas y menos contaminantes de combustibles fósiles, y promover la inversión en infraestructura energética y tecnologías limpias</li><li>De aquí a 2030, ampliar la infraestructura y mejorar la tecnología para prestar servicios energéticos modernos y sostenibles para todos en los países en desarrollo, en particular los países menos adelantados, los pequeños Estados insulares en desarrollo y los países en desarrollo sin litoral, en consonancia con sus respectivos programas de apoyo</li>" +
           
                        "<div align='center'><font face='Times New Roman' size='5' color='black'><b>¿Cómo lo lograremos?</b></font></div><br>" +
                        
                       "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Sociedad: Ahorra electricidad y si puedes, instala paneles solares en tu casa.\n" +
"<br>Iniciativa privada: En las prácticas de producción y en el lugar de trabajo, transita hacia una economía baja en carbono.\n" +
"<br>Academia: Fortalece la investigación, colabora para crear soluciones innovadoras y apoya en la medición del impacto.\n" +
"<br>Gobiernos: Promueve y facilita un mayor y mejor uso de energía no contaminante<br><br>" +
                        
                        "<div align='center'><img src=" + url + " width=450 height=250></div><br><br>" + 
                
                              "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://www.sdgfund.org/es/objetivo-7-energ%C3%ADa-asequible-y-sostenible'>Fuente numero 1</a><br>"
        + "<a href = 'https://www.gob.mx/agenda2030/articulos/7-energia-asequible-y-no-contaminante'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.un.org/sustainabledevelopment/es/energy/'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=5Cc-RZsMWAA'>Video</a><br>");
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
      cap10 cp10 = new cap10(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap8 cp8 = new cap8(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
   
}
