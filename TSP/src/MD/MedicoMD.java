/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.Interface.IPropertiesDB;
import Modelos.ModeloMedico;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alang
 */
public class MedicoMD {
     IPropertiesDB _properties;

    //CONSTRUCTOR
    public MedicoMD(IPropertiesDB properties) {
        _properties = properties;
    }
    //METODO INSERTAR
    public boolean insertar(ModeloMedico medico) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = _properties.getInsertMedico() + "('" + medico.id + "','" + medico.nombre
                + "','" + medico.genero + "','" + medico.usuario + "','" + medico.contrasenia + "','"
                + medico.especialidad + "','" + medico.departamento + "')";

        return datosDB.CUD(sqlOp);
    }

    public boolean modificar(ModeloMedico medico) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        System.out.println("ENTRO AL PUTO MODIFICAR");
        String sqlOp = _properties.getModificarMedico()+" nombre_medico = '"+medico.nombre+"',genero_medico = '"+medico.genero+"',usuario_medico = '"+medico.usuario+"',contrasenia_medico = '"+medico.contrasenia+"',especialidad = '"+medico.especialidad+"',departamento = '"+medico.departamento+"'"
                + " WHERE id_medico = '"+medico.id+"'";
        return datosDB.CUD(sqlOp);
    }

    public boolean eliminar(String id) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);        
        String sqlOp = _properties.getEliminarMedico()+"'"+ id +"'";        
        return datosDB.CUD(sqlOp);
    }
    
    public ArrayList<ModeloMedico> consultaGeneral() {
        ArrayList<ModeloMedico> medicos = new ArrayList<ModeloMedico>();
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = _properties.getConsultarMedico();
        System.out.println(sqlOp);
        ResultSet ResultSet = datosDB.Consultar(sqlOp);
        try {
            while (ResultSet.next()) {
                
                ModeloMedico medico = new ModeloMedico();
                medico.id = ResultSet.getString("id_medico");
                medico.nombre = ResultSet.getString("nombre_medico");
                medico.genero = ResultSet.getString("genero_medico").toCharArray()[0];
                medico.usuario = ResultSet.getString("usuario_medico");
                medico.contrasenia = ResultSet.getString("contrasenia_medico");
                medico.especialidad = ResultSet.getString("especialidad");
                medico.departamento = ResultSet.getString("departamento");
               System.out.println("MEDICO: "+medico.id+" "+medico.nombre+" "+medico.genero);
                medicos.add(medico);
            }
        } catch (Exception e) {

        }
        return medicos;
    }
    public ModeloMedico consultaParametro(String id) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sqlOp = _properties.getConsultarMedico()+ " WHERE id_medico = '" +id+ "'";
        System.out.println(sqlOp);
        ResultSet ResultSet = datosDB.Consultar(sqlOp);
        ModeloMedico medico = new ModeloMedico();
         
          try{
                ResultSet.next();
                medico.id = ResultSet.getString("id_medico");
                System.out.println("entro2");
                medico.nombre = ResultSet.getString("nombre_medico");
                medico.genero = ResultSet.getString("genero_medico").toCharArray()[0];
                medico.usuario = ResultSet.getString("usuario_medico");
                medico.contrasenia = ResultSet.getString("contrasenia_medico");
                medico.especialidad = ResultSet.getString("especialidad");
                medico.departamento = ResultSet.getString("departamento");
                 
          }catch(Exception e){
              
          }
          System.out.println("MEDICO: "+medico.id+" "+medico.nombre+" "+medico.genero);     
        return medico;
    }
}