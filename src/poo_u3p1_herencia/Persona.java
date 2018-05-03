
package poo_u3p1_herencia;

public class Persona {
    protected String rfc;
    protected String nombre;
    protected String email;
    
    public Persona(String rfc, String nombre, String email){
        this.rfc = rfc;
        this.nombre = nombre;
        this.email = email;
    }
    
    public Persona(){
        this.rfc = null;
        this.nombre = null;
        this.email = null;
    }
    
    
    public void setRfc(String rfc){
        this.rfc = rfc;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getRfc(){
        return this.rfc;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getEmail(){
        return this.email;
    }
    
    public String consultarDatos(){
        return this.getRfc()+"\t"+this.getNombre()+"\t"+this.getEmail();
    }
   
}
