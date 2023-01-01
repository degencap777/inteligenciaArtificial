/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4_ld_app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rober//  By: RETBOT
 */
public class Dibujo {
    public static void dibujarEdificio(Component componente){
        Graphics hoja = componente.getGraphics();
        
        hoja.setColor(componente.getBackground());
        hoja.fillRect(0, 0, componente.getWidth(), componente.getHeight());
        
        hoja.setColor(Color.BLACK);
        hoja.drawLine(0, 50, componente.getWidth(), componente.getHeight()/2); 
        for (int i = 50; i <= 700; i+=50) {
            hoja.drawLine(i,0, i, componente.getHeight());
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dibujo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void dibujarElevador(int x, int y,Component componente){
        Graphics hoja = componente.getGraphics();
        
        hoja.setColor(Color.GRAY);
        hoja.fillRect(x, y, 50, 50);

        hoja.setColor(Color.DARK_GRAY);
        hoja.fillRect(x, y+20, 10, 10);
        
        hoja.setColor(Color.BLACK);
        hoja.drawRect(x, y, 50, 50);
        hoja.drawLine(x + 25, y, x+25, y+50);
        hoja.drawRect(x, y+20, 10, 10);
        
        hoja.fillOval(x+2, y+20, 5, 5);
        hoja.fillOval(x+2, y+25, 5, 5);
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dibujo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     //  By: RETBOT
     public static void dibujarPersona(int x, int y,Component componente){
        Graphics hoja = componente.getGraphics();
        
        hoja.setColor(Color.BLACK);
        hoja.drawLine(x + 25, y+25, x+25, y+40);
        hoja.drawLine(x + 15, y+45, x+25, y+40);
        hoja.drawLine(x + 35, y+45, x+25, y+40);
        hoja.drawLine(x + 10, y+25, x+40, y+25);
        hoja.drawOval(x+19, y+10, 15, 15);

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dibujo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//  By: RETBOT
