
package controladores;



import generales.Fecha;
import generales.Matematica;
import generales.Mensajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.MDFactura;
import modelos.MEmpresa;
import modelos.MFactura;
import modelos.MServicio;
import vistas.VFactura;


public class CFactura implements ActionListener{
    private VFactura vfac;
    private MFactura mfac; 
    private Mensajes msj;
    private CEmpresa cmenu;
    private Fecha fe;
    public CFactura(CEmpresa cmenu){
        vfac= new VFactura(cmenu.getVmenu(),false,this);
        vfac.setLocationRelativeTo(null);
        vfac.setResizable(false);
        vfac.setVisible(true);	
        vfac.agregarListener(this);
        vfac.setTitle("FACTURAS");
        vfac.sinregistro();
        this.cmenu=cmenu;
        mfac = new MFactura();
        msj = new Mensajes();
        fe= new Fecha();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(vfac.getBtnbuscar())){
            if("".equals(vfac.getTxtbuscar().getText())){
                msj.mvacio("Ingrese el numero de factura para buscar", "Numero Vacio",vfac.getTxtbuscar());
            }else{
                buscarFactura();
            }
        }
        if(e.getSource().equals(vfac.getBtngenerar())){
            generarNroFactura();
        }
        if (e.getSource().equals(vfac.getBtnverificar())){
            if(vfac.getTxtnumeroc().getText().equalsIgnoreCase("")){
                msj.mvacio("Ingrese un numero de contrato para facturar","Numero de Contrato Vacio",vfac.getTxtnumeroc());
            }else{
                buscarContrato();
            }
        }
        if(e.getSource().equals(vfac.getBtnregistrar())){
            if(vfac.getTxtfechad().getText().equalsIgnoreCase("")){
                msj.mvacio("Debe ingresar una fecha de inicio para la factura", "Fecha Vacio",vfac.getTxtfechad());
            }else if(!fe.isFechaValida(vfac.getTxtfechad().getText())){
                msj.mvacio("Por favor ingrese una Fecha de inicio valida DD/MM/AAAA","Fecha Invalidad",vfac.getTxtfechad());
            }else if(vfac.getTxtfechah().getText().equalsIgnoreCase("")){
                msj.mvacio("Debe ingresar una fecha de culminacion para la factura", "Fecha Vacio",vfac.getTxtfechah());
            }else if(!fe.isFechaValida(vfac.getTxtfechah().getText())){
                msj.mvacio("Por favor ingrese una Fecha de culminacion valida DD/MM/AAAA","Fecha Invalidad",vfac.getTxtfechah());
            }else if(fe.fechaesmenorafecha(fe.deStringaFecha(vfac.getTxtfechad().getText()),fe.deStringaFecha(vfac.getTxtfechah().getText()))){
                msj.mvacio("La fecha final debe ser mayor a la fecha inicial","Fechas Invalidas",vfac.getTxtfechad());
            }else if(vfac.getTxtnumeroc().getText().equalsIgnoreCase("")){
                msj.mvacio("Verifique el numero de contrato para registrar la factura", "Numero de Contrato Vacio",vfac.getTxtnumeroc());
            }else{
                registrar();
            }
        }
        
