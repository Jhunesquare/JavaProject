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
public class cap4 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap4(Humanidades obj){
       super("Capitulo 4");
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

        URL url = getClass().getResource("imagenes/h4.jpg");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>¿Cuántas personas viven sin electricidad?</b></font></div><br>" +
                     
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>En el mundo, la cantidad de personas sin acceso a la electricidad disminuyó de 1200 millones en 2010 a 759 millones en 2019. Se aceleró especialmente la electrificación mediante soluciones descentralizadas basadas en energías renovables. La cantidad de personas conectadas a minirredes aumentó más del doble entre 2010 y 2019, y subió de 5 millones a 11 millones de personas. Sin embargo, habida cuenta de las políticas actuales y planificadas, y debido a los impactos de la crisis provocada por la COVID-19, se estima que 660 millones de personas, la mayoría de ellas en África al sur del Sahara, seguirán sin tener acceso a la electricidad en 2030.<br><br>" +
              "<div align='left'><font face='Times New Roman' size='5' color='black'><b>Consecuencias Del Problema De La Electricidad En El Mundo</b></font></div><br>" +
                     "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Es estremecedor pensar que casi dos millones de niños menores de cinco años de edad mueren cada año a causa de la contaminación del aire domestico debido a la quema de combustibles tradicionales en los hogares, y que mujeres y niños en muchos países pasan horas y horas cada día recogiendo leña para cocinar y calentar sus hogares. Además en muchas zonas, la búsqueda de leña como combustible ha causado una deforestación de enormes proporciones.<br><br>" +
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Más de 1.200 millones de personas —una de cada cinco personas de la población mundial— viven sin electricidad. La mayoría se concentra en una docena de países de África y Asia.<br>" +
                   "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Sin electricidad, las mujeres y las niñas tienen que dedicar horas a ir en busca de agua, las clínicas no pueden almacenar vacunas para los niños, muchos escolares no pueden hacer los deberes durante la noche y los empresarios no pueden dirigir empresas competitivas.<br>" +      
                "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Otros 2.800 millones de personas dependen de la leña, el carbón vegetal, el estiércol y la hulla para cocinar y calentarse, lo que provoca más de 4millones de muertes prematuras al año por contaminación del aire en locales cerrados.<br><br>" +
                        "<div align='center'><img src=" + url + " width=500 height=290></div>" + 
                                
                 "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://www.who.int/es/news/item/07-06-2021-global-launch-tracking-sdg7-the-energy-progress-report'>Fuente numero 1</a><br>"
        + "<a href = 'https://twenergy.com/energia/energia-electrica/un-cuarto-de-la-poblacion-mundial-vive-sin-electricidad-193/'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/7_Spanish_Why_it_Matters.pdf'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=q-DC8HFJ74I'>Video</a><br>");
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
      cap5 cp5 = new cap5(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap3 cp3 = new cap3(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
   
}
