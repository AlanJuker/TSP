/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author alang
 */
public class RutinaMD {
    //CONSTRUCTOR
    public RutinaMD(){
        
    }
    //METODO INSERTAR
    public boolean insertar(Modelos.ModeloRutina rutina){
        //OBTENEMOS LA DIRECCION DEL PROGRAMA
        String raiz= System.getProperty("user.dir");
        try{
            //OBTENEMOS LA DIRECCION DEL PROPERTIES
            Properties p = new Properties();
            FileReader f = new FileReader("src\\CONEXION.properties");
            p.load(f);
            //OBTENEMOS LOS VALORES DEL PROPERTIES
            String conexion = p.getProperty("conexion");
            String db = p.getProperty("db");
            String insertRutina = p.getProperty("insertRutina");
            //REALIZAMOS LA CONEXION CON LA BASE DE DATOS
            Connection con;
            con = DriverManager.getConnection(conexion + raiz + db);
            Statement st = con.createStatement();
            //REALIZAMOS LA INSERCION DE LOS DATOS
//            int res = st.executeUpdate(insertRutina+"('"+rutina.codigo+"'.'"+rutina.rutina+"')");
            //VALIDAMOS QUE LOS DATOS SE INGRESEN DE FORMA CORRECTA
//            if(res==1){
//                return true;
//            }
            //CERRAMOS EL STATEMENT Y LA CONEXION
            st.close();
            con.close();
        }
        catch(Exception e){
            
        }
        return false;
    }
    
}
