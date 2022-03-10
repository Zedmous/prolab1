
package vistas;

import controladores.CNomina;
import java.awt.Color;
import java.awt.event.ActionListener;


public class VNomina extends javax.swing.JDialog {
    private CNomina cnomina;
    public VNomina(java.awt.Frame parent, boolean modal,CNomina cnomina) {
        super(parent, modal);
        initComponents();
        setVisible(true);
        this.cnomina=cnomina;
    }
    public void agregarListener(ActionListener accion) {
        
        rdsemanal.addActionListener(accion);
        rdmensual.addActionListener(accion);
        btnverificare.addActionListener(accion);
        btncancelare.addActionListener(accion);
        btnverificarc.addActionListener(accion);
        btncancelarc.addActionListener(accion);
        btncargar.addActionListener(accion);
        btnborrar.addActionListener(accion);
        
        btnbuscar.addActionListener(accion);
        btngenerar.addActionListener(accion);
        btnregistrar.addActionListener(accion);
        btnimprimir.addActionListener(accion);
        btncancelar.addActionListener(accion);
        btnsalir.addActionListener(accion);
    }
    public void sinregistro(){
        txtbuscar.setEditable(true);
        txtnumeron.setEditable(false);
        txtfechan.setEditable(false);
        txthoran.setEditable(false);
        txtfechadn.setEditable(false);
        txtfechahn.setEditable(false);
        txtcedulae.setEditable(false);
        txtnombree.setEditable(false);
        txtapellidoe.setEditable(false);
        txtsueldobme.setEditable(false);
        
        txtcodigoc.setEditable(false);
        txtnombrec.setEditable(false);
        txtcantidadc.setEditable(false);
        txttasignaciones.setEditable(false);
        txttdeducciones.setEditable(false);
        txttsueldonp.setEditable(false);
        
        rdsemanal.setEnabled(false);
        rdmensual.setEnabled(false);
        btnverificare.setEnabled(false);
        btncancelare.setEnabled(false);
        btnverificarc.setEnabled(false);
        btncancelarc.setEnabled(false);
        btncargar.setEnabled(false);
        btnborrar.setEnabled(false);
        
        btnbuscar.setEnabled(true);
        btngenerar.setEnabled(true);
        btnregistrar.setEnabled(false);
        btnimprimir.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(true);
        
        txtbuscar.setText("");
        txtnumeron.setText("");
        txtfechan.setText("");
        txthoran.setText("");
        txtfechadn.setText("");
        txtfechahn.setText("");
        txtcedulae.setText("");
        txtnombree.setText("");
        txtapellidoe.setText("");
        txtsueldobme.setText("");
        
        txtcodigoc.setText("");
        txtnombrec.setText("");
        txtcantidadc.setText("");
        txttasignaciones.setText("");
        txttdeducciones.setText("");
        txttsueldonp.setText("");
        
        rdsemanal.setSelected(false);
        rdmensual.setSelected(false);
    }
    public void encregistro(){
        txtbuscar.setEditable(false);
        btnbuscar.setEnabled(false);
        btngenerar.setEnabled(false);
        btnimprimir.setEnabled(true);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(true);
        txtbuscar.setText("");
    }
    public void nrogenerado(){
        txtbuscar.setEditable(false);
        txtfechadn.setEditable(true);
        txtcedulae.setEditable(true);
        rdsemanal.setEnabled(true);
        rdmensual.setEnabled(true);
        btnverificare.setEnabled(true);
        btnbuscar.setEnabled(false);
        btngenerar.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(true);
    }
    
    public void encontradoEmpleado(){
        txtcedulae.setEditable(false);
        rdsemanal.setEnabled(false);
        rdmensual.setEnabled(false);
        txtfechadn.setEditable(false);
        btnverificare.setEnabled(false);
        btncancelare.setEnabled(true);
        btnverificarc.setEnabled(true);
        txtcodigoc.setEditable(true);
    }
    
    public void removerEmpleado(){
        txtcedulae.setEditable(true);
        btnverificare.setEnabled(true);
        btncancelare.setEnabled(false);
        rdsemanal.setEnabled(true);
        rdmensual.setEnabled(true);
        txtfechadn.setEditable(true);
        btnverificarc.setEnabled(false);
        txtcodigoc.setEditable(false);
        txtcodigoc.setText("");
        txtnombrec.setText("");
        txtcantidadc.setText("");
        txtcedulae.setText("");
        txtnombree.setText("");
        txtapellidoe.setText("");
        txtsueldobme.setText("");
        txtfechadn.setText("");
        txtfechahn.setText("");
        rdmensual.setSelected(false);
        rdsemanal.setSelected(false);
    }
    
