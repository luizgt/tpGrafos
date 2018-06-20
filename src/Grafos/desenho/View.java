/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * View.java
 *
 * Created on 09/05/2012, 14:57:16
 */
package Grafos.desenho;

import Grafos.ListaAdjacencia;
import Grafos.MatrizAdjacencia;
import Grafos.Vertice;
import Grafos.classe.Coloracao;
import Grafos.classe.DFS;
import Grafos.classe.BFS;
import Grafos.desenho.color.GrayScale;
import Grafos.desenho.color.RainbowScale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Danilo Medeiros Eler
 */
public class View extends javax.swing.JFrame {
    MatrizAdjacencia matriz = new MatrizAdjacencia();
    ListaAdjacencia listaAdjacencia = new ListaAdjacencia();
    
    int nVert;
    int grafoMatriz[][];
    Vertice lista[];
    
    /** Creates new form View */
    public View() {
        this.view = new ViewPanel();
        //this.view.setGraph(this.graph);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane(this.view);
        jMenuBar1 = new javax.swing.JMenuBar();
        opcoes_Menu = new javax.swing.JMenu();
        carregarGrafo_Menu = new javax.swing.JMenuItem();
        salvarImagem_Menu = new javax.swing.JMenuItem();
        algoritmos_Menu = new javax.swing.JMenu();
        componentesConexas_Menu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        opcoes_Menu.setText("Opções");

        carregarGrafo_Menu.setText("Carregar Grafo");
        carregarGrafo_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarGrafo_MenuActionPerformed(evt);
            }
        });
        opcoes_Menu.add(carregarGrafo_Menu);

        salvarImagem_Menu.setText("Salvar Imagem");
        salvarImagem_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarImagem_MenuActionPerformed(evt);
            }
        });
        opcoes_Menu.add(salvarImagem_Menu);

        jMenuBar1.add(opcoes_Menu);

        algoritmos_Menu.setText("Algoritmos");

        componentesConexas_Menu.setText("Marcar Componentes Conexas");
        componentesConexas_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentesConexas_MenuActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(componentesConexas_Menu);

        jMenuItem1.setText("Coloração");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(jMenuItem1);

        jMenuItem2.setText("Caminho 'u' à 'v'");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(jMenuItem2);

        jMenuBar1.add(algoritmos_Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarGrafo_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarGrafo_MenuActionPerformed
        JFileChooser fc = new JFileChooser();                           //escolhendo o arquivo
        int result = fc.showOpenDialog(getParent());                    //
        String arquivo = fc.getSelectedFile().getAbsolutePath();        //

        BufferedReader br = null, br1 = null, br2 = null;   //arquivo
        try {
            br = new BufferedReader(new FileReader(arquivo));       //carregando arquivos
            br1 = new BufferedReader(new FileReader(arquivo));      //
            br2 = new BufferedReader(new FileReader(arquivo));      //
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            matriz.inicia(br);                              //iniciando grafo em modo matriz
            grafoMatriz = matriz.getMatriz();
            listaAdjacencia.iniciaListaAdjacencia(br1);     //iniciando grafo em modo lista adjacencia
            lista = listaAdjacencia.getListaAdj();
            
            try {
                Integer.parseInt(br2.readLine());
                nVert =  Integer.parseInt(br2.readLine());

                this.graph = new Graph(nVert); ///desenho

                //leitura das arestas
                String line;
                while ((line = br2.readLine()) != null && line.trim().length() > 0) {
                    StringTokenizer t1 = new StringTokenizer(line, " ");

                    int vIni = Integer.parseInt(t1.nextToken().trim()); //verticeInicial
                    int vFim = Integer.parseInt(t1.nextToken().trim()); //verticeFinal
                    int vPeso = Integer.parseInt(t1.nextToken().trim()); //peso do vertice
                    
                    Vertex vS = this.graph.getVertex().get(vIni);
                    Vertex vT = this.graph.getVertex().get(vFim);
                    
//                    this.grafo.addAresta(vIni, vFim); //estrutura de dados
                    Edge e = new Edge(vS, vT, vPeso); //desenho
                    //Exemplo de seleção de aresta
                    if (vIni % 2 == 0){
//                        e.setSelected(true);                        
                    }
                    
                    this.graph.addEdge(e);    //desenho
                }

                this.view.setGraph(graph);

            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //fechar o arquivo
                if (br != null) {
                    try {
                        br.close();
                        br1.close();
                        br2.close();
                    } catch (IOException ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_carregarGrafo_MenuActionPerformed

    private void salvarImagem_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarImagem_MenuActionPerformed
        // TODO add your handling code here:
        JFileChooser dialog = new JFileChooser();
        dialog.setMultiSelectionEnabled(false);
        dialog.setDialogTitle("Save file");
        dialog.setCurrentDirectory(new File("D:\\DANILO\\UNESP\\2017\\Aulas\\Grafos"));
        int result = dialog.showDialog(this, "Salvar");
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String filename = dialog.getSelectedFile().getAbsolutePath();
                this.view.saveToPngImageFile(filename);
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_salvarImagem_MenuActionPerformed

    private void componentesConexas_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentesConexas_MenuActionPerformed
        DFS dfs = new DFS();
        dfs.conexoMatriz(grafoMatriz,nVert);
        
//        System.out.println(dfs.getResultado());
        
        int comp[] = dfs.getComponentes();
        int compStep = 255 / lista.length;

        RainbowScale rbS = new RainbowScale();
        for (int i = 0; i < lista.length; i++) {
//            System.out.println("Vertice: " + i + " Compoente: " + comp[i]);
            this.graph.getVertex().get(i).setColor(rbS.getColor(comp[i] * compStep));
        }
        this.view.cleanImage();
        this.view.repaint();
    }//GEN-LAST:event_componentesConexas_MenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         
          //se for grafo
          Coloracao coloracao = new Coloracao();
          coloracao.execute(lista);
        int cores[] = coloracao.getCores();
        int nCores = coloracao.getNumCores();
//        
        int coresStep = 255 / nCores;
        RainbowScale rbS = new RainbowScale();
        GrayScale gs = new GrayScale();
        for (int i = 0; i < cores.length; i++) {
            System.out.println("Vertice: " + i + " Cor: " + cores[i]);
            this.graph.getVertex().get(i).setColor(rbS.getColor(cores[i] * coresStep));
            this.graph.getVertex().get(i).setColor(gs.getColor(cores[i] * coresStep));
        }
        this.view.cleanImage();
        this.view.repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int vert1 = Integer.parseInt(JOptionPane.showInputDialog("Vértice u:"));
        int vert2 = Integer.parseInt(JOptionPane.showInputDialog("Vértice v:"));
        DFS dfs = new DFS();
        BFS bfs = new BFS();

        ArrayList <Integer> vertices = new ArrayList <Integer>();
        
        RainbowScale rbS = new RainbowScale();
        int comp[] = dfs.getComponentes();

        String opt[] = {"DFS","BFS"};
        int busca = JOptionPane.showOptionDialog(null,
            "Escolha o tipo de BUSCA",
            "DFS x BFS",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opt,
            0);

        if(busca == 0){         //DFS
            dfs.caminhoMatriz(vert1, vert2, grafoMatriz, nVert);
            vertices = dfs.getVertices();
//            System.out.println(dfs.getResultado());
        } else{                 //BFS
            bfs.verificaCaminhoMatriz(vert1, vert2, grafoMatriz, nVert);
            vertices = bfs.getVertices();
        }
        
        for (int i = 0; i < nVert; i++)                                 //pintando todos vertices de preto
            this.graph.getVertex().get(i).setColor(rbS.getColor(0));    //
        
        if(vertices.get(0) != -1)
            for (int i = 0; i < vertices.size(); i++)                                           //destacando
                this.graph.getVertex().get(vertices.get(i)).setColor(rbS.returnVermelho());     //o caminho
        
        this.view.cleanImage();
        this.view.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public class ViewPanel extends JPanel {

        public ViewPanel() {
            this.setBackground(java.awt.Color.WHITE);
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            ////configuração do rendering para obeter melhor qualidade
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

            if (graph != null && this.imageBuffer == null) {
                this.imageBuffer = new BufferedImage(graph.getSize().width + 1,
                        graph.getSize().height + 1, BufferedImage.TYPE_INT_RGB);

                java.awt.Graphics2D g2Buffer = this.imageBuffer.createGraphics();
                g2Buffer.setColor(this.getBackground());
                g2Buffer.fillRect(0, 0, graph.getSize().width + 1, graph.getSize().height + 1);

                g2Buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                graph.draw(g2Buffer);
                g2Buffer.dispose();
            }

            if (this.imageBuffer != null) {
                g2.drawImage(this.imageBuffer, 0, 0, null);
            }
        }

        public void saveToPngImageFile(String filename) throws IOException {
            try {
                //this.paint(this.imageBuffer.getGraphics());
                ImageIO.write(this.imageBuffer, "png", new File(filename));
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void setGraph(Graph graph) {
            if (graph != null) {
                this.setPreferredSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));
                this.setSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));

                this.cleanImage();
                this.repaint();
            }
        }

        public Vertex getMarkedVertex() {
            return markedVertex;
        }

        public void cleanImage() {
            this.imageBuffer = null;
        }

        public void adjustPanel() {
            float iniX = graph.getVertex().get(0).getX();
            float iniY = graph.getVertex().get(0).getY();
            float max_x = iniX, max_y = iniX;
            float min_x = iniY, min_y = iniY;
            int zero = graph.getVertex().get(0).getRay() * 5 + 10;

            for (int i = 1; i < graph.getVertex().size(); i++) {
                float x = graph.getVertex().get(i).getX();
                if (max_x < x) {
                    max_x = x;
                } else if (min_x > x) {
                    min_x = x;
                }

                float y = graph.getVertex().get(i).getY();
                if (max_y < y) {
                    max_y = y;
                } else if (min_y > y) {
                    min_y = y;
                }
            }

            for (Vertex v : graph.getVertex()) {
                v.setX(v.getX() + zero - min_x);
                v.setY(v.getY() + zero - min_y);
            }

            Dimension d = this.getSize();
            d.width = (int) max_x + zero;
            d.height = (int) max_y + zero;
            this.setSize(d);
            this.setPreferredSize(d);
        }

        public void markVertices(ArrayList<Vertex> vertices) {
            if (vertices != null) {
                this.cleanMarkedVertices(false);

                //change the vertices' colors
                for (Vertex v : vertices) {
                    v.setSelected(true);
                }

                this.cleanImage();
                this.repaint();
            }
        }

        public void cleanMarkedVertices(boolean cleanVertex) {
            if (graph != null) {
                this.markedVertex = null;

                for (Vertex vertex : graph.getVertex()) {
                    vertex.setSelected(false);

                }
            }

            this.cleanImage();
            this.repaint();
        }

        @Override
        public void setFont(java.awt.Font font) {
            //
        }

        @Override
        public java.awt.Font getFont() {
            return null;// colocar alguma fonte
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);

        }
        private java.awt.Color color = java.awt.Color.RED;
        //Used to color based on a document
        private Vertex markedVertex;
        //Used to move the points
        private Vertex selectedVertex;
        //contain the selected vertices which will be moved
        private ArrayList<Vertex> selectedVertices;
        //The image which will be drawn as a graph
        private BufferedImage imageBuffer;
    }
    private ViewPanel view;
    private Graph graph;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu algoritmos_Menu;
    private javax.swing.JMenuItem carregarGrafo_Menu;
    private javax.swing.JMenuItem componentesConexas_Menu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu opcoes_Menu;
    private javax.swing.JMenuItem salvarImagem_Menu;
    // End of variables declaration//GEN-END:variables
}
