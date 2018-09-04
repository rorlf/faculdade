/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg;

import br.com.br.area1.cg.key.CanvasPanelKeyboard;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author oberdan
 */
public class CanvasPanelBase extends JPanel implements Runnable{
     
     private Image cenario,nuvem,montanha,tunel,moeda,mario,mariod,bicho,bichod,mariomorto;
     private int count=0,jumping=0,caindo=0,moeda1=1,moeda2=1,moeda3=1,moeda4=1,vivo=1,emcima=0,lado=0,ladog=0,bichomov=0,vidabicho=1;   
     double px=0, py=0,gx;
    
    private boolean[] key_states = new boolean[256];
     
     
    public CanvasPanelBase(){
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
        addKeyListener(new CanvasPanelBase.KeyboardAdapter());
        setBackground(Color.cyan);
        cenario = new ImageIcon(this.getClass().getResource("/imagens/mario_ground.png")).getImage();
        nuvem = new ImageIcon(this.getClass().getResource("/imagens/mario_cloud.png")).getImage();
        montanha = new ImageIcon(this.getClass().getResource("/imagens/mario_background.png")).getImage();
        tunel = new ImageIcon(this.getClass().getResource("/imagens/mario_pipe.png")).getImage();
        moeda = new ImageIcon(this.getClass().getResource("/imagens/coin.png")).getImage();
        mario = new ImageIcon(this.getClass().getResource("/imagens/mario.png")).getImage();
        mariod = new ImageIcon(this.getClass().getResource("/imagens/mario_direita.png")).getImage();
        bicho = new ImageIcon(this.getClass().getResource("/imagens/goomba.png")).getImage();
        bichod = new ImageIcon(this.getClass().getResource("/imagens/goombad.png")).getImage();

        mariomorto = new ImageIcon(this.getClass().getResource("/imagens/mariodown.png")).getImage();
       



    }

    private void update(double dt){  
                

        if(vivo==1){
        if (key_states[KeyEvent.VK_RIGHT]){
            if(limiteDireita()){
                px =  (px +(125 * dt));
                lado=1;
                
            }
         }
        if (key_states[KeyEvent.VK_UP]){
            if(caindo==0){
               jumping =1;
            }
         }
//        if (key_states[KeyEvent.VK_DOWN]){
//             py =  (py + (100 * dt));
//         }
        if(key_states[KeyEvent.VK_LEFT]){
           if(limiteEsquerda()){
            px =  (px -(125 * dt));
            lado=0;
           }
         }
            
        
        
          if( px<-250 &&   py>=-68  && py<-66 && emcima==1){
          emcima=0;           
          caindo =1;        
        }
           if( px>-129 &&   py>=-68  && py<-66 && emcima==1){
          emcima=0;           
          caindo =1;        
        }
           
           if( px<-129 && px>-250 &&   py>=-68  && py<-66 ){
          emcima=1;    
        
        }
        
        if (jumping==1 ){
        if(py>(-100)){
           py =  (py - (100 * dt));         
        }
        if(jumping==1 && py<=(-100) ){
            jumping =0;
            caindo=1;
        }
        }
        
        if (caindo ==1 && emcima==0){
         if(py<0){
           py =  (py + (150 * dt));         
        }
         if(py>=0){
         caindo=0;
         }
        }
        
         if (caindo ==1 && emcima==1){
         if(py<0){
           py =  (py + (150 * dt));         
        }
         if(py>=-68  && py<-66){
         caindo=0;
         }
        }
        
         
        
           
          
         
        if( px<-258 && px>-300 &&   py>=-93  && py<-73 && moeda1==1){
        count=count+1;
        moeda1=0;
        play("/music/coin");
        }
         if( px<-320 && px>-370 &&   py>=-93  && py<-73 && moeda2==1){
        count=count+1;
        moeda2=0;
                play("/music/coin");

        }
         
           if( px<-520 && px>-570 &&   py>=-93  && py<-73 && moeda3==1){
        count=count+1;
        moeda3=0;
                play("/music/coin");

        }
               
         if( px<-575 && px>-625 &&   py>=-93  && py<-73 && moeda4==1){
        count=count+1;
        moeda4=0;
                play("/music/coin");

        }
         
         
//         g2d.drawImage(tunel, 450,350, this);
//         g.drawImage(mario, (680+horizontal), (373+vertical), w, h, null);
//         g.drawImage(bicho, 250, 385,w2, h2, null);
//          if( px<-405 && px>-467 &&   py>=-43  && py<10 && vivo==1){
//        vivo=0;
//        }

if(vidabicho==1){
 double localg=(int)gx+250;
 double localm=(int)px+680;

   if( (localg<=(localm+35) && localg>=(localm-30)) && py<-28 &&py>-29 && vivo==1){
        vidabicho=0;
        jumping=1;
        caindo=0;
        } 
            if( (localg<=(localm+35) && localg>=(localm-27)) && py>=-28 && vivo==1 && vidabicho==1){
        vivo=0;
        }
            
        
          
          if(gx<=182 && bichomov == 0){
          gx =  (gx + (85 * dt));
          ladog=0;
          }
          
          if(gx>=181){
             bichomov=1;
          }
          
           if(gx<=182 && bichomov==1){
          gx =  (gx - (85 * dt)); 
          ladog=1;
          }
             if(gx<=-181){
             bichomov=0;
          }
          } 
           
          
          
        }
        
    }

