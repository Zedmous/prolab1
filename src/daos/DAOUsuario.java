
package daos;

import java.sql.ResultSet;

public class DAOUsuario extends DAO{
    
    public DAOUsuario(){
        
    }
    
    public ResultSet ingresar(String sentencia){
        ResultSet rs;
        getMc().abrirConexion();
        rs=getMc().consultar(sentencia);
        getMc().cerrarConexion();
        return rs;
    }
}
