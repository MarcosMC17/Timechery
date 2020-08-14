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
public class pVistaArqueros extends javax.swing.JFrame {

    static private String databaseRuta = ".\\data";
    static private String database = "Archery.db";
    static private boolean mostrarArqueros;
    private boolean aniadiendo = false;
    private boolean modificando = false;
    private DefaultTableModel modeloArqueros;
    private DefaultListModel<String> modeloArquerosLista;
    private DefaultTableModel modeloPuntuaciones;
    private DefaultListModel<String> modeloPuntuacionesLista;

    public pVistaArqueros(boolean mostrarArqueros) throws SQLException {
        initComponents();
        this.mostrarArqueros = mostrarArqueros;
        inicializarTablas();
        actualizarTabla1();

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
        lBuscar = new javax.swing.JLabel();
        lN10 = new javax.swing.JLabel();
        tN10 = new javax.swing.JTextField();
        lN9 = new javax.swing.JLabel();
        tN9 = new javax.swing.JTextField();
        lCat = new javax.swing.JLabel();
        tCat = new javax.swing.JTextField();
        botCancelar = new javax.swing.JButton();
        botGuardar = new javax.swing.JButton();
        botModificar = new javax.swing.JButton();
        lIdComp = new javax.swing.JLabel();
        tIdComp = new javax.swing.JTextField();
        botHome = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        pTabla1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        pTabla2 = new javax.swing.JTable();
        lNPart = new javax.swing.JLabel();
        tNPart = new javax.swing.JTextField();
        lBuscar1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizacion de datos");
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

        tNLic.setToolTipText("Numero de licencia");
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
        tR1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tR1.setEnabled(false);

        lR2.setText("Round 2:");
        lR2.setToolTipText("Round 2");

        tR2.setToolTipText("Round 2");
        tR2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tR2.setEnabled(false);

        lBuscar.setText("Tabla Arqueros:");
        lBuscar.setToolTipText("");

        lN10.setText("N de 10:");
        lN10.setToolTipText("N de 10");

        tN10.setToolTipText("Numero de Dieces");
        tN10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tN10.setEnabled(false);

        lN9.setText("N de 9:");
        lN9.setToolTipText("N de 9");

        tN9.setToolTipText("Numero de Nueves");
        tN9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tN9.setEnabled(false);

        lCat.setText("Categoria:");
        lCat.setToolTipText("Categoria");

        tCat.setToolTipText("Categoria");
        tCat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tCat.setEnabled(false);

        botCancelar.setText("Cancelar");
        botCancelar.setToolTipText("Cancelar");
        botCancelar.setEnabled(false);
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        botGuardar.setText("Guardar Cambios");
        botGuardar.setToolTipText("Guardar Cambios");
        botGuardar.setEnabled(false);
        botGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGuardarActionPerformed(evt);
            }
        });

        botModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofc/Ico_modify.png"))); // NOI18N
        botModificar.setToolTipText("Modificar");
        botModificar.setEnabled(false);
        botModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botModificarActionPerformed(evt);
            }
        });

        lIdComp.setText("C. Competicion:");
        lIdComp.setToolTipText("C. Competicion");

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

        pTabla1.setToolTipText("Tabla de Información");
        pTabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTabla1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(pTabla1);

        pTabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod. Comp.", "Nombre Comp."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pTabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTabla2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(pTabla2);

        lNPart.setText("Num. Part:");
        lNPart.setToolTipText("Num. Part");

        tNPart.setToolTipText("Numero de participación");
        tNPart.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tNPart.setEnabled(false);

        lBuscar1.setText("Tabla Puntuaciones:");
        lBuscar1.setToolTipText("Tabla Puntuaciones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botHome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(botCancelar)
                                                    .addGap(141, 141, 141))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(93, 93, 93)
                                                    .addComponent(botGuardar)))
                                            .addComponent(lIdComp)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lR1)
                                                    .addComponent(lR2)
                                                    .addComponent(lN10)
                                                    .addComponent(lN9)
                                                    .addComponent(lCat))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tIdComp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tN10)
                                                        .addComponent(tR2)
                                                        .addComponent(tR1)
                                                        .addComponent(tN9, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(tCat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(11, 11, 11)
                                        .addComponent(botModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lNom)
                                            .addComponent(lApe)
                                            .addComponent(lNLic)
                                            .addComponent(lClub)
                                            .addComponent(lNPart))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tNPart, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tClub)
                                                .addComponent(tNom)
                                                .addComponent(tApe)
                                                .addComponent(tNLic, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(lBuscar1))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(botHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBuscar)
                    .addComponent(lBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(botModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lNom))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lApe))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tNLic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lNLic))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lClub))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tNPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lNPart))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lIdComp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tIdComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lR1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lR2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tN10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lN10))
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tN9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lN9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lCat))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botCancelar)
                                .addComponent(botGuardar))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void botModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botModificarActionPerformed
        modificando = true;
        tR1.setEnabled(true);
        tR2.setEnabled(true);
        tN10.setEnabled(true);
        tN9.setEnabled(true);
        tCat.setEnabled(true);
        pTabla1.setEnabled(false);
        pTabla2.setEnabled(false);
        botCancelar.setEnabled(true);
        botGuardar.setEnabled(true);
    }//GEN-LAST:event_botModificarActionPerformed

    private void botGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGuardarActionPerformed
        if (comprobarSiAlgoVacio()) {
            if (comprobarNumeros()) {
                proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
                consqlite.ConexionCrear(databaseRuta, database);
                consqlite.EjecutarActualizacion("UPDATE Puntuaciones SET Round1 =" + tR1.getText() + ", Round2 =" + tR2.getText() + ", n10 = " + tN10.getText() + ", n9 = " + tN9.getText() + ", Categoria = '" + tCat.getText() + "' where NParticipacion = '" + tNPart.getText() + "';");
                consqlite.ConexionCerrar();
                botGuardar.setEnabled(false);
                botCancelar.setEnabled(false);
                tR1.setEnabled(false);
                tR2.setEnabled(false);
                tN10.setEnabled(false);
                tN9.setEnabled(false);
                tCat.setEnabled(false);
                pTabla1.setEnabled(true);
                pTabla2.setEnabled(true);
                actualizarTabla1();
                
            } else {
                JOptionPane.showMessageDialog(this, "Debes introducir un numero en los Campos de round (1 y 2), en el N de 9 y en el Nde 10", "Error", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos", "Error", 0);
        }

    }//GEN-LAST:event_botGuardarActionPerformed

    //si algun campo esta vacio, devuelve false
    public boolean comprobarSiAlgoVacio() {
        boolean salida = true;
        if (tNom.getText().equals("") || tApe.getText().equals("") || tNLic.getText().equals("") || tClub.getText().equals("") || tIdComp.getText().equals("") || tR1.getText().equals("") || tR2.getText().equals("") || tN10.getText().equals("") || tN9.getText().equals("") || tCat.getText().equals("")) {
            salida = false;
        }
        return salida;
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

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        aniadiendo = false;
        modificando = false;
        tR1.setEnabled(false);
        tR2.setEnabled(false);
        tN10.setEnabled(false);
        tN9.setEnabled(false);
        tCat.setEnabled(false);
        botModificar.setEnabled(true);
        botCancelar.setEnabled(false);
        botGuardar.setEnabled(false);
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botHomeActionPerformed
        PBaseDatos pBD = new PBaseDatos();
        pBD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botHomeActionPerformed

    private void pTabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTabla1MouseClicked
        if (pTabla1.getSelectedRow() != -1) {
            proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
            consqlite.ConexionCrear(databaseRuta, database);
            int seleccion = pTabla1.rowAtPoint(evt.getPoint());
            String lic = pTabla1.getValueAt(seleccion, 0).toString();
            borrarTabla2();
            botModificar.setEnabled(false);
            ponerEnBlanco();
            try {
                actualizarTabla2(lic);
            } catch (SQLException ex) {
                Logger.getLogger(pVistaArqueros.class.getName()).log(Level.SEVERE, null, ex);
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
            String idBuscar = pTabla2.getValueAt(seleccion, 1).toString();
            try {
                actualizarCampos(idBuscar);
            } catch (SQLException ex) {
                Logger.getLogger(pVistaArqueros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_pTabla2MouseClicked

    private void actualizarCampos(String idBuscar) throws SQLException {
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        if (mostrarArqueros) {
            String[] parte = idBuscar.split(" ");
            String parteABuscar = parte[0];
            ResultSet rs = consqlite.EjecutarSQL("SELECT Arqueros.Nombre, Arqueros.Apellidos, Arqueros.Licencia, Arqueros.Club, Competiciones.IdCompeticion, Puntuaciones.Round1, Puntuaciones.Round2, Puntuaciones.n10, Puntuaciones.n9, Puntuaciones.Categoria, Puntuaciones.NParticipacion FROM Puntuaciones inner join Arqueros on Puntuaciones.Licencia = Arqueros.Licencia inner join Competiciones on Puntuaciones.IdCompeticion  = Competiciones.IdCompeticion  where Puntuaciones.IdCompeticion = '" + parteABuscar + "';");

            if (rs.next()) {

                tNom.setText(rs.getString(1));
                tApe.setText(rs.getString(2));
                tNLic.setText(rs.getString(3));
                tClub.setText(rs.getString(4));
                tIdComp.setText(rs.getString(5));
                tR1.setText(rs.getString(6));
                tR2.setText(rs.getString(7));
                tN10.setText(rs.getString(8));
                tN9.setText(rs.getString(9));
                tCat.setText(rs.getString(10));
                tNPart.setText(rs.getString(11));
                botModificar.setEnabled(true);
            }

        } else {
            String[] parte = idBuscar.split(" ");
            String parteABuscar = parte[0];
            ResultSet rs = consqlite.EjecutarSQL("SELECT Arqueros.Nombre, Arqueros.Apellidos, Arqueros.Licencia, Arqueros.Club, Competiciones.IdCompeticion, Puntuaciones.Round1, Puntuaciones.Round2, Puntuaciones.n10, Puntuaciones.n9, Puntuaciones.Categoria, Puntuaciones.NParticipacion FROM Puntuaciones inner join Arqueros on Puntuaciones.Licencia = Arqueros.Licencia inner join Competiciones on Puntuaciones.IdCompeticion  = Competiciones.IdCompeticion  where Puntuaciones.Licencia = " + parteABuscar + ";");

            if (rs.next()) {

                tNom.setText(rs.getString(1));
                tApe.setText(rs.getString(2));
                tNLic.setText(rs.getString(3));
                tClub.setText(rs.getString(4));
                tIdComp.setText(rs.getString(5));
                tR1.setText(rs.getString(6));
                tR2.setText(rs.getString(7));
                tN10.setText(rs.getString(8));
                tN9.setText(rs.getString(9));
                tCat.setText(rs.getString(10));
                tNPart.setText(rs.getString(11));
                botModificar.setEnabled(true);
            }
        }
        consqlite.ConexionCerrar();
    }

    public void borrarTabla1(){
        DefaultTableModel tb = (DefaultTableModel) pTabla1.getModel();
        int a = pTabla1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount()-1);
        }
    }
    
    public void borrarTabla2(){
        DefaultTableModel tb = (DefaultTableModel) pTabla2.getModel();
        int a = pTabla2.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount()-1);
        }
    }
    
    private void actualizarTabla1() {
        modeloArquerosLista.clear();
        borrarTabla1();
        if (mostrarArqueros) {
            proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
            consqlite.ConexionCrear(databaseRuta, database);
            try {
                ResultSet rs = consqlite.EjecutarSQL("SELECT * FROM Arqueros;");
                ArrayList<String> alArq = new ArrayList<String>();
                while (rs.next()) {
                    alArq.add(rs.getString(1) + "#" + rs.getString(2) + "#" + rs.getString(3)); //Licencia + Nombre Arq + Apellidos Arq
                    
                }
                
                for (int i = 0; i < alArq.size(); i++) {

                    String cabecera = alArq.get(i);
                    modeloArquerosLista.addElement(cabecera);
                    String[] datos = new String[2];
                    datos[0] = alArq.get(i).split("#")[0];//Licencia
                    datos[1] = alArq.get(i).split("#")[1] + alArq.get(i).split("#")[2];//Nombre y apellido
                    modeloArqueros.addRow(datos);
                    revalidate();
                    repaint();
                }
            } catch (SQLException ex) {
                Logger.getLogger(pVistaArqueros.class.getName()).log(Level.SEVERE, null, ex);
            }
            consqlite.ConexionCerrar();
        } else {
            proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
            consqlite.ConexionCrear(databaseRuta, database);
            try {
                ResultSet rs = consqlite.EjecutarSQL("SELECT * FROM Competiciones;");
                ArrayList<String> alArq = new ArrayList<String>();
                while (rs.next()) {
                    alArq.add(rs.getString(1) + "#" + rs.getString(2) + "#" + rs.getString(3));
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
                
                for (int i = 0; i < alArq.size(); i++) {

                    String cabecera = alArq.get(i);
                    modeloArquerosLista.addElement(cabecera);
                    String[] datos = new String[2];
                    datos[0] = alArq.get(i).split("#")[0];
                    datos[1] = alArq.get(i).split("#")[1] + " " + alArq.get(i).split("#")[2];
                    modeloArqueros.addRow(datos);
                    revalidate();
                    repaint();
                }
            } catch (SQLException ex) {
                Logger.getLogger(pVistaArqueros.class.getName()).log(Level.SEVERE, null, ex);
            }
            consqlite.ConexionCerrar();
        }
    }

    private void actualizarTabla2(String nBuscar) throws SQLException {
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        modeloPuntuacionesLista.clear();
        borrarTabla2();
        if (mostrarArqueros) {
            ResultSet rs = consqlite.EjecutarSQL("SELECT Puntuaciones.NParticipacion, Competiciones.IdCompeticion, Competiciones.Nombre FROM Puntuaciones inner join Competiciones on Puntuaciones.IdCompeticion = Competiciones.IdCompeticion where Puntuaciones.Licencia = " + nBuscar + ";");
            ArrayList<String> punts = new ArrayList<String>();
            while (rs.next()) {
                punts.add(rs.getString(1) + "#" + rs.getString(2) + "#" + rs.getString(3));
            }
            
            for (int i = 0; i < punts.size(); i++) {
                botModificar.setEnabled(true);
                String cabecera = punts.get(i);
                modeloPuntuacionesLista.addElement(cabecera);
                String[] datos = new String[2];
                datos[0] = punts.get(i).split("#")[0];
                datos[1] = punts.get(i).split("#")[1] + " " + punts.get(i).split("#")[2];
                modeloPuntuaciones.addRow(datos);
                revalidate();
                repaint();
            }
        } else {
            ResultSet rs = consqlite.EjecutarSQL("SELECT Puntuaciones.NParticipacion, Arqueros.Licencia, Arqueros.Nombre, Arqueros.Apellidos FROM Puntuaciones inner join Arqueros on Puntuaciones.Licencia = Arqueros.Licencia where Puntuaciones.IdCompeticion = '" + nBuscar + "';");
            ArrayList<String> punts = new ArrayList<String>();
            while (rs.next()) {
                punts.add(rs.getString(1) + "#" + rs.getString(2) + "#" + rs.getString(3) + "#" + rs.getString(4));
            }
            
            for (int i = 0; i < punts.size(); i++) {

                String cabecera = punts.get(i);
                modeloPuntuacionesLista.addElement(cabecera);
                String[] datos = new String[2];
                datos[0] = punts.get(i).split("#")[0];
                datos[1] = punts.get(i).split("#")[1] + " " + punts.get(i).split("#")[2] + " " + punts.get(i).split("#")[3];
                modeloPuntuaciones.addRow(datos);
                revalidate();
                repaint();
            }
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
                    pVistaArqueros dialog = new pVistaArqueros(mostrarArqueros);
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
    private javax.swing.JButton botModificar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lApe;
    private javax.swing.JLabel lBuscar;
    private javax.swing.JLabel lBuscar1;
    private javax.swing.JLabel lCat;
    private javax.swing.JLabel lClub;
    private javax.swing.JLabel lIdComp;
    private javax.swing.JLabel lN10;
    private javax.swing.JLabel lN9;
    private javax.swing.JLabel lNLic;
    private javax.swing.JLabel lNPart;
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
    private javax.swing.JTextField tNPart;
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

    public void inicializarTablas() {
        //parte de arqueros o competiciones
        modeloArqueros = new DefaultTableModel();
        modeloArquerosLista = new DefaultListModel<String>();
        if (mostrarArqueros) {
            lBuscar.setText("Tabla Arqueros:");
            modeloArqueros.addColumn("Licencia");
            modeloArqueros.addColumn("Nombre");
        } else {
            lBuscar.setText("Tabla Competiciones:");
            modeloArqueros.addColumn("Cod. Comp.");
            modeloArqueros.addColumn("Nombre Comp.");
        }
        pTabla1.setModel(modeloArqueros);
        TableColumnModel modeloColumna = pTabla1.getColumnModel();
        modeloColumna.getColumn(0).setPreferredWidth(30);
        modeloColumna.getColumn(1).setPreferredWidth(70);
        pTabla1.setDefaultEditor(Object.class, null);
        //parte de puntuaciones
        modeloPuntuaciones = new DefaultTableModel();
        modeloPuntuacionesLista = new DefaultListModel<String>();
        if (mostrarArqueros) {
            modeloPuntuaciones.addColumn("Cod.Part.");
            modeloPuntuaciones.addColumn("Nombre Comp.");
        } else {
            modeloPuntuaciones.addColumn("Cod.Part.");
            modeloPuntuaciones.addColumn("Nombre Arq.");
        }
        pTabla2.setModel(modeloPuntuaciones);
        TableColumnModel modeloColumna2 = pTabla2.getColumnModel();
        modeloColumna2.getColumn(0).setPreferredWidth(50);
        modeloColumna2.getColumn(1).setPreferredWidth(70);
        pTabla2.setDefaultEditor(Object.class, null);

    }
    
    public void ponerEnBlanco(){
        tNom.setText("");
        tApe.setText("");
        tNLic.setText("");
        tClub.setText("");
        tR1.setText("");
        tR2.setText("");
        tN10.setText("");
        tN9.setText("");
        tCat.setText("");
        tIdComp.setText("");
        tNPart.setText("");
    }

}
