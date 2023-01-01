/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u4_algoritmos.geneticos;

import static java.lang.Math.floor;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rober//  By: RETBOT
 */
public class Calculos extends Thread {
    // ZONA DE DECLARACION DE VARIABLES
    private int cromosomas [][], nuevosCromosomas[][]; // Donde almacenaremos los cromosomas y los nuevos cromosomas
    private int cantCromo; // Cantidad de cromosomas
    private int fx[]; // fx
    private double fitness[], Probability[], probabilidadAcumulada[]; // fitness, probabilidad y la probabilidad acumulada
    private Random azar = new Random(); // Instanciamento de variable para generar numeros aleatorios
    // Instaniamiento de las partes a mutar del elefante.
    // Elefante 1
    private int piernasDibjo1 = 0, orejasDibjo1 = 0, colmillosDibjo1 = 0, proboscideDibjo1 = 0;
    // Elefante 2
    private int piernasDibjo2 = 0, orejasDibjo2 = 0, colmillosDibjo2 = 0, proboscideDibjo2 = 0;
    // Elefante 3
    private int piernasDibjo3 = 0, orejasDibjo3 = 0, colmillosDibjo3 = 0, proboscideDibjo3 = 0;
    // Elefante 4
    private int piernasDibjo4 = 0, orejasDibjo4 = 0, colmillosDibjo4 = 0, proboscideDibjo4 = 0;
    //------------------------------------------------------------------------------------------
    // Paneles en donde los elefantes estaran en constante redibujo
    private final JPanel jPanelElefante; // Panel del elefante 1
    private final JPanel jPanelElefante2; // Panel para el elefante 2
    private final JPanel jPanelElefante3; // Panel para el elefante 3
    private final JPanel jPanelElefante4; // Panel para el elefante 4
    private final JPanel jPanelElefante5; // Panel para el elefante 5
    private final JPanel jPanelElefante6; // Panel para el elefante 6
    private final JPanel jPanelElefante7; // Panel para el elefante 7
    private final JPanel jPanelElefante8; // Panel para el elefante 8
    
    // estados 
    private int ePierna = 3, eOreja = 3, eColmillos = 3, eProbo = 3;
    
    private final JLabel cicloActual; // Label en donde estaremos escribiendo el num de generaciones
    private int cicloActualval = 0; // Contador que llevara la cuenta del num de generaciones
    
