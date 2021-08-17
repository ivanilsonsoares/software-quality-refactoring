/**
 * @author Lais Frigério da Silva
 */

package view.procedimento;

import controller.ProcedimentoController;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import Fix.fixAjust;
import model.Procedimento;
import model.Validacao;
import model.ValidationAux;
import view.FixedButtonModel;
import view.Main;

public class EditarProcedimento extends javax.swing.JFrame {

    private final Procedimento editarProcedimento;
    private final Main tela;
    /**
     * Creates new form EditarTipoProfissional
     * @param tela
     * @param p
     */
    public EditarProcedimento(Main tela, Procedimento p) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/portfolio.png")).getImage());
        this.setTitle("Editar Procedimento");
        
        this.editarProcedimento =  p;
        this.tela = tela;
        this.tNome.setText(this.editarProcedimento.getNome());
        bSalvarProcedimento.setModel(new FixedButtonModel());
        bSalvarProcedimento.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarProcedimento.setModel(new FixedButtonModel());
        bCancelarProcedimento.setBorder(BorderFactory.createEtchedBorder(0));
        
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bSalvarProcedimento = new javax.swing.JButton();
        bCancelarProcedimento = new javax.swing.JButton();
        tNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Tipo Profissional");

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(625, 128));

        bSalvarProcedimento.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarProcedimento.setText("Salvar");
        bSalvarProcedimento.setBorder(null);
        bSalvarProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarProcedimento.setDoubleBuffered(true);
        bSalvarProcedimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarProcedimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarProcedimentoFocusLost(evt);
            }
        });
        bSalvarProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarProcedimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarProcedimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarProcedimentoMouseExited(evt);
            }
        });
        bSalvarProcedimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bSalvarProcedimentoKeyPressed(evt);
            }
        });

        bCancelarProcedimento.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarProcedimento.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarProcedimento.setText("Cancelar");
        bCancelarProcedimento.setBorder(null);
        bCancelarProcedimento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarProcedimento.setDoubleBuffered(true);
        bCancelarProcedimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarProcedimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarProcedimentoFocusLost(evt);
            }
        });
        bCancelarProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarProcedimentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarProcedimentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarProcedimentoMouseExited(evt);
            }
        });
        bCancelarProcedimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarProcedimentoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bSalvarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarProcedimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarProcedimentoFocusGained
        bSalvarProcedimento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarProcedimentoFocusGained

    private void bSalvarProcedimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarProcedimentoFocusLost
        bSalvarProcedimento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarProcedimentoFocusLost

    private void bSalvarProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarProcedimentoMouseClicked
        this.edit();
    }//GEN-LAST:event_bSalvarProcedimentoMouseClicked

    private void bSalvarProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarProcedimentoMouseEntered
        bSalvarProcedimento.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarProcedimentoMouseEntered

    private void bSalvarProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarProcedimentoMouseExited
        bSalvarProcedimento.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarProcedimentoMouseExited

    private void bCancelarProcedimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarProcedimentoFocusGained
        bCancelarProcedimento.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarProcedimentoFocusGained

    private void bCancelarProcedimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarProcedimentoFocusLost
        bCancelarProcedimento.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarProcedimentoFocusLost

    private void bCancelarProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarProcedimentoMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarProcedimentoMouseClicked

    private void bCancelarProcedimentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarProcedimentoMouseEntered
        bCancelarProcedimento.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarProcedimentoMouseEntered

    private void bCancelarProcedimentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarProcedimentoMouseExited
        bCancelarProcedimento.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarProcedimentoMouseExited

    private void bCancelarProcedimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarProcedimentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_bCancelarProcedimentoKeyPressed

    private void bSalvarProcedimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bSalvarProcedimentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.edit();
        }
    }//GEN-LAST:event_bSalvarProcedimentoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	fixAjust.fix();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarProcedimento;
    private javax.swing.JButton bSalvarProcedimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tNome;
    // End of variables declaration//GEN-END:variables

    private void edit() {
        if(Validacao.isEmpty(tNome.getText())) {
            JOptionPane.showMessageDialog(null, "O campos Nome é obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        this.editarProcedimento.setNome(tNome.getText());
        ProcedimentoController pc = new ProcedimentoController();
        if(pc.editar(this.editarProcedimento)){
            List<Procedimento> lista = pc.procedimentos();
            if(lista!=null)
                this.tela.tableModelProcedimentos.addLista(lista);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a atualização dos dados. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
}
