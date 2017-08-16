/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.pojo.Cliente;

/**
 *
 * @author Nico
 */
public class ProductoService {
    
    GenericDao gen = new GenericDao();
    
    private List<Cliente> listaCliente = gen.getAll(Cliente.class);
    
    public Object[] getClienteForARow(Cliente c){
        Object[] fila = new Object[6]; 
        fila[0]= c.getCodigo();
        fila[1]= c.getNombre();
        fila[2]= c.getDireccion();
        fila[3]= c.getCp();
        fila[4]= c.getTelefono();
        fila[5]= c.getSaldo(); 
        return fila;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }
}
