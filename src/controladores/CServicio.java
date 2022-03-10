
package controladores;

import generales.Mensajes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelos.MServicio;
import vistas.VServicio;

public class CServicio  implements ActionListener {
    private MServicio mserv;
    private VServicio vserv;
    private CEmpresa cmenu;
    private Mensajes msj = new Mensajes();
    public CServicio(CEmpresa cmenu) {
        vserv= new VServicio(cmenu.getVmenu(),false,this);
        vserv.setLocationRelativeTo(null);
        vserv.setResizable(false);
        vserv.setVisible(true);	
        vserv.agregarListener(this);
        vserv.setTitle("SERVICIO");
        this.cmenu=cmenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Consultar")){
            if(vserv.getTxtbuscar().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un rif para buscar","Rif Vacio",vserv.getTxtbuscar());
            }else{
                buscar();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Agregar")){
            if(vserv.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para registrar","Nombre Vacio",vserv.getTxtnombre());
            }else if(vserv.getTxtprecio().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un precio para registrar","Precio Vacio",vserv.getTxtprecio());
            }else{
                registrar();
                vserv.sinregistro();
            }      
        }
        if(e.getActionCommand().equalsIgnoreCase("Modificar")){
            if(vserv.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para registrar","Nombre Vacio",vserv.getTxtnombre());
            }else if(vserv.getTxtprecio().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un precio para registrar","Precio Vacio",vserv.getTxtprecio());
            }else{
                modificar();
                vserv.sinregistro();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Eliminar")){
            eliminar();
            vserv.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
            cancelar();
            vserv.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            if(msj.msalir()==JOptionPane.YES_OPTION){
                salir();
            }
        }
    }
    
    
    
    public void buscar(){
        int i=0;
        mserv = new MServicio();
        mserv.setCodigo(vserv.getTxtbuscar().getText());
        vserv.getTxtbuscar().setText("");
        if(mserv.consultar()){
            if(mserv.getStatus().equalsIgnoreCase("A")){
                vserv.getTxtcodigo().setText(mserv.getCodigo());
                vserv.getTxtnombre().setText(mserv.getNombre());
                vserv.getTxtprecio().setText(String.valueOf(mserv.getPrecio()));
                msj.mencontrado();
                vserv.registroenc();
            }else{
                if(msj.mreactivar()==JOptionPane.YES_OPTION){
                    mserv.reactivar();
                    vserv.getTxtcodigo().setText(mserv.getCodigo());
                    vserv.getTxtnombre().setText(mserv.getNombre());
                    vserv.getTxtprecio().setText(String.valueOf(mserv.getPrecio()));
                    vserv.registroenc();
                }else{
                    vserv.sinregistro();
                }
            }
        }else{
            if(msj.mnoencontrado()==JOptionPane.YES_OPTION){
                vserv.getTxtcodigo().setText(mserv.getCodigo());
                vserv.registronoenc();
            }else{
                vserv.sinregistro();
            }
        }
    }
    public void registrar(){
        mserv.setCodigo(vserv.getTxtcodigo().getText());
        mserv.setNombre(vserv.getTxtnombre().getText());
        mserv.setPrecio(Double.parseDouble(vserv.getTxtprecio().getText()));
        mserv.setStatus("A");
        if(mserv.agregar()){
            msj.mregistrado();
        }
    }
    public void modificar(){
        mserv.setCodigo(vserv.getTxtcodigo().getText());
        mserv.setNombre(vserv.getTxtnombre().getText());
        mserv.setPrecio(Double.parseDouble(vserv.getTxtprecio().getText()));
        mserv.setStatus("A");
        if(mserv.modificar()){
            msj.mactualizado();
        }
    }
    public void eliminar(){
        mserv.setCodigo(vserv.getTxtcodigo().getText());
        if(mserv.eliminar()){
            msj.meliminado();
        }
    }
    public void cancelar(){
        vserv.sinregistro();
    }
    
    public void salir(){
        vserv.sinregistro();
        vserv.dispose();
        cmenu.setAservicio(false);
    }
    
    
}
