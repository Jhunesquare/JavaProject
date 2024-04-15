/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

/**
 *
 * @author ellol
 */
public class Proyectil {
    int angulo;
    float alcance, altura, velocidad, gravedad;
    
    public Proyectil(){
        angulo = 0;
        velocidad = alcance = altura = gravedad = (float) 0.0;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public float getAlcance() {
        return alcance;
    }

    public void setAlcance(float alcance) {
        this.alcance = alcance;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }

    
    
}
