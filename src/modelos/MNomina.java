
package modelos;

import daos.DAONomina;
import generales.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MNomina {
    private int numeron;
    private String fechaen,horaen,fechain,fechacn,cedulae,statusn;
    private double sueldomn;
    private DAONomina dnomina;
    private MEmpleado me;
    private Fecha fe;
    private ArrayList<MDNomina> lmdn;
    public MNomina(){
        lmdn = new ArrayList<MDNomina>();
        me= new MEmpleado();
        fe= new Fecha();
        dnomina= new DAONomina();
    }
    
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into nomina values("+numeron+",'"+fechaen+"','"+horaen+"','"+fechain+"','"+fechacn+"','"+cedulae+"',"+sueldomn+",'"+statusn+"')";
        dnomina.agregar(sentencia);
        enc=true;
        return enc;
    }
    
    public boolean consultar(){
        boolean enc=false;
        String sentencia="select * from nomina where numeron="+numeron;
        ResultSet rs=dnomina.buscar(sentencia);
        try {
            if(rs.next()){
                numeron=rs.getInt("numeron");
                fechaen=fe.cfechadbdapantalla(rs.getString("fechaen"));
                horaen=rs.getString("horaen");
                fechain=fe.cfechadbdapantalla(rs.getString("fechain"));
                fechacn=fe.cfechadbdapantalla(rs.getString("fechacn"));
                cedulae=rs.getString("cedulae");
                sueldomn=rs.getDouble("sueldobmn");
                statusn=rs.getString("statusn");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update nomina set fechaen='"+fechaen+"', horaen='"+horaen+"', fechain='"+fechain+"', fechacn='"+fechacn+"', cedulae='"+cedulae+"',sueldobmn="+sueldomn+", statusn='"+statusn+"'  where numeron="+numeron;
        dnomina.modificar(sentencia);
        enc=true;
        return enc;
    }
    
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="update nomina set statusn='I'  where numeron="+numeron;
        dnomina.eliminar(sentencia);
        enc=true;
        return enc;
    }
    
    // EMPIEZA EL VECTOR
    public MDNomina getMDNom(int poss) {
        return lmdn.get(poss);
    }

    public void setMDNom(MDNomina mdn,int poss) {
        lmdn.set(poss, mdn);
    }
    
    public int buscarDConcepto(String codigoc){
        int i=0;
        while(i<this.lmdn.size()){
            if(lmdn.get(i).getCodigoc().equalsIgnoreCase(codigoc)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public boolean cargarMDNom(MDNomina mdn) {
        boolean enc = true;
        this.lmdn.add(mdn);
        return enc;
    }
    
    public boolean borrarMDNom(int poss) {
        boolean enc=true;
        this.lmdn.remove(poss);
        return enc;
    }
    
    public int calcCantMDNom(){
        return lmdn.size();
    }
    
    public void cargarListaNomina(){
        String sentencia="select * from dnomina where numeron="+numeron;
        lmdn = new ArrayList<MDNomina>();
        ResultSet rs=dnomina.buscar(sentencia);
        try {
            while(rs.next()){
                MDNomina auxmdf = new MDNomina();
                auxmdf.setNumeron(rs.getInt("numeron"));
                auxmdf.setCodigoc(rs.getString("codigoc"));
                auxmdf.setCantidadn(rs.getInt("cantidadn"));
                auxmdf.setValorn(rs.getDouble("valordn"));
                auxmdf.setStatusdn(rs.getString("statusdn"));
                lmdn.add(auxmdf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // TERMINA TODO LO QUE TIENE QUE VER CON EL VECTOR
    
    public int generarNumeroNomina(){
        int num=0;
        String sentencia="select max(numeron) as nron from nomina";
        num = dnomina.generarNumeroNomina(sentencia);
        return num;
    }
    
    public boolean reactivar(){
        boolean enc=false;
        String sentencia="update nomina set statusc='A'  where numeron='"+numeron+"'";
        dnomina.reactivar(sentencia);
        return enc;
    }
    
    public int getNumeron() {
        return numeron;
    }

    public void setNumeron(int numeron) {
        this.numeron = numeron;
    }

    public String getFechaen() {
        return fechaen;
    }

    public void setFechaen(String fechaen) {
        this.fechaen = fechaen;
    }

    public String getHoraen() {
        return horaen;
    }

    public void setHoraen(String horaen) {
        this.horaen = horaen;
    }

    public String getFechain() {
        return fechain;
    }

    public void setFechain(String fechain) {
        this.fechain = fechain;
    }

    public String getFechacn() {
        return fechacn;
    }

    public void setFechacn(String fechacn) {
        this.fechacn = fechacn;
    }

    public String getCedulae() {
        return cedulae;
    }

    public void setCedulae(String cedulae) {
        this.cedulae = cedulae;
    }

    public String getStatusn() {
        return statusn;
    }

    public void setStatusn(String statusn) {
        this.statusn = statusn;
    }

    public double getSueldomn() {
        return sueldomn;
    }

    public void setSueldomn(double sueldomn) {
        this.sueldomn = sueldomn;
    }

    public MEmpleado getMe() {
        return me;
    }

    public void setMe(MEmpleado me) {
        this.me = me;
    }
    
}
