
package vistas;

import controladores.CFactura;
import java.awt.event.ActionListener;
public class VFactura extends javax.swing.JDialog {
    private CFactura cfac;
    public VFactura(java.awt.Frame parent, boolean modal,CFactura cfac){
        super(parent, modal);
        initComponents();
        this.cfac=cfac;
    }
    
    public void agregarListener(ActionListener accion) {
        getBtnverificar().addActionListener(accion);
        getBtnremover().addActionListener(accion);
        getBtnconsultars().addActionListener(accion);
        getBtncancelars().addActionListener(accion);
        getBtncargar().addActionListener(accion);
        getBtnborrar().addActionListener(accion);
        getBtnbuscar().addActionListener(accion);
        getBtngenerar().addActionListener(accion);
        getBtnregistrar().addActionListener(accion);
        getBtnimprimir().addActionListener(accion);
        getBtncancelar().addActionListener(accion);
        getBtnsalir().addActionListener(accion);
    }
    public void sinregistro(){
        txtbuscar.setEditable(true);
        txtnumerof.setEditable(false);
        getTxtnumeroc().setEditable(false);
        getTxtfecha().setEditable(false);
        getTxthora().setEditable(false);
        getTxtfechad().setEditable(false);
        getTxtfechah().setEditable(false);
        txtnumeroc.setEditable(false);
        getTxtrif().setEditable(false);
        getTxtnombrecli().setEditable(false);
        getTxtcodigos().setEditable(false);
        getTxtnombres().setEditable(false);
        getTxtcantidadcs().setEditable(false);
        getTxtsubtotal().setEditable(false);
        getTxtsubtotaliva().setEditable(false);
        getTxttotal().setEditable(false);
        
        
        getBtnverificar().setEnabled(false);
        getBtnremover().setEnabled(false);
        getBtnconsultars().setEnabled(false);
        getBtncancelars().setEnabled(false);
        getBtncargar().setEnabled(false);
        getBtnborrar().setEnabled(false);
        
        getBtnbuscar().setEnabled(true);
        getBtngenerar().setEnabled(true);
        getBtnregistrar().setEnabled(false);
        getBtnimprimir().setEnabled(false);
        getBtncancelar().setEnabled(true);
        getBtnsalir().setEnabled(true);
        
        getTxtbuscar().setText("");
        txtnumerof.setText("");
        getTxtnumeroc().setText("");
        getTxtfecha().setText("");
        getTxthora().setText("");
        getTxtfechad().setText("");
        getTxtfechah().setText("");
        txtnumeroc.setText("");
        getTxtrif().setText("");
        getTxtnombrecli().setText("");
        getTxtcodigos().setText("");
        getTxtnombres().setText("");
        getTxtcantidadcs().setText("");
        getTxtsubtotal().setText("");
        getTxtsubtotaliva().setText("");
        getTxttotal().setText("");
        
    }
    public void encregistro(){
        txtbuscar.setEditable(false);
        getTxtnumeroc().setEditable(false);
        getTxtfecha().setEditable(false);
        getTxthora().setEditable(false);
        getTxtfechad().setEditable(false);
        getTxtfechah().setEditable(false);
        txtnumeroc.setEditable(false);
        getTxtrif().setEditable(false);
        getTxtnombrecli().setEditable(false);
        getTxtcodigos().setEditable(false);
        getTxtnombres().setEditable(false);
        getTxtcantidadcs().setEditable(false);
        getTxtsubtotal().setEditable(false);
        getTxtsubtotaliva().setEditable(false);
        getTxttotal().setEditable(false);
        
        
        getBtnverificar().setEnabled(false);
        getBtnremover().setEnabled(false);
        getBtnconsultars().setEnabled(false);
        getBtncancelars().setEnabled(false);
        getBtncargar().setEnabled(false);
        getBtnborrar().setEnabled(false);
        
        getBtnbuscar().setEnabled(false);
        getBtngenerar().setEnabled(false);
        getBtnregistrar().setEnabled(false);
        getBtnimprimir().setEnabled(true);
        getBtncancelar().setEnabled(true);
        getBtnsalir().setEnabled(true);
        
        getTxtbuscar().setText("");
        
        
    }
    public void nrogenerado(){
        getTxtnumeroc().setEditable(false);
        getTxtfecha().setEditable(false);
        getTxthora().setEditable(false);
        getTxtfechad().setEditable(true);
        getTxtfechah().setEditable(true);
        txtnumeroc.setEditable(true);
        getTxtrif().setEditable(false);
        getTxtnombrecli().setEditable(false);
        getTxtcodigos().setEditable(false);
        getTxtnombres().setEditable(false);
        getTxtcantidadcs().setEditable(false);
        getTxtsubtotal().setEditable(false);
        getTxtsubtotaliva().setEditable(false);
        getTxttotal().setEditable(false);
        
        getBtnverificar().setEnabled(true);
        getBtnremover().setEnabled(false);
        getBtnconsultars().setEnabled(false);
        getBtncancelars().setEnabled(false);
        getBtncargar().setEnabled(false);
        getBtnborrar().setEnabled(false);
        
        getBtnbuscar().setEnabled(false);
        getBtngenerar().setEnabled(false);
        getBtnimprimir().setEnabled(false);
        getBtncancelar().setEnabled(true);
        getBtnsalir().setEnabled(true);
    }
    
