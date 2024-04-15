/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import pi.AyudaVectores;
import pi.PI;
import pi.PI;
import pi.Plano_Cartesiano;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;



public class AlgebraL extends JFrame{
    JButton jbVolver, jbTextoImg, jr_VSuma,jr_VEscalar,jr_Vectorial,jr_mixto, jr_Vdescomposicion, jbUnescalar, jblimpiar;
    JLabel jlTexto, jltexto2, jltexto3,jlfondo,jlAnguloA,jlAnguloB,jlEscalar,jlx,jly,jlz,jlmixto,jldescom,jlEscalarA,jlEscalarB; 
    JTextField jtAnguloA,jtAnguloB, jtEscalarA, jtEscalarB,jtx,jty,jtz;
    PI PI;
    Plano_Cartesiano suma = new Plano_Cartesiano();
    Double x,y,z,A,B,AnguloA,AnguloB;
    ArrayList<Plano_Cartesiano> puntos = new ArrayList<>();
    public AlgebraL(PI obj){
        super("Algebra lineal");
        PI = obj;
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(new Color(165, 176, 207));
        setLayout(null);
        setResizable(false); 
        crearGUI();
        
//        Plano_Cartesiano pn = new Plano_Cartesiano();
        add(suma);//muestra la clase plano cartesiano de interfaz graphics
        
        setVisible(true);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        ImageIcon img7 = new ImageIcon(
                getClass().getResource("imagenes/fondo2.jpg"));
        ImageIcon img8 = new ImageIcon(
                img7.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT));
        jlfondo = new JLabel(img8);
        jlfondo.setBounds(0, 0, 1100, 650);
        add(jlfondo);
    }

  
    
    
    public void crearGUI(){
        
        ImageIcon img1 = new ImageIcon(
                getClass().getResource("imagenes/Knob-Info-icon.png"));
        ImageIcon img2 = new ImageIcon(
                getClass().getResource("imagenes/information-icon.png"));
        jbTextoImg = new JButton(img1);
        jbTextoImg.setRolloverIcon(img2);
        jbTextoImg.setBounds(800,0, 40, 50);
        jbTextoImg.setToolTipText("Clic aqui para ir a ayuda");
        jbTextoImg.setContentAreaFilled(false);
        jbTextoImg.setBorderPainted(false);
        jbTextoImg.setFocusPainted(false);
        jbTextoImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbTextoImg();
            }
        });
        add(jbTextoImg);
        
        jlTexto = new JLabel("Calculadora de vectores  ");
        jlTexto.setBounds(0, 0, 1100, 50);
        jlTexto.setOpaque(true);
        jlTexto.setBackground(new Color(13,75,72));
        jlTexto.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 30));
        jlTexto.setForeground(Color.white);
        jlTexto.setHorizontalAlignment(SwingConstants.CENTER);        
        add(jlTexto);
        
        ImageIcon img0 = new ImageIcon(
                getClass().getResource("imagenes/hogar blanco.png"));//para imagen demasiado grande
        ImageIcon img01 = new ImageIcon(
                img0.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        jbVolver = new JButton(img01);
        jbVolver.setToolTipText("Clic aqui para volver al menú");
        jbVolver.setBounds(1000, 570, 50, 40);
        jbVolver.setBorderPainted(false);
        jbVolver.setContentAreaFilled(false);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
        
         ImageIcon imgOriginal = new ImageIcon(
                getClass().getResource("imagenes/matematicasn.png"));//para imagen demasiado grande
        ImageIcon imgScalada = new ImageIcon(
                imgOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jr_VSuma = new JButton("Suma de vectores", imgScalada);
        jr_VSuma.setBounds(550, 100, 185, 45);
        //jr_VSuma.setHorizontalTextPosition(SwingConstants.CENTER);
        //jr_VSuma.setVerticalTextPosition(SwingConstants.BOTTOM);
        //jr_VSuma.setContentAreaFilled(false);
        jr_VSuma.setBackground(new Color(244,244,244));
        jr_VSuma.setBorderPainted(false);
        jr_VSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               evento_jr_VSuma();
            }

            
        });
        add(jr_VSuma);
        
        ImageIcon imgOri = new ImageIcon(
                getClass().getResource("imagenes/matematicasn.png"));//para imagen demasiado grande
        ImageIcon imgScal = new ImageIcon(
                imgOri.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jr_VEscalar = new JButton("Producto escalar",imgScal);
        jr_VEscalar.setBounds(775, 100, 185, 45);
        //jr_VEscalar.setContentAreaFilled(false);
        jr_VEscalar.setBackground(new Color(244,244,244));
        jr_VEscalar.setBorderPainted(false);
        jr_VEscalar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               evento_jr_VEscalar();
            }
        });
        add(jr_VEscalar);
        
         ImageIcon imgO = new ImageIcon(
                getClass().getResource("imagenes/matematicasn.png"));//para imagen demasiado grande
        ImageIcon imgS = new ImageIcon(
                imgO.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jr_Vectorial = new JButton("Producto vectorial", imgS);
        jr_Vectorial.setBounds(550, 155, 185, 45);
        //jr_Vectorial.setContentAreaFilled(false);
        jr_Vectorial.setBackground(new Color(244,244,244));
        jr_Vectorial.setBorderPainted(false);
        jr_Vectorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jr_Vectorial();
                
            }
        });
        add(jr_Vectorial);
        
        jltexto2 = new JLabel("2. Seleccione la operacion que desea realizar:  ");
        jltexto2.setBounds(550, 60, 360, 35);
        jltexto2.setBackground(Color.WHITE);
        jltexto2.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 14));
        jltexto2.setOpaque(true);
        add(jltexto2);
        
        jltexto3 = new JLabel("1. Dibuje dos vectores que desea calcular operar: ");
        jltexto3.setBounds(50, 60, 360, 35); 
        jltexto3.setBackground(Color.WHITE);
        jltexto3.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 14));
        jltexto3.setOpaque(true);
        add(jltexto3);
        
        //un escalar
        jlEscalar= new JLabel("2.1. Ingrese un escalar para los vectores A y B: ");
        jlEscalar.setBounds(550, 210, 360, 35);
        jlEscalar.setBackground(Color.WHITE);
        jlEscalar.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 14));
        jlEscalar.setOpaque(true);
        jlEscalar.setHorizontalAlignment(SwingConstants.CENTER);  
        add(jlEscalar);
        
        jlEscalarA = new JLabel("Escalar A: ");
        jlEscalarA.setBounds(600, 250, 70, 20);
        jlEscalarA.setBackground(Color.WHITE);   
        jlEscalarA.setOpaque(true);
        add(jlEscalarA);
        
        jtEscalarA = new JTextField();
        jtEscalarA.setBounds(690, 250, 50, 20);
        jtEscalarA.setBackground(new Color(227,227,227));
        jtEscalarA.setDocument(new LimitadorCaracteres(jtEscalarA, 6, 3));
        add(jtEscalarA);
        
        jlEscalarB = new JLabel("Escalar B: ");
        jlEscalarB.setBounds(600, 285, 70, 20);
        jlEscalarB.setBackground(Color.WHITE);   
        jlEscalarB.setOpaque(true);
        add(jlEscalarB);
        
        jtEscalarB = new JTextField();
        jtEscalarB.setBounds(690, 285, 50, 20);
        jtEscalarB.setBackground(new Color(227,227,227));
        jtEscalarB.setDocument(new LimitadorCaracteres(jtEscalarB, 6, 3));
        add(jtEscalarB);
        
        ImageIcon img9 = new ImageIcon(
                getClass().getResource("imagenes/matematicasn.png"));//para imagen demasiado grande
        ImageIcon img10 = new ImageIcon(
                img9.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jbUnescalar= new JButton("Producto un escalar",img10);
        jbUnescalar.setBounds(775, 255, 195, 45);
        jbUnescalar.setBackground(new Color(244,244,244));
        jbUnescalar.setBorderPainted(false);
        jbUnescalar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               evento_jbUnescalar();
               
            }
            
        });
        add(jbUnescalar);
        
        //producto mixto
        jlmixto= new JLabel("2.2. Ingrese el vector faltante para calcular el producto mixto: ");
        jlmixto.setBounds(550, 315, 460, 35);
        jlmixto.setBackground(Color.WHITE); 
        jlmixto.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 14));
        jlmixto.setOpaque(true);
        jlmixto.setHorizontalAlignment(SwingConstants.CENTER);  
        add(jlmixto);
        
        jlx = new JLabel("X");
        jlx.setBounds(600, 355, 50, 30);
        jlx.setBackground(Color.WHITE);   
        jlx.setOpaque(true);
        add(jlx);
        
        jtx = new JTextField();
        jtx.setBounds(580, 390, 50, 20);
        jtx.setBackground(new Color(233,233,233));
        jtx.setDocument(new LimitadorCaracteres(jtx, 6, 3));
        add(jtx);
               
        jly = new JLabel("Y");
        jly.setBounds(660, 355, 50, 30);
        jly.setBackground(Color.WHITE);   
        jly.setOpaque(true);
        add(jly);
        
        jty = new JTextField();
        jty.setBounds(640, 390, 50, 20);
        jty.setBackground(new Color(233,233,233));
        jty.setDocument(new LimitadorCaracteres(jty, 6, 3));
        add(jty);
        
    
        jlz = new JLabel("Z");
        jlz.setBounds(720, 355, 50, 30);
        jlz.setBackground(Color.WHITE);   
        jlz.setOpaque(true);
        add(jlz);
        
        jtz = new JTextField();
        jtz.setBounds(700, 390, 50, 20);
        jtz.setBackground(new Color(233,233,233));
        jtz.setDocument(new LimitadorCaracteres(jtz, 6, 3));
        add(jtz);
        
        ImageIcon img3 = new ImageIcon(
                getClass().getResource("imagenes/matematicasn.png"));//para imagen demasiado grande
        ImageIcon img4 = new ImageIcon(
                img3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jr_mixto = new JButton("Producto mixto",img4);
        jr_mixto.setBounds(775, 365, 185, 45);
        //jr_mixto.setContentAreaFilled(false);
        jr_mixto.setBackground(new Color(244,244,244));
        jr_mixto.setBorderPainted(false);
        jr_mixto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jr_mixto();
                
            }
        });
        add(jr_mixto);
        
        
        //descomposicion de vectore 
        jldescom = new JLabel("2.3. Ingrese los angulos de los vectores A y B: ");
        jldescom.setBounds(550, 420, 460, 35);
        jldescom.setBackground(Color.WHITE);
        jldescom.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 14));
        jldescom.setOpaque(true);
        add(jldescom);
        
        jlAnguloA= new JLabel("Angulo del vector A: ");
        jlAnguloA.setBounds(550, 460, 140, 20);
        jlAnguloA.setBackground(Color.WHITE);
        jlAnguloA.setOpaque(true);
        add(jlAnguloA);
        
        jtAnguloA = new JTextField();
        jtAnguloA.setBounds(690, 462, 50, 20);
        jtAnguloA.setBackground(new Color(233,233,233));
        jtAnguloA.setDocument(new LimitadorCaracteres(jtAnguloA, 6, 3));
        add(jtAnguloA);
        
        jlAnguloB= new JLabel("Angulo del vector B: ");
        jlAnguloB.setBounds(550, 500, 140, 20);
        jlAnguloB.setBackground(Color.WHITE);
        jlAnguloB.setOpaque(true);
        add(jlAnguloB);
        
        jtAnguloB = new JTextField();
        jtAnguloB.setBounds(690, 502, 50, 20);
        jtAnguloB.setBackground(new Color(233,233,233));
        jtAnguloB.setDocument(new LimitadorCaracteres(jtAnguloB, 6, 3));
        add(jtAnguloB);
        
        ImageIcon img5 = new ImageIcon(
                getClass().getResource("imagenes/matematicasn.png"));//para imagen demasiado grande
        ImageIcon img6 = new ImageIcon(
                img5.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jr_Vdescomposicion = new JButton("Descomposición de vectores",img6);
        jr_Vdescomposicion.setBounds(776, 470, 250, 45);
        jr_Vdescomposicion.setBackground(new Color(244,244,244));
        jr_Vdescomposicion.setBorderPainted(false);
        jr_Vdescomposicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               evento_jr_Vdescomposicion();
             
            }
        });
        add(jr_Vdescomposicion);
        
        
        ImageIcon img11 = new ImageIcon(
                getClass().getResource("imagenes/clean.png"));//para imagen demasiado grande
        ImageIcon img12 = new ImageIcon(
                img11.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jblimpiar = new JButton("limpiar",img12);
        jblimpiar.setBounds(200, 540, 150, 50);
        jblimpiar.setBackground(new Color(244,244,244));
        jblimpiar.setBorderPainted(false);
        jblimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               evento_jblimpiar();
            }
        });
        add(jblimpiar);


    }
    
    public void evento_jr_VSuma(){
        suma.suma();
    }
    
    public void  evento_jr_VEscalar(){
        suma.producto_escalar();
    }
    
    public void evento_jr_Vectorial(){
        suma.producto_vecto();
    }
    
    public void evento_jr_mixto(){
        if(jtx.getText().equals("") || jty.getText().equals("") || jty.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Tiene campos sin rellenar.");
                }else{
                }
        x= Double.parseDouble(jtx.getText());
        y= Double.parseDouble(jty.getText());
        z= Double.parseDouble(jtz.getText());
                
        suma.Producto_mixto(x, y, z);
    }
    
    public void evento_jr_Vdescomposicion(){
        if(jtAnguloA.getText().equals("") || jtAnguloB.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Tiene campos sin rellenar.");
                }else{}
        AnguloA = Double.parseDouble(jtAnguloA.getText());
        AnguloB = Double.parseDouble(jtAnguloB.getText());
        
        suma.descomposicion(AnguloA, AnguloB);
    }
    
    public void evento_jbUnescalar(){
        if(jtEscalarA.getText().equals("") || jtEscalarB.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Tiene campos sin rellenar.");
                }else{
                    
                }
        A= Double.parseDouble(jtEscalarA.getText());
        B= Double.parseDouble(jtEscalarB.getText());
        
        suma.UnEscalar(A, B);
    }
    
    public void evento_jbTextoImg(){
        AyudaVectores ay = new AyudaVectores(this);   
    }
    
    public void evento_jblimpiar(){
        jtx.setText(" ");
        jty.setText(" ");
        jtz.setText(" ");
        jtEscalarA.setText(" ");
        jtEscalarB.setText(" ");
        jtAnguloB.setText(" ");
        jtAnguloA.setText(" ");
        repaint();
        suma.limpiar();
   
    }
    public void evento_jbVolver(){
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        PI.setVisible(true);//mostrar la ventana del menu principal
    }

   
    
  
}
