
package modelos;

import daos.DAODNomina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MDNomina {
    private String codigoc,statusdn;
    private int cantidadn,numeron;
    private double valorn;
    private DAODNomina ddnomi;
    private MConcepto mconcepto;
    
    public MDNomina(){
        ddnomi= new DAODNomina();
        mconcepto= new MConcepto();
    }
    
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into dnomina values("+numeron+",'"+codigoc+"',"+cantidadn+","+valorn+",'"+statusdn+"')";
        ddnomi.agregar(sentencia);
        enc=true;
        return enc;
    }
    public boolean consultar(){
        boolean enc=false;
        String sentencia="select * from dnomina where numeron="+numeron+" and codigoc='"+codigoc+"'";
        ResultSet rs=ddnomi.buscar(sentencia);
        try {
            if(rs.next()){
                numeron=rs.getInt("numeron");
                codigoc=rs.getString("codigos");
                cantidadn=rs.getInt("cantidadn");
                valorn= rs.getDouble("valordn");
                statusdn=rs.getString("statusdn");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MDNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update dnomina set cantidadn="+cantidadn+",valordn="+valorn+",statusdn='"+statusdn+"' where numeron="+numeron+" and codigoc='"+codigoc+"'";
        ddnomi.modificar(sentencia);
        enc=true;
        return enc;
    }
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="delete from dnomina where numeron="+numeron+" and codigoc='"+codigoc+"'";
        ddnomi.eliminar(sentencia);
        enc=true;
        return enc;
    }
    
    public MConcepto getMconcepto() {
        return mconcepto;
    }

    public void setMconcepto(MConcepto mconcepto) {
        this.mconcepto = mconcepto;
    }

    public String getCodigoc() {
        return codigoc;
    }

    public void setCodigoc(String codigoc) {
        this.codigoc = codigoc;
    }

    public String getStatusdn() {
        return statusdn;
    }

    public void setStatusdn(String statusdn) {
        this.statusdn = statusdn;
    }

    public int getCantidadn() {
        return cantidadn;
    }

    public void setCantidadn(int cantidadn) {
        this.cantidadn = cantidadn;
    }

    public int getNumeron() {
        return numeron;
    }

    public void setNumeron(int numeron) {
        this.numeron = numeron;
    }

    public double getValorn() {
        return valorn;
    }

    public void setValorn(double valorn) {
        this.valorn = valorn;
    }
}
