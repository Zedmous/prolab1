/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.MCargo;
import vistas.VCargo;
import vistas.VEmpresa;

public class CCargo implements ActionListener{
    private VCargo vcarg;
    private MCargo mcarg;
    private Mensajes msj = new Mensajes();
    private CEmpresa cmenu;
    public CCargo(CEmpresa cmenu) {
        vcarg= new VCargo(cmenu.getVmenu(),false,this);
        vcarg.setLocationRelativeTo(null);
        vcarg.setResizable(false);
        vcarg.setVisible(true);	
        vcarg.agregarListener(this);
        vcarg.setTitle("CARGOS DE EMPLEADO");
        vcarg.sinregistro();
        this.cmenu=cmenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Consultar")){
            if(vcarg.getTxtbuscar().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un codigo para buscar","Codigo Vacio",vcarg.getTxtbuscar());
            }else{
                buscar();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Agregar")){
            if(vcarg.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para registrar","Nombre Vacio",vcarg.getTxtnombre());
            }else if(vcarg.getTxtsueldom().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un sueldo mensual para registrar","Sueldo Mensual Vacio",vcarg.getTxtsueldom());
            }else{ 
                registrar();
                vcarg.sinregistro();
            }
            
        }
        if(e.getActionCommand().equalsIgnoreCase("Modificar")){
            if(vcarg.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para modificar","Nombre Vacio",vcarg.getTxtnombre());
            }else if(vcarg.getTxtsueldom().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un sueldo mensual para modificar","Sueldo Mensual Vacio",vcarg.getTxtsueldom());
            }else{ 
                modificar();
                vcarg.sinregistro();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Eliminar")){
            eliminar();
            vcarg.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
            cancelar();
            vcarg.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            if(msj.msalir()==JOptionPane.YES_OPTION){
                salir();
            }
        }
    }
    
    
    public void buscar(){
        int i=0;
        mcarg = new MCargo();
        mcarg.setCodigoc(vcarg.getTxtbuscar().getText());
        vcarg.getTxtbuscar().setText("");
        if(mcarg.consultar()){
            if(mcarg.getStatus().equalsIgnoreCase("A")){
                vcarg.getTxtcodigo().setText(mcarg.getCodigoc());
                vcarg.getTxtnombre().setText(mcarg.getNombrec());
                vcarg.getTxtsueldom().setText(String.valueOf(mcarg.getSueldomc()));
                msj.mencontrado();
                vcarg.registroenc();
            }else{
                if(msj.mreactivar()==JOptionPane.YES_OPTION){
                    mcarg.reactivar();
                    vcarg.getTxtcodigo().setText(mcarg.getCodigoc());
                    vcarg.getTxtnombre().setText(mcarg.getNombrec());
                    vcarg.getTxtsueldom().setText(String.valueOf(mcarg.getSueldomc()));
                    vcarg.registroenc();
                }else{
                    vcarg.sinregistro();
                }
            }
        }else{
            if(msj.mnoencontrado()==JOptionPane.YES_OPTION){
                vcarg.getTxtcodigo().setText(mcarg.getCodigoc());
                vcarg.registronoenc();
            }else{
                vcarg.sinregistro();
            }
        }
    }
    public void registrar(){
        mcarg.setCodigoc(vcarg.getTxtcodigo().getText());
        mcarg.setNombrec(vcarg.getTxtnombre().getText());
        mcarg.setSueldomc(Double.parseDouble(vcarg.getTxtsueldom().getText()));
        mcarg.setStatus("A");
        if(mcarg.agregar()){
            msj.mregistrado();
        }
    }
    public void modificar(){
        mcarg.setCodigoc(vcarg.getTxtcodigo().getText());
        mcarg.setNombrec(vcarg.getTxtnombre().getText());
        mcarg.setSueldomc(Double.parseDouble(vcarg.getTxtsueldom().getText()));
        mcarg.setStatus("A");
        if(mcarg.modificar()){
            msj.mactualizado();
        }
    }
    public void eliminar(){
        mcarg.setCodigoc(vcarg.getTxtcodigo().getText());
        if(mcarg.eliminar()){
            msj.meliminado();
        }
    }
    public void cancelar(){
        vcarg.sinregistro();
    }
    public void salir(){
        vcarg.sinregistro();
        vcarg.dispose();
        cmenu.setAcargo(false);
    }
}
