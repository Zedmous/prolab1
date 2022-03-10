
package modelos;
import daos.DAOFactura;
import generales.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MFactura {
    private int numerof,numeroc;
    private String fechaef,horaef,fechaif,fechacf,statusf;
    private ArrayList<MDFactura> lmdf;
    private MContrato mcont;
    private DAOFactura dfac;
    private Fecha fe;
    public MFactura(){
        lmdf = new ArrayList<MDFactura>();
        dfac= new DAOFactura();
        mcont= new MContrato();
        fe= new Fecha();
    }
    
    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into factura values("+numerof+",'"+fechaef+"','"+horaef+"','"+fechaif+"','"+fechacf+"',"+numerof+",'A')";
        dfac.agregar(sentencia);
        enc=true;
        return enc;
    }
    public boolean consultar(){
        boolean enc=false;
        String sentencia="select * from factura where numerof="+numerof;
        System.out.println(sentencia);
        ResultSet rs=dfac.buscar(sentencia);
        try {
            if(rs.next()){
                numerof=rs.getInt("numerof");
                fechaef=fe.cfechadbdapantalla(rs.getString("fechaef"));
                horaef=rs.getString("horaef");
                fechaif=fe.cfechadbdapantalla(rs.getString("fechaif"));
                fechacf=fe.cfechadbdapantalla(rs.getString("fechacf"));
                numeroc=rs.getInt("numeroc");
                statusf=rs.getString("statusf");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update factura set fechaef='"+fechaef+"', horaef='"+horaef+"', fechaif='"+fechaif+"', fechacf='"+fechacf+"', numeroc="+numeroc+", statusf='"+statusf+"'  where numerof="+numerof;
        dfac.modificar(sentencia);
        enc=true;
        return enc;
    }
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="update factura set statusf='I'  where numerof="+numerof;
        dfac.eliminar(sentencia);
        enc=true;
        return enc;
    }
    
    // EMPIEZA EL VECTOR
    public MDFactura getMDFac(int poss) {
        return lmdf.get(poss);
    }

    public void setMDFac(MDFactura mdf,int poss) {
        lmdf.set(poss, mdf);
    }
    
    public int buscarDServ(String codigos){
        int i=0;
        while(i<this.lmdf.size()){
            if(lmdf.get(i).getCodigos().equalsIgnoreCase(codigos)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public boolean cargarMDFac(MDFactura mdfac) {
        boolean enc = true;
        this.lmdf.add(mdfac);
        return enc;
    }
    
    public boolean borrarMDFac(int poss) {
        boolean enc=true;
        this.lmdf.remove(poss);
        return enc;
    }
    
    public int calcCantMDFac(){
        return lmdf.size();
    }
    
    public void cargarListaFactura(){
        String sentencia="select * from dfactura where numerof="+numerof;
        lmdf = dfac.cargarListaFactura(sentencia);
    }
    
    // TERMINA TODO LO QUE TIENE QUE VER CON EL VECTOR
    public int generarNumeroFactura(){
        int num=0;
        String sentencia="select max(numerof) as nrof from factura";
        System.out.println(sentencia);
        num = dfac.generarNumeroFactura(sentencia);
        return num;
    }
    public int getNumerof() {
        return numerof;
    }

    public void setNumerof(int numerof) {
        this.numerof = numerof;
    }

    public String getFechaef() {
        return fechaef;
    }

    public void setFechaef(String fechaef) {
        this.fechaef = fechaef;
    }

    public String getHoraef() {
        return horaef;
    }

    public void setHoraef(String horaef) {
        this.horaef = horaef;
    }

    public String getFechaif() {
        return fechaif;
    }

    public void setFechaif(String fechaif) {
        this.fechaif = fechaif;
    }

    public String getFechacf() {
        return fechacf;
    }

    public void setFechacf(String fechacf) {
        this.fechacf = fechacf;
    }

    public String getStatusf() {
        return statusf;
    }

    public void setStatusf(String statusf) {
        this.statusf = statusf;
    }

    
    public int getNumeroc() {
        return numeroc;
    }

    public void setNumeroc(int numeroc) {
        this.numeroc = numeroc;
    }
    
    
    public MContrato getMcont() {
        return mcont;
    }

    public void setMcont(MContrato mcont) {
        this.mcont = mcont;
    }

}
