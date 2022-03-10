
package vistas;

import generales.Mensajes;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;






public class VEmpresa extends javax.swing.JFrame {
    private String login,cedula,nombre,apellido, codigonu;
    private Mensajes msj = new Mensajes();
    public VEmpresa(String login,String cedula,String nombre, String apellido,String codigonu) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/chart.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon MyImgCustom =new ImageIcon(this.getClass().getResource("/img/descarga.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(MyImgCustom);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,MyImgCustom.getIconWidth(),MyImgCustom.getIconHeight());
        this.login=login;
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.codigonu=codigonu;
        setLocationRelativeTo(null);
        setExtendedState(6);
        //setResizable(false);
        
    }
    public void agregarListener(ActionListener actionListener) {
        getBtnempleados().addActionListener(actionListener);
        getBtnclientes().addActionListener(actionListener);
        getBtnconceptos().addActionListener(actionListener);
        getBtnservicios().addActionListener(actionListener);
        getBtncargos().addActionListener(actionListener);
        getBtngcontratos().addActionListener(actionListener);
        getBtngfacturas().addActionListener(actionListener);
        getBtngnominas().addActionListener(actionListener);
        getBtngasignacionec().addActionListener(actionListener);
        getBtnrnomina().addActionListener(actionListener);
        getBtnacerca().addActionListener(actionListener);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnmenus = new javax.swing.JMenuBar();
        btnarchivos = new javax.swing.JMenu();
        btnempleados = new javax.swing.JMenuItem();
        btnclientes = new javax.swing.JMenuItem();
        btnservicios = new javax.swing.JMenuItem();
        btnconceptos = new javax.swing.JMenuItem();
        btncargos = new javax.swing.JMenuItem();
        btnprocesos = new javax.swing.JMenu();
        btngfacturas = new javax.swing.JMenuItem();
        btngnominas = new javax.swing.JMenuItem();
        btngcontratos = new javax.swing.JMenuItem();
        btngasignacionec = new javax.swing.JMenuItem();
        btnreportes = new javax.swing.JMenu();
        btnrnomina = new javax.swing.JMenuItem();
        btnmantenimiento = new javax.swing.JMenu();
        btnseguridad = new javax.swing.JMenu();
        btncambiarclave = new javax.swing.JMenuItem();
        btnayuda = new javax.swing.JMenu();
        btncalculadora = new javax.swing.JMenuItem();
        btnsalir = new javax.swing.JMenu();
        btncerrarsesion = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU PRINCIPAL");

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        btnarchivos.setText("Archivos");

        btnempleados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        btnempleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/area.png"))); // NOI18N
        btnempleados.setText("Empleados");
        btnarchivos.add(btnempleados);

        btnclientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/material.png"))); // NOI18N
        btnclientes.setText("Clientes");
        btnarchivos.add(btnclientes);

        btnservicios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        btnservicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proveedor.png"))); // NOI18N
        btnservicios.setText("Servicios");
        btnarchivos.add(btnservicios);

        btnconceptos.setText("Conceptos");
        btnarchivos.add(btnconceptos);

        btncargos.setText("Cargos");
        btnarchivos.add(btncargos);

        btnmenus.add(btnarchivos);

        btnprocesos.setText("Procesos");

        btngfacturas.setText("Facturas");
        btnprocesos.add(btngfacturas);

        btngnominas.setText("Nominas");
        btnprocesos.add(btngnominas);

        btngcontratos.setText("Contratos");
        btnprocesos.add(btngcontratos);

        btngasignacionec.setText("Asignacion Empleados a Contratos");
        btnprocesos.add(btngasignacionec);

        btnmenus.add(btnprocesos);

        btnreportes.setText("Reportes");

        btnrnomina.setText("Reporte de Nomina");
        btnreportes.add(btnrnomina);

        btnmenus.add(btnreportes);

        btnmantenimiento.setText("Mantenimiento");
        btnmenus.add(btnmantenimiento);

        btnseguridad.setText("Seguridad");

        btncambiarclave.setText("Cambiar clave");
        btnseguridad.add(btncambiarclave);

        btnmenus.add(btnseguridad);

        btnayuda.setText("Ayuda");

        btncalculadora.setText("Calculadora");
        btncalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalculadoraActionPerformed(evt);
            }
        });
        btnayuda.add(btncalculadora);

        btnmenus.add(btnayuda);

        btnsalir.setText("Salir");

        btncerrarsesion.setText("Cerrar Sesion");
        btncerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarsesionActionPerformed(evt);
            }
        });
        btnsalir.add(btncerrarsesion);

        btnmenus.add(btnsalir);

        setJMenuBar(btnmenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void btncalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalculadoraActionPerformed
       
    }//GEN-LAST:event_btncalculadoraActionPerformed

    private void btncerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionActionPerformed
        if(msj.mcerrarsistema()==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btncerrarsesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnarchivos;
    private javax.swing.JMenu btnayuda;
    private javax.swing.JMenuItem btncalculadora;
    private javax.swing.JMenuItem btncambiarclave;
    private javax.swing.JMenuItem btncargos;
    private javax.swing.JMenuItem btncerrarsesion;
    private javax.swing.JMenuItem btnclientes;
    private javax.swing.JMenuItem btnconceptos;
    private javax.swing.JMenuItem btnempleados;
    private javax.swing.JMenuItem btngasignacionec;
    private javax.swing.JMenuItem btngcontratos;
    private javax.swing.JMenuItem btngfacturas;
    private javax.swing.JMenuItem btngnominas;
    private javax.swing.JMenu btnmantenimiento;
    private javax.swing.JMenuBar btnmenus;
    private javax.swing.JMenu btnprocesos;
    private javax.swing.JMenu btnreportes;
    private javax.swing.JMenuItem btnrnomina;
    private javax.swing.JMenu btnsalir;
    private javax.swing.JMenu btnseguridad;
    private javax.swing.JMenuItem btnservicios;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnacerca
     */
    public javax.swing.JMenuItem getBtnacerca() {
        return btncalculadora;
    }

    /**
     * @param btnacerca the btnacerca to set
     */
    public void setBtnacerca(javax.swing.JMenuItem btnacerca) {
        this.btncalculadora = btnacerca;
    }

    /**
     * @return the btnarchivos
     */
    public javax.swing.JMenu getBtnarchivos() {
        return btnarchivos;
    }

    /**
     * @param btnarchivos the btnarchivos to set
     */
    public void setBtnarchivos(javax.swing.JMenu btnarchivos) {
        this.btnarchivos = btnarchivos;
    }

    /**
     * @return the btnayuda
     */
    public javax.swing.JMenu getBtnayuda() {
        return btnayuda;
    }

    /**
     * @param btnayuda the btnayuda to set
     */
    public void setBtnayuda(javax.swing.JMenu btnayuda) {
        this.btnayuda = btnayuda;
    }

    /**
     * @return the btncambiarclave
     */
    public javax.swing.JMenuItem getBtncambiarclave() {
        return btncambiarclave;
    }

    /**
     * @param btncambiarclave the btncambiarclave to set
     */
    public void setBtncambiarclave(javax.swing.JMenuItem btncambiarclave) {
        this.btncambiarclave = btncambiarclave;
    }

    /**
     * @return the btncargos
     */
    public javax.swing.JMenuItem getBtncargos() {
        return btncargos;
    }

    /**
     * @param btncargos the btncargos to set
     */
    public void setBtncargos(javax.swing.JMenuItem btncargos) {
        this.btncargos = btncargos;
    }

    /**
     * @return the btncerrarsesion
     */
    public javax.swing.JMenuItem getBtncerrarsesion() {
        return btncerrarsesion;
    }

    /**
     * @param btncerrarsesion the btncerrarsesion to set
     */
    public void setBtncerrarsesion(javax.swing.JMenuItem btncerrarsesion) {
        this.btncerrarsesion = btncerrarsesion;
    }

    /**
     * @return the btnclientes
     */
    public javax.swing.JMenuItem getBtnclientes() {
        return btnclientes;
    }

    /**
     * @param btnclientes the btnclientes to set
     */
    public void setBtnclientes(javax.swing.JMenuItem btnclientes) {
        this.btnclientes = btnclientes;
    }

    /**
     * @return the btnconceptos
     */
    public javax.swing.JMenuItem getBtnconceptos() {
        return btnconceptos;
    }

    /**
     * @param btnconceptos the btnconceptos to set
     */
    public void setBtnconceptos(javax.swing.JMenuItem btnconceptos) {
        this.btnconceptos = btnconceptos;
    }

    /**
     * @return the btnempleados
     */
    public javax.swing.JMenuItem getBtnempleados() {
        return btnempleados;
    }

    /**
     * @param btnempleados the btnempleados to set
     */
    public void setBtnempleados(javax.swing.JMenuItem btnempleados) {
        this.btnempleados = btnempleados;
    }

    /**
     * @return the btngasignacionec
     */
    public javax.swing.JMenuItem getBtngasignacionec() {
        return btngasignacionec;
    }

    /**
     * @param btngasignacionec the btngasignacionec to set
     */
    public void setBtngasignacionec(javax.swing.JMenuItem btngasignacionec) {
        this.btngasignacionec = btngasignacionec;
    }

    /**
     * @return the btngcontratos
     */
    public javax.swing.JMenuItem getBtngcontratos() {
        return btngcontratos;
    }

    /**
     * @param btngcontratos the btngcontratos to set
     */
    public void setBtngcontratos(javax.swing.JMenuItem btngcontratos) {
        this.btngcontratos = btngcontratos;
    }

    /**
     * @return the btngfacturas
     */
    public javax.swing.JMenuItem getBtngfacturas() {
        return btngfacturas;
    }

    /**
     * @param btngfacturas the btngfacturas to set
     */
    public void setBtngfacturas(javax.swing.JMenuItem btngfacturas) {
        this.btngfacturas = btngfacturas;
    }

    /**
     * @return the btngnominas
     */
    public javax.swing.JMenuItem getBtngnominas() {
        return btngnominas;
    }

    /**
     * @param btngnominas the btngnominas to set
     */
    public void setBtngnominas(javax.swing.JMenuItem btngnominas) {
        this.btngnominas = btngnominas;
    }

    /**
     * @return the btnmantenimiento
     */
    public javax.swing.JMenu getBtnmantenimiento() {
        return btnmantenimiento;
    }

    /**
     * @param btnmantenimiento the btnmantenimiento to set
     */
    public void setBtnmantenimiento(javax.swing.JMenu btnmantenimiento) {
        this.btnmantenimiento = btnmantenimiento;
    }

    /**
     * @return the btnmenus
     */
    public javax.swing.JMenuBar getBtnmenus() {
        return btnmenus;
    }

    /**
     * @param btnmenus the btnmenus to set
     */
    public void setBtnmenus(javax.swing.JMenuBar btnmenus) {
        this.btnmenus = btnmenus;
    }

    /**
     * @return the btnprocesos
     */
    public javax.swing.JMenu getBtnprocesos() {
        return btnprocesos;
    }

    /**
     * @param btnprocesos the btnprocesos to set
     */
    public void setBtnprocesos(javax.swing.JMenu btnprocesos) {
        this.btnprocesos = btnprocesos;
    }

    /**
     * @return the btnreportes
     */
    public javax.swing.JMenu getBtnreportes() {
        return btnreportes;
    }

    /**
     * @param btnreportes the btnreportes to set
     */
    public void setBtnreportes(javax.swing.JMenu btnreportes) {
        this.btnreportes = btnreportes;
    }

    /**
     * @return the btnrnomina
     */
    public javax.swing.JMenuItem getBtnrnomina() {
        return btnrnomina;
    }

    /**
     * @param btnrnomina the btnrnomina to set
     */
    public void setBtnrnomina(javax.swing.JMenuItem btnrnomina) {
        this.btnrnomina = btnrnomina;
    }

    /**
     * @return the btnsalir
     */
    public javax.swing.JMenu getBtnsalir() {
        return btnsalir;
    }

    /**
     * @param btnsalir the btnsalir to set
     */
    public void setBtnsalir(javax.swing.JMenu btnsalir) {
        this.btnsalir = btnsalir;
    }

    /**
     * @return the btnseguridad
     */
    public javax.swing.JMenu getBtnseguridad() {
        return btnseguridad;
    }

    /**
     * @param btnseguridad the btnseguridad to set
     */
    public void setBtnseguridad(javax.swing.JMenu btnseguridad) {
        this.btnseguridad = btnseguridad;
    }

    /**
     * @return the btnservicios
     */
    public javax.swing.JMenuItem getBtnservicios() {
        return btnservicios;
    }

    /**
     * @param btnservicios the btnservicios to set
     */
    public void setBtnservicios(javax.swing.JMenuItem btnservicios) {
        this.btnservicios = btnservicios;
    }

    
}
