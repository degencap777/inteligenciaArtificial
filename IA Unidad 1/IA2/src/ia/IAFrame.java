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
    // Posición inicial BOT
    int x = 0, y = 0;

    // Posición inicial bateria
    int xB = 0, yB = 0;
    
    // Cantidad de objetos en el tablero 
    int cant = 2;
    
    // arreglo para almacenar los objetos en el tablero
    int evil[][];
    
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

        if (node == startNode)  // nodo inicio de color verde
            color = Color.GREEN;
        else if (node == targetNode)  // nodo destino de color rojo 
            color = Color.RED;
        else if (node.isBlocked())  // si esta bloqueado es negro 
            color = Color.BLACK;
        else if(node.isAgua()) // si es agua azul 
            color = Color.BLUE;
        else if(node.isTierra()) // si es tierra gris 
            color = Color.DARK_GRAY;
     
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
                    Thread.sleep(250);
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
    
    // Método para convertir de píxeles a coordenadas
    private int dePixelesACoordenadas(int aux) {
        int i = 0; //  Inicia en la posición 0 
        while (aux > 0) { // Ciclo hasta que los píxeles se terminen ( aux = 0)
                i++; // aumenta la posición 
                aux -= 50; // y disminuye las coordenadas
        }
        return i; // al final retorna la coordenada en donde se encuentra
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
        jPanel1 = new javax.swing.JPanel();
        jButTablero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRBDificultadFacil = new javax.swing.JRadioButton();
        jRBDificultadMedio = new javax.swing.JRadioButton();
        jRBDificultadDificil = new javax.swing.JRadioButton();
        jLabCosto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jRBVelocidadLento = new javax.swing.JRadioButton();
        jRBVelocidadMedio = new javax.swing.JRadioButton();
        jRBVelocidadRapido = new javax.swing.JRadioButton();
        jButIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IA RETBOT");
        setBackground(new java.awt.Color(153, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(750, 550));
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

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jButTablero.setText("Generar tablero");
        jButTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButTableroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dificultad");

        buttonGroup1.add(jRBDificultadFacil);
        jRBDificultadFacil.setSelected(true);
        jRBDificultadFacil.setText("Facil");

        buttonGroup1.add(jRBDificultadMedio);
        jRBDificultadMedio.setText("Medio");

        buttonGroup1.add(jRBDificultadDificil);
        jRBDificultadDificil.setText("Dificil");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRBDificultadFacil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBDificultadMedio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBDificultadDificil)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBDificultadFacil)
                    .addComponent(jRBDificultadMedio)
                    .addComponent(jRBDificultadDificil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButTablero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabCosto.setBackground(new java.awt.Color(51, 255, 255));
        jLabCosto.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Velocidad");

        buttonGroup2.add(jRBVelocidadLento);
        jRBVelocidadLento.setSelected(true);
        jRBVelocidadLento.setText("Lento");

        buttonGroup2.add(jRBVelocidadMedio);
        jRBVelocidadMedio.setText("Medio");

        buttonGroup2.add(jRBVelocidadRapido);
        jRBVelocidadRapido.setText("Rápido");

        jButIniciar.setText("Iniciar");
        jButIniciar.setEnabled(false);
        jButIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRBVelocidadLento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBVelocidadMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRBVelocidadRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBVelocidadLento)
                    .addComponent(jRBVelocidadMedio)
                    .addComponent(jRBVelocidadRapido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButIniciar)
                .addContainerGap())
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JPTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        //  Botón para generar el tablero 
    private void jButTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButTableroActionPerformed

        // Selección del modo de juegoFACIL, MEDIO o DIFICIL
        if(jRBDificultadFacil.isSelected()){
            cant = 10 + 2;
        }else if(jRBDificultadMedio.isSelected()){
            cant = 15 + 2;
        }else if(jRBDificultadDificil.isSelected()){
           cant = 20 + 2;
        }
       
        // Se dibuja el tablero
        Dibujo.dibujarTablero(JPTablero);
        
        // y se dimensiona el arreglo de las posiciones en el tablero
        evil = new int[cant][2];
        
        // se generan los números aleatorios, para las posiciones en el tablero
        Dibujo.aleatorios(evil, cant);
        // inicio 
        x = evil[0][0];
        y = evil[0][1];
        // fin
        xB = evil[1][0]; 
        yB = evil[1][1];
        
        // dibuja el robot (Inicio)
        Dibujo.dibujarBOT(x,y,JPTablero);
        // y un cuadrado (Fin)
        Dibujo.dibujarPila(xB, yB,JPTablero);
        
        // Esyablecemos el bloqueo en el tablero
        for(int i=2;i<(cant-2)/2;i++){
            int row = evil[i][0];
            int col = evil[i][1];
            Dibujo.dibujarBloqueo(row, col, JPTablero);  
        }
        // También tiramos en el tablero la tierra y el agua, 
        // para impedir el buen funcionamiento del bot
        for(int i=(cant-2)/2;i<cant-2;i++){
            // fila y columna en donde se colocara el agua 
            int row = evil[i][0];
            int col = evil[i][1];
            // se dibuja
            Dibujo.dibujarAgua(row, col, JPTablero);  
            
            i++; 
            // fila y columna en donde se colocara la tierra
            row = evil[i][0];
            col = evil[i][1];
            // se dibuja
            Dibujo.dibujarTierra(row, col, JPTablero);  
        }
        // Una vez establecido el tablero, podemos iniciar el recorrido
        jButIniciar.setEnabled(true);
    }//GEN-LAST:event_jButTableroActionPerformed

    private void jButIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButIniciarActionPerformed
        // inicio de la ruta 
        x = evil[0][0];
        y = evil[0][1];
        int nx = dePixelesACoordenadas(x);
        int ny = dePixelesACoordenadas(y);
        
        // fin de la ruta
        int nxFin = dePixelesACoordenadas(evil[1][0]);
        int nyFin = dePixelesACoordenadas(evil[1][1]);
        
        // creamos el la ruta a segur y el tablero 
        path = new ArrayList<>();
        grid = new Node[GRID_ROWS][GRID_COLS];

        // heuristica
        graph = new Graph<>((start, target, current) -> {
            // heuristic = linear distance
            int dx = target.getObj().x - current.getObj().x;
            int dy = target.getObj().y - current.getObj().y;
            return Math.sqrt(dx * dx + dy * dy);
        });
        // se crea el tablero 
        createGrid();

        // y se ingresan los obstaculos 
        // Nota: 0 y 1; es el inicio y el fin del recorrido, por eso inicia en 2 
        // Agregamos el bloqueo en el tablero 
        for(int i=2;i<(cant-2)/2;i++){
           int row = dePixelesACoordenadas(evil[i][0]);
            int col = dePixelesACoordenadas(evil[i][1]);
            grid[col][row].setBlocked(true);
        }
        //  También la tierra y agua
        for(int i=(cant-2)/2;i<cant-2;i++){
            // Agua
            int row = dePixelesACoordenadas(evil[i][0]);
            int col = dePixelesACoordenadas(evil[i][1]);
            grid[col][row].setAgua(true);
            i++; 
           
            // Tierra
            row = dePixelesACoordenadas(evil[i][0]);
            col = dePixelesACoordenadas(evil[i][1]);
            grid[col][row].setTierra(true);
        }
        
        
        // punto de partida 
        startNode = grid[ny][nx];
        // punto de llegada 
        targetNode = grid[nyFin][nxFin];
        
        // se limpia el recorrido 
        path.clear();
        // y se traza 
        graph.findPath(startNode, targetNode, path);
        Graphics2D g = (Graphics2D) JPTablero.getGraphics();
        
        // recorrido en el tablero 
        graph.getNodes().forEach(node -> {
            drawNode(g, node);
        });

        // se dibuja el reccorrido 
        drawPath(g);
        
        // y se establece el costo en un JLabel
        jLabCosto.setText("Costo "+((int) targetNode.getG()));
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
    private javax.swing.JLabel jLabCosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRBDificultadDificil;
    private javax.swing.JRadioButton jRBDificultadFacil;
    private javax.swing.JRadioButton jRBDificultadMedio;
    private javax.swing.JRadioButton jRBVelocidadLento;
    private javax.swing.JRadioButton jRBVelocidadMedio;
    private javax.swing.JRadioButton jRBVelocidadRapido;
    // End of variables declaration//GEN-END:variables

   
}
