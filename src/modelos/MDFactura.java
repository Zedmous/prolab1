
package modelos;

import daos.DAODFactura;
import generales.MConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MDFactura {
    private String codigos,statusdf;
    private int numerof,cantidadf;
    private double preciodf;
    private DAODFactura ddfact;
    private MServicio ms;
    public MDFactura(){
        ms = new MServicio();
        ddfact=new DAODFactura();
    }
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into dfactura values("+numerof+",'"+codigos+"',"+cantidadf+","+preciodf+",'A')";
        ddfact.agregar(sentencia);
        enc=true;
        return enc;
    }
    public boolean consultar(){
        boolean enc=false;
        String sentencia="select * from dfactura where numerof="+numerof+" and codigos='"+codigos+"'";
        ResultSet rs=ddfact.buscar(sentencia);
        try {
            if(rs.next()){
                numerof=rs.getInt("numerof");
                codigos=rs.getString("codigos");
                cantidadf=rs.getInt("cantidadf");
                preciodf=rs.getDouble("preciodf");
                statusdf=rs.getString("statusdf");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MDFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update dfactura set cantidadf="+cantidadf+",preciodf="+preciodf+",statusdf='"+statusdf+"' where numerof="+numerof+" and codigos='"+codigos+"'";
        ddfact.modificar(sentencia);
        enc=true;
        return enc;
    }
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="delete from dfactura where numerof="+numerof+" and codigos='"+codigos+"'";
        ddfact.eliminar(sentencia);
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

    public String getStatusdf() {
        return statusdf;
    }

    public void setStatusdf(String statusdf) {
        this.statusdf = statusdf;
    }

    public int getNumerof() {
        return numerof;
    }

    public void setNumerof(int numerof) {
        this.numerof = numerof;
    }

    public int getCantidadf() {
        return cantidadf;
    }

    public void setCantidadf(int cantidadf) {
        this.cantidadf = cantidadf;
    }

    public double getPreciodf() {
        return preciodf;
    }

    public void setPreciodf(double preciodf) {
        this.preciodf = preciodf;
    }
    
}
