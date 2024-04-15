/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author santi
 */
public class Fisica extends JFrame{
    PI PI;
    JComboBox<String> jcPlaneta;
    JRadioButton jrSelec1, jrSelec2;
    JLabel jlTexto1, jlFondo1;
    JSlider jsAngulo, jsAltura, jsRecipiente;
    JButton jbGuardar, jbDisparar, jbVolver;
    JTextField jtValor, jtVelocidad, jtAltura, jtRecipiente, jtInfo, jtDisMax, jtAce, jtTiemMax;
    Proyectil p1 = new Proyectil();
    int ancho = 50, largo = 50, cantTiros = 3;
    int x = 30*14, y = 690-largo;
    float alturaMax, distanciaMax, tMax, thMax, sen, cos, angulo;
    DecimalFormat formato2 = new DecimalFormat("#.##");
    
    public Fisica(PI obj){
        super("Tiro Parabólico");
        PI = obj;
        setSize(1500, 700);//ancho, largo
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        setLayout(null);
        setVisible(true);
        hud();
        numVelocidad(jtVelocidad);
        numValor(jtValor);
        numAltura(jtAltura);
        numRecip(jtRecipiente);
    }
    

    public void posicionY(int y){
        this.y = (int) (y*10.39-largo);
        repaint();
    }
    
    public void posicionX(int x){
        this.x = x*14-ancho;
        repaint();
    }
    
