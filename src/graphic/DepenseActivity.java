/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import DAO.DepenseDAO;
import Metier.Depense;
import Metier.Frais;
import Metier.NoteFrais;
import Metier.Trajet;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ibragim.abubakarov
 */
public class DepenseActivity extends javax.swing.JFrame {
    private DepenseDAO depenseConn;
    private ArrayList<Depense> depensesHolder;
    
    private NoteFrais currentNote;
    

    /**
     * Creates new form DepenseActivity
     */
    public DepenseActivity() {
        initComponents();
        this.setSize(950, 730);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    public DepenseActivity(NoteFrais note) throws ClassNotFoundException, SQLException{
        initComponents();
        this.setSize(950, 730);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.currentNote = note;
        this.setVisible(true);
        this.getDepensesForNote();
        this.checkEtatNoteFrais();
    }
    
    public void checkEtatNoteFrais(){
        if(currentNote.getEtat().equals("Validé") || currentNote.getEtat().equals("Refusé")){
            this.disableAllFields();
        }else if(currentNote.getEtat().equals("En Cours")){
            this.initTypeDepense();
            this.disableAllFields();
        }
    }
    
    
    public void disableAllFields(){
        dateField.setEnabled(false);
        montantField.setEnabled(false);
        etatField.setEnabled(false);
        libelleField.setEnabled(false);
        commentaireField.setEnabled(false);
        dureeField.setEnabled(false);
        villeDField.setEnabled(false);
        villeAField.setEnabled(false);
        dateAField.setEnabled(false);
        dateRField.setEnabled(false);
        distanceField.setEnabled(false);
    }
    
    
    public void getDepensesForNote() throws ClassNotFoundException, SQLException{
        depenseConn = new DepenseDAO();
        
        this.depensesHolder = depenseConn.getDepensesByID(currentNote.getId());
        
        for (Depense depense : depensesHolder) {
            selectedDepense.addItem(depense);
        }
    }
    
    
    
    public void initTypeDepense(){
        Depense test = (Depense) selectedDepense.getSelectedItem();
        switch(test.getTypeDepense()){
            case Depense.TYPE_FRAIS:
                hideTrajetFields();
                dateField.setText(((Frais) test).getDateFrais());
                montantField.setText(String.valueOf(((Frais) test).getMontantDepense()));
                etatField.setText(((Frais) test).isEtat());
                libelleField.setText(((Frais) test).getLibelleFrais());
                commentaireField.setText(((Frais) test).getDetailsFrais());
                break;
            case Depense.TYPE_TRAJET:
                showTrajetFields();
                dateField.setText(((Trajet) test).getDatePaiement());
                montantField.setText(String.valueOf(((Trajet) test).getMontantDepense()));
                etatField.setText(((Trajet) test).isEtat());
                libelleField.setText(((Trajet) test).getLibelleTrajet());
                commentaireField.setText(((Trajet) test).toString());
                dureeField.setText(String.valueOf(((Trajet) test).getDureeTrajet()));
                villeDField.setText(((Trajet) test).getVilleDepart());
                villeAField.setText(((Trajet) test).getVilleArrivee());
                dateAField.setText(((Trajet) test).getDateAller());
                dateRField.setText(((Trajet) test).getDateRetour());
                distanceField.setText(String.valueOf(((Trajet) test).getDistanceKM()));
                break;
        }
    }
    
    
    public void hideTrajetFields(){
        dureeField.setVisible(false);
        villeDField.setVisible(false);
        villeAField.setVisible(false);
        dateAField.setVisible(false);
        dateRField.setVisible(false);
        distanceField.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
    }
    
    
    
    public void showTrajetFields(){
        dureeField.setVisible(true);
        villeDField.setVisible(true);
        villeAField.setVisible(true);
        dateAField.setVisible(true);
        dateRField.setVisible(true);
        distanceField.setVisible(true);
        jLabel7.setVisible(true);
        jLabel8.setVisible(true);
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateField = new com.github.lgooddatepicker.components.DatePicker();
        montantField = new javax.swing.JTextField();
        etatField = new javax.swing.JLabel();
        libelleField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentaireField = new javax.swing.JTextArea();
        dureeField = new javax.swing.JTextField();
        villeDField = new javax.swing.JTextField();
        villeAField = new javax.swing.JTextField();
        dateAField = new javax.swing.JTextField();
        dateRField = new javax.swing.JTextField();
        distanceField = new javax.swing.JTextField();
        selectedDepense = new javax.swing.JComboBox<>();
        fermerBTN = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        validerBTN = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(952, 543));
        setPreferredSize(new java.awt.Dimension(952, 543));
        setSize(new java.awt.Dimension(952, 543));

        jPanel1.setBackground(new java.awt.Color(35, 38, 53));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Depense ");
        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Date ");
        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Montant");
        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Etat");
        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Libelle");
        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Commentaire");
        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Duree");
        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Ville de depart");
        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Ville d'arrivee");
        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Date aller");
        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Date retour");
        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Distance KM");
        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        dateField.setBackground(new java.awt.Color(35, 38, 53));
        dateField.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        dateField.setForeground(new java.awt.Color(255, 255, 255));

        montantField.setText("jTextField1");
        montantField.setBackground(new java.awt.Color(35, 38, 53));
        montantField.setBorder(null);
        montantField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        montantField.setForeground(new java.awt.Color(255, 255, 255));
        montantField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montantFieldActionPerformed(evt);
            }
        });

        etatField.setText("Etat");
        etatField.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        etatField.setForeground(new java.awt.Color(255, 255, 255));

        libelleField.setText("jTextField1");
        libelleField.setBackground(new java.awt.Color(35, 38, 53));
        libelleField.setBorder(null);
        libelleField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        libelleField.setForeground(new java.awt.Color(255, 255, 255));
        libelleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libelleFieldActionPerformed(evt);
            }
        });

        commentaireField.setColumns(20);
        commentaireField.setRows(3);
        commentaireField.setTabSize(6);
        commentaireField.setBackground(new java.awt.Color(35, 38, 53));
        commentaireField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        commentaireField.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(commentaireField);

        dureeField.setText("jTextField1");
        dureeField.setBackground(new java.awt.Color(35, 38, 53));
        dureeField.setBorder(null);
        dureeField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        dureeField.setForeground(new java.awt.Color(255, 255, 255));
        dureeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dureeFieldActionPerformed(evt);
            }
        });

        villeDField.setText("jTextField1");
        villeDField.setBackground(new java.awt.Color(35, 38, 53));
        villeDField.setBorder(null);
        villeDField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        villeDField.setForeground(new java.awt.Color(255, 255, 255));
        villeDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeDFieldActionPerformed(evt);
            }
        });

        villeAField.setText("jTextField1");
        villeAField.setBackground(new java.awt.Color(35, 38, 53));
        villeAField.setBorder(null);
        villeAField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        villeAField.setForeground(new java.awt.Color(255, 255, 255));
        villeAField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeAFieldActionPerformed(evt);
            }
        });

        dateAField.setText("jTextField1");
        dateAField.setBackground(new java.awt.Color(35, 38, 53));
        dateAField.setBorder(null);
        dateAField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        dateAField.setForeground(new java.awt.Color(255, 255, 255));
        dateAField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateAFieldActionPerformed(evt);
            }
        });

        dateRField.setText("jTextField1");
        dateRField.setBackground(new java.awt.Color(35, 38, 53));
        dateRField.setBorder(null);
        dateRField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        dateRField.setForeground(new java.awt.Color(255, 255, 255));
        dateRField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateRFieldActionPerformed(evt);
            }
        });

        distanceField.setText("jTextField1");
        distanceField.setBackground(new java.awt.Color(35, 38, 53));
        distanceField.setBorder(null);
        distanceField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        distanceField.setForeground(new java.awt.Color(255, 255, 255));
        distanceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceFieldActionPerformed(evt);
            }
        });

        selectedDepense.setBackground(new java.awt.Color(35, 38, 53));
        selectedDepense.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        selectedDepense.setForeground(new java.awt.Color(255, 255, 255));
        selectedDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedDepenseActionPerformed(evt);
            }
        });

        fermerBTN.setBackground(new java.awt.Color(35, 38, 53));
        fermerBTN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(217, 83, 79), 1, true));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fermer");
        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel13MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout fermerBTNLayout = new javax.swing.GroupLayout(fermerBTN);
        fermerBTN.setLayout(fermerBTNLayout);
        fermerBTNLayout.setHorizontalGroup(
            fermerBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        fermerBTNLayout.setVerticalGroup(
            fermerBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fermerBTNLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        validerBTN.setBackground(new java.awt.Color(35, 38, 53));
        validerBTN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(92, 235, 181), 1, true));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Valider");
        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout validerBTNLayout = new javax.swing.GroupLayout(validerBTN);
        validerBTN.setLayout(validerBTNLayout);
        validerBTNLayout.setHorizontalGroup(
            validerBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        validerBTNLayout.setVerticalGroup(
            validerBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(fermerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(validerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectedDepense, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(184, 184, 184)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(montantField)
                            .addComponent(etatField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(libelleField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dureeField)
                            .addComponent(villeDField)
                            .addComponent(villeAField)
                            .addComponent(dateAField)
                            .addComponent(dateRField)
                            .addComponent(distanceField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(215, 215, 215))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedDepense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(montantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etatField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(libelleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dureeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(villeDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(villeAField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dateAField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(dateRField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(distanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fermerBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(validerBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void montantFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montantFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montantFieldActionPerformed

    private void libelleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libelleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libelleFieldActionPerformed

    private void dureeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dureeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dureeFieldActionPerformed

    private void villeDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villeDFieldActionPerformed

    private void villeAFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeAFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villeAFieldActionPerformed

    private void dateAFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateAFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateAFieldActionPerformed

    private void dateRFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateRFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateRFieldActionPerformed

    private void distanceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceFieldActionPerformed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        fermerBTN.setBackground(new Color(217,83,79));
    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseReleased
        fermerBTN.setBackground(new Color(35,38,53));
        
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseReleased

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        validerBTN.setBackground(new Color(92,235,181));
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        validerBTN.setBackground(new Color(35,38,53));
        
        Depense tmpDepense = (Depense) selectedDepense.getSelectedItem();
        
            if( tmpDepense.isEtat().equals("Validé") ||  tmpDepense.isEtat().equals("Refusé")){
                JOptionPane.showMessageDialog(this, "La depense a déjà été traitée");
            }else{
                try {
                    DepenseDAO conn = new DepenseDAO();
                    boolean callback = false;
                    callback = conn.validateDepense(tmpDepense);
                    if(callback){
                        JOptionPane.showMessageDialog(this, "Depense validée");
                    }else{
                        JOptionPane.showConfirmDialog(this, "Une erreur est survenue");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DepenseActivity.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DepenseActivity.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    }//GEN-LAST:event_jLabel14MouseReleased

    private void selectedDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedDepenseActionPerformed
        initTypeDepense();
    }//GEN-LAST:event_selectedDepenseActionPerformed

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
            java.util.logging.Logger.getLogger(DepenseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepenseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepenseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepenseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepenseActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commentaireField;
    private javax.swing.JTextField dateAField;
    private com.github.lgooddatepicker.components.DatePicker dateField;
    private javax.swing.JTextField dateRField;
    private javax.swing.JTextField distanceField;
    private javax.swing.JTextField dureeField;
    private javax.swing.JLabel etatField;
    private javax.swing.JPanel fermerBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField libelleField;
    private javax.swing.JTextField montantField;
    private javax.swing.JComboBox<Object> selectedDepense;
    private javax.swing.JPanel validerBTN;
    private javax.swing.JTextField villeAField;
    private javax.swing.JTextField villeDField;
    // End of variables declaration//GEN-END:variables
}
