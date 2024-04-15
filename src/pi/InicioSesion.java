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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author santi
 */
public class InicioSesion extends JFrame {

    JButton jbGuardar, jbVolver, jbInfo;
    Humanidades hm;
    int user = 1;
    CuestionarioH ch;
    JTextField jtEntero;
    CuestionarioH CU;
    Registro rg;
    ArrayList<Usuario> usuario = new ArrayList<>();

    public InicioSesion(Humanidades obj, ArrayList<Usuario> usuarios) {
        super("Inicio de sesion");
        hm = obj;
        this.usuario = usuarios;
        setSize(400, 300);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        JLabel jl = new JLabel(" Inicia sesion");
        jl.setBackground(Color.black);
        jl.setBounds(0, 0, 400, 50);
        jl.setOpaque(true);
        //jl.setBackground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        jl.setForeground(Color.white);
        add(jl);

        JLabel jlEntero = new JLabel("Codigo:");
        jlEntero.setBounds(80, 110, 120, 25);
        add(jlEntero);

        jtEntero = new JTextField();
        jtEntero.setDocument(new LimitadorCaracteres(jtEntero, 20, 0));
        jtEntero.setBounds(150, 110, 150, 25);
        add(jtEntero);

        jbGuardar = new JButton("Acceder");
        jbGuardar.setBounds(60, 220, 100, 25);
        jbGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGuardar();

            }
        });
        add(jbGuardar);

        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(230, 220, 100, 25);
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

        //CuestionarioH ch = new CuestionarioH(hm);
        String id = jtEntero.getText();
        int ID = Integer.parseInt(id);
        int cont = 1;

        boolean existe = false;

        for (int i = 0; i < usuario.size(); i++) {

            if (usuario.get(i).getCodigo() == ID) {
                existe = true;

                cont = usuario.get(i).contadorUsuarios + cont;
                usuario.get(i).setContadorUsuarios(cont);
                break;
            }
        }

        if (existe && cont == 2) {
            CuestionarioH ch = new CuestionarioH(hm, usuario, ID);
            JOptionPane.showMessageDialog(null, "Bienvenido, responde 5 preguntas para ganar!");
  
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "No te encuentras registrado o has excedido el limite de intentos");
        }

        //dispose();//destruir ventana1
        //setVisible(true);//mostrar la ventana del menu humanidades
    }

}
