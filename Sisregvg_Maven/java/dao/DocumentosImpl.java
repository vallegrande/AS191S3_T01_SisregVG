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

import modelo.Documentos;

public class DocumentosImpl extends Conexion implements ICRUD<Documentos> {

    DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToFecha(String fecha) throws ParseException {
        return fecha != null ? new SimpleDateFormat("dd-MM-yyyy").parse(fecha) : null;
    }

    @Override
    public void registrar(Documentos documento) throws Exception {
        String sql = "insert into DOCUMENTOS (IMPDOC,FECDOC,ASUDOC,ESTDOC) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, documento.getImporte());
            ps.setString(2, formato.format(documento.getFecha()));
            ps.setString(3, documento.getAsunto());
            ps.setString(4, "E");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar DocumentosImpl " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Documentos documento) throws Exception {
        String sql = "update DOCUMENTOS set IMPDOC=?, FECDOC=?,ASUDOC=?,ESTDOC=? where IDDOC=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, documento.getImporte());
            ps.setString(2, formato.format(documento.getFecha()));
            ps.setString(3, documento.getAsunto());
            ps.setString(4, "E");
            ps.setInt(5, documento.getId());
            ps.executeUpdate();
            ps.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al ModificarImpl: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Documentos documento) throws Exception {
        String sql = "delete from DOCUMENTOS where IDDOC=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, documento.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    public void DeleteEstado(Documentos documento) throws Exception {
        String sql = "update DOCUMENTOS set ESTDOC=? where IDDOC=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, documento.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en EliminarEstadoD " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List listarTodos() throws Exception {
        List<Documentos> listado = null;
        Documentos documento;
        String sql = "select * from DOCUMENTOS  where ESTDOC='E' order by IDDOC desc";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                documento = new Documentos();
                documento.setId(rs.getInt("IDDOC"));
                documento.setImporte(rs.getString("IMPDOC"));
                documento.setFecha(rs.getDate("FECDOC"));
                documento.setAsunto(rs.getString("ASUDOC"));
                listado.add(documento);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en listarTodosImpl:" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

}
