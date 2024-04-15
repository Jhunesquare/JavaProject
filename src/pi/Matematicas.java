/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author santi
 */
public class Matematicas extends JFrame{
    
    JButton jbVolver,jbCalcular, jbTextoImg;
     JTextField jtFuncion;
    PI PI;
    
    Derivacion derivada;
    JLabel jlTexto, jlImagen;
    
    
    
    
    public Matematicas(PI obj){
        super("Matematicas");
        PI = obj;
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(new Color(153, 217,234));
        setLayout(null);
        crearGUI();
        setVisible(true);
        setResizable(false); 
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
    }
    
    
    public void crearGUI(){
        
        
        
        jlTexto = new JLabel("Calculadora de derivadas  ");
        jlTexto.setBounds(0, 0, 500, 70);
        jlTexto.setOpaque(true);
        jlTexto.setBackground(new Color(13,75,72));
        jlTexto.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 30));
        jlTexto.setForeground(Color.white);
        jlTexto.setHorizontalAlignment(SwingConstants.CENTER);        
        add(jlTexto); 
        
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(250, 300, 200, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
        
        
        JLabel jlReal = new JLabel("Ingrese la funcion a derivar:");
        jlReal.setBounds(70, 140, 250, 35);
        jlReal.setForeground(Color.black);
        add(jlReal);
        jtFuncion = new JTextField();
   
        jtFuncion.setBounds(240, 140, 150, 35);
        
        add(jtFuncion);
        
        
        jbCalcular = new JButton("Calcular");
        jbCalcular.setBounds((500-150)/2, 200, 150, 30);
       
        jbCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                evento_jbCalcular();
                
            }
        });
        add(jbCalcular);
        
       
        
        
        ImageIcon img9 = new ImageIcon(
                getClass().getResource("imagenes/acercadeicon.png"));//para imagen demasiado grande
        ImageIcon img10 = new ImageIcon(
                img9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        jbTextoImg = new JButton("Informacion", img10);
        jbTextoImg.setBounds(40,300, 130, 30);
        
        jbTextoImg.setBorderPainted(false);
        jbTextoImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbTextoImg();
            }
        });
          add(jbTextoImg);
        
       
        
        ImageIcon imgOriginal = new ImageIcon(
                getClass().getResource("imagenes/fondomate.jpg"));
        ImageIcon imgScalada = new ImageIcon(
                imgOriginal.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
        jlImagen = new JLabel(imgScalada);
        jlImagen.setBounds(-10, 65, 500, 400);
        add(jlImagen);
    }
    public void evento_jbTextoImg(){
        
       comoderivar cm = new comoderivar(this);
        setVisible(false);//ocultar el menu principal
    }
    
    
    public void evento_jbCalcular(){
       
        
        String real = jtFuncion.getText();
        
        derivada = new Derivacion();
            derivada.setFuncionADerivar(real);
            derivada.derivar();
            
        
        
        JOptionPane.showMessageDialog(null,"La derivada de " + real + " es " + derivada.getFuncionDerivada());
    }
    
    
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        PI.setVisible(true);//mostrar la ventana del menu principal
    }
}
