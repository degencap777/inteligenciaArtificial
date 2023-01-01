package ia;

import static ia.Node.State.CLOSED;
import static ia.Node.State.OPEN;
import static ia.Node.State.UNVISITED;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//  By: RETBOT
/**
 * Graph class.
 * 
 * @author RETBOT
 */

// clase creada para Graficar los dibujos 
public class Graph<T> {

    // lista de los nodos 
    private final List<Node<T>> nodes = new ArrayList<>();
    // lista para almacenar todas los caminos posibles 
    private final Heuristic<T> heuristic;
    
    // constructor 
    public Graph(Heuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    // metodo para agregar un nuevo nodo
    public void addNode(Node n) {
        nodes.add(n);
    }

    // metodo obtener los nodos
    public List<Node<T>> getNodes() {
        return nodes;
    }
    
     // metodo obtener la Heuristica
    public Heuristic<T> getHeuristic() {
        return heuristic;
    }
    //  By: RETBOT
    // metodo para el enlace de los nodos
    public void link(Node a, Node b, double cost) {
        // Creamos un nuevo objeto para determinar el costo de los nodos 
        Edge edge = new Edge(cost, a, b);
        a.addEdge(edge); // agregamos el nodo a y b
        b.addEdge(edge);
    }
    
    // metodo para encontrar la ruta entre los nodos
    public void findPath(Node<T> start, Node<T> target, List<Node<T>> path) {
        // creamos los estados del nodo 
        nodes.forEach(node -> {
            node.setState(UNVISITED); // ponemos el estado sin visitas 
            node.setBackPathNode(null); // el nodo anterior en nulo 
            node.setG(Double.MAX_VALUE); // y el costo
        });
        
        start.setG(0); // ponemos el costo inicial en 0 
        // y calculamos la distancia entre los nodos
        start.setH(heuristic.calculate(start, target, start));
        
        // utilizamos la clase PriorityQueue, integrada en java, para darle prioridad al nodo que entro primero
        PriorityQueue<Node<T>> activeNodes = new PriorityQueue<>();
        // y lo iniciamos 
        activeNodes.add(start);
        
        // si los nodos no estan vacios 
        while (!activeNodes.isEmpty()) {
            Node<T> currentNode = activeNodes.poll(); // nodo actual 
            currentNode.setState(CLOSED); // estado del nodo 
            
            // Si se encontro el nodo destino 
            if (currentNode == target) {
                path.clear(); // se limpia el path
                target.retrievePath(path); // y se obtiene la ruta 
                return;
            }    //  By: RETBOT        
            // si aun no encontro el nodo destino, continua con las busquedas
            currentNode.getEdges().forEach((edge) -> {
                // se establece el nodo vecino 
                Node<T> neighborNode = edge.getOppositeNode(currentNode);
                // y el costo de la ruta 
                double neighborG = currentNode.getG() + edge.getG();
                
                // si el nodo vecino, no se encuentra bloqueado 
                if (!neighborNode.isBlocked() 
                        && neighborG < neighborNode.getG()) {
                    // se ingresa al path 
                    neighborNode.setBackPathNode(currentNode);
                    
                    // Si el nodo vecino tiene agua 
                    if(neighborNode.isAgua()){
                        // se aumenta 55 al costo total 
                        neighborG += 55;
                    }
                    // si el nodo vecino tiene tierra 
                    if(neighborNode.isTierra()){
                        // se aumenta 25 al costo total
                        neighborG += 25; 
                    }
                    // si se guarda
                    neighborNode.setG(neighborG);
                    // calculo de la ruta 
                    double h = heuristic.calculate(start, target, neighborNode);
                    neighborNode.setH(h); 
                    
                    // si los nodos activos no contienen nodo vecino 
                    if (!activeNodes.contains(neighborNode)) {
                        activeNodes.add(neighborNode); // se agrega a los nodos activos 
                        neighborNode.setState(OPEN); // y se pone el estado abierto
                    }
                }
            });
        }
    }
    //  By: RETBOT
}
