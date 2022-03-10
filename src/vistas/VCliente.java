
package vistas;

import controladores.CCliente;
import java.awt.event.ActionListener;

public class VCliente extends javax.swing.JDialog {
    private CCliente cli;
    public VCliente(java.awt.Frame parent, boolean modal,CCliente cli) {
        super(parent, modal);
        initComponents();
        sinregistro();
        this.cli=cli;
    }
    
    public void sinregistro(){
        getTxtbuscar().setEditable(true);
        txtrif.setEditable(false);
        getTxtnombre().setEditable(false);
        getTxtdireccion().setEditable(false);
        getTxttelefono().setEditable(false);
        getCbtntipoc().setEnabled(false);
        btnconsultar.setEnabled(true);
        btnagregar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        getTxtbuscar().setText("");
        txtrif.setText("");
        getTxtnombre().setText("");
        getTxtdireccion().setText("");
        getTxttelefono().setText("");
        getCbtntipoc().setSelectedIndex(0);
    }
    public void registroenc(){
        getTxtbuscar().setEditable(false);
        txtrif.setEditable(false);
        getTxtnombre().setEditable(true);
        getTxtdireccion().setEditable(true);
        getTxttelefono().setEditable(true);
        getCbtntipoc().setEnabled(true);
        btnconsultar.setEnabled(false);
        btnagregar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
        getTxtbuscar().setText("");
    }
    public void registronoenc(){
        getTxtbuscar().setEditable(false);
        txtrif.setEditable(false);
        getTxtnombre().setEditable(true);
        getTxtdireccion().setEditable(true);
        getTxttelefono().setEditable(true);
        cbtntipoc.setEnabled(true);
        btnconsultar.setEnabled(false);
        btnagregar.setEnabled(true);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        getTxtbuscar().setText("");
        
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
        txtrif = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        cbtntipoc = new javax.swing.JComboBox<>();
        jFechayHorarg2 = new jfechayhora.JFechayHorarg();

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

        jLabel3.setText("RIF:");
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
        btnsalir.setBounds(540, 30, 120, 30);

        btnagregar.setText("Agregar");
        jPanel7.add(btnagregar);
        btnagregar.setBounds(20, 30, 120, 30);

        btnmodificar.setText("Modificar");
        jPanel7.add(btnmodificar);
        btnmodificar.setBounds(150, 30, 120, 30);

        btneliminar.setText("Eliminar");
        jPanel7.add(btneliminar);
        btneliminar.setBounds(280, 30, 120, 30);

        btncancelar.setText("Cancelar");
        jPanel7.add(btncancelar);
        btncancelar.setBounds(410, 30, 120, 30);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(10, 360, 680, 80);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel8.setLayout(null);

        jLabel4.setText("Nombre:");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(230, 30, 80, 30);
        jPanel8.add(txtnombre);
        txtnombre.setBounds(340, 30, 320, 30);

        jLabel5.setText("RIF:");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(30, 30, 60, 30);
        jPanel8.add(txtrif);
        txtrif.setBounds(80, 30, 130, 30);

        jLabel7.setText("Telefono:");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(350, 80, 80, 30);
        jPanel8.add(txttelefono);
        txttelefono.setBounds(440, 80, 220, 30);

        jLabel8.setText("Tipo de Cliente:");
        jPanel8.add(jLabel8);
        jLabel8.setBounds(30, 80, 90, 30);

        txtdireccion.setColumns(20);
        txtdireccion.setRows(5);
        jScrollPane1.setViewportView(txtdireccion);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(120, 140, 540, 80);

        jLabel11.setText("Direccion:");
        jPanel8.add(jLabel11);
        jLabel11.setBounds(30, 140, 60, 30);

        cbtntipoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Consejo Comunal", "Asociación de vecinos", "Representante de la urbanización", "Edificio Residencial", "Tienda Comercial" }));
        jPanel8.add(cbtntipoc);
        cbtntipoc.setBounds(130, 80, 190, 30);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(10, 100, 680, 250);
        jPanel5.add(jFechayHorarg2);
        jFechayHorarg2.setBounds(450, 10, 240, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        cli.salir();
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
            java.util.logging.Logger.getLogger(VCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VCliente dialog = new VCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbtntipoc;
    private jfechayhora.JFechayHorarg jFechayHorarg2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextArea txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtrif;
    private javax.swing.JTextField txttelefono;
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
     * @return the txtdireccion
     */
    public javax.swing.JTextArea getTxtdireccion() {
        return txtdireccion;
    }

    /**
     * @param txtdireccion the txtdireccion to set
     */
    public void setTxtdireccion(javax.swing.JTextArea txtdireccion) {
        this.txtdireccion = txtdireccion;
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
     * @return the txtrif
     */
    public javax.swing.JTextField getTxtrif() {
        return txtrif;
    }

    /**
     * @param txtrif the txtrif to set
     */
    public void setTxtrif(javax.swing.JTextField txtrif) {
        this.txtrif = txtrif;
    }

    /**
     * @return the txttelefono
     */
    public javax.swing.JTextField getTxttelefono() {
        return txttelefono;
    }

    /**
     * @param txttelefono the txttelefono to set
     */
    public void setTxttelefono(javax.swing.JTextField txttelefono) {
        this.txttelefono = txttelefono;
    }

    /**
     * @return the cbtntipoc
     */
    public javax.swing.JComboBox<String> getCbtntipoc() {
        return cbtntipoc;
    }

    /**
     * @param cbtntipoc the cbtntipoc to set
     */
    public void setCbtntipoc(javax.swing.JComboBox<String> cbtntipoc) {
        this.cbtntipoc = cbtntipoc;
    }
}
