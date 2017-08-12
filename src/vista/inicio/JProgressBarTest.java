/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.inicio;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
/**
 *
 * @author Nico
 */
public class JProgressBarTest {

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
                    Thread.sleep(15);
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
}
