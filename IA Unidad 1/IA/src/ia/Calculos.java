package ia;

/**
 *
 * @author RETBOT
 */
// Clase utilizada para cálculos variados
public class Calculos {
    
    // Coordenadas X e Y en el tablero
    public static void cooordenadasXY(int evil[][], int cant, int coordenadas[][]) {
        int contaPelotas = 1; // contador de pelotas inicia en 1, porque el robto es el primero en generarse en el mapa 
        while (contaPelotas <= cant - 2) {
            int x = dePixelesACoordenadas(evil[contaPelotas][0]);
            int y = dePixelesACoordenadas(evil[contaPelotas][1]);

            coordenadas[contaPelotas-1][0] = x;
            coordenadas[contaPelotas-1][1] = y;
            contaPelotas++;
            System.out.println("X = " + x + " Y = " + y);
        }
    }

    // Método Hheurística utilizado para identificar el nodo más cercano al robot
    public static double heuristica(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Método utilizado para transformar de píxeles a coordenada 
    public static int dePixelesACoordenadas(int aux) {
        int i = 0; // Posición inicial 
        while (aux > 0) { // Hasta llegar a 0
            i++; // Aumentan las posiciones 
            aux -= 50; // Disminuyen los píxeles
        }
        return i; // y retorna la coordenada 
    }

}