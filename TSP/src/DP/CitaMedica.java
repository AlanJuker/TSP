/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;
import DP.Interface.PropertiesDB;
import MD.CitaMedicaMD;
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
        MD.CitaMedicaMD citaMedicaMD = new CitaMedicaMD(new PropertiesDB());
        return citaMedicaMD.modificar(citaMedica);
    }
}
