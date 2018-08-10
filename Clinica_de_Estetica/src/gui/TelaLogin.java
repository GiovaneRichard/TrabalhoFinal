package gui;

import entity.Usuario;
import dao.UsuarioDao;
import javax.swing.JOptionPane;

/**
 *
 * @author giovane richard
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
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

        btnAcessar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtLogin = new javax.swing.JTextField();
        lblNomeLogo = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btnAcessar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAcessar.setText("Entrar");
        btnAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarActionPerformed(evt);
            }
        });
        btnAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAcessarKeyPressed(evt);
            }
        });
        getContentPane().add(btnAcessar);
        btnAcessar.setBounds(140, 190, 130, 40);

        jLabel1.setText("Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 110, 40, 14);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 150, 50, 14);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(100, 140, 230, 30);
        getContentPane().add(txtLogin);
        txtLogin.setBounds(100, 100, 230, 30);

        lblNomeLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo2.png"))); // NOI18N
        getContentPane().add(lblNomeLogo);
        lblNomeLogo.setBounds(10, 0, 370, 90);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/background.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 400, 260);

        setSize(new java.awt.Dimension(404, 289));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarActionPerformed

        Usuario usuario = new Usuario();
//        
//        user.setUsuario(txtLogin.getText());
//        
//        try {
//            user.setSenha(txtSenha.getText());
//        } catch (Exception e) {
//            txtSenha.requestFocus();  // recebe o fócu
//            txtSenha.selectAll();    // seleciona o texto do JTextField
//        }

        // Autenticando usuários
        UsuarioDao usuarioD = new UsuarioDao();

        try {
            String password = new String(txtSenha.getPassword());
            usuario.setUsuario(txtLogin.getText());
            usuario.setSenha(password);

            if (usuarioD.autenticar(usuario)) {
                // habilita campos para o acesso do administrador

                //TelaPrincipal tela = new TelaPrincipal();
                Principal tela = new Principal();
                tela.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto\nTente novamente ", "Erro 01", JOptionPane.ERROR_MESSAGE);
                // Limpar os campos
                txtLogin.setText("");
                txtSenha.setText("");

                txtLogin.requestFocus();
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnAcessarActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        Usuario usuario = new Usuario();

        // Autenticando usuários
        UsuarioDao usuarioD = new UsuarioDao();

        try {
            String password = new String(txtSenha.getPassword());
            usuario.setUsuario(txtLogin.getText());
            usuario.setSenha(password);

            if (usuarioD.autenticar(usuario)) {
                // habilita campos para o acesso do administrador

                //TelaPrincipal tela = new TelaPrincipal();
                Principal tela = new Principal();
                tela.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto\nTente novamente ", "Erro 01", JOptionPane.ERROR_MESSAGE);
                // Limpar os campos
                txtLogin.setText("");
                txtSenha.setText("");

                txtLogin.requestFocus();
            }

        } catch (Exception e) {
            System.out.println("Erro ao autenticar o usuário!" + e);
                    
        }

    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnAcessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAcessarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcessarKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblNomeLogo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
