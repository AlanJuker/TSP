/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import DP.Interface.PropertiesDB;
import MD.MedicoMD;
import MD.MedicoMD;
import Modelos.ModeloMedico;
import java.util.ArrayList;

/**
 *
 * @author alang
 */
public class Medico {
    //CONSTRUCTOR
    public Medico(){
    }
    //VERIFICARDP
    public boolean verificarDP(Modelos.ModeloMedico medico) {
        if(medico.id.length() ==10){
            return true;
        }
        return false;
    }
    //GRABARDP
    public boolean grabarDP(Modelos.ModeloMedico medico) {
       MD.MedicoMD medicoMD = new MedicoMD(new PropertiesDB());
        return medicoMD.insertar(medico);
    }
    public ArrayList<ModeloMedico> consultarDP() {
        MedicoMD medicoMD = new MedicoMD(new PropertiesDB());
        return medicoMD.consultaGeneral();
    }
    public ModeloMedico consultarParametroDP(String id) {
        MedicoMD medicoMD = new MedicoMD(new PropertiesDB());
        return medicoMD.consultaParametro(id);
    }
    public boolean eliminarDP(String id) {
        MedicoMD medicoMD = new MedicoMD(new PropertiesDB());
        return medicoMD.eliminar(id);
    }
}
