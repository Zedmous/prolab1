
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.MDFactura;

public class DAOFactura extends DAO{
    
    public DAOFactura(){
        
    }
    public ArrayList<MDFactura> cargarListaFactura(String sentencia){
        ArrayList<MDFactura> lmdf = new ArrayList<MDFactura>();
        ResultSet rs=buscar(sentencia);
        try {
            while(rs.next()){
                MDFactura auxmdf = new MDFactura();
                auxmdf.setNumerof(rs.getInt("numerof"));
                auxmdf.setCodigos(rs.getString("codigos"));
                auxmdf.setCantidadf(rs.getInt("cantidadf"));
                auxmdf.setPreciodf(rs.getDouble("preciodf"));
                auxmdf.setStatusdf(rs.getString("statusdf"));
                lmdf.add(auxmdf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lmdf;
    }
    public int generarNumeroFactura(String sentencia){
        int num=0;
        ResultSet rs;
        rs = buscar(sentencia);
        try {
            if(rs.next()){
                num= rs.getInt("nrof");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        num++;
        return num;
    }
}
