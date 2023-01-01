/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4_ld_app;

import java.text.DecimalFormat;
import java.util.ArrayList;
//  By: RETBOT
/**
 *
 * @author rober
 */
public class Calculos {
    private static DecimalFormat fNumero = new DecimalFormat("#.###");
    private static int pesoEleva = 0;

    public static int getPesoEleva() {
        return pesoEleva;
    }

    public static void setPesoEleva(int pesoEleva) {
        Calculos.pesoEleva = pesoEleva;
    }

    // Calcular el tiempo de espera 
    public static double tmpEspera(int llamadaElevador, int posElevador){
        // Si el elevador se encuentra por debajo del piso de la llamada y se calcula la distancia
        double tmpEspera = (llamadaElevador - posElevador) / 15.0 + 0.06 ;
        
        // pero si el tiempo de espera es negativo
        if(tmpEspera < 0){ // entonces el elevador se encuentra por arriba de la llamada y se calcula la distanciia
             tmpEspera = (posElevador - llamadaElevador) / 15.0 + 0.06 ;
        }
        return tmpEspera;
    }
    
    // Tiempo de viaje
    public static double tmpViaje(int llamadaElevador, int destinollamada){
        double distancia = llamadaElevador - destinollamada;
        
        if(distancia < 0){ // entonces el elevador se encuentra por arriba de la llamada y se calcula la distanciia
             distancia = destinollamada - llamadaElevador;
        }  
        //  By: RETBOT
        double tmpViaje = distancia/15 + 0.06;
        
        return tmpViaje;
    }
    
    // carga elevador
    public static double carga(int personas){
        if (pesoEleva >= 0 && pesoEleva <4) {
            if(pesoEleva-personas > 2) {
                pesoEleva = 4;
            } else {
            pesoEleva +=personas;
            }
        }
        double cPersona = pesoEleva/4.0;
        return cPersona;
    }
    
    // Calcular el tiempo de espera 
    public static double disViaje(int llamadaElevador, int posElevador){
        // Si el elevador se encuentra por debajo del piso de la llamada y se calcula la distancia
        double disViaje = (llamadaElevador - posElevador) / 15.0 + 0.06 ;
        
        // pero si la distancia de espera es negativa
        if(disViaje < 0){ // entonces el elevador se encuentra por arriba de la llamada y se calcula la distanciia
             disViaje = (posElevador - llamadaElevador) / 15.0 + 0.06 ;
        }//  By: RETBOT
        return disViaje;
    }
    
    // carga elevador actual
    public static double cargaActual(int peso){
        double cPersona = peso/4.0;
        return cPersona;
    }
    
    public static String resultadosP(int piso, double tmpEsperas, double tmpViajes,
                               double cargas, double distViaje, double cargaActual){
       String result = "\nPiso " + piso +"\n"
                +"tmpEspera: " + fNumero.format(tmpEsperas) + "\n"
                + "tmpViaje: " + fNumero.format(tmpViajes) + "\n"
                + "carga: " + fNumero.format(cargas) + "\n"
                + "disViaje: "+fNumero.format(distViaje) +"\n"
                + "cargaPiso: "+fNumero.format(cargaActual) +"\n";
       return result;
    }
    
    public static String membresiaS(String nomMenbresia, String [] membresia){
        String result = nomMenbresia+"\n";
       
        for(int i = 0; i < membresia.length; i++){
            result += membresia[i] + "\n";
        }
        return result;
    }
    //  By: RETBOT
    public static String [][] membresiaResultado(String [] membresia){
        String [][] resu = new String[membresia.length][2];
        for(int i=0; i<membresia.length; i++){
            String[] newStr = membresia[i].split("\\s+");
            for (int j = 0; j < newStr.length; j++) {
                resu[i][j] = newStr[j];
            }
        }
       return resu;
    }
 