    public void encontradoContrato(){
        getTxtrif().setEditable(false);
        getTxtnombrecli().setEditable(false);
        
        getBtnverificar().setEnabled(false);
        getBtnremover().setEnabled(true);
        
        btnregistrar.setEnabled(true);
        
        getBtnconsultars().setEnabled(true);
        getTxtcodigos().setEditable(true);
    }
    
    public void removerContrato(){
        getTxtrif().setEditable(true);
        getTxtnombrecli().setEditable(false);
        
        btnregistrar.setEnabled(false);
        
        getBtnconsultars().setEnabled(false);
        getTxtcodigos().setEditable(false);
        
        getTxtcodigos().setText("");
        getTxtnombres().setText("");
        getTxtcantidadcs().setText("");
        
        getTxtrif().setText("");
        getTxtnombrecli().setText("");
        
    }
    
    public void encontradoServicio(){
        getBtnconsultars().setEnabled(false);
        getTxtcodigos().setEditable(false);
        getTxtnombres().setEditable(false);
        getTxtcantidadcs().setEditable(true);
        getBtncancelars().setEnabled(true);
    }
    public void removerServicio(){
        getBtnconsultars().setEnabled(true);
        getTxtcodigos().setEditable(true);
        getTxtnombres().setEditable(false);
        getTxtcantidadcs().setEditable(false);
        getBtncancelars().setEnabled(false);
        getBtncargar().setEnabled(false);
        getBtnborrar().setEnabled(false);
        getTxtcodigos().setText("");
        getTxtnombres().setText("");
        getTxtcantidadcs().setText("");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnumerof = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtrif = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnombrecli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnremover = new javax.swing.JButton();
        btnverificar = new javax.swing.JButton();
        txtnumeroc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdetalle = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtsubtotaliva = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txthora = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnconsultars = new javax.swing.JButton();
        btncatalagomp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtcodigos = new javax.swing.JTextField();
        btncancelars = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        btncargar = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtcantidadcs = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfechad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtfechah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("N° Factura");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 30, 80, 30);
        jPanel2.add(txtnumerof);
        txtnumerof.setBounds(110, 30, 150, 30);
        jPanel2.add(txtfecha);
        txtfecha.setBounds(370, 30, 160, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 30, 50, 30);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Datos del Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(null);

