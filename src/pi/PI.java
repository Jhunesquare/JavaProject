/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pi;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author santi
 */
public class PI extends JFrame {

    JPanel panel;
    JButton Fisica, Matematicas, ALgebraL, Humanidades, Acercade;
    JLabel fondo;

    public PI() {
        super("Menu principal");
        setSize(700, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        iniciarComponentes();
        setVisible(true);
        
    }

    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 650);
        add(panel);
        crearGUI();
    }

    private void crearGUI() {

       

        ImageIcon img7 = new ImageIcon(
                getClass().getResource("imagenes/mateicon.png"));//para imagen demasiado grande
        ImageIcon img8 = new ImageIcon(
                img7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        Fisica = new JButton("Fisica", img8);
        Fisica.setBounds(420, 380, 200, 70);
        Fisica.setBackground(new Color(244, 244, 244));
        Fisica.setBorderPainted(false);
        Fisica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_JbFisica();
            }
        });
        panel.add(Fisica);

        ImageIcon img1 = new ImageIcon(
                getClass().getResource("imagenes/mateicon.png"));//para imagen demasiado grande
        ImageIcon img2 = new ImageIcon(
                img1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        Matematicas = new JButton("Matematicas", img2);
        Matematicas.setBounds(420, 110, 200, 70);
        Matematicas.setBackground(new Color(244, 244, 244));
        Matematicas.setBorderPainted(false);
        Matematicas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_JbMate();
            }
        });
        panel.add(Matematicas);

        ImageIcon img3 = new ImageIcon(
                getClass().getResource("imagenes/humaicon.png"));//para imagen demasiado grande
        ImageIcon img4 = new ImageIcon(
                img3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        Humanidades = new JButton("Humanidades", img4);
        Humanidades.setBounds(420, 290, 200, 70);
        Humanidades.setBackground(new Color(244, 244, 244));
        Humanidades.setBorderPainted(false);
        Humanidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_JbHumanidades();
            }
        });
        panel.add(Humanidades);

        ImageIcon img5 = new ImageIcon(
                getClass().getResource("imagenes/algeicon.png"));//para imagen demasiado grande
        ImageIcon img6 = new ImageIcon(
                img5.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ALgebraL = new JButton("Algebra Lineal", img6);
        ALgebraL.setBounds(420, 200, 200, 70);
        ALgebraL.setBackground(new Color(244, 244, 244));
        ALgebraL.setBorderPainted(false);
        ALgebraL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_JbAlgebraL();
            }
        });
        panel.add(ALgebraL);

        ImageIcon img9 = new ImageIcon(
                getClass().getResource("imagenes/acercadeicon.png"));//para imagen demasiado grande
        ImageIcon img10 = new ImageIcon(
                img9.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        Acercade = new JButton("Acerca de", img10);
        Acercade.setBounds(150, 480, 200, 70);
        Acercade.setBackground(new Color(244, 244, 244));
        Acercade.setBorderPainted(false);
        Acercade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_JbAcercade();
            }
        });
        panel.add(Acercade);

        ImageIcon imgOriginal = new ImageIcon(
                getClass().getResource("imagenes/VideoFondo.gif"));
        ImageIcon imgScalada = new ImageIcon(
                imgOriginal.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT));
        fondo = new JLabel(imgScalada);
        fondo.setBounds(0, -30, 700, 650);
        panel.add(fondo);
    }

    public void evento_JbMate() {
        Matematicas Mt = new Matematicas(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_JbFisica() {
        Fisica Fs = new Fisica(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_JbAlgebraL() {
        AlgebraL Al = new AlgebraL(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_JbHumanidades() {

        Humanidades Hm = new Humanidades(this);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_JbAcercade() {
        Acercade Hm = new Acercade(this);

    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(this,
                "Desea realmente salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        new PI();
    }
}
