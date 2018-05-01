

package poo_u3p1_herencia;

public class Administrativo extends Empleado {
    private String puesto;

    public Administrativo(String puesto, String clave, float sueldo, String rfc, String nombre, String email) {
        super(clave, sueldo, rfc, nombre, email);
        this.puesto = puesto;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }
    

    public String consultarDatos(){
        return this.clave+", "+this.getEmail()+", "+this.getNombre()+", "+this.getRfc()+", "+this.puesto;
    }
}
