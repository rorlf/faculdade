/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg.key;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author oberdan
 */
public class CanvasPanelKeyboard extends JPanel implements Runnable{
    double px, py;
    private Image hamster;
    private boolean[] key_states = new boolean[256];
    
    public CanvasPanelKeyboard(){
        setDoubleBuffered(true);
        setFocusable(true);
        load();
        new Thread(this).start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    @Override
    public void run(){
        double btime, dtime = 0;
        btime = System.currentTimeMillis();
        while(true){
            update(dtime/1000);
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            dtime = (System.currentTimeMillis() - btime);
            btime = System.currentTimeMillis();
        }
    }
    
    private void load(){
        addKeyListener(new KeyboardAdapter());
    }

    private void update(double dt){
         if (key_states[KeyEvent.VK_RIGHT]){
                px = px + (100 * dt);
         }else if (key_states[KeyEvent.VK_UP]){
                py = py - (100 * dt);
         }
         
    }

    private void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Ellipse2D.Double(px, py, 100, 100));
    }
    
    private class KeyboardAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e){
            key_states[e.getKeyCode()] = false;
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            key_states[e.getKeyCode()] = true;
        }
    }
    
 }
