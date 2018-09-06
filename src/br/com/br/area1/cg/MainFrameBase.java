/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
                    soundPlay("D:\\documentos\\NetBeansProjects\\faculdade\\src\\music\\mario_song.wav");

                new MainFrameBase().setVisible(true);
            }
        });
        
//        SwingUtilities.invokeLater(new Runnable(){
//            @Override
//            public void run(){
//                 URL url = getClass().getResource("/music/mario_song.wav");
//        AudioClip audio = Applet.newAudioClip(url);
//        audio.play();
//            }
//        });
               
      
    }
    
    public static void soundPlay(String soundName) { 
    try {
        AudioInputStream audioInputStream; 
        audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        
    } catch(Exception error) {           
        System.out.println("Error with playing sound."+error);
    }
}


}
