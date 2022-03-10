
package controladores;
import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.MConcepto;
import vistas.VConcepto;
public class CConcepto  implements ActionListener {
    private VConcepto vcon;
    private CEmpresa cmenu;
    private Mensajes msj = new Mensajes();
    private MConcepto mcon;
    public CConcepto(CEmpresa cmenu) {
        vcon= new VConcepto(cmenu.getVmenu(),false,this);
        vcon.setLocationRelativeTo(null);
        vcon.setResizable(false);
        vcon.setVisible(true);	
        vcon.agregarListener(this);
        vcon.setTitle("CONCEPTOS DE LA NOMINA");
        this.cmenu=cmenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Consultar")){
            if(vcon.getTxtbuscar().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un rif para buscar","Rif Vacio",vcon.getTxtbuscar());
            }else{
                buscar();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Agregar")){
            if(vcon.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para registrar","Nombre Vacio",vcon.getTxtnombre());
            }else if(String.valueOf((String) vcon.getCbtntipoc().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione un tipo de concepto para registrar","Tipo de Concepto sin Seleccion",vcon.getCbtntipoc());
            }else if(vcon.getTxtvalor().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un valor del concepto para registrar","Valor Vacio",vcon.getTxtvalor());
            }else{
                registrar();
                vcon.sinregistro();
            }      
        }
        if(e.getActionCommand().equalsIgnoreCase("Modificar")){
            if(vcon.getTxtnombre().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un nombre para registrar","Nombre Vacio",vcon.getTxtnombre());
            }else if(String.valueOf((String) vcon.getCbtntipoc().getSelectedItem()).equalsIgnoreCase("seleccione")){
                msj.mvacio("Por favor seleccione un tipo de concepto para registrar","Tipo de Concepto sin Seleccion",vcon.getCbtntipoc());
            }else if(vcon.getTxtvalor().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un valor del concepto para registrar","Valor Vacio",vcon.getTxtvalor());
            }else{
                modificar();
                vcon.sinregistro();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Eliminar")){
            eliminar();
            vcon.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
            cancelar();
            vcon.sinregistro();
        }
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            if(msj.msalir()==JOptionPane.YES_OPTION){
                salir();
            }
        }
    }
    
    public void buscar(){
        int i=0;
        mcon = new MConcepto();
        mcon.setCodigo(vcon.getTxtbuscar().getText());
        vcon.getTxtbuscar().setText("");
        if(mcon.consultar()){
            if(mcon.getStatus().equalsIgnoreCase("A")){
                vcon.getTxtcodigo().setText(mcon.getCodigo());
                vcon.getTxtnombre().setText(mcon.getNombre());
                String tc=mcon.getCodigotc();
                if(tc.equalsIgnoreCase("as")){
                    vcon.getCbtntipoc().setSelectedIndex(1);
                }else if(tc.equalsIgnoreCase("de")){
                    vcon.getCbtntipoc().setSelectedIndex(2);
                }
                vcon.getTxtvalor().setText(String.valueOf(mcon.getValor()));
                msj.mencontrado();
                vcon.registroenc();
            }else{
                if(msj.mreactivar()==JOptionPane.YES_OPTION){
                    mcon.reactivar();
                    vcon.getTxtcodigo().setText(mcon.getCodigo());
                    vcon.getTxtnombre().setText(mcon.getNombre());
                    String tc=mcon.getCodigotc();
                    if(tc.equalsIgnoreCase("as")){
                        vcon.getCbtntipoc().setSelectedIndex(1);
                    }else if(tc.equalsIgnoreCase("de")){
                        vcon.getCbtntipoc().setSelectedIndex(2);
                    }
                    vcon.getTxtvalor().setText(String.valueOf(mcon.getValor()));
                    vcon.registroenc();
                }else{
                    vcon.sinregistro();
                }
            }
        }else{
            if(msj.mnoencontrado()==JOptionPane.YES_OPTION){
                vcon.getTxtcodigo().setText(mcon.getCodigo());
                vcon.registronoenc();
            }else{
                vcon.sinregistro();
            }
        }
    }
    public void registrar(){
        mcon.setCodigo(vcon.getTxtcodigo().getText());
        mcon.setNombre(vcon.getTxtnombre().getText());
        String tc=String.valueOf((String) vcon.getCbtntipoc().getSelectedItem());
        if(tc.equalsIgnoreCase("Asignacion")){
            mcon.setCodigotc("as");
        }else if(tc.equalsIgnoreCase("Deduccion")){
            mcon.setCodigotc("de");
        }
        mcon.setValor(Double.parseDouble(vcon.getTxtvalor().getText()));
        mcon.setStatus("A");
        if(mcon.agregar()){
            msj.mregistrado();
        }
    }
    public void modificar(){
        mcon.setCodigo(vcon.getTxtcodigo().getText());
        mcon.setNombre(vcon.getTxtnombre().getText());
        String tc=String.valueOf((String) vcon.getCbtntipoc().getSelectedItem());
        if(tc.equalsIgnoreCase("Asignacion")){
            mcon.setCodigotc("as");
        }else if(tc.equalsIgnoreCase("Deduccion")){
            mcon.setCodigotc("de");
        }
        mcon.setValor(Double.parseDouble(vcon.getTxtvalor().getText()));
        mcon.setStatus("A");
        if(mcon.modificar()){
            msj.mactualizado();
        }
    }
    public void eliminar(){
        mcon.setCodigo(vcon.getTxtcodigo().getText());
        if(mcon.eliminar()){
            msj.meliminado();
        }
    }
    public void cancelar(){
        vcon.sinregistro();
    }
    
    public void salir(){
        vcon.sinregistro();
        vcon.dispose();
        cmenu.setAconcepto(false);
    }
    
}
