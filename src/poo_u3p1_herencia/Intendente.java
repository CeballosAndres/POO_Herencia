package poo_u3p1_herencia;
public class Intendente extends Empleado{
    private String areaAtiende;

    public Intendente(String areaAtiende, String clave, float sueldo, String rfc, String nombre, String email) {
        super(clave, sueldo, rfc, nombre, email);
        this.areaAtiende = areaAtiende;
    }

    public Intendente() {
        super();
        this.areaAtiende = null;
    }

    public String getAreaAtiende() {
        return areaAtiende;
    }
    public void setAreaAtiende(String areaAtiende){
        this.areaAtiende = areaAtiende;
    }
    
    @Override
    public String consultarDatos(){
        return this.getAreaAtiende()+"\t"+super.consultarDatos();
    }
    
    
}
