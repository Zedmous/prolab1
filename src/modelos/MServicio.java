
package modelos;

import daos.DAOServicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MServicio {
    private String codigo,nombre,status; 
    private double precio;
    private DAOServicio dservicio;
    public MServicio(){
        dservicio= new DAOServicio();
    }
    
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into servicio values('"+codigo.toLowerCase()+"','"+nombre+"',"+precio+",'"+status+"')";
        dservicio.agregar(sentencia);
        return enc;
    }
    
    
    public boolean consultar(){
        boolean enc = false;
        String sentencia="select * from servicio where codigos='"+codigo.toLowerCase()+"'";
        System.out.println(sentencia);
        ResultSet rs=dservicio.buscar(sentencia);
        
        try {
            if(rs.next()){
                codigo=rs.getString("codigos");
                nombre=rs.getString("nombres");
                precio=rs.getDouble("precios");
                status=rs.getString("statuss");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update servicio set nombres='"+nombre+"',precios='"+precio+"',statuss='"+status+"' where codigos='"+codigo.toLowerCase()+"'";
        System.out.println(sentencia);
        dservicio.modificar(sentencia);
        return enc;
    }
    
    public boolean eliminar(){
        boolean enc = false;
        String sentencia="update servicio set statuss='I' where codigos='"+codigo.toLowerCase()+"'";
        dservicio.eliminar(sentencia);
        return enc;
    }
    
    public boolean reactivar(){
        boolean enc = false;
        String sentencia="update servicio set statuss='A' where codigos='"+codigo.toLowerCase()+"'";
        dservicio.reactivar(sentencia);
        return enc;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
