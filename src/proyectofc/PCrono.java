/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Usuario
 */
public class PCrono extends javax.swing.JFrame implements KeyListener {

    private String turno = "AB";
    private boolean tPreparacion = true;
    private boolean parte1 = true;
    private int tipoTurno = 1;
    private int tiempoTurno = 121;
    private int tRecFlecha = 0;
    private int nTanda = 1;
    int delay;
    Timer Reloj;
    private boolean avanzando = false;
    private boolean STOP = false;
    private boolean enRec = false;
    private boolean enRound = true;
    private boolean enSala = true;
    private boolean calentamiento = true;
    private File soundFile;
    private Clip clip;
    private AudioInputStream inputStream;

    public PCrono() {
        initComponents();

        try {
            soundFile = new File(".\\data\\horn.au");
            clip = AudioSystem.getClip();
            inputStream = AudioSystem.getAudioInputStream(soundFile);
            clip.open(inputStream);
            clip.start();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(PCrono.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PCrono.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PCrono.class.getName()).log(Level.SEVERE, null, ex);
        }

        PPrin.setFocusable(true);
        PPrin.addKeyListener(this);
        setExtendedState(MAXIMIZED_BOTH);
        PPrin.requestFocusInWindow();
        PConfig configInicial = new PConfig(this, true);
        configInicial.setVisible(true);
        establecerConfig(configInicial);
        this.delay = 1000;
        this.Reloj = new Timer(this.delay,
                new ActionListener() // Evento que se va a ejecutar cada tantos milisegundos como vienen en el Delay
        {
            public void actionPerformed(ActionEvent e) {
                avanzar();

            }
        }
        );
        Reloj.start();
    }

