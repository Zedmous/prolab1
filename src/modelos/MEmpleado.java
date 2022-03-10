
package modelos;

import daos.DAOEmpleado;
import generales.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MEmpleado {
    private String cedula,nombre,apellido,direccion,telefono,fechaing,fechaegr,diaslibres,codigoc,status;
    
    private MCargo mcarg = new MCargo();
    private Fecha fe = new Fecha();
    private DAOEmpleado dempleado;
    public MEmpleado(){
        cedula=nombre=apellido=direccion=telefono=fechaing=fechaegr=diaslibres="";
        dempleado= new DAOEmpleado();
    }
    //acme
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into empleado values('"+cedula.toLowerCase()+"','"+nombre+"','"+apellido+"','"+telefono+"','"+fechaing+"','"+fechaegr+"','"+direccion+"','"+diaslibres+"','"+codigoc+"','"+status+"')";
        dempleado.agregar(sentencia);
        return enc;
    }
    
    
    public boolean consultar(){
        boolean enc = false;
        String sentencia="select * from empleado where cedulae='"+cedula.toLowerCase()+"'";
        //String sentencia="select * from empleado where cedulae like '%"+cedula.toLowerCase()+"%'";
        ResultSet rs=dempleado.buscar(sentencia);
        try {
            if(rs.next()){
                cedula=rs.getString("cedulae");
                nombre=rs.getString("nombree");
                apellido=rs.getString("apellidoe");
                direccion=rs.getString("direccione");
                telefono=rs.getString("nrotelefonoe");
                fechaing =fe.cfechadbdapantalla(rs.getString("fechaie"));
                fechaegr=fe.cfechadbdapantalla(rs.getString("fechaee"));
                diaslibres=rs.getString("codigodl");
                codigoc=rs.getString("codigoc");
                status=rs.getString("statuse");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update empleado set nombree='"+nombre+"',apellidoe='"+apellido+"',nrotelefonoe='"+telefono+"',fechaie='"+fechaing+"',fechaee='"+fechaegr+"',direccione='"+direccion+"',codigodl='"+diaslibres+"',codigoc='"+codigoc+"',statuse='"+status+"' where cedulae='"+cedula.toLowerCase()+"'";
        dempleado.modificar(sentencia);
        return enc;
    }
    public boolean eliminar(){
        boolean enc = false;
        String sentencia="update empleado set statuse='I' where cedulae='"+cedula.toLowerCase()+"'";
        dempleado.eliminar(sentencia);
        return enc;
    }
    
    public boolean reactivar(){
        boolean enc = false;
        String sentencia="update empleado set statuse='A' where cedulae='"+cedula.toLowerCase()+"'";
        dempleado.reactivar(sentencia);
        return enc;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getFechaing() {
        return fechaing;
    }

    public void setFechaing(String fechaing) {
        this.fechaing = fechaing;
    }
    
    
    public String getFechaegr() {
        return fechaegr;
    }

    public void setFechaegr(String fechaegr) {
        this.fechaegr = fechaegr;
    }

    public String getDiaslibres() {
        return diaslibres;
    }

    public void setDiaslibres(String diaslibres) {
        this.diaslibres = diaslibres;
    }

    public String getCodigoc() {
        return codigoc;
    }

    public void setCodigoc(String codigoc) {
        this.codigoc = codigoc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MCargo getMcarg() {
        return mcarg;
    }

    public void setMcarg(MCargo mcarg) {
        this.mcarg = mcarg;
    }
}
