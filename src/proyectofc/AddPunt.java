/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Usuario
 */
public class AddPunt extends javax.swing.JFrame {

    static private String databaseRuta = ".\\data";
    static private String database = "Archery.db";
    private DefaultTableModel modeloArqueros;
    private DefaultListModel<String> modeloArquerosLista;
    private DefaultTableModel modeloCompeticiones;
    private DefaultListModel<String> modeloCompeticionesLista;

    public AddPunt() throws SQLException {
        initComponents();
        inicializarTablas();
        actualizarTabla1();
        actualizarTabla2();
//            String[] listaArq = new String[alArq.size()];
//            listaArq = alArq.toArray(listaArq);
//            pLista1.setListData(listaArq);
//            pLista1.setSelectedIndex(0);
//            String[] partes1 = pLista1.getSelectedValue().split(" ");
//            String nLic = partes1[0];
//            ResultSet rs2 = consqlite.EjecutarSQL("SELECT * FROM Puntuaciones inner join Arqueros on Puntuaciones.Licencia = Arqueros.Licencia where Puntuaciones.Licencia =" + nLic + ";");
//            ArrayList<String> alPunt = new ArrayList<String>();
//            while (rs2.next()) {
//                alPunt.add(rs2.getString(1) + " " + rs2.getString(10)); //IdParticipacion + Nombre Comp
//            }
//            String[] listaPunt = new String[alPunt.size()];
//            listaPunt = alPunt.toArray(listaPunt);
//            pLista2.setListData(listaPunt);
//            pLista2.setSelectedIndex(0);
//            //ResultSet rs3 = consqlite.EjecutarSQL("SELECT Arqueros.Nombre, Arqueros.Apellidos, Arqueros.Licencia, Arqueros.Club, Puntuaciones.Round1, Puntuaciones.Round2, Puntuaciones.n10, Puntuaciones.n9, Puntuaciones.Categoria FROM Puntuaciones inner join Arqueros on Puntuaciones.Licencia = Arqueros.Licencia where Puntuaciones.IdParticipacion =" + rs2.getString(1) + ";");
//            actualizarInfo("SELECT Arqueros.Nombre, Arqueros.Apellidos, Arqueros.Licencia, Arqueros.Club, Puntuaciones.Round1, Puntuaciones.Round2, Puntuaciones.n10, Puntuaciones.n9, Puntuaciones.Categoria FROM Puntuaciones inner join Arqueros on Puntuaciones.Licencia = Arqueros.Licencia where Puntuaciones.IdParticipacion =" + rs2.getString(1) + ";");
//            ResultSet rs = consqlite.EjecutarSQL("SELECT * FROM Competiciones;");
//            ArrayList<String> alComp = new ArrayList<String>();
//            while (rs.next()) {
//
//                alComp.add(rs.getString(1) + " " + rs.getString(2)); //IdCompeticion + Nombre Comp
//            }
//
//            if (alComp.size() != 0) {
//                String[] listaComp = new String[alComp.size()];
//                listaComp = alComp.toArray(listaComp);
//                DefaultListModel listModel = new DefaultListModel();
//                for (int i = 0; i < alComp.size(); i++) {
//                    listModel.addElement(alComp.get(i));
//                }
//                pLista1 = new JList(alComp.toArray());
//                System.out.println(pLista1.getSize() + "aaaaaa");
//                pLista1.setModel(listModel);
//                pLista1.setSelectedIndex(0);
//                String[] partes1 = pLista1.getSelectedValue().split(" ");
//                String idComp = partes1[0];
//                ResultSet rs2 = consqlite.EjecutarSQL("SELECT * FROM Puntuaciones inner join Competiciones on Puntuaciones.IdCompeticion = Competiciones.IdCompeticion where Puntuaciones.IdCompeticion = '" + idComp + "';");
//
//                ArrayList<String> alPunt = new ArrayList<String>();
//                while (rs2.next()) {
//                    alPunt.add(rs2.getString(1) + " " + rs2.getString(10)); //IdParticipacion + Nombre Comp
//                }
//                if (alPunt.size() != 0) {
//                    String[] listaPunt = new String[alPunt.size()];
//                    listaPunt = alPunt.toArray(listaPunt);
//                    pLista2.setListData(listaPunt);
//                    pLista2.setSelectedIndex(0);
//                    actualizarInfo("SELECT Arqueros.Nombre, Arqueros.Apellidos, Arqueros.Licencia, Arqueros.Club, Puntuaciones.Round1, Puntuaciones.Round2, Puntuaciones.n10, Puntuaciones.n9, Puntuaciones.Categoria, Puntuaciones.IdCompeticion FROM Puntuaciones inner join Arqueros on Puntuaciones.Licencia = Arqueros.Licencia where Puntuaciones.IdParticipacion =" + rs2.getString(1) + ";");
//                }
//            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tNom = new javax.swing.JTextField();
        lNom = new javax.swing.JLabel();
        tApe = new javax.swing.JTextField();
        lApe = new javax.swing.JLabel();
        lNLic = new javax.swing.JLabel();
        tNLic = new javax.swing.JTextField();
        lClub = new javax.swing.JLabel();
        tClub = new javax.swing.JTextField();
        lR1 = new javax.swing.JLabel();
        tR1 = new javax.swing.JTextField();
        lR2 = new javax.swing.JLabel();
        tR2 = new javax.swing.JTextField();
        lN10 = new javax.swing.JLabel();
        tN10 = new javax.swing.JTextField();
        lN9 = new javax.swing.JLabel();
        tN9 = new javax.swing.JTextField();
        lCat = new javax.swing.JLabel();
        tCat = new javax.swing.JTextField();
        botCancelar = new javax.swing.JButton();
        botGuardar = new javax.swing.JButton();
        lIdComp = new javax.swing.JLabel();
        tIdComp = new javax.swing.JTextField();
        botHome = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        pTabla1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        pTabla2 = new javax.swing.JTable();
        lInfo1 = new javax.swing.JLabel();
        lInfo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear nueva Puntuación");
        setPreferredSize(new java.awt.Dimension(846, 583));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tNom.setToolTipText("Nombre");
        tNom.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tNom.setEnabled(false);

        lNom.setText("Nombre:");
        lNom.setToolTipText("Nombre");

        tApe.setToolTipText("Apellidos");
        tApe.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tApe.setEnabled(false);

        lApe.setText("Apellidos:");
        lApe.setToolTipText("Apellidos");

        lNLic.setText("N Licencia:");
        lNLic.setToolTipText("N Licencia");

        tNLic.setToolTipText("Numero de Licencia");
        tNLic.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tNLic.setEnabled(false);

        lClub.setText("Club:");
        lClub.setToolTipText("Club");

        tClub.setToolTipText("Club");
        tClub.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tClub.setEnabled(false);

        lR1.setText("Round 1:");
        lR1.setToolTipText("Round 1");

        tR1.setToolTipText("Round 1");

        lR2.setText("Round 2:");
        lR2.setToolTipText("Round 2");

        tR2.setToolTipText("Round 2");

        lN10.setText("N de 10:");
        lN10.setToolTipText("N de 10");

        tN10.setToolTipText("Numero de dieces");

        lN9.setText("N de 9:");
        lN9.setToolTipText("N de 9");

        tN9.setToolTipText("Numero de Nueves");

        lCat.setText("Categoria:");
        lCat.setToolTipText("Categoria");

        tCat.setToolTipText("Categoria");

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

        lIdComp.setText("C. Competición:");
        lIdComp.setToolTipText("C. Competición");

        tIdComp.setToolTipText("Codigo de competición");
        tIdComp.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tIdComp.setEnabled(false);

        botHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofc/Ico_home.png"))); // NOI18N
        botHome.setToolTipText("Volver a Inicio");
        botHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botHomeActionPerformed(evt);
            }
        });

        pTabla1.setToolTipText("Tabla de Arqueros");
        pTabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTabla1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(pTabla1);

        pTabla2.setToolTipText("Tabla de competiciones");
        pTabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTabla2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(pTabla2);

        lInfo1.setText("Tabla de Arqueros:");
        lInfo1.setToolTipText("Tabla de Arqueros:");

        lInfo2.setText("Tabla de Competiciones:");
        lInfo2.setToolTipText("Tabla de Competiciones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lApe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lNLic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tClub)
                                    .addComponent(tNom)
                                    .addComponent(tApe)
                                    .addComponent(tNLic, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lR1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lN10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lN9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tN10)
                                    .addComponent(tR2)
                                    .addComponent(tR1)
                                    .addComponent(tN9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tCat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tIdComp, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                            .addComponent(lIdComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(botHome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lInfo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lInfo2)
                        .addContainerGap(105, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botHome)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNom)
                            .addComponent(lNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tApe)
                            .addComponent(lApe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNLic)
                            .addComponent(lNLic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tClub)
                            .addComponent(lClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lIdComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tIdComp)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tR1)
                            .addComponent(lR1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tR2)
                            .addComponent(lR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tN10)
                            .addComponent(lN10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tN9)
                            .addComponent(lN9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tCat)
                            .addComponent(lCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGuardarActionPerformed
        if (comprobarSiAlgoVacio()) {
            if (comprobarNumeros()) {
                try {
                    if (comprobarSiExiste(tNLic.getText(), tIdComp.getText())) {
                        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
                        consqlite.ConexionCrear(databaseRuta, database);
                        String cadenaAEjecutar = "";
                        try {
                            int nuevoNumIdPart = nuevoNPart(Integer.parseInt(tNLic.getText()));
                            String nuevoIdPart = tNLic.getText() + Integer.toString(nuevoNumIdPart);
                            int nuevoIdPartInt = Integer.parseInt(nuevoIdPart);
                            cadenaAEjecutar = "Insert into Puntuaciones (NParticipacion, Licencia, IdCompeticion, Round1, Round2, n10, n9, Categoria) values (" + Integer.toString(nuevoIdPartInt) + ", " + tNLic.getText() + ", '" + tIdComp.getText() + "', " + tR1.getText() + ", " + tR2.getText() + ", " + tN10.getText() + ", " + tN9.getText() + ", '" + tCat.getText() + "')";
                            consqlite.EjecutarActualizacion(cadenaAEjecutar);
                            consqlite.ConexionCerrar();
                            cerrarVentana();
                        } catch (SQLException ex) {
                            Logger.getLogger(AddPunt.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Ya existe ese registro de puntuación para ese arquero en esa competicion en la base de datos", "Error", 0);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AddPunt.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Debes introducir un numero en los Campos de round (1 y 2), en el N de 9 y en el Nde 10", "Error", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos", "Error", 0);
        }

    }//GEN-LAST:event_botGuardarActionPerformed

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botHomeActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_botHomeActionPerformed

    public void cerrarVentana(){
        PBaseDatos pBD = new PBaseDatos();
        pBD.setVisible(true);
        this.dispose();
    }
    
    private void pTabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTabla1MouseClicked
        if (pTabla1.getSelectedRow() != -1) {
            proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
            consqlite.ConexionCrear(databaseRuta, database);
            int seleccion = pTabla1.rowAtPoint(evt.getPoint());
            String lic = pTabla1.getValueAt(seleccion, 0).toString();
            try {
                actualizarCamposT1(lic);
            } catch (SQLException ex) {
                Logger.getLogger(AddPunt.class.getName()).log(Level.SEVERE, null, ex);
            }
            consqlite.ConexionCerrar();
        }
    }//GEN-LAST:event_pTabla1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void pTabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTabla2MouseClicked
        if (pTabla2.getSelectedRow() != -1) {
            int seleccion = pTabla2.rowAtPoint(evt.getPoint());
            String idBuscar = pTabla2.getValueAt(seleccion, 0).toString();

            actualizarCamposT2(idBuscar);

        }
    }//GEN-LAST:event_pTabla2MouseClicked

    private void actualizarCamposT1(String idBuscar) throws SQLException {
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);

        ResultSet rs = consqlite.EjecutarSQL("SELECT Arqueros.Nombre, Arqueros.Apellidos, Arqueros.Licencia, Arqueros.Club FROM Arqueros where Licencia = " + Integer.parseInt(idBuscar) + ";");
        if (rs.next()) {
            tNom.setText(rs.getString(1));
            tApe.setText(rs.getString(2));
            tNLic.setText(rs.getString(3));
            tClub.setText(rs.getString(4));
        }
        consqlite.ConexionCerrar();
    }

    private void actualizarCamposT2(String idBuscar) {
        tIdComp.setText(idBuscar);
    }

    private void actualizarTabla1() {

        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        try {
            ResultSet rs = consqlite.EjecutarSQL("SELECT * FROM Arqueros;");
            ArrayList<String> alArq = new ArrayList<String>();
            while (rs.next()) {
                alArq.add(rs.getString(1) + "#" + rs.getString(2) + "#" + rs.getString(3)); //Licencia + Nombre Arq + Apellidos Arq
            }
            modeloArquerosLista.clear();
            for (int i = 0; i < alArq.size(); i++) {

                String cabecera = alArq.get(i);
                modeloArquerosLista.addElement(cabecera);
                String[] datos = new String[2];
                datos[0] = alArq.get(i).split("#")[0];//Licencia
                datos[1] = alArq.get(i).split("#")[1] + " " + alArq.get(i).split("#")[2];//Nombre y apellido
                modeloArqueros.addRow(datos);
                revalidate();
                repaint();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pVistaArqueros.class.getName()).log(Level.SEVERE, null, ex);
        }
        consqlite.ConexionCerrar();
    }

    private void actualizarTabla2() throws SQLException {
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        try {
            ResultSet rs = consqlite.EjecutarSQL("SELECT * FROM Competiciones;");
            ArrayList<String> alArq = new ArrayList<String>();
            while (rs.next()) {
                alArq.add(rs.getString(1) + "#" + rs.getString(2) + "#" + rs.getString(3)); //Licencia + Nombre Arq + Apellidos Arq
            }
            modeloCompeticionesLista.clear();
            for (int i = 0; i < alArq.size(); i++) {

                String cabecera = alArq.get(i);
                modeloCompeticionesLista.addElement(cabecera);
                String[] datos = new String[2];
                datos[0] = alArq.get(i).split("#")[0];//Codigo competicion
                datos[1] = alArq.get(i).split("#")[1];//Nombre competicion
                modeloCompeticiones.addRow(datos);
                revalidate();
                repaint();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pVistaArqueros.class.getName()).log(Level.SEVERE, null, ex);
        }
        consqlite.ConexionCerrar();
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
            java.util.logging.Logger.getLogger(pVistaArqueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pVistaArqueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pVistaArqueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pVistaArqueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddPunt dialog = new AddPunt();
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(pVistaArqueros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botGuardar;
    private javax.swing.JButton botHome;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lApe;
    private javax.swing.JLabel lCat;
    private javax.swing.JLabel lClub;
    private javax.swing.JLabel lIdComp;
    private javax.swing.JLabel lInfo1;
    private javax.swing.JLabel lInfo2;
    private javax.swing.JLabel lN10;
    private javax.swing.JLabel lN9;
    private javax.swing.JLabel lNLic;
    private javax.swing.JLabel lNom;
    private javax.swing.JLabel lR1;
    private javax.swing.JLabel lR2;
    private javax.swing.JTable pTabla1;
    private javax.swing.JTable pTabla2;
    private javax.swing.JTextField tApe;
    private javax.swing.JTextField tCat;
    private javax.swing.JTextField tClub;
    private javax.swing.JTextField tIdComp;
    private javax.swing.JTextField tN10;
    private javax.swing.JTextField tN9;
    private javax.swing.JTextField tNLic;
    private javax.swing.JTextField tNom;
    private javax.swing.JTextField tR1;
    private javax.swing.JTextField tR2;
    // End of variables declaration//GEN-END:variables

    private void actualizarInfo(String SentenciaSQL) throws SQLException {
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        ResultSet rs = consqlite.EjecutarSQL(SentenciaSQL);
        tNom.setText(rs.getString(1));
        tApe.setText(rs.getString(2));
        tNLic.setText(rs.getString(3));
        tClub.setText(rs.getString(4));
        tR1.setText(rs.getString(5));
        tR2.setText(rs.getString(6));
        tN10.setText(rs.getString(7));
        tN9.setText(rs.getString(8));
        tCat.setText(rs.getString(9));
        tIdComp.setText(rs.getString(10));
        consqlite.ConexionCerrar();
    }

    private int nuevoNPart(int lic) throws SQLException {
        int nuevoN = 0;
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        ResultSet rs = consqlite.EjecutarSQL("Select NParticipacion from Puntuaciones where Licencia = " + lic + " order by NParticipacion DESC limit 1;");
        if (rs.next()) {
            String antiguoNPart = rs.getString(1);
            String[] partes = antiguoNPart.split(Integer.toString(lic));
            int UltimoNumero = Integer.parseInt(partes[1]);
            nuevoN = UltimoNumero + 1;
        } else {
            nuevoN = 1;
        }
        consqlite.ConexionCerrar();
        return nuevoN;
    }

    private boolean comprobarNumeros() {
        boolean salida = true;
        String sr1 = tR1.getText();
        String sr2 = tR2.getText();
        String sN10 = tN10.getText();
        String sN9 = tN9.getText();
        int ir1 = 0;
        int ir2 = 0;
        int iN10 = 0;
        int iN9 = 0;
        if (sr1.equals("") || sr2.equals("") || sN10.equals("") || sN9.equals("")) {
            salida = false;
        }
        try {
            ir1 = Integer.parseInt(sr1);
            ir2 = Integer.parseInt(sr2);
            iN10 = Integer.parseInt(sN10);
            iN9 = Integer.parseInt(sN9);
        } catch (NumberFormatException nfe) {
            salida = false;
            //JOptionPane.showMessageDialog(this, "Debes introducir un numero en los Campos", "Error", 0);
        }
        return salida;
    }

    private boolean comprobarSiExiste(String licencia, String IdComp) throws SQLException {
        boolean salida = true;
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        ResultSet rs = consqlite.EjecutarSQL("SELECT * From Puntuaciones where Licencia = " + licencia + " AND IdCompeticion = '" + IdComp + "';");
        if (rs.next()) {
            salida = false;
        }
        consqlite.ConexionCerrar();
        return salida;
    }

    //si algun campo esta vacio, devuelve false
    public boolean comprobarSiAlgoVacio() {
        boolean salida = true;
        if (tNom.getText().equals("") || tApe.getText().equals("") || tNLic.getText().equals("") || tClub.getText().equals("") || tIdComp.getText().equals("") || tR1.getText().equals("") || tR2.getText().equals("") || tN10.getText().equals("") || tN9.getText().equals("") || tCat.getText().equals("")) {
            salida = false;
        }
        return salida;
    }

    public void inicializarTablas() {
        modeloArqueros = new DefaultTableModel();
        modeloArquerosLista = new DefaultListModel<String>();
        modeloArqueros.addColumn("Licencia");
        modeloArqueros.addColumn("Nombre");
        pTabla1.setModel(modeloArqueros);
        TableColumnModel modeloColumna = pTabla1.getColumnModel();
        modeloColumna.getColumn(0).setPreferredWidth(30);
        modeloColumna.getColumn(1).setPreferredWidth(70);
        pTabla1.setDefaultEditor(Object.class, null);

        modeloCompeticiones = new DefaultTableModel();
        modeloCompeticionesLista = new DefaultListModel<String>();
        modeloCompeticiones.addColumn("Cod. Comp.");
        modeloCompeticiones.addColumn("Nombre Comp.");
        pTabla2.setModel(modeloCompeticiones);
        TableColumnModel modeloColumna2 = pTabla2.getColumnModel();
        modeloColumna2.getColumn(0).setPreferredWidth(50);
        modeloColumna2.getColumn(1).setPreferredWidth(70);
        pTabla2.setDefaultEditor(Object.class, null);
    }

}
