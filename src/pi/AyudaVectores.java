
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
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;



/**
 *
 * @author Nikoll Duarte Rivera
 */
public class AyudaVectores extends JFrame{
    JButton jbVolver;
    JEditorPane editor;
    AlgebraL alge;
    public AyudaVectores(AlgebraL obj){
        super("Concepto de vectores");
        alge = obj;
        setSize(600, 450); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
        setLayout(null);         
        setResizable(true); 
        crearGUI();
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        setVisible(true);
    }
    
    private void crearGUI() {     
        
        
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
        
        URL url = getClass().getResource("imagenes/operaciones.png");
        URL img1 = getClass().getResource("imagenes/suma2.jpg");
        URL img2 = getClass().getResource("imagenes/escalar.jpg");
        URL img3 = getClass().getResource("imagenes/punto.png");
        URL img4 = getClass().getResource("imagenes/vectorial2.jpg");
        
        editor.setText(
                "<div align='center'><font face='Arial' size='5' color='black'><b>¿Qué son vectores?</b></font></div><br>" +
                
                "<font face='Arial' size='5' color='black'>Un vector es un segmento de recta en el espacio que parte de un punto hacia otro, es decir, que tiene dirección, sentido y magnitud. El término vector proviene del latín vector, vectores, cuyo significado es ‘el que conduce’, o ‘el que transporta’.<br><br>" + 
                "<strong><font face='Arial' size='5' color='black'>Suma de vectores</strong><br><br>"+ 
                "<font face='Arial' size='5' color='black'>Para sumar dos o más vectores, tendremos que sumar las coordenadas de forma que coincida el eje para cada coordenada de los vectores. La primera coordenada corresponde al eje X y la segunda coordenada corresponde al eje Y. Entonces tendremos que operar las coordenadas que coincidan en eje.<br><br> "+ 
                "<div align='center'><img src=" + img1 + " width=350 height=300></div><br>"+
                "<strong><font face='Arial' size='5' color='black'>Multiplicación por un escalar</strong><br><br>"+
                "<font face='Arial' size='5' color='black'>La multiplicación de un vector por un número (escalar) se completa haciendo el producto de dicho número por las coordenadas del vector. El nuevo vector será la multiplicación del vector por el escalar o también puede definirse como un vector nuevo.<br><br>"+
                "<div align='center'><img src=" + img2 + " width=350 height=300></div><br>"+
                "<strong><font face='Arial' size='5' color='black'>Producto escalar</strong><br><br>"+
                "<font face='Arial' size='5' color='black'>También conocido como producto interno o producto punto, es una operación algebraica que toma dos vectores y retorna un escalar, y que satisface ciertas condiciones.\n" +
                "<font face='Arial' size='5' color='black'>De entre todos los productos que se pueden definir en distintos espacios vectoriales, el más relevante es el denominadoproducto escalar (usual o estándar)​ en el espacio euclídeo.<br><br>"+
                "<div align='center'><img src=" + img3 + " width=350 height=300></div><br>"+
                "<strong><font face='Arial' size='5' color='black'>Producto mixto</strong><br><br>"+
                "<font face='Arial' size='5' color='black'>El Producto mixto (otambién conocido como triple producto escalar) es una operación entre tre vectores que combinael producto escalar con el producto vectorial para obtener de resultado un escalar.\n"+
                "<font face='Arial' size='5' color='black'>Los triples productos aparecen cuando se desean definir multiplicaciones entre tres vectores.<br><br>"+        
                "<div align='center'><img src=" + img4 + " width=350 height=300></div><br>"+
                "<strong><font face='Arial' size='5' color='black'>Vectores</strong><br><br>" +       
                "<div align='center'><img src=" + url + " width=350 height=300></div><br>"+
                
               "🎬 <a href = 'https://www.youtube.com/watch?v=IrTeyyzerjI&list=PLeySRPnY35dEaZT3iJUNdDkgLEZE5x-Jd&ab_channel=Matem%C3%A1ticasprofeAlex'>Lista de reproducción - vectores - Matematicas profe alex</a><br><br>");
        
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
        alge.setVisible(true);//mostrar la ventana del menu principal
    }
}
