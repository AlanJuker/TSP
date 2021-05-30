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
public class RutinaMD {
    IPropertiesDB _properties;
    //CONSTRUCTOR
    public RutinaMD(IPropertiesDB properties){
        _properties = properties;
    }
    //METODO INSERTAR
    public boolean insertar(Modelos.ModeloRutina rutina){
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p = _properties.getInsertRutina() +"('"+rutina.codigo +"','"+rutina.idcita+"')";
        return datosDB.CUD(sq10p);
    }
    public boolean modificar(Modelos.ModeloRutina rutina){
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p ="instruccion prueba";
        return datosDB.CUD(sq10p);
    }
    public boolean eliminar(Modelos.ModeloRutina paciente){
        ManejoDeDatosDB datosDB =new ManejoDeDatosDB(_properties);
        String sq10p = "instruccion prueba";
        return datosDB.CUD(sq10p);
    }
   
    
    
}
