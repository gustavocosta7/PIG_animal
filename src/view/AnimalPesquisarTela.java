package view;


import controle.AnimalControle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import modelo.AnimalTableModel;

/**
 *
 * @author Vitor Oliveira
 */
public class AnimalPesquisarTela extends javax.swing.JFrame {

    private AnimalControle animalControle = new AnimalControle();
    
    public AnimalPesquisarTela(){
        initComponents();
        carregarDados();
        carregarMenuPopup();
    }
    
    private void carregarDados()
    {
        animalControle.listar();
        tabelaAnimais.setModel(new AnimalTableModel(animalControle.getAnimals()));
          
    }
    
    private void getAnimal(MouseEvent evt)
    {
        int linha = tabelaAnimais.rowAtPoint(evt.getPoint());
        if(linha >= 0)
        {
            tabelaAnimais.setRowSelectionInterval(linha, linha);
            linha = tabelaAnimais.getSelectedRow();
            animalControle.setAnimal(animalControle.getAnimals().get(linha));       
        }
    }
    
    private void realizarAcao(MouseEvent evt)
    {
        if(evt.getButton() == MouseEvent.BUTTON1)
        {
            if(evt.getClickCount() > 1)
            {
                
            }
        }else if(evt.getButton() == MouseEvent.BUTTON3)
        {
            menuTabela.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    private void carregarMenuPopup()
    {
        JMenuItem itemExcluir  = new JMenuItem("Excluir registro");
        JMenuItem itemAlterar = new JMenuItem("Alterar");
        
        itemAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalAlterarTela alterarTela = new AnimalAlterarTela(animalControle);
                alterarTela.setVisible(true);
                dispose();
                
            }
        });
                
        itemExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(JOptionPane.showConfirmDialog(null, "Confirmar a exclusão do registro?", "Excluir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    try {
                        animalControle.remover();
                        carregarDados();
                        JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
                    } catch (Exception ex) {
                    }
                }
            }
            
        }); 
        menuTabela.add(itemAlterar);
        menuTabela.add(itemExcluir);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTabela = new javax.swing.JPopupMenu();
        cFiltro = new javax.swing.JTextField();
        bPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAnimais = new javax.swing.JTable();
        bNovo = new javax.swing.JButton();
        bSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        bPesquisar.setText("Pesquisar");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        tabelaAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabelaAnimais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaAnimaisMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAnimais);

        bNovo.setText("Cadastrar");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Univers 55", 0, 18)); // NOI18N
        jLabel1.setText("Pesquisar Animais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bSair))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cFiltro)
                                .addGap(25, 25, 25)
                                .addComponent(bPesquisar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPesquisar))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        
            new AnimalCadastroTela().setVisible(true);
        
    }//GEN-LAST:event_bNovoActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        AnimalPesquisarTela.this.dispose();
    }//GEN-LAST:event_bSairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
            carregarDados();
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
       
            carregarDados();
        
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

            
    }//GEN-LAST:event_formMouseReleased

    private void tabelaAnimaisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAnimaisMouseReleased
       
            getAnimal(evt);
            realizarAcao(evt);
        
    }//GEN-LAST:event_tabelaAnimaisMouseReleased

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
            java.util.logging.Logger.getLogger(AnimalPesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalPesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalPesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalPesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    new AnimalPesquisarTela().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JButton bSair;
    private javax.swing.JTextField cFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuTabela;
    private javax.swing.JTable tabelaAnimais;
    // End of variables declaration//GEN-END:variables
}