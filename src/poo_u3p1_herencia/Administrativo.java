package poo_u3p1_herencia;

public class Administrativo extends Empleado {
    private String puesto;

    public Administrativo(String puesto, String clave, float sueldo, String rfc, String nombre, String email) {
        super(clave, sueldo, rfc, nombre, email);
        this.puesto = puesto;
    }
    
    public Administrativo(){
        super();
        this.puesto = null;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String consultarDatos(){
        return super.consultarDatos()+"\t"+this.getPuesto();
    }
}
