/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.CentralMarca;
import Clases.CentralModelo;
import Controlador.ControladorArchivosA;
import Controlador.ControladorArchivosM;
import Modelo.ModeloCentral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author CINETO
 */
public class Archivos extends javax.swing.JPanel {

    ControladorArchivosM archivosManual;
    ControladorArchivosA archivosAutomatico;
    public static Timer timer1;

    public Archivos() {
        initComponents();
        cargarCentralMarca();
    }

    public void cargarCentralMarca() {

        ModeloCentral modeloCentralCampo = new ModeloCentral();
        List<CentralMarca> lstMarca = modeloCentralCampo.buscarMarcaCentralesTelefonicas();
        for (int i = 0; i < lstMarca.size(); i++) {
            cbxCentralMarca.addItem(lstMarca.get(i).getNombreCentralMarca());
        }

    }

    public void cargarCentralModelo(String marca) {
        ModeloCentral modeloCentralCampo = new ModeloCentral();
        List<CentralModelo> lstModelo = modeloCentralCampo.buscarModelosCentralesTelefonicas(marca);
        for (int i = 0; i < lstModelo.size(); i++) {
            cbxCentralModelo.addItem(lstModelo.get(i).getNombreCentralModelo());
        }
    }

    public int tiempo() {
        int num = 0;
        String tiempo = cbxFrecuecia.getSelectedItem().toString();
        switch (tiempo) {
            case "30 Segundos":
                num = (30000);
                break;
            case "45 Segundos":
                num = (45000);
                break;
            case "01 Minuto":
                num = (60000);
                break;
            case "02 Minutos":
                num = (120000);
                break;
            case "03 Minutos":
                num = (180000);
                break;
            case "01 Hora":
                num = (3600000);
                break;
            default:
                break;
        }
        return num;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxCentralMarca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxCentralModelo = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jPanel14 = new javax.swing.JPanel();
        btnComenzar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        btnCargaManual = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnDetener = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblCargaManual = new javax.swing.JLabel();
        cbxFrecuecia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lblCargaAutomatica = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 244));
        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(243, 243, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Marca de la Central Telefónica:");

        cbxCentralMarca.setBackground(new java.awt.Color(255, 255, 255));
        cbxCentralMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCentralMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCentralMarcaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Modelo de la Central Telefónica:");

        cbxCentralModelo.setBackground(new java.awt.Color(255, 255, 255));
        cbxCentralModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxCentralMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(cbxCentralModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCentralModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCentralMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(243, 243, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel14.setBackground(new java.awt.Color(26, 179, 148));

        btnComenzar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnComenzar.setForeground(new java.awt.Color(255, 255, 255));
        btnComenzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Iniciar.png"))); // NOI18N
        btnComenzar.setText("Comenzar");
        btnComenzar.setBorderPainted(false);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComenzar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnComenzar.setIconTextGap(10);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnComenzar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnComenzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(26, 179, 148));

        btnCargaManual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCargaManual.setForeground(new java.awt.Color(255, 255, 255));
        btnCargaManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Abrir.png"))); // NOI18N
        btnCargaManual.setText("Seleccionar Archivo");
        btnCargaManual.setBorderPainted(false);
        btnCargaManual.setContentAreaFilled(false);
        btnCargaManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargaManual.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCargaManual.setIconTextGap(10);
        btnCargaManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaManualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCargaManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCargaManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gestión Automática de Carga de Archivos:");

        jPanel12.setBackground(new java.awt.Color(237, 85, 101));

        btnDetener.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDetener.setForeground(new java.awt.Color(255, 255, 255));
        btnDetener.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancelar.png"))); // NOI18N
        btnDetener.setText("Detener");
        btnDetener.setBorderPainted(false);
        btnDetener.setContentAreaFilled(false);
        btnDetener.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetener.setEnabled(false);
        btnDetener.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDetener.setIconTextGap(10);
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDetener, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDetener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Gestión Automática de Carga de Archivos:");

        lblCargaManual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCargaManual.setForeground(new java.awt.Color(237, 85, 101));

        cbxFrecuecia.setBackground(new java.awt.Color(255, 255, 255));
        cbxFrecuecia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrecuecia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30 Segundos", "45 Segundos", "01 Minuto", "02 Minutos", "03 Minutos", "01 Hora" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Frecuencia");

        lblCargaAutomatica.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCargaAutomatica.setForeground(new java.awt.Color(237, 85, 101));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCargaManual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCargaAutomatica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 40, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxFrecuecia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(130, 130, 130))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCargaManual, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCargaAutomatica, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrecuecia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCentralMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCentralMarcaActionPerformed
        cbxCentralModelo.removeAllItems();
        cargarCentralModelo(cbxCentralMarca.getSelectedItem().toString());
    }//GEN-LAST:event_cbxCentralMarcaActionPerformed

    private void btnCargaManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaManualActionPerformed
        archivosManual = new ControladorArchivosM(btnCargaManual, lblCargaManual, cbxCentralModelo, cbxCentralMarca, cbxCentralMarca.getSelectedItem().toString());
        archivosManual.execute();
    }//GEN-LAST:event_btnCargaManualActionPerformed

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed
        timer1.stop();
        btnComenzar.setEnabled(true);
        cbxFrecuecia.setEnabled(true);
        btnDetener.setEnabled(false);
        lblCargaAutomatica.setText("");
    }//GEN-LAST:event_btnDetenerActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed

        btnComenzar.setEnabled(false);
        cbxFrecuecia.setEnabled(false);
        btnDetener.setEnabled(true);
        lblCargaAutomatica.setText(".");
        timer1 = new Timer(tiempo(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                archivosAutomatico = new ControladorArchivosA(btnComenzar, lblCargaAutomatica, cbxCentralModelo, cbxCentralMarca, cbxCentralMarca.getSelectedItem().toString());
                archivosAutomatico.execute();
            }
        });
        timer1.start();
    }//GEN-LAST:event_btnComenzarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCargaManual;
    public static javax.swing.JButton btnComenzar;
    public static javax.swing.JButton btnDetener;
    private javax.swing.JComboBox<String> cbxCentralMarca;
    private javax.swing.JComboBox<String> cbxCentralModelo;
    private javax.swing.JComboBox<String> cbxFrecuecia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JLabel lblCargaAutomatica;
    private javax.swing.JLabel lblCargaManual;
    // End of variables declaration//GEN-END:variables
}
