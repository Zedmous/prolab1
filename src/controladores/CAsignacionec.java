
package controladores;

import generales.Fecha;
import generales.Matematica;
import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import modelos.MAsignacionec;
import modelos.MContrato;
import modelos.MEmpleado;
import modelos.MEmpresa;
import vistas.VAsignacionec;


public class CAsignacionec  implements ActionListener {
    private CEmpresa cmenu;
    private Mensajes msj = new Mensajes();
    private Fecha fe= new Fecha();
    private MEmpresa memp;
    private VAsignacionec vct;
    private MAsignacionec masig= new MAsignacionec();
    public CAsignacionec(CEmpresa cmenu){
        vct= new VAsignacionec(cmenu.getVmenu(),false,this);
        vct.setLocationRelativeTo(null);
        vct.setResizable(false);
        vct.setVisible(true);	
        vct.agregarListener(this);
        vct.setTitle("CONTROL DE TURNOS");
        vct.sinregistro();
        this.cmenu=cmenu;
        memp=new MEmpresa();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getActionCommand().equalsIgnoreCase("generar")){
            if(vct.getTxtfechad().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese una fecha inicial para generar los turnos","Fecha Inicial Vacia",vct.getTxtfechad());
            }else if(!fe.isFechaValida(vct.getTxtfechad().getText())){
                msj.mvacio("Por favor ingrese una fecha inicial validad ejemplo: dd-mm-aaaa","Feca Invalidad",vct.getTxtfechad());
            }else if(vct.getTxtfechah().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese una fecha final para generar los turnos","Fecha Final Vacia",vct.getTxtfechah());
            }else if(!fe.isFechaValida(vct.getTxtfechah().getText())){
                msj.mvacio("Por favor ingrese una fecha final validad ejemplo: dd-mm-aaaa","Feca Invalidad",vct.getTxtfechah());
            }else if(fe.fechaesmenoroigualafecha(fe.deStringaFecha(fe.getFechalatina()),fe.deStringaFecha(vct.getTxtfechad().getText()))){
                msj.mvacio("La fecha inicial debe ser mayor o igual a la fecha actual","Fechas Invalidas",vct.getTxtfechad());
            }else if(fe.fechaesmenoroigualafecha(fe.deStringaFecha(vct.getTxtfechad().getText()),fe.deStringaFecha(vct.getTxtfechah().getText()))){
                msj.mvacio("La fecha inicial debe ser menor o igual a la fecha final","Fechas Invalidas",vct.getTxtfechad());
            }else{
                generarTurnoDH();
            }
        }
        if(a.getActionCommand().equalsIgnoreCase("seleccionar")){
            if(vct.getTxtfechav().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese una fecha para verificar el status","Fecha de Verificacion Vacia",vct.getTxtfechav());
            }else if(!fe.isFechaValida(vct.getTxtfechav().getText())){
                msj.mvacio("Por favor ingrese una fecha de verificacion validad ejemplo: dd-mm-aaaa","Feca de Verificacion",vct.getTxtfechav());
            }else if(!vct.getRdempleado().isSelected()){
                System.out.println("Contrato: "+vct.getRdcontrato().isSelected());
                System.out.println("Empleado: "+vct.getRdempleado().isSelected());
                msj.mcomparacionincorrecta("Por favor seleccione el tipo de busqueda por empleado","Tipo de Busqueda");
            }else{
                System.out.println("Contrato: "+vct.getRdcontrato().isSelected());
                System.out.println("Empleado: "+vct.getRdempleado().isSelected());
                if(vct.getRdempleado().isSelected()){
                    vct.habilitarBE();
                }
            }
        }
        
        if(a.getActionCommand().equalsIgnoreCase("remover")){
           vct.sinregistro();
        }
        
        if(a.getActionCommand().equalsIgnoreCase("cancelar")){
            vct.sinregistro();
        }
        if(a.getActionCommand().equalsIgnoreCase("salir")){
            salir();
        }
        
