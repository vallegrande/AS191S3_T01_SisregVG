package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.DocumentosM;


public class DocumentosD extends Conexion implements ICRUD<DocumentosM> {

    @Override
    public void registrar(DocumentosM documento) throws Exception {
    
        String sql = "insert into DOCUMENTOS (IMPODOC,FECDOC,ASUDOC,ESTDOC) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql); 
            ps.setDouble(1,documento.getImporte());
           SimpleDateFormat forma = new SimpleDateFormat("MM/dd/yyyy");
            ps.setString(2, forma.format(documento.getFecha()));        
            ps.setString(3, documento.getAsunto());
            ps.setString(4, documento.getEstado());
            ps.setString(5, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Documentos Dao " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(DocumentosM documento) throws Exception {
        String sql = "update DOCUMENTOS set IMPDOC=?, FECDOC=?,ASUDOC=?,ESTDOC=? where IDDOC=? ";
        try {
         PreparedStatement ps = this.conectar().prepareStatement(sql); 
            ps.setDouble(1,documento.getImporte());
           SimpleDateFormat forma = new SimpleDateFormat("MM/dd/yyyy");
            ps.setString(2, forma.format(documento.getFecha()));        
            ps.setString(3, documento.getAsunto());
            ps.setString(4, documento.getEstado());
            ps.setInt(5, documento.getId());
            ps.setString(6, "A");
            ps.executeUpdate();
            ps.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar DocumentosD: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(DocumentosM documento) throws Exception {
        String sql = "delete from DOCUMENTOS where IDDOC=?";
         try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);             
            ps.setInt(1, documento.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarD" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }


    @Override
    public List listarTodos() throws Exception {
        List<DocumentosM> listado = null;
        DocumentosM documento;
        String sql = "select * from DOCUMENTOS";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                documento = new DocumentosM();
                documento.setId(rs.getInt("IDDOC"));
                documento.setImporte(rs.getDouble("IMPDOC"));
                documento.setFecha(rs.getDate("FECDOC"));
                documento.setAsunto(rs.getString("ASUDOC"));
                listado.add(documento);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en listarTodosD:" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

}