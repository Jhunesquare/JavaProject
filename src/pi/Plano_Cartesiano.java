
package pi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Plano_Cartesiano extends JPanel implements  MouseListener{
    
    int a,b;
    double pointX, pointY, sumax, sumay,xescalar,yescalar,suma_escalar, vectorialx,vectorialy,vectorialz,potencia;
    double magnitud, mixtox,mixtoy,mixtoz,descomAx,descomBx, descomAy, descomBy, magnitudA, magnitudB,potenciaA,potenciaB,
            EscalarAx,EscalarAy,EscalarBx,EscalarBy;
    ArrayList<Plano_Cartesiano> puntos = new ArrayList<>();
    DecimalFormat format = new DecimalFormat("#.##");
    
   
    public Plano_Cartesiano(){
        super();
        pointX = pointY = sumax = sumay = 0.0;
        xescalar = yescalar = 1.0;
        magnitud=potencia=mixtox=mixtoy=mixtoz=EscalarAx=EscalarAy=EscalarBx=EscalarBy=1.0;
        descomAx=descomBx= descomAy= descomBy= magnitudA= magnitudB=potenciaA=potenciaB=1.0;
        setBounds(20, 115, 504, 400);
        setBackground(Color.WHITE);//el fondo o el relleno del area o ventana
        setBorder(new LineBorder(Color.BLACK));//permiteponerle borde al area que se dibujo
        addMouseListener((MouseListener) this);//se recibe evento sobre la clase actual
        setVisible(true);
    }
    
    public void paint(Graphics l){
        super.paint(l);
        a=0;
        b=-18;
        while(a<=40){
            l.setColor(Color.LIGHT_GRAY);
            l.drawLine(0, 2+b, 500, 2+b);
            l.drawLine(2+b, 0, 2+b, 399);
            a++;//numero de lineas horizontales y verticales
            b+=18;//separacion
            
        }
        
        l.setColor(Color.black);
        l.drawLine(253, 0, 253, 399);//linea vertical
        l.drawLine(0, 200, 504, 200);//linea horizontal
        
       

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics l = getGraphics();
        if(puntos.size() < 2){
            Plano_Cartesiano p1 = new Plano_Cartesiano();
            l.drawLine(e.getX(), e.getY(),253, 200);
            p1.setX(e);
            p1.setY(e);
            puntos.add(p1);
            if(puntos.size() == 2){
                for (int i = 0; i < 2; i++) {
                    Plano_Cartesiano obj = puntos.get(i);
                    sumax+=obj.getpointX();
                    sumay+=obj.getpointY();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya graficaste el maximo de vectores posibles");
        }
        //p1.guardarVectores(e);
    }
    
    
    public void suma(){            
          Graphics l = getGraphics();
          l.setColor(Color.red);
          l.drawLine((int)(sumax*18)+253, (int)(-sumay*18)+200,253, 200);
          JOptionPane.showMessageDialog(null,"La suma de vectores es: (" + 
                                       format.format(sumax) +  " , "+
                                       format.format(sumay)+")");
    }
    
    public void UnEscalar(Double A, Double B){
        Graphics l = getGraphics();
        Plano_Cartesiano obj = puntos.get(0);
        Plano_Cartesiano obj2= puntos.get(1);
        
        EscalarAx=A*(obj.getpointX());
        EscalarAy=A*(obj.getpointY());
        
        EscalarBx=B*(obj2.getpointX());
        EscalarBy=B*(obj2.getpointY());
        
        l.setColor(Color.blue);
        l.drawLine((int)(EscalarAx*18)+253, (int)(-EscalarAy*18)+200, 253, 200);
        
        l.setColor(Color.ORANGE);
        l.drawLine((int)(EscalarBx*18)+253, (int)(-EscalarBy*18)+200, 253, 200);
        
        JOptionPane.showMessageDialog(null,"El Producto de un escalar es: (" + 
                                       format.format(EscalarAx) +  " , "+
                                       format.format(EscalarAy)+")\n" +
                                       format.format(EscalarBx) +  " , "+
                                       format.format(EscalarBy)+")");
        
    }
    
    public void producto_escalar(){
    
        if(puntos.size() == 2){
            for (int i = 0; i < 2; i++) {
                Plano_Cartesiano obj = puntos.get(i);
                xescalar= xescalar * obj.getpointX();
                yescalar= yescalar * obj.getpointY();
            }
           
            suma_escalar= xescalar + yescalar;

            
            JOptionPane.showMessageDialog(null,"El producto Escalar A.B es: ("+format.format(suma_escalar)+")");
        }   
    }
    
    // son vectores de 2d asi que los valores de z es =0;
    public void producto_vecto(){
                Plano_Cartesiano obj = puntos.get(0);
                Plano_Cartesiano obj2= puntos.get(1);
                
                vectorialx=(obj.getpointY()*0)-(obj2.getpointY()*0);
                vectorialy=-((obj.getpointX()*0)-(obj2.getpointX()*0));
                vectorialz = (obj.getpointX()*obj2.getpointY()) - (obj2.getpointX()*obj.getpointY());
                
                potencia= Math.pow(vectorialx, 2) + Math.pow(vectorialy, 2) + Math.pow(vectorialz, 2);
                magnitud= Math.sqrt(potencia);
                
                
                
            JOptionPane.showMessageDialog(null,"El producto vectorial AxB es: ("+
                                         format.format(vectorialx)+"i, "+
                                         format.format(vectorialy) + "j, "
                                         +format.format(vectorialz)+"k)\n" +
                                         "La magnitud del vectpr AxB es: "+
                                         format.format(magnitud));
    }
    
    public void Producto_mixto(Double x, Double y, Double z){
     
        Plano_Cartesiano obj = puntos.get(0);
        Plano_Cartesiano obj2= puntos.get(1);
            
            mixtox=x*((obj.getpointY()*0)-(obj2.getpointY()*0));
            mixtoy=-y*((obj.getpointX()*0)-(obj2.getpointX()*0));
            mixtoz =z*((obj.getpointX()*obj2.getpointY()) - (obj2.getpointX()*obj.getpointY()));
            
            JOptionPane.showMessageDialog(null,"El producto mixto A.(BxC) es: ("+
                                         format.format(mixtox)+"i, "+
                                         format.format(mixtoy) + "j, "
                                         +format.format(mixtoz)+"k)\n");
    }
    
    public void descomposicion(Double AnguloA, Double AnguloB){
        Double radianA, radianB;
        radianA= Math.toRadians(AnguloA);
        radianB= Math.toRadians(AnguloB);
        
        Plano_Cartesiano obj = puntos.get(0);
        Plano_Cartesiano obj2= puntos.get(1);
        
        potenciaA= Math.pow(obj.getpointX(), 2) + Math.pow(obj.getpointY(), 2);
        magnitudA= Math.sqrt(potenciaA);
        
        potenciaB= Math.pow(obj2.getpointX(), 2) + Math.pow(obj2.getpointY(), 2);
        magnitudB= Math.sqrt(potenciaB);
        
        descomAx= (magnitudA)*(Math.cos(radianA));
        descomBx= (magnitudB)*(Math.cos(radianB));
        
        descomAy= (magnitudA)*(Math.sin(radianA));
        descomBy= (magnitudB)*(Math.sin(radianB));
        
        JOptionPane.showMessageDialog(null,"componentes del eje X: \n"+
                                         format.format(descomAx)+"\n"+
                                         format.format(descomBx) + "\n"
                                         +"Componentes del eje y: \n"+
                                         format.format(descomAy)+"\n"+
                                         format.format(descomBy));
        
    }

    public void setX(MouseEvent e){
        pointX = (double) (e.getX() - 253)/18;
    }
    
    public void setY(MouseEvent e){
        pointY = (double) (200 - e.getY())/18;
    }
    
    public double getpointX(){
        return pointX;
    }
    
    public double getpointY(){
        return pointY;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    void limpiar() {
        puntos.clear();
        pointX = pointY = sumax = sumay = 0.0;
        xescalar = yescalar = 1.0;
        magnitud=potencia=mixtox=mixtoy=mixtoz=EscalarAx=EscalarAy=EscalarBx=EscalarBy=1.0;
        descomAx=descomBx= descomAy= descomBy= magnitudA= magnitudB=potenciaA=potenciaB=1.0;
    }
    
    
    
   


  
    
     

   
    
}