    private void paradaEmergencia() {
        if (avanzando) {
            if (STOP) {
                STOP = false;
                avanzando = true;
                hacerSonar(1);
                botStop.setText("STOP");
            } else {
                STOP = true;
                avanzando = false;
                hacerSonar(3);
                botStop.setText("Reanudar");
            }
        } else if (!avanzando && STOP) {
            if (STOP) {
                STOP = false;
                avanzando = true;
                hacerSonar(1);
                botStop.setText("STOP");
            } else {
                STOP = true;
                avanzando = false;
                hacerSonar(3);
                botStop.setText("Reanudar");
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public synchronized void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            if (botStart.getText().equals("Comenzar")) {
                botStart.setText("Terminar");
            } else {
                if (!tPreparacion && !parte1) {
                    botStart.setText("Comenzar");
                }
            }
            if (STOP) {//esta condicion permite retomar el cronometro parado en caso de emergencia
                paradaEmergencia();
            } else {
                if (!enRec) {
                    if (avanzando && tPreparacion && parte1) {
                        clip.loop(1);
                        tPreparacion = false;
                        lTiempo.setText(Integer.toString(tiempoTurno));
                    } else if (avanzando && !tPreparacion && parte1) {
                        clip.loop(2);
                        tPreparacion = true;
                        cambiarTurno();
                        parte1 = false;
                        lTiempo.setText("010");
                    } else if (avanzando && tPreparacion && !parte1) {
                        clip.loop(1);
                        parte1 = false;
                        tPreparacion = false;
                        lTiempo.setText(Integer.toString(tiempoTurno));
                    } else if (avanzando && !tPreparacion && !parte1) {
                        clip.loop(3);
                        avanzando = false;
                        tPreparacion = true;
                        parte1 = true;
                        lTiempo.setText("010");
                        cambiarTurno();
                    } else if (!avanzando) {
                        clip.loop(2);
                        avanzando = true;
                        lTiempo.setText("010");
                        lTiempo.setForeground(Color.BLUE);
                        nTanda++;
                    }
                } else {
                    if (avanzando && tPreparacion && enRound) {
                        tPreparacion = false;
                        clip.loop(1);
                        if (tRecFlecha < 100) {
                            lTiempo.setText("0" + Integer.toString(tRecFlecha));
                        } else {
                            lTiempo.setText(Integer.toString(tRecFlecha));
                        }
                        lTiempo.setForeground(Color.GREEN);
                    } else if (avanzando && !tPreparacion && enRound) {
                        avanzando = false;
                        tPreparacion = true;
                        parte1 = true;
                        lTiempo.setText("010");
                        lTiempo.setForeground(Color.BLUE);
                        enRec = false;
                        desbloquearSiEnRec();
                        tRecFlecha = 0;
                        clip.loop(3);
                    } else if (avanzando && tPreparacion && !enRound) {
                        tPreparacion = false;
                        clip.loop(1);
                        if (tRecFlecha < 100) {
                            lTiempo.setText("0" + Integer.toString(tRecFlecha));
                        } else {
                            lTiempo.setText(Integer.toString(tRecFlecha));
                        }
                        lTiempo.setForeground(Color.GREEN);
                    } else if (avanzando && !tPreparacion && !enRound) {
                        avanzando = false;
                        tPreparacion = true;
                        parte1 = true;
                        lTiempo.setText("010");
                        enRec = false;
                        desbloquearSiEnRec();
                        tRecFlecha = 0;
                        clip.loop(3);
                    } else if (!avanzando) {
                        avanzando = true;
                        System.out.println("aqui pita dos veces");
                        clip.loop(2);
                    }
                }
            }

        }

        if (key == KeyEvent.VK_PAGE_UP || key == KeyEvent.VK_PAGE_DOWN) {
            cambiarTurno();
        }

        if (key == KeyEvent.VK_INSERT && !avanzando) {
            if (!avanzando && !STOP) {
                PConfig conf = new PConfig(this, true);
                conf.setVisible(true);
                establecerConfig(conf);
                PPrin.requestFocusInWindow();
            }
        }

        if (key == KeyEvent.VK_DELETE) {
            paradaEmergencia();
        }

        if (key == KeyEvent.VK_END) {
            if (!avanzando && !STOP) {
                cambiarTipoTurno();
            }
        }

        if (key == KeyEvent.VK_HOME) {
            recuperarFecha();
        }

        if (key == KeyEvent.VK_ESCAPE) {
            PInicio pIn = new PInicio();
            pIn.setVisible(true);
            this.dispose();
        }
    }

    public synchronized void avanzar() {
        if (enRec) {
            lRecFlecha.setText("<html>Rec.<br>Flecha</html>");
        } else {
            lRecFlecha.setText("");
        }
        if (avanzando) {

            int n = Integer.parseInt(lTiempo.getText());
            if (tPreparacion) {
                if (n == 0 && !enRec) {
                    hacerSonar(1);
                    tPreparacion = false;
                    n = tiempoTurno;
                    lTiempo.setForeground(Color.GREEN);
                } else if (n == 0 && enRec) {
                    hacerSonar(1);
                    tPreparacion = false;
                    n = tRecFlecha;
                    lTiempo.setForeground(Color.YELLOW);
                } else {
                    lTiempo.setForeground(Color.BLUE);
                }
            } else {
                if (n <= 30) {
                    lTiempo.setForeground(Color.YELLOW);
                }
                if (n <= 40 && enRec) {
                    lTiempo.setForeground(Color.YELLOW);
                }
                if (n <= 10) {
                    lTiempo.setForeground(Color.RED);
                }
                if (n <= 120 && n >= 31) {
                    lTiempo.setForeground(Color.GREEN);
                }
                if (n == 0) {
                    hacerSonar(2);
                    if (enRec) {
                        avanzando = false;
                        tPreparacion = true;
                        n = 11;
                        lTiempo.setForeground(Color.BLUE);
                        //hacerSonar(2);
                    } else if (parte1) {
                        if (tipoTurno == 5) {
                            avanzando = false;
                            tPreparacion = true;
                            cambiarTurno();
                            parte1 = true;
                            hacerSonar(1);
                            lTiempo.setForeground(Color.BLUE);
                            lTiempo.setText("010");
                        } else {
                            tPreparacion = true;
                            n = 11;
                            lTiempo.setForeground(Color.BLUE);
                            //hacerSonar(2);
                            cambiarTurno();
                            parte1 = false;
                        }

                    } else {
                        avanzando = false;
                        tPreparacion = true;
                        cambiarTurno();
                        parte1 = true;
                        hacerSonar(1);
                        lTiempo.setForeground(Color.BLUE);
                        lTiempo.setText("010");
                    }
                }
            }
            if (avanzando) {
                n--;
                if (n < 100) {
                    if (n < 10) {
                        lTiempo.setText("00" + Integer.toString(n));
                    } else {
                        lTiempo.setText("0" + Integer.toString(n));
                    }
                } else {
                    lTiempo.setText(Integer.toString(n));
                }
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PPrin = new javax.swing.JPanel();
        lTipoTurno = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botStart = new javax.swing.JButton();
        botRecFlecha = new javax.swing.JButton();
        botStop = new javax.swing.JButton();
        botTurno = new javax.swing.JButton();
        botTipoTurno = new javax.swing.JButton();
        botConf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lTurno = new javax.swing.JLabel();
        lRecFlecha = new javax.swing.JLabel();
        lTiempo = new javax.swing.JTextArea();
        lCalentamiento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");
        setBackground(new java.awt.Color(0, 0, 0));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lTipoTurno.setFont(new java.awt.Font("Dialog", 1, 55)); // NOI18N
        lTipoTurno.setText("AB-CD-CD-AB");
        lTipoTurno.setToolTipText("Tipo de Turno");

        botStart.setMnemonic(KeyEvent.VK_SPACE);
        botStart.setText("Comenzar");
        botStart.setToolTipText("Comenzar (Barra Espaciadora)");
        botStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botStartActionPerformed(evt);
            }
        });

        botRecFlecha.setMnemonic(KeyEvent.VK_SPACE);
        botRecFlecha.setText("Rec. Flecha");
        botRecFlecha.setToolTipText("Rec. Flecha (Inicio)");
        botRecFlecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRecFlechaActionPerformed(evt);
            }
        });

        botStop.setMnemonic(KeyEvent.VK_SPACE);
        botStop.setText("STOP");
        botStop.setToolTipText("Stop (Supr)");
        botStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botStopActionPerformed(evt);
            }
        });

        botTurno.setMnemonic(KeyEvent.VK_PAGE_UP);
        botTurno.setText("Cambiar Turno");
        botTurno.setToolTipText("Cambiar Turno (Av. Pag./ Rt. Pag.)");
        botTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botTurnoActionPerformed(evt);
            }
        });

        botTipoTurno.setMnemonic(KeyEvent.VK_PAGE_UP);
        botTipoTurno.setText("Cambiar Tipo de Turno");
        botTipoTurno.setToolTipText("Cambiar Tipo de Turno (Fin)");
        botTipoTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botTipoTurnoActionPerformed(evt);
            }
        });

        botConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofc/baseline_settings_black_18dp.png"))); // NOI18N
        botConf.setMnemonic(KeyEvent.VK_SPACE);
        botConf.setToolTipText("Configuracion (Ins)");
        botConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConfActionPerformed(evt);
            }
        });

        jLabel1.setText("Salir: ESC");
        jLabel1.setToolTipText("Salir: ESC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(botStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botRecFlecha, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botConf, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botTipoTurno)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botConf, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botStop, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botStart, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botRecFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botTipoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lTurno.setFont(new java.awt.Font("Dialog", 1, 300)); // NOI18N
        lTurno.setText("AB");
        lTurno.setToolTipText("Turno");

        lRecFlecha.setFont(new java.awt.Font("Dialog", 1, 130)); // NOI18N
        lRecFlecha.setForeground(new java.awt.Color(255, 255, 0));
        lRecFlecha.setToolTipText("Indicador Recuperacion de Flecha");

        lTiempo.setEditable(false);
        lTiempo.setColumns(20);
        lTiempo.setFont(new java.awt.Font("Dialog", 1, 500)); // NOI18N
        lTiempo.setForeground(java.awt.Color.blue);
        lTiempo.setLineWrap(true);
        lTiempo.setRows(5);
        lTiempo.setText("010");
        lTiempo.setToolTipText("Tiempo");

        lCalentamiento.setFont(new java.awt.Font("Dialog", 1, 150)); // NOI18N
        lCalentamiento.setForeground(new java.awt.Color(255, 102, 0));
        lCalentamiento.setToolTipText("Indicador de calentamiento");

        javax.swing.GroupLayout PPrinLayout = new javax.swing.GroupLayout(PPrin);
        PPrin.setLayout(PPrinLayout);
        PPrinLayout.setHorizontalGroup(
            PPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPrinLayout.createSequentialGroup()
                .addGroup(PPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PPrinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lCalentamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrinLayout.createSequentialGroup()
                        .addComponent(lTipoTurno)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrinLayout.createSequentialGroup()
                        .addComponent(lTurno)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrinLayout.createSequentialGroup()
                        .addComponent(lRecFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrinLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        PPrinLayout.setVerticalGroup(
            PPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPrinLayout.createSequentialGroup()
                .addGroup(PPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PPrinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lTipoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(lRecFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCalentamiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrinLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
//        int key = evt.getKeyCode();
//        System.out.println("tecla");
//        if (key == KeyEvent.VK_SPACE) {
//            if (avanzando) {
//                if (tPreparacion) {
//
//                    lTiempo.setText("120");
//                    tPreparacion = false;
//                } else {
//                    if (parte1) {
//                        lTiempo.setText("10");
//                        tPreparacion = true;
//                    }
//                    avanzando = false;
//                    lTiempo.setText("000");
//                }
//
//            } else {
//                tPreparacion = true;
//                avanzando = true;
//                lTiempo.setText("10");
//            }
//        }
//
//        if (key == KeyEvent.VK_PAGE_UP || key == KeyEvent.VK_PAGE_DOWN) {
//            cambiarTurno();
//        }
    }//GEN-LAST:event_formKeyPressed

    private void botTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botTurnoActionPerformed
        cambiarTurno();
    }//GEN-LAST:event_botTurnoActionPerformed

    private void botStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botStartActionPerformed
        if (botStart.getText().equals("Comenzar")) {
            botStart.setText("Terminar");
        } else {
            if (!tPreparacion && !parte1) {
                botStart.setText("Comenzar");
            }
        }
        if (STOP) {//esta condicion permite retomar el cronometro parado en caso de emergencia
            paradaEmergencia();
        } else {
            if (!enRec) {
                if (avanzando && tPreparacion && parte1) {
                    clip.loop(1);
                    tPreparacion = false;
                    lTiempo.setText(Integer.toString(tiempoTurno));
                } else if (avanzando && !tPreparacion && parte1) {
                    clip.loop(2);
                    tPreparacion = true;
                    cambiarTurno();
                    parte1 = false;
                    lTiempo.setText("010");

                } else if (avanzando && tPreparacion && !parte1) {
                    clip.loop(1);
                    parte1 = false;
                    tPreparacion = false;
                    lTiempo.setText(Integer.toString(tiempoTurno));
                } else if (avanzando && !tPreparacion && !parte1) {
                    clip.loop(3);
                    avanzando = false;
                    tPreparacion = true;
                    parte1 = true;
                    lTiempo.setText("010");
                    cambiarTurno();
                } else if (!avanzando) {
                    clip.loop(2);
                    avanzando = true;
                    lTiempo.setText("010");
                    nTanda++;
                }
            } else {
                if (avanzando && tPreparacion && enRound) {
                    tPreparacion = false;
                    lTiempo.setText(Integer.toString(tRecFlecha));
                } else if (avanzando && !tPreparacion && enRound) {
                    avanzando = false;
                    tPreparacion = true;
                    parte1 = true;
                    lTiempo.setText("010");
                    enRec = false;
                    desbloquearSiEnRec();
                    tRecFlecha = 0;
                } else if (avanzando && tPreparacion && !enRound) {
                    tPreparacion = false;
                    lTiempo.setText(Integer.toString(tRecFlecha));
                } else if (avanzando && !tPreparacion && !enRound) {
                    avanzando = false;
                    tPreparacion = true;
                    parte1 = true;
                    lTiempo.setText("010");
                    enRec = false;
                    desbloquearSiEnRec();
                    tRecFlecha = 0;
                } else if (!avanzando) {
                    avanzando = true;
                    clip.loop(2);
                }
            }
        }
    }//GEN-LAST:event_botStartActionPerformed

    private void botTipoTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botTipoTurnoActionPerformed
        if (!avanzando && !STOP) {
            cambiarTipoTurno();
        }
    }//GEN-LAST:event_botTipoTurnoActionPerformed

    private void botRecFlechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRecFlechaActionPerformed
        recuperarFecha();
    }//GEN-LAST:event_botRecFlechaActionPerformed

    private void botStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botStopActionPerformed
        paradaEmergencia();
        PPrin.requestFocusInWindow();
    }//GEN-LAST:event_botStopActionPerformed

    private void botConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botConfActionPerformed
        if (!avanzando && !STOP) {
            PConfig conf = new PConfig(this, true);
            conf.setVisible(true);
            establecerConfig(conf);
        }
        PPrin.requestFocusInWindow();
    }//GEN-LAST:event_botConfActionPerformed

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
            java.util.logging.Logger.getLogger(PCrono.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PCrono.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PCrono.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PCrono.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PCrono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PPrin;
    private javax.swing.JButton botConf;
    private javax.swing.JButton botRecFlecha;
    private javax.swing.JButton botStart;
    private javax.swing.JButton botStop;
    private javax.swing.JButton botTipoTurno;
    private javax.swing.JButton botTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lCalentamiento;
    private javax.swing.JLabel lRecFlecha;
    private javax.swing.JTextArea lTiempo;
    private javax.swing.JLabel lTipoTurno;
    private javax.swing.JLabel lTurno;
    // End of variables declaration//GEN-END:variables

    private void cambiarTurno() {
        switch (tipoTurno) {
            case 1:
                if (parte1) {
                    if (turno.equals("AB")) {
                        turno = "CD";
                        lTurno.setText(turno);
                    } else {
                        turno = "AB";
                        lTurno.setText(turno);
                    }
                } else {
                    //no es parte 1, no se cambia
                }
                break;
            case 2:
                if (parte1) {
                    if (turno.equals("AB")) {
                        turno = "CD";
                        lTurno.setText(turno);
                    } else {
                        turno = "AB";
                        lTurno.setText(turno);
                    }
                } else {
                    //no es parte 1, no se cambia
                }
                break;
            case 3:
                //se cambia cada turno
                if (turno.equals("AB")) {
                    turno = "CD";
                    lTurno.setText(turno);
                } else {
                    turno = "AB";
                    lTurno.setText(turno);
                }
                break;
            case 4:
                //se cambia cada turno
                if (turno.equals("AB")) {
                    turno = "CD";
                    lTurno.setText(turno);
                } else {
                    turno = "AB";
                    lTurno.setText(turno);
                }
                break;
            case 5:
                //no se cambia
                break;
        }

    }

    private void cambiarTipoTurno() {
        tipoTurno++;
        if (tipoTurno >= 6) {
            tipoTurno = 1;
        }
        lTiempo.setText("010");
        lTiempo.setForeground(Color.BLUE);
        tPreparacion = true;
        parte1 = true;
        avanzando = false;
        STOP = false;
        actualizarTipoTurno();
    }

    public void establecerConfig(PConfig panelDeConf) {
        if (panelDeConf.getMantenerCambios()) {
            this.enSala = panelDeConf.getEnSala();
            actualizarEnSala();
            this.enRound = panelDeConf.getEnRound();
            this.tipoTurno = panelDeConf.getTipoTurno();
            this.calentamiento = panelDeConf.getCalentamiento();
            if (calentamiento) {
                ponerCalentamiento();
            } else {
                quitarCalentamiento();
            }
            actualizarTipoTurno();
        }
    }

    public void actualizarTipoTurno() {
        switch (tipoTurno) {
            case 1:
                lTipoTurno.setText("AB-CD-CD-AB");
                turno = "AB";
                lTurno.setText(turno);
                break;
            case 2:
                lTipoTurno.setText("CD-AB-AB-CD");
                turno = "CD";
                lTurno.setText(turno);
                break;
            case 3:
                lTipoTurno.setText("AB-CD-AB-CD");
                turno = "AB";
                lTurno.setText(turno);
                break;
            case 4:
                lTipoTurno.setText("CD-AB-CD-AB");
                turno = "CD";
                lTurno.setText(turno);
                break;
            case 5:
                lTipoTurno.setText("AB-AB-AB-AB");
                turno = "AB";
                lTurno.setText(turno);
                break;
        }
    }

    public void actualizarEnSala() {
        if (enSala) {
            tiempoTurno = 120;
        } else {
            tiempoTurno = 240;
        }
    }

    public void recuperarFecha() {
        String sNFlechas = "";
        int nFlechas = 0;
        sNFlechas = String.valueOf(JOptionPane.showInputDialog(this, "Introduzca el numero de flecha que se quieren recuperar", "Recuperación de flechas", 1));
        PPrin.requestFocusInWindow();
        if (sNFlechas.equals("")) {
            JOptionPane.showMessageDialog(this, "Debes introducir un numero", "Error", 0);
        }
        try {
            nFlechas = Integer.parseInt(sNFlechas);
            if (nFlechas != 0) {
                enRec = true;
                bloquearSiEnRec();
                if (enRound) {
                    tRecFlecha = nFlechas * 40;
                } else {
                    tRecFlecha = nFlechas * 20;
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Debes introducir un numero", "Error", 0);
        }

    }

    public boolean esTandaPar() {
        if (nTanda % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void hacerSonar(int n) {
        clip.loop(n);
    }

    public void bloquearSiEnRec() {
        botRecFlecha.setEnabled(false);
        botStop.setEnabled(false);
        botTipoTurno.setEnabled(false);
        botTurno.setEnabled(false);
        botConf.setEnabled(false);
    }

    public void desbloquearSiEnRec() {
        botRecFlecha.setEnabled(true);
        botStop.setEnabled(true);
        botTipoTurno.setEnabled(true);
        botTurno.setEnabled(true);
        botConf.setEnabled(true);
    }

    public void ponerCalentamiento() {
        lCalentamiento.setText("Calentamiento");
    }

    public void quitarCalentamiento() {
        lCalentamiento.setText("");
    }

}
