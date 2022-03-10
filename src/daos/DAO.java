
package daos;

import generales.MConexion;
import java.sql.ResultSet;

public class DAO{
    private MConexion  mc;
    
    public DAO(){
        mc= new MConexion();
    }
    
    public boolean agregar(String sentencia){
        boolean enc=false;
        getMc().abrirConexion();
        getMc().ejecutar(sentencia);
        getMc().cerrarConexion();
        return enc;
    }
    
    public ResultSet buscar(String sentencia){
        ResultSet rs;
        getMc().abrirConexion();
        rs=getMc().consultar(sentencia);
        getMc().cerrarConexion();
        return rs;
    }
    
    public boolean modificar(String sentencia){
        boolean enc=false;
        getMc().abrirConexion();
        getMc().ejecutar(sentencia);
        getMc().cerrarConexion();
        return enc;
    }
    
    public boolean eliminar(String sentencia){
        boolean enc = false;
        getMc().abrirConexion();
        getMc().ejecutar(sentencia);
        getMc().cerrarConexion();
        return enc;
    }
    
    public boolean reactivar(String sentencia){
        boolean enc = false;
        getMc().abrirConexion();
        getMc().ejecutar(sentencia);
        getMc().cerrarConexion();
        return enc;
    }
    
    public MConexion getMc() {
        return mc;
    }
    
    public void setMc(MConexion mc) {
        this.mc = mc;
    }
}
