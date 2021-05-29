/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author alang
 */
public class PacienteMD {

    public PacienteMD() {
    }

    // Metodos:
    public static void insertar() throws FileNotFoundException {
        Properties p = new Properties();    

        try {
            FileReader f = new FileReader("src\\CONEXION.properties");
            p.load(f);
            String conexion = p.getProperty("conexion");
            String usuario = p.getProperty("usuario");
            String clave = p.getProperty("clave");
            String driver = p.getProperty("driver");
            
            Connection con = (Connection) DriverManager.getConnection(conexion, usuario, clave);
            String id = "123", nombre = "isaac";

            String queryDe = "DELETE FROM paciente WHERE ID_PACIENTE ='" + id + "'";
            String query = "INSERT INTO paciente (ID_PACIENTE,NOMBRE_PACIENTE) VALUES('" + id + "','" + nombre + "')";
            String queryConsulta = "SELECT * FROM paciente WHERE ID_PACIENTE='" + id + "'";
            String queryUpdate = "UPDATE paciente SET ID_PACIENTE ='" + id + "'";

            Statement pps = con.createStatement();
            pps.executeUpdate(query);

        } catch (Exception e) {

        }
    }
}
