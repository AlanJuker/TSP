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

    public boolean modificarMD(String id, String Nnombre, char Ngenero, String Nusuario, String Ncontrasenia, double Naltura, double Npeso, int Nedad) {
        PacienteMD pacienteMD = new PacienteMD(new PropertiesDB());
        return pacienteMD.modificar(id, Nnombre, Ngenero, Nusuario, Ncontrasenia, Naltura, Npeso, Nedad);
    }

    public ArrayList<ModeloPaciente> consultarDP() {
        PacienteMD pacienteMD = new PacienteMD(new PropertiesDB());
        return pacienteMD.consultaGeneral();
    }

    public ModeloPaciente consultarParametroDP(String id) {
        PacienteMD pacienteMD = new PacienteMD(new PropertiesDB());
        return pacienteMD.consultaParametro(id);
    }

    public boolean eliminarDP(String id) {
        PacienteMD pacienteMD = new PacienteMD(new PropertiesDB());
        return pacienteMD.eliminar(id);
    }
}
