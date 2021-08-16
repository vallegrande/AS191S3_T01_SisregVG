package dao;

//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Liquidacion;
import modelo.ValeProvisional;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;

public class LiquidacionImpl extends Conexion implements ICRUD<Liquidacion> {

//    private Liquidacion liq;
//    private LiquidacionImpl dao;
//    private List<Liquidacion> listadoLiq;
//    private int tipo = 1;
//    private ExcelOptions excelOpt;
//    private PDFOptions pdfOpt;
//    private ValeProvisional provisional;
//
//    public LiquidacionImpl() {
//    liq  = new Liquidacion();
//        dao = new LiquidacionImpl();
//        listadoLiq = new ArrayList<>();
//    provisional  = new ValeProvisional();
//    }
//    
//    Double saldo = provisional.getImpval() - liq.getGASLIQ();
    DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToFecha(String fecha) throws ParseException {
        return fecha != null ? new SimpleDateFormat("dd-MM-yyyy").parse(fecha) : null;
    }

    @Override
    public void registrar(Liquidacion liq) throws Exception {

        String sql = "insert into LiquidacionEntregasRendir (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ, FORLIQ,GASLIQ, SALLIQ,ESTLIQ) values (?,?,?,?,?,?,?,?,?,?)";
//        liq = new Liquidacion();
//        provisional = new ValeProvisional();
//        Double saldo = provisional.getImpval() - liq.getGASLIQ();
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, liq.getProvisional().getIdval());
            ps.setString(2, liq.getMOTLIQ());
            ps.setString(3, formato.format(liq.getFECLIQ()));
            ps.setString(4, liq.getARELIQ());
            ps.setString(5, liq.getCENLIQ());
            ps.setString(6, liq.getDESLIQ());
            ps.setString(7, liq.getFORLIQ());
            ps.setDouble(8, liq.getGASLIQ());
//            ps.setDouble(9,liq.getProvisional().getImpval() - liq.getGASLIQ());

            ps.setDouble(9, liq.getSALLIQ());
            ps.setString(10, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Registrar la LiqduidaciónImpl  " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    public int obtenerUltimoId() {
        try {
            PreparedStatement ps1 = this.conectar().prepareStatement("SELECT MAX(L.IDLIQ) as IDLIQ FROM LiquidacionEntregasRendir L");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                return rs.getInt("IDLIQ");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en obtenerUltimoIdIMPL" + e.getMessage());
        }
        return -1;
    }

    @Override
    public void modificar(Liquidacion liq) throws Exception {
        String sql = "update LiquidacionEntregasRendir set IDVAL=?, MOTLIQ=?, FECLIQ=?,ARELIQ=?,CENLIQ=?,DESLIQ=?,FORLIQ=?,GASLIQ=?,SALLIQR=?, ESTLIQ=? where IDLIQ=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, liq.getIDVAL());
            ps.setString(2, liq.getMOTLIQ());
            ps.setString(3, formato.format(liq.getFECLIQ()));
            ps.setString(4, liq.getARELIQ());
            ps.setString(5, liq.getCENLIQ());
            ps.setString(6, liq.getDESLIQ());
            ps.setString(7, liq.getFORLIQ());
            ps.setDouble(8, liq.getGASLIQ());
            ps.setDouble(9, liq.getSALLIQ());
            ps.setString(10, "A");
            ps.setInt(12, liq.getIDLIQ());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar LiquidacionImpl: " + e.getMessage());
        }
    }

//    @Override
//    public void eliminar(Personal per) throws Exception {
//        String sql = "delete from PERSONAL where IDPER=?";
//        try {
//            PreparedStatement ps = this.conectar().prepareStatement(sql);
//            ps.setInt(1, per.getIdper());
//            ps.executeUpdate();
//            ps.close();
//        } catch (Exception e) {
//            System.out.println("Error en eliminarD" + e.getMessage());
//        } finally {
//            this.cerrar();
//        }
//    }
    public void DeleteEstado(Liquidacion liq) throws Exception {
        String sql = "update LiquidacionEntregasRendir set ESTLIQ=? where IDLIQ=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, liq.getIDLIQ());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en EliminarEstadoImpl " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    public List listarTodos(int tipo) throws Exception {
        List<Liquidacion> listadoLiq = null;
        Liquidacion liq;
        String sql = "";

        switch (tipo) {
            case 1:
                sql = "SELECT * FROM vLiquidacionEntregasRendirA";
                break;
            case 2:
                sql = "SELECT * FROM vLiquidacionEntregasRendirI";
                break;
            case 3:
                sql = "SELECT * FROM vLiquidacionEntregasRendirT";
                break;
        }
        try {
            listadoLiq = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                liq = new Liquidacion();
                liq.setIDLIQ(rs.getInt("IDLIQ"));
                liq.setNomper(rs.getString("NOMPER"));
                liq.setDniper(rs.getString("dniper"));
                liq.setFECVAL(rs.getDate("FECVAL"));
                liq.setIDVAL(rs.getInt("IDVAL"));
                liq.setMOTLIQ(rs.getString("MOTLIQ"));
                liq.setFECLIQ(rs.getDate("FECLIQ"));
                liq.setARELIQ(rs.getString("ARELIQ"));
                liq.setCENLIQ(rs.getString("CENLIQ"));
                liq.setDESLIQ(rs.getString("DESLIQ"));
                liq.setFORLIQ(rs.getString("FORLIQ"));
                liq.setImpval(rs.getDouble("IMPVAL"));
                liq.setGASLIQ(rs.getDouble("GASLIQ"));
                liq.setSALLIQ(rs.getDouble("SALLIQ"));
                listadoLiq.add(liq);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en listarTodosImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listadoLiq;
    }

    public boolean existe(Liquidacion liq, List<Liquidacion> listaLiq) {
        for (Liquidacion liqui : listaLiq) {
            if (liqui.getDniper().equals(liqui.getDniper())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void eliminar(Liquidacion obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Liquidacion> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
