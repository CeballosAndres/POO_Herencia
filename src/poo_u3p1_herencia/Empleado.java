
package poo_u3p1_herencia;

public class Empleado extends Persona{
    String clave;
    float sueldo;

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
    
    
    public String consultarDatos(){
        return (this.rfc+", "+this.nombre+", "+this.clave+", "+this.sueldo);
    }
}
