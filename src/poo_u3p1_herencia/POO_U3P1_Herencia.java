
package poo_u3p1_herencia;
import java.util.ArrayList;
import java.util.Scanner;

public class POO_U3P1_Herencia {
    ArrayList<Estudiante> listEstudiantes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    
    public void labelMenu(String text){
        System.out.println("------ "+text+" ------\n");
    }
    

    
    public void menu(){
        int opc;
        do {
            if (this.listEstudiantes.isEmpty()) {
                labelMenu("Menu principal");
                System.out.println("1 - Agregar.");
                System.out.print("Opcion$ ");
                opc = sc.nextInt();

                switch(opc){
                    case 1:
                        menuAgregar();
                        break;
                    case 0:
                        System.out.println("Gracias, good bye.");
                        break;
                    default: 
                        System.out.println("Opción no valida.");
                }
            } else {
                labelMenu("Menu principal");
                System.out.println("1 - Agregar.");
                System.out.println("2 - Consultar.");
                System.out.println("0 - Salir.");
                System.out.print("Opcion$ ");
                opc = sc.nextInt();

                switch(opc){
                    case 1:
                        menuAgregar();
                        break;
                    case 2: 
                        menuConsultar();
                        break;
                    case 0:
                        System.out.println("Gracias, good bye.");
                        break;
                    default: 
                        System.out.println("Opción no valida.");
                }
            }
        } while (opc != 0);
    }
    
    public void menuModificar(){
        int opc;
        do {
            System.out.println("---- Modificar ----");
            System.out.println("1 - Estudiante.");
            System.out.println("2 - Docente.");
            System.out.println("3 - Administrativo.");
            System.out.println("0 - Regresar.");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();

            switch(opc){
                case 1:
                    menuEliminarEstudiante();
                    break;
                case 2: 
                    break;
                case 3:

                    break;
                case 0:
                    break;
                default: 
                    System.out.println("Opción invalida");
            }

        } while (opc != 0);
        
    }
    
    public void menuAgregar(){
        int opc;
        do {
            System.out.println("---- Agregar ----");
            System.out.println("1 - Estudiante.");
            System.out.println("2 - Docente.");
            System.out.println("3 - Administrativo.");
            System.out.println("0 - Regresar.");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();

            switch(opc){
                case 1:
                    nuevoEstudiante();
                    break;
                case 2: 
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default: 
                    System.out.println("Gracias, adios.");
            }
        } while (opc != 0);
        
        
    }
    
    public void menuEliminar(){
        int opc;
        do {
            System.out.println("---- Eliminar ----");
            System.out.println("1 - Estudiante.");
            System.out.println("2 - Docente.");
            System.out.println("3 - Administrativo.");
            System.out.println("0 - Regresar.");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();

            switch(opc){
                case 1:
                    menuEliminarEstudiante();
                    break;
                case 2: 
                    break;
                case 3:

                    break;
                case 0:
                    break;
                default: 
                    System.out.println("Opción invalida");
            }

        } while (opc != 0);
        
    }
    
    public void menuConsultar(){
        int opc;
        do {
            System.out.println("---- Consultar ----");
            System.out.println("1 - Estudiante.");
            System.out.println("2 - Docente.");
            System.out.println("3 - Administrativo.");
            System.out.println("0 - Regresar.");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();

            switch(opc){
                case 1:
                    System.out.println("Datos de los estudiantes.");
                    desplegarEstudiantes();
                    break;
                case 2: 
                    break;
                case 3:

                    break;
                case 0:
                    break;
                default: 
                    System.out.println("Gracias, adios.");
            }

        } while (opc != 0);
        
    }
    
    public void menuSeleccionaEstudiante(){
        int opc;
        System.out.println("---- Eliminar Estudiante ----");
        System.out.println("1 - Por Numero de control.");
        System.out.println("2 - Por RFC.");
        System.out.println("0 - Regresar.");
        System.out.print("Opcion$ ");
        opc = sc.nextInt();
        switch(opc){
            case 1:
                System.out.print("Ingresa el Número de control: ");
                eliminarEstudiante(seleccionarEstudiante(sc.nextInt()));
                break;
            case 2: 
                System.out.print("Ingresa el RFC: ");
                eliminarEstudiante(seleccionarEstudiante(sc.next()));
                break;
            default: 
                System.out.println("Opción invalida");
        }
    }
    
    public void nuevoEstudiante(){
        System.out.println("-> Ingresa datos del estudiante.");
        System.out.print("No Control: ");
        int numeroControl = sc.nextInt();
        System.out.print("Promedio: ");
        float promedio = sc.nextFloat();
        System.out.print("RFC: ");
        String rfc = sc.next();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        
        this.listEstudiantes.add(new Estudiante(numeroControl, promedio, rfc, nombre, email));
        
    }
    
    public void desplegarEstudiantes(){
        if (this.listEstudiantes.isEmpty()) {
            System.out.println("No existen registros.");
        } else {
            System.out.println("Campo1\tCampo2\tCampo3");
            for (int i = 0; i < this.listEstudiantes.size(); i++) {
                System.out.println(this.listEstudiantes.get(i).consultarDatos());
            }
            System.out.println("-----------------------------------\n");
        }
        
    }
    
    public int seleccionarEstudiante(String rfc){
        if (this.listEstudiantes.isEmpty()) {
            System.out.println("No existen estudiantes registrados.");
            return -1;
        }
        for (int i = 0; i < this.listEstudiantes.size(); i++) {
            if (this.listEstudiantes.get(i).getNombre().equals(rfc)) {
                System.out.println("Estudiante encontrado: ");
                this.listEstudiantes.get(i).consultarDatos();
                return i;
            }
        }
        System.out.println("No se encontro el estudiante");
        return -1;
    }
    
    public int seleccionarEstudiante(int noControl){
        if (this.listEstudiantes.isEmpty()) {
            System.out.println("No existen estudiantes registrados.");
            return -1;
        }
        for (int i = 0; i < this.listEstudiantes.size(); i++) {
            if (this.listEstudiantes.get(i).getNoControl() == noControl) {
                System.out.println("Estudiante encontrado: ");
                this.listEstudiantes.get(i).consultarDatos();
                return i;
            }
        }
        System.out.println("No se encontro el estudiante");
        return -1;
    }
    
    public void eliminarEstudiante(int estudiante){
        if (estudiante >= 0) {
            char opc;
            System.out.print("Esta seguro de eliminar al estudiante [s/n]: ");
            opc = sc.next().toLowerCase().charAt(0);
            if (opc == 's') {
                this.listEstudiantes.remove(estudiante);
                System.out.println("Esudiante eliminado");
            }
        }
    }
    
       public void menuEliminarEstudiante(){
        
        int opc;
        do {
            System.out.println("---- Eliminar Estudiante ----");
            System.out.println("1 - Por Numero de control.");
            System.out.println("2 - Por RFC.");
            System.out.println("0 - Regresar.");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.print("Ingresa el Número de control: ");
                    eliminarEstudiante(sc.nextInt());
                    break;
                case 2: 
                    System.out.print("Ingresa el RFC: ");
                    //eliminarEstudiante(sc.next());
                    break;
                case 0:
                    break;
                default: 
                    System.out.println("Gracias, adios.");
            }
        } while (opc != 0);
        
        
        
    }
    
    

    public static void main(String[] args) {
       POO_U3P1_Herencia poo = new POO_U3P1_Herencia();

       //poo.menu();
       //Tarea: agregar metodos para borrar por numero de control y por rfc
    }
    
}
