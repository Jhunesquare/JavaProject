package pi;
import java.awt.Desktop;
import pi.PI;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


/**
 *
 * @author santi
 */
public class cap2 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap2(Humanidades obj){
       super("Capitulo 2");
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

        URL url = getClass().getResource("imagenes/h3.png");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>Energía asequible y no contaminante: ¿por qué es importante?</b></font></div><br>" +
                
                         "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Uno de los factores que contribuye principalmente al cambio climático y que representa el 60% de las emisiones mundiales de gases de efecto invernadero, es la energía fósil o convencional, por esta razón la implementación de energías renovables es vital en todo el mundo.<br><br>" + 
                        
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>La energía es fundamental para casi todos los grandes desafíos y oportunidades a los que hace frente el mundo actualmente. Ya sea para el empleo, la seguridad, el cambio climático, la producción de alimentos o para aumentar los ingresos. El acceso universal a la energía es esencial.<br><br>" + 
                        
                  "<div align='left'><font face='Times New Roman' size='4' color='black'><b>¿Por que?</b></font></div>"+  
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Nuestra vida cotidiana depende de servicios energéticos fiables y asequibles para funcionar sin trabas y de forma equitativa. Un sistema energético bien establecido apoya todos los sectores: desde las empresas, la medicina y la educación a la agricultura, las infraestructuras, las comunicaciones y la alta tecnología.<br>Y a la inversa, la falta de acceso al suministro de energía y a sistemas de transformación es un obstáculo para el desarrollo humano y económico.<br>" +          
                "<div align='center'><img src=" + url + " width=350 height=300></div><br>" + 
                        
                 "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://globalsolare.com/blog/energia-asequible-no-contaminante/'>Fuente numero 1</a><br>"
        + "<a href = 'https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/7_Spanish_Why_it_Matters.pdf'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.mre.gov.py/ods/?us_portfolio=energia-asequible-y-no-contaminante'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=3LLAvYbsT7Q&t=16s'>Video</a><br>");
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
      cap3 cp3 = new cap3(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap1 cp1 = new cap1(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
  
}
