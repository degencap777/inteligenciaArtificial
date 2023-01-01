package u4_algoritmos.geneticos; // PAQUETE GENERADO POR JAVA

// Clases importadas utilizadas en este proyecto
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
///---------------------------------------------------------------------------------
/*PROYECTO UNIDAD 4 : ALGORITMOS GENETICOS
   INTELIGENCIA ARTIFICIAL AGOSTO-DICIEMBRE 2022
*/
///----------------------------------------------------------------------------------
public class U4_Frame extends javax.swing.JFrame {
/// ZONA DE DECLARACION DE VARIABLES
    int cromosomas [][], nuevosCromosomas[][];
    int cantCromo;
    int fx[];
    double fitness[], Probability[], probabilidadAcumulada[];
    
    Random azar = new Random(); // Instanciamiento de la clase random
    // estados del elefante
    int ePierna = 3, eOreja = 3, eColmillos = 3, eProbo = 3;
     Calculos cal = null; // Objeto de la clase Calculos
 ///---------------------------------------------------------------------------------   
    public U4_Frame() {
        initComponents(); // Inicializamos los componentes GUI
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        cicloActual = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jRBPiernaChica = new javax.swing.JRadioButton();
        jRBPiernaMediana = new javax.swing.JRadioButton();
        jRBPiernaGrande = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jRBOrejaChica = new javax.swing.JRadioButton();
        jRBOrejaMediana = new javax.swing.JRadioButton();
        jRBOrejaGrande = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jRBColmillosChica = new javax.swing.JRadioButton();
        jRBColmillosMediana = new javax.swing.JRadioButton();
        jRBColmillosGrande = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jRBTrompaChica = new javax.swing.JRadioButton();
        jRBTrompaMediana = new javax.swing.JRadioButton();
        jRBTrompaGrande = new javax.swing.JRadioButton();
        jPanelElefante2 = new javax.swing.JPanel();
        jPanelElefante = new javax.swing.JPanel();
        jPanelElefante3 = new javax.swing.JPanel();
        jPanelElefante4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jRBRapido = new javax.swing.JRadioButton();
        jRBLento = new javax.swing.JRadioButton();
        jPanelElefante5 = new javax.swing.JPanel();
        jPanelElefante6 = new javax.swing.JPanel();
        jPanelElefante7 = new javax.swing.JPanel();
        jPanelElefante8 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOpciones = new javax.swing.JMenu();
        jMenuIniciar = new javax.swing.JMenuItem();
        jMenuPausar = new javax.swing.JMenuItem();
        jMenuReanudar = new javax.swing.JMenuItem();
        jMenuInfo = new javax.swing.JMenu();
        jMenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("U4  ALGORITMOS GENETICOS ");

        jLabel6.setText("Generacion actual:");

        cicloActual.setText("0");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setText("Piernas");

        buttonGroup1.add(jRBPiernaChica);
        jRBPiernaChica.setText("Chica");
        jRBPiernaChica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBPiernaChicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBPiernaMediana);
        jRBPiernaMediana.setText("Mediana");
        jRBPiernaMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBPiernaMedianaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBPiernaGrande);
        jRBPiernaGrande.setSelected(true);
        jRBPiernaGrande.setText("Grande");
        jRBPiernaGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBPiernaGrandeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBPiernaChica)
                    .addComponent(jRBPiernaMediana)
                    .addComponent(jRBPiernaGrande))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBPiernaChica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBPiernaMediana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBPiernaGrande)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel3.setText("Oreja");

        buttonGroup2.add(jRBOrejaChica);
        jRBOrejaChica.setText("Chica");
        jRBOrejaChica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBOrejaChicaActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBOrejaMediana);
        jRBOrejaMediana.setText("Mediana");
        jRBOrejaMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBOrejaMedianaActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBOrejaGrande);
        jRBOrejaGrande.setSelected(true);
        jRBOrejaGrande.setText("Grande");
        jRBOrejaGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBOrejaGrandeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRBOrejaChica)
                            .addComponent(jRBOrejaMediana)
                            .addComponent(jRBOrejaGrande))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBOrejaChica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBOrejaMediana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBOrejaGrande))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        jLabel4.setText("Colmillos");

        buttonGroup3.add(jRBColmillosChica);
        jRBColmillosChica.setText("Chica");
        jRBColmillosChica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBColmillosChicaActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRBColmillosMediana);
        jRBColmillosMediana.setText("Mediana");
        jRBColmillosMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBColmillosMedianaActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRBColmillosGrande);
        jRBColmillosGrande.setSelected(true);
        jRBColmillosGrande.setText("Grande");
        jRBColmillosGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBColmillosGrandeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBColmillosChica)
                    .addComponent(jRBColmillosMediana)
                    .addComponent(jRBColmillosGrande))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBColmillosChica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBColmillosMediana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBColmillosGrande)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jLabel5.setText("Probóscide");

        buttonGroup4.add(jRBTrompaChica);
        jRBTrompaChica.setText("Chica");
        jRBTrompaChica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTrompaChicaActionPerformed(evt);
            }
        });

        buttonGroup4.add(jRBTrompaMediana);
        jRBTrompaMediana.setText("Mediana");
        jRBTrompaMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTrompaMedianaActionPerformed(evt);
            }
        });

        buttonGroup4.add(jRBTrompaGrande);
        jRBTrompaGrande.setSelected(true);
        jRBTrompaGrande.setText("Grande");
        jRBTrompaGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTrompaGrandeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jRBTrompaChica)
                    .addComponent(jRBTrompaMediana)
                    .addComponent(jRBTrompaGrande))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBTrompaChica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBTrompaMediana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBTrompaGrande))
        );

        jPanelElefante2.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefante2Layout = new javax.swing.GroupLayout(jPanelElefante2);
        jPanelElefante2.setLayout(jPanelElefante2Layout);
        jPanelElefante2Layout.setHorizontalGroup(
            jPanelElefante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefante2Layout.setVerticalGroup(
            jPanelElefante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jPanelElefante.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefanteLayout = new javax.swing.GroupLayout(jPanelElefante);
        jPanelElefante.setLayout(jPanelElefanteLayout);
        jPanelElefanteLayout.setHorizontalGroup(
            jPanelElefanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefanteLayout.setVerticalGroup(
            jPanelElefanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jPanelElefante3.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefante3Layout = new javax.swing.GroupLayout(jPanelElefante3);
        jPanelElefante3.setLayout(jPanelElefante3Layout);
        jPanelElefante3Layout.setHorizontalGroup(
            jPanelElefante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefante3Layout.setVerticalGroup(
            jPanelElefante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jPanelElefante4.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefante4Layout = new javax.swing.GroupLayout(jPanelElefante4);
        jPanelElefante4.setLayout(jPanelElefante4Layout);
        jPanelElefante4Layout.setHorizontalGroup(
            jPanelElefante4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefante4Layout.setVerticalGroup(
            jPanelElefante4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));

        jLabel7.setText("Velocidad");

        buttonGroup5.add(jRBRapido);
        jRBRapido.setText("Rapido");
        jRBRapido.setEnabled(false);
        jRBRapido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBRapidoActionPerformed(evt);
            }
        });

        buttonGroup5.add(jRBLento);
        jRBLento.setSelected(true);
        jRBLento.setText("Lento");
        jRBLento.setEnabled(false);
        jRBLento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBLentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jRBRapido)
                    .addComponent(jRBLento))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBRapido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBLento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelElefante5.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefante5Layout = new javax.swing.GroupLayout(jPanelElefante5);
        jPanelElefante5.setLayout(jPanelElefante5Layout);
        jPanelElefante5Layout.setHorizontalGroup(
            jPanelElefante5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefante5Layout.setVerticalGroup(
            jPanelElefante5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jPanelElefante6.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefante6Layout = new javax.swing.GroupLayout(jPanelElefante6);
        jPanelElefante6.setLayout(jPanelElefante6Layout);
        jPanelElefante6Layout.setHorizontalGroup(
            jPanelElefante6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefante6Layout.setVerticalGroup(
            jPanelElefante6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jPanelElefante7.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefante7Layout = new javax.swing.GroupLayout(jPanelElefante7);
        jPanelElefante7.setLayout(jPanelElefante7Layout);
        jPanelElefante7Layout.setHorizontalGroup(
            jPanelElefante7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefante7Layout.setVerticalGroup(
            jPanelElefante7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jPanelElefante8.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanelElefante8Layout = new javax.swing.GroupLayout(jPanelElefante8);
        jPanelElefante8.setLayout(jPanelElefante8Layout);
        jPanelElefante8Layout.setHorizontalGroup(
            jPanelElefante8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanelElefante8Layout.setVerticalGroup(
            jPanelElefante8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        jMenuOpciones.setText("Menu");

        jMenuIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Play.png"))); // NOI18N
        jMenuIniciar.setText("Iniciar");
        jMenuIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIniciarActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuIniciar);

        jMenuPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Reposo.png"))); // NOI18N
        jMenuPausar.setText("Pausar");
        jMenuPausar.setEnabled(false);
        jMenuPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPausarActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuPausar);

        jMenuReanudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Reanudar.png"))); // NOI18N
        jMenuReanudar.setText("Reanudar");
        jMenuReanudar.setEnabled(false);
        jMenuReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReanudarActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuReanudar);

        jMenuBar1.add(jMenuOpciones);

        jMenuInfo.setText("Información ");

        jMenuAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/informacion.png"))); // NOI18N
        jMenuAcercaDe.setText("Acerca de");
        jMenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAcercaDeActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuAcercaDe);

        jMenuBar1.add(jMenuInfo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelElefante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelElefante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelElefante5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelElefante7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cicloActual, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanelElefante3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelElefante4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelElefante6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelElefante8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelElefante7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelElefante8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelElefante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelElefante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelElefante3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelElefante4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelElefante5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelElefante6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cicloActual))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
///---------------------------------------------------------------------------------
/// BOTON INICIO QUE SE ENCUENTRA EN EL JMENU EN LA PARTE SUPERIOR
    // Menu > Iniciar
    private void jMenuIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIniciarActionPerformed
        jMenuIniciar.setEnabled(false); // Inhabilita el Boton iniciar cuando empieze el proceso
        jMenuPausar.setEnabled(true); // Habilita la opcion de pausar la mutacion
        jRBLento.setEnabled(true); // Habilita los radiobuttons de lento y
        jRBRapido.setEnabled(true); // rapido
        cantCromo = 18; // Cantidad de cromosomas
        // INSTANCIAMIENTO DE LAS VARIBLES DECLARADAS PARA LOS CALCULOS
        cromosomas = new int[cantCromo][4];
        nuevosCromosomas = new int[cantCromo][4];
        fx = new int[cantCromo];
        fitness = new double[cantCromo];
        Probability = new double[cantCromo];
        probabilidadAcumulada = new double[cantCromo+1];
      ///---------------------------------------------------------------------------------
        System.out.println("Individuos : "+cantCromo); // Separador
        System.out.println("\nCromosoma\ta\tb\tc\td"); // Creacion de tabla en consola
        for(int i=0; i<cantCromo;i++){
             System.out.print((i+1)+"\t");
            for(int j=0; j<4; j++){
                int ale = azar.nextInt(30)+1; // Genera numero aleatorio entre 1 y 30
                cromosomas[i][j] = ale; // Lo almacena en el arreglo cromosomas
                System.out.print("\t"+ale);
            }
            System.out.println("");
        }
       // Inicializacion del objeto cal, peteneciente al objeto de calculos
        cal = new Calculos(cromosomas, nuevosCromosomas, cantCromo, fx, fitness, Probability, probabilidadAcumulada, 
                ePierna, eOreja, eColmillos, eProbo, cicloActual, jMenuIniciar,jMenuPausar,jMenuPausar,
                jPanelElefante,jPanelElefante2,jPanelElefante3,jPanelElefante4, 
                jPanelElefante5,jPanelElefante6,jPanelElefante7,jPanelElefante8);
        
        cal.start();// Empieza el proceso
        buttonGroup5.clearSelection(); // Si aun no iniciar el proceso se podria decir que no estaria seleccionando algo
        jRBLento.setSelected(true); // Por defecto la velocidad a la que va la mutacion es "Lenta"
    }//GEN-LAST:event_jMenuIniciarActionPerformed
///---------------------------------------------------------------------------------
    /// BOTON PAUSAR, SE ENCUENTRA EN EL JMENU.
    // Menu > Pausar
    private void jMenuPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPausarActionPerformed
        jMenuPausar.setEnabled(false); // Se inhabilita el boton de pausar, porque ya fue presionado
        jMenuReanudar.setEnabled(true); // Se  habilita el boton para poder reanuadar el proceso
         if(cal != null){
            cal.suspend();
         }
    }//GEN-LAST:event_jMenuPausarActionPerformed
///---------------------------------------------------------------------------------
    /// BOTON REANUDAR, SE ENCUENTRA EN EL JMENU
    // Menu > Reanudar
    private void jMenuReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReanudarActionPerformed
        jMenuPausar.setEnabled(true); // Se habilita el boton de pausar porque esta activo el proceso de mutaciones
        jMenuReanudar.setEnabled(false); // Se inhabilita el boton de reanudar porque ya hay un proceso activo
         if(cal != null){
        cal.resume();
         }
    }//GEN-LAST:event_jMenuReanudarActionPerformed
///---------------------------------------------------------------------------------
    // BOTON DE TIPO JITEM, SE ENCUENTRA EN EL JMENU DE "Informacion"
    // Este boton solo muestra informacion acerca de los desarrolladores del programa
    private void jMenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAcercaDeActionPerformed
// Integrantes del equipo
    JOptionPane.showMessageDialog(this, "Proyecto de la Unidad 4: ALGORITMOS GENETICOS\n"+
            "19130527 Fatima Gorety Garcia Yescas\n"+
            "19130547 Jesus Rafael Medina Dimas\n"+
            "19130514 Isaias Gerardo Cordova Palomares\n"+
            "19130535 Ivan Herrera Garica \n"+
            "19130519 Roberto Esquivel Troncoso","Acerca De",1);
    }//GEN-LAST:event_jMenuAcercaDeActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la pierna chica
    private void jRBPiernaChicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBPiernaChicaActionPerformed
         // Asignamos valor de 1, que vendria sirve como identificador como 
         // parte "chica"
        ePierna = 1;
    }//GEN-LAST:event_jRBPiernaChicaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la pierna mediana
    private void jRBPiernaMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBPiernaMedianaActionPerformed
     // Asignamos valor de 2, que vendria sirve como identificador como 
         // parte "mediana"
        ePierna = 2;
    }//GEN-LAST:event_jRBPiernaMedianaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la pierna grande
    private void jRBPiernaGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBPiernaGrandeActionPerformed
       // Asignamos valor de 3, que vendria sirve como identificador como 
         // parte "grande"
        ePierna = 3;
    }//GEN-LAST:event_jRBPiernaGrandeActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la oreja chica
    private void jRBOrejaChicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBOrejaChicaActionPerformed
