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

/**
 *
 * @author santi
 */
public class Registro extends JFrame {

    JButton jbGuardar, jbVolver;
    Humanidades hm;
    JTextField jtEntero, jtNombre, jtApellido, jtCorreo;       
    ArrayList<Usuario>usuario = new ArrayList<>();
    public Registro(Humanidades obj,ArrayList<Usuario>usuarios ) {
        super("Usuario");
        hm = obj;
        this.usuario = usuarios;
        setSize(400, 300);
        setLocationRelativeTo(null);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        JLabel jl = new JLabel("    Gestión de usuarios");
        jl.setBackground(Color.black);
        jl.setBounds(0, 0, 400, 50);
        jl.setOpaque(true);
        jl.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 30));
        jl.setForeground(Color.white);
        add(jl);

        JLabel jlEntero = new JLabel("Codigo:");
        jlEntero.setBounds(30, 70, 120, 25);
        add(jlEntero);

        jtEntero = new JTextField();
        jtEntero.setDocument(new LimitadorCaracteres(jtEntero, 20, 0));
        jtEntero.setBounds(150, 70, 150, 25);
        add(jtEntero);

        JLabel jlApellido = new JLabel("Apellido:");
        jlApellido.setBounds(30, 105, 120, 25);
        add(jlApellido);

        jtApellido = new JTextField();
        jtApellido.setDocument(new LimitadorCaracteres(jtApellido, 20, 1));
        jtApellido.setBounds(150, 105, 150, 25);
        add(jtApellido);

        JLabel jlNombre = new JLabel("Nombre:");
        jlNombre.setBounds(30, 140, 120, 25);
        add(jlNombre);

        jtNombre = new JTextField();
        jtNombre.setDocument(new LimitadorCaracteres(jtNombre, 20, 1));
        jtNombre.setBounds(150, 140, 150, 25);
        add(jtNombre);

        JLabel jlEstado = new JLabel("Correo:");
        jlEstado.setBounds(30, 175, 120, 25);
        add(jlEstado);
        jtCorreo = new JTextField();

        jtCorreo.setBounds(150, 175, 150, 25);
        add(jtCorreo);

        jbGuardar = new JButton("Guardar");
        jbGuardar.setBounds(30, 220, 100, 25);
        jbGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGuardar();
                
          
            }
        });
        add(jbGuardar);
        
 
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(140, 220, 100, 25);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
             
            }
        });
        add(jbVolver);

    }

    public void evento_jbVolver() {
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }

    public void evento_jbGuardar() {
 
        String id = jtEntero.getText();
        String nom = jtNombre.getText();
        String ape = jtApellido.getText();
        String correo = jtCorreo.getText();
        int ID = Integer.parseInt(id);
        int p1, p2;
        p1 = p2 = 0;
    
         boolean existe = false;
         
        for (int i = 0; i < usuario.size(); i++) {

            if (usuario.get(i).getCodigo() == ID) {
                existe = true;
                break;
            }
        }
        if (existe) {
            JOptionPane.showMessageDialog(null, "Este numero de id ya se encuentra registrado");
     
        setVisible(false);//ocultar a ventana1
        } else {
             Usuario obj = new Usuario();
       obj.setCodigo(ID);
       obj.setNombre(nom);
       obj.setApellido(ape);
       obj.setCorreo(correo);
       obj.setPuntaje1(p1);
       obj.setPuntaje2(p2);
       usuario.add(obj);
       
        }

        
       
      
      
        setVisible(false);//ocultar a ventana1
        //dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu humanidades
    }
   

    
    

}
