package dao;

//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Personal;
import modelo.ValeProvisional;

public class PersonaImpl extends Conexion implements ICRUD<Personal> {

    @Override
    public void registrar(Personal per) throws Exception {

        String sql = "insert into PERSONAL (NOMPER,APEPER,DNIPER,CELPER,EMAPER,DOMPER, SEXPER,CARPER, ESTPER) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getDni());
            ps.setString(4, per.getCelular());
            ps.setString(5, per.getEmail());
            ps.setString(6, per.getDomper());
            ps.setString(7, per.getSexo());
            ps.setString(8, per.getCargo());
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
    public void modificar(Personal per) throws Exception {
        String sql = "update PERSONAL set NOMPER=?, APEPER=?,DNIPER=?,CELPER=?,EMAPER=?,DOMPER=?,SEXPER=?,CARPER=?, ESTPER=? where IDPER=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getDni());
            ps.setString(4, per.getCelular());
            ps.setString(5, per.getEmail());
            ps.setString(6, per.getDomper());
            ps.setString(7, per.getSexo());
            ps.setString(8, per.getCargo());
            ps.setString(9, "A");
            ps.setInt(10, per.getIdper());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar PersonaD: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Personal per) throws Exception {
        String sql = "delete from PERSONAL where IDPER=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, per.getIdper());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarD" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    public void DeleteEstado(Personal per) throws Exception {
        String sql = "update Personal set ESTPER=? where IDPER=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, per.getIdper());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en EliminarEstadoD " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    public List listarTodos(int tipo) throws Exception {
        List<Personal> listadoPer = null;
        Personal pers;
        String sql = "";

        switch (tipo) {
            case 1:
                sql = "SELECT * FROM vPersonalA";
                break;
            case 2:
                sql = "SELECT * FROM vPersonalI";
                break;
            case 3:
                sql = "SELECT * FROM vPersonalT";
                break;
        }
        try {
            listadoPer = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pers = new Personal();
                pers.setIdper(rs.getInt("IDPER"));
                pers.setNombre(rs.getString("NOMPER"));
                pers.setApellido(rs.getString("APEPER"));
                pers.setDni(rs.getString("DNIPER"));
                pers.setCelular(rs.getString("CELPER"));
                pers.setEmail(rs.getString("EMAPER"));
                pers.setDomper(rs.getString("DOMPER"));
                pers.setSexo(rs.getString("SEXPER"));
                pers.setCargo(rs.getString("CARPER"));
                listadoPer.add(pers);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en listarTodosD:" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listadoPer;
    }

    public boolean existe(Personal personal, List<Personal> listaPersonal) {
        for (Personal per : listaPersonal) {
            if (personal.getDni().equals(per.getDni())) {
                return true;
            }
        }
        return false;
    }

    public List<Personal> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
