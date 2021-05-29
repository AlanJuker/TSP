/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alang
 */
public class PacienteMD {

    public PacienteMD() {
    }

    // Metodos:
    public boolean insertar(Modelos.ModeloPaciente paciente) {
        String raiz = System.getProperty("user.dir");

        try {

            Properties p = new Properties();
            FileReader f = new FileReader("src\\CONEXION.properties");
            p.load(f);

            String conexion = p.getProperty("conexion");
            String db = p.getProperty("db");
            String insertPaciente = p.getProperty("insertPaciente");

            Connection con;
            con = DriverManager.getConnection(conexion + raiz + db);
            Statement st = con.createStatement();

            int res = st.executeUpdate(insertPaciente+"('" + paciente.id + "','" + paciente.nombre
                    + "','" + paciente.genero + "','" + paciente.usuario + "','" + paciente.contrasenia + "','"
                    + paciente.altura + "','" + paciente.peso + "','" + paciente.edad + "')");

            if (res == 1) {
                return true;
            }

            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return false;
    }
}
