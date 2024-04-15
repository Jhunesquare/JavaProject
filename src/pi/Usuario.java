/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

import javax.swing.JOptionPane;
import java.util.Collections;
import java.io.Serializable;
/**
 *
 * @author santi
 */
public class Usuario implements Comparable<Usuario>{
    
    int codigo, puntaje1, puntaje2, PuntajeTotal, contadorUsuarios;
    String apellido, nombre, correo;
    
    
    public Usuario(){
        apellido = nombre =correo = "";
      codigo = puntaje1 = puntaje2 = PuntajeTotal = 0;
      contadorUsuarios = 1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPuntaje1() {
        return puntaje1;
    }

    public void setPuntaje1(int puntaje1) {
        this.puntaje1 = puntaje1;
    }

    public int getPuntaje2() {
        return puntaje2;
    }

    public void setPuntaje2(int puntaje2) {
        this.puntaje2 = puntaje2;
    }

    public int getPuntajeTotal() {
        return PuntajeTotal;
    }

    public void setPuntajeTotal(int PuntajeTotal) {
        this.PuntajeTotal = PuntajeTotal;
    }

    public int getContadorUsuarios() {
        return contadorUsuarios;
    }

    public void setContadorUsuarios(int contadorUsuarios) {
        this.contadorUsuarios = contadorUsuarios;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return " Usuario{" + "codigo=" + codigo + ", puntaje1=" + puntaje1 + ", puntaje2=" + puntaje2 + ", PuntajeTotal=" + PuntajeTotal + ", contadorUsuarios=" + contadorUsuarios + ", apellido=" + apellido + ", nombre=" + nombre + ", correo=" + correo + '}';
    }

    
    @Override
    public int compareTo(Usuario o) {
      if(o.getPuntajeTotal()<PuntajeTotal){
          return -1;   
      }else if(o.getPuntajeTotal()<PuntajeTotal){
          return 0;
      }else{
          return 1;
      }
    }

   

    

    
}