/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.Interface;

import DP.Interface.IPropertiesDB;
import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author alang
 */
public class PropertiesDB implements IPropertiesDB {

    private Properties _properties;
    private FileReader _FileReader;

    public PropertiesDB() {
        _properties = new Properties();
        try {
            _FileReader = new FileReader("src\\CONEXION.properties");
            _properties.load(_FileReader);

        } catch (Exception e) {
        }
    }
    
    @Override
    public String getRaiz() {
        return System.getProperty("user.dir");
    }

    @Override
    public String getConexion() {
        return _properties.getProperty("conexion");
    }

    @Override
    public String getDB() {
        return _properties.getProperty("db");
    }

    @Override
    public String getInsertPaciente(){
        return _properties.getProperty("insertPaciente");
    }

}
