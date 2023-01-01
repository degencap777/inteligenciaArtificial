/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4_ld_app;

/**
 *
 * @author rober
 */
public class Reglas {
    
    
    public static String [] Reglas(String reglaTmpEspera, double vReglaTmpEspera, 
                                   String reglaTmpViaje, double vReglaTmpViaje, 
                                   String reglaCarga, double vReglaCarga,
                                   String reglaDisViaje, double vReglaDisViaje,
                                   String reglaCargaPesoActual, double vReglaCargaPesoActual){
        
        String resRegla [] = new String[2];
        // 1
        // Si el tiempo de espera es bajo, el tiempo de viaje es bajo, la carga es ligera
        // la distancia de viaje es baja y la carga del piso actual es ligera, 
        // la prioridad es alta
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        // 2
        // Si el tiempo de espera es bajo, el tiempo de viaje es bajo, la carga es ligera
        // la distancia de viaje es baja y la carga del piso actual es medio, 
        // la prioridad es alta
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 3
        // Si el tiempo de espera es bajo, el tiempo de viaje es bajo, la carga es ligera
        // la distancia de viaje es baja y la carga del piso actual es pesado, 
        // la prioridad es alta
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 4
        // Si el tiempo de espera es bajo, el tiempo de viaje es bajo, la carga es ligera
        // la distancia de viaje es medio y la carga del piso actual es ligera, 
        // la prioridad es alta
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 5
        // Si el tiempo de espera es bajo, el tiempo de viaje es bajo, la carga es ligera
        // la distancia de viaje es alto y la carga del piso actual es ligera, 
        // la prioridad es alta
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 6
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 7
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 8
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 9
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesada")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Pesado") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }

        
        // 10
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 11
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 12
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 13
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 14
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 15
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Alta";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 16
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 17
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 18	
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }// 18	
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 19
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 20 				
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 21 				
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 22									
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }

        // 23							
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 24										
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 25									
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 26															
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 27														
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 28													
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 29														
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 30								
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 31										
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Medio") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //32										
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 33														
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 34													
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Ligera") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Alto") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Media";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 35																			
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Ligero")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Medio") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Medio")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        if(reglaTmpEspera.equals("Medio") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Medio") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 36																								
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //37																							
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
       
        
        //38																			
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //39																						
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //40																			
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
       
        //41																				
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
       
        //42																					
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
       
        //43																						
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
       
        //44																		
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
       
        //45																				
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //46																	
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //47																	
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Ligera")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //48																			
        if(reglaTmpEspera.equals("Bajo") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //49																			
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Bajo") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //50																			
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Ligera") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        //51					
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Bajo") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        
        // 52					
        if(reglaTmpEspera.equals("Alto") && reglaTmpViaje.equals("Alto") && reglaCarga.equals("Pesado") && reglaDisViaje.equals("Alto") && reglaCargaPesoActual .equals("Pesado")){
            resRegla[0] = "Baja";
            resRegla[1] = FuzzyLogic.OperadorAnd(vReglaTmpEspera, 
                    FuzzyLogic.OperadorAnd(vReglaTmpViaje, 
                    FuzzyLogic.OperadorAnd(vReglaCarga, 
                    FuzzyLogic.OperadorAnd(vReglaDisViaje,vReglaCargaPesoActual)))) + "";
        }
        return resRegla;
    }
}
