/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import generales.Fecha;
import generales.Matematica;
import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.MConcepto;
import modelos.MDNomina;
import modelos.MEmpresa;
import modelos.MNomina;
import vistas.VNomina;

public class CNomina implements ActionListener  {
    private VNomina vnom;
    private CEmpresa cmenu;
    private MNomina mnomina;
    private Mensajes msj;
    private Fecha fe = new Fecha();
    public CNomina(CEmpresa cmenu) {
        vnom= new VNomina(cmenu.getVmenu(),false,this);
        vnom.setLocationRelativeTo(null);
        vnom.setResizable(false);
        vnom.setVisible(true);	
        vnom.agregarListener(this);
        vnom.setTitle("NOMINA");
        vnom.agregarListener(cmenu);
        vnom.sinregistro();
        this.cmenu=cmenu;
        mnomina = new MNomina();
        msj = new Mensajes();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vnom.getRdsemanal())){
            vnom.getRdmensual().setSelected(false);
        }
        if(e.getSource().equals(vnom.getRdmensual())){
            vnom.getRdsemanal().setSelected(false);
        }
        //buscar nomina
        if(e.getSource().equals(vnom.getBtnbuscar())){
            if("".equals(vnom.getTxtbuscar().getText())){
                msj.mvacio("Ingrese el numero de nomina", "Numero de nomina Vacio",vnom.getTxtbuscar());
            }else{
                buscarNomina(); 
            }
        }
        //generar numero de nomina
        if(e.getSource().equals(vnom.getBtngenerar())){
            generarNroNomina();
        }
        //registrar la nomina
        if(e.getSource().equals(vnom.getBtnregistrar())){
            if(validarNomina()==1){
                msj.mcomparacionincorrecta("Debe registrar los conceptos he: horas extras, dt: dias trabajados, dnti: dias no trabajados","Conceptos obligatorios");
            }else if(validarNomina()==2){
                msj.mcomparacionincorrecta("Debe registrar los conceptos he: horas extras,dt: dias trabajados","Conceptos obligatorios");
            }else if(validarNomina()==3){
                msj.mcomparacionincorrecta("Debe registrar los conceptos dt: dias trabajados, dnti: dias no trabajados","Conceptos obligatorios");
            }else if(validarNomina()==4){
                msj.mcomparacionincorrecta("Debe registrar los conceptos he: horas extras, dnti: dias no trabajados","Conceptos obligatorios");
            }else if(validarNomina()==5){
                msj.mcomparacionincorrecta("Debe registrar los conceptos dt: dias trabajados","Conceptos obligatorios");
            }else if(validarNomina()==6){
                msj.mcomparacionincorrecta("Debe registrar los conceptos dnti: dias no trabajados","Conceptos obligatorios");
            }else if(validarNomina()==7){
                msj.mcomparacionincorrecta("Debe registrar los conceptos he: horas extras","Conceptos obligatorios");
            }else{
                registrar();
            }
        }
        //imprimir la nomina
        if(e.getSource().equals(vnom.getBtnimprimir())){
            msj.mcomparacionincorrecta("Accion no implementada","En construccion");
        }
        //cancelar la nomina
        if(e.getSource().equals(vnom.getBtncancelar())){
            cancelar();
        }
        //salir de la nomina
        if(e.getSource().equals(vnom.getBtnsalir())){
            salir();
        }
        //Buscando el empleado
        if(e.getSource().equals(vnom.getBtnverificare())){
            if(!vnom.getRdsemanal().isSelected() && !vnom.getRdmensual().isSelected()){
                msj.mvacio("Seleccione el tipo de nomina semanal o mensual", "Seleccione el tipo de nomina", vnom.getTxtcantidadc());
            }else if(vnom.getTxtfechadn().getText().equalsIgnoreCase("")){
                msj.mvacio("Debe ingresar una fecha de inicio para la nomina", "Fecha Vacio",vnom.getTxtfechadn());
            }else if(!fe.isFechaValida(vnom.getTxtfechadn().getText())){
                msj.mvacio("Por favor ingrese una Fecha de inicio valida DD-MM-AAAA","Fecha Invalidad",vnom.getTxtfechadn());
            }else if(vnom.getTxtcedulae().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese la cedula del empleado para buscar", "Cedula del empleado",vnom.getTxtcedulae());
            }else{
                if(vnom.getRdsemanal().isSelected()){
                    sumarFecha(6);
                }
                if(vnom.getRdmensual().isSelected()){
                    sumarFecha(29);
                }
                buscarEmpleado();
            }
        }
        //Cancelando el empleado
        if(e.getSource().equals(vnom.getBtncancelare())){
            vnom.removerEmpleado();
        }
        //Buscando el concepto
        if(e.getSource().equals(vnom.getBtnverificarc())){
            if(vnom.getTxtcedulae().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese la cedula del empleado para buscar", "Cedula Vacio",vnom.getTxtcedulae());
            }else if(vnom.getTxtcodigoc().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese El Codigo del concepto", "Codigo Vacio", vnom.getTxtcodigoc());
            }else{
                buscarConcepto();
            }
        }
        //cancelando el concepto
        if(e.getSource().equals(vnom.getBtncancelarc())){
            cancelarConcepto();
        }
        //cargango el concepto
        if(e.getSource().equals(vnom.getBtncargar())){
            if(Integer.parseInt(vnom.getTxtcantidadc().getText())<0){
                msj.mvacio("Ingrese la Cantidad Solicitada del concepto mayor o igual a 0", "Cantidad Solicitada", vnom.getTxtcantidadc());
            }else if(vnom.getTxtcantidadc().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese la Cantidad Solicitada del concepto", "Cantidad Solicitada", vnom.getTxtcantidadc());
            }else if(!vnom.getRdsemanal().isSelected() && !vnom.getRdmensual().isSelected()){
                msj.mvacio("Seleccione el tipo de nomina semanal o mensual", "Seleccione el tipo de nomina", vnom.getTxtcantidadc());
            }else if(vnom.getRdsemanal().isSelected()){
                if(Integer.parseInt(vnom.getTxtcantidadc().getText())>5 && vnom.getTxtcodigoc().getText().equalsIgnoreCase("dt")){
                    msj.mcomparacionincorrecta("La cantidad maxima permitida para ingresar de dias trabajados es de 5 los otros 2 son de descanso","Limite exedido");
                }else{
                    cargarConcepto();
                }
            }else{
                if(Integer.parseInt(vnom.getTxtcantidadc().getText())>22 && vnom.getTxtcodigoc().getText().equalsIgnoreCase("dt")){
                    msj.mcomparacionincorrecta("La cantidad maxima permitida para ingresar de dias trabajados es de 22 los otros 8 dias son de descanso","Limite exedido");
                }else{
                    cargarConcepto();
                }
            }
        }
        //borrando el concepto
        if(e.getSource().equals(vnom.getBtnborrar())){
            removerConcepto();
        }
    }
    
    //para validar la nomina
    public int validarNomina(){
        int enc=0;
        if(mnomina.buscarDConcepto("het")<0 && mnomina.buscarDConcepto("dt")<0 && mnomina.buscarDConcepto("dnti")<0){
            enc=1;
        }else if(mnomina.buscarDConcepto("het")<0 && mnomina.buscarDConcepto("dt")<0){
            enc=2;
        }else if(mnomina.buscarDConcepto("dnti")<0 && mnomina.buscarDConcepto("dt")<0){
            enc=3;
        }else if(mnomina.buscarDConcepto("het")<0 && mnomina.buscarDConcepto("dnti")<0){
            enc=4;
        }else if(mnomina.buscarDConcepto("dt")<0){
            enc=5;
        }else if(mnomina.buscarDConcepto("dnti")<0){
            enc=6;
        }else if(mnomina.buscarDConcepto("het")<0){
            enc=7;
        }
        return enc;
    }
    
    
    //suma la cantida de dias ingresados por parametro
    public void sumarFecha(int dias){
        String fecha= vnom.getTxtfechadn().getText();
        fecha=fe.deFechaaString(fe.sumarFechasDias(fe.deStringaFecha(fecha), dias));
        vnom.getTxtfechahn().setText(fecha);
    }
    //genera el numero de nomina
    public final void generarNroNomina(){
        mnomina = new MNomina();
        // el numero de nomina debe generarse internamente en el metodo generar numero de nomina
        vnom.getTxtnumeron().setText(String.valueOf(mnomina.generarNumeroNomina()));
        vnom.getTxtfechan().setText(fe.getFechalatina());
        vnom.getTxthoran().setText(fe.getHoraactual());
        vnom.nrogenerado();
    }
    //busca el empleado
    public void buscarEmpleado(){
        mnomina.getMe().setCedula(vnom.getTxtcedulae().getText());
        if(mnomina.getMe().consultar()){
            vnom.getTxtnombree().setText(mnomina.getMe().getNombre());
            vnom.getTxtapellidoe().setText(mnomina.getMe().getApellido());
            mnomina.getMe().getMcarg().setCodigoc(mnomina.getMe().getCodigoc());
            if(mnomina.getMe().getMcarg().consultar()){
                vnom.getTxtsueldobme().setText(String.valueOf(mnomina.getMe().getMcarg().getSueldomc()));
            }
            vnom.encontradoEmpleado();
        }else{
            msj.mnencontrado();
        }
    }
    public void buscarConcepto(){//het dt dnti dntj
        MConcepto mconcepto = new MConcepto();
        mconcepto.setCodigo(vnom.getTxtcodigoc().getText());
        if(mconcepto.consultar()){
            vnom.getTxtnombrec().setText(mconcepto.getNombre());
            vnom.encontradoConcepto();
            int pos=mnomina.buscarDConcepto(mconcepto.getCodigo());
            if(pos>=0){
                vnom.getBtncargar().setEnabled(true);
                vnom.getBtnborrar().setEnabled(true);
            }else{
                vnom.getBtncargar().setEnabled(true);
                vnom.getBtnborrar().setEnabled(false);
            }
        }else{
            msj.mcomparacionincorrecta("El concepto no se encuentra registrado","Concepto no registrado");
        }
    }
    public void cancelarConcepto(){
        vnom.removerConcepto();
    }
    public void cargarConcepto() {
        Matematica mat = new Matematica();
        MDNomina auxmdn = new MDNomina();
        MEmpresa mempre = new MEmpresa();
        auxmdn.setNumeron(Integer.parseInt(vnom.getTxtnumeron().getText()));
        auxmdn.setCodigoc(vnom.getTxtcodigoc().getText());
        auxmdn.setCantidadn(Integer.parseInt(vnom.getTxtcantidadc().getText()));
        auxmdn.setStatusdn("A");
        double total=0;
        if(vnom.getRdsemanal().isSelected()){// para el caso semanal
            if(auxmdn.getCodigoc().equalsIgnoreCase("het")){//horas extras
                auxmdn.setValorn(mat.redondear(mempre.calcValorhet(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
            }else if(auxmdn.getCodigoc().equalsIgnoreCase("dnti")){
                auxmdn.setValorn(mat.redondear(mempre.calcValorsd(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                int poss=mnomina.buscarDConcepto(vnom.getTxtcodigoc().getText());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn);
                }else{
                    mnomina.setMDNom(auxmdn,poss);
                }
                MDNomina auxmdn2 = new MDNomina();
                auxmdn2.setNumeron(auxmdn.getNumeron());
                auxmdn2.setCodigoc("dt");
                auxmdn2.setCantidadn((5-auxmdn.getCantidadn())+2);
                auxmdn2.setValorn(auxmdn.getValorn());
                auxmdn2.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn2.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn2);
                }else{
                    mnomina.setMDNom(auxmdn2,poss);
                }
                MDNomina auxmdn3 = new MDNomina();
                auxmdn3.setNumeron(auxmdn.getNumeron());
                auxmdn3.setCodigoc("het");
                auxmdn3.setCantidadn(5*(auxmdn2.getCantidadn()-2));
                auxmdn3.setValorn(mat.redondear(mempre.calcValorhet(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                auxmdn3.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn3.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn3);
                }else{
                    mnomina.setMDNom(auxmdn3,poss);
                }
            }else if(auxmdn.getCodigoc().equalsIgnoreCase("dt")){
                auxmdn.setValorn(mat.redondear(mempre.calcValorsd(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                int poss=mnomina.buscarDConcepto(vnom.getTxtcodigoc().getText());
                auxmdn.setCantidadn(auxmdn.getCantidadn()+2);
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn);
                }else{
                    mnomina.setMDNom(auxmdn,poss);
                }
                MDNomina auxmdn2 = new MDNomina();
                auxmdn2.setNumeron(auxmdn.getNumeron());
                auxmdn2.setCodigoc("dnti");
                auxmdn2.setCantidadn((7-auxmdn.getCantidadn()));
                auxmdn2.setValorn(auxmdn.getValorn());
                auxmdn2.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn2.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn2);
                }else{
                    mnomina.setMDNom(auxmdn2,poss);
                }
                MDNomina auxmdn3 = new MDNomina();
                auxmdn3.setNumeron(auxmdn.getNumeron());
                auxmdn3.setCodigoc("het");
                auxmdn3.setCantidadn(5*(auxmdn.getCantidadn()-2));
                auxmdn3.setValorn(mat.redondear(mempre.calcValorhet(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                auxmdn3.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn3.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn3);
                }else{
                    mnomina.setMDNom(auxmdn3,poss);
                }
            }
        }else{//para el caso mensual
            if(auxmdn.getCodigoc().equalsIgnoreCase("het")){//horas extras
                auxmdn.setValorn(mat.redondear(mempre.calcValorhet(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
            }else if(auxmdn.getCodigoc().equalsIgnoreCase("dnti")){
                auxmdn.setValorn(mat.redondear(mempre.calcValorsd(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                int poss=mnomina.buscarDConcepto(vnom.getTxtcodigoc().getText());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn);
                }else{
                    mnomina.setMDNom(auxmdn,poss);
                }
                MDNomina auxmdn2 = new MDNomina();
                auxmdn2.setNumeron(auxmdn.getNumeron());
                auxmdn2.setCodigoc("dt");
                auxmdn2.setCantidadn((22-auxmdn.getCantidadn())+8);
                auxmdn2.setValorn(auxmdn.getValorn());
                auxmdn2.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn2.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn2);
                }else{
                    mnomina.setMDNom(auxmdn2,poss);
                }
                MDNomina auxmdn3 = new MDNomina();
                auxmdn3.setNumeron(auxmdn.getNumeron());
                auxmdn3.setCodigoc("het");
                auxmdn3.setCantidadn(5*(auxmdn2.getCantidadn()-8));
                auxmdn3.setValorn(mat.redondear(mempre.calcValorhet(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                auxmdn3.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn3.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn3);
                }else{
                    mnomina.setMDNom(auxmdn3,poss);
                }
            }else if(auxmdn.getCodigoc().equalsIgnoreCase("dt")){
                auxmdn.setValorn(mat.redondear(mempre.calcValorsd(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                int poss=mnomina.buscarDConcepto(vnom.getTxtcodigoc().getText());
                auxmdn.setCantidadn(auxmdn.getCantidadn()+8);
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn);
                }else{
                    mnomina.setMDNom(auxmdn,poss);
                }
                MDNomina auxmdn2 = new MDNomina();
                auxmdn2.setNumeron(auxmdn.getNumeron());
                auxmdn2.setCodigoc("dnti");
                auxmdn2.setCantidadn((30-auxmdn.getCantidadn()));
                auxmdn2.setValorn(auxmdn.getValorn());
                auxmdn2.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn2.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn2);
                }else{
                    mnomina.setMDNom(auxmdn2,poss);
                }
                MDNomina auxmdn3 = new MDNomina();
                auxmdn3.setNumeron(auxmdn.getNumeron());
                auxmdn3.setCodigoc("het");
                auxmdn3.setCantidadn(5*(auxmdn.getCantidadn()-8));
                auxmdn3.setValorn(mat.redondear(mempre.calcValorhet(Double.parseDouble(vnom.getTxtsueldobme().getText()))));
                auxmdn3.setStatusdn("A");
                poss=mnomina.buscarDConcepto(auxmdn3.getCodigoc());
                if(poss<0){
                    mnomina.cargarMDNom(auxmdn3);
                }else{
                    mnomina.setMDNom(auxmdn3,poss);
                }
            }
        }
        int pos=mnomina.buscarDConcepto(vnom.getTxtcodigoc().getText());
        if(pos<0){
            mnomina.cargarMDNom(auxmdn);
        }else{
            mnomina.setMDNom(auxmdn,pos);
        }
        cargarTabla();
        if(mnomina.calcCantMDNom()>0){
            vnom.getBtnregistrar().setEnabled(true);
        }else{
            vnom.getBtnregistrar().setEnabled(false);
        }
        vnom.getBtncancelare().setEnabled(false);
        vnom.removerConcepto();//esto es para agregar otros servicio nuevo
    }
   
    public void removerConcepto(){
        int pos=mnomina.buscarDConcepto(vnom.getTxtcodigoc().getText());
        if(pos>=0){
            mnomina.borrarMDNom(pos);
        }
        if(mnomina.calcCantMDNom()>0){
            vnom.getBtnregistrar().setEnabled(true);
        }else{
            vnom.getBtncancelare().setEnabled(true);
            vnom.getBtnregistrar().setEnabled(false);
        }
        vnom.removerConcepto();//esto es para agregar otros ervicio nuevo el manejo de la vista
        cargarTabla();
    }
    public void registrar(){
        MNomina auxmcont = new MNomina();
        auxmcont.setNumeron(Integer.parseInt(vnom.getTxtnumeron().getText()));
        if(auxmcont.consultar()){
            //aqui va el codigo en caso de que quieran actualizar los vigiliantes contratados
        }else{
            registraNomina();
            registratDNomina();
        }
        vnom.getBtnregistrar().setEnabled(false);
        vnom.getBtnimprimir().setEnabled(true);
        //vcont.sinregistro();
    }
    public void registraNomina(){
        Matematica mat = new Matematica();
        MEmpresa mempre = new MEmpresa();
        mnomina.setNumeron(Integer.parseInt(vnom.getTxtnumeron().getText()));
        mnomina.setFechaen(vnom.getTxtfechan().getText());
        mnomina.setHoraen(vnom.getTxthoran().getText());
        mnomina.setFechain(vnom.getTxtfechadn().getText());
        mnomina.setFechacn(vnom.getTxtfechahn().getText());
        mnomina.setCedulae(vnom.getTxtcedulae().getText());
        mnomina.setSueldomn(mat.redondear(Double.parseDouble(vnom.getTxtsueldobme().getText())));
        mnomina.setStatusn("A");
        if(mnomina.agregar()){
            msj.mregistrado();
        }
    }
    
    public void registratDNomina(){
        for(int i =0; i<mnomina.calcCantMDNom(); i++){
            mnomina.getMDNom(i).agregar();
        }
    }
    public void buscarNomina(){
        mnomina= new MNomina(); // DEBES GENERAR UN NUEVO ESPACIO
        mnomina.setNumeron(Integer.parseInt(vnom.getTxtbuscar().getText()));
        if(mnomina.consultar()){
            mnomina.cargarListaNomina();
            vnom.getTxtnumeron().setText(Integer.toString(mnomina.getNumeron()));
            vnom.getTxtfechan().setText(mnomina.getFechaen());
            vnom.getTxthoran().setText(mnomina.getHoraen());
            vnom.getTxtfechadn().setText(mnomina.getFechain());
            vnom.getTxtfechahn().setText(mnomina.getFechacn());
            mnomina.getMe().setCedula(mnomina.getCedulae());
            int dias =fe.diferenciasDeFechas(fe.deStringaFecha(mnomina.getFechain()),fe.deStringaFecha(mnomina.getFechacn()));
            System.out.println(dias);
            if(dias>=22){
                vnom.getRdsemanal().setSelected(false);
                vnom.getRdmensual().setSelected(true);
            }else if(dias>=1 && dias<=7){
                vnom.getRdsemanal().setSelected(true);
                vnom.getRdmensual().setSelected(false);
            }
            if(mnomina.getMe().consultar()){
                vnom.getTxtcedulae().setText(mnomina.getMe().getCedula());
                vnom.getTxtnombree().setText(mnomina.getMe().getNombre());
                vnom.getTxtapellidoe().setText(mnomina.getMe().getApellido());
            }
            vnom.getTxtsueldobme().setText(String.valueOf(mnomina.getSueldomn()));
            cargarTabla();
            vnom.encregistro();
        }else{
            msj.minformando("Nomina no registrado");
        }
    }
    public void cargarTabla(){
        Matematica mat = new Matematica();
        MEmpresa mempre= new MEmpresa();
        int i=0;
        limpiarTabla();
        double acuma=0,acumd=0;
        while(i<mnomina.calcCantMDNom()){
            mnomina.getMDNom(i).getMconcepto().setCodigo(mnomina.getMDNom(i).getCodigoc());
            vnom.getTbdetalle().setValueAt(mnomina.getMDNom(i).getCodigoc(), i, 0);//imprime el codigo del concepto
            if(mnomina.getMDNom(i).getMconcepto().consultar()){//busca el concepto para capturar su comparacion
                vnom.getTbdetalle().setValueAt(mnomina.getMDNom(i).getMconcepto().getNombre(), i, 1);//imprime el nombre del concepto
                if(mnomina.getMDNom(i).getMconcepto().getCodigotc().equalsIgnoreCase("as")){//compara si es de asignacion
                    double total=mnomina.getMDNom(i).getCantidadn()*mnomina.getMDNom(i).getValorn();
                    acuma+=total;
                    vnom.getTbdetalle().setValueAt("Asignacion", i, 4);// dice que es asignacion
                    vnom.getTbdetalle().setValueAt(mat.redondear(total), i, 5);//imprime el subtotal
                }else{
                    double total=mnomina.getMDNom(i).getCantidadn()*mnomina.getMDNom(i).getValorn();
                    acumd+=total;
                    vnom.getTbdetalle().setValueAt("Deduccion", i, 4);
                    vnom.getTbdetalle().setValueAt(mat.redondear(total), i, 5);//imprime el subtotal
                }
            }
            vnom.getTbdetalle().setValueAt(mnomina.getMDNom(i).getCantidadn(), i, 2);
            vnom.getTbdetalle().setValueAt(mnomina.getMDNom(i).getValorn(), i, 3);
            i++;
        }
        vnom.getTxttasignaciones().setText(String.valueOf(mat.redondear(acuma)));
        vnom.getTxttdeducciones().setText(String.valueOf(mat.redondear(acumd)));
        vnom.getTxttsueldonp().setText(String.valueOf(mat.redondear(acuma-acumd)));
    }
    public void limpiarTabla(){
        int i=0;
        while(i<5){
            vnom.getTbdetalle().setValueAt("", i, 0);
            vnom.getTbdetalle().setValueAt("", i, 1);
            vnom.getTbdetalle().setValueAt("", i, 2);
            vnom.getTbdetalle().setValueAt("", i, 3);
            vnom.getTbdetalle().setValueAt("", i, 4);
            vnom.getTbdetalle().setValueAt("", i, 5);
            i++;
        }
        /* int i=0;     
        while (i <tabla.getRowCount()) {
           tabla.removeRow(i);
        }
        tabla.addRow(new Object[]{"", "",""});*/
    }
    
    public void cancelar(){
        vnom.sinregistro();
        limpiarTabla();
    }
       
    public void salir(){
        vnom.sinregistro();
        vnom.dispose();
        cmenu.setAnomina(false);
    }
    
}
