
package poo_u3p1_herencia;


public class Docente extends Empleado{
    int horas;

    public void setHoras(int horas) {
        this.horas = horas;
    }

    
    public int getHoras() {
        return horas;
    }
    
    public String consultarDatos(){
        return this.clave+", "+this.email+", "+this.nombre+", "+this.rfc+", "+this.horas;
    }
    
}
