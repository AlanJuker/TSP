/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author alang
 */
public class PacienteMD {
        
           
        
        

    // Metodos:
    public void insertar() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
         Properties p = new Properties();
  
         FileReader f = new FileReader("src\\CONEXION.properties");
         p.load(f);
        
        String conexion = p.getProperty("is_conexion");
        String user = p.getProperty("is_usuario");
        String password = p.getProperty("is_password");
        String driver = p.getProperty("com.mysql.jdbc.Driver; ");
        
        
            Class.forName(driver);
        Connection con = (Connection) DriverManager.getConnection(conexion, user, password);
        
        PreparedStatemnt pps;
        pps = (PreparedStatemnt) con.prepareStatement ("INSERT INTO paciente(ID_PACIENTE, NOMBRE_PACIENTE, GENERO_PACIENTE, USUARIO_PACIENTE, CONTRASENIA_PACIENTE, ALTURA, PESO, EDAD) VALUES(?,?,?,?,?,?,?,?)");
         
        pps.setString(1,"456789");
        pps.executeUpdate();
        
        
    }
}