    // Bandera para el cambio de velocidad
    private boolean velocidad = false;
    // Opciones para la parte superior, en menu//  By: RETBOT
    JMenuItem jMenuIniciar, jMenuPausar, jMenuReanudar;
    ///--------------------------------------------------------------------------------------------------
    // Construuctor parametrizado para inicializar las variables
     public Calculos(int[][] cromosomas, int[][] nuevosCromosomas, int cantCromo, int[] fx, 
            double[] fitness, double[] Probability, double[] probabilidadAcumulada, 
            int ePierna, int eOreja, int eColmillos, int eProbo, JLabel cicloActual,
            JMenuItem jMenuIniciar, JMenuItem jMenuPausar, JMenuItem jMenuReanudar,
            JPanel jPanelElefante, JPanel jPanelElefante2, JPanel jPanelElefante3, JPanel jPanelElefante4,
            JPanel jPanelElefante5, JPanel jPanelElefante6, JPanel jPanelElefante7, JPanel jPanelElefante8) {
        this.cromosomas = cromosomas;
        this.nuevosCromosomas = nuevosCromosomas;
        this.cantCromo = cantCromo;
        this.fx = fx;
        this.fitness = fitness;
        this.Probability = Probability;
        this.probabilidadAcumulada = probabilidadAcumulada;
        this.ePierna = ePierna;
        this.eOreja = eOreja;
        this.eColmillos = eColmillos;
        this.eProbo = eProbo;
        this.cicloActual = cicloActual;
        this.jMenuIniciar = jMenuIniciar;
        this.jMenuPausar = jMenuPausar;
        this.jMenuReanudar = jMenuReanudar;
        this.jPanelElefante = jPanelElefante;
        this.jPanelElefante2 = jPanelElefante2;
        this.jPanelElefante3 = jPanelElefante3;
        this.jPanelElefante4 = jPanelElefante4;
        this.jPanelElefante5 = jPanelElefante5;
        this.jPanelElefante6 = jPanelElefante6;
        this.jPanelElefante7 = jPanelElefante7;
        this.jPanelElefante8 = jPanelElefante8;
    }
    ///--------------------------------------------------------------------------------------------------
    ///--------------------------------------------------------------------------------------------------
    // Implementacion del metodo run, para inicializar el hilo
    @Override
    public void run(){
         do{//  By: RETBOT
            calculos(); // Invocamos a la clase calculo para que empieze el proceso
            if(velocidad){
                try {
                 Thread.sleep(100); // Si velocidad es = true, el delay sera solo de 100 ms
             } catch (InterruptedException ex) {
                 java.util.logging.Logger.getLogger(Calculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             }
            }else{
             try {
                 Thread.sleep(400); // Si velocidad es = a falso entonces el delay sera de 400 ms, por lo que ira mas lento.
             } catch (InterruptedException ex) {
                 java.util.logging.Logger.getLogger(Calculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             }
            }
        }while(validaciones());
         
         jMenuIniciar.setEnabled(true); // Se habilita el boton en del jmenu "Iniciar"
         // Se deshabilita el boton del jmenu "Pausar" ya que no hay algun proceso activo
         jMenuPausar.setEnabled(false);
         JOptionPane.showMessageDialog(null, "Mutación Exitosa :)");
    }
     //-----------------------------------------------------------------------
    // CLASE PARA REALIZAR LOS CALCULOS PERTINENTES DE FX, PROBABILIDAD, PROBABILIDAD ACTUMULADA, RANGO MIN-MAX,ETC.
    private void calculos(){
     System.out.println("\nf(x)");
     int fxResultado = 0; // inicializamos la variable resultado en 0 
      for(int i=0; i<cantCromo;i++){
            // Se hace el calculo mediante la siguiente formula
             // (a+2 * b+3 * c+4 * d)-30 
                fxResultado = (cromosomas[i][0]+2 * cromosomas[i][1]+3 * 
                               cromosomas[i][2]+4 * cromosomas[i][3])  -
                                30;
        // Se van almacenando en fx los resultados
        fx[i] = fxResultado;
            System.out.println("f("+(i+1)+"): "+fxResultado);
        }//  By: RETBOT
       //-----------------------------------------------------------------------
      // fitness
        System.out.println("\nfitness(i)"); // Separador en consola
        double fitnessResultado; // Instanciamiento de
        double total = 0.0;  // Variablex
        for(int i=0; i<cantCromo;i++){
            // Mediante la siguiente formula sacamos el resultado de fitness
             //  1 / (1+f(i))
                fitnessResultado = 1/(1.0+fx[i]);
                total += fitnessResultado;// se van acumulando en total
        fitness[i] = fitnessResultado; // guardamos en fitness los resultados
            System.out.println("fitness("+(i+1)+"): "+fitnessResultado); // Mandamos a imprimir solo para ir viendo los resultados con numeros
        }
       //-----------------------------------------------------------------------  
      // Probability[i] 
        System.out.println("\nProbability(i)"); // Separador en consola
        double ProbabilityResultado; //Instanciamos la variable
        
        for(int i=0; i<cantCromo;i++){
            // La formula para obtener la probabilidad es la siguiente : 
            // fitness[i]/total
            ProbabilityResultado = fitness[i]/total; // obtenemos la probabilidad
            Probability[i] = ProbabilityResultado; // Almacenamos el resultado actual en la posicion de nuestro array Probability
            System.out.println("Probability("+(i+1)+"): "+ProbabilityResultado); // Mandamos a imprimir el resultado actual
            probabilidadAcumulada[i+1] = probabilidadAcumulada[i] + ProbabilityResultado; // Vamos sacando las prob. Acumuladas y almacenandolas en su array.
        }
        //-----------------------------------------------------------------------
        //probabilidad Acumulada C[i]
        // En esta parte solo mandamos a imprimir la probabilidad acumulada
        System.out.println("\nProbabilidad acumulada C(i)"); // Separador
        for(int i=0; i<=cantCromo;i++){
            System.out.println("Probabilidad acumulada C("+(i)+"): "+probabilidadAcumulada[i]);
        }
         //-----------------------------------------------------------------------
         //Numeros al azar
        double []numerosAzar = new double[cantCromo]; // Arreglo para ir almacenando los numeros randoms
        System.out.println("\nGeneración de números al azar"); // Separador en consola
        for (int i = 0; i < cantCromo; i++) {
            numerosAzar[i] = azar.nextDouble(); // Genera un nuevo numero aleatorio
            System.out.printf( (i+1) + ".-  %.3f\n" , numerosAzar[i] ); // Mandamos a imprimir
        }//  By: RETBOT
         //-----------------------------------------------------------------------
        //Rangos min-max, se elige al mayor
        System.out.println("\nRango min-max, eligiendo el mayor");
        int [] rangosCambios = new int[cantCromo]; // Arreglo para almacenar los rangos 
        // Formula = R[i] > C[i] < C [i+1]
        //i para la posicion actual y j para la comparacion
        for (int i = 0; i < cantCromo; i++) {
            for (int j = 0; j < cantCromo; j++) {
                // Si el numero al azar es mayor que el numero en la pos actual de prob acumulada y tambien
                // es menor que el numero de la posicion siguiente de la probabilidad actumulada
                if(numerosAzar[i] > probabilidadAcumulada[j] && numerosAzar[i] < probabilidadAcumulada[j+1] ){
                    rangosCambios[i] = j+1; // Se agrega al arreglo rangosCambios
                }
            }
            System.out.println(rangosCambios[i]); // Mandamos a imprimir por consola
        }
         //-----------------------------------------------------------------------
        //Nuevos cromosomas
        System.out.println("\n Nuevos cromosomas"); // Separador
        for (int i = 0; i < cantCromo; i++) {
        // Reacomodo de los nuevos cromosomas en base a los rangos obtenidos 
        // en el ciclo anterior
            nuevosCromosomas[i] = cromosomas[rangosCambios[i]-1];
        }
       //------------------------------------------------------------------------
        // Mandamos a imprimir en consola el nuevo acomodo
        System.out.println("\nCromosoma\ta\tb\tc\td"); // Imprimos en formato de tabla
        for(int i=0; i<cantCromo;i++){
             System.out.print((i+1)+"\t");
            for(int j=0; j<4; j++){
                System.out.print("\t"+nuevosCromosomas[i][j]);
            }
            System.out.println("");
        }
        //--------------------------------------------------------------------
          // Definimos la variable crossover, para verificar cuantos
        // numeros son aptos para el crossover
        boolean crossover[] = new boolean[cantCromo];
         //Nuevos numeros aleatorios, seleccion para el crossover
        double []numerosAzar2 = new double[cantCromo];
        System.out.println("\nGeneración de números al azar");
        for (int i = 0; i < cantCromo; i++) {
            crossover[i] = false; // El crossover sera falto si el numero aleatorio es mayor a 0.25
            numerosAzar2[i] = azar.nextDouble(); // Generacion de un nuevo numero aleatorio
            //System.out.printf( (i+1) + ".-  %.3f\n" , numerosAzar2[i] );
            if ( numerosAzar2[i] < 0.25){
                crossover[i] = true; //Se define que si el numero al azar es menor de 0.25, se le realizara un crossover
            }
            System.out.println(crossover[i]);
        }
         //Se define un arreglo cromosomasCrossover para almacenar los cromosomas que serán afectados por el crossover
        int cromosomasCrossover[][] = new int [cantCromo][4]; // Declaracion de un nuevo arreglo
        int lugaresDeCambiosCrossover[] = new int [cantCromo]; // Declaracion de un nuevo arreglo
        int cambios = 0; //Variable cambios para saber cuantos crossover se realizarán en el proceso. 
        for (int i = 0; i < cantCromo; i++) {
            if ( crossover[i] ){
                cromosomasCrossover[i] = nuevosCromosomas[i]; //Se guardan los cromosomas que  van a sufrir alteraciones
                lugaresDeCambiosCrossover[i] = i;// Maneja los cambios del crossover
                cambios++;// incrementamos el contador cambios
            } else{
                lugaresDeCambiosCrossover[i] = -1; // Se devuelve de lugar
            }
            System.out.println("cromosomasCrossover" + Arrays.toString(cromosomasCrossover[i]));
        }//  By: RETBOT
         //--------------------------------------------------------------------------
         //Se declara un arreglo puntoCrossover para saber en que punto del renglon se realizara el crossover. los valores asignados son de un random entre 1 y 3, ya que 
       //el valor en la primera columna siempre se conserva. 
        int puntoCrossover[] = new int[cantCromo ]; // Variable para los puntos de crossover
        System.out.println("Puntos Crossover:");
        for (int i = 0; i < cantCromo; i++) {
            if ( lugaresDeCambiosCrossover[i] >= 0 ){ //Si en la posicion actual hay un cambio, entra a definir el punto de crossover
                puntoCrossover[i] = azar.nextInt(3)+1;// Se genera un punto de crossover entre 1 y 3
                System.out.println(puntoCrossover[i]);// Imprimimos en consola
            }
        }
        //-------------------------------------------------------------------------------------------
        //Se declaran variables necesarias para el crossover. Anterior para saber cual fue el lugar anterior donde se hizo, primero para saber cual es el primer lugar
        //donde tendrá que haber crossover, y cambios disponibles para saber cuando se puede hacer el crossover. 
        int anterior= -1, primero = -1, cambiosDisponibles = 0;
        
        for (int i = 0; i < cantCromo ; i++) { //Se recorre el ciclo con limite del numero de cromosomas, para asignar los cromosomas del crossover al arreglo de Cromosomas. 
            if ( cambios > 1 && lugaresDeCambiosCrossover[i] >= 0) { // Solo entra si hay más de un cambio que hacer y si el lugar actual en el arreglo tendrá un crossover
                    if ( cambiosDisponibles > 0){ // Cuando hay un cambio disponible que hacer entra al switch para hacer el cambio
                        switch( puntoCrossover[i] ){ //Segun el punto del crossover, se realizara el cambio
                            case 1 : { //Si el punto es de 1, el valor en la primera columna(0) se queda, pero todos los demas valores del renglon cambian
                                nuevosCromosomas[anterior][1] = cromosomasCrossover[i][1];
                                nuevosCromosomas[anterior][2] = cromosomasCrossover[i][2];
                                nuevosCromosomas[anterior][3] = cromosomasCrossover[i][3];
                            }
                            break;
                            case 2 : { //Si el punto es 2, el valor en la primera y la segunda columna(0 y 1) se quedan, pero todos los demas valores del renglon cambian
                                nuevosCromosomas[anterior][2] = cromosomasCrossover[i][2];
                                nuevosCromosomas[anterior][3] = cromosomasCrossover[i][3];
                            }
                            break;
                            case 3: nuevosCromosomas[anterior][3] = cromosomasCrossover[i][3]; //Si el punto es 3, las primeras 3 columans se quedan igual (0, 1 y 2) y solo la ultima cambia. 
                            break;
                            default: {
                            }
                            break;
                            
                        }//  By: RETBOT
                    }
                    if( primero == -1 ){ // Cuando se llegue al primer lugar donde hay que hacer crossover, cambia el valor de primero y de anterior para el lugar actual. 
                                        //y debido a que a partir de aqui primero valdrá más, solo se puede entrar a este if una vez. 
                        primero = i;
                        anterior = i;
                    } else { // Cuando ya haya detectado un primero, solo es necesario cambiar el valor de anterior, para definir el lugar anterior del crossover
                        anterior = i;
                    }
                    cambiosDisponibles++; //Se aumentan los cambios disponibles para hacer. 
            }
        }
        
        if (cambios > 1){
            switch( puntoCrossover[anterior] ){ //Ya que en el for anterior, no podemos saber cual será el ultimo lugar de cambio, accedemos a el fuera del ciclo.
                    case 1 : {
                         // En caso de que el punto anterio de crossover sea 1
                        // Los renglones de los nuevos cromosomas en las columnas 1 2 3 
                        // seran igual a primero
                        nuevosCromosomas[anterior][1] = cromosomasCrossover[primero][1];
                        nuevosCromosomas[anterior][2] = cromosomasCrossover[primero][2];
                        nuevosCromosomas[anterior][3] = cromosomasCrossover[primero][3];
                    }
                    /*En caso de que el punto de crossover anterior sea igual a 2
                    entonces los nuevos cromosomas en las columnas 2 y 3 seran igual 
                    a lo que haya en el renglon de cromosomasCrossover primero*/
                    case 2 : {
                        nuevosCromosomas[anterior][2] = cromosomasCrossover[primero][2];
                        nuevosCromosomas[anterior][3] = cromosomasCrossover[primero][3];
                    }
                   /*En caso de que el punto de crossover anterior sea igual a 3
                    entonces los nuevos cromosomas en la columna 3 seran igual a los 
                    de la primer columna de cromosomasCrossover*/ 
                    case 3 :  nuevosCromosomas[anterior][3] = cromosomasCrossover[primero][3];
                    // Los crossover solo pueden ser del 1 al 3, por lo que ya no hay mas casos
                    // de prueba, por lo que por default simplemente hace un break.
                    default : {
                    }
                }
        }//  By: RETBOT
        //----------------------------------------------------------------------------
        // Imprime los nuevos cromosomas
        System.out.println("Nuevos Cromosomas");
        for (int i = 0; i < cantCromo; i++) {
            System.out.println(Arrays.toString(nuevosCromosomas[i]));
        }
        //-----------------------------------------------------------------------------
        // MUTACIONES
        int totalGen = 4 * cantCromo; // totalGen = numGeninChromosome * numPopulation			
        int numMutaciones = (int) floor(0.1 * totalGen); // NumMutations: 0.1*24=floor(2.4)
        int arrMutaciones []= new int [numMutaciones]; //Arreglo donde se guardan los valores de las mutaciones nuevas, random entre 0 y 30
        int lugaresMutaciones[] = new int[numMutaciones]; //Arreglo donde se guardan los lugares donde se realizarán las mutaciones, random entre 0 y 23
        
        for (int i = 0; i < numMutaciones; i++) { //Se recorre el for según el número de mutaciones
            lugaresMutaciones[i] = azar.nextInt(totalGen); // Se obtienen los valores de los lugares con el random 
            arrMutaciones[i] = azar.nextInt(30)+1; // Se obtienen los valores de los valores con el random 
            int renglon =  (int) floor(lugaresMutaciones[i] / 4); //Se calcula el renglon donde quedara la mutacion. Ej. lugar  12 / 4 = renglon 3
            int columna = lugaresMutaciones[i] - renglon * 4; //Se calcula la columna donde quuedara la mutacion. Ej. lugar12: 12 - ( 3 * 4) = 12 - 12 = columna 0.
            nuevosCromosomas[renglon][columna] = arrMutaciones[i]; // Guardamos en nuevosCromosomas los valores del array de mutaciones
        }
        // Reasignamos el valor de cromosomas tomando el de los nuevos cromosomas
        cromosomas = nuevosCromosomas;
        
        for(int c = 0; c<8; c++){
        int piernas, orejas, colmillos, proboscide;
        
        piernas = convertirPiernaDibujo( (int) floor(cromosomas[c][0]/10)-1);// Redondea lo que haya la columna 0 de cromosomas
        orejas = convertirOrejasDibjo( (int) floor(cromosomas[c][1]/10)-1); // Columna 1
        colmillos = convertirColmillosDibjo( (int) floor(cromosomas[c][2]/10)-1); // Columna 2
        proboscide = convertirProboscideDibjo( (int) floor(cromosomas[c][3]/10)-1); // Columna 3
// En los siguientes 4 switch, se van actualizando los valores de los 8 elefantes
          switch (c) { // Elefante 1
              case 0 : Dibujo.dibujarElefante(jPanelElefante.getWidth()/4, // x
                            jPanelElefante.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante); // panel
              // Elefante 2
              case 1 : Dibujo.dibujarElefante(jPanelElefante2.getWidth()/4, // x
                            jPanelElefante2.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante2); // panel
              // Elefante 3
              case 2 : Dibujo.dibujarElefante(jPanelElefante3.getWidth()/4, // x
                            jPanelElefante3.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante3); // panel
              // Elefante 4
              case 3 : Dibujo.dibujarElefante(jPanelElefante4.getWidth()/4, // x
                            jPanelElefante4.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante4); // panel
              // Elefante 5
              case 4 : Dibujo.dibujarElefante(jPanelElefante5.getWidth()/4, // x
                            jPanelElefante5.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante5); // panel
              // Elefante 6//  By: RETBOT
              case 5 : Dibujo.dibujarElefante(jPanelElefante5.getWidth()/4, // x
                            jPanelElefante6.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante6); // panel
              // Elefante 7
              case 6  : Dibujo.dibujarElefante(jPanelElefante7.getWidth()/4, // x
                            jPanelElefante7.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante7); // panel
              // Elefante 8
              case 7 : Dibujo.dibujarElefante(jPanelElefante8.getWidth()/4, // x
                            jPanelElefante8.getHeight()/4, // y
                            piernas,// tamaño piernas
                            orejas, // tamaño orejas
                            colmillos, // tamaño colmillos
                            proboscide, // tamaño probóscide
                            jPanelElefante8); // panel
          }
        }
        // Actualizamos el texto de num de generaciones llamando al contador.
        cicloActual.setText( cicloActualval++ + "");
    }
    //------------------------------------------------------------------------------
    // Estos valores se los retorna al switch de arriba
 // Metodo para en base al valor determinar si son piernas chicas, grandes o medianas
    /// VALORES PARA LA PIERNES
    // En general el valor 0,1,2 salen de los radio button.
    private int convertirPiernaDibujo(int piernas){
        switch (piernas){
            case 0 : {
                return -20;
            }
            case 1 : {
                return -10;
            }
            case 2 : {    
                return 10;
            }//  By: RETBOT
        }
        return 10;
    }
//------------------------------------------------------------------------------ 
    /// VALORES PARA LAS OREJAS
    private int convertirOrejasDibjo(int orejas){
        switch(orejas){
            case 0 : {
                return -20;
            }
            case 1 : {
                return  -10;
            }
            case 2 : {
                return 0;
            }
        }
        return 0;
    }
    //------------------------------------------------------------------------------
    /// VALORES PARA LOS COLMILLOS
    private int convertirColmillosDibjo(int colmillos){
        switch ( colmillos ){
            case 0 : {
                return 20;
            }
            case 1 : {
                return 10;
            }
            case 2 : {
                return -10;
            }
        }
        return -10;
    }
    //------------------------------------------------------------------------------
    /// VALORES PARA EL ELEFANTE
    private int convertirProboscideDibjo(int proboscide){
        switch ( proboscide ){
            case 0 : {
                return -10;
            }
            case 1 : {
                return -5;
            }
            case 2 : {
                return 5;
            }
        }
        return 5;//  By: RETBOT
    }
    //------------------------------------------------------------------------------
    /// METODO PARA LAS VALIDACIONES
    // Principalmente para ver si los valores van coincidiendo
    private boolean validaciones(){
    boolean band = true; // Variable bandera
    for(int c = 0; c<cantCromo; c++){
       
        int piernas, orejas, colmillos, proboscide; // Partes del cuerpo mutadas
        
        // Redondeo de valores usando el metodo floor de la clase Math
        // Los valores los va tomando de las columnas de nuestro array de
        // cromosomas, para posteriormente divirse entre 10 y ese resultado
        // sea redondeado
        piernas = (int)  Math.floor(cromosomas[c][0]/10); 
        orejas =  (int) Math.floor(cromosomas[c][1]/10);
        colmillos = (int)  Math.floor(cromosomas[c][2]/10);
        proboscide = (int) Math.floor(cromosomas[c][3]/10);
        ///----------------------------------------------------------------------
        /*Basicamente en este if valida si los valores siguen siendo los mismos,
        hace la comparacion y si coincide eso quiere decir que nuestro programa
        sigue bien y le da salida con la bandera en true*/
        if(ePierna == piernas && 
           eOreja == orejas &&
           eColmillos == colmillos &&
           eProbo == proboscide){
            band = true;
        }
        else{
           band = false; // Si los valores salen diferentes el programa rompe
           break;
        }
        }
        return !band;
    }//  By: RETBOT
 ///----------------------------------------------------------------------------------
   // SETTERS
    public void setVelocidad(boolean velocidad){
        this.velocidad = velocidad;
    }
 ///----------------------------------------------------------------------------------  
    public void setCromosomas(int[][] cromosomas) {
        this.cromosomas = cromosomas;
    }
 ///----------------------------------------------------------------------------------   
    public void setNuevosCromosomas(int[][] nuevosCromosomas) {
        this.nuevosCromosomas = nuevosCromosomas;
    }
///----------------------------------------------------------------------------------
    public void setCantCromo(int cantCromo) {
        this.cantCromo = cantCromo;
    }
///----------------------------------------------------------------------------------
    public void setFx(int[] fx) {
        this.fx = fx;
    }
///----------------------------------------------------------------------------------
    public void setFitness(double[] fitness) {
        this.fitness = fitness;
    }
///----------------------------------------------------------------------------------
    public void setProbability(double[] Probability) {
        this.Probability = Probability;
    }
///----------------------------------------------------------------------------------
    public void setProbabilidadAcumulada(double[] probabilidadAcumulada) {
        this.probabilidadAcumulada = probabilidadAcumulada;
    }
///----------------------------------------------------------------------------------
    public void setAzar(Random azar) {
        this.azar = azar;
    }//  By: RETBOT
///----------------------------------------------------------------------------------
    public void setPiernasDibjo1(int piernasDibjo1) {
        this.piernasDibjo1 = piernasDibjo1;
    }
///----------------------------------------------------------------------------------
    public void setOrejasDibjo1(int orejasDibjo1) {
        this.orejasDibjo1 = orejasDibjo1;
    }
///----------------------------------------------------------------------------------
    public void setColmillosDibjo1(int colmillosDibjo1) {
        this.colmillosDibjo1 = colmillosDibjo1;
    }
///----------------------------------------------------------------------------------
    public void setProboscideDibjo1(int proboscideDibjo1) {
        this.proboscideDibjo1 = proboscideDibjo1;
    }
///----------------------------------------------------------------------------------
    public void setPiernasDibjo2(int piernasDibjo2) {
        this.piernasDibjo2 = piernasDibjo2;
    }
///----------------------------------------------------------------------------------
    public void setOrejasDibjo2(int orejasDibjo2) {
        this.orejasDibjo2 = orejasDibjo2;
    }
///----------------------------------------------------------------------------------
    public void setColmillosDibjo2(int colmillosDibjo2) {
        this.colmillosDibjo2 = colmillosDibjo2;
    }
///----------------------------------------------------------------------------------
    public void setProboscideDibjo2(int proboscideDibjo2) {
        this.proboscideDibjo2 = proboscideDibjo2;
    }
///----------------------------------------------------------------------------------
    public void setPiernasDibjo3(int piernasDibjo3) {
        this.piernasDibjo3 = piernasDibjo3;
    }
///----------------------------------------------------------------------------------
    public void setOrejasDibjo3(int orejasDibjo3) {
        this.orejasDibjo3 = orejasDibjo3;
    }
///----------------------------------------------------------------------------------
    public void setColmillosDibjo3(int colmillosDibjo3) {
        this.colmillosDibjo3 = colmillosDibjo3;
    }
///----------------------------------------------------------------------------------
    public void setProboscideDibjo3(int proboscideDibjo3) {
        this.proboscideDibjo3 = proboscideDibjo3;
    }
///----------------------------------------------------------------------------------
    public void setPiernasDibjo4(int piernasDibjo4) {
        this.piernasDibjo4 = piernasDibjo4;
    }
///----------------------------------------------------------------------------------
    public void setOrejasDibjo4(int orejasDibjo4) {
        this.orejasDibjo4 = orejasDibjo4;
    }
///----------------------------------------------------------------------------------
    public void setColmillosDibjo4(int colmillosDibjo4) {
        this.colmillosDibjo4 = colmillosDibjo4;
    }
///----------------------------------------------------------------------------------
    public void setProboscideDibjo4(int proboscideDibjo4) {
        this.proboscideDibjo4 = proboscideDibjo4;
    }
///----------------------------------------------------------------------------------
    ///         GETTERS
    public int[][] getCromosomas() {
        return cromosomas;
    }
///----------------------------------------------------------------------------------
    public int[][] getNuevosCromosomas() {
        return nuevosCromosomas;
    }//  By: RETBOT
///----------------------------------------------------------------------------------
    public int getCantCromo() {
        return cantCromo;
    }
///----------------------------------------------------------------------------------
    public int[] getFx() {
        return fx;
    }
///----------------------------------------------------------------------------------
    public double[] getFitness() {
        return fitness;
    }
///----------------------------------------------------------------------------------
    public double[] getProbability() {
        return Probability;
    }
///----------------------------------------------------------------------------------
    public double[] getProbabilidadAcumulada() {
        return probabilidadAcumulada;
    }
///----------------------------------------------------------------------------------
    public Random getAzar() {
        return azar;
    }
///----------------------------------------------------------------------------------
    public int getPiernasDibjo1() {
        return piernasDibjo1;
    }
///----------------------------------------------------------------------------------
    public int getOrejasDibjo1() {
        return orejasDibjo1;
    }
///----------------------------------------------------------------------------------
    public int getColmillosDibjo1() {
        return colmillosDibjo1;
    }
///----------------------------------------------------------------------------------
    public int getProboscideDibjo1() {
        return proboscideDibjo1;
    }
///----------------------------------------------------------------------------------
    public int getPiernasDibjo2() {
        return piernasDibjo2;
    }
///----------------------------------------------------------------------------------
    public int getOrejasDibjo2() {
        return orejasDibjo2;
    }
///----------------------------------------------------------------------------------
    public int getColmillosDibjo2() {
        return colmillosDibjo2;
    }
///----------------------------------------------------------------------------------
    public int getProboscideDibjo2() {
        return proboscideDibjo2;
    }
///----------------------------------------------------------------------------------
    public int getPiernasDibjo3() {
        return piernasDibjo3;
    }
///----------------------------------------------------------------------------------
    public int getOrejasDibjo3() {
        return orejasDibjo3;
    }
///----------------------------------------------------------------------------------
    public int getColmillosDibjo3() {
        return colmillosDibjo3;
    }
///----------------------------------------------------------------------------------
    public int getProboscideDibjo3() {
        return proboscideDibjo3;//  By: RETBOT
    }
///----------------------------------------------------------------------------------
    public int getPiernasDibjo4() {
        return piernasDibjo4;
    }
///----------------------------------------------------------------------------------
    public int getOrejasDibjo4() {
        return orejasDibjo4;
    }
///----------------------------------------------------------------------------------
    public int getColmillosDibjo4() {
        return colmillosDibjo4;
    }
///----------------------------------------------------------------------------------
    public int getProboscideDibjo4() {
        return proboscideDibjo4;
    }
///----------------------------------------------------------------------------------
    public JPanel getjPanelElefante() {
        return jPanelElefante;
    }
///----------------------------------------------------------------------------------
    public JPanel getjPanelElefante2() {
        return jPanelElefante2;
    }
///----------------------------------------------------------------------------------
    public JPanel getjPanelElefante3() {
        return jPanelElefante3;
    }
///----------------------------------------------------------------------------------
    public JPanel getjPanelElefante4() {
        return jPanelElefante4;
    }
///----------------------------------------------------------------------------------  
    
    
    
    
    
    
}//  By: RETBOT
