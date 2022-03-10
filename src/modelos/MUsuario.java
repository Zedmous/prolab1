
package modelos;

import daos.DAOUsuario;
import generales.MConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MUsuario {
    private String cedula,nombre,apellido,login,clave,codigonu,status;
    private DAOUsuario dusuario;
    
    public MUsuario(){
        cedula=nombre=apellido=login=clave=codigonu="";
        dusuario=new DAOUsuario();
    }
    
    public boolean ingresar(){
        boolean enc=false;
        int pos;
        String sentencia ="select * from usuario where loginu='"+login+"' and claveu='"+clave+"'";
        ResultSet rs=dusuario.ingresar(sentencia);
        try {
            if(rs.next()){
                cedula=rs.getString("cedulau");
                nombre=rs.getString("nombreu");
                apellido=rs.getString("apellidou");
                login=rs.getString("loginu");
                clave=rs.getString("claveu");
                codigonu=rs.getString("codigonu");
                status=rs.getString("statusu");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCodigonu() {
        return codigonu;
    }

    public void setCodigonu(String codigonu) {
        this.codigonu = codigonu;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