    private void hud(){
        setLayout(null);
        
        jlTexto1 = new JLabel("metros");
        jlTexto1.setBounds(1138, 2, 50, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("m/s^2");
        jlTexto1.setBounds(1138, 35, 50, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("segundos");
        jlTexto1.setBounds(1138, 65, 80, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Distancia total recorrida: ");
        jlTexto1.setBounds(950, 2, 180, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Aceleración total: ");
        jlTexto1.setBounds(991, 35, 180, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Tiempo total de caída: ");
        jlTexto1.setBounds(965, 65, 180, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Velocidad");
        jlTexto1.setBounds(5, 2, 120, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("m/s");
        jlTexto1.setBounds(47, 26, 35, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Altura(metros en y)");
        jlTexto1.setBounds(500, 72, 115, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Ángulo(grados)");
        jlTexto1.setBounds(500, 2, 90, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Gravedad");
        jlTexto1.setBounds(230, 2, 120, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Distancia del recipiente(metros en x)");
        jlTexto1.setBounds(230, 72, 250, 30);
        add(jlTexto1);
        jlTexto1 = new JLabel("Tipo de tiro:");
        jlTexto1.setBounds(800, 2, 120, 30);
        add(jlTexto1);
        
        jrSelec1 = new JRadioButton("Tiro parabolico");
        jrSelec1.setBackground(Color.lightGray);
        jrSelec1.setBounds(800, 35, 120, 25);
        jrSelec1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsAltura.setEnabled(false);
                jtRecipiente.setEnabled(true);
                jtVelocidad.setEnabled(true);
                jtValor.setEnabled(true);
                jsRecipiente.setEnabled(true);
                jsAngulo.setEnabled(true);
                jbDisparar.setEnabled(true);
                jcPlaneta.setEnabled(true);
            }
        });
        add(jrSelec1);
        jrSelec2 = new JRadioButton("Tiro semi parabolico");
        jrSelec2.setBackground(Color.lightGray);
        jrSelec2.setBounds(800, 65, 150, 25);
        jrSelec2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsAltura.setEnabled(true);
                jtAltura.setEnabled(true);
                jtRecipiente.setEnabled(true);
                jtVelocidad.setEnabled(true);
                jtValor.setEnabled(true);
                jsRecipiente.setEnabled(true);
                jsAngulo.setEnabled(true);
                jbDisparar.setEnabled(true);
                jcPlaneta.setEnabled(true);
            }
        });
        add(jrSelec2);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrSelec1);
        bg.add(jrSelec2);
        
        
        jsAltura = new JSlider(SwingConstants.HORIZONTAL, 0, 45, 0);
        jsAltura.setBounds(500, 95, 230, 50);
        jsAltura.setMajorTickSpacing(5);
        jsAltura.setPaintTicks(true);
        jsAltura.setPaintLabels(true);
        jsAltura.setBackground(Color.lightGray);
        jsAltura.setEnabled(false);
        jsAltura.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                evento_jsAltura();
                posicionY((int) (67-jsAltura.getValue()));
            }
        });
        
        jsAngulo = new JSlider(SwingConstants.HORIZONTAL, 0, 90, 0);
        jsAngulo.setBounds(500, 25, 230, 50);
        jsAngulo.setMajorTickSpacing(10);
        jsAngulo.setPaintTicks(true);
        jsAngulo.setPaintLabels(true);
        jsAngulo.setBackground(Color.lightGray);
        jsAngulo.setEnabled(false);
        jsAngulo.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                evento_jsAngulo();
            }
        });
        jsRecipiente =new JSlider(SwingConstants.HORIZONTAL, 0, 100, 30);
        jsRecipiente.setBounds(215, 95, 230, 50);
        jsRecipiente.setMajorTickSpacing(10);
        jsRecipiente.setPaintTicks(true);
        jsRecipiente.setPaintLabels(true);
        jsRecipiente.setBackground(Color.lightGray);
        jsRecipiente.setEnabled(false);
        jsRecipiente.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                evento_Recipiente();
                posicionX(jsRecipiente.getValue()+3);
            }
        });
        add(jsRecipiente);
        add(jsAngulo);
        add(jsAltura);
        
        jtDisMax = new JTextField();
        jtDisMax.setBounds(1100, 5, 37, 25);
        jtDisMax.setText("00,00");
        jtDisMax.setEditable(false);
        add(jtDisMax);
        jtAce = new JTextField();
        jtAce.setBounds(1100, 38, 37, 25);
        jtAce.setText("00,00");
        jtAce.setEditable(false);
        add(jtAce);
        jtTiemMax = new JTextField();
        jtTiemMax.setBounds(1100, 68, 37, 25);
        jtTiemMax.setText("00,00");
        jtTiemMax.setEditable(false);
        add(jtTiemMax);
        jtValor = new JTextField();
        jtValor.setBounds(730, 30, 25, 25);
        jtValor.setText(jsAngulo.getValue()+"");
        jtValor.setEditable(false);
        jtValor.setEnabled(false);
        add(jtValor);
        jtVelocidad = new JTextField();
        jtVelocidad.setBounds(5, 30, 40, 25);
        jtVelocidad.setText("0");
        jtVelocidad.setEnabled(false);
        add(jtVelocidad);
        jtAltura = new JTextField();
        jtAltura.setBounds(730, 95, 25, 25);
        jtAltura.setText(jsAltura.getValue() + "");
        jtAltura.setEditable(false);
        jtAltura.setEnabled(false);
        add(jtAltura);
        jtRecipiente = new JTextField();
        jtRecipiente.setBounds(450, 95, 25, 25);
        jtRecipiente.setText(jsRecipiente.getValue() + "");
        jtRecipiente.setEditable(false);
        jtRecipiente.setEnabled(false);
        add(jtRecipiente);
        
        jtInfo = new JTextField("Cantidad de tiros disponibles: " + cantTiros);
        jtInfo.setBackground(Color.lightGray);
        jtInfo.setEditable(false);
        jtInfo.setBounds(2, 65, 200, 30);
        add(jtInfo);
        jbDisparar = new JButton("Disparar");
        jbDisparar.setBounds(98, 115, 83, 30);
        jbDisparar.setEnabled(false);
        jbDisparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_Disparar();   
                jtInfo.setText("Cantidad de tiros disponibles: " + cantTiros);
                jtAce.setText(formato2.format(p1.getGravedad()) + "");
                jtTiemMax.setText(formato2.format(tMax) + "");
            }       
        });
        add(jbDisparar);
        
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(800, 98, 93, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_volver();
            }
        });
        add(jbVolver);
        
        jbGuardar = new JButton("Limpiar");
        jbGuardar.setBounds(5, 115, 83, 30);
        jbGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGuardar();
            }
        });
        String planetas[] = {"Júpiter", "Marte", "Mercurio", "Neptuno", "Saturno", "Tierra", "Urano"};
        jcPlaneta = new JComboBox(planetas);
        jcPlaneta.setBounds(229, 30, 72, 25);
        jcPlaneta.setEnabled(false);
        add(jcPlaneta);
        add(jbGuardar);
        jlFondo1 = new JLabel();
        jlFondo1.setBounds(0, 0, 1500, 153);
        jlFondo1.setOpaque(true);
        jlFondo1.setBackground(Color.lightGray);
        jlFondo1.setBorder(new LineBorder(Color.DARK_GRAY));
        add(jlFondo1);
        
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        ImageIcon balon = new ImageIcon(getClass().getResource("imagenes/balon.png"));
        ImageIcon cubeta = new ImageIcon(getClass().getResource("imagenes/cubeta.png"));
        ImageIcon fondo = new ImageIcon(getClass().getResource("imagenes/fondo.jpg"));
        
        g.drawImage(fondo.getImage(), 0, 184, 1500, 540, this);
        g.drawImage(balon.getImage(), 0, y, 50, 50, this);  
        g.drawImage(cubeta.getImage(), x, 643, 50, 50, this);
        
    }
    
    private void evento_volver() {
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        PI.setVisible(true);//mostrar la ventana del menu principal      
    }
    
    private void evento_jbGuardar() {
        jtVelocidad.setText("0");
        jsAltura.setValue(30);
        jsAltura.setValue(0);
        jsAngulo.setValue(0);
        jsRecipiente.setValue(0);
        jsRecipiente.setValue(30);
    }
    
    private void evento_Disparar() {
        
        if(cantTiros > 0){
            p1.setAlcance(Float.parseFloat(jtRecipiente.getText()));
            p1.setAltura(Float.parseFloat(jtAltura.getText()));
            p1.setAngulo(Integer.parseInt(jtValor.getText()));
            p1.setVelocidad(Float.parseFloat(jtVelocidad.getText()));
            int grav = jcPlaneta.getSelectedIndex();
            switch (grav) {
                case 0:
                    p1.setGravedad((float) 24.79);
                    break;
                case 1:
                    p1.setGravedad((float) 3.721);
                    break;
                case 2:
                    p1.setGravedad((float) 3.7);
                    break;
                case 3:
                    p1.setGravedad((float) 11.15);
                    break;
                case 4:
                    p1.setGravedad((float) 10.44);
                    break;
                case 5:
                    p1.setGravedad((float) 9.8);
                    break;
                case 6:
                    p1.setGravedad((float) 8.87);
                    break;
            }
            if(jrSelec1.isSelected()){
                calcular();
            }else{
                if(jrSelec2.isSelected()){
                    calcular2();
                }
            }
            
            cantTiros--;
        }else{
            JOptionPane.showMessageDialog(null, "Se acabaron tus oportunidades :c");
            jsAltura.setEnabled(false);
            jtAltura.setEditable(false);
            jtRecipiente.setEnabled(false);
            jtVelocidad.setEnabled(false);
            jtValor.setEnabled(false);
            jsRecipiente.setEnabled(false);
            jsAngulo.setEnabled(false);
            jbDisparar.setEnabled(false);
            jcPlaneta.setEnabled(false);
            jbGuardar.setEnabled(false);
            jrSelec1.setEnabled(false);
            jrSelec2.setEnabled(false);
        }
        
    }
    
    public void calcular2() {
        Graphics g = getGraphics();
        angulo = (float) (Math.toRadians(p1.getAngulo()));
        sen = (float) (Math.sin(angulo));
        cos = (float) (Math.cos(angulo));
        thMax = (float) (p1.getVelocidad()*sen)/p1.getGravedad();
        alturaMax = (float) (p1.getAltura() + (p1.getVelocidad() * sen * thMax) - 1/2 * (p1.getGravedad() * (Math.pow(thMax, 2))));
        tMax = 2*thMax;
        distanciaMax = (float) (p1.getVelocidad()*cos*tMax);
        float dis =  Math.round(distanciaMax);
        float alt =  Math.round(alturaMax);
        g.setColor(Color.BLUE);
        g.drawArc((int) (dis - p1.getAlcance()), y, (int) (dis*14.36), (int) (alt*11.311), 0, 120);
        g.setColor(Color.BLUE);
        if((distanciaMax) >= p1.getAlcance()-1 && (distanciaMax) <= p1.getAlcance()+1){
            JOptionPane.showMessageDialog(null, "¡Felicidades, ganaste! :D");
            jsAltura.setEnabled(false);
            jtAltura.setEnabled(false);
            jtRecipiente.setEnabled(false);
            jtVelocidad.setEnabled(false);
            jtValor.setEnabled(false);
            jsRecipiente.setEnabled(false);
            jsAngulo.setEnabled(false);
            jbDisparar.setEnabled(false);
            jcPlaneta.setEnabled(false);
            jbGuardar.setEnabled(false);
            jrSelec1.setEnabled(false);
            jrSelec2.setEnabled(false);

        }else{
            JOptionPane.showMessageDialog(null, "Fallaste, vuelve a intentarlo :c");
        }
        jtDisMax.setText(formato2.format(distanciaMax) + "");
    }
    
    public void calcular() {
        Graphics g = getGraphics();
        angulo = (float) (Math.toRadians(p1.getAngulo()));
        sen = (float) (Math.sin(angulo));
        cos = (float) (Math.cos(angulo));
        thMax = (float) (p1.getVelocidad()*sen)/p1.getGravedad();
        alturaMax = (float) ((p1.getVelocidad()*sen*thMax)-1/2*(p1.getGravedad()*(Math.pow(thMax, 2))));
        tMax = 2*thMax;
        distanciaMax = (float) (p1.getVelocidad()*cos*tMax);
        float dis =  Math.round(distanciaMax);
        float alt =  Math.round(alturaMax);
        g.setColor(Color.BLUE);
        g.drawArc(0, (int) (y-alt), (int) (dis*14.36), (int) (alt*11.311), 0, 180);
        if((distanciaMax-3) >= p1.getAlcance() && (distanciaMax-7) <= p1.getAlcance()){
            JOptionPane.showMessageDialog(null, "¡Felicidades, ganaste! :D");
            jsAltura.setEnabled(false);
            jtAltura.setEnabled(false);
            jtRecipiente.setEnabled(false);
            jtVelocidad.setEnabled(false);
            jtValor.setEnabled(false);
            jsRecipiente.setEnabled(false);
            jsAngulo.setEnabled(false);
            jbDisparar.setEnabled(false);
            jcPlaneta.setEnabled(false);
            jbGuardar.setEnabled(false);
            jrSelec1.setEnabled(false);
            jrSelec2.setEnabled(false);

        }else{
            JOptionPane.showMessageDialog(null, "Fallaste, vuelve a intentarlo :c");
        }
        jtDisMax.setText(formato2.format(distanciaMax) + "");
    }
    
    private void numVelocidad(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
                if (c == '.' && jtVelocidad.getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }
    
    private void numValor(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
                if (c == '.' && jtValor.getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }
    
    private void numAltura(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
                if (c == '.' && jtAltura.getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }
    
    
    private void numRecip(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
                if (c == '.' && jtRecipiente.getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }
    
    private void evento_jsAngulo() {
        int valor = jsAngulo.getValue();
        jtValor.setText(valor + "");
    }
    
    private void evento_jsAltura() {
        int valor = jsAltura.getValue();
        jtAltura.setText(valor + "");
    }
    
    private void evento_Recipiente() {
        int valor = jsRecipiente.getValue();
        jtRecipiente.setText(valor + "");
    }
}
