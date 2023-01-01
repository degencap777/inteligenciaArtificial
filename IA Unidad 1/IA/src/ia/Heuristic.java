package ia;

/**
 * Heuristic functional interface.
 * 
 * @author RETBOT
 */
// Clase para calcular la heuristica
public interface Heuristic<T> {
    // se crea un metodo para calcular la heuristica del nodo inicial, con el nodo final
    public double calculate(Node<T> start, Node<T> target, Node<T> current);
}
