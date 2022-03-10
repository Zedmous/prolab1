
package modelos;

import daos.DAOCliente;
import generales.MConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MCliente {
    private String rif,nombre,direccion,telefono,codigotc,status;
    //private MConexion mc;
    private DAOCliente dcli;
    public MCliente(){
        rif=nombre=direccion=telefono=codigotc=status="";
        //this.mc=new MConexion();
        dcli=new DAOCliente();
    }

    
    public String getRif() {
        return rif;
    }

    
    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigotc() {
        return codigotc;
    }

    public void setCodigotc(String codigotc) {
        this.codigotc = codigotc;
    }
    
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into cliente values('"+rif.toLowerCase()+"','"+nombre+"','"+telefono+"','"+direccion+"','"+codigotc+"','"+status+"')";
        dcli.agregar(sentencia);
        return enc;
    }
    
    public boolean consultar(){
        boolean enc = false;
        String sentencia="select * from cliente where rifc='"+rif.toLowerCase()+"'";
        System.out.println(sentencia);
        ResultSet rs;
        rs=dcli.buscar(sentencia);
        try {
            if(rs.next()){
                rif=rs.getString("rifc");
                nombre=rs.getString("nombrec");
                direccion=rs.getString("direccionc");
                telefono=rs.getString("nrotelefonoc");
                codigotc=rs.getString("codigotc");
                status=rs.getString("statusc");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update cliente set nombrec='"+nombre+"',nrotelefonoc='"+telefono+"',direccionc='"+direccion+"',codigotc='"+codigotc+"',statusc='"+status+"'  where rifc='"+rif.toLowerCase()+"'";
        dcli.modificar(sentencia);
        return enc;
    }
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="update cliente set statusc='I'  where rifc='"+rif.toLowerCase()+"'";
        dcli.eliminar(sentencia);
        return enc;
    }
    
    public boolean reactivar(){
        boolean enc=false;
        String sentencia="update cliente set statusc='A'  where rifc='"+rif.toLowerCase()+"'";
        dcli.reactivar(sentencia);
        return enc;
    }
}
