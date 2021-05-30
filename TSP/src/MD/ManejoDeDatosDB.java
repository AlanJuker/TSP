/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.Interface.IPropertiesDB;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author alang
 */
public class ManejoDeDatosDB {

    Statement _st;
    IPropertiesDB _properties;
    Connection con;
    PreparedStatement pst;

    public ManejoDeDatosDB(IPropertiesDB properties) {
        _properties = properties;
    }

    private void abrirConexion() {
        String raiz = _properties.getRaiz();
        String conexion = _properties.getConexion();
        String db = _properties.getDB();
        try {
            con = DriverManager.getConnection(conexion + raiz + db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDBStatement() {
        try {
            _st = con.createStatement();
        } catch (Exception e) {
            cerrarConexion();
        }
    }

    private void cerrarConexion() {
        try {
            _st.close();
            con.close();
        } catch (Exception e) {

        }
    }

    public boolean CUD(String sqlOp) {
        abrirConexion();
        getDBStatement();
        boolean inserta = false;
        try {
            inserta = (_st.executeUpdate(sqlOp) == 1);
        } catch (Exception e) {

        } finally {
            cerrarConexion();
        }
        return inserta;
    }


    public ResultSet Consultar(String sqlOp) {
        abrirConexion();
        getDBStatement();
        ResultSet rs = null;
        boolean inserta = false;
        try {
            rs = _st.executeQuery(sqlOp);
        } catch (Exception e) {

        } finally {
            cerrarConexion();
        }
        return rs;
    }

}
