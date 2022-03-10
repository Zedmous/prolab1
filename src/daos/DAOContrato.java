
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.MDContrato;


public class DAOContrato extends DAO {
    
    public DAOContrato(){
        
    }
    
    public ArrayList<MDContrato> cargarListaContrato(String sentencia){
        ArrayList<MDContrato> lmdc = new ArrayList<MDContrato>();
        ResultSet rs=buscar(sentencia);
        try {
            while(rs.next()){
                MDContrato auxmdc = new MDContrato();
                auxmdc.setNumeroc(rs.getInt("numeroc"));
                auxmdc.setCodigos(rs.getString("codigos"));
                auxmdc.setCantidadc(rs.getInt("cantidadc"));
                auxmdc.setStatusdc(rs.getString("statusdc"));
                lmdc.add(auxmdc);
            }
        } catch (SQLException ex) {
             Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lmdc;
    }
    public int generarNumeroContrato(String sentencia){
        int num=0;
        ResultSet rs;
        rs = buscar(sentencia);
        try {
            if(rs.next()){
                num= rs.getInt("nroc");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        num++;
        return num;
    }
}
