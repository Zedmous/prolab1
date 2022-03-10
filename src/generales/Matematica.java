
package generales;

public class Matematica {
    
    
    public double redondear(double numero){
        return Math.rint(numero*100)/100;
    }
    public int randomhastaLimite(int limite){
        return (int)Math.floor(Math.random()*limite);
    }
}