    private void draw(Graphics g){
        int x =  0;
        int x2 =  0;
        Font myFont = new Font ("Arial", 1, 20);  
         Font gameover = new Font ("Arial", 1, 72);
        int w =  (mario.getWidth(null)+17);
        int h =  (mario.getHeight(null)+17);
         int w2 =  (mario.getWidth(null)+6);
        int h2 =  (mario.getHeight(null)+6);        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.setFont(myFont);
        g2d.drawString("X", 55, 40);        
        g2d.drawString(String.valueOf(count), 80, 40);
        
        
      
        g2d.drawImage(nuvem, 120,10, this);
         
        while(x2<=770){
        g2d.drawImage(montanha, x2, 174, this);
         x2= x2+256;
        }
        g2d.drawImage(tunel, 450,350, this);
          while(x<=770){
        g2d.drawImage(cenario, x, 430, this);
       x= x+128;
        }
          
          g2d.drawImage(moeda, 24,18, this);
          
          if(moeda4==1){
        g2d.drawImage(moeda, 95,290, this);
          }
          
        if(moeda3==1){
        g2d.drawImage(moeda, 150,290, this);
        }
        
        if(moeda2==1){
        g2d.drawImage(moeda, 350,290, this);
        }
        
        if(moeda1==1){
        g2d.drawImage(moeda, 410,290, this);
        }
        
        if(vidabicho==1){
        int horizontalg = (int)gx;
        
        g.drawImage(ladog(), (250+horizontalg), 385,w2, h2, null);
}
        
        
        int horizontal = (int)px;
        int vertical = (int)py;
        
        
        if(vivo==1){
        g.drawImage(lado(), (680+horizontal), (373+vertical), w, h, null);
        }
        if(vivo==0){
        g.drawImage(mariomorto, (680+horizontal), (373+vertical), w, h, null);
        g2d.setColor(Color.BLACK);
        g2d.setFont(gameover);
        g2d.drawString("GAME OVER", 195, 250);
        
        }
        

        
        

    }

    private Image lado() {
        if(lado == 1){
   return mariod;
   }
   else{
   return mario;
   } 
    }
    
    private Image ladog() {
        if(ladog == 1){
   return bicho;
   }
   else{
   return bichod;
   } 
    }

    private boolean limiteEsquerda() {
        if(px<-129&& px>-130 && py>-66){
        return false;
        }
        else
            return true;
    }
    
      private boolean limiteDireita() {
        if(px<-250&& px>-251 && py>-66){
        return false;
        }
        else
            return true;
    }

    private void play(String nome) {
        URL url = getClass().getResource(nome+".wav");
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
        
    }
    
    
   
    
    public class KeyboardAdapter extends KeyAdapter{
    
    
    public void keyReleased(KeyEvent e){
        key_states[e.getKeyCode()] = false;
    }
    
    public void keyPressed(KeyEvent e){
        key_states[e.getKeyCode()] = true;
    }
    
  
    

}
    
 }
