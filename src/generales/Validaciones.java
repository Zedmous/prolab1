

package generales;
import javax.swing.*;
import java.util.*;
public class Validaciones {
    Calendar can = new GregorianCalendar();
    
    public Validaciones() {

    }
    public void codigoalfanum(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        String aux = String.valueOf(evt.getKeyChar());
        if(!((Character.isLetter(c) || Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK))) ){
            evt.consume();
        }
        if(logintud>=5){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En el codigo solo se aceptan un maximo de 5 cararteres");
        }
    }    

    public void rif(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        if(logintud>=20){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En el rif solo se aceptan un maximo de 20 cararteres");
        }
    }
    
    public void cedula(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)))){
            evt.consume();
        }
        if(logintud>=13){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En la cedula solo se aceptan un maximo de 13 cararteres");
        }
    }
    
    public void numero(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)))){
            evt.consume();
        }
        if(logintud>=15){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se acepta un maximo de 15 caracteres");
        }
    }
    public void codigonumero(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c)))){
            evt.consume();
        }
        if(logintud>=15){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se acepta un maximo de 5 caracteres");
        }
    }
    public void numerod(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        String caracter = String.valueOf(evt.getKeyChar());
        if(!((Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK) || caracter.equalsIgnoreCase(".")))){
            evt.consume();
        }
        if(logintud>=15){
            evt.consume();
            JOptionPane.showMessageDialog(null,"La habitacion solo acepta un maximo de 15 caracteres");
        }
    }
    public void nombre(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        if(!((Character.isLetter(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE)  ||(c == java.awt.event.KeyEvent.VK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)))){
            evt.consume();
        }
        if(logintud>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En el nombre solo se aceptan un maximo de 50 cararteres");
        }
    }
    public void apellido(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        if(!((Character.isLetter(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE)  ||(c == java.awt.event.KeyEvent.VK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)))){
            evt.consume();
        }
        if(logintud>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En el apellido solo se aceptan un maximo de 50 cararteres");
        }
    }
    public void direccion(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        String aux = String.valueOf(evt.getKeyChar());
        if(!((Character.isLetter(c) || Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) ||(c == java.awt.event.KeyEvent.VK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)) || aux.equalsIgnoreCase("#")) ){
            evt.consume();
        }
        if(logintud>=250){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En la direccion solo se aceptan un maximo de 250 cararteres");
        }
    }
    public void correo(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        String aux = String.valueOf(evt.getKeyChar());
        if(!((Character.isLetter(c) || Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) ||(c == java.awt.event.KeyEvent.VK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)) || aux.equalsIgnoreCase("@") || aux.equalsIgnoreCase("-") || aux.equalsIgnoreCase("_") || aux.equalsIgnoreCase(".")) ){
            evt.consume();
        }
        if(logintud>=50){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En el correo solo se aceptan un maximo de 50 cararteres");
        }
    }
    public void claveusuario(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        //String aux = String.valueOf(evt.getKeyChar());
        if(!((Character.isLetter(c) || Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) ||(c == java.awt.event.KeyEvent.VK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)) ) ){
            evt.consume();
        }
        if(logintud>=30){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En la clave solo se aceptan un maximo de 30 cararteres");
        }
    }
    public void descripcion(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        //String aux = String.valueOf(evt.getKeyChar());
        if(!((Character.isLetter(c) || Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) ||(c == java.awt.event.KeyEvent.VK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)) ) ){
            evt.consume();
        }
        if(logintud>=200){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En la descripion solo se acepta un maximo de 200 cararteres");
        }
    }
    public void telefono(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        String aux = String.valueOf(evt.getKeyChar());
        if(!((Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK))) ){
            evt.consume();
        }
        if(logintud>=11){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En el telefono solo se aceptan un maximo de 13 cararteres");
        }
    }
    public void fecha(java.awt.event.KeyEvent evt,int logintud){
        char c = evt.getKeyChar();
        String aux = String.valueOf(evt.getKeyChar());
        if(!((Character.isDigit(c) ||(c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c==java.awt.event.KeyEvent.VK_CAPS_LOCK)) || aux.equalsIgnoreCase("-")) ){
            evt.consume();
        }
        if(logintud>=10){
            evt.consume();
            JOptionPane.showMessageDialog(null,"En la fecha solo se aceptan un maximo de 10 cararteres");
        }
    }
    
  
}
