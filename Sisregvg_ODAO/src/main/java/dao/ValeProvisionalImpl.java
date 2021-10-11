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
import modelo.ValeProvisional;

public class ValeProvisionalImpl extends Conexion implements ICRUD<ValeProvisional> {

    DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToFecha(String fecha) throws ParseException {
        return fecha != null ? new SimpleDateFormat("dd-MM-yyyy").parse(fecha) : null;
    }

    @Override
    public void registrar(ValeProvisional provisional) throws Exception {
        String sql = "insert into ValeProvisional(IMPVAL,FECVAL, CENVAL, PROVAL, ACTVAL, IDPER, ESTVAL) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setDouble(1, provisional.getImpval());
            ps.setString(2, formato.format(provisional.getFecval()));
            ps.setString(3, provisional.getCenval());
            ps.setString(4, provisional.getProval());
            ps.setString(5, provisional.getActval());
            ps.setInt(6, provisional.getPersonal().getIdper());
            ps.setString(7, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar ValeProvisionalImpl " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(ValeProvisional provisional) throws Exception {
        String sql = "update ValeProvisional set IMPVAL=?, FECVAL=?, CENVAL=?,PROVAL=?,ACTVAL=?,IDPER=?,ESTVAL=? where IDVAL=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setDouble(1, provisional.getImpval());
            ps.setString(2, formato.format(provisional.getFecval()));
            ps.setString(3, provisional.getCenval());
            ps.setString(4, provisional.getProval());
            ps.setString(5, provisional.getActval());
            ps.setString(6, provisional.getNomper());
            ps.setString(7, "A");
            ps.setInt(8, provisional.getIdval());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar ValeProvisionalImpl: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(ValeProvisional provisional) throws Exception {
        String sql = "delete from vValeProvisional1 where IDVAL=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, provisional.getIdval());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    public void DeleteEstado(ValeProvisional provisional) throws Exception {
        String sql = "update vValeProvisional1 set ESTVAL=? where IDVAL=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, provisional.getIdval());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en EliminarEstadoD " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }


    public List listarTodos(int tipo) throws Exception {
        List<ValeProvisional> listadoVal = null;
        ValeProvisional provisional;
        String sql = "";
        
        switch (tipo) {
            case 1:
                sql = "SELECT * FROM vValeProvisionalA";
                break;
            case 2:
                sql = "SELECT * FROM vValeProvisionalI";
                break;
            case 3:
                sql = "SELECT * FROM vValeProvisionalT";
                break;
        }   
        try {
            listadoVal = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                provisional = new ValeProvisional();
                provisional.setIdval(rs.getInt("IDVAL"));
                provisional.setImpval(rs.getDouble("IMPVAL"));
                provisional.setFecval(rs.getDate("FECVAL"));
                provisional.setCenval(rs.getString("CENVAL"));
                provisional.setProval(rs.getString("PROVAL"));
                provisional.setActval(rs.getString("ACTVAL"));
                provisional.setNomper(rs.getString("NOMPER"));
                listadoVal.add(provisional);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodosImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listadoVal;
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

    @Override
    public List<ValeProvisional> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
