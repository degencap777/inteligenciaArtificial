/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4_ld_app;

import java.awt.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
//  By: RETBOT
/**
 *
 * @author yo
 */
public class FuzzyLogic extends Thread implements Runnable{

    private JPanel dibujo;
    private int x = 1;
    private int prioridades = 1;
    private boolean termino = false;
    private int pesoEnElevador = 0;

    ArrayList<Double> valoresPrioridades = new ArrayList<>();
    ArrayList<Integer> valoresLlamadas = new ArrayList<>();
    ArrayList<Integer> valoresDestinos = new ArrayList<>();
    
    @Override
    public void run() {
        while(true)
         while(!termino)
            movimientoElevador(); 
    }

    public void agregarValor(double prioridad, int llamada, int destino){
       valoresPrioridades.add(prioridad);
       valoresLlamadas.add(llamada);
       valoresDestinos.add(destino);
       
       ordenarPrioridad();
    }
    //  By: RETBOT
    private void ordenarPrioridad(){
        double prioridad;
        int piso;
        for(int i = 1; i < valoresPrioridades.size(); i++){
            for (int j=0 ; j < valoresPrioridades.size() - 1; j++){
                // Si la prioridad es mayor
                if (valoresPrioridades.get(j) < valoresPrioridades.get(j+1)){
                    // prioridad
                    prioridad = valoresPrioridades.get(j);
                    valoresPrioridades.set(j, valoresPrioridades.get(j+1));
                    valoresPrioridades.set(j+1, prioridad);
                    
                    // llamada elevador
                    piso = valoresLlamadas.get(j);
                    valoresLlamadas.set(j, valoresLlamadas.get(j+1));
                    valoresLlamadas.set(j+1, piso);
                }
            }
        }
        termino = false;
    }
    
    public void setOtraPriori(){
        prioridades++;
    }

    public FuzzyLogic(JPanel dibujo) {
        this.dibujo = dibujo;
    }
    
    public boolean getTermino() {
        return termino;
    }

    public void setTermino(boolean termino) {
        this.termino = termino;
    }
    
