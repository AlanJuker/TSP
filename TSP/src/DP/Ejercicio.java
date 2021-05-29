/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;
import MD.EjercicioMD;
/**
 *
 * @author alang
 */
public class Ejercicio {
    //CONSTRUCTOR
    public Ejercicio(){
        
    }
    //VERIFICARDP
    public boolean verificarDP(Modelos.ModeloEjercicio ejercicio){
        if(ejercicio.nombre.length() <= 20 && ejercicio.nombre.length()>=1){
            return true;
        }
        return false;
    }
    //GRABARDP
    public boolean grabarDP(Modelos.ModeloEjercicio ejercicio){
        MD.EjercicioMD ejercicioMD = new EjercicioMD();
        return ejercicioMD.insertar(ejercicio);
    }
}
