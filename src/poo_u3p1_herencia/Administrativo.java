

package poo_u3p1_herencia;

public class Administrativo extends Empleado {
    protected String puesto;

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
