/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.CentralCampo;
import Clases.CentralModelo;
import Modelo.ModeloCentral;
import com.opencsv.CSVReader;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CINETO
 */
public class CamposGuardarCentral extends javax.swing.JDialog {

    String direccion;
    char separador = 0;

    public CamposGuardarCentral(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buscarCentralTelefonica();
        gestionCampos();
    }
    public void gestionCampos() {
        if (Campos.lblNombreCentralMarca.getText().equals("EPIGY")) {
            lblMsm1.setText("CALL_TYPE:");
            lblMsm2.setText("CALL_START_TIME:");
            lblMsm3.setText("CALL_DURATION_SEC:");
            lblMsm4.setText("CALLING PHONE TYPE:");
            lblMsm5.setText("CALLING PHONE:");
            lblMsm6.setText("CALLED PHONE TYPE:");
            lblMsm7.setText("CALLED PHONE:");
        } else if (Campos.lblNombreCentralMarca.getText().equals("GRANDSTREAM") || Campos.lblNombreCentralMarca.getText().equals("ASTERISK")) {
            lblMsm1.setText("CALLER NUMBER:");
            lblMsm2.setText("CALLED NUMBER:");
            lblMsm3.setText("CALLER ID:");
            lblMsm4.setText("START TIME:");
            lblMsm5.setText("CALL TIME:");
            lblMsm6.setText("TALK TIME:");
            lblMsm7.setText("DISPOSITION:");
        }
    }

    public void buscarCentralTelefonica() {

        ModeloCentral modeloCentralCampo = new ModeloCentral();
        CentralModelo centralModelo = modeloCentralCampo.buscarCentralTelefonica(Campos.idModeloCentral);
        lblCentralMarca.setText(centralModelo.getCentralMarca().getNombreCentralMarca());
        lblCentralModelo.setText(centralModelo.getNombreCentralModelo());
        lblCentralSeparador.setText(centralModelo.getSeparadorCentralModelo());
        lblIdCentral.setText(centralModelo.getIdCentralModelo() + "");

    }

    public void abrirArchivo() {

        switch (lblCentralSeparador.getText()) {
            case ",":
                separador = ',';
                break;
            case ";":
                separador = ';';
                break;
            case "	":
                separador = '	';
                break;
            default:
                break;
        }
        seleccionarArchivoCsv(".csv, .txt, .log", new String[]{"CSV", "TXT", "LOG"});
        cargarCSV(direccion, separador, tbCentralCamposUno);
        igualarColumnas();
    }

