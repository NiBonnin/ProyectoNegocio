/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.ConexionBBDD;
import modelo.pojo.Usuario;

/**
 *
 * @author Nico
 */
public class UsuarioService {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    ConexionBBDD cox = new ConexionBBDD();
    
    public boolean validacion(Usuario u){
        Usuario ubuscado = getByName(u.getNombre());
        if (ubuscado != null) {
            String nombreBuscado =ubuscado.getNombre();
            String contraseniaBuscado =ubuscado.getContrasenia();
            String nombreUsuario =u.getNombre();
            String contraseniaUsuario =u.getContrasenia();
            if (nombreUsuario.equals(nombreBuscado) && (contraseniaUsuario.equals(contraseniaBuscado))){return true;}
                else {return false;}} else {return false;}
    }
    
    /***/
    private Usuario getByName(String nombre){
        Usuario ubuscado = null;
        connection = cox.getConnection();
        String sent = "Select * from basededatosnegocio.usuario WHERE nombre = '"+nombre+"';";
        try {            
            preparedStatement = connection.prepareStatement(sent);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            ubuscado = new Usuario(resultSet.getInt("idusuario"),resultSet.getString("nombre"),resultSet.getString("contrasenia"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ubuscado;
    }
    
    
    
    
}
