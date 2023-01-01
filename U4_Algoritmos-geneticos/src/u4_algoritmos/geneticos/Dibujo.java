/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4_algoritmos.geneticos;
//  By: RETBOT
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RETBOT
 */

// Clase Dibujo creada para crear figuras y el tablero 
public class Dibujo {

    // metodo para dibujar el robot en el tablero 
    public static void dibujarElefante(int x, int y, 
                                    int piernas, int orejas,
                                    int colmillos,
                                    int trompa,
                                    Component componente){
        // Librería Graphics utilizada para crear los dibujos sobre el tablero.
        Graphics hoja = componente.getGraphics();
        // Establecemos el color del elefante #a0cadb
        // "borrando"
        hoja.setColor(componente.getBackground());
        hoja.fillRect(0, 0, componente.getWidth(), componente.getHeight());
        
        Color colorCuerpo = new Color(160,202,219);
        hoja.setColor(colorCuerpo); // Cuerpo Relleno 
        hoja.fillArc(x+10, y, componente.getWidth()/2, componente.getHeight()/2+50, 0, 180);
        hoja.fillOval(x-30, y-10, 50, 60);
        hoja.fillOval(x, y-15, componente.getWidth()/6, componente.getHeight()/7);
        //  By: RETBOT
        hoja.fillRect(x+113, y+70, 20, 40+piernas); // patas traseras
        hoja.fillRect(x+93, y+70, 20, 30+piernas);
        
        hoja.fillRect(x+20, y+70, 20, 40+piernas); // patas delanteras
        hoja.fillRect(x+10, y+70, 20, 30+piernas);
       
        hoja.fillRect(x+125, y+35, 20, 5); // colita
        hoja.fillRect(x+140, y+35, 5, 40); 
        hoja.fillArc(62, 33, 40, 60, -140, 290);// oreja
        // tropma
        hoja.fillArc(30, 30, 30+trompa, 100+trompa, -200, 150); 
        
        hoja.setColor(Color.BLACK);
        // Cuerpo
        hoja.drawArc(x+10, y, componente.getWidth()/2, componente.getHeight()/2+50, 0, 120); // Cuerpo
        hoja.drawArc(x+10, y, componente.getWidth()/2, componente.getHeight()/2+50, 160, 20); // Cuerpo
        hoja.drawLine(75, 90, 75, 98);
        hoja.drawLine(100, 120, 160, 120);
       
        hoja.drawLine(195, 120, 195, 155+piernas); // patas traseras
        hoja.drawLine(174, 156+piernas, 195, 156+piernas); // patas traseras
        hoja.drawLine(174, 120, 174, 156+piernas); // patas traseras
        hoja.drawLine(154, 120, 154, 146+piernas); // patas traseras
        hoja.drawLine(154, 146+piernas, 174, 146+piernas); // patas traseras
        
        hoja.drawLine(100, 120, 100, 155+piernas); // patas delanteras
        hoja.drawLine(81, 156+piernas, 100, 156+piernas); /// patas delanteras
        hoja.drawLine(81, 120, 81, 156+piernas); /// patas delanteras
        hoja.drawLine(70, 120, 70, 146+piernas); /// patas delanteras
        hoja.drawLine(70, 146+piernas, 81, 146+piernas); /// patas delanteras
        
        hoja.drawLine(185, 81, 205, 81); /// cola
        hoja.drawLine(206, 81, 206, 121); /// cola
        hoja.drawLine(200, 121, 205, 121); /// cola
        hoja.drawLine(200, 87, 200, 121); /// cola
        hoja.drawLine(186, 87, 200, 87); /// cola
        //  By: RETBOT
        hoja.drawArc(62, 33, 40, 50+orejas, -140, 290);// oreja
        // tropma
        hoja.drawArc(30, 30, 30+trompa, 100+trompa, -200, 150);
        
        hoja.drawArc(32, 38, 50, 50, 60, 120);//cabeza
        
        hoja.setColor(Color.WHITE);
        //hoja.fillArc(25, 45, 40, 70, -100, 100);// 
        // x coordinates of vertices
        int xP[] = {3+colmillos, 5, 10, 20, 30, 40, 50, 50, 40, 30, 3+colmillos};
        // y coordinates of vertices
        int yP[] = {60+colmillos, 70, 80, 85, 90, 90, 85, 75, 75, 75, 60+colmillos};
        // draw the polygon using drawPolygon function
        hoja.fillPolygon(xP, yP, xP.length);
        hoja.fillOval(45, 55, 10, 10); //ojo
        
        hoja.setColor(Color.BLACK);
        hoja.fillOval(45, 57, 5, 5); // ojo 
        hoja.drawPolygon(xP, yP, xP.length);
        // trompa
        hoja.drawLine(45, 90, 55+trompa, 120+trompa);
        
        hoja.drawArc(45, 75, 30, 20, -150, 140);
        //  By: RETBOT
        
    }
}
       
    
 
