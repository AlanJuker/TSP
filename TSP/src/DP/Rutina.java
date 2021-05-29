/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;
import MD.RutinaMD;
/**
 *
 * @author alang
 */
public class Rutina {
    //CONSTRUCTOR
    public Rutina(){
        
    }
    //VERIFICARDP
//    public boolean verificarDP(Modelos.ModeloRutina rutina){
//        if(rutina.codigo.length()==4){
//            return true;
//        }
//        return false;
//    }
    //GRABARDP
    public boolean grabarDP(Modelos.ModeloRutina rutina){
        MD.RutinaMD rutinaMD= new RutinaMD();
        return rutinaMD.insertar(rutina);
    }
    
}
