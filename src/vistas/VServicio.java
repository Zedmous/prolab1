
package vistas;

import controladores.CServicio;
import java.awt.event.ActionListener;

public class VServicio extends javax.swing.JDialog {
    private CServicio cserv;
    public VServicio(java.awt.Frame parent, boolean modal,CServicio cserv) {
        super(parent, modal);
        initComponents();
        sinregistro();
        this.cserv=cserv;
                
    }
    public void sinregistro(){
        getTxtbuscar().setEditable(true);
        getTxtcodigo().setEditable(false);
        getTxtnombre().setEditable(false);
        getTxtprecio().setEditable(false);
        btnconsultar.setEnabled(true);
        btnagregar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnsalir.setEnabled(true);
        getTxtbuscar().setText("");
        getTxtcodigo().setText("");
        getTxtnombre().setText("");
        getTxtprecio().setText("");
    }
    public void registroenc(){
        getTxtbuscar().setEditable(false);
        getTxtcodigo().setEditable(false);
        getTxtnombre().setEditable(true);
        getTxtprecio().setEditable(true);
        getTxtbuscar().setText("");
        btnconsultar.setEnabled(false);
        btnagregar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(false);
    }
    public void registronoenc(){
        getTxtbuscar().setEditable(false);
        getTxtcodigo().setEditable(false);
        getTxtnombre().setEditable(true);
        getTxtprecio().setEditable(true);
        getTxtbuscar().setText("");
        btnconsultar.setEnabled(false);
        btnagregar.setEnabled(true);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        
    }
   public void agregarListener(ActionListener accion) {
        btnconsultar.addActionListener(accion);
        btnagregar.addActionListener(accion);
        btnmodificar.addActionListener(accion);
        btneliminar.addActionListener(accion);
        btncancelar.addActionListener(accion);
        btnsalir.addActionListener(accion);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnconsultar = new javax.swing.JButton();
        btncatalogo = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnsalir = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jFechayHorarp2 = new jfechayhora.JFechayHorarp();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));
        jPanel5.setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Busqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel6.setLayout(null);

        jLabel3.setText("Codigo:");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(30, 30, 60, 30);
        jPanel6.add(txtbuscar);
        txtbuscar.setBounds(90, 30, 150, 30);

        btnconsultar.setText("Consultar");
        jPanel6.add(btnconsultar);
        btnconsultar.setBounds(260, 30, 90, 30);

        btncatalogo.setText("...");
        jPanel6.add(btncatalogo);
        btncatalogo.setBounds(360, 30, 40, 30);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(10, 10, 420, 80);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Operaciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel7.setLayout(null);

        btnsalir.setText("Salir");
        jPanel7.add(btnsalir);
        btnsalir.setBounds(20, 190, 120, 30);

        btnagregar.setText("Agregar");
        jPanel7.add(btnagregar);
        btnagregar.setBounds(20, 30, 120, 30);

        btnmodificar.setText("Modificar");
        jPanel7.add(btnmodificar);
        btnmodificar.setBounds(20, 70, 120, 30);

        btneliminar.setText("Eliminar");
        jPanel7.add(btneliminar);
        btneliminar.setBounds(20, 110, 120, 30);

        btncancelar.setText("Cancelar");
        jPanel7.add(btncancelar);
        btncancelar.setBounds(20, 150, 120, 30);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(450, 100, 160, 240);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel8.setLayout(null);

        jLabel4.setText("Nombre:");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(30, 100, 80, 30);
        jPanel8.add(txtnombre);
        txtnombre.setBounds(120, 100, 220, 30);

        jLabel5.setText("Codigo:");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(30, 50, 60, 30);
        jPanel8.add(txtcodigo);
        txtcodigo.setBounds(120, 50, 220, 30);

        jLabel7.setText("Precio");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(30, 150, 80, 30);
        jPanel8.add(txtprecio);
        txtprecio.setBounds(120, 150, 220, 30);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(10, 100, 420, 240);
        jPanel5.add(jFechayHorarp2);
        jFechayHorarp2.setBounds(450, 10, 160, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        cserv.salir();
    }//GEN-LAST:event_formWindowClosed
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
            java.util.logging.Logger.getLogger(VServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VServicio dialog = new VServicio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncatalogo;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnsalir;
    private jfechayhora.JFechayHorarp jFechayHorarp2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txtbuscar
     */
    public javax.swing.JTextField getTxtbuscar() {
        return txtbuscar;
    }

    /**
     * @param txtbuscar the txtbuscar to set
     */
    public void setTxtbuscar(javax.swing.JTextField txtbuscar) {
        this.txtbuscar = txtbuscar;
    }

    /**
     * @return the txtcodigo
     */
    public javax.swing.JTextField getTxtcodigo() {
        return txtcodigo;
    }

    /**
     * @param txtcodigo the txtcodigo to set
     */
    public void setTxtcodigo(javax.swing.JTextField txtcodigo) {
        this.txtcodigo = txtcodigo;
    }

    /**
     * @return the txtnombre
     */
    public javax.swing.JTextField getTxtnombre() {
        return txtnombre;
    }

    /**
     * @param txtnombre the txtnombre to set
     */
    public void setTxtnombre(javax.swing.JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    /**
     * @return the txtprecio
     */
    public javax.swing.JTextField getTxtprecio() {
        return txtprecio;
    }

    /**
     * @param txtprecio the txtprecio to set
     */
    public void setTxtprecio(javax.swing.JTextField txtprecio) {
        this.txtprecio = txtprecio;
    }
}
