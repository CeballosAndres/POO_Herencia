
package poo_u3p1_herencia;
import java.util.Scanner;

public class POO_U3P1_Herencia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante est = new Estudiante();
        Administrativo adm = new Administrativo();
        Docente doc = new Docente();
        
        est.setRfc("JULI-990122");
        est.setNombre("Juárez López Israel");
        est.setNoControl("15460132");
        est.setPromedio(96.3f);
        
        adm.setRfc("dasfjñlasdjfl");
        adm.setNombre("Torres García Alejandro");
        adm.setClave("201");
        adm.setSueldo(8429.00f);
        adm.setPuesto("Cajero");
        
        doc.setRfc("ZERO-880812");
        doc.setNombre("Zepeda Ruíz Oscar");
        doc.setClave("120");
        doc.setSueldo(14299.0f);
        doc.setHoras(20);
        
        System.out.println(est.consultarDatos());
        System.out.println(adm.consultarDatos());
        System.out.println(doc.consultarDatos());
    }
    
}
