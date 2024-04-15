/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi;

/**
 *
 * @author santi
 */
import java.util.StringTokenizer;
import javax.swing.JFrame;


public class RespuestasH extends JFrame{
       String[] respuestas = {
      "Busca garantizar el acceso a una energía asequible segura sostenible y moderna para todos",
           "Es importante porque apoya todos los sectores desde las empresas la medicina la educación a la agricultura",
           "Los combustibles fósiles como el carbón el petróleo o el gas",
           "759 millones de personas en 2019",
           "Desenchufando los aparatos electrónicos cuando no se usan",
           "1.25 billones de dólares en 2030",
           "África Subsahariana y Asia Meridional",
           "Adoptar tecnologías e infraestructuras de energía no contaminante", 
           "Invirtiendo en energías renovables en edificios e instalaciones de la empresa", 
           "Por su ubicación geográfica y las condiciones climáticas",
           "Energía solar eólica biomasa geotérmica mareomotriz y pequeñas centrales hidroeléctricas",
           "Energía fósil o convencional",
           "El cambio climático",
           "Porque reconoce que la ampliación del acceso a la electricidad y otras formas de energía mejora la calidad de vida",
           "Transforma vidas - economías y el planeta",
           "Energía asequible y no contaminante",
           "Los países no podrán impulsar sus economías",
           "2.800 millones de personas",
           "Fuentes fósiles y las que aprovechan el sol viento agua y calor de la tierra",
           "Aumentar considerablemente la proporción de energía renovable en el conjunto de fuentes energéticas",
           "Garantizar el acceso universal a servicios energéticos asequibles fiables y modernos",
           "13%",
           "17.5%",
           "En la calefacción y el transporte",
           "No son contaminantes",
           "No todos los territorios son aptos para energía renovable",
           "Duplicar la tasa mundial de mejora de la eficiencia energética",
           "Consumo de energía e intensidad energética de la organización-porcentaje de energía de origen renovable consumida",
           "Si ya que contribuye al medio ambiente y a la larga los beneficios son mucho mayores",
           "Fue aprobado en septiembre de 2015 como parte de la agenda 2030"
    };
    
