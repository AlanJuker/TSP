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
    //CONSTRUCTOR
    public PacienteMD() {
    }
     //METODO INSERTAR
    public boolean insertar(Modelos.ModeloPaciente paciente) {
        //OBTENEMOS LA DIRECCION DEL PROGRAMA
        String raiz = System.getProperty("user.dir");
        try {
            //OBTENEMOS LOS VALORES DEL PROPERTIES
            Properties p = new Properties();
            FileReader f = new FileReader("src\\CONEXION.properties");
            p.load(f);
            //REALIZAMOS LA CONEXION CON LA BASE DE DATOS
            String conexion = p.getProperty("conexion");
            String db = p.getProperty("db");
            String insertPaciente = p.getProperty("insertPaciente");
            Connection con;
            con = DriverManager.getConnection(conexion + raiz + db);
            Statement st = con.createStatement();
            //REALIZAMOS LA INSERCION DE LOS DATOS
            int res = st.executeUpdate(insertPaciente+"('" + paciente.id + "','" + paciente.nombre
                    + "','" + paciente.genero + "','" + paciente.usuario + "','" + paciente.contrasenia + "','"
                    + paciente.altura + "','" + paciente.peso + "','" + paciente.edad + "')");
            //VALIDAMOS QUE LOS DATOS SE INGRESEN DE FORMA CORRECTA
            if (res == 1) {
                return true;
            }
            //CERRAMOS EL STATEMENT Y LA CONEXION
            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return false;
    }
}
