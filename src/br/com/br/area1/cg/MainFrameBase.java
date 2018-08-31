/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg;

import br.com.br.area1.cg.key.CanvasPanelKeyboard;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author oberdan
 */
public class MainFrameBase extends JFrame{
    public MainFrameBase(){
        setTitle("Java 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         add(new CanvasPanelBase());
        setSize(800, 597);
        setLocationRelativeTo(null);
    } 
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MainFrameBase().setVisible(true);
            }
        });
    }


}
