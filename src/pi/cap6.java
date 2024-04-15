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
public class cap6 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap6(Humanidades obj){
       super("Capitulo 6");
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

        URL url = getClass().getResource("imagenes/h6.jpg");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>¿Qué podemos hacer para solucionar estos problemas?</b></font></div><br>" +
                    "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Si miramos atrás al 70º aniversario de las Naciones Unidas que ha tenido lugar recientemente y a la adopción colosal de los 17 Objetivos de Desarrollo Sostenible (ODS), es necesario hacer una pausa y reconocer el logro histórico que ha supuesto la inclusión del ODS 7 sobre la energía en la nueva agenda. Esta incorporación de la energía sostenible dentro del marco de los ODS no es sino una demostración de la influencia de las Naciones Unidas y sus Estados Miembros en la transformación de las perspectivas mundiales sobre cuestiones vitales y en el establecimiento de nuevas normas y valores universales mientras se resuelven los muchos retos mundiales que nos encontramos en los debates políticos, económicos y ambientales hoy en día.<br>" +
                    
                "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Los países pueden acelerar la transición a un sistema energético asequible, fiable y sostenible invirtiendo en recursos energéticos renovables, dando prioridad a las prácticas de alto rendimiento energético y adoptando tecnologías e infraestructuras de energía no contaminante.<br>" +
                 
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Hacer frente a esta situación se ha convertido en un objetivo primordial a escala internacional, por lo que la ONU ha establecido la necesidad de garantizar el acceso a una energía asequible, segura, sostenible y moderna para todos como el ODS 7 de sus 17 Objetivos de Desarrollo Sostenible, aprobados en septiembre de 2015 como parte de la Agenda 2030.<br><br>" +
                        "<div align='center'><img src=" + url + " width=500 height=290></div>" + 
                "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://www.un.org/es/chronicle/article/el-objetivo-de-desarrollo-sostenible-7-y-el-desarrollo-energetico-sostenible-en-america-latina-y-el'>Fuente numero 1</a><br>"
        + "<a href = 'https://www.iberdrola.com/sostenibilidad/comprometidos-objetivos-desarrollo-sostenible/ods-7-energia-asequible-y-no-contaminante#:~:text=Debemos%20aumentar%20la%20financiaci%C3%B3n%20para,energ%C3%ADa%20geot%C3%A9rmica%20o%20la%20solar.'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/7_Spanish_Why_it_Matters.pdf'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=dTPtDBoN86E'>Video</a><br>");
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
      cap7 cp7 = new cap7(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap5 cp5 = new cap5(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
   
}
