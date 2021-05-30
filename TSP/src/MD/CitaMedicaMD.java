/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;
import DP.Interface.IPropertiesDB;
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
    public boolean modificar(Modelos.ModeloCitaMedica citaMedica){
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p = _properties.getModificarCitaMedica()+"idcita = C3PO, id_medico = p002, id_paciente = p002, fecha= 5/13/2021, comentario = hol WHERE idmedico = 'p002'";
        return datosDB.CUD(sq10p);
    }
    public boolean eliminar(Modelos.ModeloCitaMedica citaMedica){
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sq10p = _properties.getEliminarCitaMedica()+" = 'C3PO'";
        return datosDB.CUD(sq10p);
    }
}
