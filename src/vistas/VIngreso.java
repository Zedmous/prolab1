
package vistas;


import generales.Mensajes;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VIngreso extends javax.swing.JFrame {
    private VEmpresa vmu;
    private VIngreso vi;
    private Mensajes msj= new Mensajes();
    public VIngreso(){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Inicio de Sesión");
        setIconImage(new ImageIcon(getClass().getResource("/img/usuarios.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon MyImgCustom =new ImageIcon(this.getClass().getResource("/img/descarga.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(MyImgCustom);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,MyImgCustom.getIconWidth(),MyImgCustom.getIconHeight());
        
    }
    public void agregarListener(ActionListener actionListener) {
        btningresar.addActionListener(actionListener);
        btncancelar.addActionListener(actionListener);
    }
    public void sinregistro(){
        txtlogin.setText("");
        txtclave.setText("");
    }
    public void ingresar(boolean enc){
        
        if(enc){
            msj.mingresarsistema("");
        }else{
            JOptionPane.showMessageDialog(this,"Login o Clave Incorrecta","INGRESANDO AL SISTEMA",JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btningresar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtlogin = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtclave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PANEL DE ACCESO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Ingrese sus Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        btningresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        jPanel2.add(btningresar);
        btningresar.setBounds(40, 160, 100, 30);

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setText("Cancelar");
        jPanel2.add(btncancelar);
        btncancelar.setBounds(210, 160, 100, 30);
        jPanel2.add(txtlogin);
        txtlogin.setBounds(190, 40, 150, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 140, 340, 10);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarios.png"))); // NOI18N
        jLabel1.setText("Identidad:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 40, 160, 30);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/llave.png"))); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 90, 166, 30);
        jPanel2.add(txtclave);
        txtclave.setBounds(190, 90, 150, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 20, 360, 210);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btningresarActionPerformed

/*
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIngreso().setVisible(true);
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btningresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtclave;
    private javax.swing.JTextField txtlogin;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txtclave
     */
    public javax.swing.JPasswordField getTxtclave() {
        return txtclave;
    }

    /**
     * @param txtclave the txtclave to set
     */
    public void setTxtclave(javax.swing.JPasswordField txtclave) {
        this.txtclave = txtclave;
    }

    /**
     * @return the txtlogin
     */
    public javax.swing.JTextField getTxtlogin() {
        return txtlogin;
    }

    /**
     * @param txtlogin the txtlogin to set
     */
    public void setTxtlogin(javax.swing.JTextField txtlogin) {
        this.txtlogin = txtlogin;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
}
