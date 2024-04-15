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
public class cap5 extends JFrame{
    
    JButton jbSig, jbAnt,jbVolver;;
     JEditorPane editor;
    Humanidades hm;
    
   
    
    public cap5(Humanidades obj){
       super("Capitulo 5");
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

        URL url = getClass().getResource("imagenes/h5.jpg");

        editor.setText(
                "<div align='center'><font face='Times New Roman' size='5' color='black'><b>¿Cuánto costaría pasar a una energía más sostenible?</b></font></div><br>" +
                  "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>La generación de energía se divide en dos categorías: las que utilizan fuentes fósiles y las que aprovechan el sol, viento, agua y calor de la tierra. Las tecnologías del sector renovable han evolucionado con celeridad; lo que propicia una disminución en costos y cumple con metas internacionales referentes a la reducción de huella de carbono.<br><br>" +    
                "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>El mundo debe triplicar su inversión anual en infraestructuras de energía sostenible y pasar de los 400.000 millones de dólares actuales a 1,25 billones de dólares en 2030.<br>" +
                   "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Las regiones con mayor déficit energético, a saber, África Subsahariana y Asia Meridional, necesitan nuestra ayuda para mejorar el acceso a la energía. Ello incluye hacer mayores esfuerzos para encontrar alternativas limpias, eficientes y asequibles a las cocinas que son perjudiciales para la salud.<br>" +      
            "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Otros 2.800 millones de personas dependen de la leña, el carbón vegetal, el estiércol y la hulla para cocinar y calentarse, lo que provoca más de 4millones de muertes prematuras al año por contaminación del aire en locales cerrados.<br><br>" +
                        "<div align='justified'><font face='Times New Roman' size='4' color='black'><b>Los costes iniciales de tener energías renovables parecen más caros que los de la energía tradicional, pero a la larga sus beneficios son mucho mayores; es más, desde el primer día ya estás respetando el medio ambiente y ahorrando dinero. Y es que las energías renovables son más económicas que las tradicionales siempre y cuando sean instaladas por profesionales del sector que te garanticen tu seguridad y una instalación adecuada.<br><br>" +
                        
                    
                        "<div align='center'><img src=" + url + " width=500 height=290></div>" + 
               "<div align='left'><font face='Times New Roman' size='3.5' color='black'><b>Fuentes utilizadas en este capitulo:</b></font></div>"          
        + "<a href = 'https://energiahoy.com/2020/10/16/cuanto-cuesta-mantenerse-al-margen-de-la-energia-renovable/'>Fuente numero 1</a><br>"
        + "<a href = 'https://www.baenasolar.es/son-las-energias-renovables-caras-o-baratas/'>Fuente numero 2</a><br>"
        + "<a href = 'https://www.un.org/sustainabledevelopment/es/wp-content/uploads/sites/3/2016/10/7_Spanish_Why_it_Matters.pdf'>Fuente numero 3</a><br>"
        + "<a href = 'https://www.youtube.com/watch?v=knx29k0O_so'>Video</a><br>");
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
      cap6 cp6 = new cap6(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbAnt(){
        cap4 cp4 = new cap4(hm);
    setVisible(false);//ocultar el menu principal
    }
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }
   
}