        txtrif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrifKeyTyped(evt);
            }
        });
        jPanel3.add(txtrif);
        txtrif.setBounds(60, 60, 160, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("N° Contraro:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 20, 90, 30);
        jPanel3.add(txtnombrecli);
        txtnombrecli.setBounds(290, 60, 180, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(230, 60, 51, 30);

        btnremover.setText("Remover");
        jPanel3.add(btnremover);
        btnremover.setBounds(420, 20, 100, 30);

        btnverificar.setText("Verificar");
        jPanel3.add(btnverificar);
        btnverificar.setBounds(290, 20, 120, 30);
        jPanel3.add(txtnumeroc);
        txtnumeroc.setBounds(120, 20, 160, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Rif:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(20, 60, 30, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 110, 730, 100);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalle de la Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(null);

        tbdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Servicio", "Cantida", "Precio", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbdetalle);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 690, 150);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Sub Total:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(20, 190, 80, 30);
        jPanel4.add(txtsubtotal);
        txtsubtotal.setBounds(110, 190, 130, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Total Iva:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(250, 190, 100, 30);
        jPanel4.add(txtsubtotaliva);
        txtsubtotaliva.setBounds(360, 190, 110, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Total:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(480, 190, 50, 30);
        jPanel4.add(txttotal);
        txttotal.setBounds(540, 190, 170, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(20, 370, 730, 230);
        jPanel2.add(txthora);
        txthora.setBounds(610, 30, 140, 30);

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Detalle del  Servicio del Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setLayout(null);

        btnconsultars.setText("Consultar");
        jPanel8.add(btnconsultars);
        btnconsultars.setBounds(170, 30, 80, 30);

        btncatalagomp.setText("...");
        jPanel8.add(btncatalagomp);
        btncatalagomp.setBounds(260, 30, 50, 30);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel9.setText("Codigo:");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(20, 30, 60, 30);
        jPanel8.add(txtcodigos);
        txtcodigos.setBounds(70, 30, 90, 30);

        btncancelars.setText("Cancelar S.");
        jPanel8.add(btncancelars);
        btncancelars.setBounds(550, 30, 150, 30);
        jPanel8.add(jSeparator1);
        jSeparator1.setBounds(20, 70, 680, 10);

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(330, 30, 60, 30);
        jPanel8.add(txtnombres);
        txtnombres.setBounds(400, 30, 130, 30);

        btncargar.setText("Cargar");
        jPanel8.add(btncargar);
        btncargar.setBounds(410, 90, 120, 30);

        btnborrar.setText("Borrar");
        jPanel8.add(btnborrar);
        btnborrar.setBounds(550, 90, 150, 30);

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel17.setText("Cantidad Actualizar:");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(20, 90, 140, 30);
        jPanel8.add(txtcantidadcs);
        txtcantidadcs.setBounds(170, 90, 220, 30);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 220, 730, 140);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Fecha Desde:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 70, 90, 30);
        jPanel2.add(txtfechad);
        txtfechad.setBounds(110, 70, 150, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Fecha Hasta:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(270, 70, 90, 30);
        jPanel2.add(txtfechah);
        txtfechah.setBounds(370, 70, 160, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Hora:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(550, 30, 50, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 20, 770, 610);

        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Consultar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel6.setLayout(null);

        btnbuscar.setText("Buscar");
        jPanel6.add(btnbuscar);
        btnbuscar.setBounds(10, 90, 140, 40);

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });
        jPanel6.add(txtbuscar);
        txtbuscar.setBounds(10, 50, 140, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("N° Factura:");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(40, 20, 80, 20);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(10, 120, 160, 150);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Operaciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel7.setLayout(null);

        btnsalir.setText("Salir");
        jPanel7.add(btnsalir);
        btnsalir.setBounds(10, 250, 140, 40);

        btngenerar.setText("Nueva Factura");
        jPanel7.add(btngenerar);
        btngenerar.setBounds(10, 30, 140, 40);

        btncancelar.setText("Cancelar");
        jPanel7.add(btncancelar);
        btncancelar.setBounds(10, 200, 140, 40);

        btnimprimir.setText("Imprimir");
        jPanel7.add(btnimprimir);
        btnimprimir.setBounds(10, 140, 140, 40);

        btnregistrar.setText("Registrar");
        jPanel7.add(btnregistrar);
        btnregistrar.setBounds(10, 90, 140, 40);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(10, 290, 160, 310);

        jFechayHorarp2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.add(jFechayHorarp2);
        jFechayHorarp2.setBounds(10, 20, 170, 90);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(790, 20, 190, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtrifKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrifKeyTyped

    }//GEN-LAST:event_txtrifKeyTyped

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped

    }//GEN-LAST:event_txtbuscarKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        cfac.salir();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncancelars;
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btncatalagomp;
    private javax.swing.JButton btnconsultars;
    private javax.swing.JButton btngenerar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnremover;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnverificar;
    private jfechayhora.JFechayHorarp jFechayHorarp2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbdetalle;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidadcs;
    private javax.swing.JTextField txtcodigos;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtfechad;
    private javax.swing.JTextField txtfechah;
    private javax.swing.JTextField txthora;
    private javax.swing.JTextField txtnombrecli;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnumeroc;
    private javax.swing.JTextField txtnumerof;
    private javax.swing.JTextField txtrif;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txtsubtotaliva;
    private javax.swing.JTextField txttotal;
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
     * @return the btncancelars
     */
    public javax.swing.JButton getBtncancelars() {
        return btncancelars;
    }

    /**
     * @param btncancelars the btncancelars to set
     */
    public void setBtncancelars(javax.swing.JButton btncancelars) {
        this.btncancelars = btncancelars;
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
     * @return the btncatalagomp
     */
    public javax.swing.JButton getBtncatalagomp() {
        return btncatalagomp;
    }

    /**
     * @param btncatalagomp the btncatalagomp to set
     */
    public void setBtncatalagomp(javax.swing.JButton btncatalagomp) {
        this.btncatalagomp = btncatalagomp;
    }

    /**
     * @return the btnconsultars
     */
    public javax.swing.JButton getBtnconsultars() {
        return btnconsultars;
    }

    /**
     * @param btnconsultars the btnconsultars to set
     */
    public void setBtnconsultars(javax.swing.JButton btnconsultars) {
        this.btnconsultars = btnconsultars;
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

    /**
     * @return the btnregistrar
     */
    public javax.swing.JButton getBtnregistrar() {
        return btnregistrar;
    }

    /**
     * @param btnregistrar the btnregistrar to set
     */
    public void setBtnregistrar(javax.swing.JButton btnregistrar) {
        this.btnregistrar = btnregistrar;
    }

    /**
     * @return the btnremover
     */
    public javax.swing.JButton getBtnremover() {
        return btnremover;
    }

    /**
     * @param btnremover the btnremover to set
     */
    public void setBtnremover(javax.swing.JButton btnremover) {
        this.btnremover = btnremover;
    }

    /**
     * @return the btnsalir
     */
    public javax.swing.JButton getBtnsalir() {
        return btnsalir;
    }

    /**
     * @param btnsalir the btnsalir to set
     */
    public void setBtnsalir(javax.swing.JButton btnsalir) {
        this.btnsalir = btnsalir;
    }

    /**
     * @return the btnverificar
     */
    public javax.swing.JButton getBtnverificar() {
        return btnverificar;
    }

    /**
     * @param btnverificar the btnverificar to set
     */
    public void setBtnverificar(javax.swing.JButton btnverificar) {
        this.btnverificar = btnverificar;
    }

    /**
     * @return the tbdetalle
     */
    public javax.swing.JTable getTbdetalle() {
        return tbdetalle;
    }

    /**
     * @param tbdetalle the tbdetalle to set
     */
    public void setTbdetalle(javax.swing.JTable tbdetalle) {
        this.tbdetalle = tbdetalle;
    }

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
     * @return the txtcantidadcs
     */
    public javax.swing.JTextField getTxtcantidadcs() {
        return txtcantidadcs;
    }

    /**
     * @param txtcantidadcs the txtcantidadcs to set
     */
    public void setTxtcantidadcs(javax.swing.JTextField txtcantidadcs) {
        this.txtcantidadcs = txtcantidadcs;
    }

    /**
     * @return the txtcodigos
     */
    public javax.swing.JTextField getTxtcodigos() {
        return txtcodigos;
    }

    /**
     * @param txtcodigos the txtcodigos to set
     */
    public void setTxtcodigos(javax.swing.JTextField txtcodigos) {
        this.txtcodigos = txtcodigos;
    }

    /**
     * @return the txtfecha
     */
    public javax.swing.JTextField getTxtfecha() {
        return txtfecha;
    }

    /**
     * @param txtfecha the txtfecha to set
     */
    public void setTxtfecha(javax.swing.JTextField txtfecha) {
        this.txtfecha = txtfecha;
    }

    /**
     * @return the txtfechad
     */
    public javax.swing.JTextField getTxtfechad() {
        return txtfechad;
    }

    /**
     * @param txtfechad the txtfechad to set
     */
    public void setTxtfechad(javax.swing.JTextField txtfechad) {
        this.txtfechad = txtfechad;
    }

    /**
     * @return the txtfechah
     */
    public javax.swing.JTextField getTxtfechah() {
        return txtfechah;
    }

    /**
     * @param txtfechah the txtfechah to set
     */
    public void setTxtfechah(javax.swing.JTextField txtfechah) {
        this.txtfechah = txtfechah;
    }

    

    /**
     * @return the txthora
     */
    public javax.swing.JTextField getTxthora() {
        return txthora;
    }

    /**
     * @param txthora the txthora to set
     */
    public void setTxthora(javax.swing.JTextField txthora) {
        this.txthora = txthora;
    }

    

    /**
     * @return the txtnombrecli
     */
    public javax.swing.JTextField getTxtnombrecli() {
        return txtnombrecli;
    }

    /**
     * @param txtnombrecli the txtnombrecli to set
     */
    public void setTxtnombrecli(javax.swing.JTextField txtnombrecli) {
        this.txtnombrecli = txtnombrecli;
    }

    /**
     * @return the txtnombres
     */
    public javax.swing.JTextField getTxtnombres() {
        return txtnombres;
    }

    /**
     * @param txtnombres the txtnombres to set
     */
    public void setTxtnombres(javax.swing.JTextField txtnombres) {
        this.txtnombres = txtnombres;
    }

    /**
     * @return the txtnumeroc
     */
    public javax.swing.JTextField getTxtnumeroc() {
        return txtnumeroc;
    }

    /**
     * @param txtnumeroc the txtnumeroc to set
     */
    public void setTxtnumeroc(javax.swing.JTextField txtnumeroc) {
        this.txtnumeroc = txtnumeroc;
    }

    /**
     * @return the txtnumerof
     */
    public javax.swing.JTextField getTxtnumerof() {
        return txtnumerof;
    }

    /**
     * @param txtnumerof the txtnumerof to set
     */
    public void setTxtnumerof(javax.swing.JTextField txtnumerof) {
        this.txtnumerof = txtnumerof;
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
     * @return the txtsubtotal
     */
    public javax.swing.JTextField getTxtsubtotal() {
        return txtsubtotal;
    }

    /**
     * @param txtsubtotal the txtsubtotal to set
     */
    public void setTxtsubtotal(javax.swing.JTextField txtsubtotal) {
        this.txtsubtotal = txtsubtotal;
    }

    /**
     * @return the txtsubtotaliva
     */
    public javax.swing.JTextField getTxtsubtotaliva() {
        return txtsubtotaliva;
    }

    /**
     * @param txtsubtotaliva the txtsubtotaliva to set
     */
    public void setTxtsubtotaliva(javax.swing.JTextField txtsubtotaliva) {
        this.txtsubtotaliva = txtsubtotaliva;
    }

    /**
     * @return the txttotal
     */
    public javax.swing.JTextField getTxttotal() {
        return txttotal;
    }

    /**
     * @param txttotal the txttotal to set
     */
    public void setTxttotal(javax.swing.JTextField txttotal) {
        this.txttotal = txttotal;
    }
}
