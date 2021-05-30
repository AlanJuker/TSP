/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;
import DP.Interface.IPropertiesDB;
import Modelos.ModeloCitaMedica;
import Modelos.ModeloMedico;
import Modelos.ModeloPaciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
/**
 *
 * @author alang
 */
public class CitaMedicaMD {
    IPropertiesDB _properties;
    //CONSTRUCTOR
    public CitaMedicaMD(IPropertiesDB properties){
        _properties = properties;
    }
    //METODO INSERTAR
    public boolean insertar (Modelos.ModeloCitaMedica citaMedica){
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p = _properties.getInsertCitaMedica()+"('"+citaMedica.idCita+"','"+citaMedica.idMedico+"','"+citaMedica.idPaciente+"','"+citaMedica.fecha+"','"+citaMedica.comentario+"')";
        return datosDB.CUD(sq10p);
    }   
    public boolean modificar(String idcita, String id_medico, String id_paciente, String fecha, String comentario){
        boolean inserta = false;
        String sq10p = _properties.getModificarCitaMedica() + " id_medico=?,id_paciente=?,fecha=?,comentarios=?"+" WHERE idcita=?";
        String raiz =_properties.getRaiz();
        String conexion =_properties.getConexion();
        String db =_properties.getDB();
        
        try {
            Connection con = DriverManager.getConnection(conexion + raiz+db);
            Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sq10p);
            pst.setString(1, id_medico);
            pst.setString(2, id_paciente);
            pst.setString(3, fecha);
            pst.setString(4, comentario);
            
            inserta=(pst.executeUpdate()==1);
            
            con.close();
            pst.close();

        } catch (Exception e) {
        }
        finally{
            
        }
        return inserta;
    }
    public boolean eliminar(String id){
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p = _properties.getEliminarCitaMedica()+"'"+id+"'";
        return datosDB.CUD(sq10p);
    }
    public ArrayList<ModeloCitaMedica> consultaGeneral(){
        ArrayList<ModeloCitaMedica> citaMedicas = new ArrayList<ModeloCitaMedica>();
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p=_properties.getConsultarCitaMedica();
        ResultSet ResultSet = datosDB.Consultar(sq10p);
        try{
            while(ResultSet.next()){
                ModeloCitaMedica citaMedica = new ModeloCitaMedica();
                citaMedica.idCita=ResultSet.getString("idcita");
                citaMedica.idMedico=ResultSet.getString("id_medico");
                citaMedica.idPaciente=ResultSet.getString("id_paciente");
                citaMedica.fecha=ResultSet.getString("fecha");
                citaMedica.comentario=ResultSet.getString("comentarios");
                citaMedicas.add(citaMedica);
            }
        }
        catch(Exception e){
            
        }
        return citaMedicas;
    }
    public ModeloCitaMedica consultaParametro(String id){
        ManejoDeDatosDB datosDB= new ManejoDeDatosDB(_properties);
        String sq10p=_properties.getConsultarCitaMedica()+ " WHERE idcita = '" + id +"'";
        ResultSet ResultSet = datosDB.Consultar(sq10p);
        ModeloCitaMedica citaMedica = new ModeloCitaMedica();
        try{
            ResultSet.next();
            citaMedica.idCita=ResultSet.getString("idcita");
            citaMedica.idMedico=ResultSet.getString("id_medico");
            citaMedica.idPaciente=ResultSet.getString("id_paciente");
            citaMedica.fecha=ResultSet.getString("fecha");
            citaMedica.comentario=ResultSet.getString("comentarios");
        }
        catch(Exception e){
            
        }
        return citaMedica;
    }
    public ArrayList<ModeloMedico> consultaMedico(){
        ArrayList<ModeloMedico> citaMedicas = new ArrayList<ModeloMedico>();
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p=_properties.getConsultarMedico();
        ResultSet ResultSet = datosDB.Consultar(sq10p);
        try{
            while(ResultSet.next()){
                ModeloMedico citaMedica = new ModeloMedico();
                citaMedica.id=ResultSet.getString("id_medico");
                citaMedicas.add(citaMedica);
                
            }
        }
        catch(Exception e){
            
        }
        return citaMedicas;
    }
    public ArrayList<ModeloPaciente> consultaPaciente(){
        ArrayList<ModeloPaciente> citaMedicas = new ArrayList<ModeloPaciente>();
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p=_properties.getConsultarPaciente();
        ResultSet ResultSet = datosDB.Consultar(sq10p);
        try{
            while(ResultSet.next()){
                ModeloPaciente citaMedica = new ModeloPaciente();
                citaMedica.id=ResultSet.getString("id_paciente");
                citaMedicas.add(citaMedica);
                
            }
        }
        catch(Exception e){
            
        }
        return citaMedicas;
    }
   
}
