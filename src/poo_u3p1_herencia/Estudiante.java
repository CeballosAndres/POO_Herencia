
package poo_u3p1_herencia;

public class Estudiante extends Persona {
    private int noControl;
    private float promedio;

    public Estudiante(int noControl, float promedio, String rfc, String nombre, String email) {
        super(rfc, nombre, email);
        this.noControl = noControl;
        this.promedio = promedio;
    }
    public Estudiante() {
        super();
        this.noControl = 0;
        this.promedio = 0.0f;
    }
    
    
    
    public void setNoControl(int noControl){
        this.noControl = noControl;
    }
    public void setPromedio(float promedio){
        this.promedio = promedio;
    }
    public int getNoControl(){
        return this.noControl;
    }
    public float getPromedio(){
        return this.promedio;
    }
    
    @Override
    public String consultarDatos(){
        return this.getNoControl()+"\t"+super.consultarDatos()+"\t"+this.getPromedio();
    }
    
    
    
}
