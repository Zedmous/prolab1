
package controladores;

import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.MUsuario;
import vistas.VIngreso;

public class CIngreso  implements ActionListener{
    private VIngreso vi;
    private CEmpresa cmenu;
    private MUsuario mu;
    private Mensajes msj = new Mensajes();
    public CIngreso() {
        vi= new VIngreso();
        vi.setLocationRelativeTo(null);
        vi.setVisible(true);	
        vi.agregarListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Ingresar")){
            if(vi.getTxtlogin().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese un login","Login Vacio",vi.getTxtlogin());
            }else if(vi.getTxtclave().getText().equalsIgnoreCase("")){
                msj.mvacio("Por favor ingrese una clave","Clave Vacia",vi.getTxtclave());
            }else{
                acceder();
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Cancelar")){
            cancelar();
        }
    }
    
    public void acceder(){
        mu = new MUsuario();
        mu.setLogin(vi.getTxtlogin().getText().toLowerCase());
        System.out.println(vi.getTxtlogin().getText().toLowerCase());
        mu.setClave(vi.getTxtclave().getText());
        if(mu.ingresar()){
            cmenu=new  CEmpresa(mu.getLogin(),mu.getCedula(),mu.getNombre(),mu.getApellido(),mu.getCodigonu());
            vi.dispose();
        }else{
            msj.mnoingresarsistema();
        }
    }
    public void cancelar(){
        vi.sinregistro();
    }
}
