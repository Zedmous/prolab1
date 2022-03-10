
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.MDNomina;

public class DAONomina extends DAO {
    
    public DAONomina(){
        
    }
    public ArrayList<MDNomina> cargarListaNomina(String sentencia){
        ArrayList<MDNomina> lmdf = new ArrayList<MDNomina>();
        ResultSet rs=buscar(sentencia);
        
        try {
            while(rs.next()){
                MDNomina auxmdf = new MDNomina();
                auxmdf.setNumeron(rs.getInt("numeron"));
                auxmdf.setCodigoc(rs.getString("codigoc"));
                auxmdf.setCantidadn(rs.getInt("cantidadn"));
                auxmdf.setStatusdn(rs.getString("statusdn"));
                lmdf.add(auxmdf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAONomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lmdf;
    }
    public int generarNumeroNomina(String sentencia){
        int num=0;
        ResultSet rs;
        rs = buscar(sentencia);
       
        try {
            if(rs.next()){
                num= rs.getInt("nron");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAONomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        num++;
        return num;
    }
}
