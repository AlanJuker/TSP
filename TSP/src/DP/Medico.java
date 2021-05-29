/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.MedicoMD;

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
       MD.MedicoMD medicoMD = new MedicoMD();
        return medicoMD.insertar(medico);
    }
}
