
package vistas;

import controladores.CAsignacionec;
import java.awt.event.ActionListener;

public class VAsignacionec extends javax.swing.JDialog {

    private CAsignacionec caec;
    public VAsignacionec(java.awt.Frame parent, boolean modal,CAsignacionec caec) {
        super(parent, modal);
        initComponents();
        this.caec=caec;
    }
    
    public void agregarListener(ActionListener accion){
        btngenerar.addActionListener(accion);
        btnseleccionar.addActionListener(accion);
        btnremover.addActionListener(accion);
        btnconsultare.addActionListener(accion);
        btnconsultarc.addActionListener(accion);
        btnlistae.addActionListener(accion);
        btnlistac.addActionListener(accion);
        btnasistido.addActionListener(accion);
        btnnoasistido.addActionListener(accion);
        btnjustificado.addActionListener(accion);
        btnasistenciatotal.addActionListener(accion);
        btncancelar.addActionListener(accion);
        btnsalir.addActionListener(accion);
    }
    
    public void sinregistro(){
        btngenerar.setEnabled(true);
        btnseleccionar.setEnabled(true);
        btnremover.setEnabled(false);
        btnconsultare.setEnabled(false);
        btnconsultarc.setEnabled(false);
        btnlistae.setEnabled(false);
        btnlistac.setEnabled(false);
        btnasistido.setEnabled(false);
        btnnoasistido.setEnabled(false);
        btnjustificado.setEnabled(false);
        btnasistenciatotal.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(true);
        txtfechad.setEditable(true);
        txtfechah.setEditable(true);
        txtfechav.setEditable(true);
        txtbuscarced.setEditable(false);
        txtnumeroc.setEditable(false);
        txtcedula.setEditable(false);
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txtobservacion.setEditable(false);
        txtbuscarcont.setEditable(false);
        
        txtfechad.setText("");
        txtfechah.setText("");
        txtfechav.setText("");
        txtbuscarced.setText("");
        txtnumeroc.setText("");
        txtcedula.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtobservacion.setText("");
        txtbuscarcont.setText("");
        
    }
    public void habilitarBE(){
        btngenerar.setEnabled(false);
        btnseleccionar.setEnabled(false);
        btnremover.setEnabled(true);
        btnconsultare.setEnabled(true);
        btnconsultarc.setEnabled(false);
        btnlistae.setEnabled(false);
        btnlistac.setEnabled(false);
        btnasistido.setEnabled(false);
        btnnoasistido.setEnabled(false);
        btnjustificado.setEnabled(false);
        btnasistenciatotal.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(true);
        
        txtfechad.setEditable(false);
        txtfechah.setEditable(false);
        txtfechav.setEditable(false);
        txtbuscarced.setEditable(true);
        txtnumeroc.setEditable(false);
        txtcedula.setEditable(false);
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txtobservacion.setEditable(false);
        txtbuscarcont.setEditable(false);
        txtbuscarcont.setText("");
    }
    
