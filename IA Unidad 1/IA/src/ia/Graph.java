package ia;

import static ia.Node.State.CLOSED;
import static ia.Node.State.OPEN;
import static ia.Node.State.UNVISITED;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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

    // metodo para el enlace de los nodos
    public void link(Node a, Node b, double cost) {
        // Creamos un nuevo objeto para determinar el costo de los nodos 
        Edge edge = new Edge(cost, a, b);
        a.addEdge(edge); // agregamos el nodo a y b
        b.addEdge(edge);
    }

    // metodo para encontrar la ruta entre los nodos
    public void findPath(Node<T> start, Node<T> target, List<Node<T>> path, boolean pilafuera, boolean pelotafuera) {
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
            Node<T> currentNode = activeNodes.poll();// nodo actual 
            currentNode.setState(CLOSED);// estado del nodo 

            // Si se encontro el nodo destino 
            if (currentNode == target) {
                path.clear(); // se limpia el path
                target.retrievePath(path); // y se obtiene la ruta 
                return;
            }

            // si aun no encontro el nodo destino, continua con las busquedas
            currentNode.getEdges().forEach((edge) -> {
                // se establece el nodo vecino 
                Node<T> neighborNode = edge.getOppositeNode(currentNode);
                // y el costo de la ruta 
                double neighborG = currentNode.getG() + edge.getG();

                // si el nodo vecino, no se encuentra bloqueado, pero en esta ocasión no se utilizan bloqueos
                if (!neighborNode.isBlocked()
                        && neighborG < neighborNode.getG()) {
                    if (pilafuera) { // Si la pila está activa 
                        if (!neighborNode.isPila()) { //  Va a evitar chocar con ella
                            // se ingresa al path 
                            neighborNode.setBackPathNode(currentNode);

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
                    }
                    if (pelotafuera) { // Si la pila está activa y va por la pelota
                        if (!neighborNode.isPelota()) { //  Va a evitar chocar las pelotas
                            // se ingresa al path 
                            neighborNode.setBackPathNode(currentNode);

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
                    }
                    if (!pilafuera) { // si la pila no esta activa
                        // se ingresa al path 
                        neighborNode.setBackPathNode(currentNode);

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
                }
            });
        }
    }
}
