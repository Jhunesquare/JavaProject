
package pi;
import javax.swing.JFrame;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;


public class Derivacion extends JFrame

{

    //Variable que almacena las funciones a derivar

    public String funcion = "";
    // DJep es la clase encargada de la derivacion en su escencia
    DJep djep;
    Node nodoFuncion;
    Node nodoDerivada;

    public Derivacion() {
        //...
    }

    public void setFuncionADerivar(String funcion) {
        this.funcion = funcion;
    }

    public String getFuncionDerivada() {
        return this.funcion;
    }

    public void derivar() {

        try {

            this.djep = new DJep();
            // agrega funciones estandares cos(x), sin(x)
            this.djep.addStandardFunctions();

            // agrega constantes estandares, pi, e, etc
            this.djep.addStandardConstants();

            // por si existe algun numero complejo
            this.djep.addComplex();

            // permite variables no declarables
            this.djep.setAllowUndeclared(true);

            // permite asignaciones
            this.djep.setAllowAssignment(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.setImplicitMul(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.addStandardDiffRules();

            // coloca el nodo con una funcion preestablecida
            this.nodoFuncion = this.djep.parse(this.funcion);

            // deriva la funcion con respecto a x
            Node diff = this.djep.differentiate(nodoFuncion, "x");

            // Simplificamos la funcion con respecto a x
            this.nodoDerivada = this.djep.simplify(diff);

            // Convertimos el valor simplificado en un String
            this.funcion = this.djep.toString(this.nodoDerivada);

        } catch (ParseException e) {
            this.funcion = "NaN";
            System.out.println("Error: " + e.getErrorInfo());
        }

    }

    void derivar(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
