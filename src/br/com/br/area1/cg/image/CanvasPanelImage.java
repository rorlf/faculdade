/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author oberdan
 */
public class CanvasPanelImage extends JPanel{
    private Image hamster;
    
    public CanvasPanelImage(){
        setDoubleBuffered(true);
        setFocusable(true);
        load();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
            
    private void load(){
        setBackground(Color.BLACK);
        hamster = new ImageIcon(this.getClass().
        getResource("hamster.png")).getImage();
    }

    private void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(hamster, 200, 200, this);
    }
    
 }
