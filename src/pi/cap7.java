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
public class cap7 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap7(Humanidades obj){
       super("Capitulo 7");
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

        URL url = getClass().getResource("imagenes/h7.jpg");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>El papel de las empresas</b></font></div><br>" +
                  
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>La contribución de las compañías a los ODS puede abordarse\n" +
"desde tres enfoques, no excluyentes y con diferente retorno.\n" +
"Por un lado se encuentra el desarrollo de acciones filantrópicas,\n" +
"no relacionadas con las actividades de la empresa, mediante las\n" +
"que se busca aportar a la mejora de las condiciones sociales y\n" +
"ambientales de los entornos en los que opera o no la compañía, y\n" +
"que tienen principalmente un beneficio reputacional. Las medidas que pueden tomar las empresas para contribuir al objetivo 7 son:<br><br>" +
                          
                        "<font face='Times New Roman' size='5' color='black'><li>Creando una política energética que establezca las directrices de la empresa en relación al uso de la energía.</li><li>Formando a empleados y proveedores en materia de eficiencia energética.</li><li>Invirtiendo en energías renovables en detrimento de los combustibles fósiles en los edificios e instalaciones de la empresa.</li>"+
                
                        
                        "<font face='Times New Roman' size='5' color='black'><li>Consumo de energía en la organización.</li><li>Importe total invertido en energías renovables.</li><li>Intensidad energética de los edificios.</li><li>Porcentaje de energía de origen renovable consumida.</li><li>Actividades de investigación y desarrollo y gasto destinado a proporcionar energía fiable y a promocionar el desarrollo sostenible.</li>"+
                
                 
                        "<div align='center'><img src=" + url + " width=500 height=300></div><br>" + 
               
                         "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://www.emin.energy/como-pueden-las-empresas-contribuir-a-los-objetivos-de-desarrollo-sostenible/'>Fuente numero 1</a><br>"
        + "<a href = 'https://www.pactomundial.org/ods/7-energia-asequible-y-no-contaminante/'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.andi.com.co/Uploads/C%C3%B3mo%20pueden%20contribuir%20las%20empresas%20a%20los%20ODS.pdf'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=7TelBTgN4Y4'>Video</a><br>");
        
        
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
      cap8 cp8 = new cap8(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap6 cp6 = new cap6(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
   
}
