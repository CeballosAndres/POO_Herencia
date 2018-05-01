
package poo_u3p1_herencia;

public class Empleado extends Persona{
    protected String clave;
    protected float sueldo;

    public Empleado(String clave, float sueldo, String rfc, String nombre, String email) {
        super(rfc, nombre, email);
        this.clave = clave;
        this.sueldo = sueldo;
    }
    
    public Empleado() {
        super();
        this.clave = null;
        this.sueldo = 0.0f;
    }

    
    public String getClave() {
        return clave;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    

}
