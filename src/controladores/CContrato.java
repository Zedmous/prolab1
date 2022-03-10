
package controladores;
import generales.Fecha;
import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.MContrato;
import modelos.MDContrato;
import modelos.MServicio;
import vistas.VContrato;
import javax.swing.table.DefaultTableModel;


public class CContrato implements ActionListener  {
    private VContrato vcont;
    private CEmpresa cmenu;
    private MContrato mcont;
    private Mensajes msj;
    private Fecha fe = new Fecha();
    //private DefaultTableModel tb;//importante
    public CContrato(CEmpresa cmenu){
        vcont= new VContrato(cmenu.getVmenu(),false,this);
        vcont.setLocationRelativeTo(null);
        vcont.setResizable(false);
        vcont.setVisible(true);	
        vcont.agregarListener(this);
        vcont.setTitle("CONTRATO");
        vcont.sinregistro();
        this.cmenu=cmenu;
        mcont = new MContrato();
        msj = new Mensajes();
        //tb = (DefaultTableModel) vcont.getTbdetalle().getModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vcont.getBtnbuscar())){
            if("".equals(vcont.getTxtbuscar().getText())){
                msj.mvacio("Ingrese el Codigo del Contrato", "Error",vcont.getTxtbuscar());
            }else{
                buscarContrato(); 
            }
        }
        if(e.getSource().equals(vcont.getBtngenerar())){
            generarNroContrato();
        }
        if(e.getSource().equals(vcont.getBtnregistrar())){
            if(vcont.getTxtfechad().getText().equalsIgnoreCase("")){
                msj.mvacio("Debe ingresar una fecha de inicio para el contrato", "Fecha Vacio",vcont.getTxtfechad());
            }else if(!fe.isFechaValida(vcont.getTxtfechad().getText())){
                msj.mvacio("Por favor ingrese una Fecha de inicio valida DD/MM/AAAA","Fecha Invalidad",vcont.getTxtfechad());
            }else if(vcont.getTxtfechah().getText().equalsIgnoreCase("")){
                msj.mvacio("Debe ingresar una fecha de culminacion para el contrato", "Fecha Vacio",vcont.getTxtfechah());
            }else if(!fe.isFechaValida(vcont.getTxtfechah().getText())){
                msj.mvacio("Por favor ingrese una Fecha de culminacion valida DD/MM/AAAA","Fecha Invalidad",vcont.getTxtfechah());
            }else if(fe.fechaesmenorafecha(fe.deStringaFecha(vcont.getTxtfechad().getText()),fe.deStringaFecha(vcont.getTxtfechah().getText()))){
                msj.mvacio("La fecha final debe ser mayor a la fecha inicial","Fechas Invalidas",vcont.getTxtfechad());
            }else if(vcont.getTxtrif().getText().equalsIgnoreCase("")){
                msj.mvacio("Verifique el RIF del cliente para registrar el contrato", "Rif Vacio",vcont.getTxtrif());
            }else{
                registrar();
            }
        }
        if(e.getSource().equals(vcont.getBtnimprimir())){
            msj.mcomparacionincorrecta("Accion no implementada","En construccion");
        }
        if(e.getSource().equals(vcont.getBtncancelar())){
            cancelar();
        }
        if(e.getSource().equals(vcont.getBtnsalir())){
            salir();
        }
        if(e.getSource().equals(vcont.getBtnverificar())){
            if(vcont.getTxtfechad().getText().equalsIgnoreCase("")){
                msj.mvacio("Debe ingresar una fecha de inicio para el contrato", "Fecha Vacio",vcont.getTxtfechad());
            }else if(!fe.isFechaValida(vcont.getTxtfechad().getText())){
                msj.mvacio("Por favor ingrese una Fecha de inicio valida DD-MM-AAAA","Fecha Invalidad",vcont.getTxtfechad());
            }else if(vcont.getTxtfechah().getText().equalsIgnoreCase("")){
                msj.mvacio("Debe ingresar una fecha de culminacion para el contrato", "Fecha Vacio",vcont.getTxtfechah());
            }else if(!fe.isFechaValida(vcont.getTxtfechah().getText())){
                msj.mvacio("Por favor ingrese una Fecha de culminacion valida DD-MM-AAAA","Fecha Invalidad",vcont.getTxtfechah());
            }else if(fe.fechaesmenoroigualafecha(fe.deStringaFecha(fe.getFechalatina()),fe.deStringaFecha(vcont.getTxtfechad().getText()))){
                msj.mcomparacionincorrecta("La fecha de inicio debe ser mayor o igual a la fecha actual","Fecha Incorrecta");
            }else if(fe.fechaesmenorafecha(fe.deStringaFecha(vcont.getTxtfechad().getText()),fe.deStringaFecha(vcont.getTxtfechah().getText()))){
                msj.mcomparacionincorrecta("La fecha de culminacion debe ser mayor o igual a la fecha inicial","Fechas Incorrecta");
            }else if(vcont.getTxtrif().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese el RIF del cliente para buscar", "Rif Vacio",vcont.getTxtrif());
            }else{
                buscarCliente();
            }
        }
        if(e.getSource().equals(vcont.getBtnremover())){
            vcont.removerCliente();
        }
        if(e.getSource().equals(vcont.getBtnconsultars())){
            if(vcont.getTxtrif().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese el RIF del cliente para buscar", "Rif Vacio",vcont.getTxtrif());
            }else if(vcont.getTxtcodigos().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese El Codigo del Servicio", "Codigo Vacio", vcont.getTxtcodigos());
            }else{
                buscarServicio();
            }
        }
        if(e.getSource().equals(vcont.getBtncancelars())){
            cancelarServicio();
        }
        if(e.getSource().equals(vcont.getBtncargar())){
            if(vcont.getTxtcantidadcs().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese la Cantidad Solicitada del servicio para el contrato", "Cantidad Solicitada", vcont.getTxtcantidadcs());
            }else if(Integer.parseInt(vcont.getTxtcantidadcs().getText())>8 && (vcont.getTxtcodigos().getText().equalsIgnoreCase("vin") || vcont.getTxtcodigos().getText().equalsIgnoreCase("vid"))){
                msj.mcomparacionincorrecta("La cantida maxima de vigilantes permitidos por turno es de 8","Limite Superado");
            }else{
                if(validarcargarContrato()){
                    cargarServicio();
                }
            }
        }
        if(e.getSource().equals(vcont.getBtnborrar())){
            removerServicio();
        }
    }    
    
    public final void generarNroContrato(){
        mcont = new MContrato();
        vcont.getTxtnumeroc().setText(String.valueOf(mcont.generarNumeroContrato()));
        vcont.getTxtfecha().setText(fe.getFechalatina());
        vcont.getTxthora().setText(fe.getHoraactual());
        vcont.nrogenerado();
    }
    public void buscarCliente(){
        mcont.getMcli().setRif(vcont.getTxtrif().getText());
        if(mcont.getMcli().consultar()){
            vcont.getTxtnombrecli().setText(mcont.getMcli().getNombre());
            if(mcont.getMcli().getCodigotc().equalsIgnoreCase("tc")){
                vcont.getRdtc24().setSelected(false);
                vcont.getRdtc12().setSelected(true);
            }else{
                vcont.getRdtc12().setSelected(false);
                vcont.getRdtc24().setSelected(true);
            }
            vcont.encontradoCliente();
        }else{
            msj.mnencontrado();
        }
    }
    public void buscarServicio(){
        MServicio mser = new MServicio();
        mser.setCodigo(vcont.getTxtcodigos().getText());
        if(mser.consultar()){
            vcont.getTxtnombres().setText(mser.getNombre());
            vcont.encontradoServicio();
            int pos=mcont.buscarDServ(mser.getCodigo());
            if(pos>=0){
                vcont.getBtncargar().setEnabled(true);
                vcont.getBtnborrar().setEnabled(true);
            }else{
                vcont.getBtncargar().setEnabled(true);
                vcont.getBtnborrar().setEnabled(false);
            }
        }else{
            msj.mcomparacionincorrecta("El servicio no se encuentra registrado","Servicio no registrado");
        }
    }
    public void cancelarServicio(){
        vcont.getBtnconsultars().setEnabled(true);
        vcont.getTxtcodigos().setText("");
        vcont.getTxtcodigos().setEditable(true);
        vcont.getTxtnombres().setText("");
        vcont.getTxtnombres().setEditable(false);
        vcont.getTxtcantidadcs().setText("");
        vcont.getTxtcantidadcs().setEditable(false);
        vcont.getBtncargar().setEnabled(false);
        vcont.getBtnborrar().setEnabled(false);
    }
    public boolean validarcargarContrato(){
        boolean validado=false;
        if(vcont.getRdtc24().isSelected()){
            if(mcont.buscarDServ("vid")==-1 && mcont.buscarDServ("vin")==-1 && (!vcont.getTxtcodigos().getText().equalsIgnoreCase("vid") && !vcont.getTxtcodigos().getText().equalsIgnoreCase("vin"))){
                msj.mcomparacionincorrecta("Primero debe registrar los servicios vid= vigilancia diurna y vin=vigilancia nocturna para registrar el servicio opcional","Sin servicios prioritarios");
            }else if(mcont.buscarDServ("vid")==-1 && (!vcont.getTxtcodigos().getText().equalsIgnoreCase("vid") && !vcont.getTxtcodigos().getText().equalsIgnoreCase("vin"))){
                msj.mcomparacionincorrecta("Primero debe registrar los servicios vid= vigilancia diurna para registrar el servicio opcional","Sin servicios prioritarios");
            }else if(mcont.buscarDServ("vin")==-1 && (!vcont.getTxtcodigos().getText().equalsIgnoreCase("vid") && !vcont.getTxtcodigos().getText().equalsIgnoreCase("vin"))){
                msj.mcomparacionincorrecta("Primero debe registrar los servicios vin=vigilancia nocturna para registrar el servicio opcional","Sin servicios prioritarios");
            }else{
                int cantidadvigmax=0,poss,aux1=-1,aux2=-1;
                poss=mcont.buscarDServ("vid");
                if(poss>-1){
                    aux1=mcont.getMDCon(poss).getCantidadc();
                }
                
                poss=mcont.buscarDServ("vin");
                if(poss>-1){
                    aux2=mcont.getMDCon(poss).getCantidadc();
                }
                
                if(aux2>aux1){
                    cantidadvigmax=aux2;
                }else{
                    cantidadvigmax=aux1;
                }
                if(vcont.getTxtcodigos().getText().equalsIgnoreCase("rad")){
                    
                    if(Integer.parseInt(vcont.getTxtcantidadcs().getText())<2){
                        msj.mcomparacionincorrecta("Debe ingresar un minimo de dos radios","Limite Inaceptable");
                    }else if(Integer.parseInt(vcont.getTxtcantidadcs().getText())>cantidadvigmax){
                        msj.mcomparacionincorrecta("Debe ingresar un maximo radios de: "+cantidadvigmax,"Limite Inaceptable");
                    }else{
                        validado=true;
                    }
                }else if(vcont.getTxtcodigos().getText().equalsIgnoreCase("bic")){
                    if(Integer.parseInt(vcont.getTxtcantidadcs().getText())<1){
                        msj.mcomparacionincorrecta("Debe ingresar una bicicleta minima","Limite Inaceptable");
                    }else if(Integer.parseInt(vcont.getTxtcantidadcs().getText())>cantidadvigmax){
                        msj.mcomparacionincorrecta("Debe ingresar un maximo bicicletas de: "+cantidadvigmax,"Limite Inaceptable");
                    }else{
                        validado=true;
                    }
                }else{
                    if(Integer.parseInt(vcont.getTxtcantidadcs().getText())<1){
                        msj.mcomparacionincorrecta("Debe ingresar al menos 1 candidad del concepto del servicio","Limite Inaceptable");
                    }else{
                        validado=true;
                    }
                }
                
            }
        }else{
            if(Integer.parseInt(vcont.getTxtcodigos().getText())<1){
                msj.mcomparacionincorrecta("Debe ingresar al menos 1 candidad del concepto del servicio","Limite Inaceptable");
            }else{
                validado=true;
            }
        }
        return validado;
    }
    //para validar la nomina
    public int validarContrato(){
        int enc=0;
        if(mcont.buscarDServ("vid")<0 && mcont.buscarDServ("vin")<0){
            enc=1;
        }else if(mcont.buscarDServ("vid")<0 ){
            enc=2;
        }else if(mcont.buscarDServ("vin")<0){
            enc=3;
        }
        return enc;
    }
    public void cargarServicio() {
        MDContrato auxmdc = new MDContrato();
        auxmdc.setNumeroc(Integer.parseInt(vcont.getTxtnumeroc().getText()));
        auxmdc.setCodigos(vcont.getTxtcodigos().getText());
        auxmdc.setCantidadc(Integer.parseInt(vcont.getTxtcantidadcs().getText()));
        auxmdc.setStatusdc("A");
        int pos=mcont.buscarDServ(vcont.getTxtcodigos().getText());
        if(pos<0){
            mcont.cargarMDCon(auxmdc);
        }else{
            mcont.setMDCon(auxmdc,pos);
        }
        cargarTabla();
        if(mcont.calcCantMDCon()>0){
            vcont.getBtnregistrar().setEnabled(true);
        }else{
            vcont.getBtnregistrar().setEnabled(false);
        }
        vcont.removerServicio();//esto es para agregar otros ervicio nuevo
    }
   
    public void removerServicio(){
        int pos=mcont.buscarDServ(vcont.getTxtcodigos().getText());
        if(pos>=0){
            mcont.borrarMDCon(pos);
        }
        if(mcont.calcCantMDCon()>0){
            vcont.getBtnregistrar().setEnabled(true);
        }else{
            vcont.getBtnregistrar().setEnabled(false);
        }
        vcont.removerServicio();//esto es para agregar otros ervicio nuevo el manejo de la vista
        cargarTabla();
    }
    public void registrar(){
        MContrato auxmcont = new MContrato();
        auxmcont.setNumeroc(Integer.parseInt(vcont.getTxtnumeroc().getText()));
        if(auxmcont.consultar()){
            //aqui va el codigo en caso de que quieran actualizar los vigiliantes contratados
        }else{
            boolean enc=false;
            if(vcont.getRdtc12().isSelected()){
                if(mcont.buscarDServ("vid")<0){
                    msj.mcomparacionincorrecta("Debe registrar el servicio obligatorio de codigo vid: vigilancia diurna para registrar el contrato","Sin vigilancia");
                }else{
                    enc=true;
                }
            }else{
                if(mcont.buscarDServ("vid")<0 && mcont.buscarDServ("vin")<0){
                    msj.mcomparacionincorrecta("Debe registrar los servicio obligatorios de codigo vid: vigilancia diurna y vin: vigilancia nocturna para registrar el contrato","Sin vigilancia");
                }else if(mcont.buscarDServ("vid")<0){
                    msj.mcomparacionincorrecta("Debe registrar el servicio obligatorio de codigo vid: vigilancia diurna para registrar el contrato","Sin vigilancia");
                }else if(mcont.buscarDServ("vin")<0){
                    msj.mcomparacionincorrecta("Debe registrar el servicio obligatorio de codigo vin: vigilancia nocturna para registrar el contrato","Sin vigilancia");
                }else{
                    enc=true;
                }
            }
            if(enc){
                registraContrato();
                registratDContrato();
            }
        }
        vcont.getBtnregistrar().setEnabled(false);
        vcont.getBtnimprimir().setEnabled(true);
        //vcont.sinregistro();
    }
    public void registraContrato(){
        mcont.setNumeroc(Integer.parseInt(vcont.getTxtnumeroc().getText()));
        mcont.setFechaec(vcont.getTxtfecha().getText());
        mcont.setHoraec(vcont.getTxthora().getText());
        mcont.setFechaic(vcont.getTxtfechad().getText());
        mcont.setFechacc(vcont.getTxtfechah().getText());
        if(vcont.getRdtc12().isSelected()){
            mcont.setCodigotc("12");
        }else if(vcont.getRdtc24().isSelected()){
            mcont.setCodigotc("24");
        }
        mcont.setRifc(vcont.getTxtrif().getText());
        if(mcont.agregar()){
            msj.mregistrado();
        }
    }
    
    public void registratDContrato(){
        //porque ya lo cargue en el vector interno del modelo contrato no es necesario un vector en el CONTROLADOR
        //ESTO ES PROGRAMACION 1 YA ESTO LO DEBES SABER
        for(int i =0; i<mcont.calcCantMDCon(); i++){
            mcont.getMDCon(i).agregar();
        }
    }
    
    public void buscarContrato(){
            mcont= new MContrato(); // DEBES GENERAR UN NUEVO ESPACIO
            mcont.setNumeroc(Integer.parseInt(vcont.getTxtbuscar().getText()));
            if(mcont.consultar()){
                mcont.cargarListaContrato();
                vcont.getTxtnumeroc().setText(Integer.toString(mcont.getNumeroc()));
                vcont.getTxtfecha().setText(mcont.getFechaec());
                vcont.getTxthora().setText(mcont.getHoraec());
                vcont.getTxtfechad().setText(mcont.getFechaic());
                vcont.getTxtfechah().setText(mcont.getFechacc());
                mcont.getMcli().setRif(mcont.getRifc());
                if(mcont.getMcli().consultar()){
                    vcont.getTxtrif().setText(mcont.getMcli().getRif());
                    vcont.getTxtnombrecli().setText(mcont.getMcli().getNombre());
                }
                if(mcont.getCodigotc().equalsIgnoreCase("12")){
                    vcont.getRdtc12().setSelected(true);
                }else{
                    vcont.getRdtc24().setSelected(true);
                }
                int i=0;
                cargarTabla();
                vcont.encregistro();
            }else{
                msj.minformando("Contrato no registrado");
            }
        
    }
    public void cargarTabla(){
        int i=0;
        limpiarTabla();
        double acum=0;
        while(i<mcont.calcCantMDCon()){
            mcont.getMDCon(i).getMs().setCodigo(mcont.getMDCon(i).getCodigos());
            vcont.getTbdetalle().setValueAt(mcont.getMDCon(i).getCodigos(), i, 0);
            if(mcont.getMDCon(i).getMs().consultar()){
                System.out.println("El nombre"+mcont.getMDCon(i).getMs().getNombre());
                vcont.getTbdetalle().setValueAt(mcont.getMDCon(i).getMs().getNombre(), i, 1);
                acum+=mcont.getMDCon(i).getMs().getPrecio();
            }
            vcont.getTbdetalle().setValueAt(mcont.getMDCon(i).getCantidadc(), i, 2);
            i++;
        }
        vcont.getTxtsubtotal().setText(String.valueOf(acum));
        vcont.getTxtsubtotaliva().setText(String.valueOf(acum*0.12));
        vcont.getTxttotal().setText(String.valueOf(acum+(acum*0.12)));
    }
    public void limpiarTabla(){
        int i=0;
        while(i<5){
            vcont.getTbdetalle().setValueAt("", i, 0);
            vcont.getTbdetalle().setValueAt("", i, 1);
            vcont.getTbdetalle().setValueAt("", i, 2);
            i++;
        }
       /* int i=0;     
        while (i <tabla.getRowCount()) {
           tb.removeRow(i);
        }
        tb.addRow(new Object[]{"", "",""});*/
    }
    
    public void cancelar(){
        vcont.sinregistro();
        limpiarTabla();
    }
       
    public void salir(){
        vcont.sinregistro();
        vcont.dispose();
        cmenu.setAcontrato(false);
    }
}
