
package generales;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
public class Fecha {
    private Calendar can; 
    
    public Fecha(){
        can = new GregorianCalendar();
    }
    
    public String getFechaeuropea() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }
    public String getFechalatina() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
    
    public String getHoraactual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }
    public String getHora() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("HH");
        return formateador.format(ahora);
    }

    public Date sumarFechasDias(java.util.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.util.Date(cal.getTimeInMillis());
        //return 
    }
    public String deFechaaString(java.util.Date fecha) {
        String fechan="";
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.add(Calendar.DATE, 0);
        int mes=cal.get(Calendar.MONTH)+1;
        String auxmes="";
        if(mes>=1 && mes<=9){
            auxmes="0"+String.valueOf(mes);
        }else{
            auxmes=String.valueOf(mes);
        }
        fechan=String.valueOf(cal.get(Calendar.DAY_OF_MONTH)+"-"+auxmes+"-"+String.valueOf(cal.get(Calendar.YEAR)));
        return fechan;
        //return 
    }
    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public synchronized java.util.Date deStringaFecha(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            return null;
        }
    }

    public Date restarFechasDias(java.util.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new java.util.Date(cal.getTimeInMillis());
    }

    public synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }
    public synchronized boolean fechaesmenoroigualafecha(Date fechaInicial, Date fechaFinal) {
        boolean validar=false;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
            
        }
        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
            
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
	if(fechaInicialMs<=fechaFinalMs){
		validar=false;
	}else{
		validar=true;
	}
	return validar;
    }
    public synchronized boolean fechaesmenorafecha(Date fechaInicial, Date fechaFinal) {
        boolean validar=false;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
            
        }
        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
            
        }
        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        if(fechaInicialMs<fechaFinalMs){
            validar=false;
        }else{
            validar=true;
        }
        return validar;
    }
    public int capturardia(String fecha){
        Date d = sumarFechasDias(deStringaFecha(fecha), 0);
        return d.getDay();
    }
    public int capturardiasiguiente(String fecha){
        Date d = sumarFechasDias(deStringaFecha(fecha), 1);
        return d.getDay();
    }
    public int capturardiaanterior(String fecha){
        Date d = sumarFechasDias(deStringaFecha(fecha), -1);
        return d.getDay();
    }
    public String mostrarDiasLenguaje(int dia){
        String diasemana="";
        if(dia==0){
            diasemana="Domingo";
        }else if(dia==1){
            diasemana="Lunes";
        }else if(dia==2){
            diasemana="Martes";
        }else if(dia==3){
            diasemana="Miercoles";
        }else if(dia==4){
            diasemana="Jueves";
        }else if(dia==5){
            diasemana="Viernes";
        }else{
            diasemana="Sabado";
        }
        return diasemana;
    }
    public String capturardia(int dia){
        String diasemana="";
        if(dia==0){
            diasemana="d";
        }else if(dia==1){
            diasemana="l";
        }else if(dia==2){
            diasemana="m";
        }else if(dia==3){
            diasemana="i";
        }else if(dia==4){
            diasemana="j";
        }else if(dia==5){
            diasemana="v";
        }else{
            diasemana="s";
        }
        return diasemana;
    }
    
    public String fecharestardias(int dias){
        String fechan="";
        Date fechaActual = Calendar.getInstance().getTime();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fechaActual.getTime());
        cal.add(Calendar.DATE, dias);
        int mes=cal.get(Calendar.MONTH)+1;
        fechan=String.valueOf(cal.get(Calendar.YEAR))+"-"+String.valueOf(mes)+"-"+String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        return fechan;
    }
    public String fechasumardias(int dias){
        String fechan="";
        Date fechaActual = Calendar.getInstance().getTime();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fechaActual.getTime());
        cal.add(Calendar.DATE, dias);
        int mes=cal.get(Calendar.MONTH)+1;
        fechan=String.valueOf(cal.get(Calendar.YEAR))+"-"+String.valueOf(mes)+"-"+String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        return fechan;
    }
    //@para validar fecha
    public boolean isFechaValida(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fechax);
            return true;
        } catch (ParseException e) {
            return false;
        }
        
    }
    public boolean isHora(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fechax);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public String cfechadbdapantalla(String fecha){
        String fechac="",ano="",mes="",dia="";
        String primerguion = fecha.substring(4,5);
        String segundoguion =fecha.substring(7,8);
        if(primerguion.equalsIgnoreCase("-")){
            dia= fecha.substring(8,10);
            mes= fecha.substring(5,7);
            ano= fecha.substring(0,4);
        }
        fechac=dia+"-"+mes+"-"+ano;
        return fechac;
    }
    
    public String cfechadpantallaabd(String fecha){
        String fechac="",ano="",mes="",dia="";
        String aux = fecha.substring(1,2);
        String aux2 = fecha.substring(2,3);
        String aux3 = fecha.substring(3,4);
        String aux4 = fecha.substring(4,5);
        String aux5 = fecha.substring(5,6);
        if(aux2.equalsIgnoreCase("-") && aux5.equalsIgnoreCase("-")){
            dia= fecha.substring(0,2);
            mes= fecha.substring(3,5);
            ano= fecha.substring(6,10);
        }
        if(aux.equalsIgnoreCase("-") && aux3.equalsIgnoreCase("-")){
            dia= fecha.substring(0,1);
            mes= fecha.substring(2,3);
            ano= fecha.substring(4,8);
        }
        if(aux.equalsIgnoreCase("-") && aux4.equalsIgnoreCase("-")){
            dia= fecha.substring(0,1);
            mes= fecha.substring(2,4);
            ano= fecha.substring(5,9);
        }
        if(aux2.equalsIgnoreCase("-") && aux4.equalsIgnoreCase("-")){
            dia= fecha.substring(0,2);
            mes= fecha.substring(3,4);
            ano= fecha.substring(5,9);
        }
        fechac=ano+"-"+mes+"-"+dia;
        return fechac;
    }
    public String registrarfecha(){
        String fecha="";
        int ano,dia,mes;
        fecha = Integer.toString(can.get(Calendar.YEAR))+"-"+Integer.toString(can.get(Calendar.MONTH)+1)+"-"+Integer.toString(can.get(Calendar.DATE));
        return fecha;
    }
    public String mostrardia(){
        String fecha="";
        int ano,dia,mes;
        fecha = Integer.toString(can.get(Calendar.DAY_OF_WEEK));
        
        return fecha;
    }
    public String mostrarfecha(){
        String fecha="";
        int ano,dia,mes;
        fecha = Integer.toString(can.get(Calendar.DATE))+"-"+Integer.toString(can.get(Calendar.MONTH)+1)+"-"+Integer.toString(can.get(Calendar.YEAR));
        return fecha;
    }
    public String hora(){
        String reloj="";
        reloj = Integer.toString(can.get(Calendar.HOUR))+":"+Integer.toString(can.get(Calendar.MINUTE))+":"+Integer.toString(can.get(Calendar.SECOND));
        return reloj;
    }
}