        if(a.getActionCommand().equalsIgnoreCase("asistido")){
            asistido();
        }
        if(a.getActionCommand().equalsIgnoreCase("no asistido")){
            noasistido();
        }
        if(a.getActionCommand().equalsIgnoreCase("justificado")){
            justificado();
        }
        
        
        if(a.getActionCommand().equalsIgnoreCase("consultar e.")){
            if(vct.getTxtbuscarced().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una cedula de empleado para buscar","Cedula Vacia",vct.getTxtbuscarced());
            }else{
                buscarempl();
            }
        }
        if(a.getActionCommand().equalsIgnoreCase("consultar c.")){
            if(vct.getTxtbuscarcont().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un numero de empleado para buscar","Nro Contrato Vacio",vct.getTxtbuscarcont());
            }else{
                
            }
        }
    }
    
    public void buscarempl(){
        masig.setCedulae(vct.getTxtbuscarced().getText());
        masig.setFechaaec(vct.getTxtfechav().getText());
        if(masig.consultar()){
            vct.getTxtnumeroc().setText(String.valueOf(masig.getNumeroc()));
            vct.getTxtcedula().setText(masig.getCedulae());
            masig.getMe().setCedula(masig.getCedulae());
            if(masig.getMe().consultar()){
                vct.getTxtnombre().setText(masig.getMe().getNombre());
                vct.getTxtapellido().setText(masig.getMe().getApellido());
            }
            String obs=masig.getCodigoaec();
            if(obs.equalsIgnoreCase("as")){
                obs="Asignado";
            }else if(obs.equalsIgnoreCase("dt")){
                obs="Trabajado";
            }else if(obs.equalsIgnoreCase("dnti")){
                obs="No trabajado injustificado";
            }else if(obs.equalsIgnoreCase("dntj")){
                obs="No trabajado justificado";
            }
            if(masig.getCodigot().equalsIgnoreCase("d")){
                obs+=" "+"Dia";
            }else{
                obs+=" "+"Noche";
            }
            vct.bloquearAsignado();
            vct.getTxtobservacion().setText(obs);
            msj.mencontrado();
        }else{
            msj.mnoencontrado();
        }
    }
    public void asistido(){
        masig.setCedulae(vct.getTxtcedula().getText());
        masig.setNumeroc(Integer.parseInt(vct.getTxtnumeroc().getText()));
        masig.setFechaaec(vct.getTxtfechav().getText());
        masig.setCodigoeaec("dt");
        masig.modificar();
        msj.mactualizado();
        vct.sinregistro();
    }
    public void justificado(){
        masig.setCedulae(vct.getTxtcedula().getText());
        masig.setNumeroc(Integer.parseInt(vct.getTxtnumeroc().getText()));
        masig.setFechaaec(vct.getTxtfechav().getText());
        masig.setCodigoeaec("dntj");
        masig.modificar();
        msj.mactualizado();
        vct.sinregistro();
    }
    public void noasistido(){
        masig.setCedulae(vct.getTxtcedula().getText());
        masig.setNumeroc(Integer.parseInt(vct.getTxtnumeroc().getText()));
        masig.setFechaaec(vct.getTxtfechav().getText());
        masig.setCodigoeaec("dnti");
        masig.modificar();
        msj.mactualizado();
        vct.sinregistro();
    }
    public void generarTurnoDH(){
        if(memp.verificartangodeasgnacion(vct.getTxtfechad().getText(),vct.getTxtfechah().getText())){
            msj.minformando("No se puede generar la asignacion de empleados de turnos en el rango de fechas ingresados");
        }else{
            cargarContratos();
        }
    }
    public int verificarces(ArrayList<MContrato> lmcontr){
        int cant=0;
        int i=0;
        while(i<lmcontr.size()){
            memp.getMContr(i).cargarListaContrato();
            if(memp.getMContr(i).getCodigotc().equalsIgnoreCase("12")){
                cant+=calccantvigd(i);
            }else{
                cant+=calccantvigd(i);
                cant+=calccantvign(i);
            }
            i++;
        }
        return cant;
    }
    public void cargarContratos(){
        Matematica mat = new Matematica();
        int i=fe.diferenciasDeFechas(fe.deStringaFecha(vct.getTxtfechad().getText()),fe.deStringaFecha(vct.getTxtfechah().getText()));
        //Date d = fe.sumarFechasDias(fe.deStringaFecha(vct.getTxtfechad().getText()), 0);
        //fe.deFechaaString(d);
        String fechapos=vct.getTxtfechad().getText();
        memp.cargarContratosActivos();
        while(i>=0){//para saber cuantas fechas recorrere
            memp.cargarEmpleadosLibresdia(capturardia(fe.capturardia(fechapos)));
            ArrayList<MContrato> lmcontr;
            lmcontr=memp.getLmcontr();
            ArrayList<MEmpleado> lmem;
            lmem=memp.getLmem();
            int poscont=0;
            if(verificarces(lmcontr)>lmem.size()){
                int resto=verificarces(lmcontr)-lmem.size();
                msj.minformando("La cantida de vigilantes que solicita no es suficiente para la fecha: "+fechapos+" por favor contrate mas empleados faltan: "+resto);
            }else{
                while(poscont<memp.calcCantContratos()){//para asignar a todos los contratos
                    memp.getMContr(poscont).cargarListaContrato();
                    int cantv=0,cantvd=0,cantvn=0;
                    if(memp.getMContr(poscont).getCodigotc().equalsIgnoreCase("12")){
                        cantv=calccantvigd(poscont);
                    }else{
                        cantv=calccantvigd(poscont);
                        cantv+=calccantvign(poscont);
                    }
                    cantvd=calccantvigd(poscont);
                    cantvn=calccantvign(poscont);
                    System.out.println("la cantida de detalle diurno es: "+cantvd);
                    System.out.println("la cantida de detalle nocturno es: "+cantvn);
                    int indice;
                    while(cantv>0){//para trabajar el detalle de vigilantes del contrato
                        indice=mat.randomhastaLimite(lmem.size());
                        if(memp.getMContr(poscont).getCodigotc().equalsIgnoreCase("12")){
                            masig.setCedulae(lmem.get(indice).getCedula());
                            masig.setFechaaec(fechapos);
                            masig.setNumeroc(lmcontr.get(poscont).getNumeroc());
                            masig.setCodigoeaec("as");
                            masig.setCodigot("d");
                            cantvd--;
                        }else{
                            if(cantvd>0){
                                masig.setCedulae(lmem.get(indice).getCedula());
                                masig.setFechaaec(fechapos);
                                masig.setNumeroc(lmcontr.get(poscont).getNumeroc());
                                masig.setCodigoeaec("as");
                                masig.setCodigot("d");
                                cantvd--;
                            }else{
                                if(cantvn>0){
                                    masig.setCedulae(lmem.get(indice).getCedula());
                                    masig.setFechaaec(fechapos);
                                    masig.setNumeroc(lmcontr.get(poscont).getNumeroc());
                                    masig.setCodigoeaec("as");
                                    masig.setCodigot("n");
                                    cantvn--;
                                }
                            }
                        }
                        lmem.remove(indice);
                        cantv--;
                        if(!masig.consultar()){//si no encuentra anda relacionado al dia lo registra
                            masig.agregar();
                        }
                    }//fin del while del detalle
                    poscont++;
                }
            }//fin del else
            i--;
            Date d = fe.sumarFechasDias(fe.deStringaFecha(fechapos), 1);
            fechapos=fe.deFechaaString(d);
        }//fin del while de la fecha
        vct.sinregistro();
                
    }
    public String capturardia(int dia){
        String diasemana="";
        if(dia==0){
            diasemana="d";
        }else if(dia==1){
            diasemana="l";
        }else if(dia==2){
            diasemana="m";
        }else if(dia==3){
            diasemana="i";
        }else if(dia==4){
            diasemana="j";
        }else if(dia==5){
            diasemana="v";
        }else{
            diasemana="s";
        }
        return diasemana;
    }
    public int calccantvigd(int pos){
        int cant=0,i=0;
        while(i<memp.getMContr(pos).calcCantMDCon()){
            if(memp.getMContr(pos).getMDCon(i).getCodigos().equalsIgnoreCase("vid")){
                cant=memp.getMContr(pos).getMDCon(pos).getCantidadc();
                i=memp.getMContr(pos).calcCantMDCon();
            }
            i++;
        }
        return cant;
    }
    public int calccantvign(int pos){
        int cant=0,i=0;
        while(i<memp.getMContr(pos).calcCantMDCon()){
            if(memp.getMContr(pos).getMDCon(pos).getCodigos().equalsIgnoreCase("vin")){
                cant=memp.getMContr(pos).getMDCon(i).getCantidadc();
                i=memp.getMContr(pos).calcCantMDCon();
            }
            
            i++;
        }
        return cant;
    }
    public void salir(){
        vct.sinregistro(); 
        vct.dispose();
        cmenu.setAasignacionec(false);
    }
    
}
