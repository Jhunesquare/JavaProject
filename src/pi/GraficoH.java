package pi;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartUtilities;

public class GraficoH extends JFrame {

    ArrayList<Usuario> usuario = new ArrayList<>();
    JFreeChart chart;
    JButton jbSig, jbAnt, jbVolver;
    Humanidades hm;
    Usuario obj = new Usuario();
    EnviarCorreoElectronico ece;

    public GraficoH(Humanidades obj, ArrayList<Usuario> usuarios) {
        super("Ranking");
        hm = obj;
        this.usuario = usuarios;
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        Image img1 = new ImageIcon(getClass().getResource("imagenes/logo.png")).getImage();
        setIconImage(img1);
        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 490);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico() {

        Collections.sort(usuario);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(usuario.get(0).getPuntajeTotal(), "Primer puesto", usuario.get(0).getNombre() + " " + usuario.get(0).getApellido());
        dataset.setValue(usuario.get(1).getPuntajeTotal(), "Segundo puesto", usuario.get(1).getNombre() + " " + usuario.get(1).getApellido());
        dataset.setValue(usuario.get(2).getPuntajeTotal(), "Tercer puesto", usuario.get(2).getNombre() + " " + usuario.get(2).getApellido());

        chart = ChartFactory.createBarChart3D(
                "Ranking del cuestionario", //Nombre de la grafica
                "Nombres de los usuarios con mayor puntaje", //Nombre del eje Horizontal
                "", //Nombre del eje vertical
                dataset, //Data
                PlotOrientation.VERTICAL, //Orientacion HORIZONTAL o VERTICAL
                true, //Incluir leyenda
                true, //Informacion al pasar el mouse
                true);                      //URls

        chart.setBackgroundPaint(Color.GRAY);//Dar color al fondo del panel
        chart.getTitle().setPaint(Color.WHITE);//Dar color al titulo 

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);//Color del fondo del gr�fico

        plot.setDomainGridlinesVisible(true);//Lineas divisorias
        plot.setRangeGridlinePaint(Color.BLACK);//Color de lineas divisorias	    

        //Calculo de los valores en el eje x
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true);//Asignar color de linea a las barras

        //Dar color a las barras
        GradientPaint gp = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        renderer.setSeriesPaint(0, gp);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));

        jbSig = new JButton("Enviar al profesor");
        jbSig.setBounds(530, 525, 120, 30);
        jbSig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                evento_enviar();

            }
        });
        add(jbSig);

        jbAnt = new JButton("Guardar grafico");
        jbAnt.setBounds(145, 525, 120, 30);
        jbAnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_guardar();
            }
        });
        add(jbAnt);

        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(350, 525, 100, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbVolver();
            }
        });
        add(jbVolver);
    }

    public void evento_jbSig() {
        cap5 cp5 = new cap5(hm);
        setVisible(false);//ocultar el menu principal
    }

    public void evento_guardar() {
        //tambien tenemos la posibilidad de crear una imagen png o jpg del grafico, y guardarla en el pc

        try {
            //Crear grafico como una imagen  
            ChartUtilities.saveChartAsPNG(
                    //ChartUtilities.saveChartAsJPEG(
                    //damos la ubicacion donde se guardara la imagen, y su extension
                    new File("C:\\Users\\santi\\Desktop\\Uceva\\Semestre 2\\Programacion\\PI" + File.separator + "Ranking.png"), //la ruta y el nombre de la imagen a crear
                    chart, //la grafica
                    800,//ancho 
                    700);//alto

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creando grafico.");
        }
    }

    public void evento_jbVolver() {
        setVisible(false);//ocultar a ventana1
        dispose();//destruir ventana1
        hm.setVisible(true);//mostrar la ventana del menu principal
    }

    public void evento_enviar() {
        ece = new EnviarCorreoElectronico();
        ece.test1();
    }

}
