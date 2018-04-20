
package poo_u3p1_herencia;
import java.util.Scanner;

public class POO_U3P1_Herencia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Estudiante est = new Estudiante();
        Persona per = new Persona();
        System.out.print("RFC ");
        per.setRfc(sc.next());
        System.out.print("Nombre ");
        per.setNombre(sc.next());
        System.out.print("Email ");
        per.setEmail(sc.next());
        System.out.println(per.getRfc()+", "+per.getNombre()+", "+per.getEmail());

        System.out.println("Datos del estudiante");
        System.out.println(est.consultarDatos());

        Empleado emp = new Empleado();
        System.out.println("Datos de emplado");

        
    }
    
}
