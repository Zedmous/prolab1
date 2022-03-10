
package modelos;

import daos.DAOCargo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MCargo {
    private String codigoc,nombrec,status;
    private double sueldomc;
    private DAOCargo daoc;
    public MCargo(){
        codigoc=nombrec=status="";
        sueldomc=0;
        daoc= new DAOCargo();
    }
    
    public String getCodigoc() {
        return codigoc;
    }

    public void setCodigoc(String codigoc) {
        this.codigoc = codigoc;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSueldomc() {
        return sueldomc;
    }

    public void setSueldomc(double sueldomc) {
        this.sueldomc = sueldomc;
    }
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into cargo values('"+codigoc.toLowerCase()+"','"+nombrec+"',"+sueldomc+",'"+status+"')";
        daoc.agregar(sentencia);
        enc=true;
        return enc;
    }
    
    
    public boolean consultar(){
        boolean enc = false;
        String sentencia="select * from cargo where codigoc='"+codigoc.toLowerCase()+"'";
        System.out.println(sentencia);
        ResultSet rs=daoc.buscar(sentencia);
        try {
            if(rs.next()){
                codigoc=rs.getString("codigoc");
                nombrec=rs.getString("nombrec");
                sueldomc=rs.getDouble("sueldomc");
                status=rs.getString("statusc");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update cargo set nombrec='"+nombrec+"',sueldomc='"+sueldomc+"',statusc='"+status+"' where codigoc='"+codigoc.toLowerCase()+"'";
        daoc.modificar(sentencia);
        return enc;
    }
    public boolean eliminar(){
        boolean enc = false;
        String sentencia="update cargo set statusc='I' where codigoc='"+codigoc.toLowerCase()+"'";
        daoc.eliminar(sentencia);
        return enc;
    }
    
    public boolean reactivar(){
        boolean enc = false;
        String sentencia="update cargo set statusc='A' where codigoc='"+codigoc.toLowerCase()+"'";
        daoc.eliminar(sentencia);
        return enc;
    }
}
