package controladores;

import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.MCliente;
import vistas.VCliente;

public class CCliente implements ActionListener{
    private CEmpresa cmenu;
    private VCliente vcli;
    private MCliente mcli;
    private Mensajes msj = new Mensajes();
    public CCliente(CEmpresa cmenu) {
        vcli= new VCliente(cmenu.getVmenu(),false,this);
        vcli.setLocationRelativeTo(null);
        vcli.setResizable(false);
        vcli.setVisible(true);
        vcli.setTitle("CLIENTES");
        vcli.agregarListener(this);
        this.cmenu=cmenu;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Consultar")){
            if(vcli.getTxtbuscar().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un rif para buscar","Rif Vacio",vcli.getTxtbuscar());
            }else{
                buscar();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Agregar")){
            if(vcli.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para registrar","Rif Vacio",vcli.getTxtnombre());
            }else if(vcli.getTxttelefono().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un telefono para registrar","Telefono Vacio",vcli.getTxttelefono());
            }else if(String.valueOf((String) vcli.getCbtntipoc().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione un tipo de cliente para registrar","Tipo de Cliente sin Seleccion",vcli.getCbtntipoc());
            }else if(vcli.getTxtdireccion().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una direccion para registrar","Direccion Vacia",vcli.getTxtdireccion());
            }else{
                registrar();
                vcli.sinregistro();
            }      
        }
        if(e.getActionCommand().equalsIgnoreCase("Modificar")){
            if(vcli.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para actualizar","Rif Vacio",vcli.getTxtnombre());
            }else if(vcli.getTxttelefono().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un telefono para actualizar","Telefono Vacio",vcli.getTxttelefono());
            }else if(String.valueOf((String) vcli.getCbtntipoc().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione un tipo de cliente para actualizar","Tipo de Cliente sin Seleccion",vcli.getCbtntipoc());
            }else if(vcli.getTxtdireccion().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una direccion para actualizar","Direccion Vacia",vcli.getTxtdireccion());
            }else{
                modificar();
                vcli.sinregistro();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Eliminar")){
            eliminar();
            vcli.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
            cancelar();
            vcli.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            if(msj.msalir()==JOptionPane.YES_OPTION){
                salir();
            }
        }
    }
    
    public void buscar(){
        int i=0;
        mcli = new MCliente();
        mcli.setRif(vcli.getTxtbuscar().getText());
        vcli.getTxtbuscar().setText("");
        if(mcli.consultar()){
            if(mcli.getStatus().equalsIgnoreCase("A")){
                vcli.getTxtrif().setText(mcli.getRif());
                vcli.getTxtnombre().setText(mcli.getNombre());
                vcli.getTxtdireccion().setText(mcli.getDireccion());
                vcli.getTxttelefono().setText(mcli.getTelefono());
                String tc="";
                tc=mcli.getCodigotc();
                if(tc.equalsIgnoreCase("cc")){
                    vcli.getCbtntipoc().setSelectedIndex(1);
                }else if(tc.equalsIgnoreCase("av")){
                    vcli.getCbtntipoc().setSelectedIndex(2);
                }else if(tc.equalsIgnoreCase("ru")){
                    vcli.getCbtntipoc().setSelectedIndex(3);
                }else if(tc.equalsIgnoreCase("er")){
                    vcli.getCbtntipoc().setSelectedIndex(4);
                }else if(tc.equalsIgnoreCase("tc")){
                    vcli.getCbtntipoc().setSelectedIndex(5);
                }
                msj.mencontrado();
                vcli.registroenc();
            }else{
                if(msj.mreactivar()==JOptionPane.YES_OPTION){
                    mcli.reactivar();
                    vcli.getTxtrif().setText(mcli.getRif());
                    vcli.getTxtnombre().setText(mcli.getNombre());
                    vcli.getTxtdireccion().setText(mcli.getDireccion());
                    vcli.getTxttelefono().setText(mcli.getTelefono());
                    String tc="";
                    tc=mcli.getCodigotc();
                    if(tc.equalsIgnoreCase("cc")){
                        vcli.getCbtntipoc().setSelectedIndex(1);
                    }else if(tc.equalsIgnoreCase("av")){
                        vcli.getCbtntipoc().setSelectedIndex(2);
                    }else if(tc.equalsIgnoreCase("ru")){
                        vcli.getCbtntipoc().setSelectedIndex(3);
                    }else if(tc.equalsIgnoreCase("er")){
                        vcli.getCbtntipoc().setSelectedIndex(4);
                    }else if(tc.equalsIgnoreCase("tc")){
                        vcli.getCbtntipoc().setSelectedIndex(5);
                    }
                    vcli.registroenc();
                }else{
                    vcli.sinregistro();
                }
            }
        }else{
            if(msj.mnoencontrado()==JOptionPane.YES_OPTION){
                vcli.getTxtrif().setText(mcli.getRif());
                vcli.registronoenc();
            }else{
                vcli.sinregistro();
            }
        }
    }
    public void registrar(){
        mcli.setRif(vcli.getTxtrif().getText());
        mcli.setNombre(vcli.getTxtnombre().getText());
        mcli.setDireccion(vcli.getTxtdireccion().getText());
        mcli.setTelefono(vcli.getTxttelefono().getText());
        mcli.setStatus("A");
        String tc=String.valueOf((String) vcli.getCbtntipoc().getSelectedItem());
        if(tc.equalsIgnoreCase("Consejo Comunal")){
            tc="cc";
        }else if(tc.equalsIgnoreCase("Asociación de Vecinos")){
            tc="av";
        }else if(tc.equalsIgnoreCase("Representante de la urbanización")){
            tc="ru";
        }else if(tc.equalsIgnoreCase("Edificio Residencial")){
            tc="er";
        }else if(tc.equalsIgnoreCase("Tienda Comercial")){
            tc="tc";
        }
        mcli.setCodigotc(tc);
        if(mcli.agregar()){
            msj.mregistrado();
        }
        mcli=null;
    }
    public void modificar(){
        mcli.setRif(vcli.getTxtrif().getText());
        mcli.setNombre(vcli.getTxtnombre().getText());
        mcli.setDireccion(vcli.getTxtdireccion().getText());
        mcli.setTelefono(vcli.getTxttelefono().getText());
        mcli.setStatus("A");
        String tc=String.valueOf((String) vcli.getCbtntipoc().getSelectedItem());
        if(tc.equalsIgnoreCase("Consejo Comunal")){
            tc="cc";
        }else if(tc.equalsIgnoreCase("Asociación de Vecinos")){
            tc="av";
        }else if(tc.equalsIgnoreCase("Representante de la urbanización")){
            tc="ru";
        }else if(tc.equalsIgnoreCase("Edificio Residencial")){
            tc="er";
        }else if(tc.equalsIgnoreCase("Tienda Comercial")){
            tc="tc";
        }
        mcli.setCodigotc(tc);
        if(mcli.modificar()){
            msj.mactualizado();
        }
        mcli=null;
    }
    public void eliminar(){
        mcli.setRif(vcli.getTxtrif().getText());
        if(mcli.eliminar()){
            msj.meliminado();
        }
        mcli=null;
    }
    public void cancelar(){
        vcli.sinregistro();
        mcli=null;
    }

    public void salir(){
        vcli.sinregistro();
        vcli.dispose();
        mcli=null;
        cmenu.setAcliente(false);
    }
    
}
