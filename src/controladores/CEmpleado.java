package controladores;
import generales.Fecha;
import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import modelos.MEmpleado;
import vistas.VEmpleado;

import modelos.MCargo;
import modelos.MEmpresa;
public class  CEmpleado implements ActionListener{
    private CEmpresa cmenu;
    private final VEmpleado ve;
    private MEmpleado me;
    private Mensajes msj = new Mensajes();
    private Fecha fe= new Fecha();
    private MEmpresa memp;
    public CEmpleado(CEmpresa cmenu) {
        ve= new VEmpleado(cmenu.getVmenu(),false,this);
        ve.setLocationRelativeTo(null);
        ve.setResizable(false);
        ve.setVisible(true);	
        ve.agregarListener(this);
        ve.setTitle("EMPLEADO");
        this.cmenu=cmenu;
        memp=new MEmpresa();
        cargarCargos();
    }
    public void cargarCargos(){
        memp.cargarCargo();
        int i=0;
        ve.getCbtncargo().removeAllItems();;
        ve.getCbtncargo().addItem("Seleccione");
        while(i<memp.calcCantCargo()){
            ve.getCbtncargo().addItem(memp.getMCarg(i).getNombrec());
            i++;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Consultar")){
            if(ve.getTxtbuscar().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una cedula para buscar","Cedula Vacia",ve.getTxtbuscar());
            }else{
                buscar();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Agregar")){
            if(ve.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para actualizar","Nombre Vacio",ve.getTxtnombre());
            }else if(ve.getTxtapellido().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un apellido para actualizar","Apellido Vacio",ve.getTxtapellido());
            }else if(ve.getTxttelefono().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un telefono para actualizar","Telefono Vacio",ve.getTxttelefono());
            }else if(ve.getTxtfechaing().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una Fecha de Ingreso para actualizar","Fecha Ingreso Vacia",ve.getTxtfechaing());
            }else if(!fe.isFechaValida(ve.getTxtfechaing().getText())){
                msj.mvacio("Por favor ingrese una Fecha de Ingreso valida DD/MM/AAAA","Fecha Invalidad",ve.getTxtfechaing());
            }else if(ve.getTxtfechaegr().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una Fecha de Egreso para actualizar","Fecha Egreso Vacia",ve.getTxtfechaegr());
            }else if(!fe.isFechaValida(ve.getTxtfechaegr().getText())){
                msj.mvacio("Por favor ingrese una Fecha de Egreso valida DD/MM/AAAA","Fecha Invalidad",ve.getTxtfechaegr());
            }else if(String.valueOf((String) ve.getCbtndiaslibres().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione los dias libres para actualizar","Dia Libre sin Seleccion",ve.getCbtndiaslibres());
            }else if(String.valueOf((String) ve.getCbtncargo().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione un cargo para actualizar","Cargo sin Seleccion",ve.getCbtncargo());
            }else if(ve.getTxtdireccion().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una direccion para actualizar","Direccion Vacia",ve.getTxtdireccion());
            }else{
                registrar();
                ve.sinregistro();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Modificar")){
            if(ve.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para actualizar","Nombre Vacio",ve.getTxtnombre());
            }else if(ve.getTxtapellido().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un apellido para actualizar","Apellido Vacio",ve.getTxtapellido());
            }else if(ve.getTxttelefono().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un telefono para actualizar","Telefono Vacio",ve.getTxttelefono());
            }else if(ve.getTxtfechaing().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una Fecha de Ingreso para actualizar","Fecha Ingreso Vacia",ve.getTxtfechaing());
            }else if(!fe.isFechaValida(ve.getTxtfechaing().getText())){
                msj.mvacio("Por favor ingrese una Fecha de Ingreso valida DD/MM/AAAA","Fecha Invalidad",ve.getTxtfechaing());
            }else if(ve.getTxtfechaegr().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una Fecha de Egreso para actualizar","Fecha Egreso Vacia",ve.getTxtfechaegr());
            }else if(!fe.isFechaValida(ve.getTxtfechaegr().getText())){
                msj.mvacio("Por favor ingrese una Fecha de Egreso valida DD/MM/AAAA","Fecha Invalidad",ve.getTxtfechaegr());
            }else if(String.valueOf((String) ve.getCbtndiaslibres().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione los dias libres para actualizar","Dia Libre sin Seleccion",ve.getCbtndiaslibres());
            }else if(String.valueOf((String) ve.getCbtncargo().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione un cargo para actualizar","Cargo sin Seleccion",ve.getCbtncargo());
            }else if(ve.getTxtdireccion().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una direccion para actualizar","Direccion Vacia",ve.getTxtdireccion());
            }else{
                modificar();
                ve.sinregistro();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Eliminar")){
            eliminar();
            ve.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
            cancelar();
            ve.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            if(msj.msalir()==JOptionPane.YES_OPTION){
                salir();
            }
        }
    }
    
    public void buscar(){
        int i=0;
        me = new MEmpleado();
        me.setCedula(ve.getTxtbuscar().getText());
        ve.getTxtbuscar().setText("");
        if(me.consultar()){
            if(me.getStatus().equalsIgnoreCase("A")){
                ve.getTxtcedula().setText(me.getCedula());
                ve.getTxtnombre().setText(me.getNombre());
                ve.getTxtapellido().setText(me.getApellido());
                ve.getTxtdireccion().setText(me.getDireccion());
                ve.getTxttelefono().setText(me.getTelefono());
                ve.getTxtfechaing().setText(me.getFechaing());
                ve.getTxtfechaegr().setText(me.getFechaegr());
                String dl="",cc="";
                dl=me.getDiaslibres();
                if(dl.equalsIgnoreCase("lm")){
                    ve.getCbtndiaslibres().setSelectedIndex(1);
                }else if(dl.equalsIgnoreCase("ij")){
                    ve.getCbtndiaslibres().setSelectedIndex(2);
                }else if(dl.equalsIgnoreCase("vs")){
                    ve.getCbtndiaslibres().setSelectedIndex(3);
                }else if(dl.equalsIgnoreCase("dl")){
                    ve.getCbtndiaslibres().setSelectedIndex(4);
                }else if(dl.equalsIgnoreCase("mi")){
                    ve.getCbtndiaslibres().setSelectedIndex(5);
                }else if(dl.equalsIgnoreCase("jv")){
                    ve.getCbtndiaslibres().setSelectedIndex(6);
                }else if(dl.equalsIgnoreCase("sd")){
                    ve.getCbtndiaslibres().setSelectedIndex(7);
                }
                int poss=memp.buscarCargopc(me.getCodigoc());
                if(poss>=0){
                    poss++;
                    ve.getCbtncargo().setSelectedIndex(poss);
                }
               
               /* me.getMcarg().setCodigoc(me.getCodigoc());
                if(me.getMcarg().consultar()){
                    ve.getTxtsueldom().setText(String.valueOf(me.getMcarg().getSueldomc()));
                }*/
                msj.mencontrado();
                ve.registroenc();
            }else{
                if(msj.mreactivar()==JOptionPane.YES_OPTION){
                    me.reactivar();
                    ve.getTxtcedula().setText(me.getCedula());
                    ve.getTxtnombre().setText(me.getNombre());
                    ve.getTxtapellido().setText(me.getApellido());
                    ve.getTxtdireccion().setText(me.getDireccion());
                    ve.getTxttelefono().setText(me.getTelefono());
                    ve.getTxtfechaing().setText(me.getFechaing());
                    ve.getTxtfechaegr().setText(me.getFechaegr());
                    String dl="",cc="";
                    dl=me.getDiaslibres();
                    if(dl.equalsIgnoreCase("lm")){
                        ve.getCbtndiaslibres().setSelectedIndex(1);
                    }else if(dl.equalsIgnoreCase("ij")){
                        ve.getCbtndiaslibres().setSelectedIndex(2);
                    }else if(dl.equalsIgnoreCase("vs")){
                        ve.getCbtndiaslibres().setSelectedIndex(3);
                    }else if(dl.equalsIgnoreCase("dl")){
                        ve.getCbtndiaslibres().setSelectedIndex(4);
                    }else if(dl.equalsIgnoreCase("mi")){
                        ve.getCbtndiaslibres().setSelectedIndex(5);
                    }else if(dl.equalsIgnoreCase("jv")){
                        ve.getCbtndiaslibres().setSelectedIndex(6);
                    }else if(dl.equalsIgnoreCase("sd")){
                        ve.getCbtndiaslibres().setSelectedIndex(7);
                    }
                    int poss=memp.buscarCargopc(me.getCodigoc());
                    if(poss>=0){
                        poss++;
                        ve.getCbtncargo().setSelectedIndex(poss);
                    }
                    /*me.getMcarg().setCodigoc(me.getCodigoc());
                    if(me.getMcarg().consultar()){
                        ve.getTxtsueldom().setText(String.valueOf(me.getMcarg().getSueldomc()));
                    }*/
                    
                    ve.registroenc();
                }else{
                    ve.sinregistro();
                }
            }
        }else{
            if(msj.mnoencontrado()==JOptionPane.YES_OPTION){
                ve.getTxtcedula().setText(me.getCedula());
                ve.registronoenc();
            }else{
                ve.sinregistro();
            }
        }
    }
    public void registrar(){
        me.setCedula(ve.getTxtcedula().getText());
        me.setNombre(ve.getTxtnombre().getText());
        me.setApellido(ve.getTxtapellido().getText());
        me.setDireccion(ve.getTxtdireccion().getText());
        me.setTelefono(ve.getTxttelefono().getText());
        me.setFechaing(ve.getTxtfechaing().getText());
        me.setFechaegr(ve.getTxtfechaegr().getText());
        me.setStatus("A");
        String dl="",cc="";
        dl=String.valueOf((String) ve.getCbtndiaslibres().getSelectedItem());
        if(dl.equalsIgnoreCase("Lunes y Martes")){
            dl="lm";
        }else if(dl.equalsIgnoreCase("Miercoles y Jueves")){
            dl="ij";
        }else if(dl.equalsIgnoreCase("Viernes y Sabado")){
            dl="vs";
        }else if(dl.equalsIgnoreCase("Domingo y Lunes")){
            dl="dl";
        }else if(dl.equalsIgnoreCase("Martes y Miercoles")){
            dl="mi";
        }else if(dl.equalsIgnoreCase("Jueves y Vienes")){
            dl="jv";
        }else if(dl.equalsIgnoreCase("Sabado y Domingo")){
            dl="sd";
        }
        me.setDiaslibres(dl);
        cc=String.valueOf((String) ve.getCbtncargo().getSelectedItem());
        int poss=memp.buscarCargopn(cc);
        if(poss>=0){
            cc=memp.getMCarg(poss).getCodigoc();
        }
        me.setCodigoc(cc);
        if(me.agregar()){
            msj.mregistrado();
        }
    }
        public void modificar(){
            me.setCedula(ve.getTxtcedula().getText());
            me.setNombre(ve.getTxtnombre().getText());
            me.setApellido(ve.getTxtapellido().getText());
            me.setDireccion(ve.getTxtdireccion().getText());
            me.setTelefono(ve.getTxttelefono().getText());
            me.setFechaing(ve.getTxtfechaing().getText());
            me.setFechaegr(ve.getTxtfechaegr().getText());
            String dl="",cc="";
            dl=String.valueOf((String) ve.getCbtndiaslibres().getSelectedItem());
            if(dl.equalsIgnoreCase("Lunes y Martes")){
                dl="lm";
            }else if(dl.equalsIgnoreCase("Miercoles y Jueves")){
                dl="ij";
            }else if(dl.equalsIgnoreCase("Viernes y Sabado")){
                dl="vs";
            }else if(dl.equalsIgnoreCase("Domingo y Lunes")){
                dl="dl";
            }else if(dl.equalsIgnoreCase("Martes y Miercoles")){
                dl="mi";
            }else if(dl.equalsIgnoreCase("Jueves y Vienes")){
                dl="jv";
            }else if(dl.equalsIgnoreCase("Sabado y Domingo")){
                dl="sd";
            }
            me.setDiaslibres(dl);
            cc=String.valueOf((String) ve.getCbtncargo().getSelectedItem());
            int poss=memp.buscarCargopn(cc);
            if(poss>=0){
                cc=memp.getMCarg(poss).getCodigoc();
            }
            me.setCodigoc(cc);
            if(me.modificar()){
                msj.mactualizado();
            }
        }
        public void eliminar(){
            me.setCedula(ve.getTxtcedula().getText());
            if(me.eliminar()){
                msj.meliminado();
            }
        }
        public void cancelar(){
            ve.sinregistro();
        }
        public void salir(){
            ve.sinregistro();
            ve.dispose();
            cmenu.setAempleado(false);
        }
        public void imprimirsueldo(){
            int poss=memp.buscarCargopn(String.valueOf((String) ve.getCbtncargo().getSelectedItem()));
            if(poss>=0){
                ve.getTxtsueldom().setText(String.valueOf(memp.getMCarg(poss).getSueldomc()));
            }else{
                ve.getTxtsueldom().setText("");
            }
        }
}