    public void seleccionarArchivoCsv(String ext, String[] extN) {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtrocsv = new FileNameExtensionFilter(ext, extN);
        fc.setFileFilter(filtrocsv);
        int respuesta = fc.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoElegido = fc.getSelectedFile();
            direccion = archivoElegido.getPath();
        }
    }

    public void cargarCSV(String ruta, Character separador, JTable tabla) {
        char QUOTE = '"';
        CSVReader reader = null;
        try {

            reader = new CSVReader(new FileReader(ruta), separador, QUOTE);
            Object[] columnnames;
            List campos = reader.readAll();
            columnnames = (String[]) campos.get(0);
            DefaultTableModel tableModel = new DefaultTableModel(columnnames, campos.size() - 1);
            int rowcount = tableModel.getRowCount();
            for (int x = 0; x < rowcount + 1; x++) {
                int columnnumber = 0;
                if (x > 0) {
                    for (String thiscellvalue : (String[]) campos.get(x)) {

                        tableModel.setValueAt(thiscellvalue.replaceAll("[\"|<|>]", ""), x - 1, columnnumber);
                        columnnumber++;
                    }
                }
            }
            tabla.setModel(tableModel);

        } catch (IOException e) {
            Logger.getLogger(CamposGuardarCentral.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(CamposGuardarCentral.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void igualarColumnas() {

        for (int i = 0; i < tbCentralCamposUno.getColumnCount(); i++) {

            tbCentralCamposUno.getColumnModel().getColumn(i).setMinWidth(200);
            tbCentralCamposUno.getColumnModel().getColumn(i).setPreferredWidth(200);
            tbCentralCamposUno.getColumnModel().getColumn(i).setMaxWidth(200);

        }

    }

    public void guardarCampos() {
        ModeloCentral modeloCentralCampo = new ModeloCentral();
        CentralCampo centralCampo = new CentralCampo();
        centralCampo.setIdCampoModeloCentral(Integer.parseInt(lblIdCentral.getText()));
        centralCampo.setCampo1Central(Integer.parseInt(cbxCampo1.getSelectedItem().toString()));
        centralCampo.setCampo2Central(Integer.parseInt(cbxCampo2.getSelectedItem().toString()));
        centralCampo.setCampo3Central(Integer.parseInt(cbxCampo3.getSelectedItem().toString()));
        centralCampo.setCampo4Central(Integer.parseInt(cbxCampo4.getSelectedItem().toString()));
        centralCampo.setCampo5Central(Integer.parseInt(cbxCampo5.getSelectedItem().toString()));
        centralCampo.setCampo6Central(Integer.parseInt(cbxCampo6.getSelectedItem().toString()));
        centralCampo.setCampo7Central(Integer.parseInt(cbxCampo7.getSelectedItem().toString()));
        JOptionPane.showMessageDialog(null, modeloCentralCampo.guardarCentralCampo(centralCampo), "Gestión Campos de la Central Telefónica", JOptionPane.WARNING_MESSAGE);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMsm3 = new javax.swing.JLabel();
        lblMsm4 = new javax.swing.JLabel();
        lblMsm5 = new javax.swing.JLabel();
        lblMsm6 = new javax.swing.JLabel();
        lblMsm7 = new javax.swing.JLabel();
        cbxCampo2 = new javax.swing.JComboBox<>();
        cbxCampo3 = new javax.swing.JComboBox<>();
        cbxCampo4 = new javax.swing.JComboBox<>();
        cbxCampo5 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCentralCamposUno = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxCampo1 = new javax.swing.JComboBox<>();
        lblMsm1 = new javax.swing.JLabel();
        cbxCampo6 = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        btnGuardarCentralCampo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnAbrirArchivo = new javax.swing.JButton();
        lblMsm2 = new javax.swing.JLabel();
        cbxCampo7 = new javax.swing.JComboBox<>();
        lblIdCentral = new javax.swing.JLabel();
        lblCentralMarca = new javax.swing.JLabel();
        lblCentralModelo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCentralSeparador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Campos a la Central Telefónica");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/Barra.png")));

        jPanel1.setBackground(new java.awt.Color(243, 243, 244));

        lblMsm3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMsm3.setText("CALL_DURATION_SEC:");

        lblMsm4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMsm4.setText("CALLING PHONE TYPE:");

        lblMsm5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMsm5.setText("CALLING PHONE:");

        lblMsm6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMsm6.setText("CALLED PHONE TYPE:");

        lblMsm7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMsm7.setText("CALLED PHONE:");

        cbxCampo2.setBackground(new java.awt.Color(255, 255, 255));
        cbxCampo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCampo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        cbxCampo3.setBackground(new java.awt.Color(255, 255, 255));
        cbxCampo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCampo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        cbxCampo4.setBackground(new java.awt.Color(255, 255, 255));
        cbxCampo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCampo4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        cbxCampo5.setBackground(new java.awt.Color(255, 255, 255));
        cbxCampo5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCampo5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        tbCentralCamposUno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbCentralCamposUno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCentralCamposUno.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbCentralCamposUno.setRowHeight(20);
        jScrollPane1.setViewportView(tbCentralCamposUno);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Modelo Central:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Marca Central:");

        cbxCampo1.setBackground(new java.awt.Color(255, 255, 255));
        cbxCampo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCampo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        lblMsm1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMsm1.setText("CALL_TYPE:");

        cbxCampo6.setBackground(new java.awt.Color(255, 255, 255));
        cbxCampo6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCampo6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        jPanel11.setBackground(new java.awt.Color(26, 179, 148));

        btnGuardarCentralCampo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarCentralCampo.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCentralCampo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Guardar.png"))); // NOI18N
        btnGuardarCentralCampo.setText("Guardar");
        btnGuardarCentralCampo.setBorderPainted(false);
        btnGuardarCentralCampo.setContentAreaFilled(false);
        btnGuardarCentralCampo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCentralCampo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardarCentralCampo.setIconTextGap(10);
        btnGuardarCentralCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCentralCampoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardarCentralCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardarCentralCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(26, 179, 148));

        btnAbrirArchivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAbrirArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Abrir.png"))); // NOI18N
        btnAbrirArchivo.setText("Probar");
        btnAbrirArchivo.setBorderPainted(false);
        btnAbrirArchivo.setContentAreaFilled(false);
        btnAbrirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAbrirArchivo.setIconTextGap(10);
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblMsm2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMsm2.setText("CALL_START_TIME:");

        cbxCampo7.setBackground(new java.awt.Color(255, 255, 255));
        cbxCampo7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxCampo7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        lblCentralMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCentralMarca.setText("Marca");

        lblCentralModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCentralModelo.setText("Modelo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Separador:");

        lblCentralSeparador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCentralSeparador.setText("Separador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblIdCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCentralModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblMsm7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMsm1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMsm2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMsm3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMsm4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMsm5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMsm6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCampo6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCampo7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCampo5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCentralMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCentralSeparador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCentralMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCentralModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblCentralSeparador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMsm1)
                            .addComponent(cbxCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMsm2)
                            .addComponent(cbxCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMsm3)
                            .addComponent(cbxCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMsm4)
                            .addComponent(cbxCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMsm5)
                            .addComponent(cbxCampo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMsm6)
                            .addComponent(cbxCampo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMsm7)
                            .addComponent(cbxCampo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        abrirArchivo();
        if (tbCentralCamposUno.getValueAt(0, 0).toString().matches(".*Call.*") || tbCentralCamposUno.getValueAt(0, 0).toString().matches(".*account.*") || tbCentralCamposUno.getValueAt(0, 0).toString().matches(".*calldate.*")) {
            DefaultTableModel dtm = (DefaultTableModel) tbCentralCamposUno.getModel();
            dtm.removeRow(0);
        }
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void btnGuardarCentralCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCentralCampoActionPerformed

        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro que desea relizar la asignación de campos", "Gestión Campos Central Telefónica", JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.OK_OPTION == resp) {
            guardarCampos();
        }
    }//GEN-LAST:event_btnGuardarCentralCampoActionPerformed

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
            java.util.logging.Logger.getLogger(CamposGuardarCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CamposGuardarCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CamposGuardarCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CamposGuardarCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CamposGuardarCentral dialog = new CamposGuardarCentral(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAbrirArchivo;
    public static javax.swing.JButton btnGuardarCentralCampo;
    private javax.swing.JComboBox<String> cbxCampo1;
    private javax.swing.JComboBox<String> cbxCampo2;
    private javax.swing.JComboBox<String> cbxCampo3;
    private javax.swing.JComboBox<String> cbxCampo4;
    private javax.swing.JComboBox<String> cbxCampo5;
    private javax.swing.JComboBox<String> cbxCampo6;
    private javax.swing.JComboBox<String> cbxCampo7;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCentralMarca;
    private javax.swing.JLabel lblCentralModelo;
    private javax.swing.JLabel lblCentralSeparador;
    private javax.swing.JLabel lblIdCentral;
    private javax.swing.JLabel lblMsm1;
    private javax.swing.JLabel lblMsm2;
    private javax.swing.JLabel lblMsm3;
    private javax.swing.JLabel lblMsm4;
    private javax.swing.JLabel lblMsm5;
    private javax.swing.JLabel lblMsm6;
    private javax.swing.JLabel lblMsm7;
    private javax.swing.JTable tbCentralCamposUno;
    // End of variables declaration//GEN-END:variables
}
