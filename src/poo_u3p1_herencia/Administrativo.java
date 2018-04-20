

package poo_u3p1_herencia;

public class Administrativo extends Empleado {
    String puesto;

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }
    

    public String consultarDatos(){
        return this.clave+", "+this.email+", "+this.nombre+", "+this.rfc+", "+this.puesto;
    }
}
