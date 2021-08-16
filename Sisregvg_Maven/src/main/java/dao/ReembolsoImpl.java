package dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Liquidacion;
import modelo.Reembolso;

public class ReembolsoImpl extends Conexion implements ICRUD<Reembolso> {

    DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToFecha(String fecha) throws ParseException {
        return fecha != null ? new SimpleDateFormat("dd-MM-yyyy").parse(fecha) : null;
    }

    @Override
    public void registrar(Reembolso reembolso) throws Exception {
        String sql = "insert into REEMBOLSO (IDLIQ,MOTREE,FECREE, AREREE, CENREE,DESREE,FORREE,PAGREE, NAHREE,NCUREE, SALREE, ESTREE) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, reembolso.getLiq().getIDLIQ());
            ps.setString(2, reembolso.getMOTREE());
            ps.setString(3, formato.format(reembolso.getFECREE()));
            ps.setString(4, reembolso.getARERRE());
            ps.setString(5, reembolso.getCENREE());
            ps.setString(6, reembolso.getDESREE());
            ps.setString(7, reembolso.getFORREE());
            ps.setString(8, reembolso.getPAGREE());
            ps.setString(9, reembolso.getNAHREE());
            ps.setString(10, reembolso.getNCUREE());
            ps.setDouble(11, reembolso.getSALREE());
            ps.setString(12, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Registrar ReembolsoImpl " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Reembolso reembolso) throws Exception {
        String sql = "update REEMBOLSO set IDLIQ=?, MOTREE=?, FECREE=?,AREREE=?,CENREE=?,DESREE=?,FORREE=?,PAGREE=?,NAHREE=?,NCUREE=?,SALREE=?,ESTREE=? where IDREE=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, reembolso.getLiq().getIDLIQ());
            ps.setString(2, reembolso.getMOTREE());
            ps.setString(3, formato.format(reembolso.getFECREE()));
            ps.setString(4, reembolso.getARERRE());
            ps.setString(5, reembolso.getCENREE());
            ps.setString(6, reembolso.getDESREE());
            ps.setString(7, reembolso.getFORREE());
            ps.setString(8, reembolso.getPAGREE());
            ps.setString(9, reembolso.getNAHREE());
            ps.setString(10, reembolso.getNCUREE());
            ps.setDouble(11, reembolso.getSALREE());
            ps.setString(12, "A");
            ps.setInt(13, reembolso.getIDREE());
            ps.executeUpdate();
            ps.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar ReembolsoImpl: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Reembolso reembolso) throws Exception {
        String sql = "delete from REEMBOLSO where IDREE=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, reembolso.getIDREE());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    public List listarTodos(int tipo) throws Exception {
        List<Reembolso> listadoRee = null;
        Reembolso reembolso;
        String sql = "";
        switch (tipo) {
            case 1:
                sql = "SELECT * FROM vREEMBOLSOA";
                break;
            case 2:
                sql = "SELECT * FROM vREEMBOLSOI";
                break;
            case 3:
                sql = "SELECT * FROM vREEMBOLSOT";
                break;
        }
        try {
            listadoRee = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                reembolso = new Reembolso();
                reembolso.setIDREE(rs.getInt("IDREE"));
                reembolso.setNOMPER(rs.getString("NOMPER"));
                reembolso.setDNIPER(rs.getString("DNIPER"));
                reembolso.setMOTREE(rs.getString("MOTREE"));
                reembolso.setFECREE(rs.getDate("FECREE"));
                reembolso.setARERRE(rs.getString("AREREE"));
                reembolso.setCENREE(rs.getString("CENREE"));
                reembolso.setDESREE(rs.getString("DESREE"));
                reembolso.setIDLIQ(rs.getInt("IDLIQ"));
                reembolso.setFORREE(rs.getString("FORREE"));
                reembolso.setPAGREE(rs.getString("PAGREE"));
                reembolso.setNAHREE(rs.getString("NAHREE"));
                reembolso.setNCUREE(rs.getString("NCUREE"));
                reembolso.setSALREE(rs.getDouble("SALREE"));
                listadoRee.add(reembolso);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodosImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listadoRee;
    }

    @Override
    public List<Reembolso> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void DeleteEstado(Reembolso reembolso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
