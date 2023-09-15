/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.CentralCampo;
import Clases.CentralMarca;
import Clases.CentralModelo;
import Modelo.ModeloLog;
import Modelo.ModeloCentral;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CINETO
 */
public class Campos extends javax.swing.JPanel {

    public static int idModeloCentral = 0;

    public Campos() {
        initComponents();
        listarCentralesTelefonicas();
    }

    public void listarCentralesTelefonicas() {

        ModeloCentral dao = new ModeloCentral();
        List<CentralModelo> lstModelo;

        DefaultTableModel modelo = (DefaultTableModel) tbCentralCampos.getModel();

        Object[] fila = new Object[20];

        try {
            lstModelo = dao.buscarCentralesTelefonicas();

            for (int i = 0; i < lstModelo.size(); i++) {

                fila[0] = lstModelo.get(i).getCentralMarca().getNombreCentralMarca();
                fila[1] = lstModelo.get(i).getIdCentralModelo();
                fila[2] = lstModelo.get(i).getNombreCentralModelo();
                fila[3] = lstModelo.get(i).getSeparadorCentralModelo();

                modelo.addRow(fila);

            }
            tbCentralCampos.setModel(modelo);
        } catch (Exception e) {
            Logger.getLogger(Campos.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void eliminarAsignacionCampos() {
        ModeloCentral modeloCentralCampo = new ModeloCentral();
        CentralCampo centralCampo = new CentralCampo();

        centralCampo.setIdCampoModeloCentral(idModeloCentral);
        JOptionPane.showMessageDialog(null, modeloCentralCampo.eliminarCentralCampo(centralCampo), "Gestión Campos Central Telefónica", JOptionPane.INFORMATION_MESSAGE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCentralCampos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(243, 243, 244));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBackground(new java.awt.Color(47, 64, 80));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Campos.png"))); // NOI18N
        jButton1.setText("Asignar Campos");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setIconTextGap(10);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        tbCentralCampos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbCentralCampos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marca", "Código Modelo", "Modelo", "Separador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCentralCampos.setRowHeight(21);
        tbCentralCampos.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tbCentralCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCentralCamposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCentralCampos);
        if (tbCentralCampos.getColumnModel().getColumnCount() > 0) {
            tbCentralCampos.getColumnModel().getColumn(0).setResizable(false);
            tbCentralCampos.getColumnModel().getColumn(1).setMinWidth(0);
            tbCentralCampos.getColumnModel().getColumn(1).setPreferredWidth(0);
            tbCentralCampos.getColumnModel().getColumn(1).setMaxWidth(0);
            tbCentralCampos.getColumnModel().getColumn(2).setResizable(false);
            tbCentralCampos.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Seleccionar Central Telefónica");

        lblNombreCentralMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(26, 179, 148));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancelar.png"))); // NOI18N
        jButton2.setText("Eliminar Campos");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setIconTextGap(10);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombreCentralMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreCentralMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbCentralCamposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCentralCamposMouseClicked
        int row = tbCentralCampos.rowAtPoint(evt.getPoint());
        idModeloCentral = Integer.parseInt(tbCentralCampos.getValueAt(row, 1).toString());
        lblNombreCentralMarca.setText(tbCentralCampos.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tbCentralCamposMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (idModeloCentral == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar una central telefónica para\nla asignación de los campos", "Gestión Campos Central Telefónica", JOptionPane.WARNING_MESSAGE);
        } else {
            CamposGuardarCentral campos1 = new CamposGuardarCentral(null, true);
            campos1.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (idModeloCentral == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar una central telefónica para\neliminar la asignación de los campos", "Gestión Campos Central Telefónica", JOptionPane.WARNING_MESSAGE);
        } else {
            eliminarAsignacionCampos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JLabel lblNombreCentralMarca = new javax.swing.JLabel();
    private javax.swing.JTable tbCentralCampos;
    // End of variables declaration//GEN-END:variables
}
