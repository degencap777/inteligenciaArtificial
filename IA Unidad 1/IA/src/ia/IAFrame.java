/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RETBOT
 */
public final class IAFrame extends javax.swing.JFrame {

    /**
     * RETBOT
     */
    // cantidad de posiciones en el tablero 
    int cant = 0;
    // arreglo para almacenar las posiciones 
    int evil[][];
    
    // Pos BOT
    int x = 0, y = 0;

    // Pos bateria
    int xB = 0, yB = 0;
    // bateria del robot
    int bateria = 1000;
    // bandera para activar y desactivar la batería
    boolean banBateria = true;
    
     // Altura de la casilla
    private static final int TILE_SIZE = 50;
     // Cantidad de columnas
    private static final int GRID_COLS = 10;
     // Cantidad de filas
    private static final int GRID_ROWS = 10;
    // Tablero 
    private Node[][] grid;
    // Objetos en el tablero
    private Graph<Point> graph;
    // inicio
    private Node<Point> startNode;
    // fin
    private Node<Point> targetNode;
    // lista de todos los nodos
    private List<Node<Point>> path;
    // recorrido
    private final Stroke stroke = new BasicStroke(10
        , BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    // inicio 
    public IAFrame() {
        initComponents();
    }
    
    // Método para seleccionar la dificultad del juego y dibujo de las mismas
    public void pelotitas() {
       // Selección del modo de juego FACIL, MEDIO o DIFICIL
        if(jRBDificultadFacil.isSelected()){
            cant = 2 + 2;
        }else if(jRBDificultadMedio.isSelected()){
            cant = 4 + 2;
        }else if(jRBDificultadDificil.isSelected()){
           cant = 6 + 2;
        }
        // se dimensiona el arreglo de las posiciones en el tablero
        evil = new int[cant][2];
        
        // se generan los números aleatorios, para las posiciones en el tablero
        Dibujo.aleatorios(evil, cant);
        // y se dibujan en el tablero las pelotas
        Dibujo.generarPelotas(evil, cant, JPTablero);
    }
    
    
    // crea el tablero vacio y recorrido del tablero
    private void createGrid() {
        // primer ciclo para crear renglones 
        for (int y2 = 0; y2 < GRID_ROWS; y2++) {
            // segundo ciclo para crear columnas 
            for (int x2 = 0; x2 < GRID_COLS; x2++) {
                // otenemos el tamaño de las casillas 
                int nx = x2 * TILE_SIZE;
                int ny = y2 * TILE_SIZE;
                // se crea un nodo y se establecen las posiciones 
                Node node = new Node(new Point(nx, ny));
                // se agrega al tablero 
                graph.addNode(node);
                grid[y2][x2] = node;
            }
        }
        
        // recorrido en el tablero 
        // Recorrido vertical
        for (int y2 = 0; y2 < GRID_ROWS - 1; y2++) {
            for (int x2 = 0; x2 < GRID_COLS; x2++) {
                // vertical '|'
                Node top = grid[y2][x2];
                Node bottom = grid[y2 + 1][x2];
                graph.link(top, bottom, TILE_SIZE);
            }
        }

        for (int x2 = 0; x2 < GRID_COLS - 1; x2++) {
            for (int y2 = 0; y2 < GRID_ROWS; y2++) {
                // horizontal '-'
                Node left = grid[y2][x2];
                Node right = grid[y2][x2 + 1];
                graph.link(left, right, TILE_SIZE);
            }
        }
    }
    
    // metodo para dibujar los Nodos
    private void drawNode(Graphics2D g, Node<Point> node) {
        Color color = Color.BLACK; // color principal 
        
        switch (node.getState()) { // dependiendo del estado, cambia el color del nodo
            case OPEN: // si esta abierto
                color = Color.CYAN; // se pone cyan
                break;
            case CLOSED: // si esta cerrado
                color = Color.ORANGE; // se pone naranja 
                break;
            case UNVISITED: // si no esta vicitado se pone blanco
                color = Color.WHITE;
                break;
        }

        if (node == startNode) {// nodo inicio
            color = Color.BLUE;
        } else if (node == targetNode) {// nodo destino
            color = Color.RED;
            if (node.isPila()) { // si es pila
                color = Color.PINK;
            } else if (node.isPelota()) { // si es pelota
                color = Color.YELLOW;
            }

        } else if (node.isBlocked()) {// si esta bloqueado es negro 
            color = Color.BLACK;
        } else if (node.isPila()) {// si es pila
            color = Color.PINK;
        } else if (node.isPelota()) {// si es pelota
            color = Color.YELLOW;
        }
        //y lo manda a dibujar
        Dibujo.dibujarComponentes(color, node, TILE_SIZE, JPTablero);
    }
  
    // dibujar el recorrido 
    private void drawPath(Graphics2D g) {
        // Se utiliza la clase Stroke, para el contorno de la línea
        Stroke originalStroke = g.getStroke();
        g.setColor(Color.BLACK); // se pone de color rosa
        g.setStroke(stroke);
        // y se empieza a trazar la linea en el tablero 
        for (int i = 0; i < path.size() - 1; i++) {
            // recorriendo hasta llegar al nodo destino
            Node<Point> a = path.get(i);
            Node<Point> b = path.get(i + 1);
            
            // y obtenemos el inicio y el final del nodo A y B, para trazar
            // la línea por en medio
            int x1 = a.getObj().x + TILE_SIZE / 2;
            int y1 = a.getObj().y + TILE_SIZE / 2;
            int x2 = b.getObj().x + TILE_SIZE / 2;
            int y2 = b.getObj().y + TILE_SIZE / 2;
            // y de dibuja la linea
            g.drawLine(x1, y1, x2, y2);
            // Velocidad de trazado en pantalla
            if (jRBVelocidadLento.isSelected()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(IAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            } else if (jRBVelocidadMedio.isSelected()) {
                try {
                    Thread.sleep(350);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(IAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            } else if (jRBVelocidadRapido.isSelected()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(IAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }

        }
        // y al final lo decora  
        g.setStroke(originalStroke);
    }
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        JPTablero = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAResultados = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButTablero = new javax.swing.JButton();
        jButIniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jRBDificultadFacil = new javax.swing.JRadioButton();
        jRBDificultadMedio = new javax.swing.JRadioButton();
        jRBDificultadDificil = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRBVelocidadLento = new javax.swing.JRadioButton();
        jRBVelocidadMedio = new javax.swing.JRadioButton();
        jRBVelocidadRapido = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IA RETBOT");
        setBackground(new java.awt.Color(153, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(760, 550));
        setPreferredSize(new java.awt.Dimension(500, 500));

        JPTablero.setBackground(new java.awt.Color(0, 204, 204));
        JPTablero.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout JPTableroLayout = new javax.swing.GroupLayout(JPTablero);
        JPTablero.setLayout(JPTableroLayout);
        JPTableroLayout.setHorizontalGroup(
            JPTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        JPTableroLayout.setVerticalGroup(
            JPTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jTAResultados.setBackground(new java.awt.Color(0, 204, 204));
        jTAResultados.setColumns(20);
        jTAResultados.setRows(5);
        jScrollPane1.setViewportView(jTAResultados);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setToolTipText("");

        jButTablero.setText("Generar tablero");
        jButTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButTableroActionPerformed(evt);
            }
        });

        jButIniciar.setText("Iniciar");
        jButIniciar.setEnabled(false);
        jButIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButIniciarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dificultad");

        buttonGroup1.add(jRBDificultadFacil);
        jRBDificultadFacil.setSelected(true);
        jRBDificultadFacil.setText("Facil");

        buttonGroup1.add(jRBDificultadMedio);
        jRBDificultadMedio.setText("Medio");

        buttonGroup1.add(jRBDificultadDificil);
        jRBDificultadDificil.setText("Dificil");

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Velocidad");

        buttonGroup2.add(jRBVelocidadLento);
        jRBVelocidadLento.setSelected(true);
        jRBVelocidadLento.setText("Lento");

        buttonGroup2.add(jRBVelocidadMedio);
        jRBVelocidadMedio.setText("Medio");

        buttonGroup2.add(jRBVelocidadRapido);
        jRBVelocidadRapido.setText("Rápido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jRBDificultadFacil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBDificultadMedio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBDificultadDificil)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jRBVelocidadLento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBVelocidadMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRBVelocidadRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBDificultadFacil)
                    .addComponent(jRBDificultadMedio)
                    .addComponent(jRBDificultadDificil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButTablero)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBVelocidadLento)
                    .addComponent(jRBVelocidadMedio)
                    .addComponent(jRBVelocidadRapido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButIniciar)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(JPTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//  Botón para generar el tablero 
    private void jButTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButTableroActionPerformed
        // Se borra el contenido de los resultados
        jTAResultados.setText("");
        // Se dibuja el tablero
        Dibujo.dibujarTablero(JPTablero);
        // Se dibujan las pelotitas
        pelotitas();
        
        // robot posicion inicial 
        x = evil[0][0];
        y = evil[0][1];
        // bateria 
        xB = evil[evil.length-1][0]; 
        yB = evil[evil.length-1][1];
        
        // dibuja el robot (Inicio)
        Dibujo.dibujarBOT(x,y,JPTablero);
        // y un cuadrado (Fin)
        Dibujo.dibujarPila(xB, yB,JPTablero);
         // Una vez establecido el tablero, podemos iniciar el recorrido
        jButIniciar.setEnabled(true);
    }//GEN-LAST:event_jButTableroActionPerformed

    private void jButIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButIniciarActionPerformed
        // se borran los resultados anteriores
        jTAResultados.setText("Reporte:\n");
        // se reinicia la bateria 
        bateria = 1000;
        banBateria = true;
        
        //CREAMOS ORIGEN DE LA RUTA
        int nx = Calculos.dePixelesACoordenadas(x);
        int ny = Calculos.dePixelesACoordenadas(y);
        int nxFin;
        int nyFin;
                
        // Bateria 
        int posBateriaX = Calculos.dePixelesACoordenadas(xB);
        int posBateriaY = Calculos.dePixelesACoordenadas(yB);
        int estadoBateria;
        
        // MATRIZ PARA GUARDAR LAS CORRDENADAS
        int[][] coord = new int[cant-2][2];
        int cantCoord = coord.length;
        
        ArrayList<Integer> coordX = new ArrayList<>();
        ArrayList<Integer> coordY = new ArrayList<>();

        //CREAMOS LA MATRIZ //AÑADIMOS LOS OBJETOS CASILLAS
        Calculos.cooordenadasXY(evil, cant, coord);
        
        // almacenar todas las pelotitas
        for (var coord1 : coord) {
            coordX.add(coord1[0]);
            coordY.add(coord1[1]);
        }

        //CREAMOS ORIGEN DE LA RUTA
        for (int i = 0; i < coord.length; i++) {
            if (bateria >= 0) {
                // tablero
                path = new ArrayList<>();
                grid = new Node[GRID_ROWS][GRID_COLS];

                graph = new Graph<>((start, target, current) -> {
                    // heuristic = linear distance
                    int dx = target.getObj().x - current.getObj().x;
                    int dy = target.getObj().y - current.getObj().y;
                    return Math.sqrt(dx * dx + dy * dy);
                });
                // se crea el tablero 
                createGrid();

                // se agregan las pelotitas
                for (int j = 0; j < coordX.size(); j++) {
                    int row = coordX.get(j);
                    int col = coordY.get(j);
                    grid[col][row].setPelota(true);
                }
                // y agregamos la pila
                if (banBateria) { // si aun no toma la bateria
                    grid[posBateriaY][posBateriaX].setPila(true); // activa la bateria
                } else { // si no
                    grid[posBateriaY][posBateriaX].setPila(false); // quita la bateria del tablero
                }

                // Distancia de todas las coordenadas
                ArrayList<Double> distCoord = new ArrayList<>();

                // y empezamos a calcular la distancia 
                int j = 0;
                while (j < cantCoord) // Distancia entre el bot y las pelotas
                {
                    // x e y de cada pelotita 
                    nxFin = coordX.get(j);
                    nyFin = coordY.get(j);
                    // y lo agregamos al arraylista 
                    distCoord.add(Calculos.heuristica(nx, ny, nxFin, nyFin));
                    j++;
                }
                //Para después ver cuál es la distancia más corta 
                int indice = 0;
                double menor = distCoord.get(0); // Iniciando por la primera pelotita
                for (int d = 1; d < distCoord.size(); d++) { // Para después verificar las demás
                    if (distCoord.get(d) < menor) {
                        menor = distCoord.get(d);
                        indice = d; // y almacenar la posición de la pelotita
                    }
                }
                // Una vez obtenido la pelotita más cercana, obtenemos sus coordenadas
                nxFin = coordX.get(indice);
                nyFin = coordY.get(indice);
                
                // incio del recorrido 
                startNode = grid[ny][nx];
                targetNode = grid[nyFin][nxFin];

                // se limpia el recorrido 
                path.clear();
                // y se traza 
                graph.findPath(startNode, targetNode, path, banBateria, false);
   
                // Verificamos la distancia entre el robot y la batería
                double distanciaRyB = Calculos.heuristica(nx, ny, posBateriaX, posBateriaY) * 50;
                // Obtenemos el costo del recorrido inicial 
                int rec1 = (int)targetNode.getG();
                //y después obtenemos el recorrido de la distancia entre el robot y la batería
                int rec2 = (int)distanciaRyB;
                // Obtenemos el valor de la batería después de los dos recorridos
                int val1 = bateria - rec1;
                int val2 = bateria - rec2;
                
                // y la bateria restante despues del primer recorrido 
                int bateriaRestante = bateria - rec1;
                
                // si el valor del primer recorrido es menor o igual a 0
                // o la batería restante es menor o igual a 300 y no es el último recorrido del tablero 
                if (val1 <= 0 || (bateriaRestante<=300 && (i+1)<coord.length)) { // Si no puede llegar a la pelota 
                    if ((val2 >= 0 && val2<=bateria) && banBateria) { // Verificamos que pueda llegar a la batería, si puede, va por la batería 
                        // incio del recorrido 
                        startNode = grid[ny][nx];
                        // fin del recorrido (Bateria )
                        targetNode = grid[posBateriaY][posBateriaX];
                        // indicamos que vamos por la bateria 
                        banBateria = false;

                        // se limpia el recorrido 
                        path.clear();
                        // y se traza 
                        graph.findPath(startNode, targetNode, path, banBateria, true);
                        Graphics2D g = (Graphics2D) JPTablero.getGraphics();
                         // recorrido en el tablero 
                        graph.getNodes().forEach(node -> {
                            drawNode(g, node);
                        });
                        // se dibuja el reccorrido 
                        drawPath(g);
                         // y se establece el costo 
                        int costo = (int) targetNode.getG();
                        // y se agrega a Reporte
                        jTAResultados.append("Costo Recorrido " + (i + 1) + ": " + costo + "\n");
                        // Se actualiza la batería, con el recorrido para agregar más batería
                        bateria -= costo;
                        estadoBateria = bateria * 1 / 10;
                        jTAResultados.append("\nEstado de batería\n antes de recoger pila = " + estadoBateria + "% \n");
                        // y despues se agrega la bateria 
                        bateria = 1000;
                        estadoBateria = bateria * 1 / 10;
                        // y se agrega al reporte
                        jTAResultados.append("Estado de batería\n después de recoger pila = " + estadoBateria + "% \n\n");
                        // se actualiza la posición del robot
                        nx = posBateriaX;
                        ny = posBateriaY;

                        // Distancia de todas las coordenadas con la posición actual del robot
                        ArrayList<Double> distCoordAux = new ArrayList<>();
                        // y empezamos a calcular la distancia 
                        j = 0;
                        while (j < cantCoord) // Distancia entre el bot y las pelotas
                        {
                            // x e y de cada pelotita 
                            nxFin = coordX.get(j);
                            nyFin = coordY.get(j);
                            // y lo agregamos al arraylista 
                            distCoordAux.add(Calculos.heuristica(nx, ny, nxFin, nyFin));
                            j++;
                        }

                // Una vez obtenido la pelotita más cercana, obtenemos sus coordenadas
                        indice = 0; // /Para después ver cuál es la distancia más corta 
                        menor = distCoordAux.get(0);// Iniciando por la primera pelotita
                        for (int d = 1; d < distCoordAux.size(); d++) {// Para después verificar las demás
                            if (distCoordAux.get(d) < menor) {
                                menor = distCoordAux.get(d);
                                indice = d; // y almacenar la posición de la pelotita
                            }
                        }
                        // y obtener la posición final del recorrido
                        nxFin = coordX.get(indice);
                        nyFin = coordY.get(indice);

                    } else { // si no puede terminamos las busquedas 
                        Dibujo.dibujarTablero(JPTablero);

                        // se agregan las pelotitas al tablero
                        for (j = 0; j < coordX.size(); j++) {
                            int row = coordX.get(j);
                            int col = coordY.get(j);
                            Dibujo.dibujarPelota(row * 50, col * 50, JPTablero);
                        }
                        // si la batería está activa
                        if (banBateria) {
                            Dibujo.dibujarPila(xB, yB, JPTablero); // la agrega al tablero
                        }
                        // Dibujamos al robot sin batería
                        Dibujo.dibujarBOTSinPila(nx * 50, ny * 50, JPTablero);
                        jTAResultados.append("\nEl robot no cuenta con la suficiente energía\npara recoger la pelota o la batería \n");
                        
                        // el costo final y lo agregamos
                        int costo = (int) targetNode.getG();
                        jTAResultados.append("Costo Recorrido " + (i + 1) + ": " + costo + "\n");

                        bateria -= costo;
                        // y agregamos el estado de la batería
                        estadoBateria = bateria * 1 / 10;
                        jTAResultados.append("Estado de Bateria = " + estadoBateria + "% \n");
                        
                        // Estado de la batería para el recorrido de la siguiente pelotita  
                        int bateriaRec1 = (int) targetNode.getG() * 1 / 10;
                        // Estado de la batería para el recorrido de la recarga de batería
                        int bateriaRec2 = (int) distanciaRyB * 1 / 10;
                        // se agrega al tablero 
                        jTAResultados.append("Bateria necesaria para \nrecoger sig. pelota = " + bateriaRec1 + "%\n");
                        if(banBateria) // si la batería esta activa, se agrega
                            jTAResultados.append("Bateria necesaria para \nrecoger bateria = " + bateriaRec2 + "%\n");
                        // se pone la bateria en 0
                        bateria = 0;
                        // y termina el for 
                        break;
                    }
                }
                // Si la bateria se encuentra bien 

                // vuelve a iniciar el recorrido 
                startNode = grid[ny][nx];
                targetNode = grid[nyFin][nxFin];

                 // se limpia el recorrido 
                path.clear();
                // y se traza 
                graph.findPath(startNode, targetNode, path, banBateria, false);
                Graphics2D g = (Graphics2D) JPTablero.getGraphics();
                // recorrido en el tablero 
                graph.getNodes().forEach(node -> {
                    drawNode(g, node);
                });
                // se dibuja el reccorrido 
                drawPath(g);
                // se obtiene el costo
                int costo = (int) targetNode.getG();
                // y se agrega al Reporte
                jTAResultados.append("Costo Recorrido " + (i + 1) + ": " + costo + "\n");
                bateria -= costo;
                // junto con el estado de la bateria 
                estadoBateria = bateria * 1 / 10;
                jTAResultados.append("Estado de Bateria = " + estadoBateria + "% \n");
                // y se actualiza el estado actual del robot 
                nx = nxFin;
                ny = nyFin;
                // se eliminan las coordenadas
                coordX.remove(indice);
                coordY.remove(indice);
                cantCoord -= 1;
            }
        }
    }//GEN-LAST:event_jButIniciarActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IAFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPTablero;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButIniciar;
    private javax.swing.JButton jButTablero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBDificultadDificil;
    private javax.swing.JRadioButton jRBDificultadFacil;
    private javax.swing.JRadioButton jRBDificultadMedio;
    private javax.swing.JRadioButton jRBVelocidadLento;
    private javax.swing.JRadioButton jRBVelocidadMedio;
    private javax.swing.JRadioButton jRBVelocidadRapido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAResultados;
    // End of variables declaration//GEN-END:variables

   
}