    String[] radiobutton = {
        "Busca garantizar el acceso a una energía asequible segura sostenible y moderna para todos,Buscar garantizar el acceso a internet en todo el mundo,Asegurar el acceso de agua potable en toda latino américa,Generar empleo",
        "Es importante porque apoya todos los sectores desde las empresas la medicina la educación a la agricultura,Es importante porque genera dinero,Es importante porque evita a largo plazo la hambruna mundial,Por que impulsa la economía colombiana",
        "Los combustibles fósiles como el carbón el petróleo o el gas,El agua,La fricción que generan todos los vehículos al pasar por la carreteras inteligentes,Hidrogeno helio y litio",
        "759 millones de personas en 2019, 352 millones de personas en 2019, 5.000 millones de personas en 2019,1 billon de personas en 2019",
        "Desenchufando los aparatos electrónicos cuando no se usan,Cerrando la llave de agua,Dejar de ir al gym,Consumiendo comidas ricas en carbihidratos",
        "1.25 billones de dólares en 2030,5 millones de dólares en 2030,14 millones de dólares en 2030,6.000 millones de pesos colombianos",
        "África Subsahariana y Asia Meridional, Colombia y Estados Unidos, Europa y Asia, America del sur y America del norte",
        "Adoptar tecnologías e infraestructuras de energía no contaminante,Invirtiendo en bitcoin,Dando capacitaciones sobre la importancia de la salud mental,Haciendo campañas de publicidad sobre la covid 19",
        "Invirtiendo en energías renovables en edificios e instalaciones de la empresa,Mantenerse al día con las vacunas contra el COVID-19 – haciendose pruebas de COVID-19 si es necesario,Hacer campañas sobre el consumo de drogas,Generando conciencia ambiental promocionando campañas sobre el reciclaje y el correcto lavado de manos",
        "Por su ubicación geográfica y las condiciones climáticas,Por la carisma de la gente,Por destacarse por tener deportistas de alto rendimiento,Por la buena administración del gobierno",
        "Energía solar eólica biomasa geotérmica mareomotriz y pequeñas centrales hidroeléctricas,Energia química, Energia cinetica y energía potencial, Solo la radiación",
        "Energía fósil o convencional,Energia térmica,Fuentes de energía hídricas,El sol",
        "El cambio climático,El alza del dólar,La falta de educación,La politica",
        "Porque reconoce que la ampliación del acceso a la electricidad y otras formas de energía mejora la calidad de vida,Porque evita que los jóvenes caigan en malos caminos,Porque genera conciencia ambiental,Porque explica la importancia de saber manejar el dinero correctamente",
        "Transforma vidas - economías y el planeta,Aumenta los índices de mortalidad,Puede generar igualdad de genero,Reduce las disigualdades",
        "Energía asequible y no contaminante,Hambre cero,Vida submarina,Educacion de calidad",
        "Los países no podrán impulsar sus economías,Los países no podrán tener acceso al agua potable,Se acabaría la hambruna en cada país,No se podrian cumplir los 17 objetivos de desarrollo sostenible",
        "2.800 millones de personas,7 millones de personas,5.2 billones de personas,1 millón de personas",
        "Fuentes fósiles y las que aprovechan el sol viento agua y calor de la tierra,Energia cinetica y energía potencial,Agua salada y agua dulce,Ninguna de las anteriores",
        "Aumentar considerablemente la proporción de energía renovable en el conjunto de fuentes energéticas,Reducir a la mitad el número de muertes y lesiones causadas por accidentes de tráfico en el mundo,Eliminar todas las prácticas nocivas como el matrimonio infantil precoz y forzado y la mutilación genital femenina,Minimizar y abordar los efectos de la acidificación de los océanos",
        "Garantizar el acceso universal a servicios energéticos asequibles fiables y modernos,Garantizar empleo para todas las personas,Lograr la gestión sostenible y el uso eficiente de los recursos naturales,Reducir considerablemente la corrupción y el soborno en todas sus formas",
        "13%,2%,45%,38%",
        "17.5%,40%,30%,58%",
        "En la calefacción y el transporte,En el deporte y la salud,En la agricultura y minería,En el sector industrial",
        "No son contaminantes,Generan gases de efecto invernadero,Generan desempleo,La producción energética es discontinua",
        "No todos los territorios son aptos para energía renovable,Generan desempleo,Estimulan el sedentarismo,Genera adicción",
        "Duplicar la tasa mundial de mejora de la eficiencia energética, Erradicar la pobreza extrema para todas las personas en el mundo,Fortalecer la prevención y el tratamiento del abuso de sustancias adictivas,Poner fin a todas las formas de discriminación contra todas las mujeres y las niñas en todo el mundo",
        "Consumo de energía e intensidad energética de la organización - porcentaje de energía de origen renovable consumida,Invertir en asientos mas comodos para los empleados,Implementar un minibar para los trabajadores,Hacer actividades lúdicas y deportivas cada 2 meses",
        "Si ya que contribuye al medio ambiente y a la larga los beneficios son mucho mayores,No porque contamina más que la energía tradicional,Si porque ayudar a crecer en las redes sociales,No porque es muy barato y seria una perdida de tiempo y dinero",
        "Fue aprobado en septiembre de 2015 como parte de la agenda 2030,Fue aprobado en diciembre del 2022 para la agenda del 2030,Fue aprobado en julio de 2014 para la agenda 2023,No ha sido aprobado",
        
            
        
    };
    
    
    
    
    public String getRespuesta(int posicion){
        return respuestas[posicion];
    }
    
    public String[] separar(String cadena, String separador){ //se importa la clase tokenizer para separar el array
        StringTokenizer token = new StringTokenizer(cadena,separador); //Si hay elementos en el token
        String[] a = new String[29];                                   //los obtiene    
        int i = 0;
        
        while(token.hasMoreTokens()){
            a[i] = token.nextToken(); //Se obtiene el token
            i++;
        }
        
        return a;
    }
    
    public String[] setRespuestas(int posicion){ //Metodo para asginar al string la posicion de
        String split1 = radiobutton[posicion];            //las respues   
        String[] split2 = separar(split1,","); //Se asignan las respuestas y las separa
        return split2;
    }
    
}
