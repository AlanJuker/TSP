/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;
import DP.Interface.PropertiesDB;
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
    public boolean veridicarDP(Modelos.ModeloRutina rutina){
        return rutina.idcita.length()==4;
    }
    //GRABARDP
    public boolean grabarDP(Modelos.ModeloRutina rutina){
        MD.RutinaMD rutinaMD= new RutinaMD(new PropertiesDB());
        return rutinaMD.insertar(rutina);
    }
    
}
