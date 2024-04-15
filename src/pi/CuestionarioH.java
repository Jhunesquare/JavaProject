/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CuestionarioH extends JFrame {

    JButton jbSig, jbAnt, jbTerminar;
    JLabel Test, preguntas;

    JRadioButton Respuesta1, Respuesta2, Repuesta3, Respuesta4, ocultar;
    Random claseRandom = new Random();
    int posicion = 0 + claseRandom.nextInt(30 - 0);
    int posicion2 = 0 + claseRandom.nextInt(30 - 0);
    int contador = 0;
    int calificacion;
    int ID = 0;
    int contadorDeUsuarios = 1;
    PreguntasH p = new PreguntasH();
    RespuestasH R = new RespuestasH();
    Object[] select = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    Humanidades hm;
    ArrayList<Usuario> usuario = new ArrayList<>();

    public CuestionarioH(Humanidades obj, ArrayList<Usuario> usuarios, int id) {
        super("Cuestionario");
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
        Test.setBounds(20, 10, 450, 30); 
        Test.setOpaque(false); 
        Test.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(Test);
        preguntas = new JLabel(p.getPregunta(posicion));
        preguntas.setBounds(20, 20, 700, 50);
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
        Respuesta1 = new JRadioButton(a[0]);
        Respuesta1.setBounds(10, 250, 780, 30);
        Respuesta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc1();
            }
        });
        add(Respuesta1);

        preguntas.setText(p.getPregunta(posicion));

        Respuesta2 = new JRadioButton(a[1]);
        Respuesta2.setBounds(10, 300, 780, 30);
        Respuesta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc2();
            }
        });
        add(Respuesta2);

        Repuesta3 = new JRadioButton(a[2]);
        Repuesta3.setBounds(10, 350, 780, 30);
        Repuesta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc3();
            }
        });
        add(Repuesta3);

        Respuesta4 = new JRadioButton(a[3]);
        Respuesta4.setBounds(10, 400, 780, 30);
        Respuesta4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_Opc4();
            }
        });
        add(Respuesta4);

        ocultar = new JRadioButton();
        add(ocultar);

        ButtonGroup bg = new ButtonGroup();
        bg.clearSelection();
        bg.add(Respuesta1);
        bg.add(Respuesta2);
        bg.add(Repuesta3);
        bg.add(Respuesta4);
        bg.add(ocultar);

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
                Respuesta1.setText(a[0]);
                Respuesta2.setText(a[1]);
                Repuesta3.setText(a[2]);
                Respuesta4.setText(a[3]);
                if (Respuesta1.isSelected()) {
                    Respuesta1.setSelected(true);
                }
                ocultar.setSelected(true);
            } else {
                if (posicion == posicion2) {

                    posicion = 0 + claseRandom.nextInt(30 - 0);

                    preguntas.setText(p.getPregunta(posicion));
                    String[] a = R.setRespuestas(posicion);
                    Respuesta1.setText(a[0]);
                    Respuesta2.setText(a[1]);
                    Repuesta3.setText(a[2]);
                    Respuesta4.setText(a[3]);
                    if (Respuesta1.isSelected()) {
                        Respuesta1.setSelected(true);
                    }
                    ocultar.setSelected(true);
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
            Respuesta1.setText(a[0]);
            Respuesta2.setText(a[1]);
            Repuesta3.setText(a[2]);
            Respuesta4.setText(a[3]);
            Respuesta1.requestFocus();

        }

    }

    public void evento_jbTerminar() {

        for (int i = 0; i <= 29; i++) {
            if (select[i].equals(R.getRespuesta(i))) {
                calificacion = calificacion + 1;
            }
        }

        JOptionPane.showMessageDialog(null, "Tu calificacion es " + calificacion);

        for (int i = 0; i < usuario.size(); i++) {
            if (usuario.get(i).getCodigo() == this.ID) {
                usuario.get(i).setPuntaje1(calificacion);
                break;
            }
        }

        if (contadorDeUsuarios < 2) {

            JOptionPane.showMessageDialog(null, "Tienes otra oportunidad!");
            contadorDeUsuarios++;
            new CuestionarioH2(hm, usuario, ID);
            setVisible(false);
        }
    }

    public int calificacion1() {
        return calificacion;
    }

    public void Evento_Opc1() {
        select[posicion] = Respuesta1.getLabel();
    }

    public void Evento_Opc2() {
        select[posicion] = Respuesta2.getLabel();
    }

    public void Evento_Opc3() {
        select[posicion] = Repuesta3.getLabel();
    }

    public void Evento_Opc4() {
        select[posicion] = Respuesta4.getLabel();
    }
}
