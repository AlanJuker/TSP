/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import DP.Interface.PropertiesDB;
import MD.AlimentoMD;
import Modelos.ModeloAlimento;
import java.util.ArrayList;

/**
 *
 * @author alang
 */
public class Alimento {

    public Alimento() {
    }

    //GRABARDP
    public boolean grabarDP(ModeloAlimento alimento) {
        AlimentoMD alimentoMD = new AlimentoMD(new PropertiesDB());

        return alimentoMD.insertar(alimento);
    }

    public boolean modificarDP(String codigo_alimento, String nombre_alimento, String tipo_alimento, double cantidad, String unidadmedida) {
        AlimentoMD alimentoMD = new AlimentoMD(new PropertiesDB());
        return alimentoMD.modificar(codigo_alimento, nombre_alimento, tipo_alimento, cantidad, unidadmedida);
    }

     public boolean eliminarDP(String codigo_alimento) {
        AlimentoMD alimentoMD = new AlimentoMD(new PropertiesDB());
        return alimentoMD.eliminar(codigo_alimento);
    }
    

    public ArrayList<ModeloAlimento> consultarDP() {
        AlimentoMD alimentoMD = new AlimentoMD(new PropertiesDB());
        return alimentoMD.consultaGeneral();
    }

    public ModeloAlimento consultarParametroDP(String codigo_alimento) {
         AlimentoMD alimentoMD = new AlimentoMD(new PropertiesDB());
        return alimentoMD.consultaParametro(codigo_alimento);
    }
   
}
