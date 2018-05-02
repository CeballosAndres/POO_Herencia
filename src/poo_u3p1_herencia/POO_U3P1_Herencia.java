
package poo_u3p1_herencia;
import java.util.ArrayList;
import java.util.Scanner;

public class POO_U3P1_Herencia {
    ArrayList<Persona> personas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    
    public void labelMenu(String text){
        System.out.println("\n------ "+text+" ------\n");
    }
    

    
    public void menu(){
        int opc;
        do {
            if (this.personas.isEmpty()) {
                labelMenu("Menu principal");
                System.out.println("1 - Agregar.");
                System.out.println("0 - Salir.");
                System.out.print("Opcion$ ");
                opc = sc.nextInt();
                System.out.println("");

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
                    registrar(new Estudiante());
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
        Persona persona;
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
                    persona = buscar(busca);
                    if (persona != null) {
                        menuAcciones(persona);
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
            System.out.println("0 - Regresar.");
            System.out.print("Opción$ ");
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
    
    public Persona registrar(Persona persona){
        System.out.println("Ingrese datos:");
        System.out.print("RFC: ");
        String rfc = sc.next();
        //validación para evitar repeticiones
        for (int i = 0; i < this.personas.size(); i++) {
            if (this.personas.get(i).getRfc().equals(rfc)) {
                System.out.println("El RFC dado ya está registrado.");
                System.out.println("Pertenece a "+this.personas.get(i).consultarDatos());
                return null;
            }
        }
        //datos comunes a la superclase
        persona.setRfc(rfc);
        System.out.print("Nombre: ");
        persona.setNombre(sc.next());
        System.out.print("Email: ");
        persona.setEmail(sc.next());
        
        if (persona.getClass() == Estudiante.class) {
            registrarEstudiante(persona);
        }
        return persona;
    }
    
    public void registrarEstudiante(Persona estudiante){
        System.out.print("Numero de Control:");
        ((Estudiante)estudiante).setNoControl(sc.nextInt());
        System.out.print("Promedio: ");
        ((Estudiante)estudiante).setPromedio(sc.nextFloat());
        this.personas.add(estudiante);
    }
    
    public void desplegarEstudiantes(){
        if (this.personas.isEmpty()) {
            System.out.println("No existen registros.");
        } else {
            System.out.println("Campo1\tCampo2\tCampo3");
            for (int i = 0; i < this.personas.size(); i++) {
                System.out.println(this.personas.get(i).consultarDatos());
            }
            System.out.println("-----------------------------------\n");
        }
        
    }
    
    public Persona buscar(String busca){
        
        for (int i = 0; i < this.personas.size(); i++) {
            if (this.personas.get(i).getNombre().equals(busca)||
                    this.personas.get(i).getEmail().equals(busca)||
                    this.personas.get(i).getRfc().equals(busca)) {
                System.out.println("** El estudiante coincide con la busqueda: ");
                System.out.println(this.personas.get(i).consultarDatos());
                System.out.println("Opciones:");
                System.out.println("1 - Seleccionar.");
                System.out.println("2 - Seguir buscando.");
                System.out.println("0 - Denetener busqueda.");
                int opc = sc.nextInt();
                
                switch(opc){
                    case 1:
                        return this.personas.get(i);
                    case 2:
                        break;
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
        System.out.println("Nombre: "+persona.getNombre());
        System.out.println("RFC: "+persona.getRfc());
        System.out.print("¿Seguro de eliminar [s/n]: ");
        opc = sc.next().toLowerCase().charAt(0);
        if (opc == 's') {
            this.personas.remove(persona);
            System.out.println("Eliminado");
        }
    }
    
    public static void main(String[] args) {
       POO_U3P1_Herencia poo = new POO_U3P1_Herencia();

       poo.menu();
    }
    
}
