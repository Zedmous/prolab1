
package modelos;

import daos.DAOAsignacionec;
import generales.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MAsignacionec {
    private String fechaaec,cedulae,codigoeaec,codigot;
    private int numeroc;
    private MEmpleado me;
    private MContrato mcont;
    private Fecha fe;
    private DAOAsignacionec daec;
    
    public MAsignacionec(){
        mcont= new MContrato();
        me=new MEmpleado();
        fe= new Fecha();
        daec= new DAOAsignacionec();
    }
    
    public boolean validarasignacionec(){
        boolean validar=false;
        //depende de lo que este en el detalle del contrato debe verificar 
        //que esta facturado todo lo que esta dentro de el
        return validar;
    }
    
    
    
    public String getFechaaec() {
        return fechaaec;
    }

    public void setFechaaec(String fechaaec) {
        this.fechaaec = fechaaec;
    }

    public String getCedulae() {
        return cedulae;
    }

    public void setCedulae(String cedulae) {
        this.cedulae = cedulae;
    }

    public String getCodigoaec() {
        return codigoeaec;
    }

    public void setCodigoeaec(String codigoeaec) {
        this.codigoeaec = codigoeaec;
    }

    public int getNumeroc() {
        return numeroc;
    }

    public void setNumeroc(int numeroc) {
        this.numeroc = numeroc;
    }

    public MEmpleado getMe() {
        return me;
    }

    public void setMe(MEmpleado me) {
        this.me = me;
    }

    public MContrato getMcont() {
        return mcont;
    }

    public void setMcont(MContrato mcont) {
        this.mcont = mcont;
    }

    /**
     * @return the codigot
     */
    public String getCodigot() {
        return codigot;
    }

    /**
     * @param codigot the codigot to set
     */
    public void setCodigot(String codigot) {
        this.codigot = codigot;
    }
    
    
    
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into asignacionec values('"+fechaaec+"','"+cedulae+"',"+numeroc+",'"+codigoeaec+"','"+codigot+"')";
        daec.agregar(sentencia);
        enc=true;
        return enc;
    }
    public boolean consultar(){
        boolean enc=false;
        String sentencia="select * from asignacionec where fechaaec='"+fechaaec+"' and cedulae='"+cedulae+"'";
        ResultSet rs=daec.buscar(sentencia);
        try {
            if(rs.next()){
                fechaaec=fe.cfechadbdapantalla(rs.getString("fechaaec"));
                cedulae=rs.getString("cedulae");
                numeroc=rs.getInt("numeroc");
                codigoeaec=rs.getString("codigoeaec");
                codigot=rs.getString("codigot");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MAsignacionec.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update asignacionec set numeroc="+numeroc+",  codigoeaec='"+codigoeaec+"'  where fechaaec='"+fechaaec+"' and cedulae='"+cedulae+"'";
        daec.modificar(sentencia);
        enc=true;
        return enc;
    }
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="delete from asignacionec where fechaaec='"+fechaaec+"' and cedulae='"+cedulae+"'";
        daec.eliminar(sentencia);
        enc=true;
        return enc;
    }
    
}
