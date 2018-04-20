
package poo_u3p1_herencia;

public class Persona {
    protected String rfc;
    protected String nombre;
    protected String email;
    
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
   
}
