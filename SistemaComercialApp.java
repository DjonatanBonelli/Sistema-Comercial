package sistema.comercial.App;

import java.util.Collection;
import java.util.stream.Stream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.comercial.Entities.Itens;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import sistema.comercial.Entities.ItensVendidos;
import sistema.comercial.Entities.Vendas;

public class SistemaComercialApp extends javax.swing.JFrame {

    private static final String WS_URL = "http://localhost:8080/gerenciamento";
    private static final String WS_URL2 = "http://localhost:8080/vendas";
    
    public SistemaComercialApp() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        pnlCadastro.setVisible(false);
        pnlVendas.setVisible(true);
        pnlRelatorio.setVisible(false); 
        
        //carrega as tabelas
        tblProdutos.setModel(new DefaultTableModel());
        tblVendas.setModel(new DefaultTableModel());
        tblRelatorio.setModel(new DefaultTableModel());
        loadTableData();
        DefaultTableModel tableModelVendas = (DefaultTableModel) tblRelatorio.getModel();
        tableModelVendas.setColumnIdentifiers(new Object[]{"ID", "Data", "Total"});
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data = LocalDateTime.now();
        String dataHoraFormatada = data.format(formato);
        edtVendasData.setText(dataHoraFormatada);
        
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlCadastro = new javax.swing.JPanel();
        edtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        edtPreco = new javax.swing.JTextField();
        selCategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVendas1 = new javax.swing.JButton();
        btnRelatorio1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnDeletar = new javax.swing.JButton();
        pnlVendas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        edtVendasTotal = new javax.swing.JTextField();
        edtVendasRecebido = new javax.swing.JTextField();
        edtVendasTroco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtVendasQuantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edtVendasData = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        edtVendasId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        edtVendasNome = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        edtVendasPreco = new javax.swing.JTextField();
        selVendasCategoria = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        btnVendaAdicionar = new javax.swing.JButton();
        btnVendaRemover = new javax.swing.JButton();
        btnVendaFinalizar = new javax.swing.JButton();
        btnVendasLimpar = new javax.swing.JButton();
        btnVendasBuscar = new javax.swing.JButton();
        btnVendasCalculaTroco = new javax.swing.JButton();
        pnlRelatorio = new javax.swing.JPanel();
        selRelatorioTempo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRelatorio = new javax.swing.JTable();
        btnCadastro2 = new javax.swing.JButton();
        btnVendas2 = new javax.swing.JButton();
        btnRelatorioBusca = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        edtRelatorioTotalVendido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Comercial");

        pnlMain.setLayout(new java.awt.CardLayout());

        jLabel5.setText("Nome");

        jLabel6.setText("Preço");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        selCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Alimento", "Limpeza", "Diversos" }));

