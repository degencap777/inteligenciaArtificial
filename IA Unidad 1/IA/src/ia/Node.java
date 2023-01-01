package ia;

import java.util.ArrayList;
import java.util.List;

/**
 * Node class.
 * 
 * @author RETBOT
 */
// clase para establecer los nodos
public class Node<T> implements Comparable<Node> {

    // estados de los nodos, Visitado, abierto y cerrado
    public static enum State { UNVISITED, OPEN, CLOSED };
    
    private final T obj;
    private State state = State.UNVISITED;
    private boolean blocked = false;
    private boolean pila = false;
    private boolean pelota = false;
    
    private double g; // cost
    private double h; // heuristic
                      // f = g + h
    
    private Node backPathNode;
    private final List<Edge<T>> edges = new ArrayList<>();
    
    // constructior
    public Node(T obj) {
        this.obj = obj;
    }

    // Método para obtener los objetos  
    public T getObj() {
        return obj;
    }

    // Método para obtener el estado
    public State getState() {
        return state;
    }

    // Método para poner el estado 
    void setState(State state) {
        this.state = state;
    }

    // Método para obtener si el nodo esta bloquedo
    public boolean isBlocked() {
        return blocked;
    }
    
    // Método para obtener si es pila 
    public boolean isPila() {
        return pila;
    }

    // Método para obtener si es pelota
    public boolean isPelota() {
        return pelota;
    }
    
    // Método para bloquear el nodo
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    
    // Método para poner tierra
    public void setPila(boolean pila) {
        this.pila = pila;
    }
    
    // Método para poner agua
    public void setPelota(boolean pelota) {
        this.pelota = pelota;
    }

    // Método para obtener costo
    public double getG() {
        return g;
    }

    // Método para poner costo
    void setG(double g) {
        this.g = g;
    }

    // Método para obtener la heuristica
    public double getH() {
        return h;
    }

    // Método para poner la heuristica
    void setH(double h) {
        this.h = h;
    }

     // Método para obtener el nodo de la ruta de regreso
    public Node getBackPathNode() {
        return backPathNode;
    }

    // Método para poner el nodo de la ruta de regreso
    public void setBackPathNode(Node backPathNode) {
        this.backPathNode = backPathNode;
    }

     // Método para obtener la lista de búsquedas
    public List<Edge<T>> getEdges() {
        return edges;
    }

    //Método para agregar a la lista de búsquedas
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    // f(n) = g(n) + h(n) -> cost + heuristic
    public double getF() {
        return g + h;
    }

    // Método para recuperar ruta
    public void retrievePath(List<Node<T>> path) {
        if (backPathNode != null) {
            backPathNode.retrievePath(path);
        }
        path.add(this);
    }
    
    // Método para comparar los nodos
    @Override
    public int compareTo(Node o) {
        double dif = getF() - o.getF();
        return dif == 0 ? 0 : dif > 0 ? 1 : -1;
    }    

    @Override
    public String toString() {
        return "Node{" + "id=" + obj + ", state=" + state + ", g=" + g + ", h=" 
            + h + ", parentNode=" + backPathNode + ", edges=" + edges + '}';
    }
    
}
