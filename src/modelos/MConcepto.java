
package modelos;

import daos.DAOConcepto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MConcepto {
    private String codigo,nombre,codigotc,status;
    private double valor;
    private DAOConcepto dconcepto;
    public MConcepto(){
        dconcepto= new DAOConcepto();
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigotc() {
        return codigotc;
    }

    public void setCodigotc(String codigotc) {
        this.codigotc = codigotc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into concepto values('"+codigo.toLowerCase()+"','"+nombre+"','"+codigotc+"',"+valor+",'"+status+"')";
        dconcepto.agregar(sentencia);
        return enc;
    }
    
    
    public boolean consultar(){
        boolean enc = false;
        String sentencia="select * from concepto where codigoc='"+codigo.toLowerCase()+"'";
        System.out.println(sentencia);
        ResultSet rs;
        rs=dconcepto.buscar(sentencia);
        try {
            if(rs.next()){
                codigo=rs.getString("codigoc");
                codigotc=rs.getString("codigotc");
                nombre=rs.getString("nombrec");
                valor=rs.getDouble("valorc");
                status=rs.getString("statusc");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MConcepto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update concepto set nombrec='"+nombre+"',codigotc='"+codigotc+"',valorc='"+valor+"',statusc='"+status+"' where codigoc='"+codigo.toLowerCase()+"'";
        dconcepto.modificar(sentencia);
        return enc;
    }
    public boolean eliminar(){
        boolean enc = false;
        String sentencia="update concepto set statusc='I' where codigoc='"+codigo.toLowerCase()+"'";
        dconcepto.eliminar(sentencia);
        return enc;
    }
    
    public boolean reactivar(){
        boolean enc = false;
        String sentencia="update concepto set statusc='A' where codigoc='"+codigo.toLowerCase()+"'";
        dconcepto.reactivar(sentencia);
        return enc;
    }
    
}
