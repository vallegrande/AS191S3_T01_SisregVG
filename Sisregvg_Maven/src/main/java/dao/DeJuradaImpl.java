package dao;

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

    @Override
    public void registrar(DeJurada declaracion) throws Exception {

        String sql = "insert into DeclaracionJurada (IMPDEC,PRODEC,CENDEC,DOMDEC,GASDEC,MOTDEC,FECDEC,IDPER,ESTDEC) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, declaracion.getImporte());
            ps.setString(2, declaracion.getProyecto());
            ps.setString(3, declaracion.getCentrodecosto());
            ps.setString(4, declaracion.getDomicilio());
            ps.setString(5, declaracion.getGastado());
            ps.setString(6, declaracion.getMotivo());
            ps.setDate(7, declaracion.getFecha());
            ps.setInt(8, declaracion.getIdper());
           ps.setString(9, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Persona Dao " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(DeJurada declaracion) throws Exception {
        String sql = "update DeclaracionJurada set IMPDEC=?, PRODEC=?,CENDEC=?,DOMDEC=?,GASDEC=?,MOTDEC=?,FECDEC=?,ESTDEC=? IDPER=? where IDDEC=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, declaracion.getImporte());
            ps.setString(2, declaracion.getProyecto());
            ps.setString(3, declaracion.getCentrodecosto());
            ps.setString(4, declaracion.getDomicilio());
            ps.setString(5, declaracion.getGastado());
            ps.setString(6, declaracion.getMotivo());
            ps.setDate(7, declaracion.getFecha());
            ps.setInt(8, declaracion.getIdper());
            ps.setString(9, "A");
            ps.setInt(10, declaracion.getId());
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
        String sql = "select * from DeclaracionJurada";
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
                declaracion.setDomicilio(rs.getString("DOMDEC"));
                declaracion.setGastado(rs.getString("GASDEC"));
                declaracion.setMotivo(rs.getString("MOTDEC"));
                declaracion.setFecha(rs.getDate("FECDEC"));
                declaracion.setIdper(rs.getInt("IDPER"));
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

}