    public static String [][] calReglas(String[][] membresiaTmpEspera, String[][] membresiaTmpViajes,
            String[][] membresiaCarga, String[][] membresiaDisViaje, String[][] membresiaCargaPactual){
        
        String[] resultAux = new String[2];
        
        String tmpEspera = "", tmpViaje = "", carga = "", disViaje = "", cargaPiso = "";
        double valTmpEspera = 0, valTmpViaje = 0, valCarga = 0, valDisViaje = 0, valCargaPiso = 0;
        boolean visTmpEspera = false, visTmpViaje = false, visCarga = false, visDisViaje = false, visCargaPiso = false;
        
        int val = 1;
        if(membresiaTmpEspera.length > 1 || membresiaTmpViajes.length > 1 ||
           membresiaCarga.length > 1 || membresiaDisViaje.length > 1 || 
                membresiaCargaPactual.length > 1)
            val = 2;
        
        String[][] result = new String[val][2];
        //  By: RETBOT
        for(int i=0; i<val; i++){
            if(membresiaTmpEspera.length <= 1){
                if(!visTmpEspera){
                    valTmpEspera = Double.parseDouble(membresiaTmpEspera[i][0]);
                    tmpEspera = membresiaTmpEspera[i][1];
                    visTmpEspera = true;
                }
            } else if (membresiaTmpEspera.length > 1){
                valTmpEspera = Double.parseDouble(membresiaTmpEspera[i][0]);
                tmpEspera = membresiaTmpEspera[i][1];
            }
            
            if(membresiaTmpViajes.length <= 1){
                if(!visTmpViaje){
                    valTmpViaje = Double.parseDouble(membresiaTmpViajes[i][0]);
                    tmpViaje = membresiaTmpViajes[i][1];
                    visTmpViaje = true;
                }
            } else if (membresiaTmpViajes.length > 1){
                valTmpViaje = Double.parseDouble(membresiaTmpViajes[i][0]);
                tmpViaje = membresiaTmpViajes[i][1];
               
            }
            
            if(membresiaCarga.length <= 1){
                if (!visCarga) {
                    valCarga = Double.parseDouble(membresiaCarga[i][0]);
                    carga = membresiaCarga[i][1];
                    visCarga = true;
                }
            } else if (membresiaCarga.length > 1){
                valCarga = Double.parseDouble(membresiaCarga[i][0]);
                carga = membresiaCarga[i][1];
                
            }
            
            if(membresiaDisViaje.length <= 1){
                if (!visDisViaje) {
                    valDisViaje = Double.parseDouble(membresiaDisViaje[i][0]);
                    disViaje = membresiaDisViaje[i][1];
                    visDisViaje = true;
                }
            } else if (membresiaDisViaje.length > 1){
                valDisViaje = Double.parseDouble(membresiaDisViaje[i][0]);
                disViaje = membresiaDisViaje[i][1];
            }
            
            if(membresiaCargaPactual.length <= 1){
                if (!visCargaPiso) {
                    valCargaPiso = Double.parseDouble(membresiaCargaPactual[i][0]);
                    cargaPiso = membresiaCargaPactual[i][1];
                    visCargaPiso = true;
                }
            } else if (membresiaCargaPactual.length > 1) {
                valCargaPiso = Double.parseDouble(membresiaCargaPactual[i][0]);
                cargaPiso = membresiaCargaPactual[i][1];
                //  By: RETBOT
            }
            System.out.println("\nval "+(i+1));
            System.out.println("tmpEspera = "+tmpEspera);
            System.out.println("tmpViaje = "+tmpViaje);
            System.out.println("carga = "+carga);
            System.out.println("disViaje = "+disViaje);
            System.out.println("disViaje = "+cargaPiso);
            
            resultAux = Reglas.Reglas(tmpEspera, valTmpEspera, 
                    tmpViaje, valTmpViaje, 
                    carga, valCarga, 
                    disViaje, valDisViaje, 
                    cargaPiso, valCargaPiso);
            
            
            for(int j = 0; j<2; j++){
                result[i][j] = resultAux[j];
                System.out.println("Result = "+result[i][j] +"\n");
            }
        }
        //  By: RETBOT
        
        return result;
    }
}