        jLabel7.setText("Categoria");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProdutos);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVendas1.setText("Vender");
        btnVendas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendas1ActionPerformed(evt);
            }
        });

        btnRelatorio1.setText("Gerar Relatório");
        btnRelatorio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorio1ActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadastroLayout = new javax.swing.GroupLayout(pnlCadastro);
        pnlCadastro.setLayout(pnlCadastroLayout);
        pnlCadastroLayout.setHorizontalGroup(
            pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar))
                    .addGroup(pnlCadastroLayout.createSequentialGroup()
                        .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadastroLayout.createSequentialGroup()
                                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlCadastroLayout.createSequentialGroup()
                                        .addComponent(selCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLimpar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCadastrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeletar))
                                    .addGroup(pnlCadastroLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                            .addGroup(pnlCadastroLayout.createSequentialGroup()
                                .addComponent(btnVendas1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRelatorio1)
                                .addGap(0, 803, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jSeparator3)
        );
        pnlCadastroLayout.setVerticalGroup(
            pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVendas1)
                    .addComponent(btnRelatorio1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar)
                    .addComponent(btnDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlCadastro, "card2");

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Quantidade", "Categoria", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Lista de Produtos Vendidos");

        edtVendasTotal.setFocusable(false);
        edtVendasTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVendasTotalActionPerformed(evt);
            }
        });

        edtVendasRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVendasRecebidoActionPerformed(evt);
            }
        });

        edtVendasTroco.setFocusable(false);
        edtVendasTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVendasTrocoActionPerformed(evt);
            }
        });

        jLabel2.setText("Total");

        jLabel3.setText("Recebido");

        jLabel4.setText("Troco");

        jLabel8.setText("Quantidade");

        edtVendasData.setFocusable(false);
        edtVendasData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVendasDataActionPerformed(evt);
            }
        });

        jLabel11.setText("Data/Hora:");

        btnCadastro.setText("Cadastrar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnRelatorio.setText("Gerar Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        jLabel14.setText("ID");

        edtVendasId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVendasIdActionPerformed(evt);
            }
        });

        jLabel15.setText("Nome");

        jLabel16.setText("Preço");

        selVendasCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhuma", "Alimentos", "Limpeza", "Diversos" }));

        jLabel17.setText("Categoria");

        btnVendaAdicionar.setText("Adicionar Produto");
        btnVendaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaAdicionarActionPerformed(evt);
            }
        });

        btnVendaRemover.setText("Remover Produto");
        btnVendaRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaRemoverActionPerformed(evt);
            }
        });

        btnVendaFinalizar.setText("Finalizar Venda");
        btnVendaFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaFinalizarActionPerformed(evt);
            }
        });

        btnVendasLimpar.setText("Limpar");
        btnVendasLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasLimparActionPerformed(evt);
            }
        });

        btnVendasBuscar.setText("Buscar");
        btnVendasBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasBuscarActionPerformed(evt);
            }
        });

        btnVendasCalculaTroco.setText("Calcular Troco");
        btnVendasCalculaTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasCalculaTrocoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVendasLayout = new javax.swing.GroupLayout(pnlVendas);
        pnlVendas.setLayout(pnlVendasLayout);
        pnlVendasLayout.setHorizontalGroup(
            pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pnlVendasLayout.createSequentialGroup()
                .addComponent(btnCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRelatorio)
                .addContainerGap(807, Short.MAX_VALUE))
            .addGroup(pnlVendasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8)
                    .addComponent(edtVendasPreco)
                    .addComponent(edtVendasQuantidade)
                    .addComponent(btnVendaFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(edtVendasId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVendasBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(btnVendaAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(edtVendasNome)
                    .addComponent(selVendasCategoria, 0, 127, Short.MAX_VALUE)
                    .addComponent(btnVendasLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVendaRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtVendasData, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVendasLayout.createSequentialGroup()
                            .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlVendasLayout.createSequentialGroup()
                                    .addComponent(edtVendasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(123, 123, 123))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVendasLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(197, 197, 197)))
                            .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(pnlVendasLayout.createSequentialGroup()
                                    .addComponent(edtVendasRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnVendasCalculaTroco)))
                            .addGap(34, 34, 34)
                            .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(edtVendasTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(11, 11, 11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVendasLayout.setVerticalGroup(
            pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastro)
                    .addComponent(btnRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtVendasData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtVendasId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtVendasNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVendasBuscar))
                        .addGap(71, 71, 71)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtVendasPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selVendasCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtVendasQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVendasLimpar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVendaAdicionar)
                            .addComponent(btnVendaRemover))
                        .addGap(47, 47, 47)
                        .addComponent(btnVendaFinalizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtVendasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtVendasRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVendasCalculaTroco)
                            .addComponent(edtVendasTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );

        pnlMain.add(pnlVendas, "card3");

        selRelatorioTempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sempre", "Uma semana", "Duas Semanas", "Um mês", "Um ano" }));
        selRelatorioTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selRelatorioTempoActionPerformed(evt);
            }
        });

        jLabel12.setText("Tempo");

        tblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblRelatorio);

        btnCadastro2.setText("Cadastrar");
        btnCadastro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastro2ActionPerformed(evt);
            }
        });

        btnVendas2.setText("Vender");
        btnVendas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendas2ActionPerformed(evt);
            }
        });

        btnRelatorioBusca.setText("Buscar");
        btnRelatorioBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioBuscaActionPerformed(evt);
            }
        });

        edtRelatorioTotalVendido.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Histórico de Vendas");

        jLabel10.setText("Total Vendido (R$)");

        javax.swing.GroupLayout pnlRelatorioLayout = new javax.swing.GroupLayout(pnlRelatorio);
        pnlRelatorio.setLayout(pnlRelatorioLayout);
        pnlRelatorioLayout.setHorizontalGroup(
            pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRelatorioLayout.createSequentialGroup()
                                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                                        .addComponent(selRelatorioTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRelatorioBusca)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtRelatorioTotalVendido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addContainerGap())
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                                .addComponent(btnCadastro2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVendas2))
                            .addComponent(jLabel9))
                        .addGap(0, 837, Short.MAX_VALUE))))
        );
        pnlRelatorioLayout.setVerticalGroup(
            pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastro2)
                    .addComponent(btnVendas2))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selRelatorioTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorioBusca)
                    .addComponent(edtRelatorioTotalVendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMain.add(pnlRelatorio, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Itens item = new Itens();
        
        if (edtNome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome não preenchido!");
            return;
        }
        else if (Character.isDigit(edtNome.getText().charAt(0))){
            JOptionPane.showMessageDialog(this, "Digite um nome válido!");
        }
        else{
        item.setNome(edtNome.getText());
        }
        
        if (edtPreco.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Preço não preenchido!");
            return;
        }
        
        String strpreco = edtPreco.getText();
        
        try{
        double preco = Double.valueOf(strpreco);
        if (preco < 0){
            throw new Exception("Preço inválido!");
        }
        item.setPreco(preco);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Digite um preço válido!");
        }
        
        Object categoria = selCategoria.getSelectedItem();
        int selectedCategoria = selCategoria.getSelectedIndex();
        
        if (selectedCategoria == 0){
            JOptionPane.showMessageDialog(this, "Categoria não selecionada!");
            return;
        }
        item.setCategoria(categoria.toString());
        
        try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(WS_URL, item, Itens.class);
            
            JOptionPane.showMessageDialog(this, "Item salvo com sucesso!");
       }
        catch(RestClientException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        btnLimparActionPerformed(evt);
        loadTableData();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        edtNome.setText("");
        edtPreco.setText("");
        selCategoria.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int rows[] = tblProdutos.getSelectedRows();
        
        if(rows.length == 0){
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado!");
            return;
        }
        
        for(int row : rows){
            RestTemplate restTemplate = new RestTemplate();
            Long id = (Long) tblProdutos.getModel().getValueAt(row, 0);
            restTemplate.delete(WS_URL + "/" + id);
        }
        loadTableData();
        JOptionPane.showMessageDialog(this, "Item(s) removido(s) com sucesso!");
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVendas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendas1ActionPerformed
        changeWindowVendas();
    }//GEN-LAST:event_btnVendas1ActionPerformed

    private void btnRelatorio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorio1ActionPerformed
        changeWindowRelatorio();
    }//GEN-LAST:event_btnRelatorio1ActionPerformed

    private void btnCadastro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastro2ActionPerformed
        changeWindowCadstro();
    }//GEN-LAST:event_btnCadastro2ActionPerformed

    private void btnVendas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendas2ActionPerformed
        changeWindowVendas();
    }//GEN-LAST:event_btnVendas2ActionPerformed

    private void selRelatorioTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selRelatorioTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selRelatorioTempoActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        changeWindowRelatorio();
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        changeWindowCadstro();
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void edtVendasDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVendasDataActionPerformed

    }//GEN-LAST:event_edtVendasDataActionPerformed

    private void edtVendasRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVendasRecebidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVendasRecebidoActionPerformed

    private void edtVendasTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVendasTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVendasTotalActionPerformed

    private void btnVendaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaAdicionarActionPerformed
            
        DefaultTableModel tableModelVendas = (DefaultTableModel) tblVendas.getModel();
        tableModelVendas.setColumnIdentifiers(new Object[]{"ID", "Nome", "Preço", "Quantidade", "Categoria", "Subtotal"});
        
        ItensVendidos itemVendido = new ItensVendidos();
        
        if (edtVendasNome.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Nome não preenchido!");
            return;
        }
        else if (Character.isDigit(edtVendasNome.getText().charAt(0))){
            JOptionPane.showMessageDialog(this, "Digite um nome válido!");
        }
        else{
        itemVendido.setNome(edtVendasNome.getText());
        }
        
        if (edtVendasPreco.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Preço não preenchido!");
            return;
        }
        
        String strPreco = edtVendasPreco.getText();
        
        try{
            double preco = Double.parseDouble(strPreco);
            if (preco < 0){
                JOptionPane.showMessageDialog(this, "Digite um preço válido!");
                throw new Exception();
            }
            else{
            itemVendido.setPreco(preco);
        }

            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Digite um preço válido!");
        }

        String categoria = "Nenhuma";
        int selCategoria = selVendasCategoria.getSelectedIndex();
        
        switch (selCategoria) {
            case 0 -> {
                JOptionPane.showMessageDialog(this, "Categoria não selecionada!");
                return;
            }
            case 1 -> categoria = "Alimento";
            case 2 -> categoria = "Limpeza";
            case 3 -> categoria = "Diversos";
            default -> {
            }
        }
        
        itemVendido.setCategoria(categoria);
  
        // Pega id, converte e atribui
        String strId = edtVendasId.getText();
        Long id = Long.valueOf(strId);
        itemVendido.setId(id);
        
        //converte tipos e calcula o subtotal 
        String strQuantidade = edtVendasQuantidade.getText();
        int quantidade = (strQuantidade.length() == 0) ? 1 : Integer.parseInt(strQuantidade);
        double preco = Double.parseDouble(strPreco);
        Double subtotal = quantidade * preco;
        itemVendido.setQuantidade(quantidade);
        itemVendido.setSubtotal(subtotal);  
        
        //carrega na tabela        
        Object[] rowData = {itemVendido.getId(), itemVendido.getNome(), itemVendido.getPreco(), itemVendido.getQuantidade(), itemVendido.getCategoria(), itemVendido.getSubtotal()};
        tableModelVendas.addRow(rowData);
        tableModelVendas.fireTableDataChanged();
        
        double total = 0;
        
        for(int i = 0; i < tblVendas.getRowCount(); i++){
            double subtotais = (Double) tblVendas.getValueAt(i, 5);
            total += subtotais;
        } 
        
        String strTotal = String.valueOf(total);
        edtVendasTotal.setText(strTotal);
        
        //limpa inputs
        edtVendasId.setText("");
        edtVendasNome.setText("");
        selVendasCategoria.setSelectedIndex(0);
        edtVendasPreco.setText("");
        edtVendasQuantidade.setText("");

    }//GEN-LAST:event_btnVendaAdicionarActionPerformed

    private void btnVendaRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaRemoverActionPerformed
         int rows[] = tblVendas.getSelectedRows();
        
        if(rows.length == 0){
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado!");
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) tblVendas.getModel();
        for(int row : rows){
            tableModel.removeRow(row);
        } 
        JOptionPane.showMessageDialog(this, "Item removido!");
    }//GEN-LAST:event_btnVendaRemoverActionPerformed

    private void btnRelatorioBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioBuscaActionPerformed

        RestTemplate restTemplateVendas = new RestTemplate();
        ResponseEntity<Vendas[]> responseVendas = restTemplateVendas.getForEntity(WS_URL2, Vendas[].class);  

        Vendas[] vendas = responseVendas.getBody();
        DefaultTableModel tableModelVendas = (DefaultTableModel) tblRelatorio.getModel();
        tableModelVendas.setColumnIdentifiers(new Object[]{"ID", "Data", "Total"});
        
        tableModelVendas.setRowCount(0);
        double total = 0;
        int i = 0;
        int dataSelecionada = selRelatorioTempo.getSelectedIndex();
        LocalDateTime dataLimite = LocalDateTime.now();
        if(dataSelecionada == 0){
            dataLimite = LocalDateTime.of(1000, 01, 01, 1, 1);
        }
        else if(dataSelecionada == 1){
            dataLimite = dataLimite.minusWeeks(1);
        }
        else if(dataSelecionada == 2){
            dataLimite = dataLimite.minusWeeks(2);
        }
        else if(dataSelecionada == 3){
            dataLimite = dataLimite.minusMonths(1);
        }
        else if(dataSelecionada == 4){
            dataLimite = dataLimite.minusYears(1);
        }
        
        try{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
           
            /* cannot find symbol stream
            if (vendas != null) {
               vendas.stream().filter(venda -> venda.getData().isAfter(dataLimite)).forEach(venda -> {
            String dataHoraFormatada = venda.getData().format(formato);
            Object[] row = {venda.getId(), dataHoraFormatada, venda.getTotal()};
            tableModelVendas.addRow(row);
        });
}*/
            for (Vendas venda : vendas) {
                LocalDateTime data = venda.getData();
                //compara as datas para filtrar
                if (data.isAfter(dataLimite)) {
                    String dataHoraFormatada = data.format(formato);
                    Object[] row = {venda.getId(), dataHoraFormatada, venda.getTotal()};
                    tableModelVendas.addRow(row);
                }
                //soma total
                double subtotais = (Double) tblRelatorio.getValueAt(i, 2);
                total += subtotais;
                i++;
                }
            //converte e atribui ao campo
            String strTotal = String.valueOf(total);
            edtRelatorioTotalVendido.setText(strTotal);
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao Buscar Vendas!");
        }
    }//GEN-LAST:event_btnRelatorioBuscaActionPerformed

    private void edtVendasIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVendasIdActionPerformed

    }//GEN-LAST:event_edtVendasIdActionPerformed

    private void btnVendaFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaFinalizarActionPerformed
        Vendas venda = new Vendas();
        
        DefaultTableModel tableModelVendas = (DefaultTableModel) tblVendas.getModel();

        List<ItensVendidos> listaItensVendidos = new ArrayList<>();
        
        venda.setItensVendidos(listaItensVendidos);
        
        int rowsNum = tableModelVendas.getRowCount();
        
        // Pega todos os valores de cada linha, atribui ao objeto e insere na lista
        try{
            double total = Double.parseDouble(edtVendasTotal.getText());
            venda.setTotal((total));
            venda.setData(LocalDateTime.now());
            
            for (int i = 0; i < rowsNum; i++) {
                ItensVendidos novoItem = new ItensVendidos();
                // Verifica se o valor na tabela não é nulo e pode ser convertido em double
                Object valorPreco = tblVendas.getValueAt(i, 2);

                if (valorPreco != null) {
                    try {
                        double preco = Double.parseDouble(valorPreco.toString());
                        novoItem.setPreco(preco);
                    } catch (NumberFormatException e) {
                        // Tratamento de exceção caso não seja possível converter em double
                        JOptionPane.showMessageDialog(this, "Erro ao converter o valor de preço para double");
                    }
                }

                // Verifica se o valor na tabela não é nulo e pode ser convertido em int
                Object valorQuantidade = tblVendas.getValueAt(i, 3);

                if (valorQuantidade != null) {
                    try {
                        int quantidade = Integer.parseInt(valorQuantidade.toString());
                        novoItem.setQuantidade(quantidade);
                    } catch (NumberFormatException e) {
                        // Tratamento de exceção caso não seja possível converter em int
                        JOptionPane.showMessageDialog(this, "Erro ao converter o valor de quantidade para int");
                    }
                novoItem.setId((Long) tblVendas.getValueAt(i, 0));
                novoItem.setNome((String) tblVendas.getValueAt(i, 1));

                }

                novoItem.setCategoria((String) tblVendas.getValueAt(i, 4));
                
                // Verifica se o valor na tabela não é nulo e pode ser convertido em double
                Object valorSubtotal = tblVendas.getValueAt(i, 5);
                if (valorSubtotal != null) {
                    try {
                        double subtotal = Double.parseDouble(valorSubtotal.toString());
                        novoItem.setSubtotal(subtotal);
                    } catch (NumberFormatException e) {
                        // Tratamento de exceção caso não seja possível converter em double
                        JOptionPane.showMessageDialog(this, "Erro ao converter o valor de subtotal para double");
                    }
                }
               
                listaItensVendidos.add(novoItem);
                venda.getItensVendidos().add(novoItem);
               
            
            }
                venda.setItensVendidos(listaItensVendidos);

                // manda pro repositório
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.postForObject(WS_URL2, venda, Vendas.class);
                JOptionPane.showMessageDialog(this, "Item salvo com sucesso!");
       }
        catch(RestClientException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        tableModelVendas.setRowCount(0);
        edtVendasTotal.setText("");
        edtVendasTroco.setText("");
        edtVendasRecebido.setText("");
    }//GEN-LAST:event_btnVendaFinalizarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int rows[] = tblProdutos.getSelectedRows();
        
        if(rows.length == 0){
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado!");
            return;
        }
        
        for(int row : rows){
            RestTemplate restTemplate = new RestTemplate();
            Long id = (Long) tblProdutos.getModel().getValueAt(row, 0);
            restTemplate.delete(WS_URL + "/" + id);
        }
        
        JOptionPane.showMessageDialog(this, "Item removido com sucesso!");
        
        loadTableData();
             
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void edtVendasTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVendasTrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVendasTrocoActionPerformed

    private void btnVendasLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasLimparActionPerformed
        edtVendasId.setText("");
        edtVendasNome.setText("");
        edtVendasPreco.setText("");
        edtVendasQuantidade.setText("");
        selVendasCategoria.setSelectedIndex(0);
    }//GEN-LAST:event_btnVendasLimparActionPerformed

    private void btnVendasBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasBuscarActionPerformed
        // get
        RestTemplate restTemplateProdutos = new RestTemplate();
        ResponseEntity<Itens[]> responseProdutos = restTemplateProdutos.getForEntity(WS_URL, Itens[].class);
        Itens[] itens = responseProdutos.getBody();
        
        //define id e formatacao p/ double
        String strId = edtVendasId.getText();
        int encontrado = 0;
        int id = Integer.parseInt(strId);
            for(Itens item : itens){
                if(item.getId() == id){
                    encontrado += 1;
                    // preenche os campos
                    String nome = item.getNome();
                    double preco = item.getPreco();
                    String precoFormatado = String.format("%.2f", preco).replace(",", ".");
                    if(null != item.getCategoria())switch (item.getCategoria()) {
                        case "Alimento" -> selVendasCategoria.setSelectedIndex(1);
                        case "Limpeza" -> selVendasCategoria.setSelectedIndex(2);
                        case "Diversos" -> selVendasCategoria.setSelectedIndex(3);
                        default -> {
                        }
                    }
                    
                    edtVendasNome.setText(nome);
                    edtVendasPreco.setText(precoFormatado);
                
            }
        }
            if(encontrado > 0){
                JOptionPane.showMessageDialog(this, "Nenhum item encontrado!");
            }
    }//GEN-LAST:event_btnVendasBuscarActionPerformed

    private void btnVendasCalculaTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasCalculaTrocoActionPerformed
        double recebido = Double.parseDouble(edtVendasRecebido.getText());
        double total = Double.parseDouble(edtVendasTotal.getText());
        double troco = recebido - total;
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        String strTroco = formato.format(troco);
        edtVendasTroco.setText(strTroco);
    }//GEN-LAST:event_btnVendasCalculaTrocoActionPerformed
    
    
    private void loadTableData(){

        RestTemplate restTemplateProdutos = new RestTemplate();
      
        ResponseEntity<Itens[]> responseProdutos = restTemplateProdutos.getForEntity(WS_URL, Itens[].class);
        
        Itens[] itens = responseProdutos.getBody();
        
        DefaultTableModel tableModelProdutos = (DefaultTableModel) tblProdutos.getModel();
        
        tableModelProdutos.setColumnIdentifiers(new Object[]{"ID", "Nome", "Preço", "Categoria"});

        tableModelProdutos.setRowCount(0);
        
        for(Itens item : itens){
            Object[] row = {item.getId(), item.getNome(), item.getPreco(), item.getCategoria()};
            tableModelProdutos.addRow(row);
        }
        
    }
    
    
    private void changeWindowRelatorio(){
        pnlCadastro.setVisible(false);
        pnlVendas.setVisible(false);
        pnlRelatorio.setVisible(true);
    }
    
    private void changeWindowVendas(){
        pnlCadastro.setVisible(false);
        pnlVendas.setVisible(true);
        pnlRelatorio.setVisible(false);        
        
    }
    
    private void changeWindowCadstro(){
        pnlCadastro.setVisible(true);
        pnlVendas.setVisible(false);
        pnlRelatorio.setVisible(false);    
        
    }
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
            java.util.logging.Logger.getLogger(SistemaComercialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaComercialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaComercialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaComercialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SistemaComercialApp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnCadastro2;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnRelatorio1;
    private javax.swing.JButton btnRelatorioBusca;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVendaAdicionar;
    private javax.swing.JButton btnVendaFinalizar;
    private javax.swing.JButton btnVendaRemover;
    private javax.swing.JButton btnVendas1;
    private javax.swing.JButton btnVendas2;
    private javax.swing.JButton btnVendasBuscar;
    private javax.swing.JButton btnVendasCalculaTroco;
    private javax.swing.JButton btnVendasLimpar;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtPreco;
    private javax.swing.JTextField edtRelatorioTotalVendido;
    private javax.swing.JTextField edtVendasData;
    private javax.swing.JTextField edtVendasId;
    private javax.swing.JTextField edtVendasNome;
    private javax.swing.JTextField edtVendasPreco;
    private javax.swing.JTextField edtVendasQuantidade;
    private javax.swing.JTextField edtVendasRecebido;
    private javax.swing.JTextField edtVendasTotal;
    private javax.swing.JTextField edtVendasTroco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel pnlCadastro;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRelatorio;
    private javax.swing.JPanel pnlVendas;
    private javax.swing.JComboBox<String> selCategoria;
    private javax.swing.JComboBox<String> selRelatorioTempo;
    private javax.swing.JComboBox<String> selVendasCategoria;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTable tblRelatorio;
    private javax.swing.JTable tblVendas;
    // End of variables declaration//GEN-END:variables
}
