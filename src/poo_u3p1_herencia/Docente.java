package poo_u3p1_herencia;

public class Docente extends Empleado{
    private int horas;

    public Docente(int horas, String clave, float sueldo, String rfc, String nombre, String email) {
        super(clave, sueldo, rfc, nombre, email);
        this.horas = horas;
    }
    
    public Docente(){
        super();
        this.horas = 0;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }
    
    @Override
    public String consultarDatos(){
        return super.consultarDatos()+"\t"+this.getHoras();
    }
    
}