    public void habilitarBC(){
        btngenerar.setEnabled(false);
        btnseleccionar.setEnabled(false);
        btnremover.setEnabled(true);
        btnconsultare.setEnabled(false);
        btnconsultarc.setEnabled(true);
        btnlistae.setEnabled(false);
        btnlistac.setEnabled(false);
        btnasistido.setEnabled(false);
        btnnoasistido.setEnabled(false);
        btnjustificado.setEnabled(false);
        btnasistenciatotal.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(true);
        txtbuscarced.setText("");
    }
    public void bloquearAsignado(){
        btngenerar.setEnabled(false);
        btnseleccionar.setEnabled(false);
        btnremover.setEnabled(true);
        btnconsultare.setEnabled(false);
        btnconsultarc.setEnabled(false);
        btnlistae.setEnabled(false);
        btnlistac.setEnabled(false);
        btnasistido.setEnabled(true);
        btnnoasistido.setEnabled(true);
        btnjustificado.setEnabled(true);
        btnasistenciatotal.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btngenerar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtfechad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtfechah = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtnumeroc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtobservacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnsalir = new javax.swing.JButton();
        btnasistido = new javax.swing.JButton();
        btnnoasistido = new javax.swing.JButton();
        btnasistenciatotal = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnjustificado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbuscarced = new javax.swing.JTextField();
        btnconsultare = new javax.swing.JButton();
        btnlistae = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtbuscarcont = new javax.swing.JTextField();
        btnconsultarc = new javax.swing.JButton();
        btnlistac = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtfechav = new javax.swing.JTextField();
        btnremover = new javax.swing.JButton();
        btnseleccionar = new javax.swing.JButton();
        rdcontrato = new javax.swing.JRadioButton();
        rdempleado = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jFechayHorarg2 = new jfechayhora.JFechayHorarg();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));
        jPanel5.setLayout(null);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Generar Turnos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel7.setLayout(null);

        btngenerar.setText("Generar");
        jPanel7.add(btngenerar);
        btngenerar.setBounds(450, 30, 130, 30);

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Fecha Desde:");
        jPanel7.add(jLabel14);
        jLabel14.setBounds(10, 30, 90, 30);

        txtfechad.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel7.add(txtfechad);
        txtfechad.setBounds(100, 30, 120, 30);

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Fecha Hasta:");
        jPanel7.add(jLabel15);
        jLabel15.setBounds(220, 30, 100, 30);

        txtfechah.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel7.add(txtfechah);
        txtfechah.setBounds(320, 30, 110, 30);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(10, 10, 600, 80);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel8.setLayout(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel8.add(jSeparator1);
        jSeparator1.setBounds(420, 20, 10, 190);

        txtnumeroc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(txtnumeroc);
        txtnumeroc.setBounds(110, 70, 120, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("N° Contrato:");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(20, 70, 90, 30);

        txtcedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(txtcedula);
        txtcedula.setBounds(290, 70, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cedula:");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(230, 70, 60, 30);

        txtnombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(txtnombre);
        txtnombre.setBounds(110, 120, 120, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nombre:");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(20, 120, 90, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Apellido:");
        jPanel8.add(jLabel8);
        jLabel8.setBounds(230, 120, 60, 30);

        txtapellido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(txtapellido);
        txtapellido.setBounds(290, 120, 120, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Observacion:");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(20, 170, 90, 30);

        txtobservacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel8.add(txtobservacion);
        txtobservacion.setBounds(110, 170, 300, 30);

        tbdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbdetalle);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(430, 70, 400, 130);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Datos de Informacion Sobre el dia de Trabajo del Empleado");
        jPanel8.add(jLabel1);
        jLabel1.setBounds(20, 30, 390, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Datos de Informacion Sobre los Empleados Asignados al Contrato");
        jPanel8.add(jLabel2);
        jLabel2.setBounds(430, 30, 400, 30);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(10, 260, 850, 220);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Operaciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel11.setLayout(null);

        btnsalir.setText("Salir");
        jPanel11.add(btnsalir);
        btnsalir.setBounds(680, 30, 150, 30);

        btnasistido.setText("Asistido");
        jPanel11.add(btnasistido);
        btnasistido.setBounds(20, 30, 120, 30);

        btnnoasistido.setText("No Asistido");
        jPanel11.add(btnnoasistido);
        btnnoasistido.setBounds(150, 30, 120, 30);

        btnasistenciatotal.setText("Asistencia Total");
        jPanel11.add(btnasistenciatotal);
        btnasistenciatotal.setBounds(410, 30, 120, 30);

        btncancelar.setText("Cancelar");
        jPanel11.add(btncancelar);
        btncancelar.setBounds(540, 30, 130, 30);

        btnjustificado.setText("Justificado");
        jPanel11.add(btnjustificado);
        btnjustificado.setBounds(280, 30, 120, 30);

        jPanel5.add(jPanel11);
        jPanel11.setBounds(10, 490, 850, 80);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Verificacion de Asistencia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Busqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel6.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cedula:");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(20, 30, 60, 30);

        txtbuscarced.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel6.add(txtbuscarced);
        txtbuscarced.setBounds(80, 30, 110, 30);

        btnconsultare.setText("Consultar E.");
        jPanel6.add(btnconsultare);
        btnconsultare.setBounds(210, 30, 110, 30);

        btnlistae.setText("...");
        jPanel6.add(btnlistae);
        btnlistae.setBounds(330, 30, 40, 30);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 60, 400, 80);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Busqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel9.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("N° Contrato:");
        jPanel9.add(jLabel4);
        jLabel4.setBounds(20, 30, 90, 30);

        txtbuscarcont.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel9.add(txtbuscarcont);
        txtbuscarcont.setBounds(100, 30, 90, 30);

        btnconsultarc.setText("Consultar C.");
        jPanel9.add(btnconsultarc);
        btnconsultarc.setBounds(220, 30, 130, 30);

        btnlistac.setText("...");
        jPanel9.add(btnlistac);
        btnlistac.setBounds(360, 30, 40, 30);

        jPanel1.add(jPanel9);
        jPanel9.setBounds(420, 60, 420, 80);

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Tipo de Busqueda:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(500, 30, 130, 30);

        txtfechav.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(txtfechav);
        txtfechav.setBounds(140, 30, 150, 30);

        btnremover.setText("Remover");
        jPanel1.add(btnremover);
        btnremover.setBounds(410, 30, 90, 30);

        btnseleccionar.setText("Seleccionar");
        jPanel1.add(btnseleccionar);
        btnseleccionar.setBounds(300, 30, 100, 30);

        rdcontrato.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rdcontrato.setText("Por Contrato");
        rdcontrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdcontratoActionPerformed(evt);
            }
        });
        jPanel1.add(rdcontrato);
        rdcontrato.setBounds(730, 30, 110, 30);

        rdempleado.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rdempleado.setText("Por Empleado");
        rdempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdempleadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdempleado);
        rdempleado.setBounds(621, 30, 110, 30);

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Fecha a Verificar:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(10, 30, 130, 30);

        jPanel5.add(jPanel1);
        jPanel1.setBounds(10, 100, 850, 150);
        jPanel5.add(jFechayHorarg2);
        jFechayHorarg2.setBounds(620, 10, 240, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdempleadoActionPerformed
        getRdcontrato().setSelected(false);
    }//GEN-LAST:event_rdempleadoActionPerformed

    private void rdcontratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdcontratoActionPerformed
        // TODO add your handling code here:
        getRdempleado().setSelected(false);
    }//GEN-LAST:event_rdcontratoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        caec.salir();
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnasistenciatotal;
    private javax.swing.JButton btnasistido;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnconsultarc;
    private javax.swing.JButton btnconsultare;
    private javax.swing.JButton btngenerar;
    private javax.swing.JButton btnjustificado;
    private javax.swing.JButton btnlistac;
    private javax.swing.JButton btnlistae;
    private javax.swing.JButton btnnoasistido;
    private javax.swing.JButton btnremover;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnseleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private jfechayhora.JFechayHorarg jFechayHorarg2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdcontrato;
    private javax.swing.JRadioButton rdempleado;
    private javax.swing.JTable tbdetalle;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscarced;
    private javax.swing.JTextField txtbuscarcont;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtfechad;
    private javax.swing.JTextField txtfechah;
    private javax.swing.JTextField txtfechav;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnumeroc;
    private javax.swing.JTextField txtobservacion;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTbdetalle() {
        return tbdetalle;
    }

    public void setTbdetalle(javax.swing.JTable tbdetalle) {
        this.tbdetalle = tbdetalle;
    }

    public javax.swing.JTextField getTxtapellido() {
        return txtapellido;
    }

    public void setTxtapellido(javax.swing.JTextField txtapellido) {
        this.txtapellido = txtapellido;
    }

    public javax.swing.JTextField getTxtbuscarced() {
        return txtbuscarced;
    }

    public void setTxtbuscarced(javax.swing.JTextField txtbuscarced) {
        this.txtbuscarced = txtbuscarced;
    }

    public javax.swing.JTextField getTxtbuscarcont() {
        return txtbuscarcont;
    }

    public void setTxtbuscarcont(javax.swing.JTextField txtbuscarcont) {
        this.txtbuscarcont = txtbuscarcont;
    }

    public javax.swing.JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(javax.swing.JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    public javax.swing.JTextField getTxtfechad() {
        return txtfechad;
    }

    public void setTxtfechad(javax.swing.JTextField txtfechad) {
        this.txtfechad = txtfechad;
    }

    public javax.swing.JTextField getTxtfechah() {
        return txtfechah;
    }

    public void setTxtfechah(javax.swing.JTextField txtfechah) {
        this.txtfechah = txtfechah;
    }

    public javax.swing.JTextField getTxtfechav() {
        return txtfechav;
    }

    public void setTxtfechav(javax.swing.JTextField txtfechav) {
        this.txtfechav = txtfechav;
    }

    public javax.swing.JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(javax.swing.JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public javax.swing.JTextField getTxtnumeroc() {
        return txtnumeroc;
    }

    public void setTxtnumeroc(javax.swing.JTextField txtnumeroc) {
        this.txtnumeroc = txtnumeroc;
    }

    public javax.swing.JTextField getTxtobservacion() {
        return txtobservacion;
    }

    public void setTxtobservacion(javax.swing.JTextField txtobservacion) {
        this.txtobservacion = txtobservacion;
    }

    public javax.swing.JRadioButton getRdcontrato() {
        return rdcontrato;
    }

    public void setRdcontrato(javax.swing.JRadioButton rdcontrato) {
        this.rdcontrato = rdcontrato;
    }

    /**
     * @return the rdempleado
     */
    public javax.swing.JRadioButton getRdempleado() {
        return rdempleado;
    }

    /**
     * @param rdempleado the rdempleado to set
     */
    public void setRdempleado(javax.swing.JRadioButton rdempleado) {
        this.rdempleado = rdempleado;
    }
}
