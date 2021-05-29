package DP.Interface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author alang
 */
public interface IPropertiesDB {
    String getRaiz();
    String getConexion();
    String getDB();
            
    //CRUD alimento
    String getInsertAlimento();
    String getModificarAlimento();
    String getConsultarAlimento();
    String getEliminarAlimento();
    
    //CRUD citamedica
    String getInsertCitaMedica();
    String getModificarCitaMedica();
    String getConsultarCitaMedica();
    String getEliminarCitaMedica();
    
    //CRUD ejercicio
    String getInsertEjercicio();
    String getModificarEjercicio();
    String getConsultarEjercicio();
    String getEliminarEjercicio();
    
    //CRUD imc
    String getInsertIMC();
    String getModificarIMC();
    String getConsultarIMC();
    String getEliminarIMC();
    
    //CRUD medico
    String getInsertMedico();
    String getModificarMedico();
    String getConsultarMedico();
    String getEliminarMedico();
    
    //CRUD paciente
    String getInsertPaciente();
    String getModificarPaciente();
    String getConsultarPaciente();
    String getEliminarPaciente();
    
    //CRUD plannutricion
    String getInsertPlanNutricion();
    String getModificarPlanNutricion();
    String getConsultarPlanNutricion();
    String getEliminarPlanNutricion();
    
    //CRUD rutina
    String getInsertRutina();
    String getModificarRutina();
    String getConsultarRutina();
    String getEliminarRutina();   
}