// Asignamos valor de 1, que vendria sirve como identificador como 
         // parte "chica"
        eOreja = 1;
    }//GEN-LAST:event_jRBOrejaChicaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la oreja mediana
    private void jRBOrejaMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBOrejaMedianaActionPerformed
 // Asignamos valor de 2, que vendria sirve como identificador como 
         // parte "mediana"
        eOreja = 2;
    }//GEN-LAST:event_jRBOrejaMedianaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la oreja grande
    private void jRBOrejaGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBOrejaGrandeActionPerformed
    // Asignamos valor de 3, que vendria sirve como identificador como 
         // parte "chica"
        eOreja = 3;
    }//GEN-LAST:event_jRBOrejaGrandeActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para los comillos chicos
    private void jRBColmillosChicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBColmillosChicaActionPerformed
   // Asignamos valor de 1, que vendria sirve como identificador como 
         // parte "chica"
        eColmillos = 1;
    }//GEN-LAST:event_jRBColmillosChicaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para los colmillos medianos
    private void jRBColmillosMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBColmillosMedianaActionPerformed
   // Asignamos valor de 2, que vendria sirve como identificador como 
         // parte "mediano"
        eColmillos = 2;
    }//GEN-LAST:event_jRBColmillosMedianaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la colmillos grandes
    private void jRBColmillosGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBColmillosGrandeActionPerformed
       // Asignamos valor de 3, que vendria sirve como identificador como 
         // parte "grandes"
        eColmillos = 3;
    }//GEN-LAST:event_jRBColmillosGrandeActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la trompa chica
    private void jRBTrompaChicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTrompaChicaActionPerformed
       // Asignamos valor de 1, que vendria sirve como identificador como 
         // parte "chica"
        eProbo = 1;
    }//GEN-LAST:event_jRBTrompaChicaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la trompa mediana
    private void jRBTrompaMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTrompaMedianaActionPerformed
    // Asignamos valor de 2, que vendria sirve como identificador como 
         // parte "mediana"
        eProbo = 2;
    }//GEN-LAST:event_jRBTrompaMedianaActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la trompa grande
    private void jRBTrompaGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTrompaGrandeActionPerformed
        // Asignamos valor de 3, que vendria sirve como identificador como 
         // parte "grande"
        eProbo = 3;
    }//GEN-LAST:event_jRBTrompaGrandeActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la velocidad lenta
    private void jRBLentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBLentoActionPerformed
         if(cal != null){
            cal.setVelocidad(false); // Ajusta el booleano a falso
            // y recordemos que en la clase calculos cuando es Falso.
            // la velocidad o delay sera de 400 ms
         }
    }//GEN-LAST:event_jRBLentoActionPerformed
