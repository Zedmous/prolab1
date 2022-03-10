
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reportes.RAusenciassm;
public class CRAusencias implements ActionListener{
    private RAusenciassm rausenciassm;
    private CEmpresa cmenu;
    public CRAusencias(CEmpresa cmenu){
        rausenciassm=new RAusenciassm(new javax.swing.JFrame(),false,this);
        rausenciassm.setLocationRelativeTo(null);
        rausenciassm.setResizable(false);
        rausenciassm.setVisible(true);	
        rausenciassm.agregarListener(this);
        this.cmenu=cmenu;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    
    }
    
    public void salir(){
        rausenciassm.sinregistro();
        rausenciassm.dispose();
        cmenu.setAausenciassm(false);
    
    }
}
