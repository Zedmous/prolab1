
package generales;
import javax.swing.*;
public class Mensajes {
    
    public Mensajes(){
        
    }
    //MENSAJES ACME
    
    //CONSULTA
    public void mencontrado(){
        JOptionPane.showMessageDialog(null,"¡Encontrado Existosamente!");
    }
    //CONSULTA PARA PODER REGISTRAR
    public int mnoencontrado(){
        return JOptionPane.showConfirmDialog(null,"Registro no encontrado ¿Desea registrar?","REGISTRANDO",JOptionPane.YES_NO_OPTION);
    }
    //CONSULTA NO ENCONTRADA
    public void mnencontrado(){
        JOptionPane.showMessageDialog(null,"¡Registro no Encontrado!");
    }
    //CONSULTA REACTIVADA
    public int mreactivar(){
        return JOptionPane.showConfirmDialog(null,"El registro se encuentra inactivo ¿Desea reactivarlo?","REACTIVANDO",JOptionPane.YES_NO_OPTION);
    }
    //REACTIVADO
    public void mreactivado(){
        JOptionPane.showMessageDialog(null,"¡Reactivado Exitosamente!");
    }
    //REGISTRO
    public void mregistrado(){
        JOptionPane.showMessageDialog(null,"¡Registrado Exitosamente!");
    }
    //ACTUALIZACIONES
    public void mactualizado(){
        JOptionPane.showMessageDialog(null,"¡Actualizado Exitoxamente!");
    }
    //ELIMINACIONES
    public void meliminado(){
        JOptionPane.showMessageDialog(null,"¡Eliminado Exitosamente!");
    }
    
    //MENSAJES DE PREGUNTAS NORMAL
    public int mpreguntar(String msj1,String msj2){
        return JOptionPane.showConfirmDialog(null,msj1,msj2,JOptionPane.YES_NO_OPTION);
    }
    //MENSAJES DE PREGUNTAS DE ADVERTENCIA
    public int mpreguntaradv(String msj1,String msj2){
        return JOptionPane.showConfirmDialog(null,msj1,msj2,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
    }
    //MENSAJES PARA CANCELAR OPERACION
    public int mcancelar(){
        int resp = JOptionPane.showConfirmDialog(null,"¿Desea cancelar?","CANCELANDO",JOptionPane.YES_NO_OPTION);
        return resp;
    }
    //MENSAJES PARA SALIR DEL FORMULARIO
    public int msalir(){
        int resp = JOptionPane.showConfirmDialog(null,"¿Desea ir al Menu?","SALIENDO",JOptionPane.YES_NO_OPTION);
        return resp;
    }
    //MENSAJE DE INFORMACION
    public void minformando(String msj){
        JOptionPane.showMessageDialog(null,msj,"INFORMANDO",JOptionPane.INFORMATION_MESSAGE);
    }
    //MENSAJE DE ADVERTENCIA
    public void madvertencia(String msj){
        JOptionPane.showMessageDialog(null,msj,"INFORMANDO",JOptionPane.WARNING_MESSAGE);
    }
    //MENSAJE DE ACCION NO IMPLEMENTADA
    public void mnoimplementado(){
        JOptionPane.showMessageDialog(null, "Accion no implementada","NO IMPLEMENTADO",JOptionPane.ERROR_MESSAGE);
        
    }
    //MENSAJES PARA ACCESOS DEL SISTEMA Y SALIDAS DEL SISTEMA
    public void mingresarsistema(String usuario){
        JOptionPane.showMessageDialog(null,"Bienvenido al sistema: "+ usuario,"BIENVENIDO",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void msuperusuario(String usuario){
        JOptionPane.showMessageDialog(null,"Bienvenido al sistema: "+ usuario + " verifica que el sistema este en orden","BIENVENIDO",JOptionPane.INFORMATION_MESSAGE);
    }
    public void mnoingresarsistema(){
        JOptionPane.showMessageDialog(null,"Login o Clave Incorrecta","INGRESANDO AL SISTEMA",JOptionPane.ERROR_MESSAGE);
    }
    public int mcerrarsistema(){
        int resp = JOptionPane.showConfirmDialog(null,"¿Desea cerrar el sistema?","SALIENDO DEL SISTEMA",JOptionPane.YES_NO_OPTION);
        return resp;
    }
    // MENSAJES PARA CAMPOS VACIOS
    public void mvacio(String msj1,String msj2,JTextField caja){
        JOptionPane.showMessageDialog(null, msj1,msj2,JOptionPane.ERROR_MESSAGE);
        caja.requestFocus();
    }
    public void mvacio(String msj1,String msj2,JTextArea caja){
        JOptionPane.showMessageDialog(null, msj1,msj2,JOptionPane.ERROR_MESSAGE);
        caja.requestFocus();
    }
    public void mvacio(String msj1,String msj2,JPasswordField caja){
        JOptionPane.showMessageDialog(null, msj1,msj2,JOptionPane.ERROR_MESSAGE);
        caja.requestFocus();
    }
    public void mvacio(String msj1,String msj2,JComboBox<String> caja){
        JOptionPane.showMessageDialog(null, msj1,msj2,JOptionPane.ERROR_MESSAGE);
    }
    
    //MENSAJES DE COMPARACION
    public void mcomparacionincorrecta(String msj1,String msj2){
        JOptionPane.showMessageDialog(null, msj1,msj2,JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    
}
