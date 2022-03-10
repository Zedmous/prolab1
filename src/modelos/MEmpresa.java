
package modelos;

import generales.Fecha;
import generales.MConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MEmpresa {
    private int cantEmpleado,cantCargos,cantContratos;
    private MConexion mc;
    private ArrayList<MCargo> lmcarg;
    private ArrayList<MEmpleado> lmem;
    private ArrayList<MContrato> lmcontr;
    private ArrayList<MServicio> lmserv;
    private ArrayList<MConcepto> lmconcep;
    private ArrayList<MCliente> lmcli; 
    private Fecha fe;
    public MEmpresa(){
        cantCargos=cantEmpleado=cantContratos=0;
        mc=new MConexion();
        fe= new Fecha();
    }
    
    // VECTOR DE CARGOS
    public MCargo getMCarg(int poss) {
        return getLmcarg().get(poss);
    }

    public void setMCarg(MCargo mcarg,int poss) {
        this.getLmcarg().set(poss, mcarg);
    }
    
   
    
    public int buscarCargopn(String nombrec){
        int i=0;
        //System.out.println("Buscando en la lista cargo: "+nombrec);
        while(i<calcCantCargo()){
            if(getLmcarg().get(i).getNombrec().equalsIgnoreCase(nombrec)){
                //System.out.println("Encontre: "+nombrec+" en la posicion "+i);
                return i;
            }
            i++;
        }
        return -1;
    }
    public int buscarCargopc(String codigoc){
        int i=0;
        //System.out.println("Buscando en la lista cargo: "+codigoc);
        while(i<calcCantCargo()){
            if(getLmcarg().get(i).getCodigoc().equalsIgnoreCase(codigoc)){
                //System.out.println("Encontre: "+codigoc+" en la posicion "+i);
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public boolean cargarCargo() {
        boolean enc = true;
        setLmcarg(new ArrayList<MCargo>());
        String sentencia="select * from cargo";
        mc.abrirConexion();
        ResultSet rs;
        rs=mc.consultar(sentencia);
        try {
            while(rs.next()){
                MCargo auxmcar = new MCargo();
                auxmcar.setCodigoc(rs.getString("codigoc"));
                auxmcar.setNombrec(rs.getString("nombrec"));
                auxmcar.setSueldomc(rs.getDouble("sueldomc"));
                getLmcarg().add(auxmcar);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return enc;
    }
    
    public boolean borrarCargo(int poss) {
        boolean enc=true;
        this.getLmcarg().remove(poss);
        return enc;
    }
    
    public int calcCantCargo(){
        return this.getLmcarg().size();
    }
    ///FIN DE VECTOR DE CARGOS
    
    // VECTOR DE EMPLEADOS
    public MEmpleado getMEmpl(int poss) {
        return getLmem().get(poss);
    }

    public void setMEmpl(MEmpleado me,int poss) {
        this.getLmem().set(poss, me);
    }
    
   
    
    public int buscarEmpleadopc(String cedulae){
        int i=0;
        //System.out.println("Buscando en la lista cargo: "+nombrec);
        while(i<calcCantEmpleadoLibres()){
            if(getLmem().get(i).getCedula().equalsIgnoreCase(cedulae)){
                //System.out.println("Encontre: "+nombrec+" en la posicion "+i);
                return i;
            }
            i++;
        }
        return -1;
    }
    
    
    public boolean cargarEmpleadosLibresdia(String dia) {
        boolean enc = true;
        setLmem(new ArrayList<MEmpleado>());
        //String sentencia="select * from empleado where statuse='A'";
        String sentencia="select * from empleado where codigodl not like '%"+dia.toLowerCase()+"%'";
        System.out.println(sentencia);
        mc.abrirConexion();
        ResultSet rs=mc.consultar(sentencia);
        try {
            while(rs.next()){
                MEmpleado auxmem = new MEmpleado();
                auxmem.setCedula(rs.getString("cedulae"));
                auxmem.setNombre(rs.getString("nombree"));
                auxmem.setApellido(rs.getString("apellidoe"));
                auxmem.setDireccion(rs.getString("direccione"));
                auxmem.setTelefono(rs.getString("nrotelefonoe"));
                auxmem.setFechaing(fe.cfechadbdapantalla(rs.getString("fechaie")));
                auxmem.setFechaegr(fe.cfechadbdapantalla(rs.getString("fechaee")));
                auxmem.setDiaslibres(rs.getString("codigodl"));
                auxmem.setCodigoc(rs.getString("codigoc"));
                auxmem.setStatus(rs.getString("statuse"));
                getLmem().add(auxmem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return enc;
    }
    public void agregarEmpleado(MEmpleado mem){
        getLmem().add(mem);
    }
    public boolean borrarEmpleado(int poss) {
        boolean enc=true;
        this.getLmem().remove(poss);
        return enc;
    }
    
    public int calcCantEmpleadoLibres(){
        return this.getLmem().size();
    }
    //FIN DE VECTOR DE EMPLEADOS
    
    //VECTOR DE CONTRATOS
    
    public MContrato getMContr(int poss) {
        return getLmcontr().get(poss);
    }

    public void setMContr(MContrato mcont,int poss) {
        this.getLmcontr().set(poss, mcont);
    }
    
   
    
    public int buscarContratopn(int numeroc){
        int i=0;
        while(i<getLmcontr().size()){
            if(getLmcontr().get(i).getNumeroc()==numeroc){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    
    public boolean cargarContratosActivos() {
        boolean enc = true;
        setLmcontr(new ArrayList<MContrato>());
        String sentencia="select * from contrato where statusc='A'";
        //String sentencia="select * from empleado where codigodl like '%"+dia.toLowerCase()+"%'";
        mc.abrirConexion();
        ResultSet rs=mc.consultar(sentencia);
        try {
            while(rs.next()){
                MContrato auxmcont = new MContrato();
                auxmcont.setNumeroc(rs.getInt("numeroc"));
                auxmcont.setFechaec(fe.cfechadbdapantalla(rs.getString("fechaec")));
                auxmcont.setHoraec(rs.getString("horaec"));
                auxmcont.setFechaic(fe.cfechadbdapantalla(rs.getString("fechaic")));
                auxmcont.setFechacc(fe.cfechadbdapantalla(rs.getString("fechacc")));
                auxmcont.setCodigotc(rs.getString("codigotc"));
                auxmcont.setRifc(rs.getString("rifc"));
                auxmcont.setStatusc(rs.getString("statusc"));
                getLmcontr().add(auxmcont);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return enc;
    }
    public void agregarContrato(MContrato mcont){
        getLmcontr().add(mcont);
    }
    public boolean borrarContrato(int poss) {
        boolean enc=true;
        this.getLmcontr().remove(poss);
        return enc;
    }
    
    public int calcCantContratos(){
        return this.getLmcontr().size();
    }
    
    //FIN DE VECTOR DE CONTRATOS
    
    //VECTOR DE SERVICIOS
    
    public MServicio getMServ(int poss) {
        return lmserv.get(poss);
    }

    public void setMContr(MServicio mserv,int poss) {
        this.lmserv.set(poss, mserv);
    }
    
   
    
    public int buscarServiciopc(String codigos){
        int i=0;
        while(i<lmserv.size()){
            if(lmserv.get(i).getCodigo().equalsIgnoreCase(codigos)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    
    public boolean cargarServicios() {
        boolean enc = true;
        lmserv= new ArrayList<MServicio>();
        String sentencia="select * from servicio";
        mc.abrirConexion();
        ResultSet rs=mc.consultar(sentencia);
        try {
            while(rs.next()){
                MServicio auxserv = new MServicio();
                auxserv.setCodigo(rs.getString("codigos"));
                auxserv.setNombre(rs.getString("nombres"));
                auxserv.setPrecio(rs.getDouble("precios"));
                auxserv.setStatus(rs.getString("statuss"));
                lmserv.add(auxserv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return enc;
    }
    public void agregarServicio(MServicio mserv){
        lmserv.add(mserv);
    }
    public boolean borrarServicio(int poss) {
        boolean enc=true;
        this.lmserv.remove(poss);
        return enc;
    }
    
    public int calcCantServicio(){
        return this.lmserv.size();
    }
    
    //FIN DE VECTOR DE SERVICIO
    
    //VECTOR DE Concepto
    
    public MConcepto getMConcep(int poss) {
        return lmconcep.get(poss);
    }

    public void setMConcep(MConcepto mconcep,int poss) {
        this.lmconcep.set(poss, mconcep);
    }
    
   
    
    public int buscarConceptopc(String codigoc){
        int i=0;
        while(i<lmserv.size()){
            if(lmserv.get(i).getCodigo().equalsIgnoreCase(codigoc)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    
    public boolean cargarConceptos() {
        boolean enc = true;
        lmconcep= new ArrayList<MConcepto>();
        String sentencia="select * from concepto";
        mc.abrirConexion();
        ResultSet rs=mc.consultar(sentencia);
        try {
            while(rs.next()){
                MConcepto auxconcep = new MConcepto();
                auxconcep.setCodigo(rs.getString("codigoc"));
                auxconcep.setNombre(rs.getString("nombrec"));
                auxconcep.setCodigotc(rs.getString("codigotc"));
                auxconcep.setValor(rs.getDouble("valorc"));
                auxconcep.setStatus(rs.getString("statusc"));
                lmconcep.add(auxconcep);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return enc;
    }
    public void agregarConcepto(MConcepto mconcep){
        lmconcep.add(mconcep);
    }
    public boolean borrarConcepto(int poss) {
        boolean enc=true;
        this.lmconcep.remove(poss);
        return enc;
    }
    
    public int calcCantConcepto(){
        return this.lmconcep.size();
    }
    
    //FIN DE VECTOR DE CONCEPTO
    
    //VECTOR DE CLIENTE
    
    public MCliente getMCli(int poss) {
        return lmcli.get(poss);
    }

    public void setMCli(MCliente mcli,int poss) {
        this.lmcli.set(poss, mcli);
    }
    
   
    
    public int buscarClientepr(String rif){
        int i=0;
        while(i<lmcli.size()){
            if(lmcli.get(i).getRif().equalsIgnoreCase(rif)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    
    public boolean cargarClientes() {
        boolean enc = true;
        lmcli= new ArrayList<MCliente>();
        String sentencia="select * from cliente";
        mc.abrirConexion();
        ResultSet rs=mc.consultar(sentencia);
        try {
            while(rs.next()){
                MCliente auxcli = new MCliente();
                auxcli.setRif(rs.getString("rifc"));
                auxcli.setNombre(rs.getString("nombrec"));
                auxcli.setCodigotc(rs.getString("codigotc"));
                auxcli.setDireccion(rs.getString("direccionc"));
                auxcli.setTelefono("nrotelefonoc");
                auxcli.setStatus(rs.getString("statusc"));
                lmcli.add(auxcli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return enc;
    }
    public void agregarCliente(MCliente mcli){
        lmcli.add(mcli);
    }
    public boolean borrarCliente(int poss) {
        boolean enc=true;
        this.lmcli.remove(poss);
        return enc;
    }
    
    public int calcCantCliente(){
        return this.lmcli.size();
    }
    
    //FIN DE VECTOR DE CONCEPTO
    public int calccantEmpleado(){
        cantEmpleado=0;
        String sentencia="select count(cedulae) as cantidad from empleado";
        mc.abrirConexion();
        ResultSet rs=mc.consultar(sentencia);
        try {
            if(rs.next()){
                cantEmpleado=rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return cantEmpleado;
    }
    
    
    
    //
    public boolean verificartangodeasgnacion(String fechai,String fechaf){
        boolean enc=false;
        String sentencia="select * from asignacionec where (fechaaec>='"+fechai+"' and fechaaec<='"+fechaf+"')";
        mc.abrirConexion();
        ResultSet rs=mc.consultar(sentencia);
        try {
            if(rs.next()){
                enc=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc.cerrarConexion();
        return enc;
    }
    //metodo para calcular el valor de la hora extra establecida por la empresa
    public double calcValorhet(double sueldobm){
        return sueldobm/30/7*1.5;
    }
    
    //metodo para calcular el valor del sueldo diario
    public double calcValorsd(double sueldobm){
        return sueldobm/30;
    }
    
    //para redondear
    
    public int getCantEmpleado() {
        return cantEmpleado;
    }

    public void setCantEmpleado(int cantEmpleado) {
        this.cantEmpleado = cantEmpleado;
    }

    public int getCantCargos() {
        return cantCargos;
    }

    public void setCantCargos(int cantCargos) {
        this.cantCargos = cantCargos;
    }

    /**
     * @return the lmcarg
     */
    public ArrayList<MCargo> getLmcarg() {
        return lmcarg;
    }

    /**
     * @param lmcarg the lmcarg to set
     */
    public void setLmcarg(ArrayList<MCargo> lmcarg) {
        this.lmcarg = lmcarg;
    }

    /**
     * @return the lmem
     */
    public ArrayList<MEmpleado> getLmem() {
        return lmem;
    }

    /**
     * @param lmem the lmem to set
     */
    public void setLmem(ArrayList<MEmpleado> lmem) {
        this.lmem = lmem;
    }

    /**
     * @return the lmcontr
     */
    public ArrayList<MContrato> getLmcontr() {
        return lmcontr;
    }

    /**
     * @param lmcontr the lmcontr to set
     */
    public void setLmcontr(ArrayList<MContrato> lmcontr) {
        this.lmcontr = lmcontr;
    }
    
}
