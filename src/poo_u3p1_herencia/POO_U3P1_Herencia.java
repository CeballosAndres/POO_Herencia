
package poo_u3p1_herencia;
import java.util.ArrayList;
import java.util.Scanner;

public class POO_U3P1_Herencia {
    ArrayList<Persona> personas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int ancho = 45;
    
    public void label(String text){
        int n = (ancho-text.length())/2;
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("=");
        }
        System.out.print(text);
        for (int i = 0; i < n; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
 
    
    public void menu(){
        int opc;
        do {
            if (this.personas.isEmpty()) {
                label(" Menu principal ");
                System.out.println("1 - Agregar.");
                System.out.println("0 - Salir.");
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
                label(" Menu principal ");
                System.out.println("1 - Alta.");
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
            label(" Alta ");
            System.out.println("1 - Estudiante.");
            System.out.println("2 - Docente.");
            System.out.println("3 - Administrativo.");
            System.out.println("0 - Regresar.");
            System.out.print("Opcion$ ");
            opc = sc.nextInt();

            switch(opc){
                case 1:
                    label(" Alta estudiante ");
                    registrar(new Estudiante());
                    break;
                case 2: 
                    label(" Alta docente ");
                    registrar(new Docente());
                    break;
                case 3:
                    label(" Alta administrativo ");
                    registrar(new Administrativo());
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
            if (!this.personas.isEmpty()) {
                label(" Consultar ");
                System.out.println("1 - Buscar.");
                System.out.println("2 - Ver todos.");
                System.out.println("0 - Regresar.");
                System.out.print("Opcion$ ");
                opc = sc.nextInt();
                switch(opc){
                    case 1:
                        label(" Buscar alumno ");
                        System.out.print("Ingresa alumno a buscar: ");
                        busca = sc.next();
                        persona = buscar(busca);
                        if (persona != null) {
                            menuAcciones(persona);
                        }
                        break;
                    case 2:
                        label(" Registros ");
                        desplegar();
                    case 0:
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");
                }
            } else {
                opc = 0;
            }           
        } while (opc!=0);
        
    }
    
    public void menuAcciones(Persona persona) {
        int opc;

        do {
            if (!this.personas.isEmpty()) {
                label(" Opciones ");
                System.out.println("1 - Ver.");
                System.out.println("2 - Modificar.");
                System.out.println("3 - Eliminar.");
                System.out.println("0 - Regresar.");
                System.out.print("Opcion$ ");
                opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        System.out.println(persona.consultarDatos());
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
            } else {
                opc = 0;
            }
        } while (opc != 0);

    }
    
    public String tipoClase(Persona persona){
        if (persona.getClass()==Estudiante.class) {
            return "estudiante";
        } else if (persona.getClass() == Docente.class){
            return "docente";
        } else if (persona.getClass()== Administrativo.class){
            return "administrativo";
        }
        return "=";
    }
    
    public void modificar(Persona persona){
        int opc;
        do {
            label(" Modificar "+tipoClase(persona)+" ");
            System.out.println("1 - Nombre: "+persona.getNombre());
            System.out.println("2 - Email: "+persona.getEmail());
            System.out.println("3 - RFC: "+persona.getRfc());
            if (persona.getClass() == Estudiante.class) {
                System.out.println("4 - No. Control: "+((Estudiante)persona).getNoControl());
                System.out.println("5 - Promedio: "+((Estudiante)persona).getPromedio());
            } else {
                System.out.println("4 - Clave: "+((Empleado)persona).getClave());
                System.out.println("5 - Sueldo: "+((Empleado)persona).getSueldo());
                if (persona.getClass() == Docente.class) {
                    System.out.println("6 - Horas: "+((Docente)persona).getHoras());
                } else {
                    System.out.println("6 - Puesto: "+((Administrativo)persona).getPuesto());
                }
            }
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
                    System.out.print("Nuevo RFC: ");
                    persona.setRfc(sc.next());
                    break;
                case 4:
                    if (persona.getClass()==Estudiante.class) {
                        System.out.print("Nuevo No. Control: ");
                        ((Estudiante)persona).setNoControl(sc.nextInt());
                    } else {
                        System.out.print("Nueva clave: ");
                        ((Empleado)persona).setClave(sc.next());
                    }
                    break;
                case 5:
                    if (persona.getClass()==Estudiante.class) {
                        System.out.print("Nuevo promedio: ");
                        ((Estudiante)persona).setPromedio(sc.nextFloat());
                    } else {
                        System.out.print("Nuevo sueldo: ");
                        ((Empleado)persona).setSueldo(sc.nextInt());
                    }
                    break;
                case 6:
                    if (persona.getClass() == Docente.class) {
                        System.out.print("Nuevas horas:");
                        ((Docente)persona).setHoras(sc.nextInt());
                    } else if (persona.getClass() == Administrativo.class) {
                        System.out.print("Nuevo puesto: ");
                        ((Administrativo)persona).setPuesto(sc.next());
                    } else {
                        System.out.println("Opción invalida.");
                    }
                    break;
                case 0:
                    break;
                default:  
                    System.out.println("Opción invalida.");
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
        } else {
            registrarEmpleado(persona);
        }
        return persona;
    }
    
    public void registrarEmpleado(Persona empleado){
        System.out.print("Clave: ");
        ((Empleado)empleado).setClave(sc.next());
        System.out.print("Sueldo: ");
        ((Empleado)empleado).setSueldo(sc.nextFloat());
        if (empleado.getClass() == Docente.class) {
            registrarDocente(empleado);
        } else {
            registrarAdministrativo(empleado);
        }
    }
    
    public void registrarEstudiante(Persona estudiante){
        System.out.print("Numero de Control: ");
        ((Estudiante)estudiante).setNoControl(sc.nextInt());
        System.out.print("Promedio: ");
        ((Estudiante)estudiante).setPromedio(sc.nextFloat());
        if (this.personas.add(estudiante)) {
            System.out.println("Ok. Estudiante "+estudiante.getNombre()+
                    " registrado.");
        } else {
            System.out.println("Error. No se registro estudiante.");
        }
    }
    
    public void registrarDocente(Persona docente){
        System.out.print("Horas: ");
        ((Docente)docente).setHoras(sc.nextInt());
        if (this.personas.add(docente)) {
            System.out.println("Ok. Docente "+docente.getNombre()+
                    " registrado.");
        } else {
            System.out.println("Error. No se registro docente.");
        }
        
    }
    
    public void registrarAdministrativo(Persona administrativo){
        System.out.print("Puesto: ");
        ((Administrativo)administrativo).setPuesto(sc.next());
        if (this.personas.add(administrativo)) {
            System.out.println("Ok. Administrativo "+administrativo.getNombre()+
                    " registrado.");
        } else {
            System.out.println("Error. No se registro administrativo.");
        }
        
    }
    
    public void desplegar(){
        if (this.personas.isEmpty()) {
            System.out.println("No existen registros.");
        } else {
            System.out.println("No. Control\tRFC\tNombre\tEmail\tPromedio");
            for (Persona persona : personas) {
                System.out.println(persona.consultarDatos());
            }
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
                System.out.println("1 - Más opciones.");
                System.out.println("2 - Seguir buscando.");
                System.out.println("0 - Denetener busqueda.");
                System.out.print("Opción$ ");
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
        label(" Confirmación ");
        System.out.print("¿Seguro de eliminar a "+persona.getNombre()+" [s/n]: ");
        opc = sc.next().toLowerCase().charAt(0);
        if (opc == 's') {
            this.personas.remove(persona);
            System.out.println("Ok. Eliminado.");
        }
    }
    
    public static void main(String[] args) {
       POO_U3P1_Herencia poo = new POO_U3P1_Herencia();

       poo.menu();
    }
    
}
