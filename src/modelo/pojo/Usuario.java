package modelo.pojo;
// Generated 27/07/2017 15:38:07 by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private String nombre;
     private String contrasenia;

    public Usuario() {
    }

    public Usuario(String nombre, String contrasenia) {
       this.nombre = nombre;
       this.contrasenia = contrasenia;
    }

    public Usuario(Integer idusuario, String nombre, String contrasenia) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
    
    
   
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }




}


