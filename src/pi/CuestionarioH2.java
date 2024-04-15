package pi;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import pi.Humanidades;
import pi.PreguntasH;
import pi.Registro;
import pi.RespuestasH;
import pi.Usuario;

public class CuestionarioH2 extends JFrame {

    JButton jbSig, jbAnt, jbTerminar, jbUsuario;
    JPanel p1;
    JLabel Test, preguntas;
    int calificacion2;
    Humanidades hm;
    Registro us;
    int user = 0;
    JRadioButton opc1, opc2, opc3, opc4, oculto;
    JTextArea jtArea;
    Random claseRandom = new Random();
    int posicion = 0 + claseRandom.nextInt(30 - 0);
    int posicion2 = 0 + claseRandom.nextInt(30 - 0);
    int posicion3 = 0;
    int contador = 0;
    PreguntasH p = new PreguntasH();
    RespuestasH R = new RespuestasH();
    Object[] select = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    CuestionarioH2 ch2;
    int contadorDeUsuarios = 1;
     ArrayList<Usuario> usuario = new ArrayList<>();
      Usuario obj = new Usuario();
      
       int ID;
         int PuntajeTotal = 0;
    public CuestionarioH2(Humanidades obj, ArrayList<Usuario> usuarios, int id) {
        super("Intento numero 2");
         hm = obj;
        this.usuario = usuarios;
        ID = id;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    public void crearGUI() {
        Test = new JLabel("Preguntas"); 
        Test.setBounds(20, 10, 250, 30); 
        Test.setOpaque(false);
        Test.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(Test);
        preguntas = new JLabel(p.getPregunta(posicion));
        preguntas.setBounds(20, 20, 800, 50);
        preguntas.setOpaque(false);
        preguntas.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(preguntas);

        jbSig = new JButton("Siguiente pregunta");
        jbSig.setBounds(550, 525, 150, 30);
        jbSig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                evento_jbSig();
            }
        });
        add(jbSig);

        jbAnt = new JButton("Pregunta anterior");
        jbAnt.setBounds(145, 525, 150, 30);
        jbAnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbAnt();
            }
        });
        add(jbAnt);

        jbTerminar = new JButton("Terminar examen");
        jbTerminar.setBounds(350, 525, 150, 30);
        jbTerminar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbTerminar();
            }
        });
        add(jbTerminar);

        preguntas.setText(p.getPregunta(posicion));
        String[] a = R.setRespuestas(posicion);
        opc1 = new JRadioButton(a[0]);
        opc1.setBounds(10, 250, 780, 30);
        opc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc1();
            }
        });
        add(opc1);

        preguntas.setText(p.getPregunta(posicion));

        opc2 = new JRadioButton(a[1]);
        opc2.setBounds(10, 300, 780, 30);
        opc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc2();
            }
        });
        add(opc2);

        opc3 = new JRadioButton(a[2]);
        opc3.setBounds(10, 350, 780, 30);
        opc3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc3();
            }
        });
        add(opc3);

        opc4 = new JRadioButton(a[3]);
        opc4.setBounds(10, 400, 780, 30);
        opc4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc4();
            }
        });
        add(opc4);

        oculto = new JRadioButton();
        add(oculto);

        ButtonGroup bg = new ButtonGroup();
        bg.clearSelection();
        bg.add(opc1);
        bg.add(opc2);
        bg.add(opc3);
        bg.add(opc4);
        bg.add(oculto);

    }

    public void evento_jbSig() {

        Random claseRandom = new Random();

        if (contador == 3) {
            jbSig.setEnabled(false);

        }

        if (contador < 5) {
            if (posicion != posicion2) {

                posicion = 0 + claseRandom.nextInt(30 - 0);

                preguntas.setText(p.getPregunta(posicion));
                String[] a = R.setRespuestas(posicion);
                opc1.setText(a[0]);
                opc2.setText(a[1]);
                opc3.setText(a[2]);
                opc4.setText(a[3]);
                if (opc1.isSelected()) {
                    opc1.setSelected(true);
                }
                oculto.setSelected(true);
            } else {
                if (posicion == posicion2) {

                    posicion = 0 + claseRandom.nextInt(30 - 0);

                    preguntas.setText(p.getPregunta(posicion));
                    String[] a = R.setRespuestas(posicion);
                    opc1.setText(a[0]);
                    opc2.setText(a[1]);
                    opc3.setText(a[2]);
                    opc4.setText(a[3]);
                    if (opc1.isSelected()) {
                        opc1.setSelected(true);
                    }
                    oculto.setSelected(true);
                }
            }
            contador++;
        
        }

    }

    public void evento_jbAnt() {

        if (contador == 0) {
            jbAnt.setEnabled(false);
        }

        if (contador > 0) {
            posicion--;    
            jbSig.setEnabled(true);
            preguntas.setText(p.getPregunta(posicion));
            String[] a = R.setRespuestas(posicion);
            opc1.setText(a[0]);
            opc2.setText(a[1]);
            opc3.setText(a[2]);
            opc4.setText(a[3]);
            opc1.requestFocus();

        }

    }

    public void evento_jbTerminar() {
        

        for (int i = 0; i <= 29; i++) {
            if (select[i].equals(R.getRespuesta(i))) {
                calificacion2 = calificacion2 + 1;
                 
            }
        }
        
        JOptionPane.showMessageDialog(null, "Tu segunda calificacion es " + calificacion2);
          
        
        for (int i = 0; i < usuario.size(); i++) {
            if(usuario.get(i).getCodigo()==this.ID){
                usuario.get(i).setPuntaje2(calificacion2);
                break;
            }
        }
        
        for (int i = 0; i < usuario.size(); i++) {
            if (usuario.get(i).getPuntaje1() > usuario.get(i).getPuntaje2()) {
                
                PuntajeTotal = usuario.get(i).getPuntaje1();
                usuario.get(i).setPuntajeTotal(PuntajeTotal);  
            } 
            
            if(usuario.get(i).getPuntaje2() > usuario.get(i).getPuntaje1()){
                     PuntajeTotal = usuario.get(i).getPuntaje2();
                usuario.get(i).setPuntajeTotal(PuntajeTotal);

                }
               
            
           if(usuario.get(i).getPuntaje1() == usuario.get(i).getPuntaje2()){
                    PuntajeTotal = usuario.get(i).getPuntaje1();
                usuario.get(i).setPuntajeTotal(PuntajeTotal);
               } 
        }
           
           
        JOptionPane.showMessageDialog(null, "Haz agotado tus intentos");
        setVisible(false);//ocultar a ventana1
        hm.setVisible(true);//mostrar la ventana del menu humanidades
        contadorDeUsuarios++;
        
    }

    public int calificacion2() {
        return calificacion2;
    }

    public void Evento_Opc1() {
        select[posicion] = opc1.getLabel();
    }

    public void Evento_Opc2() {
        select[posicion] = opc2.getLabel();
    }

    public void Evento_Opc3() {
        select[posicion] = opc3.getLabel();
    }

    public void Evento_Opc4() {
        select[posicion] = opc4.getLabel();
    }
}