///---------------------------------------------------------------------------------
/// Radio Button para la velocidad rapida
    private void jRBRapidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBRapidoActionPerformed
         if(cal != null){
            cal.setVelocidad(true); // Ajusta el booleano a verdadero
            // Recordando que si es verdadero, entonces la velocidad
            // o delay sera solo de 100ms.
        }
        
    }//GEN-LAST:event_jRBRapidoActionPerformed

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
            java.util.logging.Logger.getLogger(U4_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(U4_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(U4_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(U4_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new U4_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel cicloActual;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuAcercaDe;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuInfo;
    private javax.swing.JMenuItem jMenuIniciar;
    private javax.swing.JMenu jMenuOpciones;
    private javax.swing.JMenuItem jMenuPausar;
    private javax.swing.JMenuItem jMenuReanudar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelElefante;
    private javax.swing.JPanel jPanelElefante2;
    private javax.swing.JPanel jPanelElefante3;
    private javax.swing.JPanel jPanelElefante4;
    private javax.swing.JPanel jPanelElefante5;
    private javax.swing.JPanel jPanelElefante6;
    private javax.swing.JPanel jPanelElefante7;
    private javax.swing.JPanel jPanelElefante8;
    private javax.swing.JRadioButton jRBColmillosChica;
    private javax.swing.JRadioButton jRBColmillosGrande;
    private javax.swing.JRadioButton jRBColmillosMediana;
    private javax.swing.JRadioButton jRBLento;
    private javax.swing.JRadioButton jRBOrejaChica;
    private javax.swing.JRadioButton jRBOrejaGrande;
    private javax.swing.JRadioButton jRBOrejaMediana;
    private javax.swing.JRadioButton jRBPiernaChica;
    private javax.swing.JRadioButton jRBPiernaGrande;
    private javax.swing.JRadioButton jRBPiernaMediana;
    private javax.swing.JRadioButton jRBRapido;
    private javax.swing.JRadioButton jRBTrompaChica;
    private javax.swing.JRadioButton jRBTrompaGrande;
    private javax.swing.JRadioButton jRBTrompaMediana;
    // End of variables declaration//GEN-END:variables
}
