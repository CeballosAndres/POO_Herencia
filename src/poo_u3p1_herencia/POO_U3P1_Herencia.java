package poo_u3p1_herencia;
import java.util.ArrayList;
import java.util.Scanner;

public class POO_U3P1_Herencia {
    ArrayList<Persona> personas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int ancho = 50;
    
    public void label(String label){
        String tag = "=";
        int tam = (ancho - label.length())/2;
        System.out.println();
        for (int i = 0; i < tam; i++) {
            System.out.print(tag);
        }
        System.out.print(" "+label+" ");
        if (label.length()%2 ==0) {
            for (int i = 0; i < tam; i++) {
                System.out.print(tag);
            }
        } else {
            for (int i = 0; i < tam+1; i++) {
                System.out.print(tag);
            }
        }
        System.out.println();
    }
 
    public void menu(){
        int opc;
        do {
            if (this.personas.isEmpty()) {
                label("Menú principal");
                System.out.println("1 - Alta.");
                System.out.println("0 - Salir.");
                opc = this.opcion();
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
                label("Menú principal");
                System.out.println("1 - Alta.");
                System.out.println("2 - Consultar.");
                System.out.println("0 - Salir.");
                opc = opcion();

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
            label("Alta");
            System.out.println("1 - Estudiante.");
            System.out.println("2 - Docente.");
            System.out.println("3 - Administrativo.");
            System.out.println("4 - Intendente");
            System.out.println("0 - Regresar.");
            opc = opcion();

            switch(opc){
                case 1:
                    label("Alta estudiante");
                    alta(registrar(new Estudiante()));
                    break;
                case 2: 
                    label("Alta docente");
                    alta(registrar(new Docente()));
                    break;
                case 3:
                    label("Alta administrativo");
                    alta(registrar(new Administrativo()));
                    break;
                case 4:
                    label("Alta intendente");
                    alta(registrar(new Intendente()));
                    break;
                case 0:
                    break;
                default: 
                    System.out.println("Opción invalida.");
            }
        } while (opc != 0);
    }
    
    public void menuConsultar(){
        int opc;
        Persona persona;
        String busca;
        do {
            if (!this.personas.isEmpty()) {
                label("Consultar");
                System.out.println("1 - Buscar persona.");
                System.out.println("2 - Desplegar estudiantes.");
                System.out.println("3 - Desplegar docentes.");
                System.out.println("4 - Desplegar administrativo.");
                System.out.println("5 - Desplegar intendente.");
                System.out.println("6 - Desplegar todos.");
                System.out.println("7 - Reporte reprobacion.");
                System.out.println("0 - Regresar.");
                System.out.print("Opcion$ ");
                opc = sc.nextInt();
                switch(opc){
                    case 1:
                        label("Buscar alumno");
                        System.out.print("Ingresa alumno a buscar: ");
                        busca = sc.next();
                        persona = buscar(busca);
                        if (persona != null) {
                            menuAcciones(persona);
                        }
                        break;
                    case 2:
                        this.despliega(opc-1);
                        break;
                    case 3: 
                        this.despliega(opc-1);
                        break;
                    case 4: 
                        this.despliega(opc-1);
                        break;
                    case 5:
                        this.despliega(opc-1);
                        break;
                    case 6:
                        label("Todos los registros");
                        for (int i = 1; i <= 4; i++) {
                            this.despliega(i);
                        }
                        break;
                    case 7: 
                        System.out.println(estatusAlumnos());
                        break;
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
    
    public String estatusAlumnos(){
        int aprobados = 0;
        int reprobados = 0;
        boolean flag = false;
        this.label("Reporte reprobación");
        for(Persona item:this.personas){
            if (item instanceof Estudiante) {
                flag = true;
                if (((Estudiante)item).getPromedio() >= 70) {
                    aprobados++;
                } else {
                    reprobados++;
                }
            }
        }
        if (flag) {
            return aprobados+" alumnos aprobados.\n"+reprobados+" alumnos reprobaron.";
        }
        return "No existen alumnos registrados";
    }
    
    public void menuAcciones(Persona persona) {
        int opc;
        do {
            if (!this.personas.isEmpty()) {
                label("Opciones");
                System.out.println("1 - Ver.");
                System.out.println("2 - Modificar.");
                System.out.println("3 - Eliminar.");
                System.out.println("0 - Regresar.");
                opc = opcion();
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
        if (persona instanceof Estudiante) {
            return "estudiante";
        } else if (persona instanceof Docente){
            return "docente";
        } else if (persona instanceof Administrativo){
            return "administrativo";
        } else if (persona instanceof Intendente){
            return "intendente";
        }
        return "=";
    }
    
    public int opcion(){
        System.out.print("Opcion$ ");
        return sc.nextInt();
    }
    
    public void modificar(Persona persona){
        int opc;
        do {
            label("Modificar "+tipoClase(persona));
            System.out.println("1 - Nombre: "+persona.getNombre());
            System.out.println("2 - Email: "+persona.getEmail());
            System.out.println("3 - RFC: "+persona.getRfc());
            if (persona instanceof Estudiante) {
                System.out.println("4 - No. Control: "+((Estudiante)persona).getNoControl());
                System.out.println("5 - Promedio: "+((Estudiante)persona).getPromedio());
            } else {
                System.out.println("4 - Clave: "+((Empleado)persona).getClave());
                System.out.println("5 - Sueldo: "+((Empleado)persona).getSueldo());
                if (persona instanceof Docente) {
                    System.out.println("6 - Horas: "+((Docente)persona).getHoras());
                } else if (persona instanceof Administrativo){
                    System.out.println("6 - Puesto: "+((Administrativo)persona).getPuesto());
                } else if (persona instanceof Intendente){
                    System.out.println("6 - Área que atiende: "+((Intendente)persona).getAreaAtiende());
                }
            }
            System.out.println("0 - Regresar.");
            opc = opcion();
            
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
                    String rfc = sc.next();
                    
                    if (validarRfc(rfc)) {
                        break;
                    }
                    persona.setRfc(rfc);
                    break;
                case 4:
                    if (persona instanceof Estudiante) {
                        System.out.print("Nuevo No. Control: ");
                        ((Estudiante)persona).setNoControl(sc.nextInt());
                    } else {
                        System.out.print("Nueva clave: ");
                        ((Empleado)persona).setClave(sc.next());
                    }
                    break;
                case 5:
                    if (persona instanceof Estudiante) {
                        System.out.print("Nuevo promedio: ");
                        ((Estudiante)persona).setPromedio(sc.nextFloat());
                    } else {
                        System.out.print("Nuevo sueldo: ");
                        ((Empleado)persona).setSueldo(sc.nextInt());
                    }
                    break;
                case 6:
                    if (persona instanceof Docente) {
                        System.out.print("Nuevas horas:");
                        ((Docente)persona).setHoras(sc.nextInt());
                    } else if (persona instanceof Administrativo) {
                        System.out.print("Nuevo puesto: ");
                        ((Administrativo)persona).setPuesto(sc.next());
                    } else if (persona instanceof Intendente) {
                        System.out.print("Nueva área: ");
                        ((Intendente)persona).setAreaAtiende(sc.next());
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
    
    public boolean validarRfc(String rfc){
        for (int i = 0; i < this.personas.size(); i++) {
            if (this.personas.get(i).getRfc().equals(rfc)) {
                System.out.println("El RFC dado ya está registrado.");
                System.out.println("Pertenece a "+this.personas.get(i).consultarDatos());
                return true;
            }
        }
        return false;
    }
    
    public Persona registrar(Persona persona){
        System.out.println("<<Ingrese datos>>");
        System.out.print("RFC: ");
        String rfc = sc.next();
        //validación para evitar repeticiones
        if (validarRfc(rfc)) {
            return null;
        }
        //datos comunes a la superclase
        persona.setRfc(rfc);
        System.out.print("Nombre: ");
        persona.setNombre(sc.next());
        System.out.print("Email: ");
        persona.setEmail(sc.next());
        //Inicia registro diferenciado::
        if (persona instanceof Estudiante) {
            System.out.print("Numero de Control: ");
            ((Estudiante)persona).setNoControl(sc.nextInt());
            System.out.print("Promedio: ");
            ((Estudiante)persona).setPromedio(sc.nextFloat());
            System.out.print("Telefono: ");
            ((Estudiante)persona).setTelefono(sc.next());
        } else if (persona instanceof Empleado) {
            System.out.print("Clave: ");
            ((Empleado)persona).setClave(sc.next());
            System.out.print("Sueldo: ");
            ((Empleado)persona).setSueldo(sc.nextFloat());
            if (persona instanceof Docente) {
                System.out.print("Horas: ");
                ((Docente)persona).setHoras(sc.nextInt());
            } else if (persona instanceof Administrativo){
                System.out.print("Puesto: ");
                ((Administrativo)persona).setPuesto(sc.next());
            } else if (persona instanceof Intendente){
                System.out.print("Área: ");
                ((Intendente)persona).setAreaAtiende(sc.next());
            }
        }
        return persona;
    }
    
    public void alta(Persona persona){
        if (persona != null) {
            this.personas.add(persona);
            System.out.println("\n** Alta de "+this.tipoClase(persona)+" exitosa.");
        } else {
            System.out.println("No se ha completado el registro.");
        }
    }
    
    public void despliega(int opc){
        boolean flag = false;
        for(Persona item:this.personas){
            switch (opc){
                case 1:
                    if (item instanceof Estudiante) {
                        if (!flag) label("Estudiantes registrados");             
                        System.out.println(item.consultarDatos());
                        flag = true;
                        if (!flag) System.out.println("** Ningún registro **");
                    }
                    break;
                case 2:
                                
                    if (item instanceof Docente) {
                        if (!flag) label("Docentes registrados"); 
                        System.out.println(item.consultarDatos());
                        flag = true;
                        if (!flag) System.out.println("** Ningún registro **");
                    }
                    break;
                case 3:
                    if (item instanceof Administrativo) {
                        if (!flag) label("Administrativos registrados");             
                        System.out.println(item.consultarDatos());
                        flag = true;
                        if (!flag) System.out.println("** Ningún registro **");
                    }
                    break;
                case 4:
                    if (item instanceof Intendente) {
                        if (!flag) label("Intendentes registrados");             
                        System.out.println(item.consultarDatos());
                        flag = true;
                        if (!flag) System.out.println("** Ningún registro **");
                    }
                    break;
            }
        }
    }

    public Persona buscar(String busca){
        //||((Estudiante)this.personas.get(i)).getNoControl() == Integer.parseInt(busca)
        for (int i = 0; i < this.personas.size(); i++) {
            if (this.personas.get(i).getNombre().equals(busca)||
                    this.personas.get(i).getEmail().equals(busca)||
                    this.personas.get(i).getRfc().equals(busca)) {
                System.out.println("//Coincidencia con la busqueda// ");
                System.out.println(this.personas.get(i).consultarDatos());
                label("Opciones");
                System.out.println("1 - Más opciones.");
                System.out.println("2 - Seguir buscando.");
                System.out.println("0 - Denetener busqueda.");
                int opc = this.opcion();
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
        label("Confirmación");
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