
package poo_u3p1_herencia;
import java.util.Scanner;
public class POO_U3P1_Herencia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante est = new Estudiante();
        System.out.println(est.consultarDatos());
        System.out.println("RFC del estudiante");
        est.rfc = "Hola";
        System.out.println(est.consultarDatos());
        
    }
    
}
