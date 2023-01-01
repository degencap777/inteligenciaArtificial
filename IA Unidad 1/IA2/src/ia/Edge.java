package ia;

/**
 * Edge class.
 * 
 * @author RETBOT
 */

// clase creada para la busqueda de nodos
public class Edge<T> {

    private double g; // costo del nodo
    // para identificar los nodos
    private final Node<T> a; // nodo a
    private final Node<T> b; // nodo b

    // constructor
    public Edge(double g, Node<T> a, Node<T> b) {
        this.g = g;
        this.a = a;
        this.b = b;
    }
    
    // obtenemos G
    public double getG() {
        return g;
    }

    // ponemos G
    public void setG(double g) {
        this.g = g;
    }

    // nodo a
    public Node<T> getA() {
        return a;
    }

    // nodo b
    public Node<T> getB() {
        return b;
    }
    
    // metodo para obtener el nodo opuesto 
    public Node<T> getOppositeNode(Node<T> thisNode) {
        if (thisNode == a) { // si el nodo principal es a 
            return b; // retornamos b
        }
        else if (thisNode == b) { // si el nodo principal es b 
            return a; // retornamos b 
        }
        return null; // si no es ninguno
    }

    @Override
    public String toString() {
        return "Edge{" + "g=" + g + ", a=" + a + ", b=" + b + '}';
    }
    
}
