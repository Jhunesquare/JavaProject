/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Humanidades extends JFrame {

    JButton jbRanking, jbVolver, jbRegistro, jbCuestionario, jbcap1, jbcap2, jbcap3, jbcap4, jbcap5, jbcap6, jbcap7, jbcap8, jbcap9, jbcap10;
    PI PI;
    JLabel jlImagen;
    ArrayList<Usuario> Lista_Usuario = new ArrayList<>();
    ArrayList<Usuario> usuario = new ArrayList<>();

    public Humanidades(PI obj) {
        super("Humanidades");
        PI = obj;
        setSize(790, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false); 
        setLayout(null);
        crearGUI();
        setVisible(true);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
    }

    public void crearGUI() {

        VentanasCaps();

        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(550, 510, 200, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);

        ImageIcon imgOriginal = new ImageIcon(
                getClass().getResource("imagenes/labelH.png"));
        ImageIcon imgScalada = new ImageIcon(
                imgOriginal.getImage().getScaledInstance(700, 100, Image.SCALE_DEFAULT));
        jlImagen = new JLabel(imgScalada);
        jlImagen.setBounds(40, 20, 700, 100);
        add(jlImagen);

        jbCuestionario = new JButton("¡Pon a prueba tus conocimientos!");
        jbCuestionario.setBounds(250, 510, 250, 30);
        jbCuestionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbCuestionario();
            }
        });
        add(jbCuestionario);

        jbRegistro = new JButton("Registrate");
        jbRegistro.setBounds(30, 510, 150, 30);
        jbRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbRegistro();
            }
        });
        add(jbRegistro);

        jbRanking = new JButton("Ranking");
        jbRanking.setBounds(30, 460, 150, 30);
        jbRanking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    evento_jbRanking();
                } catch (IndexOutOfBoundsException a) {
                    JOptionPane.showMessageDialog(null, "Para poder visualizar el ranking debe de haber un minimo"
                            + "de 3 usuarios que hayan respondido el cuestionario");
                    
                } 


            }
        });
        add(jbRanking);

    }

    public void VentanasCaps() {

        jbcap1 = new JButton("Capitulo 1");
        jbcap1.setMnemonic('S');
        jbcap1.setBounds(30, 150, 120, 120);

        jbcap1.setContentAreaFilled(true);
        jbcap1.setBorderPainted(false);
        jbcap1.setFocusPainted(false);
        jbcap1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap1();
            }
        });
        add(jbcap1);

        jbcap2 = new JButton("Capitulo 2");
        jbcap2.setMnemonic('S');
        jbcap2.setBounds(180, 150, 120, 120);

        jbcap2.setContentAreaFilled(true);
        jbcap2.setBorderPainted(false);
        jbcap2.setFocusPainted(false);
        jbcap2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap2();
            }
        });
        add(jbcap2);
        ;
        jbcap3 = new JButton("Capitulo 3");
        jbcap3.setMnemonic('S');
        jbcap3.setBounds(330, 150, 120, 120);

        jbcap3.setContentAreaFilled(true);
        jbcap3.setBorderPainted(false);
        jbcap3.setFocusPainted(false);
        jbcap3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap3();
            }
        });
        add(jbcap3);

        jbcap4 = new JButton("Capitulo 4");
        jbcap4.setMnemonic('S');
        jbcap4.setBounds(480, 150, 120, 120);

        jbcap4.setContentAreaFilled(true);
        jbcap4.setBorderPainted(false);
        jbcap4.setFocusPainted(false);
        jbcap4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap4();
            }
        });
        add(jbcap4);

        jbcap5 = new JButton("Capitulo 5");
        jbcap5.setMnemonic('S');
        jbcap5.setBounds(630, 150, 120, 120);

        jbcap5.setContentAreaFilled(true);
        jbcap5.setBorderPainted(false);
        jbcap5.setFocusPainted(false);
        jbcap5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap5();
            }
        });
        add(jbcap5);

        jbcap6 = new JButton("Capitulo 6");
        jbcap6.setMnemonic('S');
        jbcap6.setBounds(30, 300, 120, 120);

        jbcap6.setContentAreaFilled(true);
        jbcap6.setBorderPainted(false);
        jbcap6.setFocusPainted(false);
        jbcap6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap6();
            }
        });
        add(jbcap6);

        jbcap7 = new JButton("Capitulo 7");
        jbcap7.setMnemonic('S');
        jbcap7.setBounds(180, 300, 120, 120);

        jbcap7.setContentAreaFilled(true);
        jbcap7.setBorderPainted(false);
        jbcap7.setFocusPainted(false);
        jbcap7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap7();
            }
        });
        add(jbcap7);

        jbcap8 = new JButton("Capitulo 8");
        jbcap8.setMnemonic('S');
        jbcap8.setBounds(330, 300, 120, 120);

        jbcap8.setContentAreaFilled(true);
        jbcap8.setBorderPainted(false);
        jbcap8.setFocusPainted(false);
        jbcap8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap8();
            }
        });
        add(jbcap8);

        jbcap9 = new JButton("Capitulo 9");
        jbcap9.setMnemonic('S');
        jbcap9.setBounds(480, 300, 120, 120);

        jbcap9.setContentAreaFilled(true);
        jbcap9.setBorderPainted(false);
        jbcap9.setFocusPainted(false);
        jbcap9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap9();
            }
        });
        add(jbcap9);

        jbcap10 = new JButton("Capitulo 10");
        jbcap10.setMnemonic('S');
        jbcap10.setBounds(630, 300, 120, 120);

        jbcap10.setContentAreaFilled(true);
        jbcap10.setBorderPainted(false);
        jbcap10.setFocusPainted(false);
        jbcap10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbcap10();
            }
        });
        add(jbcap10);

    }

    public void evento_jbcap1() {
        cap1 cp1 = new cap1(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap2() {
        cap2 cp2 = new cap2(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap3() {
        cap3 cp3 = new cap3(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap4() {
        cap4 cp4 = new cap4(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap5() {
        cap5 cp5 = new cap5(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap6() {
        cap6 cp6 = new cap6(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap7() {
        cap7 cp7 = new cap7(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap8() {
        cap8 cp8 = new cap8(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap9() {
        cap9 cp9 = new cap9(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbcap10() {
        cap10 cp10 = new cap10(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_jbVolver() {
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        PI.setVisible(true);//mostrar la ventana del menu principal
    }

    public void evento_jbRegistro() {

        Registro us = new Registro(this, this.Lista_Usuario);

        dispose();//destruir ventana1

    }

    public void evento_jbCuestionario() {

        InicioSesion is = new InicioSesion(this, this.Lista_Usuario);
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1

    }

    public void evento_jbRanking() {

        GraficoH gh = new GraficoH(this, Lista_Usuario);
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1

    }
}