    private void movimientoElevador(){
        if(!valoresPrioridades.isEmpty()){
         for(int a=0; a<valoresPrioridades.size(); a++){
            int llamada = valoresLlamadas.get(a);
            int destino = valoresDestinos.get(a);
            
            if (x != llamada) {
                if (x < llamada) {
                    for (; x < llamada; x++) {
                        Dibujo.dibujarEdificio(dibujo);
                        //x = piso en donde se encuentra el elevador
                        //y = posicion del elevador
                        // x+= 50 para ir del piso 15 al 14 ....
                        Dibujo.dibujarElevador(deXaPixeles(x), 0, dibujo);

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FuzzyLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Pos elevador = "+(x+1));
                    }
                } else if(x > llamada) {
                    x--;
                    for (; x >= llamada; x--) {
                        Dibujo.dibujarEdificio(dibujo);
                        //x = piso en donde se encuentra el elevador
                        //y = posicion del elevador
                        // x+= 50 para ir del piso 15 al 14 ....
                        Dibujo.dibujarElevador(deXaPixeles(x), 0, dibujo);
                        
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FuzzyLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Pos elevador = "+(x+1));
                    }
                }//  By: RETBOT
            }
            
        if (x != destino) {
          if(x <= destino){
            for (; x < destino; x++) {
                Dibujo.dibujarEdificio(dibujo);
                //x = piso en donde se encuentra el elevador
                //y = posicion del elevador
                // x+= 50 para ir del piso 15 al 14 ....
                Dibujo.dibujarElevador(deXaPixeles(x), 0, dibujo);

                try {
                    Thread.sleep(400);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FuzzyLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Pos elevador = "+(x+1));
            }
          } else if(x >= destino){
              x--;
              for (;destino >= x ; x--) {
                Dibujo.dibujarEdificio(dibujo);
                //x = piso en donde se encuentra el elevador
                //y = posicion del elevador
                // x+= 50 para ir del piso 15 al 14 ....
                Dibujo.dibujarElevador(deXaPixeles(x), 0, dibujo);

                try {
                    Thread.sleep(400);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FuzzyLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Pos elevador = "+(x+1));
            }
          }
         }
         valoresLlamadas.remove(a);
         valoresDestinos.remove(a);
         valoresPrioridades.remove(a);
         pesoEnElevador -= pesoEnElevador;
        }
         termino = true;
      }
    }
    
    private int deXaPixeles(int x){
        int valor = 0;
        for(int i=0; i<x; i++){
            valor += 50;
        }
        return valor;
    }

    public int getPesoEnElevador() {
        return pesoEnElevador;
    }

    public void setPesoEnElevador(int pesoEnElevador) {
        this.pesoEnElevador += pesoEnElevador;
    }

//  Membresia para el tiempo de espera, tiempo de viaje y distancia de viaje 
    public static String [] MembresiaTeTvDv(double valor){
        String [] resu = null;
        if (valor == 0.06) {
            resu = new String[1];
            resu[0] = 0.81 + " Bajo";
        } else if(valor == 0.12666666666666665) {
            resu = new String[1];
            resu[0] = 0.5 + " Bajo";
        } else if(valor == 0.19333333333333333) { 
            resu = new String[1];
            resu[0] = 0.37 + " Bajo";
        } else if(valor == 0.26) {
            resu = new String[2];
            resu[0] = 0.125 + " Bajo";
            resu[1] = 0.1875 + " Medio";
        } else if(valor == 0.32666666666666666) {
            resu = new String[1];
            resu[0] = 0.37 + " Medio";
        } else if(valor == 0.3933333333333333) {
            resu = new String[1];
            resu[0] = 0.7 + " Medio";
        } else if(valor == 0.46) {
            resu = new String[1];
            resu[0] = 0.875 + " Medio";
        } else if(valor == 0.5266666666666666) {
            resu = new String[1];
            resu[0] = 0.9 + " Medio";
        } else if(valor == 0.5933333333333333) {
            resu = new String[1];
            resu[0] = 0.7 + " Medio";
        } else if(valor == 0.6599999999999999) {
            resu = new String[1];
            resu[0] = 0.49 + " Medio";
        } else if(valor == 0.7266666666666666) {
            resu = new String[2];
            resu[0] = 0.124 + " Alto";
            resu[1] = 0.368 + " Medio";
        } else if(valor == 0.7933333333333332) {
             resu = new String[2];
            resu[0] = 0.062 + " Medio";
            resu[1] = 0.37 + " Alto";
        } else if(valor == 0.8600000000000001) {
            resu = new String[1];
            resu[0] = 0.55 + " Alto";
        } else if(valor == 0.9266666666666667) {
            resu = new String[1];
            resu[0] = 0.75 + " Alto";
        } else if(valor == 0.9933333333333334) {
            resu = new String[1];
            resu[0] = 0.9 + " Alto";
        }
        return resu;
    }
// Membresia para la carga y el peso destino de la llamada
    public static String [] MembresiaCDLL(double valor){
        String [] resu = null;
        if (valor == 0.25) {
            resu = new String[2];
            resu[0] = 0.1875 + " Ligera";
            resu[1] = 0.1875 + " Medio";
        } else if(valor == 0.5) {
            resu = new String[1];
            resu[0] = 1.0 + " Medio";
        }  else if(valor == 0.75) {
             resu = new String[2];
            resu[0] = 0.1875 + " Medio";
            resu[1] = 0.1875 + " Pesado";
        }  else if(valor == 1.0) {
            resu = new String[1];
            resu[0] = 1.0 + " Pesado";
        } 
        return resu;
    }
    
    public static double OperadorAnd(double a, double b) {
        return Math.min(a, b);
    }

    // Centroide
     public static Double Centroide(String p1, double inferencia) {
         double prioridad = 0.0;
          if (!p1.equals("")) {
            if (p1.contains("Baja")) {
                prioridad += inferencia * 0 / inferencia;
            } else if (p1.contains("Medio")) {
                prioridad += inferencia * 0.5 / inferencia;
            } else if (p1.contains("Alta")) {
                prioridad += inferencia * 1.0 / inferencia;
            }
        }
        return prioridad;
     }
    
    public static Double Centroide(String p1,double inferencia, String p2,  double inferencia2) {
        double prioridad = 0.0;

        if (!p1.equals("")) {
            if (p1.contains("Baja")) {
                prioridad += inferencia * 0.0 / inferencia;
            } else if (p1.contains("Media")) {
                prioridad += inferencia * 0.5 / inferencia;
            } else if (p1.contains("Alta")) {
                prioridad += inferencia * 1.0 / inferencia;
            }
        }
 
        if (!p2.equals("")) {
            if (p2.contains("Baja")) {
                prioridad += inferencia2 * 0.0 / inferencia2;
            } else if (p2.contains("Media")) {
                prioridad += inferencia2 * 0.5 / inferencia2;
            } else if ( p2.contains("Alta")) {
                prioridad += inferencia2 * 1.0 / inferencia2;
            }
        }
//  By: RETBOT
        return prioridad/2.0;
    }
        
    public JPanel getDibujo() {
        return dibujo;
    }

    public void setDibujo(JPanel dibujo) {
        this.dibujo = dibujo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }   
}
//  By: RETBOT