        if(e.getSource().equals(vfac.getBtncancelar())){
            cancelar();
        }
        if(e.getSource().equals(vfac.getBtnsalir())){
            salir();
        }
        
    }
    public void buscarFactura(){
        mfac= new MFactura(); // DEBES GENERAR UN NUEVO ESPACIO
        mfac.setNumerof(Integer.parseInt(vfac.getTxtbuscar().getText()));
        if(mfac.consultar()){
            mfac.cargarListaFactura();
            vfac.getTxtnumerof().setText(Integer.toString(mfac.getNumerof()));
            vfac.getTxtfecha().setText(mfac.getFechaef());
            vfac.getTxthora().setText(mfac.getHoraef());
            vfac.getTxtfechad().setText(mfac.getFechaif());
            vfac.getTxtfechah().setText(mfac.getFechacf());
            mfac.getMcont().setNumeroc(mfac.getNumeroc());
            if(mfac.getMcont().consultar()){
                vfac.getTxtnumeroc().setText(String.valueOf(mfac.getNumeroc()));
                vfac.getTxtrif().setText(mfac.getMcont().getRifc());
                mfac.getMcont().getMcli().setRif(mfac.getMcont().getRifc());
                if(mfac.getMcont().getMcli().consultar()){
                    vfac.getTxtnombrecli().setText(mfac.getMcont().getMcli().getNombre());
                }
            }
            cargarTabla();
            vfac.encregistro();
        }else{
            msj.minformando("Factura no registrado");
        }
    }
    
    public final void generarNroFactura(){
        mfac = new MFactura();
        vfac.getTxtnumerof().setText(String.valueOf(mfac.generarNumeroFactura()));
        vfac.getTxtfecha().setText(fe.getFechalatina());
        vfac.getTxthora().setText(fe.getHoraactual());
        vfac.nrogenerado();
    }
    public void buscarContrato(){
        mfac.getMcont().setNumeroc(Integer.parseInt(vfac.getTxtnumeroc().getText()));
        if(mfac.getMcont().consultar()){
            mfac.getMcont().cargarListaContrato();
            vfac.getTxtrif().setText(mfac.getMcont().getRifc());
            mfac.getMcont().getMcli().setRif(mfac.getMcont().getRifc());
            if(mfac.getMcont().getMcli().consultar()){
                vfac.getTxtnombrecli().setText(mfac.getMcont().getMcli().getNombre());
            }
            int i=0;
            limpiarTabla();
            while(i<mfac.getMcont().calcCantMDCon()){
                MDFactura auxdfac = new MDFactura();//esto es porque por cada nuevo detale que genere en el vector debocrear un nuevo espacio de memoria
                auxdfac.setCodigos(mfac.getMcont().getMDCon(i).getCodigos());
                auxdfac.setNumerof(Integer.parseInt(vfac.getTxtnumerof().getText()));
                auxdfac.setCantidadf(mfac.getMcont().getMDCon(i).getCantidadc());
                mfac.getMcont().getMDCon(i).getMs().setCodigo(mfac.getMcont().getMDCon(i).getCodigos());
                if(mfac.getMcont().getMDCon(i).getMs().consultar()){
                   auxdfac.setPreciodf(mfac.getMcont().getMDCon(i).getMs().getPrecio());
                }
                mfac.cargarMDFac(auxdfac);
                i++;
            }
            cargarTabla();
            vfac.encontradoContrato();
        }else{
            msj.minformando("Contrato no registrado");
        }
    }
    public void cargarTabla(){
        Matematica mat = new Matematica();
        MEmpresa mempre= new MEmpresa();
        int i=0;
        limpiarTabla();
        double acum=0;
        while(i<mfac.calcCantMDFac()){
            mfac.getMDFac(i).getMs().setCodigo(mfac.getMDFac(i).getCodigos());
            vfac.getTbdetalle().setValueAt(mfac.getMDFac(i).getCodigos(), i, 0);
            if(mfac.getMDFac(i).getMs().consultar()){
                vfac.getTbdetalle().setValueAt(mfac.getMDFac(i).getMs().getNombre(), i, 1);
                acum+=mat.redondear(mfac.getMDFac(i).getMs().getPrecio()*mfac.getMDFac(i).getCantidadf());
                vfac.getTbdetalle().setValueAt(mfac.getMDFac(i).getMs().getPrecio(), i, 3);
            }
            vfac.getTbdetalle().setValueAt(mfac.getMDFac(i).getCantidadf(), i, 2);
            vfac.getTbdetalle().setValueAt(mat.redondear(mfac.getMDFac(i).getCantidadf()*mfac.getMDFac(i).getMs().getPrecio()), i, 4);
            i++;
        }
        vfac.getTxtsubtotal().setText(String.valueOf(mat.redondear(acum)));
        vfac.getTxtsubtotaliva().setText(String.valueOf(mat.redondear(acum*0.12)));
        vfac.getTxttotal().setText(String.valueOf(mat.redondear(acum+(acum*0.12))));
    }
    public void limpiarTabla(){
        int i=0;
        while(i<5){
            vfac.getTbdetalle().setValueAt("", i, 0);
            vfac.getTbdetalle().setValueAt("", i, 1);
            vfac.getTbdetalle().setValueAt("", i, 2);
            vfac.getTbdetalle().setValueAt("", i, 3);
            vfac.getTbdetalle().setValueAt("", i, 4);
            i++;
        }
    }
    
    public void registrar(){
        MFactura auxmfac = new MFactura();
        auxmfac.setNumerof(Integer.parseInt(vfac.getTxtnumerof().getText()));
        if(auxmfac.consultar()){
            //aqui va el codigo en caso de que quieran actualizar los vigiliantes contratados
        }else{
            registraFactura();
            registratDFactura();
        }
        vfac.getBtnregistrar().setEnabled(false);
        vfac.getBtnimprimir().setEnabled(true);
    }
    public void registraFactura(){
        mfac.setNumerof(Integer.parseInt(vfac.getTxtnumerof().getText()));
        mfac.setFechaef(vfac.getTxtfecha().getText());
        mfac.setHoraef(vfac.getTxthora().getText());
        mfac.setFechaif(vfac.getTxtfechad().getText());
        mfac.setFechacf(vfac.getTxtfechah().getText());
        mfac.setNumeroc(Integer.parseInt(vfac.getTxtnumeroc().getText()));
        if(mfac.agregar()){
            msj.minformando("Factura Registrada Exitoxamente");
        }
    }
    
    public void registratDFactura(){
        for(int i =0; i<mfac.calcCantMDFac(); i++){
            mfac.getMDFac(i).agregar();
        }
    }
    
    private void Imprimir(){
   
    }
    public void cancelar(){
        vfac.sinregistro();
        limpiarTabla();
    }
       
    public void salir(){
        vfac.sinregistro();
        vfac.dispose();
        cmenu.setAfactura(false);
    }
    
    
}
