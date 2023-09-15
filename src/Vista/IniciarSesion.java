/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Usuario;
import Modelo.ModeloUsuario;
import Modelo.ModeloValidacionInicio;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author CINETO
 */
public class IniciarSesion extends javax.swing.JFrame {

    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion() {
        initComponents();
        iconoBarra();
    }

    public void validarInicio() {

    }

    public String validarUsuario() {

        String valor;

        Usuario usuario = new Usuario();
        ModeloUsuario modeloUsuario = new ModeloUsuario();

        usuario.setNombreUsuario(txtNombreUsuario.getText().trim());
        usuario.setPassUsuario(md5(txtPassUsuario.getText().trim()));

        valor = modeloUsuario.validarUsuario(usuario);

        return valor;
    }

    public void restablecerUsuario() {
        Usuario usuario = new Usuario();
        ModeloUsuario modeloUsuario = new ModeloUsuario();

        usuario.setNombreUsuario(txtNombreUsuario.getText().trim());

        modeloUsuario.restablecerUsuario(usuario);
    }

    public static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /* Retorna un hash MD5 a partir de un texto */
    public static String md5(String txt) {
        return getHash(txt, "MD5");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPassUsuario = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loctel | Servidor");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(243, 243, 244));

        txtNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        jPanel5.setBackground(new java.awt.Color(26, 179, 148));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Iniciar Sesion.png"))); // NOI18N
        jButton2.setText("Iniciar Sesión");
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
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo.png"))); // NOI18N

        txtPassUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPassUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreUsuario)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassUsuario))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        switch (validarUsuario()) {
            case "1":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar\nno tiene permisos para gestionar este módulo", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                restablecerUsuario();
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar\nno tiene permisos para gestionar este módulo", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                restablecerUsuario();
                break;
            case "3":
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                dispose();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar está\nya en sesión o está bloqueado", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                break;
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new ModeloValidacionInicio().cerrarApp();
    }//GEN-LAST:event_formWindowClosing

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        switch (validarUsuario()) {
            case "1":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar\nno tiene permisos para gestionar este módulo", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                restablecerUsuario();
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar\nno tiene permisos para gestionar este módulo", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                restablecerUsuario();
                break;
            case "3":
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                dispose();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar está\nya en sesión o está bloqueado", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void txtPassUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassUsuarioActionPerformed
        switch (validarUsuario()) {
            case "1":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar\nno tiene permisos para gestionar este módulo", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                restablecerUsuario();
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar\nno tiene permisos para gestionar este módulo", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                restablecerUsuario();
                break;
            case "3":
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                dispose();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "El usuario con el que intenta ingresar está\nya en sesión o está bloqueado", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas", "Gestión Inicio Sesión", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_txtPassUsuarioActionPerformed

    public final void iconoBarra() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/Barra.png"));
        setIconImage(icon);
        setVisible(true);
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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new IniciarSesion().setVisible(true);
                if (new ModeloValidacionInicio().comprobar()) {
                    new IniciarSesion().setVisible(true);
                } else {
                    System.exit(0);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtPassUsuario;
    // End of variables declaration//GEN-END:variables
}
