/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.PacienteMD;


/**
 *
 * @author alang
 */
public class Paciente {

    public Paciente(){
    }
    
    public boolean verificarDP(Modelos.ModeloPaciente paciente) {
        if(paciente.id.length() ==10){
            return true;
        }
        return false;
    }

    public boolean grabarDP(Modelos.ModeloPaciente paciente) {
       MD.PacienteMD pacienteMD = new PacienteMD();
        return pacienteMD.insertar(paciente);
    }
}
