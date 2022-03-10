
package vistas;

import controladores.CEmpleado;

import java.awt.event.ActionListener;

public class VEmpleado extends javax.swing.JDialog {
    private VEmpresa vm;
    private CEmpleado ce;
    //private boolean cerrado=false;
    public VEmpleado(java.awt.Frame parent, boolean modal,CEmpleado ce) {
        super(parent, modal);
        initComponents();
        sinregistro();
        this.ce=ce;
        
    }
    
    public void sinregistro(){
        getTxtbuscar().setEditable(true);
        getTxtcedula().setEditable(false);
        getTxtnombre().setEditable(false);
        getTxtapellido().setEditable(false);
        getTxtdireccion().setEditable(false);
        getTxttelefono().setEditable(false);
        getTxtfechaing().setEditable(false);
        getTxtfechaegr().setEditable(false);
        getCbtndiaslibres().setEnabled(false);
        getCbtncargo().setEnabled(false);
        getTxtsueldom().setEditable(false);
        btnconsultar.setEnabled(true);
        btnagregar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        getTxtbuscar().setText("");
        getTxtcedula().setText("");
        getTxtnombre().setText("");
        getTxtapellido().setText("");
        getTxtdireccion().setText("");
        getTxttelefono().setText("");
        getTxtfechaing().setText("");
        getTxtfechaegr().setText("");
        getCbtndiaslibres().setSelectedIndex(0);
        txtsueldom.setText("");
        cbtncargos.setSelectedIndex(0);
    }
    public void registroenc(){
        getTxtbuscar().setEditable(false);
        getTxtcedula().setEditable(false);
        getTxtnombre().setEditable(true);
        getTxtapellido().setEditable(true);
        getTxtdireccion().setEditable(true);
        getTxttelefono().setEditable(true);
        getTxtfechaing().setEditable(true);
        getTxtfechaegr().setEditable(true);
        getCbtndiaslibres().setEnabled(true);
        getCbtncargo().setEnabled(true);
        getTxtsueldom().setEditable(false);
        btnconsultar.setEnabled(false);
        btnagregar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
        getTxtbuscar().setText("");
    }
    public void registronoenc(){
        getTxtbuscar().setEditable(false);
        getTxtcedula().setEditable(false);
        getTxtnombre().setEditable(true);
        getTxtapellido().setEditable(true);
        getTxtdireccion().setEditable(true);
        getTxttelefono().setEditable(true);
        getTxtfechaing().setEditable(true);
        getTxtfechaegr().setEditable(true);
        getCbtndiaslibres().setEnabled(true);
        getCbtncargo().setEnabled(true);
        getTxtsueldom().setEditable(false);
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
        //this.addWindowListener(a);
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
        txtcedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtfechaing = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtfechaegr = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbtndiaslibres = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbtncargos = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtsueldom = new javax.swing.JTextField();
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

        jLabel3.setText("Cedula:");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(30, 30, 60, 30);

        txtbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        jPanel7.setBounds(10, 440, 680, 80);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel8.setLayout(null);

        jLabel4.setText("Nombre:");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(360, 30, 80, 30);
        jPanel8.add(txtnombre);
        txtnombre.setBounds(460, 30, 200, 30);

        jLabel5.setText("Cedula:");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(20, 30, 70, 30);
        jPanel8.add(txtcedula);
        txtcedula.setBounds(120, 30, 230, 30);

        jLabel6.setText("Apellido:");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(20, 80, 70, 30);
        jPanel8.add(txtapellido);
        txtapellido.setBounds(120, 80, 230, 30);

        jLabel7.setText("Telefono:");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(360, 80, 80, 30);
        jPanel8.add(txttelefono);
        txttelefono.setBounds(460, 80, 200, 30);

        jLabel8.setText("Dia Libre:");
        jPanel8.add(jLabel8);
        jLabel8.setBounds(20, 180, 70, 30);

        txtdireccion.setColumns(20);
        txtdireccion.setRows(5);
        jScrollPane1.setViewportView(txtdireccion);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(120, 230, 230, 80);

        jLabel9.setText("Fecha Ingreso:");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(20, 130, 90, 30);
        jPanel8.add(txtfechaing);
        txtfechaing.setBounds(120, 130, 230, 30);

        jLabel10.setText("Fecha Egreso:");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(360, 130, 100, 30);
        jPanel8.add(txtfechaegr);
        txtfechaegr.setBounds(460, 130, 200, 30);

        jLabel11.setText("Direccion:");
        jPanel8.add(jLabel11);
        jLabel11.setBounds(20, 230, 70, 30);

        cbtndiaslibres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Lunes y Martes", "Miercoles y Jueves", "Viernes y Sabado", "Domingo y Lunes", "Martes y Miercoles", "Jueves y Vienes", "Sabado y Domingo" }));
        jPanel8.add(cbtndiaslibres);
        cbtndiaslibres.setBounds(120, 180, 230, 30);

        jLabel14.setText("Cargo:");
        jPanel8.add(jLabel14);
        jLabel14.setBounds(360, 180, 80, 30);

        cbtncargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbtncargos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbtncargosItemStateChanged(evt);
            }
        });
        jPanel8.add(cbtncargos);
        cbtncargos.setBounds(460, 180, 200, 30);

        jLabel15.setText("Sueldo Mensual");
        jPanel8.add(jLabel15);
        jLabel15.setBounds(360, 230, 100, 30);
        jPanel8.add(txtsueldom);
        txtsueldom.setBounds(460, 230, 200, 30);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(10, 100, 680, 330);
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
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ce.salir();
    }//GEN-LAST:event_formWindowClosed

    private void cbtncargosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtncargosItemStateChanged
        // TODO add your handling code here:
        ce.imprimirsueldo();
    }//GEN-LAST:event_cbtncargosItemStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncatalogo;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbtncargos;
    private javax.swing.JComboBox<String> cbtndiaslibres;
    private jfechayhora.JFechayHorarg jFechayHorarg2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextArea txtdireccion;
    private javax.swing.JTextField txtfechaegr;
    private javax.swing.JTextField txtfechaing;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsueldom;
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
     * @return the txtapellido
     */
    public javax.swing.JTextField getTxtapellido() {
        return txtapellido;
    }

    /**
     * @param txtapellido the txtapellido to set
     */
    public void setTxtapellido(javax.swing.JTextField txtapellido) {
        this.txtapellido = txtapellido;
    }

    /**
     * @return the txtcedula
     */
    public javax.swing.JTextField getTxtcedula() {
        return txtcedula;
    }

    /**
     * @param txtcedula the txtcedula to set
     */
    public void setTxtcedula(javax.swing.JTextField txtcedula) {
        this.txtcedula = txtcedula;
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
     * @return the txtfechaegr
     */
    public javax.swing.JTextField getTxtfechaegr() {
        return txtfechaegr;
    }

    /**
     * @param txtfechaegr the txtfechaegr to set
     */
    public void setTxtfechaegr(javax.swing.JTextField txtfechaegr) {
        this.txtfechaegr = txtfechaegr;
    }

    /**
     * @return the txtfechaing
     */
    public javax.swing.JTextField getTxtfechaing() {
        return txtfechaing;
    }

    /**
     * @param txtfechaing the txtfechaing to set
     */
    public void setTxtfechaing(javax.swing.JTextField txtfechaing) {
        this.txtfechaing = txtfechaing;
    }

    
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
     * @return the txtsueldom
     */
    public javax.swing.JTextField getTxtsueldom() {
        return txtsueldom;
    }

    /**
     * @param txtsueldom the txtsueldom to set
     */
    public void setTxtsueldom(javax.swing.JTextField txtsueldom) {
        this.txtsueldom = txtsueldom;
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
     * @return the cbtndiaslibres
     */
    public javax.swing.JComboBox<String> getCbtndiaslibres() {
        return cbtndiaslibres;
    }

    /**
     * @param cbtndiaslibres the cbtndiaslibres to set
     */
    public void setCbtndiaslibres(javax.swing.JComboBox<String> cbtndiaslibres) {
        this.cbtndiaslibres = cbtndiaslibres;
    }

    /**
     * @return the cbtncargo
     */
    public javax.swing.JComboBox<String> getCbtncargo() {
        return cbtncargos;
    }

    /**
     * @param cbtncargo the cbtncargo to set
     */
    public void setCbtncargo(javax.swing.JComboBox<String> cbtncargo) {
        this.cbtncargos = cbtncargo;
    }
}
