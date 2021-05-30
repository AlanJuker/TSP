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

    //CRUD alimento
    @Override
    public String getInsertAlimento() {
        return _properties.getProperty("insertAlimento");
    }
    @Override
    public String getModificarAlimento() {
        return _properties.getProperty("modificarAlimento");
    }
    @Override
    public String getConsultarAlimento() {
        return _properties.getProperty("consultarAlimento");
    }
    @Override
    public String getEliminarAlimento() {
        return _properties.getProperty("eliminarAlimento");
    }

    //CRUD citamedica
    @Override
    public String getInsertCitaMedica() {
        return _properties.getProperty("insertarCitaMedica");
    }
    @Override
    public String getModificarCitaMedica() {
        return _properties.getProperty("modificarCitaMedica");
    }
    @Override
    public String getConsultarCitaMedica() {
        return _properties.getProperty("consultarCitaMedica");
    }
    @Override
    public String getEliminarCitaMedica() {
        return _properties.getProperty("eliminarCitaMedica");
    }
    
    //CRUD ejercicio
    @Override
    public String getInsertEjercicio() {
        return _properties.getProperty("insertEjercicio");
    }
    @Override
    public String getModificarEjercicio() {
        return _properties.getProperty("modificarEjercicio");
    }
    @Override
    public String getConsultarEjercicio() {
        return _properties.getProperty("consultarEjercicio");
    }
    @Override
    public String getEliminarEjercicio() {
        return _properties.getProperty("eliminarEjercicio");
    }
    
    //CRUD imc
    @Override
    public String getInsertIMC() {
        return _properties.getProperty("insertarIMC");
    }
    @Override
    public String getModificarIMC() {
        return _properties.getProperty("modificarIMC");
    }
    @Override
    public String getConsultarIMC() {
        return _properties.getProperty("consultarIMC");
    }
    @Override
    public String getEliminarIMC() {
        return _properties.getProperty("eliminarIMC");
    }

    //CRUD medica
    
    @Override
    public String getInsertMedico() {
        return _properties.getProperty("insertarMedico");
    }
    @Override
    public String getModificarMedico() {
        return _properties.getProperty("modificarMedico");
    }
    @Override
    public String getConsultarMedico() {
        return _properties.getProperty("consultarMedico");
    }
    @Override
    public String getEliminarMedico() {
        return _properties.getProperty("eliminarMedico");
    }
    
    //CRUD paciente

    @Override
    public String getInsertPaciente() {
        return _properties.getProperty("insertPaciente");
    }
    @Override
    public String getModificarPaciente() {
        return _properties.getProperty("modificarPaciente");
    }
    @Override
    public String getConsultarPaciente() {
        return _properties.getProperty("consultarPaciente");
    }
    @Override
    public String getEliminarPaciente() {
        return _properties.getProperty("eliminarPaciente");
    }
    
    //CRUD plannutricion

    @Override
    public String getInsertPlanNutricion() {
        return _properties.getProperty("InsertarPlanNutricion");
    }
    @Override
    public String getModificarPlanNutricion() {
        return _properties.getProperty("modificarPlanNutricion");
    }
    @Override
    public String getConsultarPlanNutricion() {
        return _properties.getProperty("consultarPlanNutricion");
    }
    @Override
    public String getEliminarPlanNutricion() {
        return _properties.getProperty("eliminarPlanNutricion");
    }

    //CRUD rutina
    
    @Override
    public String getInsertRutina() {
        return _properties.getProperty("insertRutina");
    }
    @Override
    public String getModificarRutina() {
        return _properties.getProperty("modificarRutina");
    }
    @Override
    public String getConsultarRutina() {
        return _properties.getProperty("consultarRutina");
    }
    @Override
    public String getEliminarRutina() {
        return _properties.getProperty("eliminarRutina");
    }
}
