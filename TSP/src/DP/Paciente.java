/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import DP.Interface.PropertiesDB;
import MD.PacienteMD;
import Modelos.ModeloPaciente;
import java.util.ArrayList;

/**
 *
 * @author alang
 */
public class Paciente {

    //CONSTRUCTOR
    public Paciente() {
    }

    //VERIFICARDP
    public boolean verificarDP(Modelos.ModeloPaciente paciente) {
        return paciente.id.length() == 10;
    }

    //GRABARDP
    public boolean grabarDP(Modelos.ModeloPaciente paciente) {
        PacienteMD pacienteMD = new PacienteMD(new PropertiesDB());
        return pacienteMD.insertar(paciente);
    }

    public ArrayList<ModeloPaciente> consultarDP() {
        PacienteMD pacienteMD = new PacienteMD(new PropertiesDB());
        return pacienteMD.consultaGeneral();
    }
}