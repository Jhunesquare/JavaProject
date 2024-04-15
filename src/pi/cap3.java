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
public class cap3 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap3(Humanidades obj){
       super("Capitulo 3");
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

        URL url = getClass().getResource("imagenes/h33.jpg");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>Yo tengo acceso a electricidad</b></font></div><br>" +
                  "<div align='left'><font face='Times New Roman' size='4' color='black'><b>¿Por qué debería importarme este objetivo?</b></font></div>" +
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>En el ODS 7 se reconoce que la ampliación del acceso a la electricidad y otras formas de energía es fundamental para mejorar la vida de las personas y las comunidades. En ese marco, se propicia el uso eficiente de la energía y se promueven las fuentes renovables de energía.<br><br>" +
                "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Durante muchos decenios, los combustibles fósiles como el carbón, el petróleo o el gas han sido las principales fuentes de producción de electricidad, pero la quema de combustibles con alto contenido en carbono produce grandes cantidades de gases de efecto invernadero, que contribuyen al cambio climático y tienen efectos perjudiciales para el bienestar de la población y el medio ambiente. Esto afecta a todos, y no solo a unos pocos. Además, el consumo de electricidad a nivel mundial está aumentando rápidamente. En pocas palabras, sin un suministro estable de electricidad, los países no podrán impulsar sus economías.<br><br>" +
                 "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Todos podemos ahorrar electricidad enchufando los aparatos, incluido el ordenador, en una regleta, y apagándolos completamente cuando no se usan.\n" +
"\n" +
"También podemos ir en bicicleta, caminar o utilizar el transporte público para reducir las emisiones de carbono.<br><br>" +
                                 
                "<div align='center'><img src=" + url + " width=500 height=290></div>" + 
                         
                 "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://www.gndiario.com/ods-acceso-energia-desarrollo-sostenible'>Fuente numero 1</a><br>"
        + "<a href = 'https://datatopics.worldbank.org/sdgatlas/es/goal-7-affordable-and-clean-energy/'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/7_Spanish_Why_it_Matters.pdf'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=f5f98eoTFm0'>Video</a><br>");
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
      cap4 cp4 = new cap4(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap2 cp2 = new cap2(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
    
    
    

    

   
    
    

    
    
}
