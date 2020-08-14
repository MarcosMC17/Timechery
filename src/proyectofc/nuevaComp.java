package proyectofc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class nuevaComp extends javax.swing.JFrame {

    static private String databaseRuta = ".\\data";
    static private String database = "Archery.db";

    public nuevaComp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNom = new javax.swing.JLabel();
        tNom = new javax.swing.JTextField();
        lNom1 = new javax.swing.JLabel();
        tIdComp = new javax.swing.JTextField();
        lClub = new javax.swing.JLabel();
        tClub = new javax.swing.JTextField();
        lFecha = new javax.swing.JLabel();
        tFecha = new javax.swing.JFormattedTextField();
        lLoc = new javax.swing.JLabel();
        tLoc = new javax.swing.JTextField();
        botCancelar = new javax.swing.JButton();
        botGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Competición");

        lNom.setText("Nombre:");
        lNom.setToolTipText("Nombre:");

        tNom.setToolTipText(" Nombre de la competición");

        lNom1.setText("C. Competicion:");
        lNom1.setToolTipText("C. Competicion:");

        tIdComp.setToolTipText("Codigo de Competición");

        lClub.setText("Club:");
        lClub.setToolTipText("Club:");

        tClub.setToolTipText("Club organizador");

        lFecha.setText("Fecha:");
        lFecha.setToolTipText("Fecha:");

        tFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-mm-dd"))));
        tFecha.setText("2020-01-01");
        tFecha.setToolTipText("Fecha");

        lLoc.setText("Localización:");
        lLoc.setToolTipText("Localización:");

        tLoc.setToolTipText("Localización");

        botCancelar.setText("Cancelar");
        botCancelar.setToolTipText("Cancelar");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        botGuardar.setText("Guardar Cambios");
        botGuardar.setToolTipText("Guardar Cambios");
        botGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lNom)
                    .addComponent(lNom1)
                    .addComponent(lClub)
                    .addComponent(lFecha)
                    .addComponent(lLoc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tLoc)
                    .addComponent(tClub)
                    .addComponent(tNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(tIdComp, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tFecha))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(botCancelar)
                .addGap(18, 18, 18)
                .addComponent(botGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tIdComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNom1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lClub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lFecha)
                    .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botCancelar)
                    .addComponent(botGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        PBaseDatos pb = new PBaseDatos();
        pb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGuardarActionPerformed
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        if (tIdComp.getText().equals("") || tNom.getText().equals("") || tClub.getText().equals("") || tFecha.getText().equals("") || tLoc.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hay campos vacios", "Dialogo", 0);
        } else {
            try {
                if (yaExiste(tIdComp.getText())) {
                    JOptionPane.showMessageDialog(this, "Ya existe un Campeonato con ese Identificador en la base de datos", "Error", 0);
                } else {
                    consqlite.EjecutarActualizacion("Insert Into Competiciones (IdCompeticion, Nombre, Club, Fecha, Localizacion) values ('" + tIdComp.getText() + "', '" + tNom.getText() + "', '" + tClub.getText() + "', '" + tFecha.getText() + "', '" + tLoc.getText() + "')");
                    PBaseDatos pbd = new PBaseDatos();
                    pbd.setVisible(true);
                    this.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(nuevaComp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(nuevaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                nuevaComp dialog = new nuevaComp();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private boolean yaExiste(String aComprobar) throws SQLException {
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        ResultSet rs = consqlite.EjecutarSQL("Select IdCompeticion from Competiciones where IdCompeticion = '" + aComprobar + "';");
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botGuardar;
    private javax.swing.JLabel lClub;
    private javax.swing.JLabel lFecha;
    private javax.swing.JLabel lLoc;
    private javax.swing.JLabel lNom;
    private javax.swing.JLabel lNom1;
    private javax.swing.JTextField tClub;
    private javax.swing.JFormattedTextField tFecha;
    private javax.swing.JTextField tIdComp;
    private javax.swing.JTextField tLoc;
    private javax.swing.JTextField tNom;
    // End of variables declaration//GEN-END:variables
}
