/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.sql.*;
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
            Connection con;
            con = DriverManager.getConnection("jdbc:ucanaccess://" + raiz + "\\BienestarPuce.accdb");
            Statement st = con.createStatement();

            int res = st.executeUpdate("insert into paciente values('" + paciente.id + "','" + paciente.nombre 
                    + "','" + paciente.genero + "','" + paciente.usuario+ "','" + paciente.contrasenia+ "','" + 
                    paciente.altura + "','" + paciente.peso + "','" + paciente.edad+ "')");

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
