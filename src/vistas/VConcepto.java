
package vistas;

import controladores.CConcepto;
import generales.Mensajes;
import java.awt.event.ActionListener;

public class VConcepto extends javax.swing.JDialog {
    private CConcepto ccon;
    private Mensajes msj;
    public VConcepto(java.awt.Frame parent, boolean modal,CConcepto ccon) {
        super(parent, modal);
        initComponents();
        sinregistro();
        this.ccon=ccon;
    }
    public void sinregistro(){
        getTxtbuscar().setEditable(true);
        txtcodigo.setEditable(false);
        getTxtnombre().setEditable(false);
        txtvalor.setEditable(false);
        getCbtntipoc().setEnabled(false);
        btnconsultar.setEnabled(true);
        btnagregar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        getTxtbuscar().setText("");
        txtcodigo.setText("");
        getTxtnombre().setText("");
        txtvalor.setText("");
        getCbtntipoc().setSelectedIndex(0);
    }
    public void registroenc(){
        getTxtbuscar().setEditable(false);
        txtcodigo.setEditable(false);
        getTxtnombre().setEditable(true);
        txtvalor.setEditable(true);
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
        txtcodigo.setEditable(false);
        getTxtnombre().setEditable(true);
        txtvalor.setEditable(true);
        getCbtntipoc().setEnabled(true);
        btnconsultar.setEnabled(false);
        btnagregar.setEnabled(true);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        txtbuscar.setText("");
        
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
        txtvalor = new javax.swing.JTextField();
        cbtntipoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
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

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });
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
        jLabel4.setBounds(30, 80, 80, 30);
        jPanel8.add(txtnombre);
        txtnombre.setBounds(120, 80, 220, 30);

        jLabel5.setText("Codigo:");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(30, 30, 60, 30);
        jPanel8.add(txtcodigo);
        txtcodigo.setBounds(120, 30, 220, 30);

        jLabel7.setText("Valor");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(30, 170, 80, 30);
        jPanel8.add(txtvalor);
        txtvalor.setBounds(120, 170, 220, 30);

        cbtntipoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Asignacion", "Deduccion" }));
        jPanel8.add(cbtntipoc);
        cbtntipoc.setBounds(120, 130, 220, 30);

        jLabel8.setText("Tipo de Concepto:");
        jPanel8.add(jLabel8);
        jLabel8.setBounds(20, 130, 90, 30);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(10, 100, 420, 240);
        jPanel5.add(jFechayHorarp2);
        jFechayHorarp2.setBounds(450, 10, 160, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==java.awt.event.KeyEvent.VK_ENTER){
            if(txtbuscar.getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un codigo para buscar","Codigo Vacio",txtcodigo);
            }else{
                ccon.buscar();
            }
        }
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ccon.salir();
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
            java.util.logging.Logger.getLogger(VConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VConceptos dialog = new VConceptos(new javax.swing.JFrame(), true);
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
    private jfechayhora.JFechayHorarp jFechayHorarp2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtvalor;
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
     * @return the txtvalor
     */
    public javax.swing.JTextField getTxtvalor() {
        return txtvalor;
    }

    /**
     * @param txtvalor the txtvalor to set
     */
    public void setTxtvalor(javax.swing.JTextField txtvalor) {
        this.txtvalor = txtvalor;
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
