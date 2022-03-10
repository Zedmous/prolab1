
package controladores;

import generales.Fecha;
import generales.Mensajes;
import java.awt.event.ActionEvent;
import vistas.VEmpresa;
import java.awt.event.ActionListener;
import modelos.MEmpresa;

public class CEmpresa implements ActionListener{
    private Mensajes msj=new Mensajes();
    private String login,cedula,nombre,apellido, codigonu;
    private VEmpresa vmenu;
    private CEmpleado cem;
    private CCliente ccli;
    private CConcepto cconc;
    private CCargo ccarg;
    private CServicio cserv;
    private CContrato ccont;
    private CFactura cfac;
    private CNomina cnom;
    private CAsignacionec caec;
    private CRAusencias casm;
    private CCalculadora ccalculadora;
    private MEmpresa mempre;
    private Fecha fe = new Fecha();
    private boolean aempleado=false;
    private boolean acliente=false;
    private boolean aservicio=false;
    private boolean acargo=false;
    private boolean aconcepto=false;
    private boolean anomina=false;
    private boolean afactura=false;
    private boolean acontrato=false;
    private boolean aasignacionec=false;
    private boolean aausenciassm=false;
    
    
    public CEmpresa(String login,String cedula,String nombre, String apellido,String codigonu){
        msj.mingresarsistema(nombre);
        vmenu = new VEmpresa(login,cedula,nombre,apellido,codigonu);
        vmenu.setVisible(true);
        vmenu.agregarListener(this);
        mempre=new MEmpresa();
        vmenu.setTitle("MENU");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //ARCHIVOS
            if(e.getActionCommand().equalsIgnoreCase("Empleados")){
                mempre.cargarCargo();
                if(mempre.calcCantCargo()==0){
                    msj.mcomparacionincorrecta("Por favor primero registre cargos para procesar empleados","Sin Cargos");
            
                }else{
                    if(!aempleado){
                        cem=new CEmpleado(this);
                        aempleado=true;
                    }else{
                        msj.mcomparacionincorrecta("Ya abrio el formulario empleado","FORMULARIO ABIERTO");
                    }
                }
            }
        if(e.getActionCommand().equalsIgnoreCase("Clientes")){
            if(!acliente){
                ccli=new CCliente(this);
                acliente=true;
            }else{
                msj.mcomparacionincorrecta("Ya abrio el formulario cliente","FORMULARIO ABIERTO");
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Servicios")){
            if(!aservicio){
                cserv=new CServicio(this);
                aservicio=true;
            }else{
                msj.mcomparacionincorrecta("Ya abrio el formulario servicio","FORMULARIO ABIERTO");
            }
            
        }
        if(e.getActionCommand().equalsIgnoreCase("Conceptos")){
            if(!aconcepto){
                cconc=new CConcepto(this);
                aconcepto=true;
            }else{
                msj.mcomparacionincorrecta("Ya abrio el formulario concepto","FORMULARIO ABIERTO");
            }
            
        }
        if(e.getActionCommand().equalsIgnoreCase("Cargos")){
            if(!acargo){
                ccarg=new CCargo(this);
                acargo=true;
            }else{
                msj.mcomparacionincorrecta("Ya abrio el formulario cargo","FORMULARIO ABIERTO");
            }
        }
        //PROCESOS
        if(e.getActionCommand().equalsIgnoreCase("Facturas")){
            mempre.cargarContratosActivos();
            mempre.cargarServicios();
            if(mempre.calcCantContratos()==0){
                msj.mcomparacionincorrecta("Por favor primero registre contratos para procesar facturas","Sin Contratos");
            
            }else if(mempre.calcCantServicio()==0){
                msj.mcomparacionincorrecta("Por favor primero registre servicios para procesar facturas","Sin Servicios");
            }else{
                if(!afactura){
                    cfac=new CFactura(this);
                    afactura=true;
                }else{
                    msj.mcomparacionincorrecta("Ya abrio el formulario Factura","FORMULARIO ABIERTO");
                }
            }
            
        }
        if(e.getActionCommand().equalsIgnoreCase("Contratos")){
            mempre.cargarServicios();
            mempre.cargarClientes();
            if(mempre.calcCantCliente()==0){
                msj.mcomparacionincorrecta("Por favor primero registre clientes para procesar contratos","Sin Clientes");
            
            }else if(mempre.calcCantServicio()==0){
                msj.mcomparacionincorrecta("Por favor primero registre servicios para procesar contratos","Sin Servicios");
            }else{
                if(!acontrato){
                    ccont=new CContrato(this);
                    acontrato=true;
                }else{
                    msj.mcomparacionincorrecta("Ya abrio el formulario contrato","FORMULARIO ABIERTO");
                }
            }
            
        }
        if(e.getSource().equals(vmenu.getBtngnominas())){
            
            mempre.cargarConceptos();
            if(mempre.calccantEmpleado()==0){
                msj.mcomparacionincorrecta("Por favor primero registre empleados para procesar nominas","Sin Empleados");
            }else if(mempre.calcCantConcepto()==0){
                msj.mcomparacionincorrecta("Por favor primero registre conceptos para procesar nominas","Sin Conceptos");
            }else{
                if(!anomina){
                    cnom=new CNomina(this);
                    anomina=true;
                }else{
                    msj.mcomparacionincorrecta("Ya abrio el formulario nomina de empleados","FORMULARIO ABIERTO");
                }
            }
            
            
        }
        if(e.getActionCommand().equalsIgnoreCase("Asignacion Empleados a Contratos")){
            mempre.cargarContratosActivos();
            mempre.cargarEmpleadosLibresdia(fe.capturardia(fe.capturardia(fe.getFechalatina())));
            if(mempre.calcCantContratos()==0){
                msj.mcomparacionincorrecta("Por favor primero registre contratos para procesar asignacion de turnos","Sin Contratos");
            }else if(mempre.calcCantEmpleadoLibres()==0){
                msj.mcomparacionincorrecta("Por favor primero registre empleados o verifique sus dias libres  para procesar asignacion de Turnos","Sin Empleados");
            }else{
                if(!aasignacionec){
                    caec=new CAsignacionec(this);
                    aasignacionec=true;
                }else{
                    msj.mcomparacionincorrecta("Ya abrio el formulario asignacion de empleados a contratos","FORMULARIO ABIERTO");
                }
            }
        }
        if(e.getSource().equals(vmenu.getBtnrnomina())){
            if(!aausenciassm){
                casm= new CRAusencias(this);
                aausenciassm=true;
            }else{
                msj.mcomparacionincorrecta("Ya abrio el formulario reportes de ausencias laborales semanales o mensuales","FORMULARIO ABIERTO");
            }
        }
        if(e.getSource().equals(vmenu.getBtnacerca())){
            ccalculadora= new CCalculadora(this);
        }
    }

    public VEmpresa getVmenu() {
        return vmenu;
    }

    public void setVmenu(VEmpresa vmenu) {
        this.vmenu = vmenu;
    }

    public boolean isAempleado() {
        return aempleado;
    }

    public void setAempleado(boolean aempleado) {
        this.aempleado = aempleado;
    }

    public boolean isAcliente() {
        return acliente;
    }

    public void setAcliente(boolean acliente) {
        this.acliente = acliente;
    }

    public boolean isAservicio() {
        return aservicio;
    }

    public void setAservicio(boolean aservicio) {
        this.aservicio = aservicio;
    }

    public boolean isAcargo() {
        return acargo;
    }

    public void setAcargo(boolean acargo) {
        this.acargo = acargo;
    }

    public boolean isAconcepto() {
        return aconcepto;
    }

    public void setAconcepto(boolean aconcepto) {
        this.aconcepto = aconcepto;
    }

    /**
     * @return the aasignacionec
     */
    public boolean isAasignacionec() {
        return aasignacionec;
    }

    /**
     * @param aasignacionec the aasignacionec to set
     */
    public void setAasignacionec(boolean aasignacionec) {
        this.aasignacionec = aasignacionec;
    }

    /**
     * @return the acontrato
     */
    public boolean isAcontrato() {
        return acontrato;
    }

    /**
     * @param acontrato the acontrato to set
     */
    public void setAcontrato(boolean acontrato) {
        this.acontrato = acontrato;
    }

    /**
     * @return the afactura
     */
    public boolean isAfactura() {
        return afactura;
    }

    /**
     * @param afactura the afactura to set
     */
    public void setAfactura(boolean afactura) {
        this.afactura = afactura;
    }

    /**
     * @return the aausenciassm
     */
    public boolean isAausenciassm() {
        return aausenciassm;
    }

    /**
     * @param aausenciassm the aausenciassm to set
     */
    public void setAausenciassm(boolean aausenciassm) {
        this.aausenciassm = aausenciassm;
    }

    /**
     * @return the anomina
     */
    public boolean isAnomina() {
        return anomina;
    }

    /**
     * @param anomina the anomina to set
     */
    public void setAnomina(boolean anomina) {
        this.anomina = anomina;
    }

}
