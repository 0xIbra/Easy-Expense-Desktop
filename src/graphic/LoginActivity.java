/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import DAO.LoginDAO;
import Metier.User;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ibrah
 */
public class LoginActivity extends javax.swing.JFrame {
    private User currentUser;
    private User currentComptable;
    
    /**
     * Creates new form LoginActivity
     */
    public LoginActivity() {
        initComponents();
        this.setTitle("Login - Easy Expense");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComptablePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loginComptableEmailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        loginComptablePassField = new javax.swing.JPasswordField();
        ConnectBG = new javax.swing.JPanel();
        ConnectTEXT = new javax.swing.JLabel();
        commercialPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        commercialPanelTITLE = new javax.swing.JLabel();
        loginCommercialPassField = new javax.swing.JPasswordField();
        loginCommercialEmailField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ConnectBG1 = new javax.swing.JPanel();
        ConnectTEXT1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComptablePanel.setBackground(new java.awt.Color(35, 38, 53));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Comptable");

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vous êtes un Comptable ?");

        jLabel4.setBackground(new java.awt.Color(35, 38, 53));
        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");

        jSeparator1.setBackground(new java.awt.Color(222, 222, 222));
        jSeparator1.setForeground(new java.awt.Color(222, 222, 222));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        loginComptableEmailField.setBackground(new java.awt.Color(35, 38, 53));
        loginComptableEmailField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        loginComptableEmailField.setForeground(new java.awt.Color(255, 255, 255));
        loginComptableEmailField.setBorder(null);

        jLabel5.setBackground(new java.awt.Color(35, 38, 53));
        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mot de passe");

        jSeparator2.setBackground(new java.awt.Color(222, 222, 222));
        jSeparator2.setForeground(new java.awt.Color(222, 222, 222));
        jSeparator2.setAlignmentX(1.0F);
        jSeparator2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 20));

        loginComptablePassField.setBackground(new java.awt.Color(35, 38, 53));
        loginComptablePassField.setForeground(new java.awt.Color(255, 255, 255));
        loginComptablePassField.setBorder(null);

        ConnectBG.setBackground(new java.awt.Color(92, 235, 181));
        ConnectBG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(92, 235, 181), 1, true));
        ConnectBG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnectBGMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConnectBGMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ConnectBGMouseReleased(evt);
            }
        });

        ConnectTEXT.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        ConnectTEXT.setForeground(new java.awt.Color(255, 255, 255));
        ConnectTEXT.setText("CONNEXION");

        javax.swing.GroupLayout ConnectBGLayout = new javax.swing.GroupLayout(ConnectBG);
        ConnectBG.setLayout(ConnectBGLayout);
        ConnectBGLayout.setHorizontalGroup(
            ConnectBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectBGLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(ConnectTEXT)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        ConnectBGLayout.setVerticalGroup(
            ConnectBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectBGLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ConnectTEXT)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ComptablePanelLayout = new javax.swing.GroupLayout(ComptablePanel);
        ComptablePanel.setLayout(ComptablePanelLayout);
        ComptablePanelLayout.setHorizontalGroup(
            ComptablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComptablePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(126, 126, 126))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComptablePanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(ComptablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ComptablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(loginComptablePassField, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                    .addGroup(ComptablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ConnectBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginComptableEmailField)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComptablePanelLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(83, 83, 83))
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        ComptablePanelLayout.setVerticalGroup(
            ComptablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComptablePanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginComptableEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginComptablePassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConnectBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        getContentPane().add(ComptablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 530));

        commercialPanel.setBackground(new java.awt.Color(57, 55, 76));

        jLabel9.setBackground(new java.awt.Color(35, 38, 53));
        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email");

        jSeparator3.setBackground(new java.awt.Color(222, 222, 222));
        jSeparator3.setForeground(new java.awt.Color(222, 222, 222));
        jSeparator3.setAlignmentX(1.0F);
        jSeparator3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 20));

        commercialPanelTITLE.setFont(new java.awt.Font("Montserrat", 0, 32)); // NOI18N
        commercialPanelTITLE.setForeground(new java.awt.Color(255, 255, 255));
        commercialPanelTITLE.setText("Commercial");

        loginCommercialPassField.setBackground(new java.awt.Color(57, 55, 76));
        loginCommercialPassField.setForeground(new java.awt.Color(255, 255, 255));
        loginCommercialPassField.setBorder(null);

        loginCommercialEmailField.setBackground(new java.awt.Color(57, 55, 76));
        loginCommercialEmailField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        loginCommercialEmailField.setForeground(new java.awt.Color(255, 255, 255));
        loginCommercialEmailField.setBorder(null);

        jLabel10.setBackground(new java.awt.Color(35, 38, 53));
        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mot de passe");

        ConnectBG1.setBackground(new java.awt.Color(57, 55, 76));
        ConnectBG1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(92, 235, 181), 1, true));
        ConnectBG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnectBG1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConnectBG1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ConnectBG1MouseReleased(evt);
            }
        });

        ConnectTEXT1.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        ConnectTEXT1.setForeground(new java.awt.Color(255, 255, 255));
        ConnectTEXT1.setText("CONNEXION");

        javax.swing.GroupLayout ConnectBG1Layout = new javax.swing.GroupLayout(ConnectBG1);
        ConnectBG1.setLayout(ConnectBG1Layout);
        ConnectBG1Layout.setHorizontalGroup(
            ConnectBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectBG1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(ConnectTEXT1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConnectBG1Layout.setVerticalGroup(
            ConnectBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectBG1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ConnectTEXT1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Vous êtes un Commercial ?");

        jSeparator4.setBackground(new java.awt.Color(222, 222, 222));
        jSeparator4.setForeground(new java.awt.Color(222, 222, 222));
        jSeparator4.setAlignmentX(1.0F);
        jSeparator4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout commercialPanelLayout = new javax.swing.GroupLayout(commercialPanel);
        commercialPanel.setLayout(commercialPanelLayout);
        commercialPanelLayout.setHorizontalGroup(
            commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commercialPanelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commercialPanelLayout.createSequentialGroup()
                        .addGroup(commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(commercialPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(loginCommercialEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ConnectBG1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loginCommercialPassField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commercialPanelLayout.createSequentialGroup()
                        .addGroup(commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(commercialPanelTITLE)
                            .addComponent(jLabel7))
                        .addGap(110, 110, 110))))
        );
        commercialPanelLayout.setVerticalGroup(
            commercialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commercialPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(commercialPanelTITLE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(124, 124, 124)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginCommercialEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(2, 2, 2)
                .addComponent(loginCommercialPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConnectBG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        getContentPane().add(commercialPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 430, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectBGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectBGMouseClicked
        
    }//GEN-LAST:event_ConnectBGMouseClicked

    private void ConnectBGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectBGMousePressed
        ConnectBG.setBackground(new Color(70, 196, 148));
    }//GEN-LAST:event_ConnectBGMousePressed

    private void ConnectBGMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectBGMouseReleased
        ConnectBG.setBackground(new Color(92,235,181));
        
        if(!"".equals(loginComptableEmailField.getText()) && !"".equals(loginComptablePassField.getPassword())){
            if(loginComptableEmailField.getText().contains("@") && loginComptableEmailField.getText().contains(".")){
                 try {
                    LoginDAO conn = new LoginDAO();
                    String pass = new String(loginComptablePassField.getPassword());
                    this.currentComptable = conn.authentificateComptable(loginComptableEmailField.getText(), pass);
                    if(loginComptableEmailField.getText().equals(this.currentComptable.getEmail()) && pass.equals(this.currentComptable.getPassword())){
                        this.dispose();
                        Comptable f = new Comptable(this.currentComptable);
                        f.prepareWelcome(this.currentComptable.getFirstName());
                    }else{
                        JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrects.");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Merci de remplir tous les champs avant de valider.");
        }
   
        
    }//GEN-LAST:event_ConnectBGMouseReleased

    private void ConnectBG1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectBG1MousePressed
        ConnectBG1.setBackground(new Color(92,235,181));
    }//GEN-LAST:event_ConnectBG1MousePressed

    private void ConnectBG1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectBG1MouseReleased
        ConnectBG1.setBackground(new Color(57,55,76));
        
        if(!"".equals(loginCommercialEmailField.getText()) && !"".equals(loginCommercialPassField.getPassword())){
            if(loginCommercialEmailField.getText().contains("@") && loginCommercialEmailField.getText().contains(".")){
                try {
                    LoginDAO conn = new LoginDAO();
                    String pass = new String(loginCommercialPassField.getPassword());
                    this.currentUser = conn.authentificateCommercial(loginCommercialEmailField.getText(), pass);
                    if(loginCommercialEmailField.getText().equals(this.currentUser.getEmail()) && pass.equals(this.currentUser.getPassword())){
                        this.dispose();
                        Commercial f = new Commercial(this.currentUser);
                        f.prepareWelcome(this.currentUser.getFirstName());
                    }else{
                        JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrects.");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Merci de remplir tous les champs avant de valider.");
        }
    }//GEN-LAST:event_ConnectBG1MouseReleased

    private void ConnectBG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectBG1MouseClicked

        
    }//GEN-LAST:event_ConnectBG1MouseClicked

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
            java.util.logging.Logger.getLogger(LoginActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ComptablePanel;
    private javax.swing.JPanel ConnectBG;
    private javax.swing.JPanel ConnectBG1;
    private javax.swing.JLabel ConnectTEXT;
    private javax.swing.JLabel ConnectTEXT1;
    private javax.swing.JPanel commercialPanel;
    private javax.swing.JLabel commercialPanelTITLE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField loginCommercialEmailField;
    private javax.swing.JPasswordField loginCommercialPassField;
    private javax.swing.JTextField loginComptableEmailField;
    private javax.swing.JPasswordField loginComptablePassField;
    // End of variables declaration//GEN-END:variables
}
