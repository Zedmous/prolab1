
package modelos;

import daos.DAOContrato;
import generales.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MContrato {
    private int numeroc;
    private String fechaec,horaec,fechaic,fechacc,codigotc,rifc,statusc;
    private MCliente mcli;
    private ArrayList<MDContrato> lmdc;
    private Fecha fe;
    private DAOContrato dcont;
    public MContrato(){
        mcli= new MCliente();
        lmdc= new ArrayList<MDContrato>();
        fe= new Fecha();
        dcont= new DAOContrato();
    }

    public boolean agregar(){
        boolean enc=false;
        String sentencia="insert into contrato values("+numeroc+",'"+fechaec+"','"+horaec+"','"+fechaic+"','"+fechacc+"','"+codigotc+"','"+rifc+"','A')";
        dcont.agregar(sentencia);
        enc=true;
        return enc;
    }
    public boolean consultar(){
        boolean enc=false;
        String sentencia="select * from contrato where numeroc="+numeroc;
        ResultSet rs=dcont.buscar(sentencia);
        try {
            if(rs.next()){
                numeroc=rs.getInt("numeroc");
                fechaec=fe.cfechadbdapantalla(rs.getString("fechaec"));
                horaec=rs.getString("horaec");
                fechaic=fe.cfechadbdapantalla(rs.getString("fechaic"));
                fechacc=fe.cfechadbdapantalla(rs.getString("fechacc"));
                codigotc=rs.getString("codigotc");
                rifc= rs.getString("rifc");
                statusc=rs.getString("statusc");
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enc;
    }
    public boolean modificar(){
        boolean enc=false;
        String sentencia="update contrato set fechaec='"+fechaec+"', horaec='"+horaec+"', fechaic='"+fechaic+"', fechacc='"+fechacc+"', codigotc='"+codigotc+"',rifc='"+rifc+"', statusc='"+statusc+"'  where numeroc="+numeroc;
        dcont.modificar(sentencia);
        enc=true;
        return enc;
    }
    
    public boolean eliminar(){
        boolean enc=false;
        String sentencia="update contrato set statusc='I'  where numeroc="+numeroc;
        dcont.eliminar(sentencia);
        enc=true;
        return enc;
    }
    
    public boolean validarcontrato(){
        boolean validar=false;
        //esto dependera si ingreso correctamente los servicios correspondientes
        //con respecto al tipo de contrato y al tipo de cliente
        return validar;
    }
    
    // EMPIEZA EL VECTOR
    public MDContrato getMDCon(int poss) {
        return lmdc.get(poss);
    }

    public void setMDCon(MDContrato mdc,int poss) {
        lmdc.set(poss, mdc);
    }
    
    public int buscarDServ(String codigos){
        int i=0;
        while(i<this.lmdc.size()){
            if(lmdc.get(i).getCodigos().equalsIgnoreCase(codigos)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public boolean cargarMDCon(MDContrato mdc) {
        boolean enc = true;
        this.lmdc.add(mdc);
        return enc;
    }
    
    public boolean borrarMDCon(int poss) {
        boolean enc=true;
        this.lmdc.remove(poss);
        return enc;
    }
    
    public int calcCantMDCon(){
        return lmdc.size();
    }
    
    public void cargarListaContrato(){
        String sentencia="select * from dcontrato where numeroc="+numeroc;
        lmdc = dcont.cargarListaContrato(sentencia);
    }
    public int generarNumeroContrato(){
        int num=0;
        String sentencia="select max(numeroc) as nroc from contrato";
        num = dcont.generarNumeroContrato(sentencia);
        return num;
    }
    
    // termina todo lo relacionado al vector el vector
    public MCliente getMcli() {
        return mcli;
    }

    public void setMcli(MCliente mcli) {
        this.mcli = mcli;
    }

    public int getNumeroc() {
        return numeroc;
    }

    public void setNumeroc(int numeroc) {
        this.numeroc = numeroc;
    }

    public String getFechaec() {
        return fechaec;
    }

    public void setFechaec(String fechaec) {
        this.fechaec = fechaec;
    }

    public String getHoraec() {
        return horaec;
    }

    public void setHoraec(String horaec) {
        this.horaec = horaec;
    }

    public String getFechaic() {
        return fechaic;
    }

    public void setFechaic(String fechaic) {
        this.fechaic = fechaic;
    }

    public String getFechacc() {
        return fechacc;
    }

    public void setFechacc(String fechacc) {
        this.fechacc = fechacc;
    }

    public String getCodigotc() {
        return codigotc;
    }

    public void setCodigotc(String codigotc) {
        this.codigotc = codigotc;
    }

    public String getRifc() {
        return rifc;
    }

    public void setRifc(String rifc) {
        this.rifc = rifc;
    }

    public String getStatusc() {
        return statusc;
    }

    public void setStatusc(String statusc) {
        this.statusc = statusc;
    }
}
