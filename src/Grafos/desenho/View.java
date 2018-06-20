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
import Grafos.aplicacao.Campeao;
import Grafos.aplicacao.Composicao;
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
    Composicao comp;
    
    int nVert;
    int grafoMatriz[][];
    int grafoDigrafo;
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
        CompB = new javax.swing.JLabel();
        CompA = new javax.swing.JLabel();
        Resultado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        opcoes_Menu = new javax.swing.JMenu();
        carregarGrafo_Menu = new javax.swing.JMenuItem();
        salvarImagem_Menu = new javax.swing.JMenuItem();
        algoritmos_Menu = new javax.swing.JMenu();
        componentesConexas_Menu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        restaurar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        CompB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CompB.setForeground(new java.awt.Color(255, 0, 51));

        CompA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CompA.setForeground(new java.awt.Color(51, 102, 255));

        Resultado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Resultado.setForeground(new java.awt.Color(102, 255, 102));

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

        jMenuItem3.setText("Transposto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(jMenuItem3);
        algoritmos_Menu.add(jSeparator1);

        restaurar.setText("Restaurar Grafo");
        restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(restaurar);

        jMenuBar1.add(algoritmos_Menu);

        jMenu1.setText("Aplicacao");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(CompA, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(CompB, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CompB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CompA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Resultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarGrafo_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarGrafo_MenuActionPerformed
        JFileChooser fc = new JFileChooser();                           //escolhendo o arquivo
        int result = fc.showOpenDialog(getParent());                    //
        String arquivo = fc.getSelectedFile().getAbsolutePath();        //

        BufferedReader br = null, br1 = null, br2 = null;   //arquivo
        try {                                                       //carregando arquivos
            br = new BufferedReader(new FileReader(arquivo));       //matriz
            br1 = new BufferedReader(new FileReader(arquivo));      //lista
            br2 = new BufferedReader(new FileReader(arquivo));      //desenho
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            matriz.inicia(br);                              //iniciando grafo em modo matriz
            listaAdjacencia.iniciaListaAdjacencia(br1);     //iniciando grafo em modo lista adjacencia
            
            grafoMatriz = matriz.getMatriz();
            lista = listaAdjacencia.getListaAdj();
            
            try {
                grafoDigrafo = Integer.parseInt(br2.readLine());
                
                nVert =  Integer.parseInt(br2.readLine());

                this.graph = new Graph(nVert); ///desenho

                //leitura das arestas
                String line;
                while ((line = br2.readLine()) != null && line.trim().length() > 0) {
                    StringTokenizer t1 = new StringTokenizer(line, " ");

                    int vIni = Integer.parseInt(t1.nextToken().trim());     //vertice Inicial
                    int vFim = Integer.parseInt(t1.nextToken().trim());     //vertice Final
                    int vPeso = Integer.parseInt(t1.nextToken().trim());    //peso do vertice
                    
                    Vertex vS = this.graph.getVertex().get(vIni);
                    Vertex vT = this.graph.getVertex().get(vFim);           
//                    this.grafo.addAresta(vIni, vFim); //estrutura de dados
                    Edge e = new Edge(vS, vT, vPeso); //desenho
                    
                    if(grafoDigrafo == 0)       //desenhando setas ou não
                        e.setDirected(false);   //
                    
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
        dialog.setCurrentDirectory(new File("Área de Trabalho"));
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
         
        if(grafoDigrafo == 0){//se for grafo
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
    //            this.graph.getVertex().get(i).setColor(gs.getColor(cores[i] * coresStep));
            }
            this.view.cleanImage();
            this.view.repaint();
        }else JOptionPane.showMessageDialog(null,"O algoritmo é reestrito à grafos não orientados");
        
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
        
        for (int i = 0; i < nVert; i++){                                 //pintando todos vertices de preto
            this.graph.getVertex().get(i).setColor(rbS.getColor(0));    //
            this.graph.getVertex().get(i).setSelected(false);           //
        }    
        if(vertices.get(0) != -1)
            for (int i = 0; i < vertices.size(); i++){                                      //destacando
                this.graph.getVertex().get(vertices.get(i)).setColor(rbS.returnVermelho()); //o caminho
                this.graph.getVertex().get(vertices.get(i)).setSelected(true);              //                
            }
        this.view.cleanImage();
        this.view.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ArrayList <String> auxiliar;
        Vertice transposto [];// = new Vertice [nVert];
        if(grafoDigrafo == 1){                                  //iniciando o grafo transposto
                transposto = listaAdjacencia.iniciaTransposto(lista, nVert);
                lista = transposto;                                         //setando a lista transposta
                grafoMatriz = matriz.converteListaEmMatriz(lista, nVert);   //setando a matriz transposta 

            this.graph = new Graph(nVert); ///desenho
            for(Vertice vert : transposto){
                auxiliar = vert.getAdjacencia();
                Vertex vS = this.graph.getVertex().get(vert.getNumero());
                for(String aux : auxiliar){
                    String valorAdj[] = aux.split(" ");
                    Vertex vT = this.graph.getVertex().get(Integer.parseInt(valorAdj[0]));
    //                System.out.println("vs ->"+vert.getNumero());;
    //                System.out.println("vT ->"+Integer.parseInt(aux)+"\n");
                    Edge e = new Edge(vS ,vT , Integer.parseInt(valorAdj[1]) //peso da aresta//
                        ); //desenho
                    this.graph.addEdge(e);    //desenho
                }
            }
    //        this.view.cleanImage();
    //        this.view.repaint();
            this.view.setGraph(graph);
            this.view.cleanImage();
            this.view.repaint();
        }else JOptionPane.showMessageDialog(null,"O algoritmo é reestrito à digrafos");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarActionPerformed
        ArrayList <String> auxiliar;

        this.graph = new Graph(nVert); ///desenho
        
        for(Vertice vert : lista){
            auxiliar = vert.getAdjacencia();
            Vertex vS = this.graph.getVertex().get(vert.getNumero());
            for(String aux : auxiliar){
                String valorAdj[] = aux.split(" ");
                Vertex vT = this.graph.getVertex().get(Integer.parseInt(valorAdj[0]));
//                System.out.println("vs ->"+vert.getNumero());;
//                System.out.println("vT ->"+Integer.parseInt(aux)+"\n");
                Edge e = new Edge(vS ,vT , Integer.parseInt(valorAdj[1]) //peso da aresta//
                    ); //desenho
                if(grafoDigrafo == 0)
                    e.setDirected(false);
    
                this.graph.addEdge(e);    //desenho
            }
        }
        
        this.view.setGraph(graph);
        this.view.cleanImage();
        this.view.repaint();
    }//GEN-LAST:event_restaurarActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        //nao usado /// ignorar
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
             
        try {
            comp = new Composicao();
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader br = null, br1 = null, br2 = null;   //arquivo
        try {                                                  //carregando arquivos
            br = new BufferedReader(new FileReader("grafolol.txt"));       //matriz
            br1 = new BufferedReader(new FileReader("grafolol.txt"));      //lista
            br2 = new BufferedReader(new FileReader("grafolol.txt"));      //desenho
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        matriz.inicia(br);                              //iniciando grafo em modo matriz
        listaAdjacencia.iniciaListaAdjacencia(br1);     //iniciando grafo em modo lista adjacencia

        grafoMatriz = matriz.getMatriz();
        lista = listaAdjacencia.getListaAdj();

        try {
            grafoDigrafo = Integer.parseInt(br2.readLine());

            nVert =  Integer.parseInt(br2.readLine());

            this.graph = new Graph(nVert); ///desenho

            //leitura das arestas
            String line;
            while ((line = br2.readLine()) != null && line.trim().length() > 0) {
                StringTokenizer t1 = new StringTokenizer(line, " ");

                int vIni = Integer.parseInt(t1.nextToken().trim());     //vertice Inicial
                int vFim = Integer.parseInt(t1.nextToken().trim());     //vertice Final
                int vPeso = Integer.parseInt(t1.nextToken().trim());    //peso do vertice

                Vertex vS = this.graph.getVertex().get(vIni);
                Vertex vT = this.graph.getVertex().get(vFim);           
//                    this.grafo.addAresta(vIni, vFim); //estrutura de dados
                Edge e = new Edge(vS, vT, vPeso); //desenho

                if(grafoDigrafo == 0)       //desenhando setas ou não
                    e.setDirected(false);   //

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
        
        criarTimes();
        String compTeamA = analisarComp(comp.getTeamA());
        String compTeamB = analisarComp(comp.getTeamA());
        CompA.setText("Time A "+compTeamA);
        CompB.setText("Time B "+compTeamB);
        
        
       //analisar no grafo
        
//        Aplicacao aplicacao = new Aplicacao();
//        aplicacao.setVisible(true);
    }//GEN-LAST:event_jMenu1MenuSelected

    private void criarTimes(){
            Campeao[] TeamA = new Campeao[5];
            Campeao[] TeamB = new Campeao[5];
            Campeao campeao = null;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Top Lane do Team A"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamA[0] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Jungle Laner do Team A"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamA[1] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Mid Lane do Team A"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamA[2] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Bot Laner do Team A"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamA[3] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Suporte do Team A"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamA[4] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Top Lane do Team B"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamB[0] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Jungle Laner do Team B"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamB[1] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Mid Lane do Team B"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamB[2] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Bot Laner do Team B"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamB[3] = campeao;
            
            do{
                campeao = comp.buscarCampeao(JOptionPane.showInputDialog("Insira o Suporte do Team B"));
                if(campeao == null)JOptionPane.showMessageDialog(null,"Campeao nao encontrado");
            }while(campeao==null);
            TeamB[4] = campeao;
            
            comp.setTeamA(TeamA);
            comp.setTeamB(TeamB);
    }
    
    private String analisarComp(Campeao[] time){
        int[] funcoes = new int[5];
        int maior = 0;
        int composicao = 0;
        for(int i=0;i<funcoes.length;i++){
            funcoes[i]=0;
        }
        for(int i=0;i<time.length;i++){
            if(time[i].getFuncao().equals("dive"))funcoes[0]++;
            if(time[i].getFuncao().equals("aoe"))funcoes[1]++;
            if(time[i].getFuncao().equals("poke"))funcoes[2]++;
            if(time[i].getFuncao().equals("split"))return "split";
            if(time[i].getFuncao().equals("peel"))funcoes[4]++;
        }
        for(int i=0;i<funcoes.length;i++){
            if(funcoes[i] > maior){
                maior = funcoes[i];
                composicao = i;
            }
        }
        if(composicao == 0)return "dive";
        if(composicao == 1)return "aoe";
        if(composicao == 2)return "poke";
        if(composicao == 4)return "peel";
        return "nao possui sinergia";
    }
    
    
    
    
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
    private javax.swing.JLabel CompA;
    private javax.swing.JLabel CompB;
    private javax.swing.JLabel Resultado;
    private javax.swing.JMenu algoritmos_Menu;
    private javax.swing.JMenuItem carregarGrafo_Menu;
    private javax.swing.JMenuItem componentesConexas_Menu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu opcoes_Menu;
    private javax.swing.JMenuItem restaurar;
    private javax.swing.JMenuItem salvarImagem_Menu;
    // End of variables declaration//GEN-END:variables
}
