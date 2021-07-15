package dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.DeJurada;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;

public class DeJuradaImpl extends Conexion implements ICRUD<DeJurada> {

        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToFecha(String fecha) throws ParseException {
        return  fecha!= null ? new SimpleDateFormat("dd-MM-yyyy").parse(fecha) : null;
    }
   
    @Override
    public void registrar(DeJurada declaracion) throws Exception {
        String sql = "insert into DeclaracionJurada (IMPDEC,PRODEC,CENDEC,NOMPER,DNIDEC, DOMDEC,GASDEC,MOTDEC,FECDEC, ESTDEC) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, declaracion.getImporte());
            ps.setString(2, declaracion.getProyecto());
            ps.setString(3, declaracion.getCentrodecosto());
            ps.setString(4, declaracion.getNomper());
            ps.setString(5, declaracion.getDni());
            ps.setString(6, declaracion.getDomicilio());
            ps.setString(7, declaracion.getGastado());
            ps.setString(8, declaracion.getMotivo());
            ps.setString(9, formato.format(declaracion.getFecha()));
            ps.setString(10, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar DeJuradaImpl " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(DeJurada declaracion) throws Exception {
        String sql = "update DeclaracionJurada set IMPDEC=?, PRODEC=?,CENDEC=?,NOMPER=?,DNIDEC=?, DOMDEC=?,GASDEC=?,MOTDEC=?,FECDEC=?,ESTDEC=? where IDDEC=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, declaracion.getImporte());
            ps.setString(2, declaracion.getProyecto());
            ps.setString(3, declaracion.getCentrodecosto());
            ps.setString(4, declaracion.getNomper());
            ps.setString(5, declaracion.getDni());
            ps.setString(6, declaracion.getDomicilio());
            ps.setString(7, declaracion.getGastado());
            ps.setString(8, declaracion.getMotivo());
            ps.setString(9, formato.format(declaracion.getFecha()));
            ps.setString(10, "A");
            ps.setInt(11, declaracion.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar DeJuradaImpl: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(DeJurada declaracion) throws Exception {
        String sql = "delete from DeclaracionJurada where IDDEC=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, declaracion.getId());
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
        List<DeJurada> listadoDec = null;
        DeJurada declaracion;
        String sql = "select * from DeclaracionJurada order by IDDEC desc ";
        try {
            listadoDec = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                declaracion = new DeJurada();
                declaracion.setId(rs.getInt("IDDEC"));
                declaracion.setImporte(rs.getString("IMPDEC"));
                declaracion.setProyecto(rs.getString("PRODEC"));
                declaracion.setCentrodecosto(rs.getString("CENDEC"));
                declaracion.setNomper(rs.getString("NOMPER"));
                declaracion.setDni(rs.getString("DNIDEC"));
                declaracion.setDomicilio(rs.getString("DOMDEC"));
                declaracion.setGastado(rs.getString("GASDEC"));
                declaracion.setMotivo(rs.getString("MOTDEC"));
                declaracion.setFecha(rs.getDate("FECDEC"));
                listadoDec.add(declaracion);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en listarTodosImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listadoDec;
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
            return rs.getString("APEPER");
        } catch (Exception e) {
            System.out.println("Error en obtenerNomper " + e.getMessage());
            throw e;
        }
    }

}
