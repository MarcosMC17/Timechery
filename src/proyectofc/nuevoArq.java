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
public class nuevoArq extends javax.swing.JFrame {

    static private String databaseRuta = ".\\data";
    static private String database = "Archery.db";
    
    public nuevoArq() {
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
        lLic = new javax.swing.JLabel();
        tLic = new javax.swing.JTextField();
        lApe = new javax.swing.JLabel();
        tApe = new javax.swing.JTextField();
        lClub = new javax.swing.JLabel();
        botCancelar = new javax.swing.JButton();
        botGuardar = new javax.swing.JButton();
        tClub = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Arquero");

        lNom.setText("Nombre:");
        lNom.setToolTipText("Nombre");

        tNom.setToolTipText("Nombre");

        lLic.setText("N. Licencia:");
        lLic.setToolTipText("Numero de Licencia");

        tLic.setToolTipText("Numero de licencia");

        lApe.setText("Apellidos:");
        lApe.setToolTipText("Apellidos");

        tApe.setToolTipText("Apellidos");

        lClub.setText("Club:");
        lClub.setToolTipText("Club");

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

        tClub.setToolTipText("Club");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lNom)
                    .addComponent(lLic)
                    .addComponent(lApe)
                    .addComponent(lClub))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tApe)
                    .addComponent(tNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(tLic, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tClub, javax.swing.GroupLayout.Alignment.LEADING))
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
                    .addComponent(tLic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lApe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lClub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
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
        
        if(tLic.getText().equals("") || tNom.getText().equals("") || tApe.getText().equals("") || tClub.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Hay campos vacios", "Dialogo", 0);
        }
        else{
            try {
                if(yaExiste(Integer.parseInt(tLic.getText()))){
                    JOptionPane.showMessageDialog(this, "Ya existe un arquero con esa licencia en la base de datos", "Error", 0);
                }
                else{
                    consqlite.EjecutarActualizacion("Insert Into Arqueros (Licencia, Nombre, Apellidos, CLub) values ('" + tLic.getText() + "', '" + tNom.getText() + "', '" + tApe.getText() + "', '" + tClub.getText() + "')");
                    PBaseDatos pbd = new PBaseDatos();
                    pbd.setVisible(true);
                    this.dispose();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(nuevoArq.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(nuevoArq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevoArq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevoArq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevoArq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                nuevoArq dialog = new nuevoArq();
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
    
    private boolean yaExiste(int aComprobar) throws SQLException{
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        ResultSet rs = consqlite.EjecutarSQL("Select Licencia from Arqueros where Licencia = " + Integer.toString(aComprobar) + ";");
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botGuardar;
    private javax.swing.JLabel lApe;
    private javax.swing.JLabel lClub;
    private javax.swing.JLabel lLic;
    private javax.swing.JLabel lNom;
    private javax.swing.JTextField tApe;
    private javax.swing.JTextField tClub;
    private javax.swing.JTextField tLic;
    private javax.swing.JTextField tNom;
    // End of variables declaration//GEN-END:variables
}
