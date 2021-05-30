/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;
import DP.Interface.PropertiesDB;
import MD.CitaMedicaMD;
import MD.MedicoMD;
import Modelos.ModeloCitaMedica;
import Modelos.ModeloMedico;
import Modelos.ModeloPaciente;
import java.util.ArrayList;
/**
 *
 * @author alang
 */
public class CitaMedica {
    //CONSTRUCTOR
    public CitaMedica(){
        
    }
    //VERIFICARDP
    public boolean verificarDP(Modelos.ModeloCitaMedica citaMedica){
        return citaMedica.idCita.length()==4;
    }
    //GRABARDP
    public boolean grabarDP(Modelos.ModeloCitaMedica citaMedica){
        CitaMedicaMD citaMedicaMD = new CitaMedicaMD(new PropertiesDB());
        return citaMedicaMD.insertar(citaMedica);
    }
    public boolean modificarMD(String idcita, String id_medico, String id_paciente, String fecha, String comentario){
        CitaMedicaMD citaMedicaMD = new CitaMedicaMD(new PropertiesDB());
        return citaMedicaMD.modificar(idcita, id_medico, id_paciente, fecha, comentario);
    }
    public ArrayList<ModeloCitaMedica> consultarDP(){
        CitaMedicaMD citaMedicaMD =new CitaMedicaMD(new PropertiesDB());
        return citaMedicaMD.consultaGeneral();
    }
    public ModeloCitaMedica consultaParametroDP(String id){
        CitaMedicaMD citaMedicaMD =new CitaMedicaMD(new PropertiesDB());
        return citaMedicaMD.consultaParametro(id);
    }
    public boolean eliminarDP(String id){
        CitaMedicaMD citaMedicaMD =new CitaMedicaMD(new PropertiesDB());
        return citaMedicaMD.eliminar(id);
    }
    public ArrayList<ModeloMedico> obtenerMedico(){
        CitaMedicaMD MedicoMD =new CitaMedicaMD(new PropertiesDB());
        return MedicoMD.consultaMedico();
    }
    public ArrayList<ModeloPaciente> obtenerPaciente(){
        CitaMedicaMD PacienteMD =new CitaMedicaMD(new PropertiesDB());
        return PacienteMD.consultaPaciente();
    }
    
}
