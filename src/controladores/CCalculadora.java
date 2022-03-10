
package controladores;

import vistas.VCalculadora;


public class CCalculadora {
    private VCalculadora vcalculadora;
    public CCalculadora(CEmpresa cmenu){
        vcalculadora= new VCalculadora();
        vcalculadora.setLocationRelativeTo(null);
        vcalculadora.setResizable(false);
        vcalculadora.setVisible(true);	
        vcalculadora.setTitle("Calculadora");
    }
}
