/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;


import modelo.dao.GenericDAO;
import modelo.pojo.*;
import vistaInicio.VistaLogIn;

/**
 *
 * @author Nico
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        GenericDAO genericDAO = new GenericDAO();
        Cliente contactoRecuperado;
        
        
        VistaLogIn vista = new VistaLogIn();
       // vista.setVisible(true);

        //Creamos tes instancias de Contacto  (int codCliente, String nombre, String direccion, String codigoPostal, String telefono, String dni, Double saldo
        Cliente cliente1 = new Cliente("Pedro", "dr clark 385", "3260", "86484",15531,1.2,51.0);
        Cliente cliente2 = new Cliente("Manuel", "dr clark 385", "3260", "86484",15531,1.2,51.0); 
        Cliente cliente3 = new Cliente("Martin", "dr clark 385", "3260", "86484",15531,1.2,51.0);
        Cliente cliente4 = new Cliente("Josecito", "dr clark 385", "3260", "86484",15531,1.2,51.0);
        Fecha date = new Fecha();
        
        Producto produc1 = new Producto("Mate", "Un mate con y sin yerba",date.getTimeDate() , 18.2, 5, 2, 4, 7, true, date.getTimeDate());
        
        genericDAO.save(produc1);
        System.out.println("ta");
        vista.setVisible(true);
        //List<Cliente> listaContactos = clienteDAO.obtenListaContactos();

        //for(Cliente c : listaContactos)
        //{System.out.println("-> " + c.getNombre());
        //} 
    }     
}