    public void encontradoConcepto(){
        btnverificarc.setEnabled(false);
        txtcodigoc.setEditable(false);
        txtcantidadc.setEditable(true);
        btncancelarc.setEnabled(true);
    }
    public void removerConcepto(){
        btnverificarc.setEnabled(true);
        txtcodigoc.setEditable(true);
        txtcantidadc.setEditable(false);
        btncancelarc.setEnabled(false);
        btncargar.setEnabled(false);
        btnborrar.setEnabled(false);
        txtcodigoc.setText("");
        txtnombrec.setText("");
        txtcantidadc.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnumeron = new javax.swing.JTextField();
        txtfechan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdetalle = new javax.swing.JTable();
        txthoran = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnverificarc = new javax.swing.JButton();
        btnlistac = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtcodigoc = new javax.swing.JTextField();
        btncancelarc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtnombrec = new javax.swing.JTextField();
        btncargar = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtcantidadc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtcedulae = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtnombree = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtsueldobme = new javax.swing.JTextField();
        btnverificare = new javax.swing.JButton();
        btncancelare = new javax.swing.JButton();
        txtapellidoe = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rdmensual = new javax.swing.JRadioButton();
        rdsemanal = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtfechadn = new javax.swing.JTextField();
        txtfechahn = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txttasignaciones = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txttdeducciones = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txttsueldonp = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnsalir = new javax.swing.JButton();
        btngenerar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        jFechayHorarp2 = new jfechayhora.JFechayHorarp();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Nomina", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("N° Nomina:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 30, 80, 30);
        jPanel2.add(txtnumeron);
        txtnumeron.setBounds(110, 30, 130, 30);
        jPanel2.add(txtfechan);
        txtfechan.setBounds(310, 30, 170, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(250, 30, 80, 30);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Detalle de la Nomina", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(null);

        tbdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Concepto", "Cantidad", "Valor", "Tipo", "Sub Total:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbdetalle);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 690, 120);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(20, 460, 730, 170);
        jPanel2.add(txthoran);
        txthoran.setBounds(550, 30, 200, 30);

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Detalle del  Concepto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setLayout(null);

        btnverificarc.setText("Verificar");
        jPanel8.add(btnverificarc);
        btnverificarc.setBounds(220, 30, 170, 30);

        btnlistac.setText("Catalogo");
        jPanel8.add(btnlistac);
        btnlistac.setBounds(410, 30, 140, 30);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel9.setText("Codigo:");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(20, 30, 60, 30);
        jPanel8.add(txtcodigoc);
        txtcodigoc.setBounds(90, 30, 110, 30);

        btncancelarc.setText("Cancelar");
        jPanel8.add(btncancelarc);
        btncancelarc.setBounds(560, 30, 160, 30);
        jPanel8.add(jSeparator1);
        jSeparator1.setBounds(10, 110, 710, 10);

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(20, 70, 60, 30);
        jPanel8.add(txtnombrec);
        txtnombrec.setBounds(90, 70, 630, 30);

        btncargar.setText("Cargar");
        jPanel8.add(btncargar);
        btncargar.setBounds(410, 120, 140, 30);

        btnborrar.setText("Borrar");
        jPanel8.add(btnborrar);
        btnborrar.setBounds(560, 120, 160, 30);

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel17.setText("Cantida del Concepto:");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(20, 120, 140, 30);
        jPanel8.add(txtcantidadc);
        txtcantidadc.setBounds(170, 120, 220, 30);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 280, 730, 170);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Hora:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(490, 30, 90, 30);

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Datos del Empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel9.setLayout(null);

        txtcedulae.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaeKeyTyped(evt);
            }
        });
        jPanel9.add(txtcedulae);
        txtcedulae.setBounds(80, 20, 120, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Cedula:");
        jPanel9.add(jLabel15);
        jLabel15.setBounds(20, 20, 60, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Nombre:");
        jPanel9.add(jLabel16);
        jLabel16.setBounds(341, 20, 70, 30);
        jPanel9.add(txtnombree);
        txtnombree.setBounds(410, 20, 190, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Sueldo Base Mensual:");
        jPanel9.add(jLabel20);
        jLabel20.setBounds(340, 60, 170, 30);
        jPanel9.add(txtsueldobme);
        txtsueldobme.setBounds(480, 60, 240, 30);

        btnverificare.setText("Verificar");
        jPanel9.add(btnverificare);
        btnverificare.setBounds(210, 20, 120, 30);

        btncancelare.setText("Cancelar");
        jPanel9.add(btncancelare);
        btncancelare.setBounds(610, 20, 110, 30);
        jPanel9.add(txtapellidoe);
        txtapellidoe.setBounds(80, 60, 250, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Apellido:");
        jPanel9.add(jLabel21);
        jLabel21.setBounds(20, 60, 90, 30);

        jPanel2.add(jPanel9);
        jPanel9.setBounds(20, 150, 730, 110);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Tipo de Nomina", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(null);

        rdmensual.setBackground(new java.awt.Color(153, 204, 255));
        rdmensual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdmensual.setText("Mensual");
        jPanel3.add(rdmensual);
        rdmensual.setBounds(110, 20, 93, 30);

        rdsemanal.setBackground(new java.awt.Color(153, 204, 255));
        rdsemanal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdsemanal.setText("Semanal");
        jPanel3.add(rdsemanal);
        rdsemanal.setBounds(10, 20, 93, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Desde:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(210, 20, 100, 30);
        jPanel3.add(txtfechadn);
        txtfechadn.setBounds(320, 20, 130, 30);
        jPanel3.add(txtfechahn);
        txtfechahn.setBounds(580, 20, 120, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Fecha Hasta:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(470, 20, 90, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 70, 730, 70);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Total de:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel10.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Asignaciones:");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(10, 30, 100, 30);
        jPanel10.add(txttasignaciones);
        txttasignaciones.setBounds(110, 30, 110, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Deducciones:");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(230, 30, 100, 30);
        jPanel10.add(txttdeducciones);
        txttdeducciones.setBounds(330, 30, 100, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sueldo Neto Pagar:");
        jPanel10.add(jLabel14);
        jLabel14.setBounds(440, 30, 130, 30);
        jPanel10.add(txttsueldonp);
        txttsueldonp.setBounds(580, 30, 130, 30);

        jPanel2.add(jPanel10);
        jPanel10.setBounds(20, 630, 730, 80);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 20, 770, 730);

        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Consultar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel6.setLayout(null);

        btnbuscar.setText("Buscar");
        jPanel6.add(btnbuscar);
        btnbuscar.setBounds(40, 100, 90, 30);

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });
        jPanel6.add(txtbuscar);
        txtbuscar.setBounds(20, 50, 130, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("N° Nomina:");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(50, 20, 80, 20);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(10, 160, 170, 150);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Operaciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel7.setLayout(null);

        btnsalir.setText("Salir");
        jPanel7.add(btnsalir);
        btnsalir.setBounds(20, 240, 130, 30);

        btngenerar.setText("Nueva Nomina");
        jPanel7.add(btngenerar);
        btngenerar.setBounds(20, 40, 130, 30);

        btncancelar.setText("Cancelar");
        jPanel7.add(btncancelar);
        btncancelar.setBounds(20, 190, 130, 30);

        btnimprimir.setText("Imprimir");
        jPanel7.add(btnimprimir);
        btnimprimir.setBounds(20, 140, 130, 30);

        btnregistrar.setText("Registrar");
        jPanel7.add(btnregistrar);
        btnregistrar.setBounds(20, 90, 130, 30);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(10, 320, 170, 320);

        jFechayHorarp2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.add(jFechayHorarp2);
        jFechayHorarp2.setBounds(10, 60, 170, 90);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(790, 20, 190, 730);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void txtcedulaeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaeKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        cnomina.salir();
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
            java.util.logging.Logger.getLogger(VContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VContrato dialog = new VContrato(new javax.swing.JFrame(), true);
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
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncancelarc;
    private javax.swing.JButton btncancelare;
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btngenerar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnlistac;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnverificarc;
    private javax.swing.JButton btnverificare;
    private jfechayhora.JFechayHorarp jFechayHorarp2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdmensual;
    private javax.swing.JRadioButton rdsemanal;
    private javax.swing.JTable tbdetalle;
    private javax.swing.JTextField txtapellidoe;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidadc;
    private javax.swing.JTextField txtcedulae;
    private javax.swing.JTextField txtcodigoc;
    private javax.swing.JTextField txtfechadn;
    private javax.swing.JTextField txtfechahn;
    private javax.swing.JTextField txtfechan;
    private javax.swing.JTextField txthoran;
    private javax.swing.JTextField txtnombrec;
    private javax.swing.JTextField txtnombree;
    private javax.swing.JTextField txtnumeron;
    private javax.swing.JTextField txtsueldobme;
    private javax.swing.JTextField txttasignaciones;
    private javax.swing.JTextField txttdeducciones;
    private javax.swing.JTextField txttsueldonp;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnborrar
     */
    public javax.swing.JButton getBtnborrar() {
        return btnborrar;
    }

    /**
     * @param btnborrar the btnborrar to set
     */
    public void setBtnborrar(javax.swing.JButton btnborrar) {
        this.btnborrar = btnborrar;
    }

    /**
     * @return the btnbuscar
     */
    public javax.swing.JButton getBtnbuscar() {
        return btnbuscar;
    }

    /**
     * @param btnbuscar the btnbuscar to set
     */
    public void setBtnbuscar(javax.swing.JButton btnbuscar) {
        this.btnbuscar = btnbuscar;
    }

    /**
     * @return the btncancelar
     */
    public javax.swing.JButton getBtncancelar() {
        return btncancelar;
    }

    /**
     * @param btncancelar the btncancelar to set
     */
    public void setBtncancelar(javax.swing.JButton btncancelar) {
        this.btncancelar = btncancelar;
    }

    /**
     * @return the btncancelarc
     */
    public javax.swing.JButton getBtncancelarc() {
        return btncancelarc;
    }

    /**
     * @param btncancelarc the btncancelarc to set
     */
    public void setBtncancelarc(javax.swing.JButton btncancelarc) {
        this.btncancelarc = btncancelarc;
    }

    /**
     * @return the btncancelare
     */
    public javax.swing.JButton getBtncancelare() {
        return btncancelare;
    }

    /**
     * @param btncancelare the btncancelare to set
     */
    public void setBtncancelare(javax.swing.JButton btncancelare) {
        this.btncancelare = btncancelare;
    }

    /**
     * @return the btncargar
     */
    public javax.swing.JButton getBtncargar() {
        return btncargar;
    }

    /**
     * @param btncargar the btncargar to set
     */
    public void setBtncargar(javax.swing.JButton btncargar) {
        this.btncargar = btncargar;
    }

    /**
     * @return the btngenerar
     */
    public javax.swing.JButton getBtngenerar() {
        return btngenerar;
    }

    /**
     * @param btngenerar the btngenerar to set
     */
    public void setBtngenerar(javax.swing.JButton btngenerar) {
        this.btngenerar = btngenerar;
    }

    /**
     * @return the btnimprimir
     */
    public javax.swing.JButton getBtnimprimir() {
        return btnimprimir;
    }

    /**
     * @param btnimprimir the btnimprimir to set
     */
    public void setBtnimprimir(javax.swing.JButton btnimprimir) {
        this.btnimprimir = btnimprimir;
    }

    public javax.swing.JButton getBtnlistac() {
        return btnlistac;
    }

    public void setBtnlistac(javax.swing.JButton btnlistac) {
        this.btnlistac = btnlistac;
    }

    public javax.swing.JButton getBtnregistrar() {
        return btnregistrar;
    }

    public void setBtnregistrar(javax.swing.JButton btnregistrar) {
        this.btnregistrar = btnregistrar;
    }

    public javax.swing.JButton getBtnsalir() {
        return btnsalir;
    }

    public void setBtnsalir(javax.swing.JButton btnsalir) {
        this.btnsalir = btnsalir;
    }

    public javax.swing.JButton getBtnverificarc() {
        return btnverificarc;
    }

    public void setBtnverificarc(javax.swing.JButton btnverificarc) {
        this.btnverificarc = btnverificarc;
    }

    public javax.swing.JButton getBtnverificare() {
        return btnverificare;
    }

    public void setBtnverificare(javax.swing.JButton btnverificare) {
        this.btnverificare = btnverificare;
    }

    public javax.swing.JRadioButton getRdmensual() {
        return rdmensual;
    }

    public void setRdmensual(javax.swing.JRadioButton rdmensual) {
        this.rdmensual = rdmensual;
    }

    public javax.swing.JRadioButton getRdsemanal() {
        return rdsemanal;
    }

    public void setRdsemanal(javax.swing.JRadioButton rdsemanal) {
        this.rdsemanal = rdsemanal;
    }

    public javax.swing.JTable getTbdetalle() {
        return tbdetalle;
    }

    public void setTbdetalle(javax.swing.JTable tbdetalle) {
        this.tbdetalle = tbdetalle;
    }

    public javax.swing.JTextField getTxtapellidoe() {
        return txtapellidoe;
    }

    public void setTxtapellidoe(javax.swing.JTextField txtapellidoe) {
        this.txtapellidoe = txtapellidoe;
    }

    public javax.swing.JTextField getTxtbuscar() {
        return txtbuscar;
    }

    public void setTxtbuscar(javax.swing.JTextField txtbuscar) {
        this.txtbuscar = txtbuscar;
    }

    public javax.swing.JTextField getTxtcantidadc() {
        return txtcantidadc;
    }

    public void setTxtcantidadc(javax.swing.JTextField txtcantidadc) {
        this.txtcantidadc = txtcantidadc;
    }

    public javax.swing.JTextField getTxtcedulae() {
        return txtcedulae;
    }

    public void setTxtcedulae(javax.swing.JTextField txtcedulae) {
        this.txtcedulae = txtcedulae;
    }

    public javax.swing.JTextField getTxtcodigoc() {
        return txtcodigoc;
    }

    public void setTxtcodigoc(javax.swing.JTextField txtcodigoc) {
        this.txtcodigoc = txtcodigoc;
    }

    public javax.swing.JTextField getTxtfechadn() {
        return txtfechadn;
    }

    public void setTxtfechadn(javax.swing.JTextField txtfechadn) {
        this.txtfechadn = txtfechadn;
    }

    public javax.swing.JTextField getTxtfechahn() {
        return txtfechahn;
    }

    public void setTxtfechahn(javax.swing.JTextField txtfechahn) {
        this.txtfechahn = txtfechahn;
    }

    public javax.swing.JTextField getTxtfechan() {
        return txtfechan;
    }

    public void setTxtfechan(javax.swing.JTextField txtfechan) {
        this.txtfechan = txtfechan;
    }


    public javax.swing.JTextField getTxthoran() {
        return txthoran;
    }

    public void setTxthoran(javax.swing.JTextField txthoran) {
        this.txthoran = txthoran;
    }

    

    public javax.swing.JTextField getTxtnombrec() {
        return txtnombrec;
    }

    public void setTxtnombrec(javax.swing.JTextField txtnombrec) {
        this.txtnombrec = txtnombrec;
    }

    public javax.swing.JTextField getTxtnombree() {
        return txtnombree;
    }

    public void setTxtnombree(javax.swing.JTextField txtnombree) {
        this.txtnombree = txtnombree;
    }

    public javax.swing.JTextField getTxtnumeron() {
        return txtnumeron;
    }

    public void setTxtnumeron(javax.swing.JTextField txtnumeron) {
        this.txtnumeron = txtnumeron;
    }

    public javax.swing.JTextField getTxtsueldobme() {
        return txtsueldobme;
    }

    public void setTxtsueldobme(javax.swing.JTextField txtsueldobme) {
        this.txtsueldobme = txtsueldobme;
    }

    public javax.swing.JTextField getTxttasignaciones() {
        return txttasignaciones;
    }

    public void setTxttasignaciones(javax.swing.JTextField txttasignaciones) {
        this.txttasignaciones = txttasignaciones;
    }

    public javax.swing.JTextField getTxttdeducciones() {
        return txttdeducciones;
    }

    public void setTxttdeducciones(javax.swing.JTextField txttdeducciones) {
        this.txttdeducciones = txttdeducciones;
    }

    public javax.swing.JTextField getTxttsueldonp() {
        return txttsueldonp;
    }

    public void setTxttsueldonp(javax.swing.JTextField txttsueldonp) {
        this.txttsueldonp = txttsueldonp;
    }
}
