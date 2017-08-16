/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.inicio;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import modelo.dao.GenericDao;
import modelo.pojo.*;
/**
 *
 * @author Nico
 */
public class JProgressBarTest {
    private static GenericDao genericDAO = new GenericDao();
    private static List<Cliente> listaCliente;
    private static List<Producto> listaProducto;
    private static List<Proveedor> listaProveedor;
    private static List<Usuario> listaUsuario;

    public static void main(final String[] args) {
        UIManager.put("ProgressBar.background", Color.WHITE);
        UIManager.put("ProgressBar.foreground", Color.GREEN);
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
        final JProgressBar progressBar = new JProgressBar();
        VistaLogIn vlg = new VistaLogIn();
        
    

        new JFrame() {
        {
            getContentPane().setLayout(new FlowLayout());
            getContentPane().add(progressBar);
            progressBar.setStringPainted(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 200);
            setLocationRelativeTo(null);
            setVisible(true);
            progressBar.setValue(0);
            for (int i = 0; i <= 100; i++){
                try {
                    inicializarPrograma(i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JProgressBarTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                progressBar.setValue(i);}
            setVisible(false);
            vlg.setVisible(true);
            dispose();
            
        }
    };
        }
    
    private static void inicializarPrograma(int i) throws InterruptedException{
        switch (i){
            case 1:setListaCliente(); break;
            case 2:setListaProducto(); break;
            case 3:setListaProveedor(); break;
            case 4:setListaUsuario(); break;
            default:Thread.sleep(15); break;
        }
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }
    
    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    private static void setListaCliente() {
        JProgressBarTest.listaCliente = genericDAO.getAll(Cliente.class);
    }

    private static void setListaProducto() {
        JProgressBarTest.listaProducto = genericDAO.getAll(Producto.class);
    }

    private static void setListaProveedor() {
        JProgressBarTest.listaProveedor = genericDAO.getAll(Proveedor.class);
    }

    private static void setListaUsuario() {
        JProgressBarTest.listaUsuario = genericDAO.getAll(Usuario.class);
    }
    
    
    
    
}
