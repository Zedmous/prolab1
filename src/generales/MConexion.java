package generales;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MConexion {
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    //en todas las conexiones estos atributos son los mas 
    //importante porque indican el ususario, la base de datos y la clave
    private String usuario,clave,bd;
    // las SQLException es aquella que nos indica cuando nos equivocaos que estamso ahciendo algo mal, nos indica los errores por eso aparecen a cada rato cuanso se tarbajan con bd
    //metodo para abrir la conexion
    public void abrirConexion(){
        try {
            //conexion a mysql
            //setCon(DriverManager.getConnection("jdbc:mysql://localhost/"+bd,usuario,clave));
            //conexion a postgresql
            setCon(DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+bd,usuario,clave));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //metodo para cerrar la conexion
    public void cerrarConexion(){
        try {
            getCon().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //metodo para hacer registros, modificaciones o eliminaciones
    public int ejecutar(String sentencia){
      int a=0;
        try {
            setStm(getCon().createStatement());
             a = getStm().executeUpdate(sentencia);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return a;
    }
    //metodo para hacer consultas
    public ResultSet consultar(String sentencia){
        try{
            setStm(getCon().createStatement());
            setRs(getStm().executeQuery(sentencia));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return getRs();
    } 
    //metodo constructor de la clase aqui se definen los valores de las conexion
    // a que motor de base de datos trabajara
    // se dice el ususario , clave y usuario
    //se indica tambien que driver de conexion estamos usando
    public MConexion() {
        usuario="postgres";
        clave="8565203";// la clave en mi caso la defini de esta forma
        bd="labempresavig";
        try {
            //esto es para mysql
            //Class.forName("com.mysql.jdbc.Driver");
            //esto es para postgresql
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
}
