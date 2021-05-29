/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.PacienteMD;
import com.sun.corba.se.impl.orbutil.graph.NodeData;

/**
 *
 * @author alang
 */
public class Paciente {

    public Paciente(){
    }
    
    public boolean verificarDP() {
        return false;
    }

    public boolean grabarDP(Modelos.ModeloPaciente paciente) {
       MD.PacienteMD pacienteMD = new PacienteMD();
        return pacienteMD.insertar(paciente);
    }
}
