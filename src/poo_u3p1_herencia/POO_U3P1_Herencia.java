
package poo_u3p1_herencia;
import java.util.ArrayList;
import java.util.Scanner;

public class POO_U3P1_Herencia {
    ArrayList<Persona> listEstudiantes = new ArrayList<>();
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
    
    public void menuConsultar(){
        int opc;
        Estudiante est;
        String busca;
        do {
            labelMenu("Consultar");
            System.out.println("1 - Buscar alumno.");
            System.out.println("2 - Ver todos.");
            System.out.println("0 - Regresar");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.print("Ingresa alumno a buscar: ");
                    busca = sc.next();
                    est = buscar(busca);
                    if (est != null) {
                        menuAcciones(est);
                    }
                    break;
                case 2:
                    desplegarEstudiantes();
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }            
        } while (opc!=0);
        
    }
    
    public void menuAcciones(Persona persona){
        int opc;
        do {
            labelMenu("Acciones");
            System.out.println("1 - Ver.");
            System.out.println("2 - Modificar.");
            System.out.println("3 - Eliminar.");
            System.out.println("0 - Regresar.");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();
            
            switch(opc){
                case 1:
                    persona.consultarDatos();
                    break;
                case 2:
                    modificar(persona);
                    break;
                case 3:
                    eliminar(persona);
                    break;
                case 0:
                    break;
                default: 
                    System.out.println("Opción invalida.");
            }
        } while (opc!=0);
        
    }
    
    public void modificar(Persona persona){
        int opc;
        do {
            labelMenu("Modificar");
            System.out.println("1 - Nombre: "+persona.getNombre());
            System.out.println("2 - Email: "+persona.getEmail());
            System.out.println("3 - RFC: "+persona.getRfc());
            System.out.println("4 - No. Control: "+((Estudiante)persona).getNoControl());
            System.out.println("5 - Promedio: "+((Estudiante)persona).getPromedio());
            opc = sc.nextInt();
            
            switch(opc){
                case 1:
                    System.out.print("Nuevo nombre: ");
                    persona.setNombre(sc.next());
                    break;
                case 2:
                    System.out.print("Nuevo Email: ");
                    persona.setEmail(sc.next());
                    break;
                case 3:
                    System.out.println("Nuevo RFC: ");
                    persona.setRfc(sc.next());
                    break;
                case 4:
                    System.out.print("Nuevo No. Control: ");
                    ((Estudiante)persona).setNoControl(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Nuevo promedio: ");
                    ((Estudiante)persona).setPromedio(sc.nextFloat());
                    break;
                case 0:
                    break;
                default:             
            }
        } while (opc!=0);
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
    
    public Estudiante buscar(String busca){
        for (int i = 0; i < this.listEstudiantes.size(); i++) {
            if (this.listEstudiantes.get(i).getNombre().equals(busca)||
                    this.listEstudiantes.get(i).getEmail().equals(busca)||
                    this.listEstudiantes.get(i).getNoControl() == Integer.parseInt(busca)||
                    this.listEstudiantes.get(i).getRfc().equals(busca)) {
                System.out.println("** El estudiante coincide con la busqueda: ");
                this.listEstudiantes.get(i).consultarDatos();
                System.out.println("Opciones:");
                System.out.println("1 - Seguir buscando.");
                System.out.println("2 - Seleccionar.");
                System.out.println("0 - Denetener busqueda.");
                int opc = sc.nextInt();
                
                switch(opc){
                    case 1:
                        break;
                    case 2:
                        return this.listEstudiantes.get(i);
                    case 0:
                        return null;
                }
            }
        }
        System.out.println("No se encontro el estudiante");
        return null;
    }
    
    public void eliminar(Persona persona){
        char opc;
        labelMenu("Datos");
        persona.consultarDatos();
        System.out.print("Esta seguro de eliminar [s/n]: ");
        opc = sc.next().toLowerCase().charAt(0);
        if (opc == 's') {
            this.listEstudiantes.remove(persona);
            System.out.println("Eliminado");
        }
    }
    
    public static void main(String[] args) {
       POO_U3P1_Herencia poo = new POO_U3P1_Herencia();

       poo.menu();
    }
    
}
