
package modelos;

import daos.DAODContrato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MDContrato {
    
    
    private String codigos,statusdc;
    private int cantidadc,numeroc;
    private MServicio ms;
    private DAODContrato ddcont;
    public MDContrato(){
        ddcont = new DAODContrato();
        ms= new MServicio();
    }
    
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into dcontrato values("+numeroc+",'"+codigos+"',"+cantidadc+",'A')";
        ddcont.agregar(sentencia);
        enc=true;
        return enc;
    }
    public boolean consultar(){
        boolean enc=false;
        String sentencia="select * from dcontrato where numeroc="+numeroc+" and codigos='"+codigos+"'";
        
        ResultSet rs=ddcont.buscar(sentencia);
        try {
            if(rs.next()){
                numeroc=rs.getInt("numeroc");
                codigos=rs.getString("codigos");
                cantidadc=rs.getInt("cantidadc");
                statusdc=rs.getString("statusdc");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MDContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update dcontrato set cantidadc="+cantidadc+",statusdc='"+statusdc+"' where numeroc="+numeroc+" and codigos='"+codigos+"'";
        ddcont.modificar(sentencia);
        enc=true;
        return enc;
    }
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="delete from dcontrato where numeroc="+numeroc+" and codigos='"+codigos+"'";
        ddcont.eliminar(sentencia);
        enc=true;
        return enc;
    }
    
    public MServicio getMs() {
        return ms;
    }

    public void setMs(MServicio ms) {
        this.ms = ms;
    }
    
    public String getCodigos() {
        return codigos;
    }

    public void setCodigos(String codigos) {
        this.codigos = codigos;
    }

    public String getStatusdc() {
        return statusdc;
    }

    public void setStatusdc(String statusdc) {
        this.statusdc = statusdc;
    }

    public int getCantidadc() {
        return cantidadc;
    }

    public void setCantidadc(int cantidadc) {
        this.cantidadc = cantidadc;
    }

    public int getNumeroc() {
        return numeroc;
    }

    public void setNumeroc(int numeroc) {
        this.numeroc = numeroc;
    }

    
}
