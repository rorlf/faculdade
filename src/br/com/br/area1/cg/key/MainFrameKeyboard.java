/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg.key;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author oberdan
 */
public class MainFrameKeyboard extends JFrame{
    public MainFrameKeyboard(){
        setTitle("Java 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CanvasPanelKeyboard());
        setSize(800, 600);
        setLocationRelativeTo(null);
    } 
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MainFrameKeyboard().setVisible(true);
            }
        });
    }


}
