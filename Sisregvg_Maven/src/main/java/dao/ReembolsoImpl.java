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

import modelo.Reembolso;

public class ReembolsoImpl extends Conexion implements ICRUD<Reembolso> {

    DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToFecha(String fecha) throws ParseException {
        return  fecha!= null ? new SimpleDateFormat("dd-MM-yyyy").parse(fecha) : null;
    }

    @Override
    public void registrar(Reembolso reembolso) throws Exception {
        String sql = "insert into REEMBOLSO (NOMPER,DNIREE, MOTREE, NLIREE, FORREE, FECREE, AREREE, CENREE, NAHREE, NCUREE, ESTREE) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, reembolso.getNomper());
            ps.setString(2, reembolso.getDni());
            ps.setString(3, reembolso.getMotivo());
            ps.setString(4, reembolso.getNliquidacion());
            ps.setString(5, reembolso.getForma());
            ps.setString(6, formato.format(reembolso.getFecha()));
            ps.setString(7, reembolso.getArea());
            ps.setString(8, reembolso.getCentrodecosto());
            ps.setString(9, reembolso.getNahorroscorriente());
            ps.setString(10, reembolso.getNcuenta());
            ps.setString(11, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar ReembolsoImpl " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Reembolso reembolso) throws Exception {
        String sql = "update REEMBOLSO set MOMPER=?, DNIREE=?, MOTREE=?,NLIREE=?,FORREE=?,FECREE=?,AREREE=?,CENREE=?,NAHREE=?,NCUREE=?,ESTDOC=? where IDREE=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, reembolso.getNomper());
            ps.setString(2, reembolso.getDni());
            ps.setString(3, reembolso.getMotivo());
            ps.setString(4, reembolso.getNliquidacion());
            ps.setString(5, reembolso.getForma());
            ps.setString(6, formato.format(reembolso.getFecha()));
            ps.setString(7, reembolso.getArea());
            ps.setString(8, reembolso.getCentrodecosto());
            ps.setString(9, reembolso.getNahorroscorriente());
            ps.setString(10, reembolso.getNcuenta());
            ps.setString(11, "A");
            ps.setInt(12, reembolso.getId());
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
            ps.setInt(1, reembolso.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List listarTodos() throws Exception {
        List<Reembolso> listadoRee = null;
        Reembolso reembolso;
        String sql = "select * from REEMBOLSO order by IDREE desc";
        try {
            listadoRee = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                reembolso = new Reembolso();
                reembolso.setId(rs.getInt("IDREE"));
                reembolso.setNomper(rs.getString("NOMPER"));
                reembolso.setDni(rs.getString("DNIREE"));
                reembolso.setMotivo(rs.getString("MOTREE"));
                reembolso.setNliquidacion(rs.getString("NLIREE"));
                reembolso.setForma(rs.getString("FORREE"));
                reembolso.setFecha(rs.getDate("FECREE"));
                reembolso.setArea(rs.getString("AREREE"));
                reembolso.setCentrodecosto(rs.getString("CENREE"));
                reembolso.setNahorroscorriente(rs.getString("NAHREE"));
                reembolso.setNcuenta(rs.getString("NCUREE"));
                reembolso.setEstado(rs.getString("ESTREE"));
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

    public List<String> autocompletePersonal(String consulta) throws SQLException, Exception {
        List<String> lista = new ArrayList<>();
        String sql = "select top 30 concat(NOMPER, ', ', APEPER) as PERSONALDESC from Personal where NOMPER like ?";
        try {
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, "%" + consulta + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("PERSONALDESC"));
            }
        } catch (Exception e) {
            System.out.println("Error en autocompletePersonal" + e.getMessage());
        }
        return lista;
    }

    public String obtenerNomper(String cadenaPersonal) throws SQLException, Exception {
        String sql = "select NOMPER from PERSONAL where concat(NOMPER, ', ', APEPER) = ?";
        try {
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, cadenaPersonal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("NOMPER");
            }
            return rs.getString("NOMPER");
        } catch (Exception e) {
            System.out.println("Error en obtenerNomper " + e.getMessage());
            throw e;
        }
    }

}
