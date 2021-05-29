/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author alang
 */
public class MedicoMD {
    public MedicoMD(){
        
    }
    public boolean insertar(Modelos.ModeloMedico medico) {
        String raiz = System.getProperty("user.dir");

        try {

            Properties p = new Properties();
            FileReader f = new FileReader("src\\CONEXION.properties");
            p.load(f);

            String conexion = p.getProperty("conexion");
            String db = p.getProperty("db");
            String insertMedico = p.getProperty("insertMedico");
            
            Connection con;
            con = DriverManager.getConnection(conexion + raiz + db);
            Statement st = con.createStatement();
            
            int res = st.executeUpdate(insertMedico+"('" + medico.id + "','" + medico.nombre
                    + "','" + medico.genero + "','" + medico.usuario + "','" + medico.contrasenia + "','"
                    + medico.especialidad + "','" + medico.departamento +"')");
                    System.out.println("ENTRE PUTOS");
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
